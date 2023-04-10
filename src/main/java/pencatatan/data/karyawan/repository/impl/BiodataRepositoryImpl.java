package pencatatan.data.karyawan.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import java.sql.PreparedStatement;

import pencatatan.data.karyawan.entity.Biodata;
import pencatatan.data.karyawan.repository.BiodataRepository;

public class BiodataRepositoryImpl implements BiodataRepository {

    private DataSource dataSource;

    public BiodataRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void add(Biodata biodata) {
     
        //query
        String sql = "INSERT INTO biodata (name, jenis_kelamin, umur, alamat) VALUES (?,?,?,?)";

        //excute
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql)) {
        
            //set value
            statement.setString(1, biodata.getName());
            statement.setString(2, biodata.getJenisKelamin());
            statement.setString(3, biodata.getUmur());
            statement.setString(4, biodata.getAlamat());
            // execute
            statement.executeUpdate();

        } catch (SQLException e) {       
            throw new RuntimeException(e);
        }
    }

    @Override
    public Biodata[] getAll() {
        //query
        String query = "SELECT id, name, jenis_kelamin, umur, alamat FROM biodata";
        //execute
        try (Connection connection = dataSource.getConnection(); 
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)){
        
            
            //initialize
            List<Biodata> list = new ArrayList<Biodata>();

            while (resultSet.next()) {
                //initialize
                Biodata biodata = new Biodata();

                biodata.setId(resultSet.getInt("id"));
                biodata.setName(resultSet.getString("name"));
                biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                biodata.setUmur(resultSet.getString("umur"));
                biodata.setAlamat(resultSet.getString("alamat"));

                //add book
                list.add(biodata);
            }
            //return
            return list.toArray(new Biodata[] {});

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Biodata getById(Integer id) {

        //query
        String query = "SELECT id, name, jenis_kelamin,umur,alamat FROM biodata WHERE id = ?";

        //execute
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            //set value
            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery();) {
            
                //initialize
            Biodata biodata = new Biodata();
            
            while (resultSet.next()){
                //set value
                biodata.setId(resultSet.getInt("id"));
                biodata.setName(resultSet.getString("name"));
                biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                biodata.setUmur(resultSet.getString("umur"));
                biodata.setAlamat(resultSet.getString("alamat"));
            }

            //return
            return biodata;
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Biodata biodata) {
        //query
        String query = "UPDATE biodata SET name = ?, jenis_kelamin = ?, umur = ?, alamat = ? WHERE id = ?";

        //execute
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)){

            //set value
            statement.setString(1, biodata.getName());
            statement.setString(2, biodata.getJenisKelamin());
            statement.setString(3, biodata.getUmur());
            statement.setString(4, biodata.getAlamat());
            statement.setInt(5, biodata.getId());

            //execute
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM biodata WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
