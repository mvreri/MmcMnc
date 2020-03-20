package mccCountryCodes;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//this class has the scraper for the country codes
public class ccodeScraper {
	public static void Scrape() {

		Document doc = null;
		ccodesReadWrite ccrw = new ccodesReadWrite();
		String recrd=null, braces0="{", braces1="}";

		try {
			doc = Jsoup.connect("http://www.mcc-mnc.com/").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(doc);
		Element table = doc.getElementById("mncmccTable");
		Elements rows = table.getElementsByTag("tr");
		
		for (Element row : rows) {
			Elements tds = row.getElementsByTag("td");
			for (int i = 0; i < tds.size(); i++) {
				if (i == 0 ) {
					//System.out.println(tds.get(i).text());
					recrd = recrd +","+ "\"mcc\""+ tds.get(i).text();
				}
				if (i == 1 ) {
					//System.out.println(tds.get(i).text());
					recrd = recrd +","+ "\"mnc\""+ tds.get(i).text();
				}
				if (i == 4 ) {
					//System.out.println(tds.get(i).text());
					recrd = recrd +","+ "\"countryCode\""+ tds.get(i).text();
				}
				if (i == 5) {
					recrd = recrd +","+ "\"telco\"" + tds.get(i).text();
				}
				ccrw.WriteToFile("{" + recrd+ "}");
			}
		}
	
	}

}
