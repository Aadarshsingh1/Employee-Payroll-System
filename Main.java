import java.util.ArrayList;
import java.util.List;
// starting point of employee class
class Employee {
    // employee name and per hour rate declare
    private int employeeId;
    private String name;
    private double hourlyRate;
    // set value of employee id name and hour rate take input from input

    public Employee(int employeeId, String name, double hourlyRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    // function to get employee id 

    public int getEmployeeId() {
        return employeeId;
    }
    // function for set employee id 

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
      // function for get name 
    public String getName() {
        return name;
    }
    // function for set name

    public void setName(String name) {
        this.name = name;
    }
    // function for get hour rate

    public double getHourlyRate() {
        return hourlyRate;
    }
    // function for set hour rate

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

// Attadence class start hare
class Attendance {
    // variavle declare employee id and worked hour by employee
    private int employeeId;
    private int hoursWorked;
   // set value of emplohyee id and hour worked
    public Attendance(int employeeId, int hoursWorked) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
    }

    // function for get employee id

    public int getEmployeeId() {
        return employeeId;
    }
    // function for set employee id

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    // function for get hour 

    public int getHoursWorked() {
        return hoursWorked;
    }
    // function for set hour 
    

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
// class payroll start hare

class PayrollSystem {
    // mapping of employee and attadence
    private List<Employee> employees;
    private List<Attendance> attendanceList;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
        this.attendanceList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void markAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    public void calculatePayroll() {
        for (Employee emp : employees) {
            double totalSalary = 0;
            for (Attendance att : attendanceList) {
                if (emp.getEmployeeId() == att.getEmployeeId()) {
                    totalSalary += att.getHoursWorked() * emp.getHourlyRate();
                }
            }
            // Perform tax deduction or other calculations if needed
            // Generate payslip
            generatePayslip(emp, totalSalary);
        }
    }

    private void generatePayslip(Employee employee, double totalSalary) {
        // Generate and print payslip details
        System.out.println("Payslip for employee : " + employee.getName());
        System.out.println("Total Salary: $" + totalSalary);
        // Add other details like tax deductions, net salary, etc.
        System.out.println("---------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        // Adding employees
        Employee emp1 = new Employee(1, "Aadarsh Singh", 10.0);
        Employee emp2 = new Employee(2, "Sourabh dhangar", 11.0);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        // Marking attendance
        Attendance att1 = new Attendance(1, 20); // John Doe worked 40 hours
        Attendance att2 = new Attendance(2, 15); // Jane Smith worked 35 hours
        payrollSystem.markAttendance(att1);
        payrollSystem.markAttendance(att2);

        // Calculating and generating payslips
        payrollSystem.calculatePayroll();
    }
}
