package com.plm.pattern.prototype;

import java.io.Serializable;
import java.util.List;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class FamilyMemeber implements Serializable {
    private List<String> members;

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        members.stream().forEach(e -> sb.append(e + " "));
        return sb.toString();
    }


}
