package tools;

import entities.City;

import entities.Country;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repositories.CityRepository;
import repositories.CountryRepository;

import java.awt.font.TextMeasurer;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Loader {
    static public void loadCitiesCapitals(CityRepository cities, CountryRepository countries) throws SQLException {
        OPCPackage pkg = null;
        try {
            pkg = OPCPackage.open(new File("E:\\AN2\\ProiectePA\\PA_LAB8\\src\\main\\resources\\cities.xlsx"));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
//creating workbook instance that refers to .xls file
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(pkg);
        } catch (IOException e) {
            e.printStackTrace();
        }
//creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        int skipHeader = 1;
        for (Row row : sheet)     //iteration over row using for each loop
        {
            if (skipHeader == 1) {
                skipHeader = 0;
                continue;
            }
            int columnIndex = 1;
            City tempCity = new City();
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                switch (columnIndex) {
                    case 1:
                        tempCity.setName(cell.getStringCellValue());
                        break;
                    case 2:
                        tempCity.setCountry(cell.getStringCellValue());
                        break;
                    case 3:
                        tempCity.setLatitude(cell.getNumericCellValue());
                        break;
                    case 4:
                        tempCity.setLongitude(cell.getNumericCellValue());
                        Country newCountry = new Country(tempCity.getCountry());
                        newCountry.getCitySet().add(tempCity);
                        countries.save(newCountry);
                        cities.save(tempCity);
                        System.out.println(tempCity);
                        break;
                }
                columnIndex++;
            }
            System.out.println();
        }
    }

    static public void loadCities(CityRepository cities) throws SQLException {
        OPCPackage pkg = null;
        try {
            pkg = OPCPackage.open(new File("E:\\AN2\\ProiectePA\\PA_LAB9\\src\\main\\resources\\citiesGood.xlsx"));
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
//creating workbook instance that refers to .xls file
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(pkg);
        } catch (IOException e) {
            e.printStackTrace();
        }
//creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type
        int skipHeader = 1;
        for (Row row : sheet)     //iteration over row using for each loop
        {
            if (skipHeader == 1) {
                skipHeader = 0;
                continue;
            }
            int columnIndex = 1;
            City tempCity = new City();
            for (Cell cell : row)    //iteration over cell using for each loop
            {
                switch (columnIndex) {
                    case 1:
                        tempCity.setName(cell.getStringCellValue());
                        break;
                    case 2:
                        tempCity.setCountry(cell.getStringCellValue());
                        break;

                    case 3:
                        String tempString = cell.getStringCellValue();
                        if (tempString.equals("true"))
                            tempCity.setCapital(true);
                        else
                            tempCity.setCapital(false);
                        break;
                    case 4:
                        tempCity.setLatitude(cell.getNumericCellValue());
                        break;
                    case 5:
                        tempCity.setLongitude(cell.getNumericCellValue());
                        cities.save(tempCity);
                        /**
                         * aici printez orasul adaugat
                         */
                        // System.out.println(tempCity);
                        break;

                }
                columnIndex++;
            }
            //System.out.println();
        }
    }

}