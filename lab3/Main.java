// Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // === Задание 1: демонстрация своей HashTable ===
        HashTable<String, Integer> table = new HashTable<>(8);
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);
        table.put("two", 22); // перезапись значения

        System.out.println("size=" + table.size());      // 3
        System.out.println("get(two)=" + table.get("two")); // 22
        System.out.println("remove(one)=" + table.remove("one")); // 1
        System.out.println("isEmpty=" + table.isEmpty()); // false

        // === Задание 2 (вариант 3): HashMap для заказов ===
        OrderManager manager = new OrderManager();
        Order order1 = new Order("19.10.2025", List.of("Laptop", "Mouse"), "In progress");
        Order order2 = new Order("19.10.2025", List.of("iPhone"), "In delivery");

        manager.addOrder(1001, order1);
        manager.addOrder(1002, order2);

        System.out.println(manager.getOrder(1001));
        manager.updateStatus(1001, "Canceled");
        manager.removeOrder(1002);
        System.out.println(manager.getOrder(1001));
        System.out.println(manager.getOrder(1002)); // null
    }
}
