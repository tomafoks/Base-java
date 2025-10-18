package storage;

import model.Resume;

public interface Storage {

    public void save(Resume r);
    
    public Resume get(String uuid);
    
    public void delete(String uuid);
    
    public void update(Resume r);
    
    public Resume[] getAll();
    
    public void clear();

    public int size();
}
