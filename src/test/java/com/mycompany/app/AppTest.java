package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testNewStrings() {
    
        ArrayList<Integer> list1=new ArrayList<Integer>(Arrays.asList(5,11,7,1));
        ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6));
        ArrayList<String> list3=new ArrayList<String>(Arrays.asList("Yasar","Can","Kakdas"));
        ArrayList<String> result=App.changeLetter(list1,list2,list3,2,19);
            assertEquals(result.get(0),"Ygsdr");
            assertEquals(result.get(1),"Fgn");
            assertEquals(result.get(2),"Ngkdas");
      }
    public void testNullStringArray(){
        ArrayList<Integer> list1=new ArrayList<Integer>(Arrays.asList(5,11,7,1));
        ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6));
            assertNull(App.changeLetter(list1,list2,null,2,19));
    }
      
    public void testEmptyStrings(){
        ArrayList<Integer> list1=new ArrayList<Integer>(Arrays.asList(5,11,7,1));
        ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6));
        ArrayList<String> list3=new ArrayList<String>(Arrays.asList("","",""));
            assertEquals(App.changeLetter(list1,list2,list3,2,19).get(0),"");
            assertEquals(App.changeLetter(list1,list2,list3,2,19).get(1),"");
            assertEquals(App.changeLetter(list1,list2,list3,2,19).get(2),"");
    
    }
    
    public void testZeroLengthArrays(){
       
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        ArrayList<String> list3=new ArrayList<String>();
            assertNull(App.changeLetter(list1,list2,list3,2,19));
    
    }
    
    public void testNullStrings(){
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        ArrayList<String> list3=new ArrayList<String>();
        list3.add(null);
        list3.add(null);
        list3.add(null);
            assertNull(App.changeLetter(list1,list2,list3,2,19));
    
    }
}
