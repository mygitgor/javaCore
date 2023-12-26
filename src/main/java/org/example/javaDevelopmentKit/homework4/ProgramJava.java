package org.example.javaDevelopmentKit.homework4;
import java.util.List;
public class ProgramJava {

    public static void main(String[] args) {

         //* Создать справочник сотрудников
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addEmployee("44082124","gor",1);
        employeeDirectory.addEmployee("41258545","sargis",2);
        employeeDirectory.addEmployee("42584532","sergio",3);
        employeeDirectory.addEmployee("45099322","gustavo",2);

        List<Employee> employeesWithExperience5 = employeeDirectory.findEmployeesByExperience(3);
        System.out.println(employeesWithExperience5);


    }
}
