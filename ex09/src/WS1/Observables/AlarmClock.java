package WS1.Observables;

import java.util.ArrayList;

public class AlarmClock {
    public final int CLOCK_INTERVAL_MILLIS = 100;
    protected static AlarmClock instance = null;
    private final ArrayList<AlarmClockRecord> itsAlarmClockRecords = new ArrayList();

    protected AlarmClock() {
    }

    public static AlarmClock theInstance() {
        if (null == instance)
            instance = new AlarmClock();
        return instance;
    }

    protected void tic() {
        for (AlarmClockRecord rec : itsAlarmClockRecords)
        {
            if (rec.getRemainingTime() - CLOCK_INTERVAL_MILLIS < 0) {
                rec.getItsAlarmListener().wakeup();
                rec.setRemainingTime(rec.getInterval());
            }
            rec.setRemainingTime(rec.getRemainingTime() - CLOCK_INTERVAL_MILLIS);
        }
    }

    public void register(int interval, AlarmListener pal) {
        itsAlarmClockRecords.add(new AlarmClockRecord(interval, pal));
    }
}

