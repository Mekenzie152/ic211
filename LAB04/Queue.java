public class Queue {
    //Node.java moved into Queue as an inner class of Quene
    private static class Node {
        public String data;
        public Node next;

        public Node(String d, Node n) {
            data = d;
            next = n;
        }
    }


    private Node front;//Front of the queue
    private Node rear;//End of the queue

    //Initalizng queue
    public Queue() {
        front = null;//initalizing the beggining of the queue
        rear = null;//initalizing the end of the queue
    }

    //adds s to the back of the queue
    public void enqueue(String s) {
        Node newNode = new Node(s, null);//creating a new list to add to the front of it
        if (empty()) {// set the font and back to the only data if there is only one peice of data
            front = newNode;
            rear = newNode;
        } else {//set the new data the end of the list and link the end to the rear
            rear.next = newNode;
            rear = newNode;
        }
    }

    //removes and returns string from the front of the queue
    public String dequeue() {
        if (empty()) {
            System.out.println("Queue is empty");
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    //returns true of the queue is empty
    public boolean empty() {
        return front == null;
    }


}
