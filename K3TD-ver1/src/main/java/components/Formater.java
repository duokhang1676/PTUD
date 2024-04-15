package components;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Formater {
	public static String decimalFormat(double number) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
	}
}
