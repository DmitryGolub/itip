import java.util.HashMap;

public class EmployeeManager {

    private HashMap<Integer, Employee> employees;

    public EmployeeManager() {
        employees = new HashMap<>();
    }

    public void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void removeEmployee(int id) {
        employees.remove(id);
    }

    public void updatePosition(int id, String newPosition) {
        Employee employee = employees.get(id);
        if (employee != null) {
            employee.setPosition(newPosition);
        }
    }

    public void updateSalary(int id, double newSalary) {
        Employee employee = employees.get(id);
        if (employee != null) {
            employee.setSalary(newSalary);
        }
    }
}