package WS1.Observers;

public class MSTempObserver implements Observer<Integer>{
    @Override
    public void update(Integer data) {

        System.out.println("MonitoringScreen: temperature = "+data+" Celsius");
    }
}
