package pencatatan.data.karyawan.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import pencatatan.data.karyawan.entity.Biodata;
//import pencatatan.data.karyawan.repository.BiodataRepository;
import pencatatan.data.karyawan.repository.impl.BiodataRepositoryImpl;
import pencatatan.data.karyawan.util.DatabaseUtil;
public class BiodataRepositoryImplTest {
    //Datasource
    private static HikariDataSource dataSource;

    //Book repo
    private BiodataRepositoryImpl biodataRepository;

    @BeforeEach 
    void setupDB(){
        dataSource =  DatabaseUtil.getDataSource();
        biodataRepository = new BiodataRepositoryImpl(dataSource);
    }

    @Test
    void testAddBiodata(){
        Biodata biodata = new Biodata();

        //set value
        biodata.setName("Cahaya Ilahi");
        biodata.setJenisKelamin("Laki-laki");
        biodata.setUmur("17 Tahun");
        biodata.setAlamat("Subang");

        //add biodata
        biodataRepository.add(biodata);

}
    @Test
    void testGetAllBiodata() {
        Biodata[] list = biodataRepository.getAll();
    }

    @AfterEach
        void tearDown(){
            dataSource.close();
        }

}
