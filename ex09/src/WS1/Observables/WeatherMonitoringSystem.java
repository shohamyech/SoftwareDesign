package WS1.Observables;

import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Nimbus1.Nimbus1TemperatureSensor;
import WS1.Nimbus1.Trend;
import WS1.Observers.Observer;

public class WeatherMonitoringSystem {

    private final Nimbus1PressureSensor pressureSensor;
    private final Nimbus1TemperatureSensor temperatureSensor;
    private final PressureTrendSensor trendSensor;


    protected static WeatherMonitoringSystem instance = null;

    public WeatherMonitoringSystem() {
        System.out.println("WeatherMonitoringSystem was created");
        this.pressureSensor = new Nimbus1PressureSensor("pressure", 1100);
        this.temperatureSensor = new Nimbus1TemperatureSensor("temperature", 700);
        this.trendSensor = new PressureTrendSensor(pressureSensor);
    }

    public static WeatherMonitoringSystem theInstance() {
        if(instance == null)
        {
            instance = new WeatherMonitoringSystem();
        }
        return instance;
    }

    public void addPressureObserver(Observer<Integer> observer)
    {
        pressureSensor.addObserver(observer);
    }

    public void addPressureTrendObserver(Observer<Trend> observer)
    {
        trendSensor.addObserver(observer);
    }

    public void addTemperatureObserver(Observer<Integer> observer)
    {
        temperatureSensor.addObserver(observer);
    }
}
