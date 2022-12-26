public class Main {
    public static void main(String[] args) {
        EmployeesBook employeesBook = new EmployeesBook();

        //список всех сотрудников
        System.out.println("список всех сотрудников:");
        employeesBook.printAllEmployee();
        System.out.println();

        //сумму затрат на зарплату в месяц
        System.out.println("сумму затрат на зарплаты в месяц:");
        employeesBook.printTotalSalaryInMonth();
        System.out.println();

        //найти сотрудника с минимальной зарплатой
        System.out.println("сотрудник с минимальной зарплатой:");
        System.out.println(employeesBook.getEmployeeWithMinSalary());
        System.out.println();

        //найти сотрудника с максимальной зарплатой
        System.out.println("сотрудник с максимальной зарплатой:");
        System.out.println(employeesBook.getEmployeeWithMaxSalary());
        System.out.println();

        //среднее значение зарплат
        System.out.println("Средняя зарплата по предприятию составляет: ");
        System.out.println(employeesBook.middleSalaryInMonth());
        System.out.println();

        //Ф. И. О. всех сотрудников
        System.out.println("Ф. И. О. всех сотрудников:");
        employeesBook.printAllEmployeeFullName();


        }

    }

