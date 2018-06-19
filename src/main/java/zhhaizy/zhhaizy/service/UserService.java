package zhhaizy.zhhaizy.service;

import zhhaizy.zhhaizy.domain.User;

public interface UserService extends CommonService<User,Integer> {

    //修改密码
    int updatePwd(String newPwd,Integer id);

    //按照名字查询
    User selectUserByName(String name);
}
