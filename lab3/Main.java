public class Main {
    public static void main(String[] args) {

        HashTable<String, Integer> table = new HashTable<>(10);
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);

        System.out.println(table.get("two"));
        table.remove("two");
        System.out.println(table.size());
        System.out.println(table.isEmpty());

        EmployeeManager manager = new EmployeeManager();

        Employee emp1 = new Employee("Иванов Иван", "Разработчик", 120000);
        Employee emp2 = new Employee("Петров Пётр", "Тестировщик", 90000);

        manager.addEmployee(101, emp1);
        manager.addEmployee(102, emp2);

        System.out.println(manager.getEmployee(101));
        System.out.println(manager.getEmployee(102));

        manager.updatePosition(101, "Старший разработчик");
        manager.updateSalary(102, 95000);

        System.out.println(manager.getEmployee(101));
        System.out.println(manager.getEmployee(102));

        manager.removeEmployee(102);
        System.out.println(manager.getEmployee(102));
    }
}