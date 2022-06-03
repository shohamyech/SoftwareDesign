package WS1.Observers;

public class MSTempObserver implements Observer<Integer> {
    public MSTempObserver() {
        System.out.println("MSTempObserver was created");
    }

    @Override
    public void update(Integer data) {

        System.out.println("MonitoringScreen: temperature = " + data + " Celsius");
    }
}
