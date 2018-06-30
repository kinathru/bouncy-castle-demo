package com.kinath.mis;

import java.security.Provider;
import java.security.Security;

public class ListProviders
{

    public static void main( String[] args )
    {
        Provider[] providers = Security.getProviders();
        for( Provider p : providers )
        {
            System.out.println( "Provider Name: " + p.getName() );
            System.out.println( "Provider Infor: " + p.getInfo() );
            System.out.println( "Provider Version" + p.getVersion() );
            System.out.println( "-------------------------------" );
        }
    }
}