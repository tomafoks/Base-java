package storage;

import java.util.Arrays;

import model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void doInsertResume(Resume r, int size) {
        int insertIndex = Arrays.binarySearch(storage, 0, size, r);
        if (insertIndex < 0) {
            insertIndex = (-(insertIndex) - 1);
            System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
            storage[insertIndex] = r;
        }
    }
}
