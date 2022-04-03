package ua.edu.sumdu.j2se.KaplunDanil.tasks;

public class LinkedTaskList extends AbstractTaskList{
    private Node head;

    public class Node
    {
        public Task task;
        public Node next;

        public Node(Task task) {
            this.task = task;
            next = null;
        }
    }

    public LinkedTaskList(){
        head = null;
        size = 0;
    }

    public void add(Task task)
    {
        if(task == null){
            throw new NullPointerException("null argument!");
        }

        Node newNode = new Node(task);
        Node currentNode = head;

        if (size == 0) {
            head = newNode;
        }
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;

    }

    public boolean remove(Task task) {
        if(task == null) {
            throw new NullPointerException(
                    "Task object parameter has null value!"
            );
        }

        Node currentNode = head;

        if(size == 0) {
            return false;
        }

        if(currentNode.task.equals(task)){
            head = currentNode.next;
            size--;
            return true;
        }

        while(currentNode.next != null) {
            if(currentNode.next.task.equals(task)) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    public int size()
    {
        return size;
    }

    public Task getTask(int index)
    {
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("invalid index!");
        }

        Node currentNode = head;
        int counter = 0;

        while(currentNode.next != null){

            if(index == counter){
                break;
            }
            counter++;
            currentNode = currentNode.next;
        }

        return currentNode.task;
    }


}
