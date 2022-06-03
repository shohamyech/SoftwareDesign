package WS1.Observables;

import WS1.Nimbus1.Nimbus1Clock;

public abstract class Sensor extends Observable<Integer> {
    protected int lastReading;
    protected int interval;
    protected String type;

    public Sensor(String type, int interval) {
        this.interval = interval;
        this.type = type;
        Nimbus1Clock.theInstance().register(interval, this::check);
        System.out.println(type + " registered to clock");
    }

    protected abstract int read();

    public void check() {
        int newRead = read();
        if (lastReading != newRead) {
            notifyObservers(newRead);
            lastReading = newRead;
        }
    }
}
