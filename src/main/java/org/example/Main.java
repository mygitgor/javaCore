package org.example;

public class Main {
    public static void main(String[] args) {

        BaseWorker[] workers = {
                Freelancer.createFreelancer("filip#1",20.8,0,Bid.HOURLY_RATE),
                Freelancer.createFreelancer("filip#2",20.8,0,Bid.HOURLY_RATE),
                Freelancer.createFreelancer("filip#3",20.8,0,Bid.HOURLY_RATE),
                Worker.getWorker("superWorker#1",50,Bid.FOOL_TIME,0),
                Worker.getWorker("superWorker#2",20,Bid.FOOL_TIME,0),
                Worker.getWorker("superWorker#3",35,Bid.FOOL_TIME,0)
        };


        Payment[] payments = {
                new Payment(10),
                new Payment(20),
                new Payment(30),
                new Payment(60),
                new Payment(80)
        };

        for (Payment payment:payments) {
            for (BaseWorker worker : workers) {
                worker.monthlySalary();
                if(payment.getPayment() < worker.kivyMany()){
                    System.out.println(worker.getName() +", " +worker.kivyMany());
                }
            }
        }




    }

    /**
     *1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).
     * а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
     * Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
     * б) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.
     * в) ** Реализовать интерфейсы для возможности сортировки массива/коллекции (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на урове базового типа и создайте свой уникальный компаратор.
     * г) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer), и реализовать возможность вывода данных с использованием foreach (подсказка: вам потребуется поработать с интерфейсом Iterable).
     */
}