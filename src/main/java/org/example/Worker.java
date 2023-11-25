package org.example;

public class Worker extends BaseWorker{
    private Bid workbid;
    public Worker(String name, double salary, double payment, Bid workbid) {
        super(name, salary, payment);
        this.workbid = workbid;
    }

    @Override
    void payment() {
        System.out.println("im worker");
    }
//поле методов
    @Override
    void workBid() {

    }
//поле гетеров
    public Bid getWorkbid() {
        return workbid;
    }
}
