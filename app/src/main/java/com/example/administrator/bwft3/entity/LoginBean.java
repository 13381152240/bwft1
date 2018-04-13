package com.example.administrator.bwft3.entity;

/**
 * Created by Administrator on 2018/4/12.
 */

public class LoginBean {
    /**
     * status : 1
     * msg : 登录成功！
     * result : {"user_id":"28","user_type1":"0","user_type2":"0","user_type3":"0","user_type4":"0","type":"0","dlqy":"","email":"","password":"","re_password":"","pay_password":null,"sex":"0","birthday":"","address_id":"0","reg_time":"1523520693","last_login":"0","last_ip":"","qq":"","mobile":"17600769828","mobile_validated":"0","oauth":"","openid":null,"head_pic":null,"idcode_name":"","idcode":"","province":"0","city":"0","district":"0","email_validated":"0","nickname":"17600769828","is_lock":"0","first_leader":"3","second_leader":"2","third_leader":"1","token":"","real_name":"","top_id":"0","code":null,"url":null,"is_black":"0","address":"","tuijian":"13700000000","fxid":"","status":"0","industry":"0","status1":"0","is_ren":"0","is_shi":"0","is_you":"0","is_pin":"0","gyjj":"0.00","member_level":"1","levels":"1","s_token":"0","status2":"0","status3":"0","member_level_time":"0","file1":"","file2":"","file3":"","real_status":"0","agent_id":"0","agent_username":""}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * user_id : 28
         * user_type1 : 0
         * user_type2 : 0
         * user_type3 : 0
         * user_type4 : 0
         * type : 0
         * dlqy :
         * email :
         * password :
         * re_password :
         * pay_password : null
         * sex : 0
         * birthday :
         * address_id : 0
         * reg_time : 1523520693
         * last_login : 0
         * last_ip :
         * qq :
         * mobile : 17600769828
         * mobile_validated : 0
         * oauth :
         * openid : null
         * head_pic : null
         * idcode_name :
         * idcode :
         * province : 0
         * city : 0
         * district : 0
         * email_validated : 0
         * nickname : 17600769828
         * is_lock : 0
         * first_leader : 3
         * second_leader : 2
         * third_leader : 1
         * token :
         * real_name :
         * top_id : 0
         * code : null
         * url : null
         * is_black : 0
         * address :
         * tuijian : 13700000000
         * fxid :
         * status : 0
         * industry : 0
         * status1 : 0
         * is_ren : 0
         * is_shi : 0
         * is_you : 0
         * is_pin : 0
         * gyjj : 0.00
         * member_level : 1
         * levels : 1
         * s_token : 0
         * status2 : 0
         * status3 : 0
         * member_level_time : 0
         * file1 :
         * file2 :
         * file3 :
         * real_status : 0
         * agent_id : 0
         * agent_username :
         */

        private String user_id;
        private String user_type1;
        private String user_type2;
        private String user_type3;
        private String user_type4;
        private String type;
        private String dlqy;
        private String email;
        private String password;
        private String re_password;
        private Object pay_password;
        private String sex;
        private String birthday;
        private String address_id;
        private String reg_time;
        private String last_login;
        private String last_ip;
        private String qq;
        private String mobile;
        private String mobile_validated;
        private String oauth;
        private Object openid;
        private Object head_pic;
        private String idcode_name;
        private String idcode;
        private String province;
        private String city;
        private String district;
        private String email_validated;
        private String nickname;
        private String is_lock;
        private String first_leader;
        private String second_leader;
        private String third_leader;
        private String token;
        private String real_name;
        private String top_id;
        private Object code;
        private Object url;
        private String is_black;
        private String address;
        private String tuijian;
        private String fxid;
        private String status;
        private String industry;
        private String status1;
        private String is_ren;
        private String is_shi;
        private String is_you;
        private String is_pin;
        private String gyjj;
        private String member_level;
        private String levels;
        private String s_token;
        private String status2;
        private String status3;
        private String member_level_time;
        private String file1;
        private String file2;
        private String file3;
        private String real_status;
        private String agent_id;
        private String agent_username;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_type1() {
            return user_type1;
        }

        public void setUser_type1(String user_type1) {
            this.user_type1 = user_type1;
        }

        public String getUser_type2() {
            return user_type2;
        }

        public void setUser_type2(String user_type2) {
            this.user_type2 = user_type2;
        }

        public String getUser_type3() {
            return user_type3;
        }

        public void setUser_type3(String user_type3) {
            this.user_type3 = user_type3;
        }

        public String getUser_type4() {
            return user_type4;
        }

