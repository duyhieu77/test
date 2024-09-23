public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new Employee(8, "Peter", "Tan", 2500);
        employees[1] = new Employee(9, "Peter", "Parker", 2000);
        employees[2] = new Employee(10, "Peter", "Pan", 3000);

        for (Employee e : employees) {
            System.out.println(e);
        }

        Employee maxSalaryEmployee = employees[0];
        for (Employee e : employees) {
            if (e.getAnnualSalary() > maxSalaryEmployee.getAnnualSalary()) {
                maxSalaryEmployee = e;
            }
        }

        System.out.println("Employee with the max annual salary:");
        System.out.println(maxSalaryEmployee);
        System.out.println("Annual Salary: " + maxSalaryEmployee.getAnnualSalary());

        Employee e1 = employees[0];
        System.out.println(e1);

        e1.setSalary(999);
        System.out.println(e1);
        System.out.println("id is: " + e1.getID());
        System.out.println("firstname is: " + e1.getFirstName());
        System.out.println("lastname is: " + e1.getLastName());
        System.out.println("salary is: " + e1.getSalary());
        System.out.println("name is: " + e1.getName());
        System.out.println("annual salary is: " + e1.getAnnualSalary());

        e1.raiseSalary(10);
        System.out.println("After raise:");
        System.out.println(e1);
    }
}