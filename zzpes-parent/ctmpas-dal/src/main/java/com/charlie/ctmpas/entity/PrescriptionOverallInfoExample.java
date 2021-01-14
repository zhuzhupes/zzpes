package com.charlie.ctmpas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PrescriptionOverallInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionOverallInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPrescriptionIdIsNull() {
            addCriterion("prescription_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNotNull() {
            addCriterion("prescription_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdEqualTo(Long value) {
            addCriterion("prescription_id =", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotEqualTo(Long value) {
            addCriterion("prescription_id <>", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThan(Long value) {
            addCriterion("prescription_id >", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prescription_id >=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThan(Long value) {
            addCriterion("prescription_id <", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThanOrEqualTo(Long value) {
            addCriterion("prescription_id <=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIn(List<Long> values) {
            addCriterion("prescription_id in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotIn(List<Long> values) {
            addCriterion("prescription_id not in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdBetween(Long value1, Long value2) {
            addCriterion("prescription_id between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotBetween(Long value1, Long value2) {
            addCriterion("prescription_id not between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(String value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(String value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(String value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(String value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(String value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(String value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLike(String value) {
            addCriterion("patient_id like", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotLike(String value) {
            addCriterion("patient_id not like", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<String> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<String> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(String value1, String value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(String value1, String value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdIsNull() {
            addCriterion("prescription_last_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdIsNotNull() {
            addCriterion("prescription_last_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdEqualTo(String value) {
            addCriterion("prescription_last_id =", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdNotEqualTo(String value) {
            addCriterion("prescription_last_id <>", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdGreaterThan(String value) {
            addCriterion("prescription_last_id >", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdGreaterThanOrEqualTo(String value) {
            addCriterion("prescription_last_id >=", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdLessThan(String value) {
            addCriterion("prescription_last_id <", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdLessThanOrEqualTo(String value) {
            addCriterion("prescription_last_id <=", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdLike(String value) {
            addCriterion("prescription_last_id like", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdNotLike(String value) {
            addCriterion("prescription_last_id not like", value, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdIn(List<String> values) {
            addCriterion("prescription_last_id in", values, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdNotIn(List<String> values) {
            addCriterion("prescription_last_id not in", values, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdBetween(String value1, String value2) {
            addCriterion("prescription_last_id between", value1, value2, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionLastIdNotBetween(String value1, String value2) {
            addCriterion("prescription_last_id not between", value1, value2, "prescriptionLastId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdIsNull() {
            addCriterion("prescription_next_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdIsNotNull() {
            addCriterion("prescription_next_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdEqualTo(String value) {
            addCriterion("prescription_next_id =", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdNotEqualTo(String value) {
            addCriterion("prescription_next_id <>", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdGreaterThan(String value) {
            addCriterion("prescription_next_id >", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdGreaterThanOrEqualTo(String value) {
            addCriterion("prescription_next_id >=", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdLessThan(String value) {
            addCriterion("prescription_next_id <", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdLessThanOrEqualTo(String value) {
            addCriterion("prescription_next_id <=", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdLike(String value) {
            addCriterion("prescription_next_id like", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdNotLike(String value) {
            addCriterion("prescription_next_id not like", value, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdIn(List<String> values) {
            addCriterion("prescription_next_id in", values, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdNotIn(List<String> values) {
            addCriterion("prescription_next_id not in", values, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdBetween(String value1, String value2) {
            addCriterion("prescription_next_id between", value1, value2, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionNextIdNotBetween(String value1, String value2) {
            addCriterion("prescription_next_id not between", value1, value2, "prescriptionNextId");
            return (Criteria) this;
        }

        public Criteria andFinalStateIsNull() {
            addCriterion("final_state is null");
            return (Criteria) this;
        }

        public Criteria andFinalStateIsNotNull() {
            addCriterion("final_state is not null");
            return (Criteria) this;
        }

        public Criteria andFinalStateEqualTo(String value) {
            addCriterion("final_state =", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateNotEqualTo(String value) {
            addCriterion("final_state <>", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateGreaterThan(String value) {
            addCriterion("final_state >", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateGreaterThanOrEqualTo(String value) {
            addCriterion("final_state >=", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateLessThan(String value) {
            addCriterion("final_state <", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateLessThanOrEqualTo(String value) {
            addCriterion("final_state <=", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateLike(String value) {
            addCriterion("final_state like", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateNotLike(String value) {
            addCriterion("final_state not like", value, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateIn(List<String> values) {
            addCriterion("final_state in", values, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateNotIn(List<String> values) {
            addCriterion("final_state not in", values, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateBetween(String value1, String value2) {
            addCriterion("final_state between", value1, value2, "finalState");
            return (Criteria) this;
        }

        public Criteria andFinalStateNotBetween(String value1, String value2) {
            addCriterion("final_state not between", value1, value2, "finalState");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateIsNull() {
            addCriterion("prescription_date is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateIsNotNull() {
            addCriterion("prescription_date is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateEqualTo(Date value) {
            addCriterionForJDBCDate("prescription_date =", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("prescription_date <>", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("prescription_date >", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prescription_date >=", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateLessThan(Date value) {
            addCriterionForJDBCDate("prescription_date <", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("prescription_date <=", value, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateIn(List<Date> values) {
            addCriterionForJDBCDate("prescription_date in", values, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("prescription_date not in", values, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prescription_date between", value1, value2, "prescriptionDate");
            return (Criteria) this;
        }

        public Criteria andPrescriptionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("prescription_date not between", value1, value2, "prescriptionDate");
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