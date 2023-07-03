package domain.use_case;

import java.util.Optional;

import data.repository.CurrencyRepositoryImpl;
import domain.model.Currency;
import domain.repository.IExchangableItem;

public class CurrencyConverterUtil {
	
	private CurrencyConverterUtil() {}
	
    public static double convertCurrency(Currency sourceCurrency, Currency targetCurrency, double amount) {
        double sourceRate = sourceCurrency.exchangeValue();
        double targetItem = targetCurrency.exchangeValue();

        // Perform the currency conversion calculation
        return (amount / sourceRate) * targetItem;
    }
    
    public static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        Optional<IExchangableItem> sourceItem = 
        		CurrencyRepositoryImpl.INSTANCE.getItemByName(sourceCurrency);
        Optional<IExchangableItem> targetItem = 
        		CurrencyRepositoryImpl.INSTANCE.getItemByName(targetCurrency);
        
        // Perform the currency conversion calculation
        if(sourceItem.isPresent() && targetItem.isPresent()) {
        	Currency sourceCurr = (Currency) sourceItem.get();
        	Currency targetCurr = (Currency) targetItem.get();
        	return convertCurrency(sourceCurr, targetCurr, amount);
        }
        
		return 0;
    }

}