package test.storage;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.ArrayStorage;
class AbstractArrayStorageTest {
    final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    Resume r1 = new Resume();
    Resume r2 = new Resume();
    Resume r3 = new Resume();
    Resume r4 = new Resume();

    @BeforeEach
    void setUp() {
        r1.setUuid("uuid1");
        r2.setUuid("uuid2");
        r3.setUuid("uuid3");
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
    }

    @Test
    void clear() {
        ARRAY_STORAGE.clear();
        Assertions.assertEquals(0, ARRAY_STORAGE.size());
    }

    @Test
    void save() {
        r4.setUuid("uuid4");
        ARRAY_STORAGE.save(r4);
        Assertions.assertEquals(4, ARRAY_STORAGE.size());
    }

    @Test
    void get() {
        ARRAY_STORAGE.get(r1.getUuid());
    }

    @Test
    void delete() {
        ARRAY_STORAGE.delete(r3.getUuid());
        Assertions.assertEquals(2, ARRAY_STORAGE.size());
    }

    @Test
    void update() {
        ARRAY_STORAGE.update(r1);
        Assertions.assertEquals(ARRAY_STORAGE.get(r1.getUuid()), r1.getUuid());
    }

    @Test
    void getAll() {
    }

    @Test
    void size() {
    }
}