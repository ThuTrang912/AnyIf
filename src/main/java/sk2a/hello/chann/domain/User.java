package sk2a.hello.chann.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;
    private String user_login;
    private String password;
    private String user_name;
    private int review;
    private String address;
    private String tel;
    private int age;
    private String gender;
    private String profile;

}
