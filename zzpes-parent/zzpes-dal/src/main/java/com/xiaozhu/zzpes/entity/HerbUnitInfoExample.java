package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.List;

public class HerbUnitInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HerbUnitInfoExample() {
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

        public Criteria andHerbUnitSeqIsNull() {
            addCriterion("herb_unit_seq is null");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqIsNotNull() {
            addCriterion("herb_unit_seq is not null");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqEqualTo(Long value) {
            addCriterion("herb_unit_seq =", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqNotEqualTo(Long value) {
            addCriterion("herb_unit_seq <>", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqGreaterThan(Long value) {
            addCriterion("herb_unit_seq >", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("herb_unit_seq >=", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqLessThan(Long value) {
            addCriterion("herb_unit_seq <", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqLessThanOrEqualTo(Long value) {
            addCriterion("herb_unit_seq <=", value, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqIn(List<Long> values) {
            addCriterion("herb_unit_seq in", values, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqNotIn(List<Long> values) {
            addCriterion("herb_unit_seq not in", values, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqBetween(Long value1, Long value2) {
            addCriterion("herb_unit_seq between", value1, value2, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbUnitSeqNotBetween(Long value1, Long value2) {
            addCriterion("herb_unit_seq not between", value1, value2, "herbUnitSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqIsNull() {
            addCriterion("herb_seq is null");
            return (Criteria) this;
        }

        public Criteria andHerbSeqIsNotNull() {
            addCriterion("herb_seq is not null");
            return (Criteria) this;
        }

        public Criteria andHerbSeqEqualTo(Integer value) {
            addCriterion("herb_seq =", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotEqualTo(Integer value) {
            addCriterion("herb_seq <>", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqGreaterThan(Integer value) {
            addCriterion("herb_seq >", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("herb_seq >=", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqLessThan(Integer value) {
            addCriterion("herb_seq <", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqLessThanOrEqualTo(Integer value) {
            addCriterion("herb_seq <=", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqIn(List<Integer> values) {
            addCriterion("herb_seq in", values, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotIn(List<Integer> values) {
            addCriterion("herb_seq not in", values, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqBetween(Integer value1, Integer value2) {
            addCriterion("herb_seq between", value1, value2, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("herb_seq not between", value1, value2, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqIsNull() {
            addCriterion("unit_seq is null");
            return (Criteria) this;
        }

        public Criteria andUnitSeqIsNotNull() {
            addCriterion("unit_seq is not null");
            return (Criteria) this;
        }

        public Criteria andUnitSeqEqualTo(Integer value) {
            addCriterion("unit_seq =", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqNotEqualTo(Integer value) {
            addCriterion("unit_seq <>", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqGreaterThan(Integer value) {
            addCriterion("unit_seq >", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_seq >=", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqLessThan(Integer value) {
            addCriterion("unit_seq <", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqLessThanOrEqualTo(Integer value) {
            addCriterion("unit_seq <=", value, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqIn(List<Integer> values) {
            addCriterion("unit_seq in", values, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqNotIn(List<Integer> values) {
            addCriterion("unit_seq not in", values, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqBetween(Integer value1, Integer value2) {
            addCriterion("unit_seq between", value1, value2, "unitSeq");
            return (Criteria) this;
        }

        public Criteria andUnitSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_seq not between", value1, value2, "unitSeq");
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