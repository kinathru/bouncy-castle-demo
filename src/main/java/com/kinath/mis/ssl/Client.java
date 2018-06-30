package com.kinath.mis.ssl;/*
Kasun De Zoysa @UCSC
*/

import java.math.BigInteger;
import java.security.cert.*;
import java.io.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import javax.net.SocketFactory;

public class Client
{
    public static void main( String[] args ) throws Exception
    {
        SocketFactory sf = SSLSocketFactory.getDefault();
        Socket s = sf.createSocket( args[0], Integer.parseInt( args[1] ) );

        printSession( ( (SSLSocket) s ).getSession() );

        BufferedReader br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
        PrintWriter pw = new PrintWriter( s.getOutputStream() );

        System.out.println( "GET /" );
        pw.println( "GET /" );
        pw.flush();
        String st;
        while( ( st = br.readLine() ) != null )
        {
            System.out.println( st );
        }
        s.close();
    }

    public static void printSession( SSLSession session ) throws Exception
    {

        Certificate[] cc = session.getPeerCertificates();
        // System.out.println("The Certificates used by peer");
        //for (Certificate x:cc) System.out.println(x);

        System.out.println( "Peer host is " + session.getPeerHost() );
        System.out.println( "Cipher is " + session.getCipherSuite() );
        System.out.println( "Protocol is " + session.getProtocol() );
        System.out.println( "ID is " + new BigInteger( session.getId() ) );
        System.out.println( "Session created in " + session.getCreationTime() );
        System.out.println( "Session accessed in " + session.getLastAccessedTime() );
    }
}
