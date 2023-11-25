package org.example;

public abstract class BaseWorker {
//поле полев
    private  String name;
    private  double salary;
    private double payment;

//поле конструкторов
    public BaseWorker(String name, double salary, double payment){
        this.salary = salary;
        this.name = name;
        this.payment = payment;
    }

//поле методов
    abstract void payment();
    abstract void workBid();

//поле гетеров
    public double getPayment() {
        return payment;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
