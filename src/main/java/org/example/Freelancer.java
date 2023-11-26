package org.example;

public class Freelancer extends BaseWorker implements Kivy{
//region полев
    private Bid workBid;

    private double payment;

//region конструкторов
    private Freelancer(String name, double salary, double payment, Bid workBid) {
        super(name, salary);
        this.workBid = workBid;
        this.payment = payment;
    }


// region методов
    public static Freelancer createFreelancer(String name, double salary, double payment, Bid workBid){
        return  new Freelancer(name, salary, payment,workBid);
    }

    /**
     * Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
     */
    @Override
    void monthlySalary() {
        // «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
        if(workBid.equals(Bid.HOURLY_RATE)){
            this.payment += (getSalary() * 8) * 30;
        }
    }

// поле гетеров
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

    @Override
    public String toString() {
        return super.toString()+ ", payment: "+ payment +", workbid: "+ workBid;
    }


    @Override
    public double kivyMany() {
        return payment;
    }
}
