package library;

import java.util.Scanner;

public class Book {
	public int book_id;
	public String book_name;
	public String author_name;
	public int book_quantity;
	public int book_quantity_copy;
	
	Scanner sc = new Scanner(System.in);
	
	public Book(String i, String bn, String an, String q)
	{
		//System.out.println("Enter the Book ID: ");
		this.book_id = Integer.parseInt(i);		//= sc.nextInt();
		//sc.nextLine();
		
		//System.out.println("Enter the Book Name: ");
		this.book_name = bn;		//= sc.nextLine();
		
		//System.out.println("Enter the Author Name: ");
		this.author_name = an;		//sc.nextLine();
		
		//System.out.println("Enter the Book Quantity: ");
		this.book_quantity = Integer.parseInt(q);			//nextInt();
		book_quantity_copy = this.book_quantity;
	}
	
	/*public static void main(String args[])
	{
		Book ob = new Book();
	}*/
	

}