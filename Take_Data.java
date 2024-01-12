//Issue with code at the moment is error when there is a lot of empty columns can result in out of bounds errors.

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Take_Data {
    //                  GETTER AND SETTER METHODS
    public void setAction(String action) {
        this.action = action;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNumOfShares(double numOfShares) {
        this.numOfShares = numOfShares;
    }

    public void setPricePershare(double pricePershare) {
        this.pricePershare = pricePershare;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setCurrencyofResult(String currencyofResult) {
        this.currencyofResult = currencyofResult;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCurrencyofTotal(String currencyofTotal) {
        this.currencyofTotal = currencyofTotal;
    }

    public void setWithholdingTax(double withholdingTax) {
        this.withholdingTax = withholdingTax;
    }

    public void setCurrencyofWithholdingTax(String currencyofWithholdingTax) {
        this.currencyofWithholdingTax = currencyofWithholdingTax;
    }

    public void setStampDuty(double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public void setCurrencyofStampDuty(String currencyofStampDuty) {
        this.currencyofStampDuty = currencyofStampDuty;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setConversionFee(double conversionFee) {
        this.conversionFee = conversionFee;
    }

    public void setCurrencyConversionFee(String currencyConversionFee) {
        this.currencyConversionFee = currencyConversionFee;
    }

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

    //                      END OF GETTER AND SETTER METHODS

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
        // Skip the header line if present
        if (read.hasNextLine()) {
            read.nextLine();
        }
        //Size of each row
        String[] newArray = new String[21];

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] row = line.split(cvsSplitBy);
            //Copy current row into our Array this ensures it is always the same size
            System.arraycopy(row, 0, newArray, 0, row.length);

            //Checks for null or empty string might make a helper method for this to clean code later
            if(newArray[2] == null || newArray[2].trim().isEmpty())
            {
                newArray[2] = "";
            }
            if(newArray[3] == null || newArray[3].trim().isEmpty())
            {
                newArray[3] = "";
            }
            if(newArray[4] == null || newArray[4].trim().isEmpty())
            {
                newArray[4] = "";
            }
            if(newArray[5] == null || newArray[4].trim().isEmpty())
            {
                newArray[5] = "0.0";
            }
            if(newArray[6] == null || newArray[5].trim().isEmpty())
            {
                newArray[6] = "0.0";
            }
            if(newArray[7] == null || newArray[7].trim().isEmpty())
            {
                newArray[7] = "";
            }
            if (newArray[8] == null || Objects.equals(newArray[8], "Not available") ) {
                newArray[8] = "0.0";
            }
            if (newArray[9] == null  || newArray[9].trim().isEmpty()) {
                newArray[9] = "0.0";
            }
            if(newArray[10] == null || newArray[10].trim().isEmpty())
            {
                newArray[10] = "";
            }
            if (newArray[13] == null  || newArray[13].trim().isEmpty()) {
                newArray[13] = "0.0";
            }
            if (newArray[14] == null  || newArray[14].trim().isEmpty()) {
                newArray[14] = "";
            }
            if (newArray[15] == null  || newArray[15].trim().isEmpty()) {
                newArray[15] = "0.0";
            }
            if (newArray[16] == null  || newArray[16].trim().isEmpty()) {
                newArray[16] = "";
            }
            if (newArray[17] == null  || newArray[17].trim().isEmpty()) {
                newArray[17] = "";
            }
            if (newArray[18] == null  || newArray[18].trim().isEmpty()) {
                newArray[18] = "";
            }

            if ( newArray[19] == null  || newArray[19].trim().isEmpty()) {
                    newArray[19] = "0.0";
            }
            if (newArray[20] == null  || newArray[20].trim().isEmpty()) {
                    newArray[20] = "";
            }

            //Print out the current row for testing purposes
            for (int i = 0; i < row.length; i++){
                System.out.println(row[i]);
            }
            temp = new Take_Data(newArray[0], newArray[1], newArray[2], newArray[3], newArray[4], Double.parseDouble(newArray[5]), Double.parseDouble(newArray[6]), row[7], Double.parseDouble(newArray[8]), Double.parseDouble(newArray[9]), newArray[10], Double.parseDouble(newArray[11]), newArray[12], Double.parseDouble(newArray[13]), newArray[14], Double.parseDouble(newArray[15]), newArray[16], newArray[17], newArray[18], Double.parseDouble(newArray[19]), newArray[20]);
            count++;
            //Add our temp Take_Data to our Arraylist of Take_Data
            fullData.add(temp);
        }


        return fullData;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Take_Data> dataList = Take_Data.readFile();
        for (Take_Data data : dataList) {
            System.out.println(data.getName() + ": " + data.getResult());
        }
    }
}