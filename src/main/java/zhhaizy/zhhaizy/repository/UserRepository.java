package zhhaizy.zhhaizy.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import zhhaizy.zhhaizy.domain.User;

public interface UserRepository extends BaseRepository<User,Integer> {

    //修改密码
    @Modifying
    @Query("update  User set password=?1 where id=?2")
    @Transactional
    int updatePwd(String newPwd,Integer id);


    //按照名字查询
    @Query("select id,name,password,type from User where name=?1")
    User selectUserByName(String name);
}
