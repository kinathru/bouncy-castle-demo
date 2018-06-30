package com.kinath.mis.provider;/*
Kasun De Zoysa @ UCSC
*/

import java.security.Provider;
import java.security.Security;
import java.util.Set;
import java.util.Iterator;

public class ListProviders{
 public static void main(String[] args){
  
  Provider[] providers=Security.getProviders();
  for(Provider p:providers){
  	System.out.println("Provider Name: "+p.getName());
	System.out.println("Provider Infor: "+p.getInfo());
	System.out.println("Provider Version"+p.getVersion());
	System.out.println("-------------------------------");
  }
 }
}
