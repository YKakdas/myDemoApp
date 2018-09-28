package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static ArrayList<String> changeLetter(ArrayList<Integer> array1, ArrayList<Integer> array2, ArrayList<String> strings,int whichLetter1,int whichLetter2) {
        
        if(strings==null || array1==null || array2==null)
            return null;
        if(strings.size()==0 || array1.size()==0 || array2.size()==0)
            return null;
        for(int i=0;i<strings.size();i++)
            if(strings.get(i)==null)
                return null;
        for(int i=0;i<strings.size();i++)
            if(strings.get(i).length()==0)
                return strings;
        int array1Size=array1.size();
        int totalArray1Value=0;
        for(int x=0;x<array1Size;x++){
            totalArray1Value=totalArray1Value+array1.get(x);
        }
        int averageOfArray1=totalArray1Value/array1Size;

        int array2Size=array2.size();
        int totalArray2Value=0;
        for(int i=0;i<array2Size;i++){
            totalArray2Value=totalArray2Value+array2.get(i);
        }
        int averageOfArray2=totalArray2Value/array2Size;
        ArrayList<String> result=new ArrayList<String>();
        for(int i=0;i<strings.size();i++){
        		String s1=strings.get(i).substring(0,((whichLetter1-1)%(strings.get(i).length())))+
                        (char)((int)(strings.get(i).charAt(((whichLetter1-1)%(strings.get(i).length()))))+(averageOfArray1%128))+
                        strings.get(i).substring(((whichLetter1-1)%(strings.get(i).length()))+1);
        		
                
                s1=s1.substring(0,((whichLetter2-1)%(strings.get(i).length())))+
                    (char)((int)(s1.charAt(((whichLetter2-1)%(strings.get(i).length()))))+(averageOfArray2%128))+
                        s1.substring(((whichLetter2-1)%(strings.get(i).length()))+1);
                result.add(s1);
                
        }

        return result;
      }
}
