package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public void clear() {
    }

    public void save(Resume r) {
    }

    public Resume get(String uuid) {
        return null;
    }

    public void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return new Resume[0];
    }

    public int size() {
        return 0;
    }
}
