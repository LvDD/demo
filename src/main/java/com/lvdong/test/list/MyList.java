package com.lvdong.test.list;

/**
 * Created by lvdong on 2017/5/28.
 */
public class MyList<T> {
    private Node<T> head;
    private Node<T> current;
    private static int length;

    static class Node<T> {
        private int index;
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(T data) {
        if (this.head == null) {
            head = new Node<>(data, null);
            head.index = length;
            current = head;
        } else {
            current.next = new Node<>(data, null);
            current.next.index = length;
            current = current.next;
        }
        length++;
    }

    public Node get() {
        return current;
    }

    public int size() {
        return length;
    }

    public String toString() {
        if (head == null) {
            return "";
        }
        current = head;

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (true) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(",");
                current = current.next;
            } else {
                break;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public void revese() {
        if (head == null) return;

        //两个变量保存节点
        Node<T> prev = null;
        Node<T> next = null;

        while (head.next != null){
            next = head.next;//保存下一个节点
            head.next = prev;//当前节点的指针指向前一个节点
            prev = head;//移动前一个节点的指针到当前节点
            head = next;//移动当前节点的指针到下一个节点
        }

        head.next = prev;
    }
}
