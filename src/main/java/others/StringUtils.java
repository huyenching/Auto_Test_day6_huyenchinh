package others;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {

    public static boolean isIsNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String capitalizeFirst(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        str = str.trim().toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


    public static String toLower(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        return str.toLowerCase();
    }


    public static String toUpper(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        return str.toUpperCase();
    }

    public static String removeSpecialChars(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        // Regex: Chỉ giữ lại chữ cái (a-zA-Z), số (0-9) và khoảng trắng (\s).
        return str.replaceAll("[^a-zA-Z0-9\\s]", "");
    }


    public static String removeVietnameseAccents(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
        // Loại bỏ các ký tự dấu (diacritics)
        temp = temp.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        // Xử lý ký tự 'đ' và 'Đ'
        temp = temp.replaceAll("[Đđ]", "d");
        return temp;
    }

    public static String normalizeKeyword(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        String normalized = removeVietnameseAccents(str);
        normalized = normalized.toLowerCase();
        normalized = normalized.replaceAll("\\s+", " ").trim(); // Thay thế nhiều khoảng trắng thành một và trim
        return normalized;
    }


    public static String trimAllSpaces(String str) {
        if (isIsNullOrEmpty(str)) {
            return str;
        }
        return str.replaceAll("\\s", "");
    }


    public static String truncate(String str, int maxLength) {
        if (isIsNullOrEmpty(str) || str.length() <= maxLength) {
            return str;
        }
        if (maxLength < 3) {
            return str.substring(0, maxLength);
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    public static boolean containsNumber(String str) {
        if (isIsNullOrEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile(".*\\d+.*");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
