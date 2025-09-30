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
    if (next.getValue().compareTo(line) == 0) {
      ListNode out = next;
      head = next.getNext();
      nodes--;
      return out;
    }
    while ((next.getNext()) != null) {

      if (lowerNext.compareTo(line) == 0) {
        ListNode done = next;
        beforeNext.setNext(done.getNext());
        nodes--;
        return done;
      }

      beforeNext = next;
      next = next.getNext();
      lowerNext = next.getValue();
    }
    if (lowerNext.compareTo(line) == 0) {
      ListNode done = next;
      beforeNext.setNext(null);
      nodes--;
      return done;
    }
    return null;
  }

  // precondition: the list has been initialized
  // postconditions: returns a string containing all values appended together with
  // spaces between.
  public String showValues() {
    if (head == null) {
      return "";
    }
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

  public void reverse() {
    ListNode curr = head;
    ListNode before = null;
    ListNode next = null;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(before);
      before = curr;
      curr = next;
    }
    head = before;
  }

  public void nReverse(int n) {
    ListNode curr = head;
    ListNode before = null;
    ListNode next = null;
    ListNode temp = new ListNode("", head);
    ListNode nHead = head;
    ListNode nEnd = temp;

    while (nHead != null) {
      ListNode temp2 = nHead;
      int c = 0;
      while (c < n && temp2 != null) {
        temp2 = temp2.getNext();
        c++;
      }

      if (c < n) {
        break;
      }
            // the following code exists in case one would like to reverse the remaining section of their linked list that is %n > 0
      /*if (c < n) {
        before = null;
        curr = nHead;

        for (int i = 0; i < c; i++) {

          next = curr.getNext();
          curr.setNext(before);
          before = curr;
          curr = next;
        }
        nEnd.setNext(before);
        nHead.setNext(curr);
        nEnd = nHead;
        nHead = curr;


      } else {*/

      before = null;
      curr = nHead;

      for (int i = 0; i < n; i++) {
      
        next = curr.getNext();
        curr.setNext(before);
        before = curr;
        curr = next;
      }
      nEnd.setNext(before);
      nHead.setNext(curr);
      nEnd = nHead;
      nHead = curr;

      

    }

    head = temp.getNext();
  }

}
