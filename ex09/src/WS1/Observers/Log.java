package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class Log {

    private WeatherMonitoringSystem ws;

    public Log(WeatherMonitoringSystem ws) {
        this.ws = ws;
        displayPressure();
        displayPressureTrend();
    }

    public void displayPressure()
    {
        ws.addPressureObserver(new LogPressObserver());
    }

    public void displayPressureTrend()
    {
        ws.addPressureTrendObserver(new LogPressTrendObserver());
    }
}
