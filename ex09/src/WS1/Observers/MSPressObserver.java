package WS1.Observers;

public class MSPressObserver implements Observer<Integer>{

    @Override
    public void update(Integer data) {
        System.out.println("MonitoringScreen: pressure = "+data+" millibars");
    }
}
