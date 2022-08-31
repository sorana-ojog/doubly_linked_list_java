public class DoublyLinkedList {
    Node start;
    Node end;
    class Node {
        int value;
        Node prev;
        Node next;
        Node(int d) {
            value = d; 
        }
    }
    public void pushRight(int value){
        Node n = new Node(value);
        if(start == null && end == null){
            start = n;
            end = n;
        }else{
            end.next = n;
            n.prev = end;
            end = n;
        }
    }
    public void pushLeft(int value){
        Node n = new Node(value);
        if(start == null && end == null){
            start = n;
            end = n;
        }else{
            n.next = start;
            start.prev = n;
            start = n;
        }
    }
    public void printElements(){
        Node n = start;
        while (n != null){
            System.out.print(n.value);
            n = n.next;
        }
        System.out.println();
    }
    public void printReversedElements(){
        Node n = end;
        while (n != null){
            System.out.print(n.value);
            n = n.prev;
        }
        System.out.println();
    }
    public void removeElementByValue(int n){
        Node tmp = start;
        while (tmp != null){
            if(tmp.value == n){
                 if(tmp.prev == null && tmp.next == null){
                    start = null;
                    end = null;
                //case in which the element to be removed is the start
                }else if(tmp.prev == null && tmp.next != null){
                    tmp.next.prev = null;
                    start = tmp.next;
                //case in which the element to be removed is the end
                }else if(tmp.prev != null && tmp.next == null){
                    tmp.prev.next = null;
                    end = tmp.prev;
                //case in which the element to be removed is neither the start or the end
                }else{
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
            }
            tmp = tmp.next;
        }
    }
    public void removeElement(Node n){
        //case in which there is only one element
        if(n.prev == null && n.next == null){
            start = null;
            end = null;
        //case in which the element to be removed is the start
        }else if(n.prev == null && n.next != null){
            n.next.prev = null;
            start = n.next;
        //case in which the element to be removed is the end
        }else if(n.prev != null && n.next == null){
            n.prev.next = null;
            end = n.prev;
        //case in which the element to be removed is neither the start or the end
        }else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }
    public Node searchElementByValue(int n){
        Node tmp = start;
        while (tmp != null){
            if(tmp.value == n){
                return tmp;
            }
            tmp = tmp.next;
        }
        System.out.println();
        return null;
    }
    public int start(){
        if(start == null) {
            throw new RuntimeException("Start is null.");
        }
        return start.value;
    }
    public int end(){
        if(end == null) {
            throw new RuntimeException("End is null.");
        }
        return end.value;
    }
    public static void main(String[] args) {
        var list = new DoublyLinkedList();
        // list.pushRight(1);
        // list.pushRight(2);
        // list.pushRight(3);
        // list.printElements();
        
        // list.pushLeft(1);
        // list.pushLeft(2);
        // list.pushLeft(3);
        // list.printReversedElements();
        
        list.pushRight(1);
        list.pushRight(2);
        list.pushRight(3);
        list.printElements();
        list.removeElementByValue(1);
        list.printElements();
        list.removeElement(list.searchElementByValue(2));
        list.printElements();
        System.out.println(list.start());
        System.out.println(list.end());
    }
}
