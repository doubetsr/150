package Lab12;
/*  Starter code of Linked data structure Lab
 *  CSIT 150 
 *  This source file contains the class meant to 
 *       test the implementation of the Linked list
 *  There is an accompanying lab handout to go with this code
 *  Provided by C.Anderson
 *  REVISED 11-15-15
 *
 *   Revised by S Harms
 *  April 2017
 */
/**
 *
 * @author andersoncl4
 */
public class ListDriver {
    
    public ListDriver()
    {
        LinkedList lyrics = new LinkedList("Unknown Song");
        lyrics.addElement("If there's a bustling in the hedgerow, don't be alarmend now. ");
        lyrics.addElement("It's just spring cleaning for the may queen. ");
        lyrics.addElement("Yes, there are two paths you can go by but in the long run. ");
        lyrics.addElement("There's still time to change the road you're on. ");
        
        System.out.println("\n"+lyrics.toString());
        
        //The test below can be uncommented at the time indicated in the handout
    /*
        //Test1:
        System.out.println("\n\n\"Performed by ????????\"  is in list:"+lyrics.isInList("Performed by ????????")+"\n");
        
        //Test2:
        System.out.println("There are "+lyrics.length()+" items in the list "+lyrics.getLabel()+"\n");
        
        //Test3:
        System.out.println("\"Performed by ????????\"  is in list:"+lyrics.isInList("Performed by ????????"));
        lyrics.addElementAtHead("Performed by ????????");
        System.out.println("\"Performed by ????????\"  is in list:"+lyrics.isInList("Performed by ????????")+"\n");
        System.out.println(lyrics.toString()+"\n");
        
        //Test4:
        System.out.println("\"Performed by ????????\"  is in list:"+lyrics.isInList("Performed by ????????"));
        lyrics.pop();
        System.out.println("\"Performed by ????????\"  is in list:"+lyrics.isInList("Performed by ????????")+"");
        lyrics.addElementAtHead("Performed by LedZepplin");
        System.out.println("\"Performed by LedZepplin\"  is in list:"+lyrics.isInList("Performed by ????????")+"\n");
        System.out.println(lyrics.toString()+"\n");
      
        //Test5:
        lyrics.remove(2);
        System.out.println("\n"+lyrics.toString()+"\n\n");
        
        //Test6:
        lyrics.addElement("It's just spring cleaning for the may queen. ", 2);
        System.out.println("\n"+lyrics.toString()+"\n\n");
   */  
        
        
        
        
    }
    
    
    public static void main(String[] args)
    {
        new ListDriver();
    }
    
}
