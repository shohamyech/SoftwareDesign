package WS1.Observers;

public class MSPressObserver implements Observer<Integer> {

    public MSPressObserver() {
        System.out.println("MSPressObserver was created");
    }

    @Override
    public void update(Integer data) {
        System.out.println("MonitoringScreen: pressure = " + data + " millibars");
    }
}
