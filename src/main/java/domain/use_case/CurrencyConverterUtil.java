package domain.use_case;

import java.util.Optional;

import data.repository.currency.CurrencyRepositoryImpl;
import domain.model.currency.Currency;

public class CurrencyConverterUtil {
	
	private CurrencyConverterUtil() {}
	
    public static double convertCurrency(Currency sourceCurrency, Currency targetCurrency, double amount) {
        double sourceRate = sourceCurrency.exchangeValue();
        double targetItem = targetCurrency.exchangeValue();

        // Perform the currency conversion calculation
        return (amount / sourceRate) * targetItem;
    }
    
    public static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        Optional<Currency> sourceItem = 
        		CurrencyRepositoryImpl.INSTANCE.getItemByName(sourceCurrency);
        Optional<Currency> targetItem = 
        		CurrencyRepositoryImpl.INSTANCE.getItemByName(targetCurrency);
        double result = 0;
        // Perform the currency conversion calculation
        if(sourceItem.isPresent() && targetItem.isPresent()) {
        	Currency sourceCurr = sourceItem.get();
        	Currency targetCurr = targetItem.get();
        	result = convertCurrency(sourceCurr, targetCurr, amount);
        }
        
		return result;
    }

}