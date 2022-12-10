package custom_linkedList;
public class MyLinkedList<T> {

    Node<T> head;
    private int length = 0;

    MyLinkedList() {
        this.head = null;
    }

    void add(T data) {
        Node<T> temp = new Node<>(data);
        if (this.head == null) {
            head = temp;
        }
        else {
            Node<T> X = head;
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }
        length++;
    }


    void add(int position, T data) {
        if (position == 1) {
            Node<T> temp = head;
            head = new Node<T>(data);
            head.next = temp;
            return;
        }
        Node<T> temp = head;
        Node<T> prev = new Node<T>(null);
        while (position - 1 > 0) {
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = new Node<T>(data);
        prev.next.next = temp;
    }

    void remove(T key) {
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> temp = head;
        boolean exists = false;

        if (head.data == key) {
            head = head.next;
            exists = true;
        }
        while (temp.next != null) {
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (!exists
                && String.valueOf(temp.data).equals(
                String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        if (exists) {
            length--;
        } else {
            System.out.println(
                    "Given value is not in list");
        }
    }


    void clear() {
        head = null;
        length = 0;
    }

    boolean empty() {return head == null;}

    int size() { return this.length; }


    public String toString() {
        StringBuilder S = new StringBuilder("[");
        Node<T> X = head;
        if (X == null)
            return S + "]";
        while (X.next != null) {
            S.append(String.valueOf(X.data)).append(",");
            X = X.next;
        }
        S.append(String.valueOf(X.data));
        return S + "]";
    }
}

