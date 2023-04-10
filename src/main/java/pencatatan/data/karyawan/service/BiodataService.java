package pencatatan.data.karyawan.service;

import pencatatan.data.karyawan.entity.Biodata;

public interface BiodataService {

        //add
        public void add(String name, String jenis_kelamin, String umur, String alamat);    
        //getAll
        public void getAll();
        //get by id
        public Biodata getById(Integer id);
        //update
        public void update(Integer id, String name, String jenis_kelamin, String umur, String alamat);
        //delete
        public void delete(Integer id);
    }
    
