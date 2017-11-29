import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/** 
   This Swing class is used to demonstrate
   the operations in the LinkedList1 class.
*/

public class SwingLinkedList1Demo extends JFrame
{    
    private LinkedList1 ll;
    private JTextArea  listView;
    private JTextField cmdTextField;
    private JTextField resultTextField;
    
    public SwingLinkedList1Demo()
    {
       ll = new LinkedList1(); 
       listView = new JTextArea();
       cmdTextField = new JTextField();
       resultTextField = new JTextField();
       
       // Create a panel and label for result field
       JPanel resultPanel = new JPanel(new GridLayout(1,2));
       resultPanel.add(new JLabel("Command Result"));
       resultPanel.add(resultTextField);
       resultTextField.setEditable(false);
       add(resultPanel, BorderLayout.NORTH);
       
       // Put the textArea in the center of the frame
       add(listView);
       listView.setEditable(false);
       listView.setBackground(Color.WHITE);
       
       // Create a panel and label for the command text field
       JPanel cmdPanel = new JPanel(new GridLayout(1,2));
       cmdPanel.add(new JLabel("Command:"));
       cmdPanel.add(cmdTextField);
       add(cmdPanel, BorderLayout.SOUTH);  
       cmdTextField.addActionListener(new CmdTextListener());
       
       // Set up the frame
       setTitle("Swing Linked List Demo");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
       setVisible(true);       
    }
     
    /**
       Private class that responds to the command that 
       the user types into the command entry text field.
    */
    
    private class CmdTextListener implements ActionListener
    {            
        public void actionPerformed(ActionEvent evt)
        {
            // Get the command from the command textfield.
            String cmdText = cmdTextField.getText();
            
            // Use a scanner to read the method in the command
            // and do a switch on it.
            Scanner sc = new Scanner(cmdText);
            String cmd = sc.next();            
            switch(cmd)
            {
                case "add":
                    if (sc.hasNextInt())
                    {
                        // add index element
                        int index = sc.nextInt();
                        String element = sc.next();
                        ll.add(index, element);                
                    }
                    else
                    {  
                        // add element
                        String element = sc.next();
                        ll.add(element);                
                    }
                    listView.setText(ll.toString());
                    pack();
                    return;
                case "remove":
                    if (sc.hasNextInt())
                    {
                        // remove index
                        int index = sc.nextInt();
                        String res = ll.remove(index);
                        resultTextField.setText(res);              
                    }
                    else
                    {
                        // remove element
                        String element = sc.next();
                        boolean res = ll.remove(element);
                        String resText = String.valueOf(res);
                        resultTextField.setText(resText);
                    }
                    listView.setText(ll.toString());
                    pack();
                    return;
                case "isempty" :
                    String resText = String.valueOf(ll.isEmpty());
                    resultTextField.setText(resText);
                    return;
                case "size":
                    String resText1 = String.valueOf(ll.size());
                    resultTextField.setText(resText1);
                    return;                
            }          
        }
    }
	 
    /**
       The main method creates an instance of the 
       SwingLinkedList1Demo class which causes it to 
       display its window.
    */
    
    public static void main(String [ ] args)
    {
        new SwingLinkedList1Demo();
    }    
}