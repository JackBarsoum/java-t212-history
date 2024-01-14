/*************************************************************
 *                Trading212 History Reader                  *
 *                   By: Jack Barsoum &                      *
 *                       Oisin Lynch                         *
 *                    Last Updated: 14/01/2024               *
 *************************************************************
 */
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.Map;

public class Take_Data {
    //                  GETTER METHODS
    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public String getISIN() {
        return ISIN;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public double getNumOfShares() {
        return numOfShares;
    }

    public double getPricePershare() {
        return pricePershare;
    }

    public String getCurrency() {
        return currency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getResult() {
        return result;
    }

    public String getCurrencyofResult() {
        return currencyofResult;
    }

    public double getTotal() {
        return total;
    }

    public String getCurrencyofTotal() {
        return currencyofTotal;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public String getCurrencyofWithholdingTax() {
        return currencyofWithholdingTax;
    }

    public double getStampDuty() {
        return stampDuty;
    }

    public String getCurrencyofStampDuty() {
        return currencyofStampDuty;
    }

    public String getNotes() {
        return notes;
    }

    public String getID() {
        return ID;
    }

    public double getConversionFee() {
        return conversionFee;
    }

    public String getCurrencyConversionFee() {
        return currencyConversionFee;
    }

    //                      END OF GETTER METHODS

    //Instance variables
    private String action;
    private String time;
    private String ISIN;
    private String ticker;
    private String name;
    private double numOfShares;
    private double pricePershare;
    private String currency;
    private double exchangeRate;
    private double result;
    private String currencyofResult;
    private double total;
    private String currencyofTotal;
    private double withholdingTax;
    private String currencyofWithholdingTax;
    private double stampDuty;
    private String currencyofStampDuty;
    private String notes;
    private String ID;
    private double conversionFee;
    private String currencyConversionFee;


    //Constructor
    public Take_Data(String a, String t, String I, String tick, String n, double num,
                     double pricep, String cur, double exc, double res, String curres, double tot, String curroft, double withtax,
                     String curroftax, double stamp, String stampcur, String note, String identifier, double conversion, String currofConversion) {
        this.action = a;
        this.time = t;
        this.ISIN = I;
        this.ticker = tick;
        this.name = n;
        this.numOfShares = num;
        this.pricePershare = pricep;
        this.currency = cur;
        this.exchangeRate = exc;
        this.result = res;
        this.currencyofResult = curres;
        this.total = tot;
        this.currencyofTotal = curroft;
        this.withholdingTax = withtax;
        this.currencyofWithholdingTax = curroftax;
        this.stampDuty = stamp;
        this.currencyofStampDuty = stampcur;
        this.notes = note;
        this.ID = identifier;
        this.conversionFee = conversion;
        this.currencyConversionFee = currofConversion;
    }

    public static ArrayList<Take_Data> readFile() throws IOException {
        ArrayList<Take_Data> fullData = new ArrayList<Take_Data>();
        //**  To be replaced with prompt for user to enter in the file path  **
        String csvFile = "C:/Users/jackb/Downloads/2023-2024.csv";
        String cvsSplitBy = ",";
        Scanner read = new Scanner(new File(csvFile));
        int count = 0;
        Take_Data temp;
        Take_Data l = new Take_Data("","","","","",0.0,0.0,"",0.0,0.0,"",0.0,"",0.0,"",0.0,"","","",0.0,"");
        // Skip the header line if present
        if (read.hasNextLine()) {
            read.nextLine();
        }
        //Size of each row
        String[] newArray = new String[21];

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] row = line.split(cvsSplitBy);
            Arrays.fill(newArray, null);
            //Copy current row into our Array this ensures it is always the same size
            System.arraycopy(row, 0, newArray, 0, row.length);

            //Checks for null or empty string might make a helper method for this to clean code later
            if(l.improvedEmpty(newArray[2]))
            {
                newArray[2] = "";
            }
            if(l.improvedEmpty(newArray[3]))
            {
                newArray[3] = "";
            }
            if(l.improvedEmpty(newArray[4]))
            {
                newArray[4] = "";
            }
            if(l.improvedEmpty(newArray[5]))
            {
                newArray[5] = "0.0";
            }
            if(l.improvedEmpty(newArray[6]))
            {
                newArray[6] = "0.0";
            }
            if(l.improvedEmpty(newArray[7]))
            {
                newArray[7] = "";
            }
            if (l.improvedEmpty(newArray[8]) || Objects.equals(newArray[8], "Not available")) {
                newArray[8] = "0.0";
            }
            if (l.improvedEmpty(newArray[9])) {
                newArray[9] = "0.0";
            }
            if(l.improvedEmpty(newArray[10]))
            {
                newArray[10] = "";
            }
            if (l.improvedEmpty(newArray[13])) {
                newArray[13] = "0.0";
            }
            if (l.improvedEmpty(newArray[14])) {
                newArray[14] = "";
            }
            if (l.improvedEmpty(newArray[15])) {
                newArray[15] = "0.0";
            }
            if (l.improvedEmpty(newArray[16])) {
                newArray[16] = "";
            }
            if (l.improvedEmpty(newArray[17])) {
                newArray[17] = "";
            }
            if (l.improvedEmpty(newArray[18])) {
                newArray[18] = "";
            }

            if (l.improvedEmpty(newArray[19])) {
                    newArray[19] = "0.0";
            }
            if (l.improvedEmpty(newArray[20])) {
                    newArray[20] = "";
            }
            temp = new Take_Data(newArray[0], newArray[1], newArray[2], newArray[3], newArray[4], Double.parseDouble(newArray[5]), Double.parseDouble(newArray[6]), row[7], Double.parseDouble(newArray[8]), Double.parseDouble(newArray[9]), newArray[10], Double.parseDouble(newArray[11]), newArray[12], Double.parseDouble(newArray[13]), newArray[14], Double.parseDouble(newArray[15]), newArray[16], newArray[17], newArray[18], Double.parseDouble(newArray[19]), newArray[20]);
            count++;
            //Add our temp Take_Data to our Arraylist of Take_Data
            fullData.add(temp);
        }


        return fullData;
    }

    //Helper method to make code look neater
    public boolean improvedEmpty(String p)
    {
        return (p == null ||p.trim().isEmpty());
    }


    //**Need to make look nicer in the future**
    @Override
    public String toString()
    {
        return "Action: \t\t\t At time: \t\t\t Stock Name: \t\t\t With Ticker: \t Shares: \t Price/Share: \t Currency: \t Exchange Rate:  \t Result: \t Total:  \t Currency Conversion Fee: \t Withholding Tax: \t Stamp duty: \n" +getAction()+" "+getTime()+" "+getName()+" "+getTicker()+" "+getNumOfShares()+" "+getPricePershare()+" "+getCurrency()+" "+getExchangeRate()+" "+getResult()+" "+getTotal()+" "+getCurrencyConversionFee()+" "+getWithholdingTax()+" "+getStampDuty();
    }

    //Method to get total profit made from history
    public static String totalProfit(ArrayList<Take_Data> fulldata)
    {
        double profit = 0.0;
        for (Take_Data data: fulldata)
        {
            profit += data.getResult();
        }
        DecimalFormat df = new DecimalFormat("#.##"); // Specify the number of decimal places
        String roundedProfit = df.format(profit);
        return "Your total profit from trading was: "+roundedProfit;
    }

    //Method to get the most amount of money made in a single trade
    public static String biggestTrade(ArrayList<Take_Data> fulldata)
    {
        double max = 0.0;
        String ticker = "";
        String name = "";
        for (Take_Data data: fulldata)
        {
             if(max < data.getResult())
             {
                 max = data.getResult();
                 ticker = data.getTicker();
                 name = data.getName();
             }
        }
        return "Your biggest trade that made you the most profit is: "+max+ ". The name of the stock is "+name+", with ticker: "+ticker;
    }

    //Method to group all of our trades under the key of a ticker using a hashmap
    public static String pairedTrade(ArrayList<Take_Data> fulldata)
    {
        //Make a list with our Arraylist of data
        List<Take_Data> dataListgroup = fulldata;

        //Create a hashmap with format String using our data
        Map<String, List<Take_Data>> groupedDataList = new HashMap<>();

        //Go through all the data in our list
        for (Take_Data data: dataListgroup)
        {
            //Get the current ticker
            String tickersymbol = data.getTicker();
            //If our hashmap contains the ticker already
            if(groupedDataList.containsKey(tickersymbol))
            {
                //Go to our saved ticker symbol and add the data for that ticker onto it
                groupedDataList.get(tickersymbol).add(data);
            }
            //If we have not encountered the ticker before
            else
            {
                //Create a new arraylist and add our data to it and add that data to our newly inputted ticker
                List<Take_Data> newsymbol = new ArrayList<>();
                newsymbol.add(data);
                groupedDataList.put(tickersymbol, newsymbol);
            }
        }

        //Iterate through our keys in our hashmap
        for (String tickerSymbol: groupedDataList.keySet())
        {
            //Get the data for the ticker symbol and make it a list
            List<Take_Data> data = groupedDataList.get(tickerSymbol);

            //If the current symbol is empty then it is an interest
            if (tickerSymbol.trim().isEmpty())
            {
                System.out.println("Interest: ");
            }
            else {
                System.out.println("Ticker: " + tickerSymbol);
            }
            //Go through our data and print out its toString method
            for (Take_Data data1 : data)
            {
                System.out.println("" + data1);
            }
            System.out.println();
        }
        //Blank return
        return "";
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Take_Data> dataList = Take_Data.readFile();
        System.out.println(Take_Data.totalProfit(dataList));
        System.out.println(Take_Data.biggestTrade(dataList));
        System.out.println(pairedTrade(dataList));
        }
    }