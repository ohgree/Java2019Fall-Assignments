/**
 * CSE3040 HW3
 * Level021.java
 * Purpose: Parse top 50 bestsellers from Aladin bookstore website.
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Level021 {
    final static String address = "https://aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0";
    public static void main(String[] args) {
        ArrayList<String> page = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> author = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(
                /* I really DO HATE YOU ALADIN, MS949 encoding */
                new InputStreamReader(new URL(address).openStream(), "MS949"))){
            while((line = br.readLine()) != null) {
                /* blank lines are ignored */
                if(line.trim().length() > 0)
                    page.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean inDiv = false, getAuthor = false;
        String year=null, month=null, week=null;
        int start, end, rank=0;

        /* iterate by lines */
        for(String l: page) {

            /* select newbg_body div */
            if(l.contains("<div id=\"newbg_body\""))
                inDiv = true;
            if(!inDiv) continue;

            /* get year, month, and week */
            if(l.contains("<div class=\"newbs_year\"")) {
                start = l.indexOf("hDisplayHide('Layer_Year')\">") + "hDisplayHide('Layer_Year')\">".length();
                end = l.indexOf("<img src=");
                year = l.substring(start, end);
            } else if(l.contains("<div class=\"newbs_month\"")) {
                start = l.indexOf("hDisplayHide('Layer_Month')\">") + "hDisplayHide('Layer_Month')\">".length();
                end = l.indexOf("<img src=");
                month = l.substring(start, end);
            } else if(l.contains("<div class=\"newbs_week\"")) {
                start = l.indexOf("hDisplayHide('Layer_Week')\">") + "hDisplayHide('Layer_Week')\">".length();
                end = l.indexOf("<img src=");
                week = l.substring(start, end);
            }

            /* get book name */
            if(l.contains("class=\"bo3\"><b>")) {
                String s = l.substring(l.indexOf("class=\"bo3\"><b>"));
                start = s.indexOf("<b>") + "<b>".length();
                end = s.indexOf("</b>");
                name.add(s.substring(start, end));
                getAuthor = true;
                continue;
            }

            /* author info comes right after the line containing book name */
            if(getAuthor) {
                getAuthor = false;
                l = l.substring(0, l.indexOf("|")); // remove unnecessary trailing string after '|'

                start = l.indexOf("\">") + "\">".length();
                end = l.indexOf("</a>");
                author.add(l.substring(start, end));
            }
        }

        /* printing out data */
        System.out.println("[" + year + " " + month + " " + week + "]");
        for(int i=0 ; i<name.size() ; i++) {
            System.out.println((i+1) + "위: " + name.get(i) + " (" + author.get(i) + ")");
        }
    }
}
