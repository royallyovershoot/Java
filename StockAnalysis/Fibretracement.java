package lation;

import java.util.zip.DataFormatException;

/**
 * 
 * @author Hussam
 * 
 * "In finance, Fibonacci retracement is a method of technical analysis for determining support and
 * resistance levels. They are named after their use of the Fibonacci sequence. Fibonacci
 * retracement is based on the idea that markets will retrace a predictable portion of a move, after
 * which they will continue to move in the original direction."-Wiki
 * 
 * This simple method accepts two arguments , the support and resistance values in your backtest
 * model. From which five outputs will be presented signifying a potential price diversion at each
 * of the output price.
 * 
 *
 * 
 * 
 * 
 */


public class Fibretracement
{
  private final float ZERO;
  private final float FIRST;
  private final float SECOND;
  private final float THIRD;
  private final float FOURTH;
  private final float FIFTH;
  private final String DISCLAIMER;

  public Fibretracement()
  {
    // default constructor
    this.ZERO = 0.0f;
    this.FIRST = 0.236f;
    this.SECOND = 0.382f;
    this.THIRD = 0.5f;
    this.FOURTH = 0.618f;
    this.FIFTH = 1.0f;
    this.DISCLAIMER =
        "DISLAIMER: THIS SOFTWARE BY NO MEANS IS RESPONSIBLE FOR ANY LOSSES INCURRED AS A RESULT OF DIRECTLY RELYING ON THE OUTCOME. USE OTHER TECHANICAL ANALYSIS TOOLS IN COMBINATIONS WITH THIS TOOL TO GET THE MOST RELIABLE PREDICTION";

  }
/**
 * 
 * @param support- Support Value
 * @param resistance- Resistance Value
 * @return String representing 5 values
 * @throws DataFormatException - if client number are negative or their diference is zero.
 */
  public String FibonacciRetract(float support, float resistance) throws DataFormatException
  {

    if (support < 0 || resistance < 0)
    {
      throw new DataFormatException("Values cannot be negative");
    } else
    {
      float diff = resistance - support;
      if (diff == 0)
      {
        throw new DataFormatException("Support and resitance values cannot be the same");
      }
      StringBuilder sb = new StringBuilder();
      System.out.println(getDISCLAIMER());
      System.out.println("Units are default to the numbers inserted");
      sb.append(" Zeroth = " + (diff * getZERO()) + "\n First = " + (diff * getFIRST())
          + "\n Second = " + (diff * getSECOND()) + "\n Third = " + (diff * getTHIRD())
          + "\n Fourth = " + (diff * getFOURTH() + "\n Fifth = " + (diff * getFIFTH())));
      return sb.toString();
    }
  }

  public String getDISCLAIMER()
  {
    return DISCLAIMER;
  }

  public float getZERO()
  {
    return ZERO;
  }

  public float getFIRST()
  {
    return FIRST;
  }

  public float getSECOND()
  {
    return SECOND;
  }

  public float getTHIRD()
  {
    return THIRD;
  }

  public float getFOURTH()
  {
    return FOURTH;
  }

  public float getFIFTH()
  {
    return FIFTH;
  }

}
