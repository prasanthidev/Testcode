package helper;

import helper.node.Node;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int length;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    SinglyLinkedList(int data) {
        this.head = new Node(data);
        this.tail = this.head;
        this.length ++;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if(length == 0) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            newNode.next = this.head.next;
            this.head = newNode;
        }
        length ++;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        if(length == 0) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        length ++;
    }

    public void insertAt(int data, int index) {

        if(length == 0) {
            insertAtHead(data);

        } else if (length < index) {
            insertAtTail(data);

        } else {
            // iterate till k-1 th position
            Node temp = this.head;
            for (int id = 0; id < index - 1; id++) {
                temp = temp.next;
            }

            // insert this new node
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        length ++;

    }

    public void deleteAtHead() {
        if(length > 0) {
            if (length ==1) {
                this.head = null;
                this.tail = this.head;
            } else {
                Node temp = this.head;
                this.head = this.head.next;

                temp.next = null;
            }

            length --;
        }
    }

    public void deleteAtTail() {
        if(length > 0) {
            if (length ==1) {
                this.deleteAtTail();

            } else {
                Node temp = this.head;

                while(temp.next != this.tail) {
                    temp = temp.next;
                }

                this.tail = temp;
                this.tail.next = null;
            }

            length --;
        }
    }

    public void deleteAtIndex(int index) {
        if (length > 0) {
            if(length == 1) {
                this.deleteAtHead();

            } else if(length < index) {
                this.deleteAtTail();

            } else {
                Node temp = this.head;
                for(int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }

                if(temp.next != null) {
                    temp.next = temp.next.next;
                    temp.next.next = null;
                }

            }
        }
    }

    public void deleteByKey(int data) {

    }

    @Override
    public String toString() {
        String linkedListString = "";

        Node temp = this.head;
        for (int i =0; i < length; i++) {
            linkedListString += temp.data + " -> ";

            temp = temp.next;
        }

        return linkedListString;
    }

}




// Java program to implement
// a Singly Linked List
/*
class LinkedList {

    // **************DELETION BY KEY**************

    // Method to delete a node in the LinkedList by KEY
    public static LinkedList deleteByKey(LinkedList list, int key)
    {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the List
        return list;
    }

    // **************DELETION AT A POSITION**************

    // Method to delete a node in the LinkedList by POSITION
    public static LinkedList deleteAtPosition(LinkedList list, int index)
    {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be deleted

        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(index + " position element deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required position
                // Unlink currNode from linked list
                prev.next = currNode.next;

                // Display the message
                System.out.println(index + " position element deleted");
                break;
            }
            else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be at currNode
        // Therefore the currNode shall not be null
        //
        // CASE 3: The index is greater than the size of the LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(index + " position element not found");
        }

        // return the List
        return list;
    }

    // **************MAIN METHOD**************

    // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {

        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION BY KEY******
        //

        // Delete node with value 1
        // In this case the key is ***at head***
        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        // Delete node with value 4
        // In this case the key is present ***in the middle***
        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        // Delete node with value 10
        // In this case the key is ***not present***
        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION AT POSITION******
        //

        // Delete node at position 0
        // In this case the key is ***at head***
        deleteAtPosition(list, 0);

        // Print the LinkedList
        printList(list);

        // Delete node at position 2
        // In this case the key is present ***in the middle***
        deleteAtPosition(list, 2);

        // Print the LinkedList
        printList(list);

        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(list, 10);

        // Print the LinkedList
        printList(list);
    }
}

 */
