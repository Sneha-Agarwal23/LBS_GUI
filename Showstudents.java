package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Showstudents {
	private JFrame frame;
	private JPanel panel;
	
	private BooksDB db;
	private StudentsDB sc;
	
	public Showstudents()
	{
		//sc = new StudentsDB(db);
		createPanel();
		createFrame();
	}
	
	public Showstudents(BooksDB db, StudentsDB sc)
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
        
        JLabel headingLabel = new JLabel("ALL STUDENTS");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel, BorderLayout.NORTH);
        
        JTextArea studentlist = new JTextArea();
        studentlist.setEditable(false);
        JScrollPane scroll = new JScrollPane(studentlist);
        panel.add(scroll, BorderLayout.CENTER);
        
        
        Student[] s = sc.getAllStudents();
        studentlist.append("SL No."+ "\t\t" +  "Name" + "\t\t" + "ID" + "\t\t" + "Stream" + "\t\t" + "Year " + "\t\t" + "Mobile" + "\n" );
        for(int i = 0; i < s.length; i++)
        {
        	studentlist.append((i+1) + "\t\t" +  s[i].student_name + "\t\t" + s[i].student_id  + "\t\t" + s[i].student_stream + "\t\t" + s[i].student_year + "\t\t" + s[i].student_mobile + "\n");
        }
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Adminpage(db, sc);
        	}
        });
        panel.add(back, BorderLayout.SOUTH);
	}
	
	
	private void createFrame()
	{
		frame = new JFrame("ALL STUDENTS:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Showstudents();
    }

}
