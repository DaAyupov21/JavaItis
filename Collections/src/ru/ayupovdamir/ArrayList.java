package ru.ayupovdamir;

import java.util.Arrays;


public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;

    private T[] elements;
    private int count;

    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.count = 0;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < count) {
            return elements[index];
        }
        return null;
    }

    @Override
    public void removeAt(int index) {
        for ( int i = index; i < count - 1; i++){
            elements[i] = elements[i+1];
        }
        elements = Arrays.copyOf(elements, elements.length - 1);
        count--;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < elements.length; i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        System.err.println("Не найден элемент");
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        for (int i = elements.length - 1; i <= 0; i--){
            if(elements[i].equals(element)){
                return i;
            }
        }
        System.err.println("Не найден элемент");
        return -1;
    }

    @Override
    public void add(T element) {
        // если мы хотим добавить элемент, но массив уже заполнен
        if (isFull()) {
            resize();
        }
        addLast(element);
    }

    private void addLast(T element) {
        elements[count] = element;
        count++;
    }

    private boolean isFull() {
        return count == elements.length;
    }

    private void resize() {
        T newArray[] = (T[]) new Object [elements.length + elements.length / 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T element) {
        for (T i : elements) {
            if (i.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeFirst(T element) {
        int positionOfRemovingElement = -1;
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(element)) {
                positionOfRemovingElement = i;
                break;
            }
        }
        for (int i = positionOfRemovingElement; i < count; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    @Override
    public void removeLast(T element) {
        // TODO: реализовать
    }

    @Override
    public void removeAll(T element) {
        // TODO: реализовать
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}
