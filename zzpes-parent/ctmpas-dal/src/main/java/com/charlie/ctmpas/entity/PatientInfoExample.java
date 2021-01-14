package com.charlie.ctmpas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PatientInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientInfoExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andPatientSeqIsNull() {
            addCriterion("patient_seq is null");
            return (Criteria) this;
        }

        public Criteria andPatientSeqIsNotNull() {
            addCriterion("patient_seq is not null");
            return (Criteria) this;
        }

        public Criteria andPatientSeqEqualTo(Long value) {
            addCriterion("patient_seq =", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqNotEqualTo(Long value) {
            addCriterion("patient_seq <>", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqGreaterThan(Long value) {
            addCriterion("patient_seq >", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("patient_seq >=", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqLessThan(Long value) {
            addCriterion("patient_seq <", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqLessThanOrEqualTo(Long value) {
            addCriterion("patient_seq <=", value, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqIn(List<Long> values) {
            addCriterion("patient_seq in", values, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqNotIn(List<Long> values) {
            addCriterion("patient_seq not in", values, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqBetween(Long value1, Long value2) {
            addCriterion("patient_seq between", value1, value2, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientSeqNotBetween(Long value1, Long value2) {
            addCriterion("patient_seq not between", value1, value2, "patientSeq");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNull() {
            addCriterion("patient_name is null");
            return (Criteria) this;
        }

        public Criteria andPatientNameIsNotNull() {
            addCriterion("patient_name is not null");
            return (Criteria) this;
        }

        public Criteria andPatientNameEqualTo(String value) {
            addCriterion("patient_name =", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotEqualTo(String value) {
            addCriterion("patient_name <>", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThan(String value) {
            addCriterion("patient_name >", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameGreaterThanOrEqualTo(String value) {
            addCriterion("patient_name >=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThan(String value) {
            addCriterion("patient_name <", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLessThanOrEqualTo(String value) {
            addCriterion("patient_name <=", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameLike(String value) {
            addCriterion("patient_name like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotLike(String value) {
            addCriterion("patient_name not like", value, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameIn(List<String> values) {
            addCriterion("patient_name in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotIn(List<String> values) {
            addCriterion("patient_name not in", values, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameBetween(String value1, String value2) {
            addCriterion("patient_name between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andPatientNameNotBetween(String value1, String value2) {
            addCriterion("patient_name not between", value1, value2, "patientName");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andTreatTimesIsNull() {
            addCriterion("treat_times is null");
            return (Criteria) this;
        }

        public Criteria andTreatTimesIsNotNull() {
            addCriterion("treat_times is not null");
            return (Criteria) this;
        }

        public Criteria andTreatTimesEqualTo(Integer value) {
            addCriterion("treat_times =", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesNotEqualTo(Integer value) {
            addCriterion("treat_times <>", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesGreaterThan(Integer value) {
            addCriterion("treat_times >", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("treat_times >=", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesLessThan(Integer value) {
            addCriterion("treat_times <", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesLessThanOrEqualTo(Integer value) {
            addCriterion("treat_times <=", value, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesIn(List<Integer> values) {
            addCriterion("treat_times in", values, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesNotIn(List<Integer> values) {
            addCriterion("treat_times not in", values, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesBetween(Integer value1, Integer value2) {
            addCriterion("treat_times between", value1, value2, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andTreatTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("treat_times not between", value1, value2, "treatTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesIsNull() {
            addCriterion("cure_times is null");
            return (Criteria) this;
        }

        public Criteria andCureTimesIsNotNull() {
            addCriterion("cure_times is not null");
            return (Criteria) this;
        }

        public Criteria andCureTimesEqualTo(Integer value) {
            addCriterion("cure_times =", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesNotEqualTo(Integer value) {
            addCriterion("cure_times <>", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesGreaterThan(Integer value) {
            addCriterion("cure_times >", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("cure_times >=", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesLessThan(Integer value) {
            addCriterion("cure_times <", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesLessThanOrEqualTo(Integer value) {
            addCriterion("cure_times <=", value, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesIn(List<Integer> values) {
            addCriterion("cure_times in", values, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesNotIn(List<Integer> values) {
            addCriterion("cure_times not in", values, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesBetween(Integer value1, Integer value2) {
            addCriterion("cure_times between", value1, value2, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andCureTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("cure_times not between", value1, value2, "cureTimes");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterionForJDBCTime("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeIsNull() {
            addCriterion("last_update_type is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeIsNotNull() {
            addCriterion("last_update_type is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeEqualTo(String value) {
            addCriterion("last_update_type =", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeNotEqualTo(String value) {
            addCriterion("last_update_type <>", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeGreaterThan(String value) {
            addCriterion("last_update_type >", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_type >=", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeLessThan(String value) {
            addCriterion("last_update_type <", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeLessThanOrEqualTo(String value) {
            addCriterion("last_update_type <=", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeLike(String value) {
            addCriterion("last_update_type like", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeNotLike(String value) {
            addCriterion("last_update_type not like", value, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeIn(List<String> values) {
            addCriterion("last_update_type in", values, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeNotIn(List<String> values) {
            addCriterion("last_update_type not in", values, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeBetween(String value1, String value2) {
            addCriterion("last_update_type between", value1, value2, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTypeNotBetween(String value1, String value2) {
            addCriterion("last_update_type not between", value1, value2, "lastUpdateType");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNull() {
            addCriterion("last_update_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNotNull() {
            addCriterion("last_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserEqualTo(String value) {
            addCriterion("last_update_user =", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotEqualTo(String value) {
            addCriterion("last_update_user <>", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThan(String value) {
            addCriterion("last_update_user >", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_user >=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThan(String value) {
            addCriterion("last_update_user <", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("last_update_user <=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLike(String value) {
            addCriterion("last_update_user like", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotLike(String value) {
            addCriterion("last_update_user not like", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIn(List<String> values) {
            addCriterion("last_update_user in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotIn(List<String> values) {
            addCriterion("last_update_user not in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserBetween(String value1, String value2) {
            addCriterion("last_update_user between", value1, value2, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotBetween(String value1, String value2) {
            addCriterion("last_update_user not between", value1, value2, "lastUpdateUser");
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