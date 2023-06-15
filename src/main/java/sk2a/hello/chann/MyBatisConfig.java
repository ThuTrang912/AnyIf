package sk2a.hello.chann;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
@Configuration
public class MyBatisConfig {

    private final DataSource dataSource;

    public MyBatisConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);  // MyBatis에서 사용할 DataSource를 설정
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml")); // MyBatis 구성 파일위치
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

/**
 *  MyBatisConfigクラスはdataSourceをコンストラクタで注入してもらい、SqlSessionFactoryと SqlSessionTemplate Beanを生成する
 *  SqlSessionTemplateは、SqlSessionオブジェクトをラッピングし、Springのトランザクション管理とAOPなどの機能を活用できるようにする
 *  sessionFactory.setDataSource(dataSource)はMyBatisで使用するデータベース接続を設定する
 *  sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"))는 MyBatis 構成ファイルであるmybatis-config.xmlの位置を設定する
 *  このように設定されたSqlSessionFactoryとSqlSessionTemplateウィーンは、@Autowiredアノテーションを利用して必要なクラスで注入して使用することができる
 */
