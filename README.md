## Wotech indivitual tasks

 ### For [java](https://github.com/MargoZhubinska/Individual-work/tree/main/Java) :coffee:
 <details>
  <summary>The Tic-Tac-Toe medium code</summary>
  
 ```java
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        int size = 3;
        int[][] grid = new int [size][size];
        boolean win = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Tic-Tac-Toe!" + "\nWhere will you put 1 or 2?");
        
        printGrid(grid, size);
        
        while (!win) {
            System.out.println("Player 1 enter a row (number 1-3): ");
                int row = scanner.nextInt();
                row = row - 1;
                System.out.println("Player 1 enter a column (number 1-3): ");
                int column = scanner.nextInt();
                column = column - 1;
                
            if (row < 0 || row >= size || column < 0 || column >= size || grid[row][column] != 0) {
                System.out.println("Invalid move. Try again.");
                continue;
                        }
            grid[row][column] = 1;
            printGrid(grid,size);
            win = checkWinRow(grid,size) || checkWinCol(grid,size);
            
            if(win) {
                System.out.println("Congratulations!Player 1 you won!");
                break;
            }
            
            System.out.println("Player 2 enter a row (number 1-3): ");
                int row2 = scanner.nextInt();
                row2 = row2 - 1;
                System.out.println("Player 2 enter a column (number 1-3): ");
                int column2 = scanner.nextInt();
                column2 = column2 - 1;
                
            if (row2 < 0 || row2 >= size || column2 < 0 || column2 >= size || grid[row2][column2] != 0) {
                System.out.println("Invalid move. Try again.");
                continue;
                        }
            grid[row2][column2] = 2;
            printGrid(grid,size);
            
            win = checkWinRow(grid,size) || checkWinCol(grid,size);
            
            if(win) {
                System.out.println("Congratulations! Player 2 you won!");
                break;
            }
        }
        
        scanner.close();
            
    }   
  
    public static void printGrid (int[][] grid, int size){
        for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++){
                    System.out.print(grid[i][j] + " ");
                }
        System.out.println();
        }
    }
    
    
    public static boolean checkWinRow(int[][] grid, int size) {
        for(int i = 0; i < size; i++) {
            boolean rowWin = true;
            for(int j = 1; j < size; j++){
                if(grid[i][j] != grid[i][0] || grid[i][0] == 0){
                rowWin =  false;
                break;
            }
            
        }
            if(rowWin) {
            return true;
            }
        }
        return false;
    }
    
    public static boolean checkWinCol(int[][] grid, int size) {
        for(int j = 0; j < size; j++) {
            boolean colWin = true;
            for(int i = 0; i < size; i++){
                if(grid[i][j] != grid[0][j] || grid[0][j] == 0){
                colWin =  false;
                break;
            }
            
        }
            if(colWin) {
            return true;
            }
        }
        return false;
    } 
    
   /* public static boolean checkWinDiag(int[][] grid, int size){
        for(int i = 0; i < size; i ++){
            for(int j = 0; j < size; j ++){
                boolean diagnWin = true;
                if(grid[i][j] != grid[1][1] || grid[0][j] == 0){
                    diagnWin  = false;
                    break;
                }
            }
            if(diagnWin){
                return true;
            }
        }
        return false;
        
    } */
}
```
</details>

<details>
  <summary>BookManager (hard)</summary>

  ```java
public class Book{
  public String title;
  public String author;
  public int year;

  public Book(String title, String author, int year){
    this.title = title;
    this.author = author;
    this.year = year;
  }
}
```
```java
import java.util.ArrayList;

public class BookManager{

  public ArrayList<Book> books = new ArrayList<Book>();

  public void addBook(Book book){
    books.add(book);
  }

  public void removeBook(String title){
    books.removeIf(x -> x.title.equals(title));
  }

  public ArrayList<Book> getBooks(){
    return books;
  }
}
```
```java
import java.util.Scanner;

public class Main {
    public static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("Press 1 to add a book");
            System.out.println("Press 2 to remove a book");
            System.out.println("Press 3 to show all books");
            System.out.println("Press X to exit");
    
            String userInput = scanner.nextLine();
                if (userInput.equals("1")) {
                    addBook();
                } else if (userInput.equals("2")) {
                    removeBook();
                } else if (userInput.equals("3")) {
                    showBooks();
                } else if (userInput.equals("x")) {
                    
                    System.out.println("Book Manager is closed.");
                    break;
                } else {
                    System.out.println("Invalid input. Please try again.");
             }
        }
    scanner.close();
    }

    public static void addBook(){
        clearScreen();
        System.out.println("Please input the title of the book:");
        var title = scanner.nextLine();
        System.out.println("Please input the author of the book:");
        var author = scanner.nextLine();
        System.out.println("Please input the year of the book:");
        var year = scanner.nextInt();
        scanner.nextLine();
        var book = new Book(title, author, year);
        bookManager.addBook(book);
    
    }

    public static void removeBook(){
        clearScreen();
        System.out.println("Please input the title of the book to remove:");
        var removedBook = scanner.nextLine();
        bookManager.removeBook(removedBook);
    }

    public static void showBooks(){
        System.out.println("The list of books:");
        var allBooks = bookManager.getBooks();
        for(var books: allBooks){
            System.out.println(books.title + " by " + books.author + " (" + books.year + ")");    
        }
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
```
</details>   


