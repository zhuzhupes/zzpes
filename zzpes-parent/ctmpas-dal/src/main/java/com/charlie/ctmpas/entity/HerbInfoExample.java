package com.charlie.ctmpas.entity;

import java.util.ArrayList;
import java.util.List;

public class HerbInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HerbInfoExample() {
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

        public Criteria andHerbSeqIsNull() {
            addCriterion("herb_seq is null");
            return (Criteria) this;
        }

        public Criteria andHerbSeqIsNotNull() {
            addCriterion("herb_seq is not null");
            return (Criteria) this;
        }

        public Criteria andHerbSeqEqualTo(Long value) {
            addCriterion("herb_seq =", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotEqualTo(Long value) {
            addCriterion("herb_seq <>", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqGreaterThan(Long value) {
            addCriterion("herb_seq >", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("herb_seq >=", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqLessThan(Long value) {
            addCriterion("herb_seq <", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqLessThanOrEqualTo(Long value) {
            addCriterion("herb_seq <=", value, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqIn(List<Long> values) {
            addCriterion("herb_seq in", values, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotIn(List<Long> values) {
            addCriterion("herb_seq not in", values, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqBetween(Long value1, Long value2) {
            addCriterion("herb_seq between", value1, value2, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbSeqNotBetween(Long value1, Long value2) {
            addCriterion("herb_seq not between", value1, value2, "herbSeq");
            return (Criteria) this;
        }

        public Criteria andHerbNameIsNull() {
            addCriterion("herb_name is null");
            return (Criteria) this;
        }

        public Criteria andHerbNameIsNotNull() {
            addCriterion("herb_name is not null");
            return (Criteria) this;
        }

        public Criteria andHerbNameEqualTo(String value) {
            addCriterion("herb_name =", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameNotEqualTo(String value) {
            addCriterion("herb_name <>", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameGreaterThan(String value) {
            addCriterion("herb_name >", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameGreaterThanOrEqualTo(String value) {
            addCriterion("herb_name >=", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameLessThan(String value) {
            addCriterion("herb_name <", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameLessThanOrEqualTo(String value) {
            addCriterion("herb_name <=", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameLike(String value) {
            addCriterion("herb_name like", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameNotLike(String value) {
            addCriterion("herb_name not like", value, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameIn(List<String> values) {
            addCriterion("herb_name in", values, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameNotIn(List<String> values) {
            addCriterion("herb_name not in", values, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameBetween(String value1, String value2) {
            addCriterion("herb_name between", value1, value2, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbNameNotBetween(String value1, String value2) {
            addCriterion("herb_name not between", value1, value2, "herbName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameIsNull() {
            addCriterion("herb_eng_name is null");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameIsNotNull() {
            addCriterion("herb_eng_name is not null");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameEqualTo(String value) {
            addCriterion("herb_eng_name =", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameNotEqualTo(String value) {
            addCriterion("herb_eng_name <>", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameGreaterThan(String value) {
            addCriterion("herb_eng_name >", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameGreaterThanOrEqualTo(String value) {
            addCriterion("herb_eng_name >=", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameLessThan(String value) {
            addCriterion("herb_eng_name <", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameLessThanOrEqualTo(String value) {
            addCriterion("herb_eng_name <=", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameLike(String value) {
            addCriterion("herb_eng_name like", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameNotLike(String value) {
            addCriterion("herb_eng_name not like", value, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameIn(List<String> values) {
            addCriterion("herb_eng_name in", values, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameNotIn(List<String> values) {
            addCriterion("herb_eng_name not in", values, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameBetween(String value1, String value2) {
            addCriterion("herb_eng_name between", value1, value2, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbEngNameNotBetween(String value1, String value2) {
            addCriterion("herb_eng_name not between", value1, value2, "herbEngName");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionIsNull() {
            addCriterion("herb_function is null");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionIsNotNull() {
            addCriterion("herb_function is not null");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionEqualTo(String value) {
            addCriterion("herb_function =", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionNotEqualTo(String value) {
            addCriterion("herb_function <>", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionGreaterThan(String value) {
            addCriterion("herb_function >", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("herb_function >=", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionLessThan(String value) {
            addCriterion("herb_function <", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionLessThanOrEqualTo(String value) {
            addCriterion("herb_function <=", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionLike(String value) {
            addCriterion("herb_function like", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionNotLike(String value) {
            addCriterion("herb_function not like", value, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionIn(List<String> values) {
            addCriterion("herb_function in", values, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionNotIn(List<String> values) {
            addCriterion("herb_function not in", values, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionBetween(String value1, String value2) {
            addCriterion("herb_function between", value1, value2, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbFunctionNotBetween(String value1, String value2) {
            addCriterion("herb_function not between", value1, value2, "herbFunction");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseIsNull() {
            addCriterion("herb_disease is null");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseIsNotNull() {
            addCriterion("herb_disease is not null");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseEqualTo(String value) {
            addCriterion("herb_disease =", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseNotEqualTo(String value) {
            addCriterion("herb_disease <>", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseGreaterThan(String value) {
            addCriterion("herb_disease >", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("herb_disease >=", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseLessThan(String value) {
            addCriterion("herb_disease <", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseLessThanOrEqualTo(String value) {
            addCriterion("herb_disease <=", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseLike(String value) {
            addCriterion("herb_disease like", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseNotLike(String value) {
            addCriterion("herb_disease not like", value, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseIn(List<String> values) {
            addCriterion("herb_disease in", values, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseNotIn(List<String> values) {
            addCriterion("herb_disease not in", values, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseBetween(String value1, String value2) {
            addCriterion("herb_disease between", value1, value2, "herbDisease");
            return (Criteria) this;
        }

        public Criteria andHerbDiseaseNotBetween(String value1, String value2) {
            addCriterion("herb_disease not between", value1, value2, "herbDisease");
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