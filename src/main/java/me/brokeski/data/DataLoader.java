package me.brokeski.data;

import java.util.Collections;
import java.util.List;

/**
 * DataLoader utility for batching and shuffling datasets.
 *
 * 2025
 */
public class DataLoader<T> {

    private final List<T> dataset;

    public DataLoader(List<T> dataset) {
        this.dataset = dataset;
    }

    /**
     * Shuffles the dataset in place.
     */
    public void shuffle() {
        Collections.shuffle(dataset);
    }

    /**
     * Returns a batch of the dataset starting from index with given size.
     *
     * @param start Starting index.
     * @param batchSize Number of elements in batch.
     * @return Sublist batch.
     */
    public List<T> getBatch(int start, int batchSize) {
        int end = Math.min(start + batchSize, dataset.size());
        return dataset.subList(start, end);
    }

    /**
     * Returns dataset size.
     */
    public int size() {
        return dataset.size();
    }
}
