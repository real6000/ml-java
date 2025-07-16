package me.brokeski.core;

import java.util.Random;

/**
 * Utility class for random number generation, including Gaussian sampling
 * and array shuffling — useful for initialization or data mixing.
 *
 * 2025
 */

public class RandomUtil {

    private static final Random random = new Random();


    /**
     * Returns a random number from a Gaussian distribution with mean 0 and stddev 1.
     *
     * @return Random Gaussian number.
     */
    public static double gaussian(){
        return random.nextGaussian();
    }

    /**
     * Returns a random double between 0.0 and 1.0.
     *
     * @return Random uniform double.
     */
    public static double uniform(){
        return random.nextDouble();
    }

    public static void shuffle(int[] arr){
        for(int i = arr.length -1; i > 0; i--){
            int j = random.nextInt(i+1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
