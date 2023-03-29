package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Showbooks {
	private JFrame frame;
	private JPanel panel;
	private BooksDB obj;
	public StudentsDB sc;
	
	public Showbooks()
	{
		obj = new BooksDB();
		createPanel();
		createFrame();
	}
	
	public Showbooks(BooksDB db, StudentsDB sc)
	{
		this.obj = db;
		createPanel();
		createFrame();
		this.sc = sc;
	}
	
	private void createPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("ALL BOOKS");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel, BorderLayout.NORTH);
        
        JTextArea booklist = new JTextArea();
        booklist.setEditable(false);
        JScrollPane scroll = new JScrollPane(booklist);
        panel.add(scroll, BorderLayout.CENTER);
        
        
        Book[] b = obj.getAllBooks();
        booklist.append("SL No."+ "\t\t" +  "Book ID" + "\t\t" + "Book Name" + "\t\t" + "Author Name" + "\t\t" + "Total Quantity" +  "\n");
        for(int i = 0; i < b.length; i++)
        {
        	booklist.append((i+1) + "\t\t" +  b[i].book_id + "\t\t" + b[i].book_name + "\t\t" + b[i].author_name + "\t\t" + b[i].book_quantity + "\n");
        }
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Adminpage(obj, sc);
        	}
        });
        panel.add(back, BorderLayout.SOUTH);
	}
	
	
	private void createFrame()
	{
		frame = new JFrame("ALL BOOKS:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Showbooks();
    }

}
