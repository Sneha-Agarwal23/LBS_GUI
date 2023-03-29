package library;
import java.util.*;
public class StudentsDB 
{
	public  Student[] students;
    private int numOfStudents;
    
    public BooksDB db;
    
    public StudentsDB(BooksDB db)
    {
    	students = new Student[50];
    	numOfStudents = 0;
        this.db = db;
    }
    
    public StudentsDB() {
    	students = new Student[50];
        for(int i=0; i<50; i++) {
            students[i] = new Student("", "", "", "-1",""); // Initialize each element with a new book object
        }
        numOfStudents = 0;

    }
    
    public void addStudent(Student s) {
        if(numOfStudents == 50) {
            System.out.println("Yo");
        } else {
            students[numOfStudents] = s;
            numOfStudents++;
        }
    }
    
    public Student[] getAllStudents() {
        return students;
    }
    
    public Student[] getinfo(String s)
    {
    	Student[] st = new Student[5];
    	int x = 0;
    	for(int i = 0; i < numOfStudents; i++)
    	{
    		if(students[i].student_id.equalsIgnoreCase(s))
    		{
    			st[x++] = students[i];
    		}
    	}
    	return st;
    }
    
    public void issueBook(String s, String b)
    {
    	Student st []= getinfo(s);
    	Book bk [] = db.searchBook(b, "");
    	
    	
    	Student curst = st[0];
    	Book curb = bk[0];
    	if(curst.book_count >= 3)
    		System.out.println("You can't issue more books!");
    	else
    	{
    		curst.issued_book[curst.book_count++] = curb;
    		curb.book_quantity_copy--;
    	}
    	
    }
    public void returnbook(String s, String b)
    {
    	Student st []= getinfo(s);
    	int bid = Integer.parseInt(b);
    	Book curb;
    	Student curst = st[0];
    	for(int i = 0; i < curst.book_count;i++)
    	{
    		if(curst.issued_book[i].book_id == bid)
    		{
    			curb = curst.issued_book[i];
    			curst.issued_book[i] = null;
    			curst.book_count--;
    			curb.book_quantity_copy++;
    		}
    	}
    }

}
