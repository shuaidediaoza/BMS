package com.example.smsless.utils;
//暂时不用
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

public class CustomTokenUtils {

    // 密钥（建议放在配置文件中）
    private static final String SECRET_KEY = "your-secret-key";
    // 过期时间（24小时）
    private static final long EXPIRATION = 86400000;

    /**
     * 生成 token
     */
    public static String generateToken(String username) {
        long expireTime = System.currentTimeMillis() + EXPIRATION;
        String content = username + ":" + expireTime;
        String signature = DigestUtils.md5DigestAsHex((content + SECRET_KEY).getBytes(StandardCharsets.UTF_8));

        String token = content + ":" + signature;
        return Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 校验 token 并返回用户名
     */

//    Base64 解码：将传入的 Token 进行 Base64 解码，还原出原始字符串。
//    拆分字段：解码后的字符串格式应为 username:expireTime:signature。
//    重新计算签名：根据 username 和 expireTime 使用相同的密钥重新计算 MD5 签名。
//    对比签名：如果重新计算的签名与 Token 中的签名一致，并且未过期，则认为 Token 合法，返回用户名；否则返回 null。
    public static String validateToken(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(token);
            String decodedToken = new String(decodedBytes, StandardCharsets.UTF_8);
            String[] parts = decodedToken.split(":");

            if (parts.length != 3) {
                return null; // 格式错误
            }

            String username = parts[0];
            long expireTime = Long.parseLong(parts[1]);
            String signature = parts[2];

            String expectedSignature = DigestUtils.md5DigestAsHex(
                    (username + ":" + expireTime + SECRET_KEY).getBytes(StandardCharsets.UTF_8)
            );

            if (expectedSignature.equals(signature) && new Date(expireTime).after(new Date())) {
                return username;
            }
        } catch (Exception e) {
            return null; // 解析失败或格式错误
        }

        return null;
    }
}
