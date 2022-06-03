package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class Log {

    private WeatherMonitoringSystem ws;

    public Log(WeatherMonitoringSystem ws) {
        this.ws = ws;
        System.out.println("Log was created");
        displayPressure();
        displayPressureTrend();
    }

    public void displayPressure() {
        ws.addPressureObserver(new LogPressObserver());
        System.out.println("LogPressObserver observes pressure");
    }

    public void displayPressureTrend() {
        ws.addPressureTrendObserver(new LogPressTrendObserver());
        System.out.println("LogPressTrendObserver observes pressure trend");
    }
}
