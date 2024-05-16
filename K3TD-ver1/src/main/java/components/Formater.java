package components;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Formater {
	public static String decimalFormat(double number) {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
	}
    public static double roundToNearest500(double number) {
        // Chia số ban đầu cho 500
    	double quotient = number / 500;
        // Làm tròn kết quả chia
    	double roundedQuotient = Math.round(quotient);
        // Nhân kết quả tròn với 500
    	double roundedNumber = roundedQuotient * 500;
        return roundedNumber;
    }
}
