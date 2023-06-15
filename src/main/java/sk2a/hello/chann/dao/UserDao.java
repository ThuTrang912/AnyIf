package sk2a.hello.chann.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sk2a.hello.chann.domain.User;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserDao {
    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE user_id=#{user_id}")
    default User selectUserById (@Param("user_id") Integer id){ return null;};

    @Insert("INSERT INTO user(user_login," +
            " password, user_name, review, address," +
            " tel, age, gender, profile) " +
            "VALUE(#{user.user_login},#{user.password},#{user.user_name}," +
            "#{user.review},#{user.address},#{user.tel},#{user.age},#{user.gender},#{user.profile})")
    default void insertUser(@Param("user") User user){};

}
