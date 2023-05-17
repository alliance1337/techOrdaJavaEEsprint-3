package kz.bitlab.techorda.db;

import java.util.ArrayList;

public class DBUtil {
    private static final ArrayList<Worker> workers = new ArrayList<>();

    static {
        workers.add(new Worker("Ilyas", "Zhuanyshev", "IT", 600000));
        workers.add(new Worker("Erik", "Zhuanyshev", "IT", 400000));
        workers.add(new Worker("Serik", "Zhuanyshev", "IT", 300000));
        workers.add(new Worker("Berik", "Zhuanyshev", "IT", 500000));
        workers.add(new Worker("Zhanik", "Zhuanyshev", "IT", 200000));
    }

    public static ArrayList<Worker> getWorkers(){
        return workers;
    }
}
