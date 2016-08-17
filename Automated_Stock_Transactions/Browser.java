/**
@Author TRO
*/
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLButtonElement;

/**
This program automates the process of logging-in into Investopedia.com, carry a transaction and exit
*/
public class Browser
{

  // Initiate Webclient
  @SuppressWarnings("deprecation")

  public void submittingForm() throws Exception
  {

    final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getCookieManager().setCookiesEnabled(true);
    webClient.getOptions().setRedirectEnabled(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(false);
    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getCookieManager().setCookiesEnabled(true);


// getPage
    final HtmlPage page1 = webClient.getPage(
        "http://www.investopedia.com/accounts/login.aspx?returnurl=http://www.investopedia.com/simulator/");
    // Assert.assertEquals("Login | Investopedia", page1.getTitleText()); // action name
    final HtmlForm form = page1.getFirstByXPath("//form[@action='/accounts/login.aspx']");// getting

    System.out.println("Getting attribute Data");
    // getting login names
    final HtmlSubmitInput button = form.getInputByValue("Sign in");// getting Button By name
    final HtmlTextInput username = form.getInputByName("email");// getting field by Name
    final HtmlPasswordInput password = form.getInputByName("password");// getting field by Name

    System.out.println("Inserting Credentials");
    // Setting login values
    username.setValueAttribute("YOUR_EMAIL");
    System.out.println("User Name Inserted");
    password.setValueAttribute("YOUR_PASSWORD");
    System.out.println("Password Inserted");

    button.click();
    System.out.println("Signed-in");
    // wait tw seconds for page to load
    TimeUnit.SECONDS.sleep(2);
    System.out.println("Wait for 2 seconds Over");
    // http://www.investopedia.com/simulator/trade/tradestock.aspx
    final HtmlPage page3 =
        webClient.getPage("http://www.investopedia.com/simulator/trade/tradestock.aspx");// redirect
    System.out.println("Entered into Simulator"); // to stock
    // page

    TimeUnit.SECONDS.sleep(3);// delay for3 seconds
    /*
     * Assert.assertEquals(
     * "Investopedia Stock Simulator - Investopedia Stock Simulator - Trade a Stock",
     * page3.getTitleText());
     */
    System.out.println("Wait for 3 seconds Over");


    System.out.println("Entering Trading Page");
    // Trading Form Values
    System.out.println("Getting Form Name");
    final HtmlForm tradingform = page3.getFormByName("simTrade");// getting form name
    System.out.println("getting Type of Drop Down");
    final HtmlSelect select = (HtmlSelect) page3.getElementById("transactionTypeDropDown");
    System.out.println("Getting Stock Symbol");
    final HtmlTextInput STOCK_SYMBOL = tradingform.getInputByName("symbolTextbox");
    System.out.println("Getting Quantity info");
    // Selecting Element
    // final HtmlNumberInput Quantity = tradingform.getInputByName("quantityTextbox");
    final HtmlTextInput Quantity = tradingform.getInputByName("quantityTextbox");
    System.out.println("Selecting Radio Button");
    final HtmlRadioButtonInput radioButton =
        (HtmlRadioButtonInput) page3.getElementById("marketPriceRadioButton'");
    System.out.println("Getting Preview Order button- Enter");
    // final HtmlButtonInput Preview_order = (HtmlButtonInput)
    // page3.getElementById("previewButton");// getting ___>`
    final HtmlButtonInput Preview_order = (HtmlButtonInput) page3.getHtmlElementById("previewButton");
    System.out.println("Getting Preview Order Button -  Exit"); // Button
    // name


    // 1=buy, 2=sell, 3= sell Short 4= Buy to Cover
    STOCK_SYMBOL.setValueAttribute("IBM");// seeting STOCK symbol
    System.out.println("Stock Symbol Inserted");
    final HtmlOption option = select.getOptionByValue("1");// BUY
    System.out.println("Buy option Selected");
    select.setSelectedAttribute(option, true);
    Quantity.setValueAttribute("5");// setting 5 stocks

    System.out.println("Quantity of Stocks is entered");
    // radioButton.setChecked(true);// setting radio button on Market
    final HtmlPage page4 = Preview_order.click();// clicking the preview order button
    Preview_order.click();
    System.out.println("Preview order selected");
    System.out.println(page4);
    TimeUnit.SECONDS.sleep(3);
    System.out.println("3 Sec Over");
    System.out.println("Content of page4");

    final String pageAsText = page4.asText();
    if (pageAsText.contains(
        "The markets are closed right now. The market re-opens at 09:30 Eastern Daylight Time,"))
    {
      System.out.println("INDEED IN SUBMIT PAGE");
    } else
    {
      System.out.println("SORRY NOT IN SUBMIT PAGE");
    }
    // NEXT PAGE
    System.out.println("Entering Submit Page");
    // HtmlPage submiter = (HtmlPage) webClient.getCurrentWindow().getEnclosedPage();

    final HtmlForm Submitform = page4.getFormByName("simTradePreview");// getting From by name

    System.out.println("Submit Form Accessed");


    final HtmlButtonInput Submit_order = Submitform.getInputByName("submitOrder");
    System.out.println("Submit Form Initialized");
    Submit_order.click();
    webClient.close();
    System.out.println("TRANSACTON ENDED");


  }



}
