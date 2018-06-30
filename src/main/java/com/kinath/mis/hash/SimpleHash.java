package com.kinath.mis.hash;/*
Kasun De Zoysa @ UCSC
*/

import java.security.*;
import java.io.*;


public class SimpleHash{

public static void main(String args[]) {

 try {

   String data = "hello kasun";
   byte dataBytes[] = data.getBytes();

   MessageDigest md1 = MessageDigest.getInstance("md5");
   md1.update(dataBytes);
   byte digest1[] = md1.digest();


   System.out.println("Orig. digest: ");
   for(byte b:digest1) System.out.format("%02x",b);
   System.out.println("");

   String data2 = "hello kasun";
   MessageDigest md2 = MessageDigest.getInstance("md5");
   md2.update(data2.getBytes());
   byte digest2[] = md2.digest();


   System.out.println("New digest: ");
   for(byte b:digest2) System.out.format("%02x",b);
   System.out.println("");

   if(md2.isEqual(digest1,digest2)) 
     System.out.println("Digest Verified");
   else  
     System.out.println("Digest Verification failed!");



  } catch (Exception e) {
     System.out.println(e);
  }

 }

}

