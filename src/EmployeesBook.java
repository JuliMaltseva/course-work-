public class EmployeesBook {
    private static Employee[] employees = new Employee[10];

    {
        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 300_000);
        employees[1] = new Employee("Петров", "Петр", "Петрович", 2, 105_000);
        employees[2] = new Employee("Павлов", "Павел", "Павлович", 2, 78_000);
        employees[3] = new Employee("Васильева", "Василиса", "Васильевна", 3, 45_000);
        employees[4] = new Employee("Ольгина", "Ольга", "Олеговна", 4, 130_000);
        employees[5] = new Employee("Фёдоров", "Федор", "Федорович", 4, 70_000);
        employees[6] = new Employee("Алексеев", "Алексей", "Алексеевич", 5, 125_000);
        employees[7] = new Employee("Сергеев", "Сергей", "Сергеевич", 5, 98_000);
        employees[8] = new Employee("Романов", "Роман", "Романович", 5, 88_000);
        employees[9] = new Employee("Егоров", "Егор", "Егорович", 5, 74_000);
    }

    //добавить сотрудника
    public static void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        System.out.println("Нет свободных вакансий.");
    }

    //удалить сотрудника по id
    public void removeEmployeeById(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employee.equals(employees[i])) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудника с таким id не найдено.");
    }

    //удалить сотрудника по ФИО
    public void removeEmployeeByFullName(String surname, String name, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && surname.equals(employees[i].getSurname())
                    && name.equals(employees[i].getName())
                    && middleName.equals(employees[i].getMiddleName())) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудника с такими ФИО не найдено.");
    }

    //вывести на печать всю инф по всем сотрудникам
    public void printAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //счет суммы ЗП по предприятию за месяц
    public double totalSalaryInMonth() {
        double total = 0d;
        for (Employee employee : employees) {
            if (employee != null) {
                total = total + employee.getSalary();
            }
        }
        return total;
    }

    //вывод на печать суммы ЗП за месяц
    public void printTotalSalaryInMonth() {
        System.out.println("Всего по предприятию ФОТ на месяц составляет: " +
                totalSalaryInMonth() + " руб. в месяц");
    }

    //поиск первого сотрудника с заполненными данными
    public int getFirstNullSalaryIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        throw new RuntimeException("Нет ни одного сотрудника");
    }

    //поиск сотрудника с минимальной зп
    public Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employees[getFirstNullSalaryIndex()];
        for (int i = getFirstNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null &&
                    employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    //поиск сотрудника с максимальной зп
    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[getFirstNullSalaryIndex()];
        for (int i = getFirstNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null &&
                    employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    //общее кол-во сотрудников с учетом пустых вакансий
    public int numberOfEmployees() {
        int totalEmployees = employees.length;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                totalEmployees = totalEmployees - 1;
            }
        }
        return totalEmployees;
    }

    //средняя зп
    public double middleSalaryInMonth() {
        double middleSalary = 0d;
        for (Employee employee : employees) {
            if (employee != null) {
                middleSalary = totalSalaryInMonth() / numberOfEmployees();
                return middleSalary;
            }
        }
        return totalSalaryInMonth() / employees.length;
    }

    //вывод на печать ФИО по всем сотрудникам
    public void printAllEmployeeFullName() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getSurname() + " " +
                        employees[i].getName() + " " + employees[i].getMiddleName());
            }
        }
    }

    //вывод на печать сотрудников нужного отдела
    public void printAllEmployeeByDepartment(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.println(employee);
            }
        }
    }

    public void toIndexTheSalary() {
        double indexationPercentage = 0.1;
        double indexationAmount = 0;
        double salaryWithIndexation = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                indexationAmount = employee.getSalary() * indexationPercentage;
                salaryWithIndexation = employee.getSalary() + indexationAmount;
            }
        }
    }


}
