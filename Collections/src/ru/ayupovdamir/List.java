package ru.ayupovdamir;


public interface List<V> extends Collection<V> {
    /**
     * Получение элемента коллекции по индексу
     * @param index индекс элемента
     * @return элемент, размещенный под этим индексом. Если элемент не найден - возвращается -1
     */
    V get(int index);

    /**
     * Удаляет элемент по заданному индексу
     * @param index индекс удаляемого элемента
     */
    void removeAt(int index);

    /**
     * Возвращает индекс элемента (первое вхождение)
     * @param element элемент
     * @return позиция элемента, либо -1 если элемент не обнаружен
     */
    int indexOf(V element);

    /**
     * Возвращает индекс элемента (последнее вхождение)
     * @param element элемент
     * @return позиция элемента, либо -1 если элемент не обнаружен
     */
    int lastIndexOf(V element);
}
