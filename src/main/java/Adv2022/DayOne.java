package Adv2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DayOne {
    public static void main(String[] args) throws IOException {
        dayOnePart1();
        dayOnePart2();
    }

    public static void dayOnePart1() throws IOException {
        File f = new File("src/main/java/adv2022/advent2022_dayOne.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        String[] lines = content.split("\r\n");

        int max = 0, current= 0 ;
        for(String s : lines){
            if(!s.equals(""))current += Integer.parseInt(s);
            if(s.equals("") && current>max)max=current;
            if(s.equals(""))current=0;
        }

        System.out.println("Answer 1 is:" + max);
    }

    public static void dayOnePart2() throws IOException {
        File f = new File("src/main/java/adv2022/advent2022_dayOne.txt");
        String content = FileUtils.readFileToString(f, StandardCharsets.UTF_8);

        String[] lines = content.split("\r\n");

        int[] max = new int[1000];
        int current=0,i=0;
        for(String s : lines){
            if(!s.equals(""))current += Integer.parseInt(s);
            if(s.equals("")) {
                max[i]=current;
                current=0;
                i++;
            }
        }
        i++;
        max[i]=current;
        Arrays.sort(max);

        System.out.println("Answer 2 is:"+(max[max.length-1]+max[max.length-2]+max[max.length-3]));
    }
}
