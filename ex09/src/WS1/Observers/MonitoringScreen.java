package WS1.Observers;

import WS1.Observables.WeatherMonitoringSystem;

public class MonitoringScreen {

    private WeatherMonitoringSystem ws;

    public MonitoringScreen(WeatherMonitoringSystem ws) {
        this.ws = ws;
        System.out.println("MonitoringScreen was created");
        displayTemperature();
        displayPressure();
    }

    public void displayPressure() {
        ws.addPressureObserver(new MSPressObserver());
        System.out.println("MSPressObserver observes pressure");
    }

    public void displayTemperature() {
        ws.addTemperatureObserver(new MSTempObserver());
        System.out.println("MSTempObserver observes temperature");
    }
}
