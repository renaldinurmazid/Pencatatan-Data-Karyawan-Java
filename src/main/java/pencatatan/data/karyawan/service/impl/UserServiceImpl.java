package pencatatan.data.karyawan.service.impl;

import pencatatan.data.karyawan.repository.UserRepository;
import pencatatan.data.karyawan.service.UserService;
import pencatatan.data.karyawan.entity.User;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
