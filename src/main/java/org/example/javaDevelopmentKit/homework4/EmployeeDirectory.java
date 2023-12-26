package org.example.javaDevelopmentKit.homework4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private Employee employee;
    private List<Employee> employeeList;
    public EmployeeDirectory(){
        this.employeeList = new ArrayList<>();
    }

//----------------------------------------------------------region methods
    //* Добавить метод, который ищет сотрудника по стажу (может быть список)

    //* Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)

    //* Добавить метод, который ищет сотрудника по табельному номеру

    //* Добавить метод добавление нового сотрудника в справочник

    public void addEmployee(String phoneNumber, String name, int experience){
        employeeList.add(new Employee(phoneNumber, name, experience));
    }
    public List<Employee> findEmployeesByExperience(int experience){
        List<Employee> employees = new ArrayList<>();
        for(Employee employee : employeeList){
            if(employee.getExperience() == experience){
                employees.add(employee);
            }
        }
        return employees;
    }

    public List<String> findPhoneNumbersByName(){
        return null;
    }

    public Employee findEmployeeByEmployeeId(){
        return null;
    }

}
