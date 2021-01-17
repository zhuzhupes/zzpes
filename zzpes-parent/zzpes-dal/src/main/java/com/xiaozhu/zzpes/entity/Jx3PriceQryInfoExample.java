package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jx3PriceQryInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3PriceQryInfoExample() {
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

        public Criteria andQryIdIsNull() {
            addCriterion("QRY_ID is null");
            return (Criteria) this;
        }

        public Criteria andQryIdIsNotNull() {
            addCriterion("QRY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQryIdEqualTo(Integer value) {
            addCriterion("QRY_ID =", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdNotEqualTo(Integer value) {
            addCriterion("QRY_ID <>", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdGreaterThan(Integer value) {
            addCriterion("QRY_ID >", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("QRY_ID >=", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdLessThan(Integer value) {
            addCriterion("QRY_ID <", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdLessThanOrEqualTo(Integer value) {
            addCriterion("QRY_ID <=", value, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdIn(List<Integer> values) {
            addCriterion("QRY_ID in", values, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdNotIn(List<Integer> values) {
            addCriterion("QRY_ID not in", values, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdBetween(Integer value1, Integer value2) {
            addCriterion("QRY_ID between", value1, value2, "qryId");
            return (Criteria) this;
        }

        public Criteria andQryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("QRY_ID not between", value1, value2, "qryId");
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

        public Criteria andPageNoIsNull() {
            addCriterion("PAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andPageNoIsNotNull() {
            addCriterion("PAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPageNoEqualTo(Integer value) {
            addCriterion("PAGE_NO =", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoNotEqualTo(Integer value) {
            addCriterion("PAGE_NO <>", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoGreaterThan(Integer value) {
            addCriterion("PAGE_NO >", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGE_NO >=", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoLessThan(Integer value) {
            addCriterion("PAGE_NO <", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoLessThanOrEqualTo(Integer value) {
            addCriterion("PAGE_NO <=", value, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoIn(List<Integer> values) {
            addCriterion("PAGE_NO in", values, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoNotIn(List<Integer> values) {
            addCriterion("PAGE_NO not in", values, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_NO between", value1, value2, "pageNo");
            return (Criteria) this;
        }

        public Criteria andPageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_NO not between", value1, value2, "pageNo");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsIsNull() {
            addCriterion("RANGE_TOTAL_NUMS is null");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsIsNotNull() {
            addCriterion("RANGE_TOTAL_NUMS is not null");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsEqualTo(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS =", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsNotEqualTo(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS <>", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsGreaterThan(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS >", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS >=", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsLessThan(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS <", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsLessThanOrEqualTo(Integer value) {
            addCriterion("RANGE_TOTAL_NUMS <=", value, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsIn(List<Integer> values) {
            addCriterion("RANGE_TOTAL_NUMS in", values, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsNotIn(List<Integer> values) {
            addCriterion("RANGE_TOTAL_NUMS not in", values, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsBetween(Integer value1, Integer value2) {
            addCriterion("RANGE_TOTAL_NUMS between", value1, value2, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andRangeTotalNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("RANGE_TOTAL_NUMS not between", value1, value2, "rangeTotalNums");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumIsNull() {
            addCriterion("NOW_PAGE_DATA_NUM is null");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumIsNotNull() {
            addCriterion("NOW_PAGE_DATA_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumEqualTo(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM =", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumNotEqualTo(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM <>", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumGreaterThan(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM >", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM >=", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumLessThan(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM <", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumLessThanOrEqualTo(Integer value) {
            addCriterion("NOW_PAGE_DATA_NUM <=", value, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumIn(List<Integer> values) {
            addCriterion("NOW_PAGE_DATA_NUM in", values, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumNotIn(List<Integer> values) {
            addCriterion("NOW_PAGE_DATA_NUM not in", values, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumBetween(Integer value1, Integer value2) {
            addCriterion("NOW_PAGE_DATA_NUM between", value1, value2, "nowPageDataNum");
            return (Criteria) this;
        }

        public Criteria andNowPageDataNumNotBetween(Integer value1, Integer value2) {
            addCriterion("NOW_PAGE_DATA_NUM not between", value1, value2, "nowPageDataNum");
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