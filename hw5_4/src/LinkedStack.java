public class LinkedStack {

    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        // ваш код
        // возьмите value из последнего узла
        // назначьте предыдущий к последнему узлу последним узлом
        int tailValue = tail.getValue();
        Node prev = tail.getPrev();
        tail = prev;
        size--;
        return tailValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else return false;
    }

    public String toString() {
        // если есть элементы, пройдитесь по связному списку,
        // выводя элементы.
        // вывод должен быть в точности как в комментариях к main
        // при этом этот метод не должен менять стек!

        StringBuilder info = new StringBuilder();

        if (size == 0) {
            info.append("EMPTY");
        } else if (size == 1) {
            info.append(tail.getValue());
        } else {
            info.append(tail.getValue());
            Node prev = tail.getPrev();
            while (prev != null) {
                info.append(" -> ");
                info.append(prev.getValue());
                prev = prev.getPrev();
            }
        }

        return info.toString();

    }
}

