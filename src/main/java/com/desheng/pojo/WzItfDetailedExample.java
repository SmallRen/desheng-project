package com.desheng.pojo;

import java.util.ArrayList;
import java.util.List;

public class WzItfDetailedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzItfDetailedExample() {
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

        public Criteria andWzNameIsNull() {
            addCriterion("wz_name is null");
            return (Criteria) this;
        }

        public Criteria andWzNameIsNotNull() {
            addCriterion("wz_name is not null");
            return (Criteria) this;
        }

        public Criteria andWzNameEqualTo(String value) {
            addCriterion("wz_name =", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameNotEqualTo(String value) {
            addCriterion("wz_name <>", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameGreaterThan(String value) {
            addCriterion("wz_name >", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameGreaterThanOrEqualTo(String value) {
            addCriterion("wz_name >=", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameLessThan(String value) {
            addCriterion("wz_name <", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameLessThanOrEqualTo(String value) {
            addCriterion("wz_name <=", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameLike(String value) {
            addCriterion("wz_name like", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameNotLike(String value) {
            addCriterion("wz_name not like", value, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameIn(List<String> values) {
            addCriterion("wz_name in", values, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameNotIn(List<String> values) {
            addCriterion("wz_name not in", values, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameBetween(String value1, String value2) {
            addCriterion("wz_name between", value1, value2, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNameNotBetween(String value1, String value2) {
            addCriterion("wz_name not between", value1, value2, "wzName");
            return (Criteria) this;
        }

        public Criteria andWzNumberIsNull() {
            addCriterion("wz_number is null");
            return (Criteria) this;
        }

        public Criteria andWzNumberIsNotNull() {
            addCriterion("wz_number is not null");
            return (Criteria) this;
        }

        public Criteria andWzNumberEqualTo(String value) {
            addCriterion("wz_number =", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberNotEqualTo(String value) {
            addCriterion("wz_number <>", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberGreaterThan(String value) {
            addCriterion("wz_number >", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberGreaterThanOrEqualTo(String value) {
            addCriterion("wz_number >=", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberLessThan(String value) {
            addCriterion("wz_number <", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberLessThanOrEqualTo(String value) {
            addCriterion("wz_number <=", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberLike(String value) {
            addCriterion("wz_number like", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberNotLike(String value) {
            addCriterion("wz_number not like", value, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberIn(List<String> values) {
            addCriterion("wz_number in", values, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberNotIn(List<String> values) {
            addCriterion("wz_number not in", values, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberBetween(String value1, String value2) {
            addCriterion("wz_number between", value1, value2, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzNumberNotBetween(String value1, String value2) {
            addCriterion("wz_number not between", value1, value2, "wzNumber");
            return (Criteria) this;
        }

        public Criteria andWzSspceIsNull() {
            addCriterion("wz_sspce is null");
            return (Criteria) this;
        }

        public Criteria andWzSspceIsNotNull() {
            addCriterion("wz_sspce is not null");
            return (Criteria) this;
        }

        public Criteria andWzSspceEqualTo(String value) {
            addCriterion("wz_sspce =", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceNotEqualTo(String value) {
            addCriterion("wz_sspce <>", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceGreaterThan(String value) {
            addCriterion("wz_sspce >", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceGreaterThanOrEqualTo(String value) {
            addCriterion("wz_sspce >=", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceLessThan(String value) {
            addCriterion("wz_sspce <", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceLessThanOrEqualTo(String value) {
            addCriterion("wz_sspce <=", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceLike(String value) {
            addCriterion("wz_sspce like", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceNotLike(String value) {
            addCriterion("wz_sspce not like", value, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceIn(List<String> values) {
            addCriterion("wz_sspce in", values, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceNotIn(List<String> values) {
            addCriterion("wz_sspce not in", values, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceBetween(String value1, String value2) {
            addCriterion("wz_sspce between", value1, value2, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzSspceNotBetween(String value1, String value2) {
            addCriterion("wz_sspce not between", value1, value2, "wzSspce");
            return (Criteria) this;
        }

        public Criteria andWzScodeIsNull() {
            addCriterion("wz_scode is null");
            return (Criteria) this;
        }

        public Criteria andWzScodeIsNotNull() {
            addCriterion("wz_scode is not null");
            return (Criteria) this;
        }

        public Criteria andWzScodeEqualTo(String value) {
            addCriterion("wz_scode =", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotEqualTo(String value) {
            addCriterion("wz_scode <>", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeGreaterThan(String value) {
            addCriterion("wz_scode >", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeGreaterThanOrEqualTo(String value) {
            addCriterion("wz_scode >=", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLessThan(String value) {
            addCriterion("wz_scode <", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLessThanOrEqualTo(String value) {
            addCriterion("wz_scode <=", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLike(String value) {
            addCriterion("wz_scode like", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotLike(String value) {
            addCriterion("wz_scode not like", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeIn(List<String> values) {
            addCriterion("wz_scode in", values, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotIn(List<String> values) {
            addCriterion("wz_scode not in", values, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeBetween(String value1, String value2) {
            addCriterion("wz_scode between", value1, value2, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotBetween(String value1, String value2) {
            addCriterion("wz_scode not between", value1, value2, "wzScode");
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