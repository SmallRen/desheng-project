package com.desheng.pojo;

import java.util.ArrayList;
import java.util.List;

public class WzPointProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzPointProductExample() {
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

        public Criteria andWzPointIdIsNull() {
            addCriterion("wz_point_id is null");
            return (Criteria) this;
        }

        public Criteria andWzPointIdIsNotNull() {
            addCriterion("wz_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andWzPointIdEqualTo(Integer value) {
            addCriterion("wz_point_id =", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdNotEqualTo(Integer value) {
            addCriterion("wz_point_id <>", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdGreaterThan(Integer value) {
            addCriterion("wz_point_id >", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wz_point_id >=", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdLessThan(Integer value) {
            addCriterion("wz_point_id <", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("wz_point_id <=", value, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdIn(List<Integer> values) {
            addCriterion("wz_point_id in", values, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdNotIn(List<Integer> values) {
            addCriterion("wz_point_id not in", values, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdBetween(Integer value1, Integer value2) {
            addCriterion("wz_point_id between", value1, value2, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wz_point_id not between", value1, value2, "wzPointId");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeIsNull() {
            addCriterion("wz_product_scode is null");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeIsNotNull() {
            addCriterion("wz_product_scode is not null");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeEqualTo(Integer value) {
            addCriterion("wz_product_scode =", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeNotEqualTo(Integer value) {
            addCriterion("wz_product_scode <>", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeGreaterThan(Integer value) {
            addCriterion("wz_product_scode >", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wz_product_scode >=", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeLessThan(Integer value) {
            addCriterion("wz_product_scode <", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeLessThanOrEqualTo(Integer value) {
            addCriterion("wz_product_scode <=", value, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeIn(List<Integer> values) {
            addCriterion("wz_product_scode in", values, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeNotIn(List<Integer> values) {
            addCriterion("wz_product_scode not in", values, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeBetween(Integer value1, Integer value2) {
            addCriterion("wz_product_scode between", value1, value2, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andWzProductScodeNotBetween(Integer value1, Integer value2) {
            addCriterion("wz_product_scode not between", value1, value2, "wzProductScode");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Integer value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Integer value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Integer value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Integer value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Integer> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Integer> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
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