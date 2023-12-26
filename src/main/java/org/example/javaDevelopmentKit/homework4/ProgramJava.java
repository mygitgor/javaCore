package org.example.javaDevelopmentKit.homework4;
import java.util.List;
public class ProgramJava {

    public static void main(String[] args) {

         //* Создать справочник сотрудников
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addEmployee(1,"44082124","gor",1);
        employeeDirectory.addEmployee(2,"41258545","sargis",2);
        employeeDirectory.addEmployee(3,"42584532","gor",3);
        employeeDirectory.addEmployee(4,"45099322","gustavo",2);

        List<Employee> employeesWithExperience2 = employeeDirectory.findEmployeesByExperience(2);
        System.out.println(employeesWithExperience2);
        List<String> employeesWithNumberPhone = employeeDirectory.findPhoneNumbersByName("gor");
        System.out.println(employeesWithNumberPhone);
        Employee employeeWithId2 = employeeDirectory.findEmployeeByEmployeeId(2);
        System.out.println(employeeWithId2);

    }
}
