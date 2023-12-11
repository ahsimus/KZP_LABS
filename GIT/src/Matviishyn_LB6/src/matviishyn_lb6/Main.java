package matviishyn_lb6;

public class Main {

	public static void main(String[] args) {
        Shelf<? super Data> shelf = new Shelf<Data>();
        shelf.add(new Books(3));
        shelf.add(new Books(4));
        shelf.add(new Books(5));
        shelf.add(new Books(6));
        shelf.weight();
        Data book = shelf.findMin();
        System.out.print("The easiest book is: ");
        book.print();

    }

}
