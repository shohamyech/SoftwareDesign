package WS1.Nimbus1;

import WS1.Observables.Sensor;

import java.util.random.RandomGenerator;

public class Nimbus1TemperatureSensor extends Sensor {

    public Nimbus1TemperatureSensor(String type, int interval) {
        super(type, interval);
    }

    public static int boundedNextInt(RandomGenerator rng, int origin, int bound) {
        int r = rng.nextInt();
        if (origin < bound) {
            // It's not case (1).
            final int n = bound - origin;
            final int m = n - 1;
            if ((n & m) == 0) {
                // It is case (2): length of range is a power of 2.
                r = (r & m) + origin;
            } else if (n > 0) {
                // It is case (3): need to reject over-represented candidates.
                for (int u = r >>> 1;
                     u + m - (r = u % n) < 0;
                     u = rng.nextInt() >>> 1)
                    ;
                r += origin;
            } else {
                // It is case (4): length of range not representable as long.
                while (r < origin || r >= bound) {
                    r = rng.nextInt();
                }
            }
        }
        return r;
    }

    @Override
    protected int read() {
        return boundedNextInt(RandomSupplier.getRnd(), 0, 40);
    }
}
