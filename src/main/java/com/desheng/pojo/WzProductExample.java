package com.desheng.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WzProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzProductExample() {
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

        public Criteria andWzScodeIsNull() {
            addCriterion("wc_scode is null");
            return (Criteria) this;
        }

        public Criteria andWzScodeIsNotNull() {
            addCriterion("wc_scode is not null");
            return (Criteria) this;
        }

        public Criteria andWzScodeEqualTo(String value) {
            addCriterion("wc_scode =", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotEqualTo(String value) {
            addCriterion("wc_scode <>", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeGreaterThan(String value) {
            addCriterion("wc_scode >", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeGreaterThanOrEqualTo(String value) {
            addCriterion("wc_scode >=", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLessThan(String value) {
            addCriterion("wc_scode <", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLessThanOrEqualTo(String value) {
            addCriterion("wc_scode <=", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeLike(String value) {
            addCriterion("wc_scode like", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotLike(String value) {
            addCriterion("wc_scode not like", value, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeIn(List<String> values) {
            addCriterion("wc_scode in", values, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotIn(List<String> values) {
            addCriterion("wc_scode not in", values, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeBetween(String value1, String value2) {
            addCriterion("wc_scode between", value1, value2, "wzScode");
            return (Criteria) this;
        }

        public Criteria andWzScodeNotBetween(String value1, String value2) {
            addCriterion("wc_scode not between", value1, value2, "wzScode");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNull() {
            addCriterion("update_person is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNotNull() {
            addCriterion("update_person is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonEqualTo(String value) {
            addCriterion("update_person =", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotEqualTo(String value) {
            addCriterion("update_person <>", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThan(String value) {
            addCriterion("update_person >", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("update_person >=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThan(String value) {
            addCriterion("update_person <", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThanOrEqualTo(String value) {
            addCriterion("update_person <=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLike(String value) {
            addCriterion("update_person like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotLike(String value) {
            addCriterion("update_person not like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIn(List<String> values) {
            addCriterion("update_person in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotIn(List<String> values) {
            addCriterion("update_person not in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonBetween(String value1, String value2) {
            addCriterion("update_person between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotBetween(String value1, String value2) {
            addCriterion("update_person not between", value1, value2, "updatePerson");
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