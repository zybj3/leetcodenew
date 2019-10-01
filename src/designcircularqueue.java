public class designcircularqueue {
    class MyCircularQueue {
        private int maxsize;
        private int cursize;
        private Node head;
        private Node tail;
        class Node{

            private int num;

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            private Node next;

            public int getNum() {
                return num;
            }
            public void setNum(int num) {
                this.num = num;
            }
        }

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.maxsize = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
            if (head==null){
                head = new Node();
                head.setNum(value);
                tail = head;
            }
            else {
                Node node = new Node();
                node.setNum(value);
                tail.next = node;
                tail = node;
            }

            cursize+=1;
            return true;


        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            head = head.next;
            cursize-=1;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return head.num;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()){
                return -1;
            }
            return tail.num;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head==null;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return cursize==maxsize;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
