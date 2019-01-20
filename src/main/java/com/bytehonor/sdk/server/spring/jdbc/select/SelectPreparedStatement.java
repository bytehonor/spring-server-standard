package com.bytehonor.sdk.server.spring.jdbc.select;

import java.util.List;
import java.util.Objects;

import com.bytehonor.sdk.server.spring.jdbc.SqlConstants;
import com.bytehonor.sdk.server.spring.query.QueryCondition;
import com.bytehonor.sdk.server.spring.string.StringCreator;

public class SelectPreparedStatement {

    private final String table;

    private final QueryCondition condition;

    private SelectPreparedStatement(String table, QueryCondition condition) {
        this.table = table;
        this.condition = condition;
    }

    public static SelectPreparedStatement create(String table, QueryCondition condition) {
        Objects.requireNonNull(table, "table");
        Objects.requireNonNull(condition, "condition");
        return new SelectPreparedStatement(table, condition);
    }

    public String getTable() {
        return table;
    }

    public QueryCondition getCondition() {
        return condition;
    }

    public String toSelectSql(String keys) {
        Objects.requireNonNull(keys, "keys");
        StringCreator creator = StringCreator.create();
        creator.append("SELECT ").append(keys).append(" FROM ").append(table).append(SqlConstants.BLANK);
        creator.append("WHERE 1=1").append(condition.getMatchHolder().toAndSql());
        if (condition.getOrder() != null) {
            creator.append(condition.getOrder().toSql());
        }
        creator.append(condition.offsetLimitSql());
        return creator.toString();
    }

    public String toCountSql(String key) {
        Objects.requireNonNull(key, "key");
        StringCreator creator = StringCreator.create();
        creator.append("SELECT count(").append(key).append(") FROM ").append(table).append(SqlConstants.BLANK);
        creator.append("WHERE 1=1").append(condition.getMatchHolder().toAndSql());
        return creator.toString();
    }

    public List<Object> args() {
        return condition.getMatchHolder().getArgs();
    }

    public void clear() {
        condition.getMatchHolder().clear();
    }

}
