public class MyList<T> {
    private MyNode<T> first;
    private MyNode<T> last;

    public static final int ASC = 0;
    public static final int DESC = 1;

    public MyList() {
    }

    public void add(T element){
        if(first == null){
            first = new MyNode<>(element);
            last = first;
        }else{
            MyNode<T> myNode = new MyNode<>(element);
            myNode.previous = last;
            last.next = myNode;
            last = myNode;
        }
    }

    public void sort(Class clazz, int order){
        if(clazz.equals(String.class)){
            if(first != null){
                for(MyNode<T> current = first.getNext(); current != null; current = current.getNext()){
                    for(MyNode<T> ithNode = current.previous; ithNode != null && ithNode != current; ithNode = ithNode.getPrevious()){
                        String currentVal = (String) ithNode.getValue();
                        String ithVal = (String) current.getValue();
                        if(order == ASC){
                            if(compare(currentVal, ithVal) == 1){
                                if(ithNode == first){
                                    first = current;
                                }
                                if(current == last){
                                    last = ithNode;
                                }
                                ithNode.next = current.next;
                                if(current.next != null){
                                    current.next.previous = ithNode;
                                }
                                current.next = ithNode;
                                current.previous = ithNode.previous;
                                if(ithNode.previous != null){
                                    ithNode.previous.next = current;
                                }
                                ithNode.previous = current;
                                ithNode = current;

                            }else if(compare(currentVal, ithVal) == 0){
                                if(ithNode == last){
                                    last = current;
                                }
                                if(ithNode.next != null){
                                    ithNode.next.previous = current;
                                }
                                ithNode.next = current;
                                current.previous = ithNode;
                            }
                        }else if(order == DESC){
                            if(compare(currentVal, ithVal) == -1){
                                if(ithNode == first){
                                    first = current;
                                }
                                if(current == last){
                                    last = ithNode;
                                }
                                ithNode.next = current.next;
                                if(current.next != null){
                                    current.next.previous = ithNode;
                                }
                                current.next = ithNode;
                                current.previous = ithNode.previous;
                                if(ithNode.previous != null){
                                    ithNode.previous.next = current;
                                }
                                ithNode.previous = current;
                                ithNode = current;

                            }else if(compare(currentVal, ithVal) == 0){
                                if(ithNode == last){
                                    last = current;
                                }
                                if(ithNode.next != null){
                                    ithNode.next.previous = current;
                                }
                                ithNode.next = current;
                                current.previous = ithNode;
                            }
                        }
                    }
                }
            }
        }
    }

    private int compare(String s1, String s2){
        int i;
        for(i = 0; i < s1.length() && i < s2.length(); i++){
            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }else if(s2.charAt(i) > s1.charAt(i)){
                return -1;
            }
        }
        if(s1.length() > s2.length()){
            return 1;
        }else if(s2.length() > s1.length()){
            return -1;
        }else{
            return 0;
        }
    }

    public MyNode<T> getFirst() {
        return first;
    }

    public MyNode<T> getLast() {
        return last;
    }

    public class MyNode<T> {
        private T value;
        private MyNode<T> next;
        private MyNode<T> previous;

        public MyNode() {
        }

        public MyNode(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public MyNode<T> getNext() {
            return next;
        }

        public void setNext(MyNode<T> next) {
            this.next = next;
        }

        public MyNode<T> getPrevious() {
            return previous;
        }

        public void setPrevious(MyNode<T> previous) {
            this.previous = previous;
        }
    }
}
