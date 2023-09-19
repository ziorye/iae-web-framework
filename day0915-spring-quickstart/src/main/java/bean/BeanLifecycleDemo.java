package bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycleDemo implements InitializingBean, DisposableBean {
    public BeanLifecycleDemo() {
        System.out.println("BeanLifecycleDemo.BeanLifecycleDemo");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifecycleDemo.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanLifecycleDemo.destroy");
    }
}
