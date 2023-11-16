import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.table.DefaultTableModel;


class GUI_2{

    public static void main(String[]args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("PASSWORD MANAGER");
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        //table to store data elements:
        JTable table = new JTable(0,3);
        DefaultTableModel tblmodel = (DefaultTableModel)table.getModel();
        tblmodel.addRow(new Object[]{"Website", "Username", "Password"});
        panel.add(new JScrollPane(table));
        //visual guidelines for the table
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setShowHorizontalLines(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);
        table.setBounds(10, 50,680, 500);
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

        //creating text fields for username, password and website
        JTextField usertext = new JTextField();
        usertext.setBounds(100, 600 , 165, 25);
        panel.add(usertext);


        JTextField passtext = new JTextField();
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


        ActionListener actionListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) // Function to invoke add button
            {

                String[] data = {webtext.getText(), usertext.getText(), passtext.getText()};
                String null1 = "";

                if (data[0].equals(null1) || data[1].equals(null1) || data[2].equals(null1))
                {
                    System.out.println("Empty parameter");
                    JOptionPane.showMessageDialog(null, "Enter all fields");
                }
                else
                {

                    tblmodel.addRow(data);

                    JOptionPane.showMessageDialog(null, "Successfully added!");

                    usertext.setText("");
                    passtext.setText("");
                    webtext.setText("");

                }

            }
        };

        addbutton.addActionListener(actionListener);

        JButton removebutton = new JButton("Remove");
        removebutton.setBounds(400, 630, 80 , 25);
        panel.add(removebutton);

        ActionListener actionListener1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){


                if(table.getSelectedRowCount()==1){
                    tblmodel.removeRow(table.getSelectedRow());
                }
                else{
                    if(table.getRowCount()==0){
                        JOptionPane.showMessageDialog(null, "Table is empty");}
                    else{
                        JOptionPane.showMessageDialog(null, "Select single row for deletion");}
                    }
                }

            };

        JButton generate = new JButton("Generate Password");
        generate.setBounds(500, 630, 150 , 25);
        panel.add(generate);
        ActionListener actionListener2= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int digit = ThreadLocalRandom.current().nextInt(14, 25);

                String lower_case = "qwertyuiopasdfghjklzxcvbnm";
                String upper_case = "QWERTYUIOPASDFGHJKLZXCVBNM";
                String special_char = "!@#$%^&*";

                String password = "";

                for(int i =0; i< digit; i++){
                    int rand = (int)(4 * Math.random());

                    switch(rand){
                        case 0:
                            password += String.valueOf((int)(10 * Math.random()));
                            break;
                        case 1:
                            rand = (int)(lower_case.length()* Math.random());
                            password += String.valueOf(lower_case.charAt(rand));
                            break;
                        case 2:
                            rand = (int)(upper_case.length()* Math.random());
                            password += String.valueOf(upper_case.charAt(rand));
                            break;
                        case 3:
                            rand = (int)(special_char.length()* Math.random());
                            password += String.valueOf(special_char.charAt(rand));
                            break;
                    }

                    passtext.setText(password);
                }
            }
        };
        generate.addActionListener(actionListener2);
        removebutton.addActionListener(actionListener1);
        frame.setVisible(true);
    }
}
