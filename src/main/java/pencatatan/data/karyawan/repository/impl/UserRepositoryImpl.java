package pencatatan.data.karyawan.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pencatatan.data.karyawan.repository.UserRepository;
import pencatatan.data.karyawan.entity.User;

public class UserRepositoryImpl implements UserRepository {
    private final Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findByUsername(String username) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE username = ?")) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("role")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by username", e);
        }
    }
}