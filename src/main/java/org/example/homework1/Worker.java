package org.example.homework1;

public class Worker extends  BaseWorker implements Kivy{
//region полев
    private Bid workBid;
    private double payment;

//region конструкторов
    private Worker(String name, double salary, Bid bid,double payment){
        super(name, salary);
        this.workBid = bid;
        this.payment = payment;
    }

//поле методов
    public static Worker getWorker(String name, double salary, Bid bid, double payment){
        return  new Worker(name, salary, bid, payment);
    }

    /**
     * Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
     */
    @Override
    void monthlySalary() {
        // «среднемесячная заработная плата = fool ставка»,
        if (workBid.equals(Bid.FOOL_TIME)){
            this.payment += getSalary() * 30;
        }
    }

//поле гетеров
    public Bid getWorkbid() {
        return workBid;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setWorkBid(Bid workBid) {
        this.workBid = workBid;
    }


    @Override
    public String toString() {
        return super.toString() + ", workBid: "+ workBid + ", payment: " + payment;
    }

    @Override
    public double kivyMany() {
        return payment;
    }
}
