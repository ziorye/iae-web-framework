package com.ioewvsau.autowired.otherPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;
    private Assistant assistant;
    private Plane plane;

    /**
     * 如果只有一个有参构造方法，可以省略 @Autowired 标注。参数中的值默认就是从容器中获取
     */
    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    @Autowired
    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(@Autowired Plane plane) {
        this.plane = plane;
    }
}
