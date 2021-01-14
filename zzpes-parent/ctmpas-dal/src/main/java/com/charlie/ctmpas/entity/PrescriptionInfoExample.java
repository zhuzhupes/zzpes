package com.charlie.ctmpas.entity;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrescriptionInfoExample() {
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

        public Criteria andPrescriptionSeqIsNull() {
            addCriterion("prescription_seq is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqIsNotNull() {
            addCriterion("prescription_seq is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqEqualTo(Integer value) {
            addCriterion("prescription_seq =", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqNotEqualTo(Integer value) {
            addCriterion("prescription_seq <>", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqGreaterThan(Integer value) {
            addCriterion("prescription_seq >", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_seq >=", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqLessThan(Integer value) {
            addCriterion("prescription_seq <", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_seq <=", value, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqIn(List<Integer> values) {
            addCriterion("prescription_seq in", values, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqNotIn(List<Integer> values) {
            addCriterion("prescription_seq not in", values, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqBetween(Integer value1, Integer value2) {
            addCriterion("prescription_seq between", value1, value2, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_seq not between", value1, value2, "prescriptionSeq");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNull() {
            addCriterion("prescription_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIsNotNull() {
            addCriterion("prescription_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdEqualTo(Integer value) {
            addCriterion("prescription_id =", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotEqualTo(Integer value) {
            addCriterion("prescription_id <>", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThan(Integer value) {
            addCriterion("prescription_id >", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescription_id >=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThan(Integer value) {
            addCriterion("prescription_id <", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescription_id <=", value, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdIn(List<Integer> values) {
            addCriterion("prescription_id in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotIn(List<Integer> values) {
            addCriterion("prescription_id not in", values, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id between", value1, value2, "prescriptionId");
            return (Criteria) this;
        }

        public Criteria andPrescriptionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescription_id not between", value1, value2, "prescriptionId");
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

        public Criteria andUnitNumIsNull() {
            addCriterion("unit_num is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNotNull() {
            addCriterion("unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumEqualTo(Integer value) {
            addCriterion("unit_num =", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotEqualTo(Integer value) {
            addCriterion("unit_num <>", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThan(Integer value) {
            addCriterion("unit_num >", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_num >=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThan(Integer value) {
            addCriterion("unit_num <", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThanOrEqualTo(Integer value) {
            addCriterion("unit_num <=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIn(List<Integer> values) {
            addCriterion("unit_num in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotIn(List<Integer> values) {
            addCriterion("unit_num not in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumBetween(Integer value1, Integer value2) {
            addCriterion("unit_num between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_num not between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andOperationSeqIsNull() {
            addCriterion("operation_seq is null");
            return (Criteria) this;
        }

        public Criteria andOperationSeqIsNotNull() {
            addCriterion("operation_seq is not null");
            return (Criteria) this;
        }

        public Criteria andOperationSeqEqualTo(Integer value) {
            addCriterion("operation_seq =", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqNotEqualTo(Integer value) {
            addCriterion("operation_seq <>", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqGreaterThan(Integer value) {
            addCriterion("operation_seq >", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_seq >=", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqLessThan(Integer value) {
            addCriterion("operation_seq <", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqLessThanOrEqualTo(Integer value) {
            addCriterion("operation_seq <=", value, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqIn(List<Integer> values) {
            addCriterion("operation_seq in", values, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqNotIn(List<Integer> values) {
            addCriterion("operation_seq not in", values, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqBetween(Integer value1, Integer value2) {
            addCriterion("operation_seq between", value1, value2, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_seq not between", value1, value2, "operationSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqIsNull() {
            addCriterion("operation_unit_seq is null");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqIsNotNull() {
            addCriterion("operation_unit_seq is not null");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqEqualTo(Integer value) {
            addCriterion("operation_unit_seq =", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqNotEqualTo(Integer value) {
            addCriterion("operation_unit_seq <>", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqGreaterThan(Integer value) {
            addCriterion("operation_unit_seq >", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_unit_seq >=", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqLessThan(Integer value) {
            addCriterion("operation_unit_seq <", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqLessThanOrEqualTo(Integer value) {
            addCriterion("operation_unit_seq <=", value, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqIn(List<Integer> values) {
            addCriterion("operation_unit_seq in", values, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqNotIn(List<Integer> values) {
            addCriterion("operation_unit_seq not in", values, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqBetween(Integer value1, Integer value2) {
            addCriterion("operation_unit_seq between", value1, value2, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_unit_seq not between", value1, value2, "operationUnitSeq");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumIsNull() {
            addCriterion("operation_unit_num is null");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumIsNotNull() {
            addCriterion("operation_unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumEqualTo(Integer value) {
            addCriterion("operation_unit_num =", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumNotEqualTo(Integer value) {
            addCriterion("operation_unit_num <>", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumGreaterThan(Integer value) {
            addCriterion("operation_unit_num >", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_unit_num >=", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumLessThan(Integer value) {
            addCriterion("operation_unit_num <", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumLessThanOrEqualTo(Integer value) {
            addCriterion("operation_unit_num <=", value, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumIn(List<Integer> values) {
            addCriterion("operation_unit_num in", values, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumNotIn(List<Integer> values) {
            addCriterion("operation_unit_num not in", values, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumBetween(Integer value1, Integer value2) {
            addCriterion("operation_unit_num between", value1, value2, "operationUnitNum");
            return (Criteria) this;
        }

        public Criteria andOperationUnitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_unit_num not between", value1, value2, "operationUnitNum");
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