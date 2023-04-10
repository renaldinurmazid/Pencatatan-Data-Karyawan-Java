package pencatatan.data.karyawan.service.impl;
import pencatatan.data.karyawan.entity.Biodata;
import pencatatan.data.karyawan.repository.BiodataRepository;
import pencatatan.data.karyawan.service.BiodataService;

public class BiodataServiceImpl implements BiodataService {
    
    private BiodataRepository biodataRepository;

    public BiodataServiceImpl(BiodataRepository biodataRepository){
        this.biodataRepository = biodataRepository;
    }
    
    @Override
    public void add(String name, String jenis_kelamin, String umur, String alamat) {
        Biodata biodata = new Biodata(name, jenis_kelamin, umur, alamat);
       
        //add book
        biodataRepository.add(biodata);

        //return
        System.out.println("Biodata Added Succecfully : " + biodata.getName());
    }

    @Override
    public void getAll() {

        Biodata[] list = biodataRepository.getAll();

        //return
        for (Biodata biodata : list) {

        System.out.println(String.format("%d. %s -- %s -- %s -- %s", biodata.getId(), biodata.getName(), biodata.getJenisKelamin(),
            biodata.getUmur(), biodata.getAlamat()));
        }
    }

    @Override
    public Biodata getById(Integer id) {
        //get data
        Biodata biodata = biodataRepository.getById(id);

        //return
        System.out.println(String.format("%d. %s -- %s -- %s -- %s", biodata.getId(), biodata.getName(), biodata.getJenisKelamin(),
        biodata.getUmur(), biodata.getAlamat()));
        return biodata;
    }

    @Override

    public void update(Integer id, String name, String jenis_kelamin, String umur, String alamat) {

        Biodata biodata = biodataRepository.getById(id);
    if (biodata != null) {
        biodata.setName(name);
        biodata.setJenisKelamin(jenis_kelamin);
        biodata.setUmur(umur);
        biodata.setAlamat(alamat);
        biodataRepository.update(biodata);
    } else {
        System.out.println("Biodata with ID " + id + " not found.");
    }
}


    @Override
    public void delete(Integer id) {

        //Update Data
        boolean succes = biodataRepository.delete(id);//true or false
        
        if (succes){
        System.out.println("Biodata deleted succesfully :" + id);
        }else {
            System.out.println("Biodata deleted notsuccesfully :" + id);

        }
    }

}
