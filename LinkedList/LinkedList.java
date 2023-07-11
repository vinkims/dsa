class LinkedList {
    
    // Create a node
    Node head;

    // Create a node
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert at the beginning
    public void insertAtBeginning(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    // Insert after a node
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");;
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = new Node(newData);
            return;
        }

        newNode.next = null;
        
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    // Delete a node
    void deleteNode(int position) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        // Find the key to be deleted
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If the key is not present
        if (temp == null || temp.next == null) {
            return;
        }

        // Remove the node
        Node next = temp.next.next;
        temp.next = next;
    }

    // Search a node
    boolean search(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Sort the linked list
    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // index points to the node next to current
                index = current.next;

                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    // Print the linked list
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.println(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertAtEnd(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAfter(linkedList.head.next, 5);

        System.out.println("Linked list: ");
        linkedList.printList();

        System.out.println("\nAfter deleting an element: ");
        linkedList.deleteNode(3);
        linkedList.printList();

        System.out.println();
        int item_to_find = 3;
        if (linkedList.search(linkedList.head, item_to_find)) {
            System.out.println(item_to_find + " is found");
        } else {
            System.out.println(item_to_find + " is not found");
        }

        linkedList.sortLinkedList(linkedList.head);
        System.out.println("\nSorted List: ");
        linkedList.printList();
    }
}