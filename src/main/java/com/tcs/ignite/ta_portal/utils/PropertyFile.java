/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author ignite054
 */
public class PropertyFile {
    
    public  String fetchProperty(String propertiesFile, String queryName) {
       Properties properties = new Properties();
       String result = "";
       try {
           ClassLoader classLoader = PropertyFile.class.getClassLoader();
           properties.load(classLoader.getResourceAsStream(propertiesFile));
           result = properties.getProperty(queryName);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           return result;
       }
   }
    public static String fetchPropertyDirectly(String propertiesFile, String queryName) {
       return new PropertyFile().fetchProperty(propertiesFile, queryName);
   }

   /**
    *
    * @param propertiesFile
    * @return
    */
   public Enumeration<String> fetchAllPropertyNames(String propertiesFile) {
       Properties properties = new Properties();
       Enumeration<String> enumeration = null;
       try {
           ClassLoader classLoader = PropertyFile.class.getClassLoader();
           properties.load(classLoader.getResourceAsStream(propertiesFile));
           enumeration = (Enumeration<String>) properties.propertyNames();
//            while (enumeration.hasMoreElements()) {
//                System.out.println(enumeration.nextElement());
//            }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
       }
       return enumeration;
   }

   /**
    *
    * @param propertiesFileName
    * @return
    */
   public Properties loadPropertiesFile(String propertiesFileName) {
       Properties properties = null;
       try {
           properties = new Properties();
           ClassLoader classLoader = PropertyFile.class.getClassLoader();
           properties.load(classLoader.getResourceAsStream(propertiesFileName));
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           return properties;
       }
   }

   /**
    *
    * @param propertiesFile
    * @return
    */
   public HashMap<String, String> convertPropertiesFileToHashMap(String propertiesFile) {
       Properties properties = new Properties();
       HashMap<String, String> hashMap = new HashMap<String, String>();
       Enumeration<String> keys = null;
       try {
           ClassLoader classLoader = PropertyFile.class.getClassLoader();
           properties.load(classLoader.getResourceAsStream(propertiesFile));
           keys = (Enumeration<String>) properties.propertyNames();
           while (keys.hasMoreElements()) {
               String key = keys.nextElement();
               hashMap.put(key, properties.getProperty(key));
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
       }
       return hashMap;
   }
}
