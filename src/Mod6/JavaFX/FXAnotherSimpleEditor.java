package Mod6.JavaFX;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * This program is a simple text editor. It will save text files with two different
 * encryption methods, as long as change the texts color.
 * @author GrantPerson
 *
 */
public class FXAnotherSimpleEditor extends Application {

    MenuItem OpenFile;		//Open file option
    Menu SaveFile;		//Save file option
    MenuItem ExitFile;		//Exit file option
    MenuItem EditText;		//Change text file option
    MenuItem BlackText;	//Change text file option
    TextArea TextA;		//The text area
    MenuItem SaveOp1;		//The various save options
    MenuItem SaveOp2;
    MenuItem SaveOp3;
    MenuItem How2; 		//About the program menu item
    MenuItem Info;			//About the program menu item
    File FN;				//FileName
    int TypeOfEn;			//For the type of encryption, 0 for +1, 1 for reverse, 2 for normal

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Sets the title of our window
        primaryStage.setTitle("Mini Text Editor");

        //build vbox
        VBox box = new VBox(); //buildTextA();

        // buidl scene with box
        Scene scene = new Scene(box);

        //Add the menu bar onto the box
        MenuBar bar = buildMenuBar();
        box.getChildren().add(bar);

        // add the textbox
        buildTextA();
        box.getChildren().add(TextA);

        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.show();
    }

    /**
     * Creates the JMenu bar with the Edit, File, Help options
     * @return menu A menu bar.
     */
    private MenuBar buildMenuBar(){
        //Create a menu bar

        //Add the various menu items
        Menu fileM = buildFileMenu();
        Menu EditM = buildEditMenu();
        Menu HelpMe = buildHelpMenu();

        return new MenuBar(fileM, EditM, HelpMe);
    }


    /**
     * Creates the File menu along with its various options
     * @return file A JMenuItem for "File"
     */
    private Menu buildFileMenu(){
        //Create the menu
        Menu file = new Menu("File");

        //Creates the items.
        OpenFile = new MenuItem("Open File");
        SaveFile = new Menu("Save");
        ExitFile = new MenuItem("Exit");

        //Makes a sub menu for the +1 save option.
        SaveFile.setMnemonicParsing(true);
        SaveOp1 = new MenuItem("_Save Encrypted +1");
        SaveOp1.setAccelerator(KeyCombination.keyCombination("ALT+2"));

        //Makes a sub menu for the reverse text save option.
        SaveOp2 = new MenuItem("Save Encrypted Reverse");
        SaveOp2.setAccelerator(KeyCombination.keyCombination("ALT+3"));

        //Makes a sub menu for the regular text save option.
        SaveOp3 = new MenuItem("Save Normal");
        SaveOp3.setAccelerator(KeyCombination.keyCombination("ALT+4"));

        SaveFile.getItems().addAll(SaveOp1, SaveOp2, SaveOp3);

        //Add items to menu

        ObservableList<MenuItem> items = file.getItems();
        items.addAll(OpenFile, SaveFile, new SeparatorMenuItem(), ExitFile);

        // Hook up the menu items with the listener
        MyListener listener = new MyListener();


        OpenFile.setOnAction(listener);
        SaveFile.setOnAction(listener);
        ExitFile.setOnAction(listener);
        SaveOp1.setOnAction(listener);
        SaveOp2.setOnAction(listener);
        SaveOp3.setOnAction(listener);

        return file;
    }

    /**
     * Creates the Edit menu along with its various options
     * @return edit A JMenuItem for "Edit"
     */
    private Menu buildEditMenu(){
        //Creates the edit menu
        Menu edit = new Menu("Edit");

        //Creates color menu item
        EditText = new MenuItem("Text Color: Red");
        BlackText = new MenuItem("Text Color: Black");

        //Add item to menu
        edit.getItems().addAll(EditText, BlackText);

        //Hook up listener with menu item
        EditListener listener = new EditListener();
        EditText.setOnAction(listener);
        BlackText.setOnAction(listener);

        return edit;

    }

    /**
     * Creates the Help menu along with its various options
     * @return helpM A JMenuItem for "Help"
     */
    private Menu buildHelpMenu(){
        //Create the menu
        Menu helpM = new Menu("Help");

        //The items in the menu
        How2 = new MenuItem("About MiniTextEditor");
        Info = new MenuItem("Licensing Information");

        // Add the items with a separator
        helpM.getItems().addAll(How2, new SeparatorMenuItem(), Info);

        //Create the listener for the options in the help menu.
        HelpList listener = new HelpList();
        How2.setOnAction(listener);
        Info.setOnAction(listener);

        return helpM;
    }

    /**
     * Creates the text area.
     */
    private void buildTextA() {
        // make text area
        TextA = new TextArea();

        TextA.setWrapText(true);

        TextA.setPrefColumnCount(20);
        TextA.setPrefRowCount(20);

        // set styles through setColor
        setTextAreaColor("Black");
    }

    private void setTextAreaColor(String color){

        String style = "*{" +
                "-fx-pref-column-count: 20;" +
                "-fx-pref-row-count: 20;" +
                "-fx-font: 12px \"monospace\";" +
                "-fx-text-fill:" + color + ";" +
                "}";
        TextA.setStyle(style);

    }

    /**
     * This is for printing the help menu.
     */
    private void HelpMenu() {
        //Displays this message
        showInfoDialog("This program is a barebones text editor. You can type text into the text area\n" +
                "and change its color.  You can save your data in the text area as an encryted file,\n" +
                "this can be chosen when saving.  Also when opening a file this program will unencrypt\n" +
                "your file so it is readable.");
    }

    /**
     * This is for printing the information menu
     */
    private void InfoMenu(){
        //This statement is shown
        showInfoDialog("MiniTextEditor\nAuthour: Grant Person\nEdition: 1.0\nDate 3/08/12");
    }

    /**
     * This class is for the action listener in the help menu.
     * @author GrantPerson
     *
     */
    private class HelpList implements EventHandler<javafx.event.ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent e) {
            //If the About MiniTextEditor is clicked
            if(e.getSource() == How2){
                //Prompt to show help menu.
                HelpMenu();
            }
            else{
                //Any other action (i.e Licensing Info), prints it's this method.
                InfoMenu();
            }
        }
    }

    /**
     * This class is for the action listener in the file menu.
     * @author GrantPerson
     *
     */
    private class MyListener implements EventHandler<javafx.event.ActionEvent> {

        @Override
        public void handle(javafx.event.ActionEvent e) {
            //If the Exit but is select

            if (e.getSource() == ExitFile)
                System.exit(0);
                //If open file is selected
            else if(e.getSource() == OpenFile){
                // Show a dialog to allow the user to choose files
                FileChooser of = new FileChooser();  //set starting point
                of.setInitialDirectory(new File("./"));

                //Next few lines are for prompting the user for which type of encryption
                //they would like to open the file with. Sets selection to the option chose in the drop down
                //JOptionPane window.
                File result = of.showOpenDialog(null);
                if (result == null){
                    showInfoDialog("You did not select a file.");
                    return;
                }
                String[] SaveSelections = {"+1 Encryption", "Reverse Encryption","Normal"};
                String initial = "Normal";

                ChoiceDialog<String> dialog = new ChoiceDialog<>(initial, Arrays.asList(SaveSelections));
                dialog.setTitle("File Open Options");
                dialog.setContentText("How is this file encrypted?");
                Optional<String> choice = dialog.showAndWait();

                if (!choice.isPresent()){
                    showInfoDialog("You did not select a read method.");
                    return;
                }

                String selection = choice.get();

                //Initialize the file
                FN = result;

                //This determines what to set the TypeOfEncryption to depending on the users choice.
                if(selection.equalsIgnoreCase("Reverse Encryption"))
                    TypeOfEn = 1;
                else if(selection.equalsIgnoreCase("+1 Encryption"))
                    TypeOfEn = 0;
                else
                    TypeOfEn = 2;

                //Show the file
                TextA.setText(showFile());

            }
            else if(e.getSource() == SaveOp1){
                //Opens window for choosing file
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("./"));
                File result = fc.showSaveDialog(null);
                if(result != null){
                    // Get the files name the the user input for what type of encryption.
                    FN = result;
                    TypeOfEn = 0;
                    writeFile();
                }
            }
            else if(e.getSource() == SaveOp2){
                //Opens window for choosing file
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("./"));
                File result = fc.showSaveDialog(null);
                if(result != null){
                    // Get the files name the the user input.
                    FN = result;
                    TypeOfEn = 1;
                    writeFile();
                }
            }

            else if(e.getSource() == SaveOp3){
                //Opens window for choosing file
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("./"));
                File result = fc.showSaveDialog(null);
                if(result != null){
                    // Get the files name the the user input.
                    FN = result;
                    TypeOfEn = 2;
                    writeFile();
                }
            }
        }
    }

    /**
     * This class is the action listener for the Edit menu item.
     * @author GrantPerson
     *
     */
    private class EditListener implements EventHandler<javafx.event.ActionEvent> {

        @Override
        public void handle(javafx.event.ActionEvent e) {
            //For changing the text color to red
            if(e.getSource() == EditText){
                setTextAreaColor("red");
            }
            //Changing text to black
            if(e.getSource() == BlackText){
                setTextAreaColor("black");
            }
        }
    }

    /*
     * This method is for writing the file depending on what encryption method is chosen.
     */
    public void writeFile(){
        //Checks if the save type is 1+
        if(TypeOfEn == 0){
            try{
                //Gets the content from the text area and saves into a string
                String Content = TextA.getText();

                //This string is for the end product after the encryption
                String EnContent = "";

                //This loop will read every char of the Content string and add one to the
                //ASCII number.
                for(int i = 0; i< Content.length(); i++){
                    if(Character.isLetter(Content.charAt(i))){
                        char NL = (char) (Content.charAt(i)+1);
                        EnContent = EnContent + NL;
                    }
                    //If its not a character we skip it.
                    else
                        EnContent = EnContent + Content.charAt(i);
                }

                //Write the file
                FileWriter outFile = new FileWriter(FN);
                outFile.write(EnContent);

                // Close the file
                outFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
                System.exit(0);
            }
        }

        //Checks if the save type is reverse
        if(TypeOfEn == 1){
            try{
                //Gets the content from the text area and saves into a string
                String Content = TextA.getText();

                //This string is for the end product after the encryption
                String EnContent = "";

                //This loop will read every char of the Content string from last to first,
                //then add them to the new encrypted string.
                int length = Content.length();
                for(int i = length-1; i>= 0; i--){
                    char NL = (char) (Content.charAt(i));
                    EnContent = EnContent + NL;
                }

                //Prints the file
                FileWriter outFile = new FileWriter(FN);
                outFile.write(EnContent);

                // Close the file
                outFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
                System.exit(0);
            }
        }

        //Checks if the save type is normal
        if(TypeOfEn == 2){
            try{
                //Just writes text if no encryption is needed
                FileWriter outFile = new FileWriter(FN);
                outFile.write(TextA.getText());

                // Close the file
                outFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            } catch (IOException e) {
                System.out.println("IO Error: " + e.getMessage());
                System.exit(0);
            }
        }
    }

    public String showFile(){
        // Put all selections into one string
        String s = "";
        String s2 = "";

        //These if else statements are used to determine which method is needed to be use to open the file
        if(TypeOfEn == 0){
            try{
                //Scanner for reading file
                Scanner file = new Scanner(FN);
                while (file.hasNextLine())
                {
                    // Read the data, save into one string
                    s = file.nextLine().toString();

                    //Goes through the string decrypting it, and copying it to a new string
                    for(int i = 0; i < s.length();i++){
                        if(Character.isLetter(s.charAt(i))){
                            char S =(char) (s.charAt(i)-1);
                            s2 = s2 + S;
                        }
                        else
                            s2 = s2 + s.charAt(i);
                    }
                    s2 = s2 + "\n";
                }
                // Close the file
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            }
        }

        //This will read the file unreversing the text and returning it.
        else if(TypeOfEn == 1){
            try{
                Scanner file = new Scanner(FN);
                while (file.hasNextLine())
                {
                    // Read the data
                    s = file.nextLine().toString();

                    for(int i = (s.length()-1); i >= 0;i--){
                        s2 = s2 + (char)(s.charAt(i));
                    }
                    s2 = s2 + "\n";
                }
                // Close the file
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            }
        }
        //If it is normal simply just print out each line
        else{
            try{
                Scanner file = new Scanner(FN);
                while(file.hasNextLine()){
                    s2 = s2 + file.nextLine() +"\n";
                }
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: " + e.getMessage());
                System.exit(0);
            }
        }

        return s2;
    }

    /**
     * Creates a simple alert pop-up to display a once-off message
     * @param message The message to display
     */
    private void showInfoDialog(String message){
        Alert a = (new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK));
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // stretch box to show all of message
        a.show();
    }

    /**
     *@param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Call the text editor
        launch(args);
    }

}
