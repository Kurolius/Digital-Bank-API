# Digital-Bank-API

## Project Structure 
![image](https://user-images.githubusercontent.com/84138772/171065295-4fbe7efc-63bf-4920-b383-6d2efb4477cc.png)

## Entities 

![image](https://user-images.githubusercontent.com/84138772/171065641-f8d3b14e-77ff-449c-9e98-b2d465522d83.png)

## Dtos 

![image](https://user-images.githubusercontent.com/84138772/171065678-a4c3a25c-3307-4f2a-8c2f-b0faf4e718a7.png)

## Repositories 

![image](https://user-images.githubusercontent.com/84138772/171065745-bfdd88ef-0474-4209-8ac2-eb4230c6978c.png)


## Security 
![image](https://user-images.githubusercontent.com/84138772/171065905-26d93146-0238-4f2d-87e3-de219b5582da.png)

### Security Config
in *SecurityConfig.java*
```java

public class Jwt_config {

    public static String REFRESH_PATH = "/api/refresh-token";
    public static String SECRET_PHRASE = "yousk2";
    public static String AUTHORIZATION_HEADER = "Authorization";
    public static String TOKEN_HEADER_PREFIX = "Bearer ";
    public static int ACCESS_TOKEN_EXPIRATION = 2*24*60*60*1000;
    public static int REFRESH_TOKEN_EXPIRATION = 30*24*60*60*1000;
}

```

## Web
![image](https://user-images.githubusercontent.com/84138772/171065792-6038e63d-8423-4212-a9a5-abf94c5b9060.png)

### Routes
#### Customer
![image](https://user-images.githubusercontent.com/84138772/171066566-04600d2e-2c7a-42f7-930a-2747f2e47176.png)

#### Bank Account
![image](https://user-images.githubusercontent.com/84138772/171066593-d5796e58-53bc-4dd7-b6f7-2ecd0e6716e8.png)
#### Operation
![image](https://user-images.githubusercontent.com/84138772/171066633-1e34348b-5f2d-47f6-b3eb-b911733d816f.png)

#### Security
![image](https://user-images.githubusercontent.com/84138772/171066650-b7722750-4813-490a-b404-86c6dba52205.png)


