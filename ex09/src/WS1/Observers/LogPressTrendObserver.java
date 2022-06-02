package WS1.Observers;

import WS1.Nimbus1.Trend;

public class LogPressTrendObserver implements Observer<Trend>{
    @Override
    public void update(Trend data) {
        System.out.println("Log: pressure trend = " + data.toString());

    }
}
