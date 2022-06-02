package WS1.Observables;

import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Nimbus1.Trend;
import WS1.Observers.Observer;

public class PressureTrendSensor extends Observable<Trend> implements Observer<Integer> {
    private int lastReading1;
    private int lastReading2;
    private int lastReading3;
    private Trend pressureState;
    private Trend lastState;

    public PressureTrendSensor(Nimbus1PressureSensor pressureSensor) {
        pressureSensor.addObserver(this);
    }

    public Trend calc()
    {

        if (lastReading1 < lastReading2 && lastReading2 < lastReading3)
            pressureState = Trend.FALLING;
        else if (lastReading1 > lastReading2 && lastReading2 > lastReading3)
            pressureState = Trend.RISING;
        else
            pressureState = Trend.STABLE;
        return pressureState;
    }
    public void check() {
        pressureState = calc();
        if (lastState != pressureState)
        {
            notifyObservers(pressureState);
            lastState = pressureState;
        }
    }

    @Override
    public void update(Integer data) {
        lastReading3 = lastReading2;
        lastReading2 = lastReading1;
        lastReading1 = data;
        check();
    }
}
