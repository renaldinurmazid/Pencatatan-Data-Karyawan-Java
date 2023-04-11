package pencatatan.data.karyawan.view;

import pencatatan.data.karyawan.service.UserService;
import pencatatan.data.karyawan.service.impl.BiodataServiceImpl;
import pencatatan.data.karyawan.service.BiodataService;
import java.util.Scanner;

import javax.sql.DataSource;

import pencatatan.data.karyawan.entity.User;
import pencatatan.data.karyawan.repository.BiodataRepository;
import pencatatan.data.karyawan.repository.impl.BiodataRepositoryImpl;
import pencatatan.data.karyawan.util.DatabaseUtil;

public class LoginView {
    private final UserService userService;

    public LoginView(UserService userService) {
        this.userService = userService;
    }

    DataSource dataSource = DatabaseUtil.getDataSource();


    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========LOGIN==========");
        System.out.print("Masukan Username:");
        String username = scanner.nextLine();
        System.out.print("Password:");
        String password = scanner.nextLine();   
        System.out.println("=========================");
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("======================================================================");
            System.out.println("Welcome, " + user.getName() + " Anda Login Sebagai " + user.getRole());
            System.out.println("======================================================================");

            //
             BiodataRepository biodataRepository = new BiodataRepositoryImpl(dataSource);
             BiodataService biodataService = new BiodataServiceImpl(biodataRepository);   
             BiodataView biodataView =  new BiodataView(biodataService);

            // show view
            biodataView.showMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
