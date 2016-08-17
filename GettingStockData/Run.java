/**
@Author TRO
*/
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
Main Class
*/
public class Run
{
  /** 
   * Running investopedia   
   * @param args
   * @throws IOException
   * @throws InterruptedException 
   */
  public static void main(String args[]) throws IOException, InterruptedException
  {
    Tickers tk = new Tickers();
    for(int i=364;i<tk.length();i++)
    {
      if(i%10==0)
      {
        TimeUnit.SECONDS.sleep(10);

      }
      String st= tk.TickerListNasdaq[i];
    
    String yahooURL="http://finance.yahoo.com/d/quotes.csv?s="+st+"&f=nabb2b3poc1cc6k2p2c8c3ghk1ll1t8w1w4p1mm2kjj5k4j6k5wva5b6k3a2ee7e8e9b4j4p5p6rr2r5r6r7s7ydr1qd1d2t1m5m6m7m8m3m4g1g3g4g5g6ij1j3f6nn4ss1xj2t7t6i5l2l3v1v7s6";
    //Stock_values sv = new Stock_values();
    //sv.getStockValueof();
    Download_Files df = new Download_Files();
    df.downloadUrl(yahooURL, st+".csv");
  }
  }
  
  
}
