## Wotech indivitual tasks

 ### For [java](https://github.com/MargoZhubinska/Individual-work/blob/main/java) :coffee:
 <details>
  <summary>The Tic-Tac-Toe easy code</summary>
  
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

 ### For [python](https://github.com/MargoZhubinska/Individual-work/blob/main/python) :snake:
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