<details>
  <summary>The CheeseShop easy/medium</summary>
 
  ```java
  public class Cheese {
    private String name;
    private int weight;
    private float price;

    public Cheese(String name, int weight, float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public float getPrice() {
        return price;
    }
}
```
```java
import java.util.ArrayList;

public class CheeseService{

    private ArrayList<Cheese> cheeses = new ArrayList<Cheese>();

    public void addCheese(Cheese cheese){
        cheeses.add(cheese);
    }

    public void removeCheese(String name){
        for (var cheese : cheeses){
            if (cheese.getName().equals(name)){
                cheeses.remove(cheese);
                return;
            }
        }
    }

    public ArrayList<Cheese> getCheese(){
        return cheeses;
    }
}

```
```java
import java.util.ArrayList;

public class CheeseShop {

    private ArrayList<Cheese> cart = new ArrayList<Cheese>();

    public void addCheeseToCart(Cheese cheese){
        cart.add(cheese);
    }

    public ArrayList<Cheese> getCheeseInCart(){
        return cart;
    }

    public void removeCheeseFromCart(Cheese cheese) {
        cart.remove(cheese);
    }

    public float checkout() {
        float sum = 0.0f;
        for (var cheese : cart) {
            sum += cheese.getPrice();
        }
        return sum;
    }
    public void clearCart() {
        cart.clear();
    }
}

```
```java
import java.util.ArrayList;

public class Customer {
    private float balance;
    private ArrayList<Cheese> ownedItems;

    public Customer(float balance) {
        this.balance = balance;
        this.ownedItems = new ArrayList<>();
    }

    public float getBalance() {
        return balance;
    }

    public ArrayList<Cheese> getOwnedItems() {
        return ownedItems;
    }

    public boolean buyCheese(CheeseShop cheeseShop) {
        float totalAmount = cheeseShop.checkout();
        if (this.balance >= totalAmount) {
            this.balance -= totalAmount;
            this.ownedItems.addAll(cheeseShop.getCheeseInCart());
            cheeseShop.clearCart();
            return true;
        }else{
            return false;
        }
    }
}

```
```java
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CheeseService cheeseService = new CheeseService();
    private static CheeseShop cheeseShop = new CheeseShop();
    private static Customer customer = new Customer(500.0f);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Press 1, if you are a admin");
            System.out.println("Press 2, if you are a customer");
            int action = scanner.nextInt();
            scanner.nextLine();
            if (action == 1) {
                adminMenu();
            } else if (action == 2) {
                customerMenu();
            } else {
                break;
            }
        }
        scanner.close();
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("Welcome Admin!");
            System.out.println("To add cheese to store, enter 1");
            System.out.println("To remove cheese from store, enter 2");
            System.out.println("To see cheese list, enter 3");
            System.out.println("To exit, enter 4");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 1) {
                cheeseService.addCheese(createStock());
            } else if (userInput == 2) {
                System.out.println("Please enter cheese name to be removed: ");
                String removeCheeseName = scanner.nextLine();
                cheeseService.removeCheese(removeCheeseName);
                System.out.println("Cheese removed successfully!");
            } else if (userInput == 3) {
                printCheese(cheeseService.getCheese());
            } else {
                System.out.println("You're exiting the program...");
                break;
            }
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("Press 1, to add cheese to the cart");
            System.out.println("Press 2, to view the cart");
            System.out.println("Press 3, to remove cheese form cart");
            System.out.println("Press 4, to checkout");
            int action = scanner.nextInt();
            scanner.nextLine();
            if (action == 1) {
                addCheeseToCart();
            } else if (action == 2) {
                printCheeseInCart();
            } else if (action == 3) {
                removeCheeseFromCart();

            } else {
                float totalAmount = cheeseShop.checkout();
                System.out.println("You have checked out, the amount is: " + totalAmount  + " EUR");
                if (totalAmount > customer.getBalance()){
                    System.out.println("Transaction failed, not enough money!");
                } else {
                    System.out.println("Transaction Successful!");
                    customer.buyCheese(cheeseShop);
                    System.out.println("Owned items: ");
                    for(Cheese cheese : customer.getOwnedItems()){
                        System.out.println(cheese.getName());
                        System.out.println("(" + cheese.getWeight() + "grams)");
                        System.out.println(cheese.getPrice() + " EUR");
                    }
                }
                break;
            }

        }
    }

    public static Cheese createStock() {
            String cheeseName = "";
            int cheeseWeight = 0;
            float cheesePrice = 0.0f;

            while (true) {
                boolean validInput = true;

                try {
                    System.out.println("Please enter cheese name: ");
                    cheeseName = scanner.nextLine();
                    if (cheeseName.trim().isEmpty() || !cheeseName.matches("[a-zA-Z ]+")) {
                        System.out.println("Cheese name cannot be empty.");
                        validInput = false;
                    }

                    System.out.println("Please enter cheese weight in grams: ");
                    cheeseWeight = scanner.nextInt();
                    if (cheeseWeight <= 0) {
                        System.out.println("Cheese weight must be positive.");
                        validInput = false;
                    }
                    scanner.nextLine();

                    System.out.println("Please enter cheese price: ");
                    cheesePrice = scanner.nextFloat();
                    if (cheesePrice <= 0) {
                        System.out.println("Cheese price must be positive.");
                        validInput = false;
                    }
                    scanner.nextLine();

                } catch (Exception e) {
                    System.out.println("Wrong input!");
                    scanner.nextLine();
                    validInput = false;
                }

                if (validInput) {
                    break;
                } else {
                    System.out.println("Invalid inputs detected. Please start over.");
                }
            }

        Cheese cheese1 = new Cheese(cheeseName, cheeseWeight, cheesePrice);
        return cheese1;
    }



    public static void printCheese(ArrayList<Cheese> cheeses) {
                System.out.println("These are the cheese in the storage");
                for (Cheese cheese : cheeses) {
                    System.out.println(cheese.getName());
                    System.out.println("(" + cheese.getWeight() + "grams)");
                    System.out.println(cheese.getPrice() + " EUR");
                }
            }
            public static void addCheeseToCart() {
                System.out.println("Enter a cheese name you want to put in the cart: ");
                String nameToCart = scanner.nextLine();

                ArrayList<Cheese> cheeses = cheeseService.getCheese();
                for (Cheese cheese : cheeses) {
                    if (cheese.getName().equalsIgnoreCase(nameToCart)) {
                        cheeseShop.addCheeseToCart(cheese);
                        return;
                    }
                }
                System.out.println("This cheese does not exist in the shop!");
            }
    public static void removeCheeseFromCart() {
        ArrayList<Cheese> cart = cheeseShop.getCheeseInCart();
        System.out.println("Provide a cheese name to remove from cart: :");
        String name = scanner.nextLine();
        for (Cheese cheese : cart) {
            if (cheese.getName().equalsIgnoreCase(name)) {
                cheeseShop.removeCheeseFromCart(cheese);
                return;
            }
        }
        System.out.println("That cheese does not exist in the cart!");
    }
    public static void printCheeseInCart() {
        System.out.println("These are the items in the cart:");
        ArrayList<Cheese> cart = cheeseShop.getCheeseInCart();
        for (var cheese : cart) {
            System.out.println(cheese.getName() + " (" + cheese.getWeight() + " g) - " + cheese.getPrice() + " EUR");
        }
    }
}
```
</details>

 ### For [python](https://github.com/MargoZhubinska/Individual-work/tree/main/Python) :snake:
 <details>
  <summary>Bank medium and hard level</summary>
  
  ```python

  print("Welcome to MargoBank!")

balance = 0

while True:
    deposit = input('Enter your amount of money to deposit, \nwrite "Exit" to stop or "Withdraw" to withdraw money: ')
    if deposit.lower() == 'exit':
        print(f'Thank you for choosing our bank! Your total balance is:  {balance}')
        break
    elif deposit.lower() == 'withdraw':
        try:
            withdrawal = int(input('Enter the amount of money to withdraw :' ))
            if balance < withdrawal:
                    print('Withdrawal is not possible! Insufficient funds!')
            else:
                    balance -= withdrawal
                    print(f'Your balance {balance}')
        except:
            print('Invalid input! Please enter whole  numbers, "Exit" or "Withdraw" !')

    else:
        try:
            deposit_int = int(deposit)
            balance += deposit_int
        except:
            print('Invalid input! Please enter whole  numbers or "Exit" !'
            
 ```
