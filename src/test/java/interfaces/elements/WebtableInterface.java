package interfaces.elements;

public interface WebtableInterface {
    String EMAIL_BY_FIRSTNAME = "//div[text()='%s']/following-sibling::div[1]";

    String TABLE_CONTAINER = "//div[@class='rt-table']";
    // Dùng ancestor
    String EDIT_BY_LASTNAME = "//div[text()='%s']/ancestor::div[@class='rt-tr-group']//span[text()='Edit']";

    String EDIT_FORM = "//div[@class='modal-content']";
    // Dùng following
    String ROWS_AFTER_AGE = "//div[text()='%s']/ancestor::div[@class='rt-tr-group']/following-sibling::div";
}