        public void setUser_type4(String user_type4) {
            this.user_type4 = user_type4;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDlqy() {
            return dlqy;
        }

        public void setDlqy(String dlqy) {
            this.dlqy = dlqy;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRe_password() {
            return re_password;
        }

        public void setRe_password(String re_password) {
            this.re_password = re_password;
        }

        public Object getPay_password() {
            return pay_password;
        }

        public void setPay_password(Object pay_password) {
            this.pay_password = pay_password;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getLast_login() {
            return last_login;
        }

        public void setLast_login(String last_login) {
            this.last_login = last_login;
        }

        public String getLast_ip() {
            return last_ip;
        }

        public void setLast_ip(String last_ip) {
            this.last_ip = last_ip;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMobile_validated() {
            return mobile_validated;
        }

        public void setMobile_validated(String mobile_validated) {
            this.mobile_validated = mobile_validated;
        }

        public String getOauth() {
            return oauth;
        }

        public void setOauth(String oauth) {
            this.oauth = oauth;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public Object getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(Object head_pic) {
            this.head_pic = head_pic;
        }

        public String getIdcode_name() {
            return idcode_name;
        }

        public void setIdcode_name(String idcode_name) {
            this.idcode_name = idcode_name;
        }

        public String getIdcode() {
            return idcode;
        }

        public void setIdcode(String idcode) {
            this.idcode = idcode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getEmail_validated() {
            return email_validated;
        }

        public void setEmail_validated(String email_validated) {
            this.email_validated = email_validated;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getIs_lock() {
            return is_lock;
        }

        public void setIs_lock(String is_lock) {
            this.is_lock = is_lock;
        }

        public String getFirst_leader() {
            return first_leader;
        }

        public void setFirst_leader(String first_leader) {
            this.first_leader = first_leader;
        }

        public String getSecond_leader() {
            return second_leader;
        }

        public void setSecond_leader(String second_leader) {
            this.second_leader = second_leader;
        }

        public String getThird_leader() {
            return third_leader;
        }

        public void setThird_leader(String third_leader) {
            this.third_leader = third_leader;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getTop_id() {
            return top_id;
        }

        public void setTop_id(String top_id) {
            this.top_id = top_id;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }

        public String getIs_black() {
            return is_black;
        }

        public void setIs_black(String is_black) {
            this.is_black = is_black;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTuijian() {
            return tuijian;
        }

        public void setTuijian(String tuijian) {
            this.tuijian = tuijian;
        }

        public String getFxid() {
            return fxid;
        }

        public void setFxid(String fxid) {
            this.fxid = fxid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIndustry() {
            return industry;
        }

        public void setIndustry(String industry) {
            this.industry = industry;
        }

        public String getStatus1() {
            return status1;
        }

        public void setStatus1(String status1) {
            this.status1 = status1;
        }

        public String getIs_ren() {
            return is_ren;
        }

        public void setIs_ren(String is_ren) {
            this.is_ren = is_ren;
        }

        public String getIs_shi() {
            return is_shi;
        }

        public void setIs_shi(String is_shi) {
            this.is_shi = is_shi;
        }

        public String getIs_you() {
            return is_you;
        }

        public void setIs_you(String is_you) {
            this.is_you = is_you;
        }

        public String getIs_pin() {
            return is_pin;
        }

        public void setIs_pin(String is_pin) {
            this.is_pin = is_pin;
        }

        public String getGyjj() {
            return gyjj;
        }

        public void setGyjj(String gyjj) {
            this.gyjj = gyjj;
        }

        public String getMember_level() {
            return member_level;
        }

        public void setMember_level(String member_level) {
            this.member_level = member_level;
        }

        public String getLevels() {
            return levels;
        }

        public void setLevels(String levels) {
            this.levels = levels;
        }

        public String getS_token() {
            return s_token;
        }

        public void setS_token(String s_token) {
            this.s_token = s_token;
        }

        public String getStatus2() {
            return status2;
        }

        public void setStatus2(String status2) {
            this.status2 = status2;
        }

        public String getStatus3() {
            return status3;
        }

        public void setStatus3(String status3) {
            this.status3 = status3;
        }

        public String getMember_level_time() {
            return member_level_time;
        }

        public void setMember_level_time(String member_level_time) {
            this.member_level_time = member_level_time;
        }

        public String getFile1() {
            return file1;
        }

        public void setFile1(String file1) {
            this.file1 = file1;
        }

        public String getFile2() {
            return file2;
        }

        public void setFile2(String file2) {
            this.file2 = file2;
        }

        public String getFile3() {
            return file3;
        }

        public void setFile3(String file3) {
            this.file3 = file3;
        }

        public String getReal_status() {
            return real_status;
        }

        public void setReal_status(String real_status) {
            this.real_status = real_status;
        }

        public String getAgent_id() {
            return agent_id;
        }

        public void setAgent_id(String agent_id) {
            this.agent_id = agent_id;
        }

        public String getAgent_username() {
            return agent_username;
        }

        public void setAgent_username(String agent_username) {
            this.agent_username = agent_username;
        }
    }
}
