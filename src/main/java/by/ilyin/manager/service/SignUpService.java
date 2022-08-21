package by.ilyin.manager.service;

import by.ilyin.manager.entity.User;

public interface SignUpService {

    public void register(User user);

    public Boolean isExistUserByUsername(String username);

    public Boolean isExistUserByEmail(String email);

}
