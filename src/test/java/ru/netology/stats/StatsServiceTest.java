package ru.netology.stats;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsServiceTest {
    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 180")
    void testSum(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.sum(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 15")
    void testAverage(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.average(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 6")
    void testMaxSales(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.maxSales(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 9")
    void testMinSales(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.minSales(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 5")
    void testNumberOfMonthsLessThanAverage(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.numberOfMonthsLessThanAverage(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource("'8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18', 5")
    void testNumberOfMonthsMoreThanAverage(String column1, long expected) {
        long[] sales = convertStringToArray(column1);
        StatsService statsService = new StatsService();
        long actual = statsService.numberOfMonthsMoreThanAverage(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }


    // ------------------------------------------------------
    // Взяла эту часть из интернет
    public long[] convertStringToArray(String str) {
        String[] strArray = str.split(",");
        long[] sales = new long[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            sales[i] = Long.parseLong(strArray[i].trim());
        }
        return sales;
    }
    // ------------------------------------------------------
}




















