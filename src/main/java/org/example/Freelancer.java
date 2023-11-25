package org.example;

public class Freelancer extends BaseWorker{
    private Bid workbid;

    public Freelancer(String name, double salary, double payment, Bid workbid) {
        super(name, salary, payment);
        this.workbid = workbid;
    }

    @Override
    void payment() {
        System.out.println("im Freelancer");
    }


    // «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,

// поле методов
    @Override
    void workBid() {

    }
// поле гетеров
    public Bid getWorkbid() {
        return workbid;
    }




}
