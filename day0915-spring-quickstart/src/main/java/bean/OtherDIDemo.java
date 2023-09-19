package bean;

import org.springframework.beans.factory.InitializingBean;

import java.util.*;

public class OtherDIDemo implements InitializingBean {
    private int straightValue;

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String, String> map;

    private Properties properties;

    public void setStraightValue(int straightValue) {
        this.straightValue = straightValue;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("自动注入的Straight Values=" + straightValue);
        System.out.println("自动注入的数组=" + Arrays.toString(array));
        System.out.println("自动注入的List=" + list);
        System.out.println("自动注入的Set=" + set);
        System.out.println("自动注入的Map=" + map);
        System.out.println("自动注入的Properties=" + properties);
    }
}
