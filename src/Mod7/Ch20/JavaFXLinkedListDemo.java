import java.util.Scanner;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
    This JavaFX class is used to demonstrate
    the operations in the LinkedList1 class.
*/

public class JavaFXLinkedListDemo extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        // Reference to linked list.
        LinkedList1 ll = new LinkedList1();         
        
        // listView shows current list elements.
        TextArea  listView = new TextArea(); 
        listView.setEditable(false);
        
        // Input for user command.
        TextField cmdTextField = new TextField();  
        cmdTextField.setPrefColumnCount(5);
        
        // Displays result of list method that was 
        // invoked by the user command.
        TextField resultTextField = new TextField();  
        resultTextField.setPrefColumnCount(5);
        resultTextField.setEditable(false);
        
        // Attach event handler to cmdTextField
        EventHandler<ActionEvent> handler = 
                new CommandHandler(ll, listView, resultTextField);
        cmdTextField.setOnAction(handler);
       
         // HBox to contain command result label and text field.
        HBox hBox1 = new HBox(10);
        Label resultLabel = new Label("Command Result");
        hBox1.getChildren().addAll(resultLabel, resultTextField);
        
        // HBox to contain label and text field for command input.
        HBox hBox2 = new HBox(10);
        Label cmdLabel = new Label("Command: ");
        hBox2.getChildren().addAll(cmdLabel, cmdTextField);
        
        // VBox to contain the user interface components
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(hBox1, listView, hBox2);        
        
        // Set up the scene and show the stage.
        stage.setScene(new Scene(vBox));
        stage.setTitle("JavaFX Linked List Demo");
        stage.show();           
    }
    
    public static void main(String [] args)
    {
        launch();
    }    
}


// Event Handler class for the command text field.       
class CommandHandler implements EventHandler<ActionEvent>
{
    // private fields to hold information passed to the constructor.
    private LinkedList1 ll;
    private TextField resultTextField;
    private TextArea listView;
    
    CommandHandler(LinkedList1 lList, TextArea lView, TextField rTfield)
    {
        ll = lList;
        resultTextField = rTfield;
        listView = lView;        
    }
    
    @Override
    public void handle(ActionEvent event)
    {
        // Get the command from the command textfield.
        TextField cmdTextField = (TextField)event.getTarget();
        String cmdText =  cmdTextField.getText();
        
        // Use a scanner to read the name of the linked list  
        // method and do a switch on it.
        Scanner sc = new Scanner(cmdText);
        String cmd = sc.next();
        switch(cmd)
        {
            case "add" :
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
                return;
            case "remove" :
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
                return;
            case "isempty":
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
