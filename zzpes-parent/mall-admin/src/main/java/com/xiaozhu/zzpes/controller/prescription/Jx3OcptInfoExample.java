package com.xiaozhu.zzpes.controller.prescription;

import java.util.ArrayList;
import java.util.List;

public class Jx3OcptInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3OcptInfoExample() {
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

        public Criteria andOcptIdIsNull() {
            addCriterion("OCPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOcptIdIsNotNull() {
            addCriterion("OCPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOcptIdEqualTo(Integer value) {
            addCriterion("OCPT_ID =", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdNotEqualTo(Integer value) {
            addCriterion("OCPT_ID <>", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdGreaterThan(Integer value) {
            addCriterion("OCPT_ID >", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OCPT_ID >=", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdLessThan(Integer value) {
            addCriterion("OCPT_ID <", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdLessThanOrEqualTo(Integer value) {
            addCriterion("OCPT_ID <=", value, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdIn(List<Integer> values) {
            addCriterion("OCPT_ID in", values, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdNotIn(List<Integer> values) {
            addCriterion("OCPT_ID not in", values, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdBetween(Integer value1, Integer value2) {
            addCriterion("OCPT_ID between", value1, value2, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OCPT_ID not between", value1, value2, "ocptId");
            return (Criteria) this;
        }

        public Criteria andOcptNameIsNull() {
            addCriterion("OCPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOcptNameIsNotNull() {
            addCriterion("OCPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOcptNameEqualTo(String value) {
            addCriterion("OCPT_NAME =", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameNotEqualTo(String value) {
            addCriterion("OCPT_NAME <>", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameGreaterThan(String value) {
            addCriterion("OCPT_NAME >", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameGreaterThanOrEqualTo(String value) {
            addCriterion("OCPT_NAME >=", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameLessThan(String value) {
            addCriterion("OCPT_NAME <", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameLessThanOrEqualTo(String value) {
            addCriterion("OCPT_NAME <=", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameLike(String value) {
            addCriterion("OCPT_NAME like", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameNotLike(String value) {
            addCriterion("OCPT_NAME not like", value, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameIn(List<String> values) {
            addCriterion("OCPT_NAME in", values, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameNotIn(List<String> values) {
            addCriterion("OCPT_NAME not in", values, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameBetween(String value1, String value2) {
            addCriterion("OCPT_NAME between", value1, value2, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptNameNotBetween(String value1, String value2) {
            addCriterion("OCPT_NAME not between", value1, value2, "ocptName");
            return (Criteria) this;
        }

        public Criteria andOcptCodeIsNull() {
            addCriterion("OCPT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOcptCodeIsNotNull() {
            addCriterion("OCPT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOcptCodeEqualTo(String value) {
            addCriterion("OCPT_CODE =", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeNotEqualTo(String value) {
            addCriterion("OCPT_CODE <>", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeGreaterThan(String value) {
            addCriterion("OCPT_CODE >", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OCPT_CODE >=", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeLessThan(String value) {
            addCriterion("OCPT_CODE <", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeLessThanOrEqualTo(String value) {
            addCriterion("OCPT_CODE <=", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeLike(String value) {
            addCriterion("OCPT_CODE like", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeNotLike(String value) {
            addCriterion("OCPT_CODE not like", value, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeIn(List<String> values) {
            addCriterion("OCPT_CODE in", values, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeNotIn(List<String> values) {
            addCriterion("OCPT_CODE not in", values, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeBetween(String value1, String value2) {
            addCriterion("OCPT_CODE between", value1, value2, "ocptCode");
            return (Criteria) this;
        }

        public Criteria andOcptCodeNotBetween(String value1, String value2) {
            addCriterion("OCPT_CODE not between", value1, value2, "ocptCode");
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