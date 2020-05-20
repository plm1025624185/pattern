package com.plm.pattern.prototype;

import com.plm.pattern.singleton.DestroyUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 原型模式
 * java中的Cloneable接口实现的是浅拷贝
 * 深拷贝可以使用序列化实现
 * @author 潘磊明
 * @date 2020/5/20
 */
public class NeedPrototypePojo implements Cloneable, Serializable {

    private String name;
    private Integer age;
    private int sex;
    private List<String> hobies;
    private FamilyMemeber memeber;

    public NeedPrototypePojo(){}

    public NeedPrototypePojo(String name, Integer age, int sex, List<String> hobies) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobies = hobies;
        memeber = new FamilyMemeber();
        memeber.setMembers(Arrays.asList("李四", "王五"));
    }

    /**
     * 默认实现的是浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public NeedPrototypePojo clone() throws CloneNotSupportedException {
        return (NeedPrototypePojo)super.clone();
    }

    /**
     * 使用序列化实现深拷贝
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public NeedPrototypePojo deepClone() throws IOException, ClassNotFoundException {
        return DestroyUtil.objectStream(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名为：");
        sb.append(name);
        sb.append("，年龄为：");
        sb.append(age);
        sb.append("，性别为：");
        sb.append(sex);
        sb.append("，兴趣有：");
        for (String str : hobies) {
            sb.append(str + " ");
        }
        sb.append("，家庭成员有：");
        sb.append(memeber == null ? "无" : memeber.toString());
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<String> getHobies() {
        return hobies;
    }

    public void setHobies(List<String> hobies) {
        this.hobies = hobies;
    }

    public FamilyMemeber getMemeber() {
        return memeber;
    }

    public void setMemeber(FamilyMemeber memeber) {
        this.memeber = memeber;
    }
}
