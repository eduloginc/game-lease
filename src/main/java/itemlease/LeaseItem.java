package itemlease;

public class LeaseItem {

    public static final int CHILDREN = 2;
    public static final int NEWLY_RELEASED = 1;
    public static final int REGULAR = 0;

    private String title;
    private int priceCode;

    public LeaseItem(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }


}
