package bean;

import org.springframework.beans.factory.DisposableBean;

public class DisposableBeanDemo implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBeanDemo.destroy");
    }
}
