package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jx3PricePeriodErrorInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3PricePeriodErrorInfoExample() {
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

        public Criteria andErrorIdIsNull() {
            addCriterion("ERROR_ID is null");
            return (Criteria) this;
        }

        public Criteria andErrorIdIsNotNull() {
            addCriterion("ERROR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andErrorIdEqualTo(Integer value) {
            addCriterion("ERROR_ID =", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotEqualTo(Integer value) {
            addCriterion("ERROR_ID <>", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdGreaterThan(Integer value) {
            addCriterion("ERROR_ID >", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_ID >=", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdLessThan(Integer value) {
            addCriterion("ERROR_ID <", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_ID <=", value, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdIn(List<Integer> values) {
            addCriterion("ERROR_ID in", values, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotIn(List<Integer> values) {
            addCriterion("ERROR_ID not in", values, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_ID between", value1, value2, "errorId");
            return (Criteria) this;
        }

        public Criteria andErrorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_ID not between", value1, value2, "errorId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("BATCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("BATCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("BATCH_ID =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("BATCH_ID <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("BATCH_ID >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("BATCH_ID >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("BATCH_ID <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("BATCH_ID <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("BATCH_ID like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("BATCH_ID not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("BATCH_ID in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("BATCH_ID not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("BATCH_ID between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("BATCH_ID not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("START_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("START_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(Integer value) {
            addCriterion("START_PRICE =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(Integer value) {
            addCriterion("START_PRICE <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(Integer value) {
            addCriterion("START_PRICE >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("START_PRICE >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(Integer value) {
            addCriterion("START_PRICE <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(Integer value) {
            addCriterion("START_PRICE <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<Integer> values) {
            addCriterion("START_PRICE in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<Integer> values) {
            addCriterion("START_PRICE not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(Integer value1, Integer value2) {
            addCriterion("START_PRICE between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("START_PRICE not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceIsNull() {
            addCriterion("END_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andEndPriceIsNotNull() {
            addCriterion("END_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andEndPriceEqualTo(Integer value) {
            addCriterion("END_PRICE =", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceNotEqualTo(Integer value) {
            addCriterion("END_PRICE <>", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceGreaterThan(Integer value) {
            addCriterion("END_PRICE >", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("END_PRICE >=", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceLessThan(Integer value) {
            addCriterion("END_PRICE <", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceLessThanOrEqualTo(Integer value) {
            addCriterion("END_PRICE <=", value, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceIn(List<Integer> values) {
            addCriterion("END_PRICE in", values, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceNotIn(List<Integer> values) {
            addCriterion("END_PRICE not in", values, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceBetween(Integer value1, Integer value2) {
            addCriterion("END_PRICE between", value1, value2, "endPrice");
            return (Criteria) this;
        }

        public Criteria andEndPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("END_PRICE not between", value1, value2, "endPrice");
            return (Criteria) this;
        }

        public Criteria andErrorStateIsNull() {
            addCriterion("ERROR_STATE is null");
            return (Criteria) this;
        }

        public Criteria andErrorStateIsNotNull() {
            addCriterion("ERROR_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorStateEqualTo(Integer value) {
            addCriterion("ERROR_STATE =", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateNotEqualTo(Integer value) {
            addCriterion("ERROR_STATE <>", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateGreaterThan(Integer value) {
            addCriterion("ERROR_STATE >", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_STATE >=", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateLessThan(Integer value) {
            addCriterion("ERROR_STATE <", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_STATE <=", value, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateIn(List<Integer> values) {
            addCriterion("ERROR_STATE in", values, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateNotIn(List<Integer> values) {
            addCriterion("ERROR_STATE not in", values, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_STATE between", value1, value2, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorStateNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_STATE not between", value1, value2, "errorState");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoIsNull() {
            addCriterion("ERROR_PAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoIsNotNull() {
            addCriterion("ERROR_PAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoEqualTo(Integer value) {
            addCriterion("ERROR_PAGE_NO =", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoNotEqualTo(Integer value) {
            addCriterion("ERROR_PAGE_NO <>", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoGreaterThan(Integer value) {
            addCriterion("ERROR_PAGE_NO >", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_PAGE_NO >=", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoLessThan(Integer value) {
            addCriterion("ERROR_PAGE_NO <", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_PAGE_NO <=", value, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoIn(List<Integer> values) {
            addCriterion("ERROR_PAGE_NO in", values, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoNotIn(List<Integer> values) {
            addCriterion("ERROR_PAGE_NO not in", values, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_PAGE_NO between", value1, value2, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andErrorPageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_PAGE_NO not between", value1, value2, "errorPageNo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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