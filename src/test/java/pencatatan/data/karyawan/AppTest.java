package pencatatan.data.karyawan;
import javax.sql.DataSource;

import pencatatan.data.karyawan.repository.BiodataRepository;
import pencatatan.data.karyawan.service.BiodataService;

import pencatatan.data.karyawan.repository.impl.BiodataRepositoryImpl;
import pencatatan.data.karyawan.service.impl.BiodataServiceImpl;
import pencatatan.data.karyawan.util.DatabaseUtil;
//import pencatatan.data.karyawan.view.BiodataView;

public class AppTest 
{
    public static void main( String[] args )
    {
        // datasource
        DataSource dataSource = DatabaseUtil.getDataSource();

        //set data
        BiodataRepository biodataRepository = new BiodataRepositoryImpl(dataSource);
        BiodataService biodataService = new BiodataServiceImpl(biodataRepository);

        
        //view
        //BiodataView biodataView =  new BiodataView(bookService);

        //show view
        //biodataView.showMenu();
    }
}