package pencatatan.data.karyawan.repository;

import pencatatan.data.karyawan.entity.Biodata;

public interface BiodataRepository {
    
    //add
    public void add(Biodata biodata);
    //Get all
    public Biodata[] getAll();
    //Get by id
    public Biodata getById(Integer id);
    //update
    public boolean update(Biodata biodata);
    //Delete
    public boolean delete(Integer id);
     
}
