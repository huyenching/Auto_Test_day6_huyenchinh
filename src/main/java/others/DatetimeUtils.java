package others;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Timestamp;


public class DatetimeUtils {


        // Định dạng mặc định
        private static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
        private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
        private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";


        public static String getCurrentDateTime() {
            return getCurrentDateTime(DEFAULT_DATETIME_PATTERN);
        }


        public static String getCurrentDateTime(String pattern) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDateTime.now().format(formatter);
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi định dạng ngày giờ: " + e.getMessage());
                return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN));
            }
        }


        public static String getCurrentDate() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN));
        }

        public static String getCurrentTime() {
            return LocalTime.now().format(DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN));
        }

        public static LocalDateTime parseDateTime(String dateTime, String pattern) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDateTime.parse(dateTime, formatter);
            } catch (DateTimeParseException | NullPointerException e) {
                System.err.println("Không thể phân tích chuỗi ngày giờ: " + e.getMessage());
                return null;
            }
        }

        public static String addDays(String dateTime, String pattern, long days) {
            LocalDateTime ldt = parseDateTime(dateTime, pattern);
            if (ldt == null) {
                return dateTime; // Trả về chuỗi gốc nếu phân tích thất bại
            }
            return ldt.plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
        }

        public static String addHours(String dateTime, String pattern, long hours) {
            LocalDateTime ldt = parseDateTime(dateTime, pattern);
            if (ldt == null) {
                return dateTime; // Trả về chuỗi gốc nếu phân tích thất bại
            }
            return ldt.plusHours(hours).format(DateTimeFormatter.ofPattern(pattern));
        }

        public static long getCurrentTimestamp() {
            return Instant.now().toEpochMilli();
        }

        public static String fromTimestamp(long timestamp, String pattern) {
            try {
                LocalDateTime ldt = Instant.ofEpochMilli(timestamp)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                return ldt.format(DateTimeFormatter.ofPattern(pattern));
            } catch (Exception e) {
                System.err.println("Lỗi chuyển đổi Timestamp: " + e.getMessage());
                return String.valueOf(timestamp);
            }
        }

        public static boolean isValidDateTime(String dateTime, String pattern) {
            if (dateTime == null || pattern == null || dateTime.trim().isEmpty() || pattern.trim().isEmpty()) {
                return false;
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                // Sử dụng STRICT Resolver Style để kiểm tra tính hợp lệ nghiêm ngặt (ví dụ: không cho phép 30/02)
                formatter.parse(dateTime);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }
    }
