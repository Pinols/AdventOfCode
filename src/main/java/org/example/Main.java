package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
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

        System.out.println("ddd");
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
}
