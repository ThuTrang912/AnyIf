# Spring Boot - MyBatis Config (最初環境設定)

## 入れたDependencyリスト

https://start.spring.io/

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/6f6e6d56-69d7-4b27-994b-949fe02303a0)

IntelliJを開いて Open → ダウンロードしたファイルのbuild.gradleを選択 → Trust Projectで開く

## build.gradleを確認

先　「https://start.spring.io/」 ここで注入したDependenciesがちゃんと入ってるか確認する

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/66f0a8e8-7649-4c25-bf30-61cad6a60c0e)


## プロジェクトの階層

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/6c8526d4-d69f-4865-9ece-9a34c945189c)

controller, domain, mapper, service パッケージを作った

resourcesの下にmybatisっていう名前でパッケージを作って、さらにその下にmapperパッケージを作る

多分みんなはapplication.propertiesだけ入ってるはず

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/4664932d-a9c0-4424-acc0-c03a5e38b11d)


application.propertiesは削除して new → file で application.yml を新しく作る

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/355018aa-9f4a-44c4-9212-feb554f327f7)

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/1e0191bc-b28e-4f22-a527-4af248ab0ed2)

### application.yml

application.ymlを開いて下のように書き込む

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/48ea3c49-8392-48a3-9dcb-70f06959585e)


```yaml
url: jdbc:mysql://localhost:3306/データベース名前?characterEncoding=UTF-8 
// serverTimezoneは書かなくても構わない

username: 何でもいい。俺は一応rootで使ってる

password: データベースログインする時のパスワード

driverClassName: com.mysql.cj.jdbc.Driver
// mysqlのバージョンが8.x以上やったら　com.mysql.cj.jdbc.Driver
// mysqlのバージョンが8.xより下やったら　com.mysql.jdbc.Driver

typeAliasesPackage: プロジェクトの階層を見てdomainの下位のクラス（DBとマッピングするクラス）を指定して
あげる
// typeAliasesPackageは後で説明するから今は書く必要はない

mapper-locations: classpath:mybatis/mapper/*.xml
// 「mapperは全部ここにありますよ」　と指定する
// resourcesの下のmybatisの下のmapperのパッケージに入ってる全てのxmlファイル
```

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/fa175d6a-32ac-4386-8c4d-e9591b7d8dbf)


mapperパッケージに UserDao Interfaceを作る

### UserDao.java

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/651becb8-471c-4db2-966e-03ed0cc81b93)


@Mapperを書いてイメージの通りにList<Map<String, Object>> users(); を書く

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/73a39ce1-4990-48d5-9978-34b45994262f)


resources → mybatis → mapperパッケージにUserMapper.xmlを新しく作る

### UserMapper.xml

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/ea067659-0509-4d5e-a917-f000cebc5115)

上のイメージの通りに書くと　「 user 」 のところに赤線が引かれる

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/ba5e3b90-983d-4b4f-99e1-68639348cb42)


IntelliJの右のところのDatabaseをクリックして DataSource → MySQL

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/274cd313-3729-4396-9d51-1633826c3ba2)


UserとPasswordは　application.ymlに書いたやつと同じにする

Databaseは使いたいデータベース名を書く

Test Connectionをクリックして繋がるか確認する

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/a1d7aa12-770a-47df-8a96-3a2abdb01a29)


Succeededが表示されたら　Apply → OK 

こうやってもまだ赤線が残ってる

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/8483cc47-f9e4-4b0d-8165-cbcde695ae54)


マウスCursorをuserの上に置いて　window : alt + Ent  / mac : opt + Ent

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/33e053f3-16c8-4a16-b4ad-a6efba91de96)


![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/b8e65194-d4c1-47f5-a073-95266e7d1460)


choose schemaからデータベース選択

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/d1ea9645-6cde-4954-8dc8-899ca9d28f22)


Data Source Propertiesクリック

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/336009db-03bb-4cd7-b5d2-598b9fc7b1a4)

使いたいデータベース選択 Apply - OK

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/258d5e42-aafe-471f-93bb-7bc7a91b28b8)

赤線がなくなった

controller → UserController を新しく作る

### UserController.java

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/a9d4016f-106d-4986-a9b7-223fe76605ae)


実行してみよう〜！

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/b3695a5b-769c-422b-9f51-de7350dd2bb7)


エラーは出てないからBrowserを開いて　localhost:8080/hello を打つと

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/6ae0276f-f335-4a1f-8c95-da209f9f61e3)


500エラーが出ちゃう

理由は？

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/87a8e12c-2b43-45d9-80ab-e923850ecac6)


UserMapper.xmlの<select id=”getAllUsers” >と書いてあるから UserDaoのメソッド名も

getAllUsersに変える

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/d28ef10b-c66c-41b5-a490-97713ab78f26)


UserDao のメソッド名が　users() → getAllUsers(); に 

UserController　の users()メソッドの中のuserDao.users() → userDao.getAllUsers()に変わった

これで実行してみると

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/d9ad42d2-2981-4d4c-b74f-cf20f8839d82)


![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/57aeb213-7830-4477-ab41-1bb406a7d8e8)


200番でデータベースからデータを持ってくることができた。

これはMybatisを簡単に使える方法の１つである。今回はこれでやりましょうおおうおうおう。

ー 2023/06/06 ー
