package com.plm.pattern.builder;

/**
 * 建造者模式
 * @author 潘磊明
 * @date 2020/5/20
 */
public class SqlBuilder {

    private String select; // 查询语句

    private String from; // from语句

    private String where; // where语句

    private String orderBy; // orderby语句

    public SqlBuilder() {}

    public SqlBuilder buildSelect(String select) {
        this.select = select;
        return this; // 返回当前实例，实现链式调用
    }

    public SqlBuilder buildFrom(String from) {
        this.from = from;
        return this;
    }

    public SqlBuilder buildWhere(String where) {
        this.where = where;
        return this;
    }

    public SqlBuilder buildOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("select " + select + " from " + from + " where " + where + " order by " + orderBy);
        return sb.toString();
    }
}
