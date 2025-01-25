package task1;

/**
 * Created by Avazbek on 26/12/24.
 */
public class App {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.add(1);
        array.add(2);
        array.add(5);
        array.add(4);
        array.add(null);
        /*array.remove(2);*/
        System.out.println(array.size());
        System.out.println(array.toString());
    }
}
