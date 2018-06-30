package com.kinath.mis.publickey;/*
Kasun De Zoysa @ UCSC
Compile:
javac -cp ../BC/bcprov-jdk16-146.jar RSAEncryption.java 
Execute:
java -cp ../BC/bcprov-jdk16-146.jar:. RSAEncryption
*/

import java.security.Security;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import java.util.Formatter;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSAEncryption {

  public static void main(String[]    args) throws Exception    {

  Security.addProvider(new BouncyCastleProvider());

  String        input = "Hello Kasun ..";
  Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");


  // create the keys
  KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
  generator.initialize(1024,new SecureRandom());


  KeyPair          pair = generator.generateKeyPair();
  Key              pubKey = pair.getPublic();
  Key              privKey = pair.getPrivate();

  // encryption step
  cipher.init(Cipher.ENCRYPT_MODE,pubKey);
  byte[] cipherText = cipher.doFinal(input.getBytes());
  System.out.println("Cipher : " +byteArray2Hex(cipherText));
  
  // decryption step
  cipher.init(Cipher.DECRYPT_MODE,privKey);
  byte[] plainText = cipher.doFinal(cipherText);
  System.out.println("Plain : " +new String(plainText));

 }

 private static String byteArray2Hex(byte[] hash) {
     Formatter formatter = new Formatter();
     for (byte b : hash) formatter.format("%02x", b);
     return formatter.toString();
  }

}

