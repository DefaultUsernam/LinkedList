/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList {

  // instance variables go here (think about what you need to keep track of!)
  private int nodes;
  private ListNode head;

  // constructors go here
  public LinkedList() {
    nodes = 0;
    head = null;
  }

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been added
  // and returned
  public ListNode addAValue(String line) {
    String lowerLine = line;
    lowerLine.toLowerCase();

    // if there's nothing in the list at all
    if (head == null && nodes == 0) {
      head = new ListNode(line, null);
      nodes++;
      return head;
    }

    // if we want to insert in the very beginning
    if (head.getValue().toLowerCase().compareTo(lowerLine) > 0) {
      ListNode front = new ListNode(line, head);
      head = front;
      nodes++;
      return front;
    }

    // otherwise
    else {
      ListNode next = head;
      ListNode beforeNext = head;
      while ((next.getNext() != null) && (next.getNext().getValue().toLowerCase().compareTo(lowerLine) < 0)) {
        beforeNext = next;
        next = next.getNext();
      }
      ListNode done = new ListNode(line, next.getNext());
      next.setNext(done);

      nodes++;
      return done;
    }
  }

  // precondition: the list has been initialized
  // postcondition: the ListNode containing the appropriate value has been deleted
  // and returned.
  // if the value is not in the list returns null
  public ListNode deleteAValue(String line) {
    ListNode next = head;
    ListNode beforeNext = head;
    String lowerNext = next.getValue();
    if (next.getValue().compareTo(line) == 0){
      ListNode out = next;
      head = next.getNext();
      nodes--;
      return out;
    }
    while ((next.getNext()) != null){

     if(lowerNext.compareTo(line) == 0) {
      ListNode done = next;
      beforeNext.setNext(done.getNext());
      nodes--;
      return done;
     }
    
beforeNext = next;
    next = next.getNext();
      lowerNext = next.getValue();
    }
  
      return null;
    } 

  

  // precondition: the list has been initialized
  // postconditions: returns a string containing all values appended together with
  // spaces between.
  public String showValues() {
    String returnString = "";
    ListNode nextNode = head;
    while (nextNode.getNext() != null) {
      returnString += (nextNode.getValue() + " ");

      nextNode = nextNode.getNext();
    }
    returnString += nextNode.getValue();
    return returnString;
  }

  // precondition: the list has been initialized
  // postconditions: clears the list.
  public void clear() {
    nodes = 0;
    head = null;
  }
}
