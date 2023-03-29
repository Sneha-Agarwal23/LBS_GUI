package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Booksperstudent {
	private JFrame frame;
	private JPanel panel;
	private JTextField sidField;
	private JButton okbutton;
	
	public BooksDB db;
	public StudentsDB sc;
	
	public Booksperstudent()
	{
		createPanel();
		createFrame();
	}
	
	public Booksperstudent(BooksDB db, StudentsDB sc)
	{
		createPanel();
		createFrame();
		this.db = db;
		this.sc = sc;
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("STUDENT'S ISSUED BOOKS:");
        headingLabel.setBounds(100, 50, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel sid = new JLabel("Student ID: ");
        sid.setBounds(50, 100, 100, 30);
        panel.add(sid);
        
        sidField = new JTextField();
        sidField.setBounds(200, 100, 200, 30);
        panel.add(sidField);
        
        
        okbutton = new JButton("SHOW");
        okbutton.setBounds(150, 200, 100, 30);
        panel.add(okbutton);
        okbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String s = sidField.getText();
        		
        		Student st[] = sc.getinfo(s);
        		
        		new disp(db,sc,s);
        		/*JTextArea blist = new JTextArea();
                blist.setEditable(false);
                JScrollPane scroll = new JScrollPane(blist);
                panel.add(scroll);
                
                Student curst = st[0];
                
                blist.append("SL No."+ "\t\t" +  "Book ID" + "\t\t" + "Book Name" + "\t\t" + "Author Name" + "\n");
                for(int i = 0; i < curst.book_count; i++)
                {
                	blist.append((i+1) + "\t\t" +  curst.issued_book[i].book_id + "\t\t" + curst.issued_book[i].book_name + "\t\t" + curst.issued_book[i].author_name + "\n");
                }
         		
        		
        		//frame.dispose();
        		//new Studentpage(db, sc);*/
        	}
        });
        
        
	}
	private void createFrame()
	{
		frame = new JFrame("STUDENT'S ISSUED BOOKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String args[])
	{
		//new Booksperstudent();
	}

}
