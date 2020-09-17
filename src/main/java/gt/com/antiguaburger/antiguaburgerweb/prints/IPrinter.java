package gt.com.antiguaburger.antiguaburgerweb.prints;


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