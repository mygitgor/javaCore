package org.example.homework1;

public abstract class BaseWorker implements Kivy{
//region полев
    private  String name;
    private  double salary;

//region конструкторов
    public BaseWorker(String name, double salary){
        this.salary = salary;
        this.name = name;
    }

//region методов
//Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
    abstract void monthlySalary();

//region гетеров
    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: "+ name + ", salary: "+ salary;
    }
}
