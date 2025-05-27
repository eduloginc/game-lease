package itemlease;

public class LeaseItem {

    public static final int CHILDREN = 2;
    public static final int NEWLY_RELEASED = 1;
    public static final int REGULAR = 0;

    private String _title;
    private int _priceCode;

    public LeaseItem(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    public String getTitle() {
        return _title;
    }


}
