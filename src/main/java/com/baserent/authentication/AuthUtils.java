package com.baserent.authentication;

public interface AuthUtils {
     String encryptPassword(String password);

     boolean verifyPassword(String password, String passwordHash);
}
