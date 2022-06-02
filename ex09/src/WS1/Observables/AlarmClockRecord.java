package WS1.Observables;

public class AlarmClockRecord {
    private int interval;
    private int remainingTime;
    private AlarmListener itsAlarmListener;

    public AlarmClockRecord(int interval, AlarmListener itsAlarmListener) {
        this.interval = interval;
        this.itsAlarmListener = itsAlarmListener;
        remainingTime = 0;
    }


    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public AlarmListener getItsAlarmListener() {
        return itsAlarmListener;
    }

    public int getInterval() {
        return interval;
    }
}
