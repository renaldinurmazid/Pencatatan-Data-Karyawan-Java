package pencatatan.data.karyawan;

import java.sql.SQLException;

import javax.sql.DataSource;

import pencatatan.data.karyawan.util.DatabaseUtil;

import pencatatan.data.karyawan.repository.UserRepository;
import pencatatan.data.karyawan.repository.impl.UserRepositoryImpl;
import pencatatan.data.karyawan.service.UserService;
import pencatatan.data.karyawan.service.impl.UserServiceImpl;
import pencatatan.data.karyawan.view.LoginView;

public class App 
{
    public static void main( String[] args ) throws SQLException
        {
    
        // datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        //set data
        UserRepository userRepository = new UserRepositoryImpl(dataSource.getConnection());
        UserService userService = new UserServiceImpl(userRepository);
        LoginView loginView = new LoginView(userService);

        
        //view

        //show view
        loginView.show();
    }
    }