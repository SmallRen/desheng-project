package com.desheng.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WzItfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WzItfExample() {
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

        public Criteria andCreateUnitIsNull() {
            addCriterion("create_unit is null");
            return (Criteria) this;
        }

        public Criteria andCreateUnitIsNotNull() {
            addCriterion("create_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUnitEqualTo(String value) {
            addCriterion("create_unit =", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitNotEqualTo(String value) {
            addCriterion("create_unit <>", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitGreaterThan(String value) {
            addCriterion("create_unit >", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitGreaterThanOrEqualTo(String value) {
            addCriterion("create_unit >=", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitLessThan(String value) {
            addCriterion("create_unit <", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitLessThanOrEqualTo(String value) {
            addCriterion("create_unit <=", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitLike(String value) {
            addCriterion("create_unit like", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitNotLike(String value) {
            addCriterion("create_unit not like", value, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitIn(List<String> values) {
            addCriterion("create_unit in", values, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitNotIn(List<String> values) {
            addCriterion("create_unit not in", values, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitBetween(String value1, String value2) {
            addCriterion("create_unit between", value1, value2, "createUnit");
            return (Criteria) this;
        }

        public Criteria andCreateUnitNotBetween(String value1, String value2) {
            addCriterion("create_unit not between", value1, value2, "createUnit");
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

        public Criteria andYwTypeIsNull() {
            addCriterion("yw_type is null");
            return (Criteria) this;
        }

        public Criteria andYwTypeIsNotNull() {
            addCriterion("yw_type is not null");
            return (Criteria) this;
        }

        public Criteria andYwTypeEqualTo(Integer value) {
            addCriterion("yw_type =", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeNotEqualTo(Integer value) {
            addCriterion("yw_type <>", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeGreaterThan(Integer value) {
            addCriterion("yw_type >", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("yw_type >=", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeLessThan(Integer value) {
            addCriterion("yw_type <", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeLessThanOrEqualTo(Integer value) {
            addCriterion("yw_type <=", value, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeIn(List<Integer> values) {
            addCriterion("yw_type in", values, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeNotIn(List<Integer> values) {
            addCriterion("yw_type not in", values, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeBetween(Integer value1, Integer value2) {
            addCriterion("yw_type between", value1, value2, "ywType");
            return (Criteria) this;
        }

        public Criteria andYwTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("yw_type not between", value1, value2, "ywType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeIsNull() {
            addCriterion("ewm_type is null");
            return (Criteria) this;
        }

        public Criteria andEwmTypeIsNotNull() {
            addCriterion("ewm_type is not null");
            return (Criteria) this;
        }

        public Criteria andEwmTypeEqualTo(String value) {
            addCriterion("ewm_type =", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeNotEqualTo(String value) {
            addCriterion("ewm_type <>", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeGreaterThan(String value) {
            addCriterion("ewm_type >", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ewm_type >=", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeLessThan(String value) {
            addCriterion("ewm_type <", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeLessThanOrEqualTo(String value) {
            addCriterion("ewm_type <=", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeLike(String value) {
            addCriterion("ewm_type like", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeNotLike(String value) {
            addCriterion("ewm_type not like", value, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeIn(List<String> values) {
            addCriterion("ewm_type in", values, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeNotIn(List<String> values) {
            addCriterion("ewm_type not in", values, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeBetween(String value1, String value2) {
            addCriterion("ewm_type between", value1, value2, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmTypeNotBetween(String value1, String value2) {
            addCriterion("ewm_type not between", value1, value2, "ewmType");
            return (Criteria) this;
        }

        public Criteria andEwmNumberIsNull() {
            addCriterion("ewm_number is null");
            return (Criteria) this;
        }

        public Criteria andEwmNumberIsNotNull() {
            addCriterion("ewm_number is not null");
            return (Criteria) this;
        }

        public Criteria andEwmNumberEqualTo(Integer value) {
            addCriterion("ewm_number =", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberNotEqualTo(Integer value) {
            addCriterion("ewm_number <>", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberGreaterThan(Integer value) {
            addCriterion("ewm_number >", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ewm_number >=", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberLessThan(Integer value) {
            addCriterion("ewm_number <", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ewm_number <=", value, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberIn(List<Integer> values) {
            addCriterion("ewm_number in", values, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberNotIn(List<Integer> values) {
            addCriterion("ewm_number not in", values, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberBetween(Integer value1, Integer value2) {
            addCriterion("ewm_number between", value1, value2, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andEwmNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ewm_number not between", value1, value2, "ewmNumber");
            return (Criteria) this;
        }

        public Criteria andFhUnitIsNull() {
            addCriterion("fh_unit is null");
            return (Criteria) this;
        }

        public Criteria andFhUnitIsNotNull() {
            addCriterion("fh_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFhUnitEqualTo(String value) {
            addCriterion("fh_unit =", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitNotEqualTo(String value) {
            addCriterion("fh_unit <>", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitGreaterThan(String value) {
            addCriterion("fh_unit >", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitGreaterThanOrEqualTo(String value) {
            addCriterion("fh_unit >=", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitLessThan(String value) {
            addCriterion("fh_unit <", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitLessThanOrEqualTo(String value) {
            addCriterion("fh_unit <=", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitLike(String value) {
            addCriterion("fh_unit like", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitNotLike(String value) {
            addCriterion("fh_unit not like", value, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitIn(List<String> values) {
            addCriterion("fh_unit in", values, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitNotIn(List<String> values) {
            addCriterion("fh_unit not in", values, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitBetween(String value1, String value2) {
            addCriterion("fh_unit between", value1, value2, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andFhUnitNotBetween(String value1, String value2) {
            addCriterion("fh_unit not between", value1, value2, "fhUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitIsNull() {
            addCriterion("sh_unit is null");
            return (Criteria) this;
        }

        public Criteria andShUnitIsNotNull() {
            addCriterion("sh_unit is not null");
            return (Criteria) this;
        }

        public Criteria andShUnitEqualTo(String value) {
            addCriterion("sh_unit =", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitNotEqualTo(String value) {
            addCriterion("sh_unit <>", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitGreaterThan(String value) {
            addCriterion("sh_unit >", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitGreaterThanOrEqualTo(String value) {
            addCriterion("sh_unit >=", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitLessThan(String value) {
            addCriterion("sh_unit <", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitLessThanOrEqualTo(String value) {
            addCriterion("sh_unit <=", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitLike(String value) {
            addCriterion("sh_unit like", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitNotLike(String value) {
            addCriterion("sh_unit not like", value, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitIn(List<String> values) {
            addCriterion("sh_unit in", values, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitNotIn(List<String> values) {
            addCriterion("sh_unit not in", values, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitBetween(String value1, String value2) {
            addCriterion("sh_unit between", value1, value2, "shUnit");
            return (Criteria) this;
        }

        public Criteria andShUnitNotBetween(String value1, String value2) {
            addCriterion("sh_unit not between", value1, value2, "shUnit");
            return (Criteria) this;
        }

        public Criteria andCphIsNull() {
            addCriterion("cph is null");
            return (Criteria) this;
        }

        public Criteria andCphIsNotNull() {
            addCriterion("cph is not null");
            return (Criteria) this;
        }

        public Criteria andCphEqualTo(String value) {
            addCriterion("cph =", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotEqualTo(String value) {
            addCriterion("cph <>", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphGreaterThan(String value) {
            addCriterion("cph >", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphGreaterThanOrEqualTo(String value) {
            addCriterion("cph >=", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLessThan(String value) {
            addCriterion("cph <", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLessThanOrEqualTo(String value) {
            addCriterion("cph <=", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphLike(String value) {
            addCriterion("cph like", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotLike(String value) {
            addCriterion("cph not like", value, "cph");
            return (Criteria) this;
        }

        public Criteria andCphIn(List<String> values) {
            addCriterion("cph in", values, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotIn(List<String> values) {
            addCriterion("cph not in", values, "cph");
            return (Criteria) this;
        }

        public Criteria andCphBetween(String value1, String value2) {
            addCriterion("cph between", value1, value2, "cph");
            return (Criteria) this;
        }

        public Criteria andCphNotBetween(String value1, String value2) {
            addCriterion("cph not between", value1, value2, "cph");
            return (Criteria) this;
        }

        public Criteria andBjTimeIsNull() {
            addCriterion("bj_time is null");
            return (Criteria) this;
        }

        public Criteria andBjTimeIsNotNull() {
            addCriterion("bj_time is not null");
            return (Criteria) this;
        }

        public Criteria andBjTimeEqualTo(String value) {
            addCriterion("bj_time =", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeNotEqualTo(String value) {
            addCriterion("bj_time <>", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeGreaterThan(String value) {
            addCriterion("bj_time >", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeGreaterThanOrEqualTo(String value) {
            addCriterion("bj_time >=", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeLessThan(String value) {
            addCriterion("bj_time <", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeLessThanOrEqualTo(String value) {
            addCriterion("bj_time <=", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeLike(String value) {
            addCriterion("bj_time like", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeNotLike(String value) {
            addCriterion("bj_time not like", value, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeIn(List<String> values) {
            addCriterion("bj_time in", values, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeNotIn(List<String> values) {
            addCriterion("bj_time not in", values, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeBetween(String value1, String value2) {
            addCriterion("bj_time between", value1, value2, "bjTime");
            return (Criteria) this;
        }

        public Criteria andBjTimeNotBetween(String value1, String value2) {
            addCriterion("bj_time not between", value1, value2, "bjTime");
            return (Criteria) this;
        }

        public Criteria andCcDoorIsNull() {
            addCriterion("cc_door is null");
            return (Criteria) this;
        }

        public Criteria andCcDoorIsNotNull() {
            addCriterion("cc_door is not null");
            return (Criteria) this;
        }

        public Criteria andCcDoorEqualTo(String value) {
            addCriterion("cc_door =", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorNotEqualTo(String value) {
            addCriterion("cc_door <>", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorGreaterThan(String value) {
            addCriterion("cc_door >", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorGreaterThanOrEqualTo(String value) {
            addCriterion("cc_door >=", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorLessThan(String value) {
            addCriterion("cc_door <", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorLessThanOrEqualTo(String value) {
            addCriterion("cc_door <=", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorLike(String value) {
            addCriterion("cc_door like", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorNotLike(String value) {
            addCriterion("cc_door not like", value, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorIn(List<String> values) {
            addCriterion("cc_door in", values, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorNotIn(List<String> values) {
            addCriterion("cc_door not in", values, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorBetween(String value1, String value2) {
            addCriterion("cc_door between", value1, value2, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andCcDoorNotBetween(String value1, String value2) {
            addCriterion("cc_door not between", value1, value2, "ccDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorIsNull() {
            addCriterion("jc_door is null");
            return (Criteria) this;
        }

        public Criteria andJcDoorIsNotNull() {
            addCriterion("jc_door is not null");
            return (Criteria) this;
        }

        public Criteria andJcDoorEqualTo(String value) {
            addCriterion("jc_door =", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorNotEqualTo(String value) {
            addCriterion("jc_door <>", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorGreaterThan(String value) {
            addCriterion("jc_door >", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorGreaterThanOrEqualTo(String value) {
            addCriterion("jc_door >=", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorLessThan(String value) {
            addCriterion("jc_door <", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorLessThanOrEqualTo(String value) {
            addCriterion("jc_door <=", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorLike(String value) {
            addCriterion("jc_door like", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorNotLike(String value) {
            addCriterion("jc_door not like", value, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorIn(List<String> values) {
            addCriterion("jc_door in", values, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorNotIn(List<String> values) {
            addCriterion("jc_door not in", values, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorBetween(String value1, String value2) {
            addCriterion("jc_door between", value1, value2, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andJcDoorNotBetween(String value1, String value2) {
            addCriterion("jc_door not between", value1, value2, "jcDoor");
            return (Criteria) this;
        }

        public Criteria andWorklineSysIsNull() {
            addCriterion("workline_sys is null");
            return (Criteria) this;
        }

        public Criteria andWorklineSysIsNotNull() {
            addCriterion("workline_sys is not null");
            return (Criteria) this;
        }

        public Criteria andWorklineSysEqualTo(String value) {
            addCriterion("workline_sys =", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysNotEqualTo(String value) {
            addCriterion("workline_sys <>", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysGreaterThan(String value) {
            addCriterion("workline_sys >", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysGreaterThanOrEqualTo(String value) {
            addCriterion("workline_sys >=", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysLessThan(String value) {
            addCriterion("workline_sys <", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysLessThanOrEqualTo(String value) {
            addCriterion("workline_sys <=", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysLike(String value) {
            addCriterion("workline_sys like", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysNotLike(String value) {
            addCriterion("workline_sys not like", value, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysIn(List<String> values) {
            addCriterion("workline_sys in", values, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysNotIn(List<String> values) {
            addCriterion("workline_sys not in", values, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysBetween(String value1, String value2) {
            addCriterion("workline_sys between", value1, value2, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklineSysNotBetween(String value1, String value2) {
            addCriterion("workline_sys not between", value1, value2, "worklineSys");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonIsNull() {
            addCriterion("workline_person is null");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonIsNotNull() {
            addCriterion("workline_person is not null");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonEqualTo(String value) {
            addCriterion("workline_person =", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonNotEqualTo(String value) {
            addCriterion("workline_person <>", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonGreaterThan(String value) {
            addCriterion("workline_person >", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonGreaterThanOrEqualTo(String value) {
            addCriterion("workline_person >=", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonLessThan(String value) {
            addCriterion("workline_person <", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonLessThanOrEqualTo(String value) {
            addCriterion("workline_person <=", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonLike(String value) {
            addCriterion("workline_person like", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonNotLike(String value) {
            addCriterion("workline_person not like", value, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonIn(List<String> values) {
            addCriterion("workline_person in", values, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonNotIn(List<String> values) {
            addCriterion("workline_person not in", values, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonBetween(String value1, String value2) {
            addCriterion("workline_person between", value1, value2, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andWorklinePersonNotBetween(String value1, String value2) {
            addCriterion("workline_person not between", value1, value2, "worklinePerson");
            return (Criteria) this;
        }

        public Criteria andCreateTiemIsNull() {
            addCriterion("create_tiem is null");
            return (Criteria) this;
        }

        public Criteria andCreateTiemIsNotNull() {
            addCriterion("create_tiem is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTiemEqualTo(Date value) {
            addCriterion("create_tiem =", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemNotEqualTo(Date value) {
            addCriterion("create_tiem <>", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemGreaterThan(Date value) {
            addCriterion("create_tiem >", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemGreaterThanOrEqualTo(Date value) {
            addCriterion("create_tiem >=", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemLessThan(Date value) {
            addCriterion("create_tiem <", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemLessThanOrEqualTo(Date value) {
            addCriterion("create_tiem <=", value, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemIn(List<Date> values) {
            addCriterion("create_tiem in", values, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemNotIn(List<Date> values) {
            addCriterion("create_tiem not in", values, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemBetween(Date value1, Date value2) {
            addCriterion("create_tiem between", value1, value2, "createTiem");
            return (Criteria) this;
        }

        public Criteria andCreateTiemNotBetween(Date value1, Date value2) {
            addCriterion("create_tiem not between", value1, value2, "createTiem");
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

        public Criteria andGdStatusIsNull() {
            addCriterion("gd_status is null");
            return (Criteria) this;
        }

        public Criteria andGdStatusIsNotNull() {
            addCriterion("gd_status is not null");
            return (Criteria) this;
        }

        public Criteria andGdStatusEqualTo(Integer value) {
            addCriterion("gd_status =", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusNotEqualTo(Integer value) {
            addCriterion("gd_status <>", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusGreaterThan(Integer value) {
            addCriterion("gd_status >", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("gd_status >=", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusLessThan(Integer value) {
            addCriterion("gd_status <", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusLessThanOrEqualTo(Integer value) {
            addCriterion("gd_status <=", value, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusIn(List<Integer> values) {
            addCriterion("gd_status in", values, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusNotIn(List<Integer> values) {
            addCriterion("gd_status not in", values, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusBetween(Integer value1, Integer value2) {
            addCriterion("gd_status between", value1, value2, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("gd_status not between", value1, value2, "gdStatus");
            return (Criteria) this;
        }

        public Criteria andGdMarkIsNull() {
            addCriterion("gd_mark is null");
            return (Criteria) this;
        }

        public Criteria andGdMarkIsNotNull() {
            addCriterion("gd_mark is not null");
            return (Criteria) this;
        }

        public Criteria andGdMarkEqualTo(String value) {
            addCriterion("gd_mark =", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkNotEqualTo(String value) {
            addCriterion("gd_mark <>", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkGreaterThan(String value) {
            addCriterion("gd_mark >", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkGreaterThanOrEqualTo(String value) {
            addCriterion("gd_mark >=", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkLessThan(String value) {
            addCriterion("gd_mark <", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkLessThanOrEqualTo(String value) {
            addCriterion("gd_mark <=", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkLike(String value) {
            addCriterion("gd_mark like", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkNotLike(String value) {
            addCriterion("gd_mark not like", value, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkIn(List<String> values) {
            addCriterion("gd_mark in", values, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkNotIn(List<String> values) {
            addCriterion("gd_mark not in", values, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkBetween(String value1, String value2) {
            addCriterion("gd_mark between", value1, value2, "gdMark");
            return (Criteria) this;
        }

        public Criteria andGdMarkNotBetween(String value1, String value2) {
            addCriterion("gd_mark not between", value1, value2, "gdMark");
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