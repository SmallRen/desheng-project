package com.desheng.pojo;

import java.util.ArrayList;
import java.util.List;

public class WzWorkLineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzWorkLineExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWzItfIdIsNull() {
            addCriterion("wz_itf_id is null");
            return (Criteria) this;
        }

        public Criteria andWzItfIdIsNotNull() {
            addCriterion("wz_itf_id is not null");
            return (Criteria) this;
        }

        public Criteria andWzItfIdEqualTo(Integer value) {
            addCriterion("wz_itf_id =", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdNotEqualTo(Integer value) {
            addCriterion("wz_itf_id <>", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdGreaterThan(Integer value) {
            addCriterion("wz_itf_id >", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wz_itf_id >=", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdLessThan(Integer value) {
            addCriterion("wz_itf_id <", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdLessThanOrEqualTo(Integer value) {
            addCriterion("wz_itf_id <=", value, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdIn(List<Integer> values) {
            addCriterion("wz_itf_id in", values, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdNotIn(List<Integer> values) {
            addCriterion("wz_itf_id not in", values, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdBetween(Integer value1, Integer value2) {
            addCriterion("wz_itf_id between", value1, value2, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andWzItfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wz_itf_id not between", value1, value2, "wzItfId");
            return (Criteria) this;
        }

        public Criteria andPoint1IsNull() {
            addCriterion("point1 is null");
            return (Criteria) this;
        }

        public Criteria andPoint1IsNotNull() {
            addCriterion("point1 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint1EqualTo(String value) {
            addCriterion("point1 =", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1NotEqualTo(String value) {
            addCriterion("point1 <>", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1GreaterThan(String value) {
            addCriterion("point1 >", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1GreaterThanOrEqualTo(String value) {
            addCriterion("point1 >=", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1LessThan(String value) {
            addCriterion("point1 <", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1LessThanOrEqualTo(String value) {
            addCriterion("point1 <=", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1Like(String value) {
            addCriterion("point1 like", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1NotLike(String value) {
            addCriterion("point1 not like", value, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1In(List<String> values) {
            addCriterion("point1 in", values, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1NotIn(List<String> values) {
            addCriterion("point1 not in", values, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1Between(String value1, String value2) {
            addCriterion("point1 between", value1, value2, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1NotBetween(String value1, String value2) {
            addCriterion("point1 not between", value1, value2, "point1");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeIsNull() {
            addCriterion("point1_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeIsNotNull() {
            addCriterion("point1_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeEqualTo(String value) {
            addCriterion("point1_time =", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeNotEqualTo(String value) {
            addCriterion("point1_time <>", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeGreaterThan(String value) {
            addCriterion("point1_time >", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point1_time >=", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeLessThan(String value) {
            addCriterion("point1_time <", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeLessThanOrEqualTo(String value) {
            addCriterion("point1_time <=", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeLike(String value) {
            addCriterion("point1_time like", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeNotLike(String value) {
            addCriterion("point1_time not like", value, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeIn(List<String> values) {
            addCriterion("point1_time in", values, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeNotIn(List<String> values) {
            addCriterion("point1_time not in", values, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeBetween(String value1, String value2) {
            addCriterion("point1_time between", value1, value2, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TimeNotBetween(String value1, String value2) {
            addCriterion("point1_time not between", value1, value2, "point1Time");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverIsNull() {
            addCriterion("point1_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverIsNotNull() {
            addCriterion("point1_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverEqualTo(String value) {
            addCriterion("point1_turnover =", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverNotEqualTo(String value) {
            addCriterion("point1_turnover <>", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverGreaterThan(String value) {
            addCriterion("point1_turnover >", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point1_turnover >=", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverLessThan(String value) {
            addCriterion("point1_turnover <", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point1_turnover <=", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverLike(String value) {
            addCriterion("point1_turnover like", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverNotLike(String value) {
            addCriterion("point1_turnover not like", value, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverIn(List<String> values) {
            addCriterion("point1_turnover in", values, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverNotIn(List<String> values) {
            addCriterion("point1_turnover not in", values, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverBetween(String value1, String value2) {
            addCriterion("point1_turnover between", value1, value2, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint1TurnoverNotBetween(String value1, String value2) {
            addCriterion("point1_turnover not between", value1, value2, "point1Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2IsNull() {
            addCriterion("point2 is null");
            return (Criteria) this;
        }

        public Criteria andPoint2IsNotNull() {
            addCriterion("point2 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint2EqualTo(String value) {
            addCriterion("point2 =", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2NotEqualTo(String value) {
            addCriterion("point2 <>", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2GreaterThan(String value) {
            addCriterion("point2 >", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2GreaterThanOrEqualTo(String value) {
            addCriterion("point2 >=", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2LessThan(String value) {
            addCriterion("point2 <", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2LessThanOrEqualTo(String value) {
            addCriterion("point2 <=", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2Like(String value) {
            addCriterion("point2 like", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2NotLike(String value) {
            addCriterion("point2 not like", value, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2In(List<String> values) {
            addCriterion("point2 in", values, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2NotIn(List<String> values) {
            addCriterion("point2 not in", values, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2Between(String value1, String value2) {
            addCriterion("point2 between", value1, value2, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2NotBetween(String value1, String value2) {
            addCriterion("point2 not between", value1, value2, "point2");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeIsNull() {
            addCriterion("point2_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeIsNotNull() {
            addCriterion("point2_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeEqualTo(String value) {
            addCriterion("point2_time =", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeNotEqualTo(String value) {
            addCriterion("point2_time <>", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeGreaterThan(String value) {
            addCriterion("point2_time >", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point2_time >=", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeLessThan(String value) {
            addCriterion("point2_time <", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeLessThanOrEqualTo(String value) {
            addCriterion("point2_time <=", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeLike(String value) {
            addCriterion("point2_time like", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeNotLike(String value) {
            addCriterion("point2_time not like", value, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeIn(List<String> values) {
            addCriterion("point2_time in", values, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeNotIn(List<String> values) {
            addCriterion("point2_time not in", values, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeBetween(String value1, String value2) {
            addCriterion("point2_time between", value1, value2, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TimeNotBetween(String value1, String value2) {
            addCriterion("point2_time not between", value1, value2, "point2Time");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverIsNull() {
            addCriterion("point2_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverIsNotNull() {
            addCriterion("point2_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverEqualTo(String value) {
            addCriterion("point2_turnover =", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverNotEqualTo(String value) {
            addCriterion("point2_turnover <>", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverGreaterThan(String value) {
            addCriterion("point2_turnover >", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point2_turnover >=", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverLessThan(String value) {
            addCriterion("point2_turnover <", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point2_turnover <=", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverLike(String value) {
            addCriterion("point2_turnover like", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverNotLike(String value) {
            addCriterion("point2_turnover not like", value, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverIn(List<String> values) {
            addCriterion("point2_turnover in", values, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverNotIn(List<String> values) {
            addCriterion("point2_turnover not in", values, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverBetween(String value1, String value2) {
            addCriterion("point2_turnover between", value1, value2, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint2TurnoverNotBetween(String value1, String value2) {
            addCriterion("point2_turnover not between", value1, value2, "point2Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3IsNull() {
            addCriterion("point3 is null");
            return (Criteria) this;
        }

        public Criteria andPoint3IsNotNull() {
            addCriterion("point3 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint3EqualTo(String value) {
            addCriterion("point3 =", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3NotEqualTo(String value) {
            addCriterion("point3 <>", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3GreaterThan(String value) {
            addCriterion("point3 >", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3GreaterThanOrEqualTo(String value) {
            addCriterion("point3 >=", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3LessThan(String value) {
            addCriterion("point3 <", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3LessThanOrEqualTo(String value) {
            addCriterion("point3 <=", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3Like(String value) {
            addCriterion("point3 like", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3NotLike(String value) {
            addCriterion("point3 not like", value, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3In(List<String> values) {
            addCriterion("point3 in", values, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3NotIn(List<String> values) {
            addCriterion("point3 not in", values, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3Between(String value1, String value2) {
            addCriterion("point3 between", value1, value2, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3NotBetween(String value1, String value2) {
            addCriterion("point3 not between", value1, value2, "point3");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeIsNull() {
            addCriterion("point3_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeIsNotNull() {
            addCriterion("point3_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeEqualTo(String value) {
            addCriterion("point3_time =", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeNotEqualTo(String value) {
            addCriterion("point3_time <>", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeGreaterThan(String value) {
            addCriterion("point3_time >", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point3_time >=", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeLessThan(String value) {
            addCriterion("point3_time <", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeLessThanOrEqualTo(String value) {
            addCriterion("point3_time <=", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeLike(String value) {
            addCriterion("point3_time like", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeNotLike(String value) {
            addCriterion("point3_time not like", value, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeIn(List<String> values) {
            addCriterion("point3_time in", values, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeNotIn(List<String> values) {
            addCriterion("point3_time not in", values, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeBetween(String value1, String value2) {
            addCriterion("point3_time between", value1, value2, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TimeNotBetween(String value1, String value2) {
            addCriterion("point3_time not between", value1, value2, "point3Time");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverIsNull() {
            addCriterion("point3_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverIsNotNull() {
            addCriterion("point3_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverEqualTo(String value) {
            addCriterion("point3_turnover =", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverNotEqualTo(String value) {
            addCriterion("point3_turnover <>", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverGreaterThan(String value) {
            addCriterion("point3_turnover >", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point3_turnover >=", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverLessThan(String value) {
            addCriterion("point3_turnover <", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point3_turnover <=", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverLike(String value) {
            addCriterion("point3_turnover like", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverNotLike(String value) {
            addCriterion("point3_turnover not like", value, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverIn(List<String> values) {
            addCriterion("point3_turnover in", values, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverNotIn(List<String> values) {
            addCriterion("point3_turnover not in", values, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverBetween(String value1, String value2) {
            addCriterion("point3_turnover between", value1, value2, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint3TurnoverNotBetween(String value1, String value2) {
            addCriterion("point3_turnover not between", value1, value2, "point3Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4IsNull() {
            addCriterion("point4 is null");
            return (Criteria) this;
        }

        public Criteria andPoint4IsNotNull() {
            addCriterion("point4 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint4EqualTo(String value) {
            addCriterion("point4 =", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4NotEqualTo(String value) {
            addCriterion("point4 <>", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4GreaterThan(String value) {
            addCriterion("point4 >", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4GreaterThanOrEqualTo(String value) {
            addCriterion("point4 >=", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4LessThan(String value) {
            addCriterion("point4 <", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4LessThanOrEqualTo(String value) {
            addCriterion("point4 <=", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4Like(String value) {
            addCriterion("point4 like", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4NotLike(String value) {
            addCriterion("point4 not like", value, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4In(List<String> values) {
            addCriterion("point4 in", values, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4NotIn(List<String> values) {
            addCriterion("point4 not in", values, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4Between(String value1, String value2) {
            addCriterion("point4 between", value1, value2, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4NotBetween(String value1, String value2) {
            addCriterion("point4 not between", value1, value2, "point4");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeIsNull() {
            addCriterion("point4_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeIsNotNull() {
            addCriterion("point4_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeEqualTo(String value) {
            addCriterion("point4_time =", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeNotEqualTo(String value) {
            addCriterion("point4_time <>", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeGreaterThan(String value) {
            addCriterion("point4_time >", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point4_time >=", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeLessThan(String value) {
            addCriterion("point4_time <", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeLessThanOrEqualTo(String value) {
            addCriterion("point4_time <=", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeLike(String value) {
            addCriterion("point4_time like", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeNotLike(String value) {
            addCriterion("point4_time not like", value, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeIn(List<String> values) {
            addCriterion("point4_time in", values, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeNotIn(List<String> values) {
            addCriterion("point4_time not in", values, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeBetween(String value1, String value2) {
            addCriterion("point4_time between", value1, value2, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TimeNotBetween(String value1, String value2) {
            addCriterion("point4_time not between", value1, value2, "point4Time");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverIsNull() {
            addCriterion("point4_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverIsNotNull() {
            addCriterion("point4_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverEqualTo(String value) {
            addCriterion("point4_turnover =", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverNotEqualTo(String value) {
            addCriterion("point4_turnover <>", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverGreaterThan(String value) {
            addCriterion("point4_turnover >", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point4_turnover >=", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverLessThan(String value) {
            addCriterion("point4_turnover <", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point4_turnover <=", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverLike(String value) {
            addCriterion("point4_turnover like", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverNotLike(String value) {
            addCriterion("point4_turnover not like", value, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverIn(List<String> values) {
            addCriterion("point4_turnover in", values, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverNotIn(List<String> values) {
            addCriterion("point4_turnover not in", values, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverBetween(String value1, String value2) {
            addCriterion("point4_turnover between", value1, value2, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint4TurnoverNotBetween(String value1, String value2) {
            addCriterion("point4_turnover not between", value1, value2, "point4Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5IsNull() {
            addCriterion("point5 is null");
            return (Criteria) this;
        }

        public Criteria andPoint5IsNotNull() {
            addCriterion("point5 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint5EqualTo(String value) {
            addCriterion("point5 =", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5NotEqualTo(String value) {
            addCriterion("point5 <>", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5GreaterThan(String value) {
            addCriterion("point5 >", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5GreaterThanOrEqualTo(String value) {
            addCriterion("point5 >=", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5LessThan(String value) {
            addCriterion("point5 <", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5LessThanOrEqualTo(String value) {
            addCriterion("point5 <=", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5Like(String value) {
            addCriterion("point5 like", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5NotLike(String value) {
            addCriterion("point5 not like", value, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5In(List<String> values) {
            addCriterion("point5 in", values, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5NotIn(List<String> values) {
            addCriterion("point5 not in", values, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5Between(String value1, String value2) {
            addCriterion("point5 between", value1, value2, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5NotBetween(String value1, String value2) {
            addCriterion("point5 not between", value1, value2, "point5");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeIsNull() {
            addCriterion("point5_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeIsNotNull() {
            addCriterion("point5_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeEqualTo(String value) {
            addCriterion("point5_time =", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeNotEqualTo(String value) {
            addCriterion("point5_time <>", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeGreaterThan(String value) {
            addCriterion("point5_time >", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point5_time >=", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeLessThan(String value) {
            addCriterion("point5_time <", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeLessThanOrEqualTo(String value) {
            addCriterion("point5_time <=", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeLike(String value) {
            addCriterion("point5_time like", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeNotLike(String value) {
            addCriterion("point5_time not like", value, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeIn(List<String> values) {
            addCriterion("point5_time in", values, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeNotIn(List<String> values) {
            addCriterion("point5_time not in", values, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeBetween(String value1, String value2) {
            addCriterion("point5_time between", value1, value2, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TimeNotBetween(String value1, String value2) {
            addCriterion("point5_time not between", value1, value2, "point5Time");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverIsNull() {
            addCriterion("point5_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverIsNotNull() {
            addCriterion("point5_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverEqualTo(String value) {
            addCriterion("point5_turnover =", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverNotEqualTo(String value) {
            addCriterion("point5_turnover <>", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverGreaterThan(String value) {
            addCriterion("point5_turnover >", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point5_turnover >=", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverLessThan(String value) {
            addCriterion("point5_turnover <", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point5_turnover <=", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverLike(String value) {
            addCriterion("point5_turnover like", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverNotLike(String value) {
            addCriterion("point5_turnover not like", value, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverIn(List<String> values) {
            addCriterion("point5_turnover in", values, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverNotIn(List<String> values) {
            addCriterion("point5_turnover not in", values, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverBetween(String value1, String value2) {
            addCriterion("point5_turnover between", value1, value2, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint5TurnoverNotBetween(String value1, String value2) {
            addCriterion("point5_turnover not between", value1, value2, "point5Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6IsNull() {
            addCriterion("point6 is null");
            return (Criteria) this;
        }

        public Criteria andPoint6IsNotNull() {
            addCriterion("point6 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint6EqualTo(String value) {
            addCriterion("point6 =", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6NotEqualTo(String value) {
            addCriterion("point6 <>", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6GreaterThan(String value) {
            addCriterion("point6 >", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6GreaterThanOrEqualTo(String value) {
            addCriterion("point6 >=", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6LessThan(String value) {
            addCriterion("point6 <", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6LessThanOrEqualTo(String value) {
            addCriterion("point6 <=", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6Like(String value) {
            addCriterion("point6 like", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6NotLike(String value) {
            addCriterion("point6 not like", value, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6In(List<String> values) {
            addCriterion("point6 in", values, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6NotIn(List<String> values) {
            addCriterion("point6 not in", values, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6Between(String value1, String value2) {
            addCriterion("point6 between", value1, value2, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6NotBetween(String value1, String value2) {
            addCriterion("point6 not between", value1, value2, "point6");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeIsNull() {
            addCriterion("point6_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeIsNotNull() {
            addCriterion("point6_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeEqualTo(String value) {
            addCriterion("point6_time =", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeNotEqualTo(String value) {
            addCriterion("point6_time <>", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeGreaterThan(String value) {
            addCriterion("point6_time >", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point6_time >=", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeLessThan(String value) {
            addCriterion("point6_time <", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeLessThanOrEqualTo(String value) {
            addCriterion("point6_time <=", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeLike(String value) {
            addCriterion("point6_time like", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeNotLike(String value) {
            addCriterion("point6_time not like", value, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeIn(List<String> values) {
            addCriterion("point6_time in", values, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeNotIn(List<String> values) {
            addCriterion("point6_time not in", values, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeBetween(String value1, String value2) {
            addCriterion("point6_time between", value1, value2, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TimeNotBetween(String value1, String value2) {
            addCriterion("point6_time not between", value1, value2, "point6Time");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverIsNull() {
            addCriterion("point6_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverIsNotNull() {
            addCriterion("point6_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverEqualTo(String value) {
            addCriterion("point6_turnover =", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverNotEqualTo(String value) {
            addCriterion("point6_turnover <>", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverGreaterThan(String value) {
            addCriterion("point6_turnover >", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point6_turnover >=", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverLessThan(String value) {
            addCriterion("point6_turnover <", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point6_turnover <=", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverLike(String value) {
            addCriterion("point6_turnover like", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverNotLike(String value) {
            addCriterion("point6_turnover not like", value, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverIn(List<String> values) {
            addCriterion("point6_turnover in", values, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverNotIn(List<String> values) {
            addCriterion("point6_turnover not in", values, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverBetween(String value1, String value2) {
            addCriterion("point6_turnover between", value1, value2, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint6TurnoverNotBetween(String value1, String value2) {
            addCriterion("point6_turnover not between", value1, value2, "point6Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7IsNull() {
            addCriterion("point7 is null");
            return (Criteria) this;
        }

        public Criteria andPoint7IsNotNull() {
            addCriterion("point7 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint7EqualTo(String value) {
            addCriterion("point7 =", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7NotEqualTo(String value) {
            addCriterion("point7 <>", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7GreaterThan(String value) {
            addCriterion("point7 >", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7GreaterThanOrEqualTo(String value) {
            addCriterion("point7 >=", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7LessThan(String value) {
            addCriterion("point7 <", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7LessThanOrEqualTo(String value) {
            addCriterion("point7 <=", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7Like(String value) {
            addCriterion("point7 like", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7NotLike(String value) {
            addCriterion("point7 not like", value, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7In(List<String> values) {
            addCriterion("point7 in", values, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7NotIn(List<String> values) {
            addCriterion("point7 not in", values, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7Between(String value1, String value2) {
            addCriterion("point7 between", value1, value2, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7NotBetween(String value1, String value2) {
            addCriterion("point7 not between", value1, value2, "point7");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeIsNull() {
            addCriterion("point7_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeIsNotNull() {
            addCriterion("point7_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeEqualTo(String value) {
            addCriterion("point7_time =", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeNotEqualTo(String value) {
            addCriterion("point7_time <>", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeGreaterThan(String value) {
            addCriterion("point7_time >", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point7_time >=", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeLessThan(String value) {
            addCriterion("point7_time <", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeLessThanOrEqualTo(String value) {
            addCriterion("point7_time <=", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeLike(String value) {
            addCriterion("point7_time like", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeNotLike(String value) {
            addCriterion("point7_time not like", value, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeIn(List<String> values) {
            addCriterion("point7_time in", values, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeNotIn(List<String> values) {
            addCriterion("point7_time not in", values, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeBetween(String value1, String value2) {
            addCriterion("point7_time between", value1, value2, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TimeNotBetween(String value1, String value2) {
            addCriterion("point7_time not between", value1, value2, "point7Time");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverIsNull() {
            addCriterion("point7_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverIsNotNull() {
            addCriterion("point7_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverEqualTo(String value) {
            addCriterion("point7_turnover =", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverNotEqualTo(String value) {
            addCriterion("point7_turnover <>", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverGreaterThan(String value) {
            addCriterion("point7_turnover >", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point7_turnover >=", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverLessThan(String value) {
            addCriterion("point7_turnover <", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point7_turnover <=", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverLike(String value) {
            addCriterion("point7_turnover like", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverNotLike(String value) {
            addCriterion("point7_turnover not like", value, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverIn(List<String> values) {
            addCriterion("point7_turnover in", values, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverNotIn(List<String> values) {
            addCriterion("point7_turnover not in", values, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverBetween(String value1, String value2) {
            addCriterion("point7_turnover between", value1, value2, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint7TurnoverNotBetween(String value1, String value2) {
            addCriterion("point7_turnover not between", value1, value2, "point7Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8IsNull() {
            addCriterion("point8 is null");
            return (Criteria) this;
        }

        public Criteria andPoint8IsNotNull() {
            addCriterion("point8 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint8EqualTo(String value) {
            addCriterion("point8 =", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8NotEqualTo(String value) {
            addCriterion("point8 <>", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8GreaterThan(String value) {
            addCriterion("point8 >", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8GreaterThanOrEqualTo(String value) {
            addCriterion("point8 >=", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8LessThan(String value) {
            addCriterion("point8 <", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8LessThanOrEqualTo(String value) {
            addCriterion("point8 <=", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8Like(String value) {
            addCriterion("point8 like", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8NotLike(String value) {
            addCriterion("point8 not like", value, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8In(List<String> values) {
            addCriterion("point8 in", values, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8NotIn(List<String> values) {
            addCriterion("point8 not in", values, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8Between(String value1, String value2) {
            addCriterion("point8 between", value1, value2, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8NotBetween(String value1, String value2) {
            addCriterion("point8 not between", value1, value2, "point8");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeIsNull() {
            addCriterion("point8_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeIsNotNull() {
            addCriterion("point8_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeEqualTo(String value) {
            addCriterion("point8_time =", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeNotEqualTo(String value) {
            addCriterion("point8_time <>", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeGreaterThan(String value) {
            addCriterion("point8_time >", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point8_time >=", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeLessThan(String value) {
            addCriterion("point8_time <", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeLessThanOrEqualTo(String value) {
            addCriterion("point8_time <=", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeLike(String value) {
            addCriterion("point8_time like", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeNotLike(String value) {
            addCriterion("point8_time not like", value, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeIn(List<String> values) {
            addCriterion("point8_time in", values, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeNotIn(List<String> values) {
            addCriterion("point8_time not in", values, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeBetween(String value1, String value2) {
            addCriterion("point8_time between", value1, value2, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TimeNotBetween(String value1, String value2) {
            addCriterion("point8_time not between", value1, value2, "point8Time");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverIsNull() {
            addCriterion("point8_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverIsNotNull() {
            addCriterion("point8_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverEqualTo(String value) {
            addCriterion("point8_turnover =", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverNotEqualTo(String value) {
            addCriterion("point8_turnover <>", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverGreaterThan(String value) {
            addCriterion("point8_turnover >", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point8_turnover >=", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverLessThan(String value) {
            addCriterion("point8_turnover <", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point8_turnover <=", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverLike(String value) {
            addCriterion("point8_turnover like", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverNotLike(String value) {
            addCriterion("point8_turnover not like", value, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverIn(List<String> values) {
            addCriterion("point8_turnover in", values, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverNotIn(List<String> values) {
            addCriterion("point8_turnover not in", values, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverBetween(String value1, String value2) {
            addCriterion("point8_turnover between", value1, value2, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint8TurnoverNotBetween(String value1, String value2) {
            addCriterion("point8_turnover not between", value1, value2, "point8Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9IsNull() {
            addCriterion("point9 is null");
            return (Criteria) this;
        }

        public Criteria andPoint9IsNotNull() {
            addCriterion("point9 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint9EqualTo(String value) {
            addCriterion("point9 =", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9NotEqualTo(String value) {
            addCriterion("point9 <>", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9GreaterThan(String value) {
            addCriterion("point9 >", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9GreaterThanOrEqualTo(String value) {
            addCriterion("point9 >=", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9LessThan(String value) {
            addCriterion("point9 <", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9LessThanOrEqualTo(String value) {
            addCriterion("point9 <=", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9Like(String value) {
            addCriterion("point9 like", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9NotLike(String value) {
            addCriterion("point9 not like", value, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9In(List<String> values) {
            addCriterion("point9 in", values, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9NotIn(List<String> values) {
            addCriterion("point9 not in", values, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9Between(String value1, String value2) {
            addCriterion("point9 between", value1, value2, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9NotBetween(String value1, String value2) {
            addCriterion("point9 not between", value1, value2, "point9");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeIsNull() {
            addCriterion("point9_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeIsNotNull() {
            addCriterion("point9_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeEqualTo(String value) {
            addCriterion("point9_time =", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeNotEqualTo(String value) {
            addCriterion("point9_time <>", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeGreaterThan(String value) {
            addCriterion("point9_time >", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point9_time >=", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeLessThan(String value) {
            addCriterion("point9_time <", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeLessThanOrEqualTo(String value) {
            addCriterion("point9_time <=", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeLike(String value) {
            addCriterion("point9_time like", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeNotLike(String value) {
            addCriterion("point9_time not like", value, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeIn(List<String> values) {
            addCriterion("point9_time in", values, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeNotIn(List<String> values) {
            addCriterion("point9_time not in", values, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeBetween(String value1, String value2) {
            addCriterion("point9_time between", value1, value2, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TimeNotBetween(String value1, String value2) {
            addCriterion("point9_time not between", value1, value2, "point9Time");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverIsNull() {
            addCriterion("point9_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverIsNotNull() {
            addCriterion("point9_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverEqualTo(String value) {
            addCriterion("point9_turnover =", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverNotEqualTo(String value) {
            addCriterion("point9_turnover <>", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverGreaterThan(String value) {
            addCriterion("point9_turnover >", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point9_turnover >=", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverLessThan(String value) {
            addCriterion("point9_turnover <", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point9_turnover <=", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverLike(String value) {
            addCriterion("point9_turnover like", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverNotLike(String value) {
            addCriterion("point9_turnover not like", value, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverIn(List<String> values) {
            addCriterion("point9_turnover in", values, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverNotIn(List<String> values) {
            addCriterion("point9_turnover not in", values, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverBetween(String value1, String value2) {
            addCriterion("point9_turnover between", value1, value2, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint9TurnoverNotBetween(String value1, String value2) {
            addCriterion("point9_turnover not between", value1, value2, "point9Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10IsNull() {
            addCriterion("point10 is null");
            return (Criteria) this;
        }

        public Criteria andPoint10IsNotNull() {
            addCriterion("point10 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint10EqualTo(String value) {
            addCriterion("point10 =", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10NotEqualTo(String value) {
            addCriterion("point10 <>", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10GreaterThan(String value) {
            addCriterion("point10 >", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10GreaterThanOrEqualTo(String value) {
            addCriterion("point10 >=", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10LessThan(String value) {
            addCriterion("point10 <", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10LessThanOrEqualTo(String value) {
            addCriterion("point10 <=", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10Like(String value) {
            addCriterion("point10 like", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10NotLike(String value) {
            addCriterion("point10 not like", value, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10In(List<String> values) {
            addCriterion("point10 in", values, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10NotIn(List<String> values) {
            addCriterion("point10 not in", values, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10Between(String value1, String value2) {
            addCriterion("point10 between", value1, value2, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10NotBetween(String value1, String value2) {
            addCriterion("point10 not between", value1, value2, "point10");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeIsNull() {
            addCriterion("point10_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeIsNotNull() {
            addCriterion("point10_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeEqualTo(String value) {
            addCriterion("point10_time =", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeNotEqualTo(String value) {
            addCriterion("point10_time <>", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeGreaterThan(String value) {
            addCriterion("point10_time >", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point10_time >=", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeLessThan(String value) {
            addCriterion("point10_time <", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeLessThanOrEqualTo(String value) {
            addCriterion("point10_time <=", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeLike(String value) {
            addCriterion("point10_time like", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeNotLike(String value) {
            addCriterion("point10_time not like", value, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeIn(List<String> values) {
            addCriterion("point10_time in", values, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeNotIn(List<String> values) {
            addCriterion("point10_time not in", values, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeBetween(String value1, String value2) {
            addCriterion("point10_time between", value1, value2, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TimeNotBetween(String value1, String value2) {
            addCriterion("point10_time not between", value1, value2, "point10Time");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverIsNull() {
            addCriterion("point10_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverIsNotNull() {
            addCriterion("point10_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverEqualTo(String value) {
            addCriterion("point10_turnover =", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverNotEqualTo(String value) {
            addCriterion("point10_turnover <>", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverGreaterThan(String value) {
            addCriterion("point10_turnover >", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point10_turnover >=", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverLessThan(String value) {
            addCriterion("point10_turnover <", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point10_turnover <=", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverLike(String value) {
            addCriterion("point10_turnover like", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverNotLike(String value) {
            addCriterion("point10_turnover not like", value, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverIn(List<String> values) {
            addCriterion("point10_turnover in", values, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverNotIn(List<String> values) {
            addCriterion("point10_turnover not in", values, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverBetween(String value1, String value2) {
            addCriterion("point10_turnover between", value1, value2, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint10TurnoverNotBetween(String value1, String value2) {
            addCriterion("point10_turnover not between", value1, value2, "point10Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11IsNull() {
            addCriterion("point11 is null");
            return (Criteria) this;
        }

        public Criteria andPoint11IsNotNull() {
            addCriterion("point11 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint11EqualTo(String value) {
            addCriterion("point11 =", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11NotEqualTo(String value) {
            addCriterion("point11 <>", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11GreaterThan(String value) {
            addCriterion("point11 >", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11GreaterThanOrEqualTo(String value) {
            addCriterion("point11 >=", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11LessThan(String value) {
            addCriterion("point11 <", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11LessThanOrEqualTo(String value) {
            addCriterion("point11 <=", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11Like(String value) {
            addCriterion("point11 like", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11NotLike(String value) {
            addCriterion("point11 not like", value, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11In(List<String> values) {
            addCriterion("point11 in", values, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11NotIn(List<String> values) {
            addCriterion("point11 not in", values, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11Between(String value1, String value2) {
            addCriterion("point11 between", value1, value2, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11NotBetween(String value1, String value2) {
            addCriterion("point11 not between", value1, value2, "point11");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeIsNull() {
            addCriterion("point11_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeIsNotNull() {
            addCriterion("point11_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeEqualTo(String value) {
            addCriterion("point11_time =", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeNotEqualTo(String value) {
            addCriterion("point11_time <>", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeGreaterThan(String value) {
            addCriterion("point11_time >", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point11_time >=", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeLessThan(String value) {
            addCriterion("point11_time <", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeLessThanOrEqualTo(String value) {
            addCriterion("point11_time <=", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeLike(String value) {
            addCriterion("point11_time like", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeNotLike(String value) {
            addCriterion("point11_time not like", value, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeIn(List<String> values) {
            addCriterion("point11_time in", values, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeNotIn(List<String> values) {
            addCriterion("point11_time not in", values, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeBetween(String value1, String value2) {
            addCriterion("point11_time between", value1, value2, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TimeNotBetween(String value1, String value2) {
            addCriterion("point11_time not between", value1, value2, "point11Time");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverIsNull() {
            addCriterion("point11_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverIsNotNull() {
            addCriterion("point11_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverEqualTo(String value) {
            addCriterion("point11_turnover =", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverNotEqualTo(String value) {
            addCriterion("point11_turnover <>", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverGreaterThan(String value) {
            addCriterion("point11_turnover >", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point11_turnover >=", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverLessThan(String value) {
            addCriterion("point11_turnover <", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point11_turnover <=", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverLike(String value) {
            addCriterion("point11_turnover like", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverNotLike(String value) {
            addCriterion("point11_turnover not like", value, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverIn(List<String> values) {
            addCriterion("point11_turnover in", values, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverNotIn(List<String> values) {
            addCriterion("point11_turnover not in", values, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverBetween(String value1, String value2) {
            addCriterion("point11_turnover between", value1, value2, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint11TurnoverNotBetween(String value1, String value2) {
            addCriterion("point11_turnover not between", value1, value2, "point11Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12IsNull() {
            addCriterion("point12 is null");
            return (Criteria) this;
        }

        public Criteria andPoint12IsNotNull() {
            addCriterion("point12 is not null");
            return (Criteria) this;
        }

        public Criteria andPoint12EqualTo(String value) {
            addCriterion("point12 =", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12NotEqualTo(String value) {
            addCriterion("point12 <>", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12GreaterThan(String value) {
            addCriterion("point12 >", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12GreaterThanOrEqualTo(String value) {
            addCriterion("point12 >=", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12LessThan(String value) {
            addCriterion("point12 <", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12LessThanOrEqualTo(String value) {
            addCriterion("point12 <=", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12Like(String value) {
            addCriterion("point12 like", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12NotLike(String value) {
            addCriterion("point12 not like", value, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12In(List<String> values) {
            addCriterion("point12 in", values, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12NotIn(List<String> values) {
            addCriterion("point12 not in", values, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12Between(String value1, String value2) {
            addCriterion("point12 between", value1, value2, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12NotBetween(String value1, String value2) {
            addCriterion("point12 not between", value1, value2, "point12");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeIsNull() {
            addCriterion("point12_time is null");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeIsNotNull() {
            addCriterion("point12_time is not null");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeEqualTo(String value) {
            addCriterion("point12_time =", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeNotEqualTo(String value) {
            addCriterion("point12_time <>", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeGreaterThan(String value) {
            addCriterion("point12_time >", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeGreaterThanOrEqualTo(String value) {
            addCriterion("point12_time >=", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeLessThan(String value) {
            addCriterion("point12_time <", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeLessThanOrEqualTo(String value) {
            addCriterion("point12_time <=", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeLike(String value) {
            addCriterion("point12_time like", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeNotLike(String value) {
            addCriterion("point12_time not like", value, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeIn(List<String> values) {
            addCriterion("point12_time in", values, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeNotIn(List<String> values) {
            addCriterion("point12_time not in", values, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeBetween(String value1, String value2) {
            addCriterion("point12_time between", value1, value2, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TimeNotBetween(String value1, String value2) {
            addCriterion("point12_time not between", value1, value2, "point12Time");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverIsNull() {
            addCriterion("point12_turnover is null");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverIsNotNull() {
            addCriterion("point12_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverEqualTo(String value) {
            addCriterion("point12_turnover =", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverNotEqualTo(String value) {
            addCriterion("point12_turnover <>", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverGreaterThan(String value) {
            addCriterion("point12_turnover >", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("point12_turnover >=", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverLessThan(String value) {
            addCriterion("point12_turnover <", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverLessThanOrEqualTo(String value) {
            addCriterion("point12_turnover <=", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverLike(String value) {
            addCriterion("point12_turnover like", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverNotLike(String value) {
            addCriterion("point12_turnover not like", value, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverIn(List<String> values) {
            addCriterion("point12_turnover in", values, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverNotIn(List<String> values) {
            addCriterion("point12_turnover not in", values, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverBetween(String value1, String value2) {
            addCriterion("point12_turnover between", value1, value2, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPoint12TurnoverNotBetween(String value1, String value2) {
            addCriterion("point12_turnover not between", value1, value2, "point12Turnover");
            return (Criteria) this;
        }

        public Criteria andPointNumberIsNull() {
            addCriterion("point_number is null");
            return (Criteria) this;
        }

        public Criteria andPointNumberIsNotNull() {
            addCriterion("point_number is not null");
            return (Criteria) this;
        }

        public Criteria andPointNumberEqualTo(Integer value) {
            addCriterion("point_number =", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotEqualTo(Integer value) {
            addCriterion("point_number <>", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberGreaterThan(Integer value) {
            addCriterion("point_number >", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_number >=", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberLessThan(Integer value) {
            addCriterion("point_number <", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberLessThanOrEqualTo(Integer value) {
            addCriterion("point_number <=", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberIn(List<Integer> values) {
            addCriterion("point_number in", values, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotIn(List<Integer> values) {
            addCriterion("point_number not in", values, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberBetween(Integer value1, Integer value2) {
            addCriterion("point_number between", value1, value2, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("point_number not between", value1, value2, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointSlicerIsNull() {
            addCriterion("point_slicer is null");
            return (Criteria) this;
        }

        public Criteria andPointSlicerIsNotNull() {
            addCriterion("point_slicer is not null");
            return (Criteria) this;
        }

        public Criteria andPointSlicerEqualTo(Integer value) {
            addCriterion("point_slicer =", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerNotEqualTo(Integer value) {
            addCriterion("point_slicer <>", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerGreaterThan(Integer value) {
            addCriterion("point_slicer >", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_slicer >=", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerLessThan(Integer value) {
            addCriterion("point_slicer <", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerLessThanOrEqualTo(Integer value) {
            addCriterion("point_slicer <=", value, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerIn(List<Integer> values) {
            addCriterion("point_slicer in", values, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerNotIn(List<Integer> values) {
            addCriterion("point_slicer not in", values, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerBetween(Integer value1, Integer value2) {
            addCriterion("point_slicer between", value1, value2, "pointSlicer");
            return (Criteria) this;
        }

        public Criteria andPointSlicerNotBetween(Integer value1, Integer value2) {
            addCriterion("point_slicer not between", value1, value2, "pointSlicer");
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