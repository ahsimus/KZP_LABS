package matviishyn_lb6;

import java.util.ArrayList;

public class Shelf<T extends Data> {


    Shelf() {
        list = new ArrayList<T>();
    }

    ArrayList<T> list;

    public void add(T t) {
        list.add(t);
    }



    public void remove(int index) {
        list.remove(index);
    }


    public void weight() {
        int sumWeight = 0;
        for (T t : list)
            sumWeight += t.getWeight();
        System.out.println("Weight of books on this shelf is: " + sumWeight + "kg");
    }


    public T findMin() {
        T min = list.get(0);
        for (T t : list)
            if (t.compareTo(min) == 1)
                min = t;
        return min;
    }

}
