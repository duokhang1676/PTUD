package components;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Formater {
	public static String decimalFormat(double number) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
	}
}
