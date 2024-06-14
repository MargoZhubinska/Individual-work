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
