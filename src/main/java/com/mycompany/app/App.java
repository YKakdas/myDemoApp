package com.mycompany.app;

import java.util.ArrayList;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App 
{
    public static void main( String[] args )
    {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
          java.util.ArrayList<String> result=new ArrayList<>();
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
          int int1=0;
          int int2=0;
          String input1=req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          if(input1.equals("")){
              inputList1=null;
          }
          else{
          sc1.useDelimiter("[;\r\n]+");
          

          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
           
          }

          sc1.close();
        }
          String input2 = req.queryParams("input2");
         
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          if(input2.equals("")){
            inputList2=null;
        }
        else{
          sc2.useDelimiter("[;\r\n]+");
          

          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }

          sc2.close();
        }
          String input3 = req.queryParams("input3");
          
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          if(input3.equals("")){
            inputList3=null;
        }
        else{
          

          while (sc3.hasNext())
          {
            String value =sc3.nextLine();
            inputList3.add(value);
          }

          sc3.close();
        }
          String input4 = req.queryParams("input4");
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          if(!input4.equals(""))
          {
          sc4.useDelimiter("[;\r\n]+");
            int1 = Integer.parseInt(sc4.next().replaceAll("\\s",""));
          
          sc4.close();
        }
          String input5 = req.queryParams("input5");
          java.util.Scanner sc5 = new java.util.Scanner(input5);
          if(!input5.equals("")){
          sc5.useDelimiter("[;\r\n]+");
           int2 = Integer.parseInt(sc5.next().replaceAll("\\s",""));
          
          sc5.close();
          }
            if(inputList1==null || inputList2==null || inputList3==null)
                result.add("Missing input or inputs, result is cannot be shown");
            else
                result=App.changeLetter(inputList1,inputList2,inputList3,int1,int2);

          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
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
