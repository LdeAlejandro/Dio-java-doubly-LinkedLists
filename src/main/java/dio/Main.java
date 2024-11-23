package dio;

public class Main {

    public static void main(String [] args){

        DoublyLinkedLists<String> minhaListaEncadeada = new DoublyLinkedLists();

        minhaListaEncadeada.add("c1");
        minhaListaEncadeada.add("c2");
        minhaListaEncadeada.add("c3");
        minhaListaEncadeada.add("c4");
        minhaListaEncadeada.add("c5");
        minhaListaEncadeada.add("c6");
        minhaListaEncadeada.add("c7");

        System.out.println(minhaListaEncadeada.toString());

        minhaListaEncadeada.remove(3);
        System.out.println(minhaListaEncadeada.toString());

        minhaListaEncadeada.add(3, "99");

        System.out.println(minhaListaEncadeada.toString());
        System.out.println(minhaListaEncadeada.get(3));
    }

}
