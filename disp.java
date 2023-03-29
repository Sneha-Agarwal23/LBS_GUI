package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class disp {
	private JFrame frame;
	private JPanel panel;
	private BooksDB db;
	public StudentsDB sc;
	String s;
	
	public disp(BooksDB db, StudentsDB sc, String s)
	{
		createPanel();
		createFrame();
		this.db = db;
		this.sc = sc;
		this.s = s;
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
        
        JTextArea blist = new JTextArea();
        blist.setEditable(false);
        JScrollPane scroll = new JScrollPane(blist);
        panel.add(scroll, BorderLayout.CENTER);
        
        Student st[] = sc.getinfo(s);
        Student curst = st[0];
        
        blist.append("SL No."+ "\t\t" +  "Book ID" + "\t\t" + "Book Name" + "\t\t" + "Author Name" + "\n");
        for(int i = 0; i < curst.book_count; i++)
        {
        	blist.append((i+1) + "\t\t" +  curst.issued_book[i].book_id + "\t\t" + curst.issued_book[i].book_name + "\t\t" + curst.issued_book[i].author_name + "\n");
        }
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Studentpage(db, sc);
        	}
        });
        panel.add(back, BorderLayout.SOUTH);
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

	public static void main(String[] args) {
      
    }
}
