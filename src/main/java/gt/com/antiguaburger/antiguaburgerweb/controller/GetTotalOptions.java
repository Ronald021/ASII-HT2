package gt.com.antiguaburger.antiguaburgerweb.controller;

public class GetTotalOptions {
    public int totaloptions(String id){
        int total =0;
        switch (id){
            case "1": total =5;break;
            case "2": total =3;break;
            case "3": total =3;break;
            case "4": total =4;break;
            case "5": total =4;break;
            case "6": total =4;break;

        }
        return total;
    }
}
