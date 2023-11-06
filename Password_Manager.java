import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;

class GUI_2{

    public static void main(String[]args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);
        
        //an array of strings to add and remove from the list whenever a button is called
        String[] header = {"Website", "Username", "Password"};
        String[][] rec = {{"Website", "Username", "Password"},{null,null,null}};

        //table to store array elements in
        JTable table = new JTable(rec, header);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowHorizontalLines(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);
        table.setBounds(10, 50,680, 400);
        panel.add(new JScrollPane(table));
        panel.add(table);

        
        //create a new username, password and website labels
        JLabel userlabel = new JLabel("Username");
        JLabel passlabel = new JLabel("Password");
        JLabel weblabel = new JLabel("Website");

        //setting the positions for the labels
        userlabel.setBounds(10, 600, 80 ,25);
        panel.add(userlabel);

        passlabel.setBounds(10, 630, 80, 25);
        panel.add(passlabel);

        weblabel.setBounds(10, 570, 80, 25);
        panel.add(weblabel);

        //creating textfields for username, password and website fields
        JTextField usertext = new JTextField();
        usertext.setBounds(100, 600 , 165, 25);
        panel.add(usertext);


        JPasswordField passtext = new JPasswordField();
        passtext.setBounds(100, 630, 165, 25);
        panel.add(passtext);

        JTextField webtext = new JTextField();
        webtext.setBounds(100, 570, 165, 25);
        panel.add(webtext);

        //create button for adding and removing the password to/from the list
        JButton addbutton = new JButton("Add");
        addbutton.setBounds(300, 630, 80, 25);
        panel.add(addbutton);
        
        //Adding an actionlistener to invoke add button 
        
        ActionListener actionListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) // Function to invoke add button
            {
                 String username=usertext.getText();                // Extracting username from the text field
                 String password=passtext.getText();                // Extracting password from the text field
                 String webaddress=webtext.getText();               // Extracting webaddress from the text field 
                 
                 if (username.equals("") || password.equals("")||webaddress.equals(""))
                 {
                     System.out.println("Empty parameter");
                 }
                 else
                 {
                     
                 String[] newrec={webaddress,username,password};    // Creating an array to append the new record into the table
                 
                 String[][] temp=new String[rec.length][3];         // Creating an temporary array to backup the existing records
                 
                 int x=rec.length;                                  // Storing the value of no. of rows
                 for (int i=0;i<temp.length;i++)
                 {
                     temp[i]=rec[i];
                 }
                 
                 String[] header = {"Website", "Username", "Password"};
                 String[][] rec=new String[x+1][3];                            // Redefining the 'rec' array
                 
                 for (int i=0;i<temp.length;i++)
                 {
                     rec[i]=temp[i];                                           // pasting the previous record
                 }
                 
                 rec[rec.length-1]=newrec;                                     // Appening the new record
                 
                 panel.remove(table);
                 
                 //table to store array elements in
                 
                 JTable table = new JTable(rec, header);
                 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                 table.setShowHorizontalLines(true);
                 table.setShowGrid(true);
                 table.setGridColor(Color.gray);
                 table.setBounds(10, 50,680, 400);
                 panel.add(new JScrollPane(table));
                 panel.add(table);
                 
                 panel.revalidate();
                 panel.repaint();
                 
                 System.out.println("Hello");
                   
                 }
                 
            }
        };
        
        addbutton.addActionListener(actionListener);
            
        JButton removebutton = new JButton("Remove");
        removebutton.setBounds(400, 630, 80 , 25);
        panel.add(removebutton);

        frame.setVisible(true);
    }
}
