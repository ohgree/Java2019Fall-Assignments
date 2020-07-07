/**
 * CSE3040 HW3
 * Level022.java
 * Purpose: Parse top 50 bestsellers from Aladin bookstore website,
 *          using jsoup library.
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Level022 {
    final static String address = "https://aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0";
    public static void main(String[] args) {
        Document doc = null;

        try {
            doc = Jsoup.connect(address).get();
        } catch(IOException e) {
            e.printStackTrace();
        }

        /* parse body div */
        Elements body = doc.select("div#newbg_body");

        /* parse year, month, week */
        Elements year = body.select("div.newbs_year");
        Elements month = body.select("div.newbs_month");
        Elements week = body.select("div.newbs_week");

        /* parse book list div */
        Elements bookList = body.select("div.ss_book_list");

        /* parse name and author from book list div */
        Elements name = bookList.select("a.bo3[href]").select("b");

        /* author list */
        ArrayList<String> authors = new ArrayList<>();

        /* for each book list div, search for first author */
        for(int i=0 ; i<bookList.size() ; i++) {
            Elements au = bookList.eq(i).select("a[href*=AuthorSearch]");
            if(au.size() > 0)
                authors.add(au.eachText().get(0));
        }

        /* printing out results */
        System.out.println("[" + year.eachText().get(0) + " " + month.eachText().get(0) + " " + week.eachText().get(0) + "]");
        for(int i=0 ; i<name.eachText().size() ; i++) {
            System.out.println((i+1) + "위: " + name.eachText().get(i) + " (" + authors.get(i) + ")");
        }
    }
}