```python
print("Welcome to MargoBank!")
print("\nWhat would you like to do?") 
print("1. Deposit money") 
print("2. Withdraw money") 
print("3. Check balance") 
print("4. Exit")
balance = 0

while True:
    try:
        choice = int(input('Enter action 1. - 4.: '))
        if choice == 1:
            try:
                deposit = int(input('Enter your amount of money to deposit : '))
                balance += deposit
            except:
                print('Invalid input! Please enter whole numbers!')
        elif choice == 2:
            try:
                withdrawal = int(input('Enter the amount of money to withdraw :' ))
                if balance < withdrawal:
                        print('Withdrawal is not possible! Insufficient funds!')
                else:
                        balance -= withdrawal
            except:
                print('Invalid input! Please enter whole numbers!')
        elif choice == 3:
            print(f'Your balance: {balance}')
        elif choice == 4:
            print(f'Thank you for choosing our bank! Your total balance is:  {balance}')
            break
            
        else:
            print('Invalid choice! Please enter numbers from 1 - 4!')
    except:
        print('Invalid input! Please enter whole  numbers 1 - 4')

```

 </details>

 <details>
  <summary>OnlineShop</summary>

  ```python
import datetime

class Client:
    def __init__(self, id, name, account):
        self.id = id
        self.name = name
        self.account = account
        self.transactions = []

    def add_transactions(self, transaction):
        self.transactions.append(transaction)


class Item:
    def __init__(self,article, item_name, price):
        self.article = article
        self.item_name = item_name
        self.price = float(price)

class Transaction:
    def __init__(self, transaction_id, currency, client, items):
        self.transaction_id = transaction_id
        self.currency = currency
        self.client = client
        self.items = items
        self.amount = 0

        for item in items:
            self.amount +=item.price
        self.amount = round(self.amount, 2)

        self.time_stamp = datetime.datetime.now()



clients = []

clients.append(Client('1', 'Anna', 'LV123456789'))
clients.append(Client('2', 'Margarita', 'LV987654321'))
clients.append(Client('3', 'Janis', 'LV678912345'))

items = []

items.append(Item('012345', 'Soap', 2.49))
items.append(Item('567834', 'Toothbrush', 4.50))
items.append(Item('524803', 'Cream', 20.99))
items.append(Item('890890', 'Laundry detergent', 8.79))
items.append(Item('237845', 'Shower gel', 5.24))

transactions = []

transactions.append(Transaction('001', 'EUR', clients[0], [items[0]]))
transactions.append(Transaction('002', 'EUR', clients[1],[items[2], items [4]]))
transactions.append(Transaction('003', 'EUR', clients[2], [items[3], items[0]]))
transactions.append(Transaction('004', 'EUR', clients[2], [items[1]]))

for transaction in transactions:
    transaction.client.add_transactions(transaction)


print('Client:')
for client in clients:
    print(f'{client.id} {client.name} {client.account}')
    print("Transactions:")
    for transaction in client.transactions:
        print(f' {transaction.transaction_id} {transaction.amount} {transaction.currency} {transaction.time_stamp}')
        print(" Items:")
        for item in transaction.items:
            print(f' {item.item_name}')
```
 </details>

<details>
  <summary>Prices</summary>
 
```python

total_price = 0
total_items = 0

with open('/content/prices.txt', 'r') as file:
    prices = file.readlines()

    for number in prices:
        total_price += float(number)
        total_items += 1

print(f'Total Price: {total_price}')
print(f'Total Number of Purchased Items: {total_items}')
```
</details>
