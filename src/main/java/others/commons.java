package others;

public class commons {
    public static void main(String[] args) {
        String locatorCommon = "//span[contains(text(),'%s')]/parent::label/preceding-sibling::button";
        String workplaceLocator = String.format(locatorCommon,"Workplace","Doccument");
        System.out.println("Workplace = "+ workplaceLocator);
    }
}
