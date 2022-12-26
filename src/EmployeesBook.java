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

    public static void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
        System.out.println("Нет свободных вакансий.");
    }

    public void removeEmployeeById(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employee.equals(employees[i])) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудника с таким id не найдено.");
    }

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

    public void printAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double totalSalaryInMonth() {
        double total = 0d;
        for (Employee employee : employees) {
            if (employee != null) {
                total = total + employee.getSalary();
            }
        }
        return total;
    }

    public void printTotalSalaryInMonth() {
        System.out.println("Всего по предприятию ФОТ на месяц составляет: " + totalSalaryInMonth() + " руб. в месяц");
    }

    public int getFirstNullSalaryIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                return i;
            }
        }
        throw new RuntimeException("Нет ни одного сотрудника");
    }

    public Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employees[getFirstNullSalaryIndex()];
        for (int i = getFirstNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public void printEmployeeWithMinSalary(){
        System.out.println(getEmployeeWithMinSalary());
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[getFirstNullSalaryIndex()];
        for (int i = getFirstNullSalaryIndex() + 1; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public void printEmployeeWithMaxSalary(){
        System.out.println(getEmployeeWithMaxSalary());
    }
    public int numberOfEmployees() {
        int totalEmployees = employees.length;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                totalEmployees = totalEmployees - 1;
            }
        }
        return totalEmployees;
    }

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

    public void printMiddleSalaryInMonth() {
        System.out.println("Всего ФОТ по предприятию составляет: " + middleSalaryInMonth() + " руб. в месяц");
    }

    public void printAllEmployeeFullName() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public void printAllEmployeeByDepartment(String department) {
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) {
                System.out.println(employee);
            }
        }
    }


}
