

# Cat Paw Protocol Ver 1.0 登陆

*Cat Paw Login Protocol Ver 1.0 2020/10/14*

欢迎！我们先来看看客户端怎么和服务端沟通吧！

### 0x01 流程

1.与服务器建立连接

2.发送第一个json数据 内容为携带用户名 申请一个WebSocket用户池并创建用户线程

3.接收由用户线程生成的RSA Public Keys

4.用户输入密码

5.接收由用户线程生成的SHA 盐值 此盐值将被加在密码前并使用Public Keys加密后发送到服务器

6.等待服务器校验并发回校验是否成功

7.登陆成功后接收服务器的第二条RSA用于加密其他数据内容

~~8.（其实是抄的Bilibili的）~~

> 1. 加密登录密码，获取RSA公钥`key`与盐值`hash`**（盐值有效时间为20s）**，并连接盐值+密码字串（注意先后顺序），使用RSA公钥加密，得到base64格式密文
> 2. 登录操作验证，使用账号`username`**（手机号或邮箱）**+密文密码`password`+登录密钥`key`+极验`challenge`+验证结果`validate`+验证结果`seccode`

### 0x02 协议

**客户端协议**

| 数据包头 Head | 功能号 Function | 描述 Description                               | 返回内容 Return         | 数据包尾 TALI |
| ------------- | --------------- | ---------------------------------------------- | ----------------------- | ------------- |
| CATC          | 000             | 空功能 可携带一个包含message说明错误字段的json | Void                    | E             |
| CATC          | 001             | 申请一个WebSocket用户池并创建用户线程          | Login RSA Public Keys   | E             |
| CATC          | 002             | 请求服务器校验密码                             | Content RSA Public Keys | E             |

**服务端协议**

| 数据包头 Head | 功能号 Function | 描述 Description                               | 数据包尾 TALI |
| ------------- | --------------- | ---------------------------------------------- | ------------- |
| CATS          | 000             | 空功能 可携带一个包含message说明错误字段的json | E             |
| CATS          | 001             | 返回给客户端创建结果 / 若创建不成功将发回空包  | E             |
| CATS          | 002             | 若登陆成功则为客户端发回第二条RSA Public Keys  | E             |

**功能号 001**

客户端包：

| 参数名 Parameter | 类型 Type | 内容 Content  |
| ---------------- | --------- | ------------- |
| username         | String    | 用户名 (邮箱) |

```json
Package:”CATC001{username:"Hanbings"}E“
```

服务器包：

| 参数名 Parameter | 类型 Type | 内容 Content              |
| ---------------- | --------- | ------------------------- |
| hash             | String    | 盐值**（有效时间为20s）** |
| keys             | String    | 登陆RAS公钥               |

```
Package: "CATS001{hash:" 7b7d29fdfd54dc22fad553f70c9c8118691f00ae",keys:"-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzA8X9zhQg9U3VlUpuRXC
gz2nrIp2OphF71QyWDCktNsRfEFjRwPZL8Cg+MDrqiTb5tHQom5QasH8hp9KeGbq
/Bq3S++EkWco8GRODO9y7941vtXQAcAf2y80oXl1A0l/CdsiVHFJr3a/zX3WQ+h6
gm2P93fyAMQyHtJshCVXsUBOl8XXF0m4/i2H2qrFIWUC72trCmDTkZXNIa8qStry
lS7gAuHg90jnXorDdAEuAX4peg1leGpwyK/F6mvO9rbr/NRmyMVgiTITblQa7V2t
5/w7UMRxfL6YdifI3256GkIV7QuxONpJoH1ym/udz6Qxw5taFK/+JWQJTe3B38ww
dwIDAQAB
-----END PUBLIC KEY-----"}E"
```

```
Package: "CATS000{massage:"ERROR: SERVER CAN'T NOT CREATE USER THREAD"}E"
```

**功能号 002**

客户端包：

| 参数名 Parameter | 类型 Type | 内容 Content  |
| ---------------- | --------- | ------------- |
| username         | String    | 用户名 (邮箱) |
| password         | String    | 加密后的密码  |
| keys             | String    | 公钥          |

```
Package:”CATC001{username:"Hanbings",password:"wPZL8Cg+MDrqiTb5tHQom5QasH8hp",keys:"-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzA8X9zhQg9U3VlUpuRXC
gz2nrIp2OphF71QyWDCktNsRfEFjRwPZL8Cg+MDrqiTb5tHQom5QasH8hp9KeGbq
/Bq3S++EkWco8GRODO9y7941vtXQAcAf2y80oXl1A0l/CdsiVHFJr3a/zX3WQ+h6
gm2P93fyAMQyHtJshCVXsUBOl8XXF0m4/i2H2qrFIWUC72trCmDTkZXNIa8qStry
lS7gAuHg90jnXorDdAEuAX4peg1leGpwyK/F6mvO9rbr/NRmyMVgiTITblQa7V2t
5/w7UMRxfL6YdifI3256GkIV7QuxONpJoH1ym/udz6Qxw5taFK/+JWQJTe3B38ww
dwIDAQAB
-----END PUBLIC KEY-----"}E“
```

服务器包：

| 参数名 Parameter | 类型 Type | 内容 Content                               |
| ---------------- | --------- | ------------------------------------------ |
| keys             | String    | 第二条RSA公钥 （登陆成功的情况下才会发回） |
| message          | String    | 登陆错误信息（默认为null）                 |

```
Package: "CATS001{keys:"-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzA8X9zhQg9U3VlUpuRXC
gz2nrIp2OphF71QyWDCktNsRfEFjRwPZL8Cg+MDrqiTb5tHQom5QasH8hp9KeGbq
/Bq3S++EkWco8GRODO9y7941vtXQAcAf2y80oXl1A0l/CdsiVHFJr3a/zX3WQ+h6
gm2P93fyAMQyHtJshCVXsUBOl8XXF0m4/i2H2qrFIWUC72trCmDTkZXNIa8qStry
lS7gAuHg90jnXorDdAEuAX4peg1leGpwyK/F6mvO9rbr/NRmyMVgiTITblQa7V2t
5/w7UMRxfL6YdifI3256GkIV7QuxONpJoH1ym/udz6Qxw5taFK/+JWQJTe3B38ww
dwIDAQAB
-----END PUBLIC KEY-----",message:"null"}E"
```

```
Package: "CATS000{massage:"ERROR: SERVER CAN'T NOT CREATE USER THREAD"}E"
```

