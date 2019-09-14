package com.desheng.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveInfoUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveInfoUserExample() {
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

        public Criteria andLeaveInfoIdIsNull() {
            addCriterion("leave_info_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdIsNotNull() {
            addCriterion("leave_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdEqualTo(Integer value) {
            addCriterion("leave_info_id =", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdNotEqualTo(Integer value) {
            addCriterion("leave_info_id <>", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdGreaterThan(Integer value) {
            addCriterion("leave_info_id >", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_info_id >=", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdLessThan(Integer value) {
            addCriterion("leave_info_id <", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("leave_info_id <=", value, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdIn(List<Integer> values) {
            addCriterion("leave_info_id in", values, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdNotIn(List<Integer> values) {
            addCriterion("leave_info_id not in", values, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("leave_info_id between", value1, value2, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andLeaveInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_info_id not between", value1, value2, "leaveInfoId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSpTimeIsNull() {
            addCriterion("sp_time is null");
            return (Criteria) this;
        }

        public Criteria andSpTimeIsNotNull() {
            addCriterion("sp_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpTimeEqualTo(Date value) {
            addCriterion("sp_time =", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeNotEqualTo(Date value) {
            addCriterion("sp_time <>", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeGreaterThan(Date value) {
            addCriterion("sp_time >", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sp_time >=", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeLessThan(Date value) {
            addCriterion("sp_time <", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeLessThanOrEqualTo(Date value) {
            addCriterion("sp_time <=", value, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeIn(List<Date> values) {
            addCriterion("sp_time in", values, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeNotIn(List<Date> values) {
            addCriterion("sp_time not in", values, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeBetween(Date value1, Date value2) {
            addCriterion("sp_time between", value1, value2, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpTimeNotBetween(Date value1, Date value2) {
            addCriterion("sp_time not between", value1, value2, "spTime");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusIsNull() {
            addCriterion("sp_user_status is null");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusIsNotNull() {
            addCriterion("sp_user_status is not null");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusEqualTo(String value) {
            addCriterion("sp_user_status =", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusNotEqualTo(String value) {
            addCriterion("sp_user_status <>", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusGreaterThan(String value) {
            addCriterion("sp_user_status >", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sp_user_status >=", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusLessThan(String value) {
            addCriterion("sp_user_status <", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusLessThanOrEqualTo(String value) {
            addCriterion("sp_user_status <=", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusLike(String value) {
            addCriterion("sp_user_status like", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusNotLike(String value) {
            addCriterion("sp_user_status not like", value, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusIn(List<String> values) {
            addCriterion("sp_user_status in", values, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusNotIn(List<String> values) {
            addCriterion("sp_user_status not in", values, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusBetween(String value1, String value2) {
            addCriterion("sp_user_status between", value1, value2, "spUserStatus");
            return (Criteria) this;
        }

        public Criteria andSpUserStatusNotBetween(String value1, String value2) {
            addCriterion("sp_user_status not between", value1, value2, "spUserStatus");
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