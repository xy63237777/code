package day02;

import java.util.Iterator;

public class Queue<Item> {

        private Node first;

        private Node last;

        private int N = 0;

        private int number = 0;

        private class Node {
            Item Date;
            Node next;
            Node() {}
            Node(Item Date, Node next) {
                this.Date = Date;
                this.next = next;
            }
        }

        public boolean isEmpty() { return first == null; }

        public int size() { return N; }

        public void enqueue(Item Date) {
            Node temp = last;
            last = new Node(Date, null);
            if(isEmpty()) first = last;
            else temp.next = last;
            N++; number++;
        }

        public Item dequeue() {
            Item temp = first.Date;
            first = first.next;
            if(isEmpty()) last = null;
            N--; number++;
            return temp;
        }

        public QueueLinkIterator Iterator() { return new QueueLinkIterator(); }

        private class QueueLinkIterator implements Iterator<Item> {

            private int key = number;

            private Node first = Queue.this.first;

            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public Item next() {
                if (key != number) throw new UnsupportedOperationException();
                Item temp = first.Date;
                first = first.next;
                return temp;
            }

            @Override
            public void remove() {

            }
        }

    }



