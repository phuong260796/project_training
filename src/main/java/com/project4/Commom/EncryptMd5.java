package com.project4.Commom;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncryptMd5 {
    public static String encryMd5(String str){
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

   /* public static String convertEncryMd5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] arr = md.digest("");
            return Base64.getEncoder().encodeToString(arr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }*/


}
