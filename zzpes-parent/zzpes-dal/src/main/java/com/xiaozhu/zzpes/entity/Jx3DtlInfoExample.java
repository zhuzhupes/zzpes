package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class Jx3DtlInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3DtlInfoExample() {
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

        public Criteria andDtlIdIsNull() {
            addCriterion("DTL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDtlIdIsNotNull() {
            addCriterion("DTL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDtlIdEqualTo(Integer value) {
            addCriterion("DTL_ID =", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdNotEqualTo(Integer value) {
            addCriterion("DTL_ID <>", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdGreaterThan(Integer value) {
            addCriterion("DTL_ID >", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DTL_ID >=", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdLessThan(Integer value) {
            addCriterion("DTL_ID <", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdLessThanOrEqualTo(Integer value) {
            addCriterion("DTL_ID <=", value, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdIn(List<Integer> values) {
            addCriterion("DTL_ID in", values, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdNotIn(List<Integer> values) {
            addCriterion("DTL_ID not in", values, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdBetween(Integer value1, Integer value2) {
            addCriterion("DTL_ID between", value1, value2, "dtlId");
            return (Criteria) this;
        }

        public Criteria andDtlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DTL_ID not between", value1, value2, "dtlId");
            return (Criteria) this;
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

        public Criteria andDtlTypeDtlIsNull() {
            addCriterion("DTL_TYPE_DTL is null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlIsNotNull() {
            addCriterion("DTL_TYPE_DTL is not null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlEqualTo(String value) {
            addCriterion("DTL_TYPE_DTL =", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlNotEqualTo(String value) {
            addCriterion("DTL_TYPE_DTL <>", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlGreaterThan(String value) {
            addCriterion("DTL_TYPE_DTL >", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_TYPE_DTL >=", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlLessThan(String value) {
            addCriterion("DTL_TYPE_DTL <", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlLessThanOrEqualTo(String value) {
            addCriterion("DTL_TYPE_DTL <=", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlLike(String value) {
            addCriterion("DTL_TYPE_DTL like", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlNotLike(String value) {
            addCriterion("DTL_TYPE_DTL not like", value, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlIn(List<String> values) {
            addCriterion("DTL_TYPE_DTL in", values, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlNotIn(List<String> values) {
            addCriterion("DTL_TYPE_DTL not in", values, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlBetween(String value1, String value2) {
            addCriterion("DTL_TYPE_DTL between", value1, value2, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeDtlNotBetween(String value1, String value2) {
            addCriterion("DTL_TYPE_DTL not between", value1, value2, "dtlTypeDtl");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdIsNull() {
            addCriterion("DTL_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdIsNotNull() {
            addCriterion("DTL_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdEqualTo(Integer value) {
            addCriterion("DTL_TYPE_ID =", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdNotEqualTo(Integer value) {
            addCriterion("DTL_TYPE_ID <>", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdGreaterThan(Integer value) {
            addCriterion("DTL_TYPE_ID >", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DTL_TYPE_ID >=", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdLessThan(Integer value) {
            addCriterion("DTL_TYPE_ID <", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("DTL_TYPE_ID <=", value, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdIn(List<Integer> values) {
            addCriterion("DTL_TYPE_ID in", values, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdNotIn(List<Integer> values) {
            addCriterion("DTL_TYPE_ID not in", values, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("DTL_TYPE_ID between", value1, value2, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DTL_TYPE_ID not between", value1, value2, "dtlTypeId");
            return (Criteria) this;
        }

        public Criteria andDtlUrlIsNull() {
            addCriterion("DTL_URL is null");
            return (Criteria) this;
        }

        public Criteria andDtlUrlIsNotNull() {
            addCriterion("DTL_URL is not null");
            return (Criteria) this;
        }

        public Criteria andDtlUrlEqualTo(String value) {
            addCriterion("DTL_URL =", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlNotEqualTo(String value) {
            addCriterion("DTL_URL <>", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlGreaterThan(String value) {
            addCriterion("DTL_URL >", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_URL >=", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlLessThan(String value) {
            addCriterion("DTL_URL <", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlLessThanOrEqualTo(String value) {
            addCriterion("DTL_URL <=", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlLike(String value) {
            addCriterion("DTL_URL like", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlNotLike(String value) {
            addCriterion("DTL_URL not like", value, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlIn(List<String> values) {
            addCriterion("DTL_URL in", values, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlNotIn(List<String> values) {
            addCriterion("DTL_URL not in", values, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlBetween(String value1, String value2) {
            addCriterion("DTL_URL between", value1, value2, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlUrlNotBetween(String value1, String value2) {
            addCriterion("DTL_URL not between", value1, value2, "dtlUrl");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceIsNull() {
            addCriterion("DTL_ALIACE is null");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceIsNotNull() {
            addCriterion("DTL_ALIACE is not null");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceEqualTo(String value) {
            addCriterion("DTL_ALIACE =", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceNotEqualTo(String value) {
            addCriterion("DTL_ALIACE <>", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceGreaterThan(String value) {
            addCriterion("DTL_ALIACE >", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_ALIACE >=", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceLessThan(String value) {
            addCriterion("DTL_ALIACE <", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceLessThanOrEqualTo(String value) {
            addCriterion("DTL_ALIACE <=", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceLike(String value) {
            addCriterion("DTL_ALIACE like", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceNotLike(String value) {
            addCriterion("DTL_ALIACE not like", value, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceIn(List<String> values) {
            addCriterion("DTL_ALIACE in", values, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceNotIn(List<String> values) {
            addCriterion("DTL_ALIACE not in", values, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceBetween(String value1, String value2) {
            addCriterion("DTL_ALIACE between", value1, value2, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlAliaceNotBetween(String value1, String value2) {
            addCriterion("DTL_ALIACE not between", value1, value2, "dtlAliace");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameIsNull() {
            addCriterion("DTL_ZHCN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameIsNotNull() {
            addCriterion("DTL_ZHCN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameEqualTo(String value) {
            addCriterion("DTL_ZHCN_NAME =", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameNotEqualTo(String value) {
            addCriterion("DTL_ZHCN_NAME <>", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameGreaterThan(String value) {
            addCriterion("DTL_ZHCN_NAME >", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameGreaterThanOrEqualTo(String value) {
            addCriterion("DTL_ZHCN_NAME >=", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameLessThan(String value) {
            addCriterion("DTL_ZHCN_NAME <", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameLessThanOrEqualTo(String value) {
            addCriterion("DTL_ZHCN_NAME <=", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameLike(String value) {
            addCriterion("DTL_ZHCN_NAME like", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameNotLike(String value) {
            addCriterion("DTL_ZHCN_NAME not like", value, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameIn(List<String> values) {
            addCriterion("DTL_ZHCN_NAME in", values, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameNotIn(List<String> values) {
            addCriterion("DTL_ZHCN_NAME not in", values, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameBetween(String value1, String value2) {
            addCriterion("DTL_ZHCN_NAME between", value1, value2, "dtlZhcnName");
            return (Criteria) this;
        }

        public Criteria andDtlZhcnNameNotBetween(String value1, String value2) {
            addCriterion("DTL_ZHCN_NAME not between", value1, value2, "dtlZhcnName");
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