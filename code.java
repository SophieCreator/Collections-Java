import java.util.*;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        //Task 1
        HashMap<Integer, String> input = new HashMap<>();
        input.put(1, "First");
        input.put(2, "Second");
        input.put(3, "Third");
        HashMap<String, Integer> output = exchangeKeyAndValue(input);
        System.out.println("Task 1\nNew hashmap: " + output);

        //Task 2
        timeDifferenceOfArrayListAndLinkedList();
        
        //Task 3
        ArrayList<String> array = new ArrayList<>();
        array.add("Cow");
        array.add("Dog");
        array.add("Dog");
        array.add("Dog");
        array.add("Cat");
        array.add("Cat");
        array.add("Dog");
        array.add("Cat");
        array.add("Cow");
        array.add("Cow");
        array.add("Cow");
        array.add("Cat");
        removeDuplicate(array);
        //removeDuplicateCheating(array);
        System.out.println("Task 3\nAn array without duplicates " + array);
    }

    //Задание 1: Реализуй метод, который поменяет ключи и значения в HashMap местами.
    // На вход в метод поступает HashMap<Interger, String>, надо вернуть HashMap<String, Integer>.
    // Выведи результат.
    public static HashMap<String, Integer> exchangeKeyAndValue(HashMap<Integer, String> input) {
        HashMap<String, Integer> output = new HashMap<>();
        Set<Integer> keys = input.keySet();
        for (Integer key : keys){
            output.put(input.get(key), key);
        }
        return output;
    }

    //Задание 2: Реализуй метод, в котором создаются ArrayList, LinkedList и заполняются 1 000 000 случайными
    // элементами одного и того же типа. После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
    // Замерь время для ArrayList и LinkedList. Сравни результаты и предположи, почему они могут отличаться.

    //Предположение: 
    public static void timeDifferenceOfArrayListAndLinkedList () {
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();
        Random random = new Random();

        //**** arrayAddingTime ****//
        long arrayAddingTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            array.add(random.nextInt());
        }
        long arrayAddingTime = System.currentTimeMillis() - arrayAddingTimeStart;

        //**** linkedAddingTime ****//
        long linkedAddingTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linked.add(random.nextInt());
        }
        long linkedAddingTime = System.currentTimeMillis() - linkedAddingTimeStart;

        System.out.println("Task 2\nLinkedList adding differs from ArrayList one on " +
                (linkedAddingTime - arrayAddingTime) + " ms\nlinked adding time is " + linkedAddingTime +
                " ms\narray adding time is " + arrayAddingTime + "ms\n");

        //**** arraySeekingTime ****//
        long arraySeekingTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int tmp = array.get(random.nextInt(999999));
        }
        long arraySeekingTime = System.currentTimeMillis() - arraySeekingTimeStart;

        //**** linkedSeekingTime ****//
        long linkedSeekingTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int tmp = linked.get(random.nextInt(999999));
        }
        long linkedSeekingTime = System.currentTimeMillis() - linkedSeekingTimeStart;

        System.out.println("LinkedList seeking differs from ArrayList one on " +
                (linkedSeekingTime - arraySeekingTime) + " ms\nlinked seeking time is " + linkedSeekingTime + " ms\narray seeking time is " +
                arraySeekingTime + "ms");
    }

    //Задание 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты,
    // не используя метод contains(). Можно использовать другие коллекции, которые были изучены на уроке.
    
public static void removeDuplicateCheating(ArrayList<String> array) {
        if (array.isEmpty()){
            return;
        }
        LinkedHashSet<String> target = new LinkedHashSet<String>(array);
        array.clear();
        array.addAll(target);
    }

    public static void removeDuplicate(ArrayList<String> array) {
        if (array.isEmpty()){
            return;
        }
        HashMap<String, Boolean> checker = new HashMap<>();
        int i = 0;
        while (i != array.size()){
            if (checker.get(array.get(i)) == null){
                checker.put(array.get(i), true);
                i++;
            } else {
                array.remove(i);
            }
        }
    }
}
