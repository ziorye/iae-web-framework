# 今日总结

## 课前分享

- 作业完成情况汇报：自己思考了，也网上查了资料，但是都没有完成
- 分享各自解决问题的思路，重点在思路

## commit log

commit 记录就是课程大纲、学习笔记、复习笔记
同时要有能力根据简短的 commit 历史记录重写出课上讲解的代码

- System.setProperty("k", "v")
- @Conditional
- @BeforeAll + @BeforeEach
- System.setOut(...)

## 练习：寻找从 `WindowsCondition.java` 到 `System.getProperties()` 的通路

锻炼阅读源码的能力

### 通路1

- step1
![img_1.png](img_1.png)
- step2
![img_2.png](img_2.png)
- step3
![img_3.png](img_3.png)
- step4
![img_4.png](img_4.png)
- step5
![img_5.png](img_5.png)
- step6
![img_6.png](img_6.png)
- step7
![img_7.png](img_7.png)
- step8
![img_8.png](img_8.png)


### 核心
- 从 `getEnvironment().getProperty()` 跳出到 `getEnvironment()`
- Debug
