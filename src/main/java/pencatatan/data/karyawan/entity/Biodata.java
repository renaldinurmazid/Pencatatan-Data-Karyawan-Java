package pencatatan.data.karyawan.entity;

public class Biodata {
  
    private Integer id;
    private String name;
    private String jenis_kelamin; 
    private String umur;
    private String alamat;

    //Constructur
    public Biodata() {

    }

    public Biodata(Integer id,String name, String jenis_kelamin, String umur, String alamat){
        this.id = id;
        this.name = name;
        this.jenis_kelamin = jenis_kelamin;
        this.umur = umur;
        this.alamat = alamat;
        
    }
    public Biodata(String name, String jenis_kelamin, String umur, String alamat) {
        this.name = name;
        this.jenis_kelamin = jenis_kelamin;
        this.umur = umur;
        this.alamat = alamat;
        
    }

    //Getter
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getJenisKelamin() {
        return jenis_kelamin;
    }
    public String getUmur() {
        return umur;
    }
    public String getAlamat() {
        return alamat;
    }

    //getter for update Biodata
    // public Biodata getUpdateBiodata(String newTitle, String newAuthor, int newYear) {
    //     return new Biodata(id, newTitle, newAuthor, newYear);
    // }

    //Setter
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name =  name;
    }
    public void setJenisKelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    public void setUmur(String umur) {
        this.umur = umur;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
