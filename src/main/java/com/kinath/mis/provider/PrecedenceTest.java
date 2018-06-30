package com.kinath.mis.provider;/*
Kasun De Zoysa @ UCSC
Compile:
javac -cp ../BC/bcprov-jdk16-146.jar PrecedenceTest.java 
Execute:
java -cp ../BC/bcprov-jdk16-146.jar:. PrecedenceTest
*/

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.Security;

public class PrecedenceTest
{
    public static void main( String[] args ) throws Exception
    {
        Security.addProvider( new BouncyCastleProvider() );
        Cipher cipher = Cipher.getInstance( "AES/ECB/NoPadding" );
        System.out.println( cipher.getProvider() );
    }
}
