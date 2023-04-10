package pencatatan.data.karyawan.service;

import pencatatan.data.karyawan.entity.User;

public interface UserService {
    User login(String username, String password);
}
