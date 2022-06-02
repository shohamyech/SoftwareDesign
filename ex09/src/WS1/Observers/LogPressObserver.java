package WS1.Observers;

public class LogPressObserver implements Observer<Integer>{
    @Override
    public void update(Integer data) {
        System.out.println("Log: pressure = "+data+" millibars");

    }
}
