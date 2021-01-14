package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class Jx3AdtTypeKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3AdtTypeKeyExample() {
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

        public Criteria andDtlTypeIsNull() {
            addCriterion("DTL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIsNotNull() {
            addCriterion("DTL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeEqualTo(String value) {
            addCriterion("DTL_TYPE =", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeNotEqualTo(String value) {
            addCriterion("DTL_TYPE <>", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeGreaterThan(String value) {
            addCriterion("DTL_TYPE >", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_TYPE >=", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeLessThan(String value) {
            addCriterion("DTL_TYPE <", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeLessThanOrEqualTo(String value) {
            addCriterion("DTL_TYPE <=", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeLike(String value) {
            addCriterion("DTL_TYPE like", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeNotLike(String value) {
            addCriterion("DTL_TYPE not like", value, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIn(List<String> values) {
            addCriterion("DTL_TYPE in", values, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeNotIn(List<String> values) {
            addCriterion("DTL_TYPE not in", values, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeBetween(String value1, String value2) {
            addCriterion("DTL_TYPE between", value1, value2, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlTypeNotBetween(String value1, String value2) {
            addCriterion("DTL_TYPE not between", value1, value2, "dtlType");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyIsNull() {
            addCriterion("DTL_RES_KEY is null");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyIsNotNull() {
            addCriterion("DTL_RES_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyEqualTo(String value) {
            addCriterion("DTL_RES_KEY =", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyNotEqualTo(String value) {
            addCriterion("DTL_RES_KEY <>", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyGreaterThan(String value) {
            addCriterion("DTL_RES_KEY >", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_RES_KEY >=", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyLessThan(String value) {
            addCriterion("DTL_RES_KEY <", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyLessThanOrEqualTo(String value) {
            addCriterion("DTL_RES_KEY <=", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyLike(String value) {
            addCriterion("DTL_RES_KEY like", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyNotLike(String value) {
            addCriterion("DTL_RES_KEY not like", value, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyIn(List<String> values) {
            addCriterion("DTL_RES_KEY in", values, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyNotIn(List<String> values) {
            addCriterion("DTL_RES_KEY not in", values, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyBetween(String value1, String value2) {
            addCriterion("DTL_RES_KEY between", value1, value2, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlResKeyNotBetween(String value1, String value2) {
            addCriterion("DTL_RES_KEY not between", value1, value2, "dtlResKey");
            return (Criteria) this;
        }

        public Criteria andDtlNameIsNull() {
            addCriterion("DTL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDtlNameIsNotNull() {
            addCriterion("DTL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDtlNameEqualTo(String value) {
            addCriterion("DTL_NAME =", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameNotEqualTo(String value) {
            addCriterion("DTL_NAME <>", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameGreaterThan(String value) {
            addCriterion("DTL_NAME >", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_NAME >=", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameLessThan(String value) {
            addCriterion("DTL_NAME <", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameLessThanOrEqualTo(String value) {
            addCriterion("DTL_NAME <=", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameLike(String value) {
            addCriterion("DTL_NAME like", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameNotLike(String value) {
            addCriterion("DTL_NAME not like", value, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameIn(List<String> values) {
            addCriterion("DTL_NAME in", values, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameNotIn(List<String> values) {
            addCriterion("DTL_NAME not in", values, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameBetween(String value1, String value2) {
            addCriterion("DTL_NAME between", value1, value2, "dtlName");
            return (Criteria) this;
        }

        public Criteria andDtlNameNotBetween(String value1, String value2) {
            addCriterion("DTL_NAME not between", value1, value2, "dtlName");
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