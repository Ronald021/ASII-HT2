package gt.com.antiguaburger.antiguaburgerweb.print;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

/**
 * 
 */
public interface IPrinter {

    /**
     * @param order
     */
    public void print(OrderEntity order);

}