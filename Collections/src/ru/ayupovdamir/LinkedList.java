package ru.ayupovdamir;

/**
 * 27.02.2021
 * 19. LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList<D> implements List<D> {

    public static class Node<C> {
        C value;
        Node<C> next;

        Node(C value) {
            this.value = value;
        }

        public Node() {

        }
    }

    /*public class LinkedListIterator implements Iterator {
        private Node current;

        public LinkedListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public int next() {
            int value = current.value;
            current = current.next;

            return value;
        }
    }*/

    private Node<D> first;

    private Node<D> last;

    private int count;

    @Override
    public void add(D value) {
        Node<D> newNode = new Node<D>(value);
        if (first == null) {
            this.first = newNode;
        } else {
            // следующий после последнего - новый узел
            last.next = newNode;
        }
        // новый узел теперь последний
        this.last = newNode;
        this.count++;
    }

    @Override
    public D get(int index) {

        // если индекс = 4
        if (index < count && index > -1) {
            Node<D> current = this.first;
            // отсчитываем элементы
            // i = 0, 1, 2, 3, 4
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }
        System.err.println("Вышли за пределы списка");
        return null;
    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index > count - 1) {
            System.err.println("Вы вышли за пределы листа");
            return;
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node<D> node = findNodeBeforeByIndex(index);
            Node<D> tmp = findByIndex(index);
            node.next = tmp.next;
        }
        count--;

    }

    @Override
    public int indexOf(D element) {
        Node current = this.first;
        for (int i = 0; i < count; i++){
            if(current.value == element){
                return i;
            }
            else {
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(D element) {
        int lastIndex = -1;
        Node current = this.first;
        for (int i = 0; i < count; i++){
            if(current.value == element){
                lastIndex = i;
                current = current.next;
            }
            else {
                current = current.next;
            }
        }
        return lastIndex;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(D element) {
        boolean isContains = false;
        Node current = this.first;
        for (int i = 0; i < count; i++){
            if(current.value == element){
                isContains = true;
            }
            else {
                current = current.next;
            }
        }
        return isContains;
    }

    @Override
    public void removeFirst(D element) {
        // a -> b -> c -> d -> null
        // ^
        // f

        // current = a

        Node current = first;

        // removeFirst(a)
        if (current.value == element) {
            // a -> b -> c -> d -> null
            //      ^
            //      f
            first = first.next;
            return;
        }

        // removeFirst(c)
        // a -> b -> c -> d -> null
        //      ^
        //      c
        while (current.next != null && current.next.value != element) {
            current = current.next;
        }

        // a -> b -> -> d -> null
        //      ^
        //      c
        if (current.next != null) {
            current.next = current.next.next;
        }

        if (current.next == null) {
            this.last = current;
        }

        count--;
    }

    @Override
    public void removeLast(D element) {
        // TODO: реализовать
    }

    @Override
    public void removeAll(D element) {
        Node<D> temp = first, prev = null;

        // If head node itself holds the key
        // or multiple occurrences of key
        while (temp != null && temp.value == element)
        {
            first = temp.next; // Changed head
            temp = first; // Change Temp
        }

        // Delete occurrences other than head
        while (temp != null)
        {
            // Search for the key to be deleted,
            // keep track of the previous node
            // as we need to change 'prev->next'
            while (temp != null && temp.value != element)
            {
                prev = temp;
                temp = temp.next;
            }

            // If key was not present in linked list
            if (temp == null)
                return;

            // Unlink the node from linked list
            prev.next = temp.next;

            // Update Temp for next iteration of outer loop
            temp = prev.next;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

   /* @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }*/

    private Node findByIndex(int index) {
        if (index < 0 || index > count - 1) {
            return null;
        }
        int tmpIndex = 0;
        if (first == null) {
            return null;
        }

        if (index == 0) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        return null;
    }

    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > count - 1) {
            return null;
        }

        int count = 0;
        Node node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}
