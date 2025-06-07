package ej5;

public class TestRemove {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(0, 5);
        list.add(1, 8);
        list.add(2, 4);
        list.add(3, 10);

        System.out.println("Lista antes de eleminar un elemento: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(1);

        System.out.println("Lista despues de eleminar un elemento: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}