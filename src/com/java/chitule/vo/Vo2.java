package chitule.vo;

import lombok.Data;

// http://www.njztc.com/emc_taskwork_list.jspx?count=6
// http://www.njztc.com/ajax_taskwork_list.jspx

@Data
public class Vo2 {

    private String address;// 作业地点
    private String beginTime;// 作业开始时间
    private String endTime;// 作业结束时间

    private String person;
    private String telPhone;
    private String news;// 作业方式
    private String works;// 大麦、玉米....

    private String scale;// 规模
    private String unitPrice;// 单价

}
