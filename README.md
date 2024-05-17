## Wotech indivitual tasks

 ### For [java](https://github.com/MargoZhubinska/Individual-work/blob/main/java)
 
 ```java
import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        int size = 3;
        int[][] grid = new int [size][size];
        boolean win = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Tic-Tac-Toe!" + "\nWhere will you put 1?");
        
        printGrid(grid, size);
        
        while (!win) {
            System.out.println("Enter a row (number 1-3): ");
                int row = scanner.nextInt();
                row = row - 1;
                System.out.println("Enter a column (number 1-3): ");
                int column = scanner.nextInt();
                column = column - 1;
                
            if (row < 0 || row >= size || column < 0 || column >= size || grid[row][column] != 0) {
                System.out.println("Invalid move. Try again.");
                continue;
                        }
            grid[row][column] = 1;
            printGrid(grid,size);
            
            win = checkWin(grid,size);
            
            if(win) {
                System.out.println("Congratulations! You won!");
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
    
    public static boolean checkWin( int[][] grid, int size) {
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
}

```

 ### For [python](https://github.com/MargoZhubinska/Individual-work/blob/main/python)
