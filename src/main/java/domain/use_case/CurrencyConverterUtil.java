package domain.use_case;

import java.util.Optional;

import data.repository.currency.CurrencyRepositoryImpl;
import domain.model.currency.Currency;

/**
 * Utility class for currency conversion.
 * This class provides static methods to convert currency between different units.
 */
public class CurrencyConverterUtil {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private CurrencyConverterUtil() {}

    /**
     * Converts the specified amount of currency from the source currency to the target currency.
     *
     * @param sourceCurrency the source currency to convert from.
     * @param targetCurrency the target currency to convert to.
     * @param amount         the amount of currency to convert.
     * @return the converted amount of currency.
     */
    public static double convertCurrency(Currency sourceCurrency, Currency targetCurrency, double amount) {
        double sourceRate = sourceCurrency.exchangeValue();
        double targetRate = targetCurrency.exchangeValue();

        // Perform the currency conversion calculation
        return (amount / sourceRate) * targetRate;
    }

    /**
     * Converts the specified amount of currency from the source currency to the target currency.
     *
     * @param sourceCurrency the symbol of the source currency to convert from.
     * @param targetCurrency the symbol of the target currency to convert to.
     * @param amount         the amount of currency to convert.
     * @return the converted amount of currency.
     */
    public static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        Optional<Currency> sourceItem = CurrencyRepositoryImpl.INSTANCE.getItemByName(sourceCurrency);
        Optional<Currency> targetItem = CurrencyRepositoryImpl.INSTANCE.getItemByName(targetCurrency);
        double result = 0;

        // Perform the currency conversion calculation
        if (sourceItem.isPresent() && targetItem.isPresent()) {
            Currency sourceCurr = sourceItem.get();
            Currency targetCurr = targetItem.get();
            result = convertCurrency(sourceCurr, targetCurr, amount);
        }

        return result;
    }
}
