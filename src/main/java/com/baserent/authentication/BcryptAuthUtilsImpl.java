package com.baserent.authentication;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.inject.Singleton;

import java.util.InputMismatchException;

@Singleton
public class BcryptAuthUtilsImpl implements AuthUtils {

    @Override
    public String encryptPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean verifyPassword(String password, String passwordHash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), passwordHash);
        if (!result.verified) {
            throw new InputMismatchException("Incorrect Password. Password not found in database");
        }
        return true;
    }
}
