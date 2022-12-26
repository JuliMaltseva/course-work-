import java.util.Objects;

public class Employee {
    private String surname; //фамилия
    private String name; //имя
    private String middleName; //отчество
    private int department;
    private double salary;
    private final long id = count;
    private static long count = 1L;

    public Employee(String surname, String name, String middleName, int department, double salary) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        if (isDepartment(department)) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Введено не корректное значение отдела.");
        }
        this.salary = salary;
        count++;
    }

    private boolean isDepartment(int department) {
        if (department < 1 && department > 5) {
            return false;
        }
        return true;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник №" + id + ", ФИО: " + surname + " " + name + " " + middleName +
                " отдел: " + department +
                " размер оклада составляет: " + String.format("%.2f", salary) + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


