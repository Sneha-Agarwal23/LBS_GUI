package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Upgradebook {
	private JFrame frame;
	private JPanel panel;
	private BooksDB db;
	private JTextField bookname;
	private JTextField bookid;
	private JTextField qty;
	private JButton update;
	
	public BooksDB ob;
	public StudentsDB sc;
	
	public Upgradebook()
	{
		createPanel();
		createFrame();
	}
	
	public Upgradebook(BooksDB ob, StudentsDB sc)
	{
		createPanel();
		createFrame();
		this.ob = ob;
		this.sc = sc;
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("UPGRADE BOOK QUANTITY");
        headingLabel.setBounds(100, 50, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel bname = new JLabel("Book Name:");
        bname.setBounds(50, 100, 100, 30);
        panel.add(bname);
        
        bookname = new JTextField();
        bookname.setBounds(200, 100, 200, 30);
        panel.add(bookname);
        
        JLabel bid = new JLabel("Book ID: ");
        bid.setBounds(50, 150, 100, 30);
        panel.add(bid);
        
        bookid = new JTextField();
        bookid.setBounds(200, 150, 200, 30);
        panel.add(bookid);
        
        JLabel bqty = new JLabel("Quantity: ");
        bqty.setBounds(50, 200, 100, 30);
        panel.add(bqty);
        
        qty = new JTextField();
        qty.setBounds(200, 200, 200, 30);
        panel.add(qty);
        
        update = new JButton("UPDATE");
        update.setBounds(125, 300, 200, 30);
        panel.add(update);
        update.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String n = bookname.getText();
        		String i = bookid.getText();
        		String q = qty.getText();
        		
        		if(n.isEmpty() || i.isEmpty() || q.isEmpty())
        		{
        			JOptionPane.showMessageDialog(frame, "Please Enter Valid Details");
        		}
        		else
        		{
        			Book[] b = db.searchBook(i, n);
        			if(b == null)
        				JOptionPane.showMessageDialog(frame, "No Book Found");
        			else
        			{
        				try {
        					int x = Integer.parseInt(q);
        					b[0].book_quantity += x;
        					b[0].book_quantity_copy += x;
        					JOptionPane.showMessageDialog(frame, "Updation Successful");
        					new Showbooks(ob, sc);
        				}
        				catch(NumberFormatException ex){
        					JOptionPane.showMessageDialog(frame, "Please Enter Quantity in Numerical Value");
        				}
        			}
        		}
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(125, 350, 200, 30);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Adminpage(ob, sc);
        	}
        });
        panel.add(back);
        
	}
	private void createFrame()
	{
		frame = new JFrame("UPGRADE BOOK QUANTITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Upgradebook();
    }


}
