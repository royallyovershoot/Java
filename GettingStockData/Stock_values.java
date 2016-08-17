/**
@Author TRO
*/
import java.io.IOException;
import java.io.PrintWriter;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Stock_values
{
  public Stock_values()
  {
    // default constructor
  }

  /**
   * Getting info from a single stock value
   * @param StockTicker
   * @throws IOException
   */
  public void getStockValueof(String StockTicker) throws IOException
  {
    Stock stock = YahooFinance.get(StockTicker);
    stock.print();
  }

  /**
   * Getting info from array of stock values, 
   * @param StockTicker
   * @throws IOException
   */
  public void getStockValueof(String[] StockTicker) throws IOException
  {
    for (int i = 0; i < StockTicker.length - 1; i++)
    {
      Stock stock = YahooFinance.get(StockTicker[i]);  
      stock.print();

    }
  }
 



}
