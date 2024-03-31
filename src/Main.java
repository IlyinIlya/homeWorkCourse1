import java.util.Arrays;
public class Main {
    private static Employee[] employee;
    private final static int numberOfEmployees = 10;
    public static void main(String[] args) {
        employee = new Employee[numberOfEmployees];
        EmployeeBook eBook = new EmployeeBook(numberOfEmployees);
        eBook.newEmployee(employee,1, "Булгакова",
                "София", "Леоновна", 32890.45f);
        eBook.newEmployee(employee,2, "Родина",
                "Александра", "Артемьевна", 31575.25f);
        eBook.newEmployee(employee,3, "Зайцева",
                "Елизавета", "Ивановна", 34099.09f);
        eBook.newEmployee(employee,4, "Демин",
                "Матвей", "Андреевич", 27829.36f);
        eBook.newEmployee(employee,5, "Румянцев",
                "Илья", "Никитич", 32547.41f);
        eBook.newEmployee(employee,2, "Лопатин",
                "Тимофей", "Викторович", 30776.91f);
        eBook.newEmployee(employee,1, "Котова",
                "Сафия", "Михайловна", 29791.22f);
        eBook.newEmployee(employee,5, "Федосеев",
                "Алексей", "Львович", 35112.69f);
        eBook.newEmployee(employee,4, "Смирнов",
                "Александр", "Александрович", 33001.15f);
        eBook.newEmployee(employee,3, "Кузьмина",
                "Мария", "Максимовна", 33553.82f);

        // Вывод информации по всем сотрудникам
        eBook.printEmployeeInfo(employee);
        // Расчет общей суммы по ЗП, поиск минимальной/максимальной ЗП, расчет средней ЗП
        System.out.println("Сотрудник с минимальной зарплатой: " + eBook.calculateMinSalary(employee));
        System.out.println("Сотрудник с максимальной зарплатой: " + eBook.calculateMaxSalary(employee));
        System.out.println("Средняя зарплата за месяц составляет: " + eBook.calculateAverageSalary(employee));
        // Вывод информации: ФИО сотрудников
        eBook.printEmployeeFullName(employee);
        // Расчет индексирования ЗП
        System.out.println("Если процент повышения зарплаты: " + eBook.salaryIndexIncrease(employee, 7) + "%, то:");
        eBook.printEmployeeInfo(employee);
        // Поиск минимальной/максимальной ЗП при задании фильтра по отделам
        int departmentID = 5;
        System.out.println("В отделе № " + departmentID + " минимальная зарплата сотрудника: "
                + eBook.calculateMinSalary(eBook.checkDepartment(employee, departmentID)));
        System.out.println("В отделе № " + departmentID + " максимальная зарплата сотрудника: "
                + eBook.calculateMaxSalary(eBook.checkDepartment(employee, departmentID)));
        // Расчет суммы ЗП при задании фильтра по отделу
        System.out.println("Сумма затрат на зарплаты в отделе № " + departmentID + " составляет: "
                + eBook.salaryCalculate(eBook.checkDepartment(employee, departmentID)));
        // Расчет средней ЗП при задании фильтра по отделу
        System.out.println("Средняя зарплата в отделе № " + departmentID + " составляет: "
                + eBook.calculateAverageSalary(eBook.checkDepartment(employee, departmentID)));
        // Расчет индексирования ЗП при задании фильтра по отделу
        System.out.println("Если процент повышения зарплаты: "
                + eBook.salaryIndexIncrease(eBook.checkDepartment(employee, departmentID), 9) + "%, то:");
        eBook.printEmployeeInfo(eBook.checkDepartment(employee, departmentID));
        // Вывод информации по всем сотрудником, исключая номер отдела
        eBook.printEmployeeInfoNoDep(eBook.checkDepartment(employee, departmentID));
        // Вывод информации по сотрудникам с ЗП меньше лимита
        float limitSalary = 33000.50f;
        eBook.findLessLimitCurrentSalary(employee, limitSalary);
        // Вывод информации по сотрудникам с ЗП меньше лимита
        eBook.findMoreLimitCurrentSalary(employee, limitSalary);

    }



}