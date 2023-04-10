package pencatatan.data.karyawan.repository;

import  pencatatan.data.karyawan.entity.User;

public interface UserRepository {
    User findByUsername(String username);
}
