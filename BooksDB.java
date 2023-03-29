package library;
import java.util.*;
public class BooksDB {
	public  Book[] theBooks;
    private int numOfBooks;

    public BooksDB() {
    	theBooks = new Book[50];
        for(int i=0; i<50; i++) {
            theBooks[i] = new Book("-1", "", "", "-1"); // Initialize each element with a new book object
        }
        numOfBooks = 0;
    }

    public void addBook(Book bookObj) {
        if(numOfBooks == 50) {
            System.out.println("Database is full, cannot add more books.");
        } else {
            theBooks[numOfBooks] = bookObj;
            numOfBooks++;
        }
    }
    
    public Book[] getAllBooks() {
        return theBooks;
    }
    
    public Book[] searchBook(String i, String n)
    {
    	//ArrayList<Book> a = new ArrayList<Book>();
    	Book y[] = new Book[5];
    	int k = 0;
    	int j = Integer.parseInt(i);
    	for(int x = 0; x < numOfBooks; x++)
    	{
    		Book b = theBooks[x];
    		if(j == b.book_id || n == b.book_name)
    		{
    			y[k++] = b;
    		}
    	}
    	return y;
    }

    public void displayBooks() {
        if(numOfBooks == 0) {
            System.out.println("Database is empty.");
        } else {
            System.out.println("Serial No\tBook Name\tAuthor Name\tQuantity");
            for(int i=0; i<numOfBooks; i++) {
                System.out.println(theBooks[i].book_id + "\t\t" + theBooks[i].book_name + "\t\t" + theBooks[i].author_name + "\t\t" + theBooks[i].book_quantity + "\t\t" + theBooks[i].book_quantity_copy);
            }
        }
    }

}
