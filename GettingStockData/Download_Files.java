/**
@Author TRO
*/
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/*
 * Given a direct download url, the file will be download to harddrive at directory :
 * C:\Users\TRO\Documents\Eclipse\Web
 */
public class Download_Files
{
  /**
   * Default Constructor
   */
  public Download_Files()
  {
    System.out.println("File Download Constructor Initiated");
  }

  /**
   * 
   * @param url- to download from
   * @throws IOException
   */
  public void downloadUrl(String url, String fileName)
  {


    URL website;
    try
    {
      website = new URL(url);
      try
      {
        downloadtoHarddrive(fileName, website);
      } catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (MalformedURLException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } // URL locator

  }

  private void downloadtoHarddrive(String fileName, URL website) throws IOException
  {
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());// read one byte at a time
    // from the website
    FileOutputStream fos = new FileOutputStream(fileName);// create a file to output the info
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);// source,start,end
    fos.close();// close the stream
    System.out.println(fileName + "Download Complete");
  }
}
