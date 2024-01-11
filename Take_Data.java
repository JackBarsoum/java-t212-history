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
        String csvFile = "C:/Users/Jack Barsoum/IdeaProjects/T212/src";
        String cvsSplitBy = ",";
        Scanner read = new Scanner(new File(csvFile));
        int count = 0;
        Take_Data temp;
        // Skip the header line if present
        if (read.hasNextLine()) {
            read.nextLine();
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] row = line.split(cvsSplitBy);
            //Create a new Take_Data some of the values are defaulted now and are set later after checks
            temp = new Take_Data(row[0], row[1], row[2], row[3], row[4], Double.parseDouble(row[5]), Double.parseDouble(row[6]), row[7], -1, 0, row[10], Double.parseDouble(row[11]), row[12], 0, "", 0, "", "", row[18], 0, "");
            //if not avaible let exhange = -1
            if (Objects.equals(row[8], "Not available")) {
                temp.setExchangeRate(-1);
            } else {
                temp.setExchangeRate(Double.parseDouble(row[8]));
            }
            if (row[9].isEmpty()) {
                temp.setResult(0.0);
            } else {
                temp.setResult(Double.parseDouble(row[9]));
            }
            if (row[13].isEmpty()) {
                temp.setWithholdingTax(0.0);
            } else {
                temp.setWithholdingTax(Double.parseDouble(row[13]));
            }
            if (row[14].isEmpty()) {
                temp.setCurrencyofWithholdingTax("");
            } else {
                temp.setCurrencyofWithholdingTax(row[14]);
            }
            if (row[15].isEmpty()) {
                temp.setStampDuty(0.0);
            } else {
                temp.setStampDuty(Double.parseDouble(row[15]));
            }
            if (row[16].isEmpty()) {
                temp.setCurrencyofStampDuty("");
            } else {
                temp.setCurrencyofStampDuty(row[16]);
            }
            System.out.println(row[16]);
            if (row[17].isEmpty()) {
                temp.setNotes("");
            } else {
                temp.setNotes(row[17]);
            }
            if (row.length > 19) {
                if (row[19].isEmpty()) {
                    temp.setConversionFee(0.0);
                } else {
                    temp.setConversionFee(Double.parseDouble(row[19]));
                }
                if (row[20].isEmpty()) {
                    temp.setCurrencyConversionFee("");
                } else {
                    temp.setCurrencyConversionFee("");
                }
            } else {
                temp.setConversionFee(0.0);
                temp.setCurrencyConversionFee("");
            }
            count++;
            System.out.println(count);
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