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

    public void addEmployee(int id,String phoneNumber, String name, int experience){
        employeeList.add(new Employee(id,phoneNumber, name, experience));
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

    public List<String> findPhoneNumbersByName(String name){
        List<String> phones = new ArrayList<>();
        for (Employee employee : employeeList){
            if(employee.getName().equals(name)){
                phones.add(employee.getPhoneNumber());
            }
        }
        return phones;
    }

    public Employee findEmployeeByEmployeeId(int id){
        for (Employee employee : employeeList){
            if(employee.getEmployeeId() == id){
                return employee;
            }
        }
        return null;
    }

}
