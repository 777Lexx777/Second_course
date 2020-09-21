package Lesson_8;

public class DoubleLinkedList implements GeekbrainsList{

    private NodeDouble head;

    @Override
    public void add(String o) {
        if (head == null) {
            head = new NodeDouble(o);
            return;
        }
        add( o, head );
    }

    private void add(String o, NodeDouble cur ) {

            if (cur.getNext() == null) {
                cur.setNext(new NodeDouble(o));
                cur.getNext().setPrevious(cur);
                return;
            }

        add( o, cur.getNext());
    }
    @Override
    public void remove(String o) {
        if (head == null) {
            return;
        } else if (head.getVal().equals(o)) {
                head.getNext().setPrevious(null);
                head = head.getNext();
                return;
        }
        remove(head, head.getNext(), o);
    }

    private void remove(NodeDouble prev, NodeDouble current, String o) {
        if (current.getNext() == null) {
            if (current.getVal().equals(o)) {
                prev.setNext(null);
                return;
            }
            return;
        }
        if (current.getVal().equals(o)) {
            prev.setNext(current.getNext());
            current.getNext().setPrevious(prev);

            return;
        }

        remove(current, current.getNext(), o);
    }

    private static class NodeDouble {
        private NodeDouble previous;
        private String val;
        private NodeDouble next;

        public NodeDouble(String val) { this(null, val, null);}

        public NodeDouble(NodeDouble previous) {
            this.previous = previous;
        }
        public NodeDouble(NodeDouble previous, String val, NodeDouble next) {
            this.previous = previous;
            this.val = val;
            this.next = next;
        }
        public String getVal() { return val; }

        public NodeDouble getNext() { return next; }

        public void setNext(NodeDouble next) { this.next = next;}

        public NodeDouble getPrevious() { return previous;}

        public void setPrevious(NodeDouble previous) { this.previous = previous; }

        @Override
        public String toString() {

            return "NodeDouble{" +
                    "previous=" +  ((previous != null) ? previous.getVal() : null) +
                    ", val='" + val + '\'' +
                    ", next= NodeDouble} -> {" + next ;
        }

    }
    @Override
    public String toString() {
        return "{" + "head=" + head + '}';
    }
}
