package pencatatan.data.karyawan.view;

import java.util.Scanner;
import pencatatan.data.karyawan.service.BiodataService;
import pencatatan.data.karyawan.entity.Biodata;
import pencatatan.data.karyawan.entity.User;

public class BiodataView {
    //   Book Service
    private BiodataService biodataService;

    public BiodataView(BiodataService biodataService){
        this.biodataService = biodataService;
    }

    //show menu
    public void showMenu(User user){
        if (user.getRole().equals("Admin")) {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("============ MAIN MENU ===========");
            System.out.println("1.INSERT DATA KARYAWAN");
            System.out.println("2.UPDATE DATA KARYAWAN");
            System.out.println("3.SHOW DATA KARYAWAN");
            System.out.println("4.SHOW DATA BY ID KARYAWAN");
            System.out.println("5.DELETE DATA KARYAWAN");
            System.out.println("X.EXIT");
            System.out.println("==================================");
            System.out.print("Masukan Menu Pilihan Anda: ");
            String input = scanner.nextLine();
    
            if(input.equals("1")) {
                insertData();
            }else if (input.equals("3")) {
                showData();
            }else if (input.equals("2")) {
                updateData();
            }else if (input.equals("4")) {
                showDataById();
            }else if(input.equals("X")) {
                break;
            }else if(input.equals("5")) {
                deleteData();
            }else {
                 System.out.println("Option Tidak ada dalam pilihan");
            }
        }
        
    }else if (user.getRole().equals("User")) {
        while (true) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("============ MAIN MENU ===========");
            System.out.println("1.SHOW DATA KARYAWAN");
            System.out.println("2.SHOW DATA BY ID KARYAWAN");
            System.out.println("X.EXIT");
            System.out.println("==================================");
            System.out.print("Masukan Menu Pilihan Anda: ");
            String input = scanner.nextLine();

            if(input.equals("1")) {
                showData();
            }else if (input.equals("2")) {
                showDataById();
            }else if(input.equals("X")) {
                break;
            }else{
                 System.out.println("Option Tidak ada dalam pilihan");
            }
        }
    }else {
        System.out.println("Invalid role.");
    }
}

    //insert data
    public void insertData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== INSERT DATA ===========");

        //get data input
        System.out.print("Masukan Nama Karyawan: ");
    
        String name = scanner.nextLine();
    
        System.out.print("Masukan Jenis Kelamin: ");
    
        String jenis_kelamin = scanner.nextLine();
    
        System.out.print("Masukan Umur Karyawan: ");
    
        String umur = scanner.nextLine();

        System.out.print("Masukan Alamat Karyawan: ");
    
        String alamat = scanner.nextLine();
    
        //add data
        biodataService.add(name, jenis_kelamin, umur, alamat);
    }
    //update data
    public void updateData() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Masukan ID Karyawan: ");
    
        Integer id = scanner.nextInt();

        Biodata biodata = biodataService.getById(id);
    
        scanner.nextLine(); // Consume newline left-over
    
        System.out.print("Masukan Nama Karyawan: ");
    
        String name = scanner.nextLine();
    
        System.out.print("Masukan Jenis Kelamin: ");
    
        String jenis_kelamin = scanner.nextLine();
    
        System.out.print("Masukan Umur Karyawan: ");
    
        String umur = scanner.nextLine();

        System.out.print("Masukan Alamat Karyawan: ");
    
        String alamat = scanner.nextLine();
    
        biodataService.update(id, name, jenis_kelamin, umur, alamat);
    
        System.out.println("Data Karyawan updated successfully.");
        
    }
    //show data
    public void showData(){
        System.out.println("========== SHOW DATA ===========");
        //show
        biodataService.getAll();
    }
    //delete data
    public void deleteData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== DELETE DATA ===========");

        System.out.print("Masukan ID Karyawan: ");
    
        Integer id = scanner.nextInt();

        //show
        biodataService.delete(Integer.valueOf(id));
    }
    //show data byid
    public void showDataById(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== SHOW DATA By ID ===========");

        System.out.print("Masukan ID Karyawan: ");
    
        Integer id = scanner.nextInt();

        //show
        biodataService.getById(Integer.valueOf(id));
    }
}