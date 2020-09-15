package gt.com.antiguaburger.antiguaburgerweb.modelo;

import java.util.List;

public class OrderWebEntity {
    private String idmenu;
    private List<String> idoption;
    private List<String> cantoption;
    private List<String> idExtra;
    private List<String> cantextra;
    private String cashier;
    private String user;
    private String nit;

    public String getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(String idmenu) {
        this.idmenu = idmenu;
    }

    public List<String> getIdoption() {
        return idoption;
    }

    public void setIdoption(List<String> idoption) {
        this.idoption = idoption;
    }

    public List<String> getCantoption() {
        return cantoption;
    }

    public void setCantoption(List<String> cantoption) {
        this.cantoption = cantoption;
    }

    public List<String> getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(List<String> idExtra) {
        this.idExtra = idExtra;
    }

    public List<String> getCantextra() {
        return cantextra;
    }

    public void setCantextra(List<String> cantextra) {
        this.cantextra = cantextra;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
