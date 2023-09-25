package com.ioewvsau.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class QualifierController {
    /**
     * 此时容器中有两个相同类型的 PrimaryBean 组件
     *     - 一个是在 AutowiredQualifierConfig 通过 @Bean 注入的
     *     - 另一个是在 PrimaryBean 中使用 @Component 注解标注的
     *
     * 而在这里中通过 @Autowired 注解注入了一个 PrimaryBean
     * 默认是按类型查找，如果同类型有多个组件，则默认从容器中获取 ID 为属性名的组件
     *
     * 可以通过 @Qualifier 注解改变这一个默认规则，@Qualifier 注解指定的组件即为 @Autowired 注入的组件
     */
    @Autowired
    @Qualifier("primaryBean2")
    PrimaryBean primaryBean;

    public PrimaryBean getPrimaryBean() {
        return primaryBean;
    }
}
