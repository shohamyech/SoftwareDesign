package WS1.Observers;

public class LogPressObserver implements Observer<Integer> {
    public LogPressObserver() {
        System.out.println("LogPressObserver was created");
    }

    @Override
    public void update(Integer data) {
        System.out.println("Log: pressure = " + data + " millibars");
    }
}
