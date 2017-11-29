package Lab12;

/*  Starter code of Linked data structure Lab
 *  CSIT 150 
 *  This source file contains the code for  Linkedlist
 *      and  ListElement
 *
 *  Provided by C.Anderson
 *  REVISED 11-15-15
 *
 *  Revised by S Harms
 *  April 2017
 */

/**
 *
 * @author andersoncl4
 */
public class LinkedList {

    private String label;
    private ListElement firstItem;

    public LinkedList(String name) {
        label = name;
    }

    public boolean isEmpty() {
        if (firstItem == null)
            return true;
        return false;
    }

    public boolean addElement(String newElementText) {
        ListElement newElement = new ListElement(newElementText);
        if (isEmpty()) {
            firstItem = newElement;
            return true;
        } else {
            ListElement currentElement = firstItem;
            while (currentElement.hasNext()) {
                currentElement = currentElement.getNextItem();
            }
            currentElement.setNextItem(newElement);
            return true;
        }
    }//  end add element


    public String toString() {
        return label + "\n" + firstItem.toString();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ListElement getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(ListElement firstItem) {
        this.firstItem = firstItem;
    }



// end of LinkedList class
//////////////////////////////////////////////////
//  PRIVATE CLASS  ///////////////////////////////
//////////////////////////////////////////////////

    private class ListElement {

        private String itemText;
        private ListElement nextItem;

        public ListElement(String el) {
            itemText = el;
        }

        public boolean hasNext() {
            if (nextItem == null)
                return false;
            return true;
        }

        public String toString() {
            String content = itemText;
            if (hasNext())
                content += "\n" + nextItem.toString();
            return content;
        }

        public ListElement getNextItem() {
            return nextItem;
        }

        public String getItemText() {
            return itemText;
        }

        public void setItemText(String itemText) {
            this.itemText = itemText;
        }

        public void setNextItem(ListElement nextItem) {
            this.nextItem = nextItem;
        }

    }
}
