import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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

    public boolean improvedEmpty(String p)
    {
        return (p == null ||p.trim().isEmpty());
    }

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


    public static void main(String[] args) throws IOException {
        ArrayList<Take_Data> dataList = Take_Data.readFile();
        System.out.println(Take_Data.totalProfit(dataList));
        System.out.println(Take_Data.biggestTrade(dataList));
        }
    }
