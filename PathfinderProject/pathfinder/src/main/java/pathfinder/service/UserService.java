package pathfinder.service;

import pathfinder.model.entity.User;
import pathfinder.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logoutUser();

    UserServiceModel findById(Long id);

    boolean isNameExists(String username);

    User findCurrentLoginUserEntity();
}
