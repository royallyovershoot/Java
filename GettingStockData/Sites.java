/**
@Author TRO

 * Contains list of sites to get Data from
 */
public class Sites
{
  /**
   * 
   * @param tickerName
   * @return Yahoo URL For specified ticker
   */
  public static String getYahooURL(String tickerName)
  {
       String yahooFianceURL="https://finance.yahoo.com/quote/"+tickerName+"/?p="+tickerName;
       return yahooFianceURL;
  }

}
