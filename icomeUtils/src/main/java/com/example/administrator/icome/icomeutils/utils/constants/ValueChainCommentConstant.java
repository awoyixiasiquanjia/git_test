package com.example.administrator.icome.icomeutils.utils.constants;

import com.example.administrator.icome.icomeutils.utils.bean.PersonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caozhuangzhuang
 * @email 1063841764@qq.com
 * @create 2019/11/23 14:30
 * @Describe 创值链评论
 */
public class ValueChainCommentConstant {

    public static String evaRecordId;//创值记录id
    public static List<PersonBean> personList = new ArrayList<>();//@人信息
    public static boolean showCommentBar;//是否显示底部评论框,因列表无法传参，置为静态
    public static final String VALUE_CHAIN_PUBLISH_COMMENT="PublishComment"; //创建评论

    public static void clearData(){
        showCommentBar = false;
    }
}
