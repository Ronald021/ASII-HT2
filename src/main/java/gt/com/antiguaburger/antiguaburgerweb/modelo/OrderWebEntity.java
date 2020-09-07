package gt.com.antiguaburger.antiguaburgerweb.modelo;

import java.util.List;

public class OrderWebEntity {
    private String idmenu;
    private List<String> idoption;
    private List<String> cantoption;
    private List<String> idExtra;
    private List<String> cantextra;

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
}
