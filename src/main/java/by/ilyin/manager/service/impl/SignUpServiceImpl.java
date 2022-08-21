package by.ilyin.manager.service.impl;

import by.ilyin.manager.entity.User;
import by.ilyin.manager.service.SignUpService;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Override
    public void register(User user) {

    }

    @Override
    public Boolean isExistUserByUsername(String username) {
        return null;
    }

    @Override
    public Boolean isExistUserByEmail(String email) {
        return null;
    }
}
