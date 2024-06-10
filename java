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

//Second task
///Book.java
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

//BookManager.java

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

//Main.java

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
