package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class Jx3BodyShapeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3BodyShapeInfoExample() {
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

        public Criteria andBodyShapeIdIsNull() {
            addCriterion("BODY_SHAPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdIsNotNull() {
            addCriterion("BODY_SHAPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdEqualTo(Integer value) {
            addCriterion("BODY_SHAPE_ID =", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdNotEqualTo(Integer value) {
            addCriterion("BODY_SHAPE_ID <>", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdGreaterThan(Integer value) {
            addCriterion("BODY_SHAPE_ID >", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BODY_SHAPE_ID >=", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdLessThan(Integer value) {
            addCriterion("BODY_SHAPE_ID <", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdLessThanOrEqualTo(Integer value) {
            addCriterion("BODY_SHAPE_ID <=", value, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdIn(List<Integer> values) {
            addCriterion("BODY_SHAPE_ID in", values, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdNotIn(List<Integer> values) {
            addCriterion("BODY_SHAPE_ID not in", values, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdBetween(Integer value1, Integer value2) {
            addCriterion("BODY_SHAPE_ID between", value1, value2, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BODY_SHAPE_ID not between", value1, value2, "bodyShapeId");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameIsNull() {
            addCriterion("BODY_SHAPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameIsNotNull() {
            addCriterion("BODY_SHAPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameEqualTo(String value) {
            addCriterion("BODY_SHAPE_NAME =", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameNotEqualTo(String value) {
            addCriterion("BODY_SHAPE_NAME <>", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameGreaterThan(String value) {
            addCriterion("BODY_SHAPE_NAME >", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameGreaterThanOrEqualTo(String value) {
            addCriterion("BODY_SHAPE_NAME >=", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameLessThan(String value) {
            addCriterion("BODY_SHAPE_NAME <", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameLessThanOrEqualTo(String value) {
            addCriterion("BODY_SHAPE_NAME <=", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameLike(String value) {
            addCriterion("BODY_SHAPE_NAME like", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameNotLike(String value) {
            addCriterion("BODY_SHAPE_NAME not like", value, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameIn(List<String> values) {
            addCriterion("BODY_SHAPE_NAME in", values, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameNotIn(List<String> values) {
            addCriterion("BODY_SHAPE_NAME not in", values, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameBetween(String value1, String value2) {
            addCriterion("BODY_SHAPE_NAME between", value1, value2, "bodyShapeName");
            return (Criteria) this;
        }

        public Criteria andBodyShapeNameNotBetween(String value1, String value2) {
            addCriterion("BODY_SHAPE_NAME not between", value1, value2, "bodyShapeName");
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