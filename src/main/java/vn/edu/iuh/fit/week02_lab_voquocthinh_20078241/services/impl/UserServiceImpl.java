package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.User;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.UserRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepository();
    }

    @Override
    public boolean insert(User user) {
        return userRepository.insert(user);
    }
}
