public class MyVeryOwnListMain {
    public static void main(String[] args){
        MyList<String> myList = new MyList<>();
        myList.add("Horacio");
        myList.add("Ernesto");
        myList.add("Fer");

        for(MyList<String>.MyNode<String> current = myList.getFirst(); current != null; current = current.getNext()){
            System.out.println(current.getValue());
        }

        myList.sort(String.class, MyList.ASC);

        for(MyList<String>.MyNode<String> current = myList.getFirst(); current != null; current = current.getNext()){
            System.out.println(current.getValue());
        }

        myList.sort(String.class, MyList.DESC);

        for(MyList<String>.MyNode<String> current = myList.getFirst(); current != null; current = current.getNext()){
            System.out.println(current.getValue());
        }

    }
}
