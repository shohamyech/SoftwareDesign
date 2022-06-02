package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    private WeatherMonitoringSystem ws;
    public MonitoringScreen(WeatherMonitoringSystem ws) {
        this.ws = ws;
        displayPressure();
        displayTemperature();
    }

    public void displayPressure()
    {
        ws.addPressureObserver(new MSPressObserver());
    }

    public void displayTemperature()
    {
        ws.addTemperatureObserver(new MSTempObserver());
    }
}
