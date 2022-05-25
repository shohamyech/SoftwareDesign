package sortingClean;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Random;

public class MainApp {
    static Weld weld = new Weld();
    static WeldContainer container = weld.initialize();

    public static void main(String[] args) {
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.runAlgorithms();
    }

    @Produces
    public static @Named("quadraticSort") SortingAlgorithm<Integer> quadraticGenerator() {
        return container.select(InsertionSort.class).get();
    }

    @Produces
    public static @Named("nlognSort") SortingAlgorithm<Integer> nlognGenerator() {
        return container.select(QuickSort.class).get();
    }

    @Produces
    public int numberOfElements() {
        return 10000;
    }

    @Produces
    private static @Named("AnySort") SortingAlgorithm<Integer> makeRandomSortingAlgorithm() {
        Random random = new Random(System.currentTimeMillis());

        switch (random.nextInt(4)) {
            case 0:
                return container.select(QuickSort.class).get();
            case 1:
                return container.select(MergeSort.class).get();
            case 2:
                return container.select(BubbleSort.class).get();
            case 3:
                return container.select(InsertionSort.class).get();
            default:
                return null;
        }
    }

}
