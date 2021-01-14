package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class Jx3CampInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3CampInfoExample() {
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

        public Criteria andCampTypeIdIsNull() {
            addCriterion("CAMP_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdIsNotNull() {
            addCriterion("CAMP_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdEqualTo(Integer value) {
            addCriterion("CAMP_TYPE_ID =", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdNotEqualTo(Integer value) {
            addCriterion("CAMP_TYPE_ID <>", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdGreaterThan(Integer value) {
            addCriterion("CAMP_TYPE_ID >", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAMP_TYPE_ID >=", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdLessThan(Integer value) {
            addCriterion("CAMP_TYPE_ID <", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("CAMP_TYPE_ID <=", value, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdIn(List<Integer> values) {
            addCriterion("CAMP_TYPE_ID in", values, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdNotIn(List<Integer> values) {
            addCriterion("CAMP_TYPE_ID not in", values, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("CAMP_TYPE_ID between", value1, value2, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CAMP_TYPE_ID not between", value1, value2, "campTypeId");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameIsNull() {
            addCriterion("CAMP_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameIsNotNull() {
            addCriterion("CAMP_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameEqualTo(String value) {
            addCriterion("CAMP_TYPE_NAME =", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameNotEqualTo(String value) {
            addCriterion("CAMP_TYPE_NAME <>", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameGreaterThan(String value) {
            addCriterion("CAMP_TYPE_NAME >", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("CAMP_TYPE_NAME >=", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameLessThan(String value) {
            addCriterion("CAMP_TYPE_NAME <", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameLessThanOrEqualTo(String value) {
            addCriterion("CAMP_TYPE_NAME <=", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameLike(String value) {
            addCriterion("CAMP_TYPE_NAME like", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameNotLike(String value) {
            addCriterion("CAMP_TYPE_NAME not like", value, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameIn(List<String> values) {
            addCriterion("CAMP_TYPE_NAME in", values, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameNotIn(List<String> values) {
            addCriterion("CAMP_TYPE_NAME not in", values, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameBetween(String value1, String value2) {
            addCriterion("CAMP_TYPE_NAME between", value1, value2, "campTypeName");
            return (Criteria) this;
        }

        public Criteria andCampTypeNameNotBetween(String value1, String value2) {
            addCriterion("CAMP_TYPE_NAME not between", value1, value2, "campTypeName");
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