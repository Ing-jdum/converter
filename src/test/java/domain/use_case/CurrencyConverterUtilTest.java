package domain.use_case;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CurrencyConverterUtilTest {
	@Test
	void testConvertCurrency() {
		final double TOLERANCE = 0.01;
		double amount;
		double expectedConversion;
		double actualConversion;

		// USD to EUR
		amount = 100.0;
		expectedConversion = 92.08;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "Euro", amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

		// USD to USD
		amount = 100.0;
		expectedConversion = 100.0;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "United States Dollar",
				amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

		// USD to GBP
		amount = 100.0;
		expectedConversion = 75.71;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "British Pound", amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

		// USD to DOP
		amount = 100.0;
		expectedConversion = 5491.43;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "Dominican Peso", amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

		// USD to JPY
		amount = 100.0;
		expectedConversion = 10750.0;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "Japanese Yen", amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

		// USD to KRW
		amount = 100.0;
		expectedConversion = 116500.0;
		actualConversion = CurrencyConverterUtil.convertCurrency("United States Dollar", "South Korean Won", amount);
		assertEquals(expectedConversion, actualConversion, TOLERANCE);

	}

}
