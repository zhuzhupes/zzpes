package com.xiaozhu.zzpes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jx3RoleInfoOverallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Jx3RoleInfoOverallExample() {
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

        public Criteria andJx3rIdIsNull() {
            addCriterion("JX3R_ID is null");
            return (Criteria) this;
        }

        public Criteria andJx3rIdIsNotNull() {
            addCriterion("JX3R_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJx3rIdEqualTo(String value) {
            addCriterion("JX3R_ID =", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdNotEqualTo(String value) {
            addCriterion("JX3R_ID <>", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdGreaterThan(String value) {
            addCriterion("JX3R_ID >", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdGreaterThanOrEqualTo(String value) {
            addCriterion("JX3R_ID >=", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdLessThan(String value) {
            addCriterion("JX3R_ID <", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdLessThanOrEqualTo(String value) {
            addCriterion("JX3R_ID <=", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdLike(String value) {
            addCriterion("JX3R_ID like", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdNotLike(String value) {
            addCriterion("JX3R_ID not like", value, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdIn(List<String> values) {
            addCriterion("JX3R_ID in", values, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdNotIn(List<String> values) {
            addCriterion("JX3R_ID not in", values, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdBetween(String value1, String value2) {
            addCriterion("JX3R_ID between", value1, value2, "jx3rId");
            return (Criteria) this;
        }

        public Criteria andJx3rIdNotBetween(String value1, String value2) {
            addCriterion("JX3R_ID not between", value1, value2, "jx3rId");
            return (Criteria) this;
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

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andFollowNumIsNull() {
            addCriterion("FOLLOW_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFollowNumIsNotNull() {
            addCriterion("FOLLOW_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFollowNumEqualTo(Integer value) {
            addCriterion("FOLLOW_NUM =", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumNotEqualTo(Integer value) {
            addCriterion("FOLLOW_NUM <>", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumGreaterThan(Integer value) {
            addCriterion("FOLLOW_NUM >", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FOLLOW_NUM >=", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumLessThan(Integer value) {
            addCriterion("FOLLOW_NUM <", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumLessThanOrEqualTo(Integer value) {
            addCriterion("FOLLOW_NUM <=", value, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumIn(List<Integer> values) {
            addCriterion("FOLLOW_NUM in", values, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumNotIn(List<Integer> values) {
            addCriterion("FOLLOW_NUM not in", values, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumBetween(Integer value1, Integer value2) {
            addCriterion("FOLLOW_NUM between", value1, value2, "followNum");
            return (Criteria) this;
        }

        public Criteria andFollowNumNotBetween(Integer value1, Integer value2) {
            addCriterion("FOLLOW_NUM not between", value1, value2, "followNum");
            return (Criteria) this;
        }

        public Criteria andExpPointIsNull() {
            addCriterion("EXP_POINT is null");
            return (Criteria) this;
        }

        public Criteria andExpPointIsNotNull() {
            addCriterion("EXP_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andExpPointEqualTo(Integer value) {
            addCriterion("EXP_POINT =", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointNotEqualTo(Integer value) {
            addCriterion("EXP_POINT <>", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointGreaterThan(Integer value) {
            addCriterion("EXP_POINT >", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXP_POINT >=", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointLessThan(Integer value) {
            addCriterion("EXP_POINT <", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointLessThanOrEqualTo(Integer value) {
            addCriterion("EXP_POINT <=", value, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointIn(List<Integer> values) {
            addCriterion("EXP_POINT in", values, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointNotIn(List<Integer> values) {
            addCriterion("EXP_POINT not in", values, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointBetween(Integer value1, Integer value2) {
            addCriterion("EXP_POINT between", value1, value2, "expPoint");
            return (Criteria) this;
        }

        public Criteria andExpPointNotBetween(Integer value1, Integer value2) {
            addCriterion("EXP_POINT not between", value1, value2, "expPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointIsNull() {
            addCriterion("EQUIP_POINT is null");
            return (Criteria) this;
        }

        public Criteria andEquipPointIsNotNull() {
            addCriterion("EQUIP_POINT is not null");
            return (Criteria) this;
        }

        public Criteria andEquipPointEqualTo(Integer value) {
            addCriterion("EQUIP_POINT =", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointNotEqualTo(Integer value) {
            addCriterion("EQUIP_POINT <>", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointGreaterThan(Integer value) {
            addCriterion("EQUIP_POINT >", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("EQUIP_POINT >=", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointLessThan(Integer value) {
            addCriterion("EQUIP_POINT <", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointLessThanOrEqualTo(Integer value) {
            addCriterion("EQUIP_POINT <=", value, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointIn(List<Integer> values) {
            addCriterion("EQUIP_POINT in", values, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointNotIn(List<Integer> values) {
            addCriterion("EQUIP_POINT not in", values, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointBetween(Integer value1, Integer value2) {
            addCriterion("EQUIP_POINT between", value1, value2, "equipPoint");
            return (Criteria) this;
        }

        public Criteria andEquipPointNotBetween(Integer value1, Integer value2) {
            addCriterion("EQUIP_POINT not between", value1, value2, "equipPoint");
            return (Criteria) this;
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

        public Criteria andServerIdIsNull() {
            addCriterion("SERVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("SERVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(String value) {
            addCriterion("SERVER_ID =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(String value) {
            addCriterion("SERVER_ID <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(String value) {
            addCriterion("SERVER_ID >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_ID >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(String value) {
            addCriterion("SERVER_ID <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(String value) {
            addCriterion("SERVER_ID <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLike(String value) {
            addCriterion("SERVER_ID like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotLike(String value) {
            addCriterion("SERVER_ID not like", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<String> values) {
            addCriterion("SERVER_ID in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<String> values) {
            addCriterion("SERVER_ID not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(String value1, String value2) {
            addCriterion("SERVER_ID between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(String value1, String value2) {
            addCriterion("SERVER_ID not between", value1, value2, "serverId");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeIsNull() {
            addCriterion("DTL_INFO_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeIsNotNull() {
            addCriterion("DTL_INFO_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeEqualTo(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME =", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeNotEqualTo(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME <>", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeGreaterThan(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME >", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME >=", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeLessThan(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME <", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("DTL_INFO_UPDATE_TIME <=", value, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeIn(List<Date> values) {
            addCriterion("DTL_INFO_UPDATE_TIME in", values, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeNotIn(List<Date> values) {
            addCriterion("DTL_INFO_UPDATE_TIME not in", values, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("DTL_INFO_UPDATE_TIME between", value1, value2, "dtlInfoUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDtlInfoUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("DTL_INFO_UPDATE_TIME not between", value1, value2, "dtlInfoUpdateTime");
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

        public Criteria andRemainingTimeIsNull() {
            addCriterion("REMAINING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeIsNotNull() {
            addCriterion("REMAINING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeEqualTo(Integer value) {
            addCriterion("REMAINING_TIME =", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotEqualTo(Integer value) {
            addCriterion("REMAINING_TIME <>", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeGreaterThan(Integer value) {
            addCriterion("REMAINING_TIME >", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("REMAINING_TIME >=", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeLessThan(Integer value) {
            addCriterion("REMAINING_TIME <", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("REMAINING_TIME <=", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeIn(List<Integer> values) {
            addCriterion("REMAINING_TIME in", values, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotIn(List<Integer> values) {
            addCriterion("REMAINING_TIME not in", values, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeBetween(Integer value1, Integer value2) {
            addCriterion("REMAINING_TIME between", value1, value2, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("REMAINING_TIME not between", value1, value2, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
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