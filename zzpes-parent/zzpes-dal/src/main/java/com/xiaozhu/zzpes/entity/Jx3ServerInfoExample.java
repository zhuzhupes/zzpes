package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class Jx3ServerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3ServerInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andServerIdIsNull() {
            addCriterion("SERVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("SERVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(String value) {
            addCriterion("SERVER_ID =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(String value) {
            addCriterion("SERVER_ID <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(String value) {
            addCriterion("SERVER_ID >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_ID >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(String value) {
            addCriterion("SERVER_ID <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(String value) {
            addCriterion("SERVER_ID <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLike(String value) {
            addCriterion("SERVER_ID like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotLike(String value) {
            addCriterion("SERVER_ID not like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<String> values) {
            addCriterion("SERVER_ID in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<String> values) {
            addCriterion("SERVER_ID not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(String value1, String value2) {
            addCriterion("SERVER_ID between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(String value1, String value2) {
            addCriterion("SERVER_ID not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNull() {
            addCriterion("SERVER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNotNull() {
            addCriterion("SERVER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServerNameEqualTo(String value) {
            addCriterion("SERVER_NAME =", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("SERVER_NAME <>", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("SERVER_NAME >", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_NAME >=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThan(String value) {
            addCriterion("SERVER_NAME <", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("SERVER_NAME <=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLike(String value) {
            addCriterion("SERVER_NAME like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotLike(String value) {
            addCriterion("SERVER_NAME not like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameIn(List<String> values) {
            addCriterion("SERVER_NAME in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("SERVER_NAME not in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("SERVER_NAME between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("SERVER_NAME not between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerAliasIsNull() {
            addCriterion("SERVER_ALIAS is null");
            return (Criteria) this;
        }

        public Criteria andServerAliasIsNotNull() {
            addCriterion("SERVER_ALIAS is not null");
            return (Criteria) this;
        }

        public Criteria andServerAliasEqualTo(String value) {
            addCriterion("SERVER_ALIAS =", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasNotEqualTo(String value) {
            addCriterion("SERVER_ALIAS <>", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasGreaterThan(String value) {
            addCriterion("SERVER_ALIAS >", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_ALIAS >=", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasLessThan(String value) {
            addCriterion("SERVER_ALIAS <", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasLessThanOrEqualTo(String value) {
            addCriterion("SERVER_ALIAS <=", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasLike(String value) {
            addCriterion("SERVER_ALIAS like", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasNotLike(String value) {
            addCriterion("SERVER_ALIAS not like", value, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasIn(List<String> values) {
            addCriterion("SERVER_ALIAS in", values, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasNotIn(List<String> values) {
            addCriterion("SERVER_ALIAS not in", values, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasBetween(String value1, String value2) {
            addCriterion("SERVER_ALIAS between", value1, value2, "serverAlias");
            return (Criteria) this;
        }

        public Criteria andServerAliasNotBetween(String value1, String value2) {
            addCriterion("SERVER_ALIAS not between", value1, value2, "serverAlias");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}