package com.plm.pattern.builder;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) {
        SqlBuilder sqlBuilder = new SqlBuilder();
        String sql = sqlBuilder.buildFrom("person t").buildOrderBy("t.id desc")
                .buildSelect("t.id, t.name").buildWhere("t.id < 50").build();
        System.out.println(sql);
    }
}
