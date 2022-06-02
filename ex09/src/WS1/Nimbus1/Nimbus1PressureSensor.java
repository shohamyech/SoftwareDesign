package WS1.Nimbus1;

import WS1.Observables.AlarmListener;
import WS1.Observables.Sensor;

public class Nimbus1PressureSensor extends Sensor{
    public Nimbus1PressureSensor(String type, int interval) {
        super(type, interval);
    }

    @Override
    protected int read() {
        return RandomSupplier.getRnd().nextInt();
    }
}

