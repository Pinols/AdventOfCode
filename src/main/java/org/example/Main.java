package org.example;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File f = new File("C:/Users/Stefano/Desktop/adventP.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);


        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.now().plusHours(10);
        lt2 = lt2.plusMinutes(35);
        Duration d = Duration.between(lt1,lt2);

        //d.get(ChronoUnit.MINUTES);
        long ore,minuti;
        ore = ( d.getSeconds() / 3600);
        minuti = ( (d.getSeconds() - (ore*3600)) / 60 );

        System.out.println(ore);
        /*String[] lines = content.split("\r\n");

        int counter = 0;

        boolean a,b,cc;

        for(String s:lines){

            a=false;
            if ( !s.contains("ab") && !s.contains("cd") && !s.contains("pq") && !s.contains("xy") ) a=true;

            b = false;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i) == s.charAt(i+1) ){
                    b=true;
                    break;
                }
            }
            if(nic){
                counter++;
                continue;
            }

            cc=false;
            int vowel=0;
            for(char c : s.toCharArray()){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') vowel++;
            }
            if(vowel>2){
                cc=true;
            }

            if(a && b && cc){
                counter++;
            }
        }*/
        // 269 too high
        //System.out.println(counter);

        System.out.println("End");
    }

    public static void puzzleOne() throws IOException {
        File f = new File("C:/Users/Stefano/Desktop/advent.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        int floor = 0,steps=0;


        for(char c : content.toCharArray()){
            if(c == '(')floor++;
            else floor--;
            steps++;
            if(floor<0)break;
        }

        System.out.println(steps);

        System.out.println("debug me");
    }

    public static void puzzleTwo() throws IOException {
        File f = new File("C:/Users/Stefano/Desktop/adventP.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        int length=0,width=0,height=0,area=0;

        String[] lines = content.split("\r\n");

        int ribbon=0;
        for(String s : lines){
            String[] line = s.split("x");
            length= Integer.parseInt(line[0]);
            width= Integer.parseInt(line[1]);
            height= Integer.parseInt(line[2]);

            /*int area1 = (2*length*width);
            int area2 = (2*width*height);
            int area3 = (2*height*length);

            int min = Math.min(area1, area2);
            min = Math.min(min, area3);

            area += (area1 + area2 + area3 + (min/2) );*/
            int[] arr = new int[]{length,width,height};
            Arrays.sort(arr);

            ribbon += (arr[0]*2)+(arr[1]*2)+(height*width*length);
        }

        System.out.println(ribbon);
    }

    public static void puzzleThree() throws IOException {
        File f = new File("C:/Users/Stefano/Desktop/adventP.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        //String[] lines = content.split("\r\n");
        int grid[][] = new int[1001][1001];
        int i=500,j=500;
        int a=500,b=500;
        grid[i][j]=2;

        boolean flag = true;
        for(char c : content.toCharArray()){

            if(flag){
                if(c=='<')i--;
                else if(c=='>')i++;
                else if(c=='^')j--;
                else j++;
                grid[i][j]++;
            }else{
                if(c=='<')a--;
                else if(c=='>')a++;
                else if(c=='^')b--;
                else b++;
                grid[a][b]++;
            }
            flag=!flag;
        }
        int count=0;
        for(int[] arr : grid){
            for(int slot : arr){
                if(slot>0)count++;
            }
        }
        System.out.println(count);
    }

    public static void puzzle4() throws IOException {
        File f = new File("C:/Users/Stefano/Desktop/adventP.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        //String[] lines = content.split("\r\n");

        // key : bgvyzdsv
        // Hash: bbd0b4dcb0d07a947bf3c280f99baffd

        String key = "bgvyzdsv";

        int i = 0;

        String keyH="";
        String myHash="";
        do{
            keyH = key + "" + i;

            myHash = DigestUtils.md5Hex(keyH);

            if(myHash.startsWith("000000"))break;

            i++;
        }while(true);
        System.out.println(myHash);
        System.out.println(key + i);
        //not bgvyzdsv15907

        System.out.println("ddd");
    }
}
