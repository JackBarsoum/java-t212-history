//Issue with code at the moment is error when there is a lot of empty columns can result in out of bounds errors.

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


class Take_Data {

    private static ArrayList<String> action = new ArrayList<>();
    private static ArrayList<String> time = new ArrayList<>();
    private static ArrayList<String> ISIN = new ArrayList<>();
    private static ArrayList<String> ticker = new ArrayList<>();
    private static ArrayList<String> name = new ArrayList<>();
    private static ArrayList<Double> noOfShares = new ArrayList<>();
    private static ArrayList<Double> pricePerShare = new ArrayList<>();
    private static ArrayList<String> currency= new ArrayList<>();
    private static ArrayList<Double> exchangeRate = new ArrayList<>();
    private static ArrayList<Double> result = new ArrayList<>();
    private static ArrayList<String> currencyofResult = new ArrayList<>();
    private static ArrayList<Double> total = new ArrayList<>();
    private static ArrayList<String> currencyofTotal = new ArrayList<>();
    private static ArrayList<Double> withholdingTax = new ArrayList<>();
    private static ArrayList<String> currencyofWithholdingTax = new ArrayList<>();
    private static ArrayList<Double> stampDutyReserveTax = new ArrayList<>();
    private static ArrayList<String> currencyofStampDutyReserveTax = new ArrayList<>();
    private static ArrayList<String> notes = new ArrayList<>();
    private static ArrayList<String> ID = new ArrayList<>();
    private static ArrayList<Double> currencyConversionFee = new ArrayList<>();
    private static ArrayList<String> currencyCurrencyConversionFee = new ArrayList<>();

    public static void addAction(String newAction) {
        action.add(newAction);
    }

    public static void addTime(String newTime) {
        time.add(newTime);
    }

    public static void addISIN(String newISIN) {
        ISIN.add(newISIN);
    }

    public static void addTicker(String newTicker) {
        ticker.add(newTicker);
    }

    public static void addName(String newName) {
        name.add(newName);
    }

    public static void addNoOfShares(Double newNoOfShares) {
        noOfShares.add(newNoOfShares);
    }

    public static void addPricePerShare(Double newPricePerShare) {
        pricePerShare.add(newPricePerShare);
    }

    public static void addCurrencyPricePerShare(String newCurrencyPricePerShare) {
        currency.add(newCurrencyPricePerShare);
    }

    public static void addExchangeRate(Double newExchangeRate) {
        exchangeRate.add(newExchangeRate);
    }

    public static void addResult(Double newResult) {
        result.add(newResult);
    }

    public static void addCurrencyResult(String newCurrencyResult) {
        currencyofResult.add(newCurrencyResult);
    }

    public static void addTotal(Double newTotal) {
        total.add(newTotal);
    }

    public static void addCurrencyTotal(String newCurrencyTotal) {
        currencyofTotal.add(newCurrencyTotal);
    }

    public static void addWithholdingTax(Double newWithholdingTax) {
        withholdingTax.add(newWithholdingTax);
    }

    public static void addCurrencyWithholdingTax(String newCurrencyWithholdingTax) {
        currencyofWithholdingTax.add(newCurrencyWithholdingTax);
    }

    public static void addStampDutyReserveTax(Double newStampDutyReserveTax) {
        stampDutyReserveTax.add(newStampDutyReserveTax);
    }

    public static void addCurrencyStampDutyReserveTax(String newCurrencyStampDutyReserveTax) {
        currencyofStampDutyReserveTax.add(newCurrencyStampDutyReserveTax);
    }

    public static void addNotes(String newNotes) {
        notes.add(newNotes);
    }

    public static void addID(String newID) {
        ID.add(newID);
    }

    public static void addCurrencyConversionFee(Double newCurrencyConversionFee) {
        currencyConversionFee.add(newCurrencyConversionFee);
    }

    public static void addCurrencyCurrencyConversionFee(String newCurrencyCurrencyConversionFee) {
        currencyCurrencyConversionFee.add(newCurrencyCurrencyConversionFee);
    }


    public static void readFile() throws IOException {
        String csvFile = "C:/Users/oisin/Downloads/2023-2024_trades.csv";
        String cvsSplitBy = ",";
        Scanner read = new Scanner(new File(csvFile));
        int count = 0;

        // Skip the header line if present
        if (read.hasNextLine()) {
            read.nextLine();
        }

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] row = line.split(cvsSplitBy);
            System.out.println(row.length);
            addAction(row[0]);
            addTime(row[1]);
            addISIN(row[2]);
            addTicker(row[3]);
            addName(row[4]);
            addNoOfShares(Double.parseDouble(row[5]));
            addPricePerShare(Double.parseDouble(row[6]));
            addCurrencyPricePerShare(row[7]);
            //if not avaible let exhange = -1
            if(Objects.equals(row[8], "Not available")){
                addExchangeRate(-1.0);
            }else {
                addExchangeRate(Double.parseDouble(row[8]));
            }
            if(row[9].isEmpty()){
                addResult(0.0);
            }else {
                addResult(Double.parseDouble(row[9]));
            }
            addCurrencyResult(row[10]);
            addTotal(Double.parseDouble(row[11]));
            addCurrencyTotal(row[12]);
            if(row[13].isEmpty()){
                addWithholdingTax(0.0);
            }else {
                addWithholdingTax(Double.parseDouble(row[13]));
            }
            if(row[14].isEmpty()){
                addCurrencyWithholdingTax("");
            }else {
                addCurrencyWithholdingTax(row[14]);
            }
            if(row[15].isEmpty()){
                addStampDutyReserveTax(0.0);
            }else {
                addStampDutyReserveTax(Double.parseDouble(row[15]));
            }
            if (row[16].isEmpty()){
                addCurrencyStampDutyReserveTax("");
            }else {
                addCurrencyStampDutyReserveTax(row[16]);
            }
            System.out.println(row[16]);
            if (row[17].isEmpty()){
                addNotes("");
            }else{
                addNotes(row[17]);
            }
            addID(row[18]);
            if(row.length > 19) {
                if (row[19].isEmpty()) {
                    addCurrencyConversionFee(0.0);
                } else {
                    addCurrencyConversionFee(Double.parseDouble(row[19]));
                }
                if (row[20].isEmpty()) {
                    addCurrencyCurrencyConversionFee("");
                } else {
                    addCurrencyCurrencyConversionFee("");
                }
            }else{
                addCurrencyConversionFee(0.0);
                addCurrencyCurrencyConversionFee("");
            }
            count++;
            System.out.println(count);
        }



        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }


}