package org.example.javaDevelopmentKit.homework3;

public class TuoNumbers <T,U>{
    private T first;
    private U second;
    public  TuoNumbers(T t, U u){
      this.first = t;
      this.second = u;
    }


    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "TuoNumbers{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
