package zhhaizy.zhhaizy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhhaizy.zhhaizy.domain.User;
import zhhaizy.zhhaizy.repository.BaseRepository;
import zhhaizy.zhhaizy.repository.UserRepository;
import zhhaizy.zhhaizy.service.UserService;

@Service
public class UserServiceImpl extends CommonServiceImpl<User,Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public BaseRepository<User, Integer> currentRepository() {
        return userRepository;
    }


    @Override
    public int updatePwd(String newPwd, Integer id) {
        return userRepository.updatePwd(newPwd,id);
    }

    @Override
    public User selectUserByName(String name) {
        return null;
    }
}
