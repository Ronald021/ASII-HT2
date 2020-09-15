package gt.com.antiguaburger.antiguaburgerweb.modelo;

import java.util.List;

/**
 * 
 */
public class OrderEntity {

    /**
     * Default constructor
     */
    public OrderEntity() {
    }
    private String menuid;
    private String type;
        public String getType() {
        return type;
    }
        public void setType(String type) {
        this.type = type;
    }

    private String date;
    private String time;
    private int order;

    /**
     * 
     */
    private String cashier;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String customer;

    /**
     * 
     */
    private String taxid;


    /**
     * 
     */
    private List<String>  items;
    private List<String> options;
    private String  extras;
    private List<Integer> priceE;
    private List<String> data;
    public List<Integer> getPriceE() {
        return priceE;
    }

    public void setPriceE(List<Integer> priceE) {
        this.priceE = priceE;
    }

    /**
     * 
     */

    private int total;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }


    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}