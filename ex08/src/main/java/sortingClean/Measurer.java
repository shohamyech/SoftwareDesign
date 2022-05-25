package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Measurer {

    long total_time = 0, bubble_time = 0, insert_time = 0, quick_time = 0, merge_time = 0;
    long bubble_count = 0, insert_count = 0, quick_count = 0, merge_count = 0;
    long current_time;

    @Pointcut("@annotation(Measurable) && execution(* *(..))")
    private void selectMeasurable() {
    }

    @Pointcut("execution(void sortingClean.AlgorithmRunner.runAlgorithms(..))")
    private void selectRunner() {
    }

    @After("selectRunner()")
    public void afterRunner(JoinPoint jp) {
        System.out.println("Total time of running all sort functions was " + total_time + " ms");
        System.out.println("In detail:");
        if (bubble_time != 0)
            System.out.println("Function sort in BubbleSort ran " + bubble_count + " times and took in total " + bubble_time + " ms");
        if (quick_time != 0)
            System.out.println("Function sort in QuickSort ran " + quick_count + " times and took in total " + quick_time + " ms");
        if (merge_time != 0)
            System.out.println("Function sort in MergeSort ran " + merge_count + " times and took in total " + merge_time + " ms");
        if (insert_time != 0)
            System.out.println("Function sort in InsertionSort ran " + insert_count + " times and took in total " + insert_time + " ms");
    }


    @Before("selectMeasurable()")
    public void beforeMeasurable(JoinPoint jp) {
        current_time = System.currentTimeMillis();
    }

    @After("selectMeasurable()")
    public void afterMeasurable(JoinPoint jp) {
        current_time = System.currentTimeMillis() - current_time;
        total_time += current_time;

        String current_algo = jp.getThis().toString();
        current_algo = current_algo.split("\\.")[1].split("@")[0];

        switch (current_algo) {
            case "QuickSort":
                quick_time += current_time;
                quick_count++;
                break;
            case "BubbleSort":
                bubble_time += current_time;
                bubble_count++;
                break;
            case "InsertionSort":
                insert_time += current_time;
                insert_count++;
                break;
            case "MergeSort":
                merge_time += current_time;
                merge_count++;
                break;
        }
    }

}
