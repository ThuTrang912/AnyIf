# Spring Boot - MyBatis Config (最初環境設定)

## 入れたDependencyリスト

https://start.spring.io/

![image](https://github.com/ThuTrang912/AnyIf/assets/129019073/6f6e6d56-69d7-4b27-994b-949fe02303a0)

IntelliJを開いて Open → ダウンロードしたファイルのbuild.gradleを選択 → Trust Projectで開く

## build.gradleを確認

先　「https://start.spring.io/」 ここで注入したDependenciesがちゃんと入ってるか確認する

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/73b6b6fa-eed0-4f88-a223-e93c69da9d4b/Untitled.png)

## プロジェクトの階層

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/937cf5a7-fec8-49b6-a5db-8f49568eb975/Untitled.png)

controller, domain, mapper, service パッケージを作った

resourcesの下にmybatisっていう名前でパッケージを作って、さらにその下にmapperパッケージを作る

多分みんなはapplication.propertiesだけ入ってるはず

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4bc899c0-d6ba-4346-bb86-c37b0d881b79/Untitled.png)

application.propertiesは削除して new → file で application.yml を新しく作る

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eb292f93-e224-4a68-adc7-89f95d1288a9/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fba5e547-c9d0-4f0b-b1dc-9af2129e99b5/Untitled.png)

### application.yml

application.ymlを開いて下のように書き込む

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ac90a9e4-7cf8-452f-8e09-52ac737c191b/Untitled.png)

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

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/974784f4-0134-4320-873c-1707808e93e4/Untitled.png)

mapperパッケージに UserDao Interfaceを作る

### UserDao.java

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/973a937c-b2a0-430c-b124-30520f99e3e7/Untitled.png)

@Mapperを書いてイメージの通りにList<Map<String, Object>> users(); を書く

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9c7b26c-ae8e-4695-9784-70a814f553bd/Untitled.png)

resources → mybatis → mapperパッケージにUserMapper.xmlを新しく作る

### UserMapper.xml

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/961b32dd-54e6-4ddc-892c-5abbaf4cf45e/Untitled.png)

上のイメージの通りに書くと　「 user 」 のところに赤線が引かれる

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7b76b4ef-192b-4914-bade-8c0f33476c2a/Untitled.png)

IntelliJの右のところのDatabaseをクリックして DataSource → MySQL

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/832cd4fe-ac2b-4bf2-875c-258cac0426f0/Untitled.png)

UserとPasswordは　application.ymlに書いたやつと同じにする

Databaseは使いたいデータベース名を書く

Test Connectionをクリックして繋がるか確認する

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7d06b334-0e71-44c6-bfa0-c6cb4428629d/Untitled.png)

Succeededが表示されたら　Apply → OK 

こうやってもまだ赤線が残ってる

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c84d2578-2d4b-42d2-80b7-b5b2f3cf643a/Untitled.png)

マウスCursorをuserの上に置いて　window : alt + Ent  / mac : opt + Ent

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e626edbb-6ec2-453b-8b4c-d508703d3a21/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7e21525f-d2c8-43f7-9b1e-d55b42e7a2cd/Untitled.png)

choose schemaからデータベース選択

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b903ec57-b858-469a-b238-8b32d18af78b/Untitled.png)

Data Source Propertiesクリック

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/739a5858-e6e5-4f77-97c5-609253791c3e/Untitled.png)

使いたいデータベース選択 Apply - OK

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6f1103b4-b218-4159-9177-59893ba4c2ca/Untitled.png)

赤線がなくなった

controller → UserController を新しく作る

### UserController.java

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0c480228-7144-4810-b6eb-cc5252c3d1b2/Untitled.png)

実行してみよう〜！

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fc217821-aaa8-477e-8bfe-20c02f09f099/Untitled.png)

エラーは出てないからBrowserを開いて　localhost:8080/hello を打つと

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e2125a86-d287-47b4-87f4-1a454e45c433/Untitled.png)

500エラーが出ちゃう

理由は？

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a73503d8-04ee-4a97-bd15-954a58bbbfb0/Untitled.png)

UserMapper.xmlの<select id=”getAllUsers” >と書いてあるから UserDaoのメソッド名も

getAllUsersに変える

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ee0e3d81-dffb-4a53-b3ca-15c969069f3b/Untitled.png)

UserDao のメソッド名が　users() → getAllUsers(); に 

UserController　の users()メソッドの中のuserDao.users() → userDao.getAllUsers()に変わった

これで実行してみると

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2e1e4b51-768c-4988-b67c-ca4535f55698/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f510beb4-7105-43a5-b9b4-c19349192626/Untitled.png)

200番でデータベースからデータを持ってくることができた。

これはMybatisを簡単に使える方法の１つである。今回はこれでやりましょうおおうおうおう。

ー 2023/06/06 ー
