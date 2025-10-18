package storage;

import java.util.Arrays;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("Stack Overflow");
        } else if (searchIndexOfResume(r.getUuid()) != -1) {
            System.out.println("Resume" + r.getUuid() + "already exist!");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = searchIndexOfResume(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            resumeNotFoundMessage(uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int index = searchIndexOfResume(uuid);
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            size--;
        } else {
            resumeNotFoundMessage(uuid);
        }
    }

    public void update(Resume r) {
        int index = searchIndexOfResume(r.getUuid());
        if (index != -1) {
            storage[index].setUuid("update test");
        } else {
            resumeNotFoundMessage(r.getUuid());
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int searchIndexOfResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private void resumeNotFoundMessage(String uuid) {
        System.out.println("Resume " + uuid + " not found!");
    }
}
