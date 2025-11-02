package storage;
import model.Resume;
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    public void doInsertResume(Resume r, int index) {
        storage[index] = r;
    }
}
