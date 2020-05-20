package com.example.administrator.icome.icomeutils.utils;

/**
 * 网络请求路径
 */
public class AddressConst {
    //登录
    public static final String ICOME_LOGIN = "common/user/loginWithSig";
    //获取用户信息
    public static final String ICOME_GET_USER_INFO = "common/user/query/loginUser";
    //获取orgPath
    public static final String ICOME_GET_ORG_PATH = "common/user/query/orgTree";
    //退出登录
    public static final String ICOME_LOGOUT = "common/user/logOut";
    //获取标签
    public static final String ICOME_CUSTOMER_GET_TAG = "customer/lable/labelGroup/list";
    //客户动态-客户资讯分页查询
    public static final String ICOME_CUSTOMER_DYNAMIC_CYZC = "customer/dynamic/industrialpolicy";
    //客户动态-商机情报分页查询
    public static final String ICOME_CUSTOMER_DYNAMIC_SJTJ = "customer/dynamic/opportunitiesrecommend";
    //线索池列表(改版后的客户：此接口用于客户主页面 客户声音和线索推荐)
    public static final String ICOME_CUSTOMER_CLUELIST = "customer/customerDynamic/clueList";
    //得到客户关注领域和关注地域列表
    public static final String ICOME_FIELDREGIONALLIST = "customer/attentions/fieldregionallist";
    //修改用户关注的领域和地域
    public static final String ICOME_ATTENTIONS = "customer/attentions/";
    //启信宝对接 -搜索
    public static final String ICOME_GETSEARCHURL = "customer/qixin/getSearchUrl";
    //痛点标签
    public static final String ICOME_PAINAG = "customer/lable/labelGroup/list";
    //我的关注
    public static final String ICOME_MY_FOCUS = "customer/myfollow/listContent";
    //系统已有用户
    public static final String ICOME_EXITING_USER = "customer/customerinfo/searchCustomers";
    //根据customerCode和userId添加关注
    public static final String ICOME_FOLLOW_USER = "customer/myfollow/follow";
    //根据customerCode和userId取消关注
    public static final String ICOME_UNFOLLOW_USER = "customer/myfollow/unFollow";
    //根据customerCode和userId查询是否已关注
    public static final String ICOME_FOLLOW_ISFOLLOWED = "customer/myfollow/isFollowed";
    //关注已有用户
    public static final String ICOME_ADD_FOCUS_USER = "customer/myfollow/add";
    //取消关注已有用户
    public static final String ICOME_CANCLE_FOCUS_USER = "customer/myfollow/cancel";

    //查询当前用户是否在该客户创值群组中
    public static final String ICOME_EVAGROUP_EXISTINCUSTGROUP = "customer/evagroup/existincustgroup";
    //创建创值团队
    public static final String ICOME_CREATE_GROUP = "customer/evagroup/add";
    //可见范围列表
    public static final String ICOME_CUSTOMER_VISIABLE_LIST = "customer/clueVisiblePerson/getVisiblePersons";

    //增加可见人
    public static final String ICOME_CUSTOMER_ADD_VISIABLE = "customer/clueVisiblePerson/insert";
    //评论列表
    public static final String ICOME_CUSTOMER_COMMENT_LIST = "customer/comment/list";

    //取消可见
    public static final String ICOME_CUSTOMER_CANCLE_VISIABLE = "customer/clueVisiblePerson/update/cancelVisible";

    //申请获取线索
    public static final String ICOME_CUSTOMER_CLIENT_INFO = "customer/cluenoticer/apply";

    //腾讯添加好友
    public static final String ICOME_CUSTOMER_TECENT_ADD_FRIEND = "tim/tencentImSns/friend_add";

    //添加点赞
    public static final String ICOME_CUSTOMER_PRAISE_ADD = "customer/praise/add";

    //82-关注系统已有客户
    public static final String ICOME_CUSTOMER_MYFOLLOW_ADD = "customer/myfollow/add";

    //87-取消关注
    public static final String ICOME_CUSTOMER_MYFOLLOW_CANCEL = "customer/myfollow/cancel";

    //03-添加评论
    public static final String ICOME_CUSTOMER_COMMENT_ADD = "customer/comment/add";

    //96-获取客户动态是否已点赞和关注
    public static final String ICOME_CUSTOMER_DYNAMIC_FOLLOWPRAISE = "customer/dynamic/followPraise";

    //获取客户详情
    public static final String ICOME_CUSTOMER_CUSTOMER = "customer/customerinfo/getdetailinfobyid";
    //97-是否存在新的@我的消息
    public static final String ICOME_CUSTOMER_HASNEWREMINDMESSAGE = "customer/myfollow/hasNewRemindMessage";
    //99-显示热搜记录
    public static final String ICOME_CUSTOMER_GETHOTKEYWORDLISTE = "customer/search/getHotKeyWordList";
    //100-删除客户声音
    public static final String ICOME_CUSTOMER_CUSTPAINPOINT_DELETE = "customer/custpainpoint/delete";
    //101-删除客户
    public static final String ICOME_CUSTOMER_CUSTOMERINFO_DELETE = "customer/customerinfo/delete";

    //app新增提问接口
    public static final String ICOME_QUESTION_ADDQUESTION = "knowledge/question/addQuestion";

    //列表取消关注
    public static final String ICOME_CUSTOMER_CANCLE_FOLLOW = "customer/myfollow/cancelByFollowId";

    //98-添加搜索记录
    public static final String ICOME_CUSTOMER_ADDKEYWORD = "customer/search/addKeyWord";

    //添加手势密码
    public static final String ICOME_ADD_GESTURE = "common/gesture/add";
    //手势密码登录
    public static final String ICOME_GESTURE_LOGIN = "common/gesture/login";

    //手势忘记密码，输入密码验证
    public static final String ICOME_LOGIN_WITHOUT_SIG = "usercenter/user/login";

    //更新手势密码
    public static final String ICOME_UPDATA_GESTURE = "common/gesture/update";

    //获取邀请卡片信息
    public static final String ICOME_IMCART_DATA = "team/team/query/heropost";

    //获取机会群申请竞标卡片信息
    public static final String ICOME_CHANCE_IMINFO = "career/biz/query/applycard";

    //事业机会申请反馈
    public static final String ICOME_APPLY_FEEDBACK = "career/biz/modify/bidder/list/approve";

    //获取 Ticket
    public static final String ICOME_GET_TICKET = "common/user/query/ticket";

    //查询关注人历史列表
    public static final String ICOME_WATCH_MENLIST = "schedule/task/query/taskDetail";

    //查询评审卡片接口
    public static final String ICOME_START_REVIEWCARD = "career/reviewMeeting/query/startReviewCard";

    //决策卡片查询接口
    public static final String ICOME_RESOVE_DETAIL = "career/resolveMeeting/im/detail";

    //更新分享状态
    public static final String ICOME_REVIEWMEETING_UPDATE = "career/reviewMeeting/updateShareFlagByReviewTargetId";

    //获取会话消息列表
    public static final String ICOME_NEWIM_LOAD_MESSAGE = "tim/immessage/load_message";

    //进去时唤起机器人
    public static final String ICOME_NEWIM_AROUSE_ROBOT = "tim/robot/sendUserInfoToRobot";

    //回传给机器人的信息
    public static final String ICOME_NEWIM_BACK_ROBOT = "tim/robot/postBackSelectedInfo";

    //查询当前页卡片的状态
    public static final String ICOME_NEWIM_QRYSTATUS_ROBOT = "tim/robot/qryBtnsStatus";

    //获取拜访记录
    public static final String ICOME_GET_VISITING_RECORD = "customer/visit/query/pagelist";

    //获取拜访记录
    public static final String ICOME_GET_VISITING_DELETE = "customer/visit/delete";

    //104-根据客户ID获取客户名称、拜访对象、拜访方式和原因
    public static final String ICOME_CUSTOMER_GETVISITCONTACTS = "customer/visit/getVisitRecordInterfix";

    //根据客户名称关键字搜索启信宝客户列表
    public static final String ICOME_CUSTOMER_SEARCH_LIST= "customer/qixin/enterprise/searchList";

    //51-新增拜访记录
    public static final String ICOME_CUSTOMER_VISIT_ADD = "customer/visit/add";

    //51-拜访记录详情
    public static final String ICOME_CUSTOMER_VISIT_DETAIL = "/customer/visit/query";

    //查询热门话题列表
    public static final String ICOME_HOT_DYNAMIC_TOPIC = "dynamic/dynamicTopic/getHotDynamicTopicList";
    //
    public static final String ICOME_DYNAMIC_TOPIC = "dynamic/dynamicTopic/getDynamicTopicListByTopicName";

    //获取手势密码状态
    public static final String ICOME_CLIENT_GET_GESTURE_STATUS = "common/gesture/v2/getStatus";

    //创建群组
    public static final String ICOME_TENCENTIMGROUP = "tim/tencentImGroup/create_group";

    //新增群成员
    public static final String ICOME_TENCENADDGROUP_MEMBER = "tim/tencentImGroup/add_group_member";
    //取消关注痛点
    public static final String ICOME_CANCLE_PAINT = "customer/myfollow/cancel";
    //删除痛点
    public static final String ICOME_DELETE_PAINT = "customer/custpainpoint/delete";
    //创值链发送产品到工作台
    public static final String ICOME_VALUE_CHAIN_PUSH_NOTE_SEND= "eva/system/push-note/send";

    //获取创值链产品链接
    public static final String ICOME_VALUE_CHAIN_PRODUCT_URL= "eva/system/product/url";

    //个人信息
    public static final String ICOME_PERSON_INFO = "label/empinfo/get/userinfo";
    //新版我的页面
    public static final String ICOME_MYHOMEINFO= "label/empinfo/get/myhomeinfo";
    //IM获取表情列表
    public static final String ICOME_IM_PICTURELIST_URL= "tim/emoji/list";



    //个人中心添加关注
    public static final String ICOME_ADDFOCUS= "dynamic/concern/addOrCancelConcern";
    //我的成长
    public static final String ICOME_MYGROWHT= "label/mygrowth/query";
    //我的成长等级详情
    public static final String ICOME_MYGROWHT_ROLELEVEL= "label/mygrowth/query/rolelevel";
    //隐私设置查询
    public static final String ICOME_QUERY_PRIVACYSETTINGS= "label/empinfo/query/privacySettings";
    //隐私设置查询
    public static final String ICOME_QUERY_PRIVACYSETTINGS_v2= "label/empinfo/query/privacySettings/v2";
    //隐私设置保存
    public static final String ICOME_UPDATE_PRIVACYSETTING= "label/empinfo/update/privacySetting";
    //推荐标签
    public static final String ICOME_RECOMMENT_LABLE= "common/user/query/recommenndLabels";
    //共同关注的人
    public static final String ICOME_QUERY_MUTUALFOLLOWED= "label/empinfo/query/mutualFollowed";
    //搜索联系人
    public static final String ICOME_SEARCH_USER= "common//user/search";
    //问答标签列表
    public static final String ICOME_LABEL_LIST= "knowledge/questionLabel/list";

    //黑白名单分页列表
    public static final String ICOME_BLACKWHITELISTR_QUERYLIST= "label/blackwhitelist/querylist";
    //私聊验证设置
    public static final String ICOME_SWITCHSETTING_UPTATE= "label/switchsetting/uptate";
    //黑白名单添加成员
    public static final String ICOME_BLACKWHITELIST_ADD= "label/blackwhitelist/add";
    //删除黑白名单成员
    public static final String ICOME_BLACKWHITELIST_DELETE= "label/blackwhitelist/delete";
    //申请聊天
    public static final String ICOME_APPLY_CHAT= "label/friendapply/add";
    //同意好友申请聊天
    public static final String ICOME_AGREE_APPLY_CHAT= "label/friendapply/updatestatus";
    //好友申请列表
    public static final String ICOME_FRIENDS_APPLICATION_LIST= "label/friendapply/querylist";
    //申请留言分页列表
    public static final String ICOME_FRIENDAPPLYMSG_QUERYLIST= "label/friendapplymsg/querylist";

    //申请列表数量
    public static final String ICOME_GET_APPLY_NUM= "label/friendapply/count";

    //获取通讯录列表
    public static final String ICOME_GET_MAILLIST = "common/user/query/orgTreeInfo";

    //添加常用联系人
    public static final String ICOME_ADD_CONTACT = "common/contacts/add";
    //删除常用联系人
    public static final String ICOME_DELETE_CONTACT = "common/contacts/delete";

    //常用联系人列表
    public static final String ICOME_CONTACT_LIST = "common/contacts/search";
    //根据创建人eId查询用户分组
    public static final String ICOME_GET_EMPGROUPSBYEID = "common/empGroup/queryAll";
    //新增用户分组
    public static final String ICOME_EMPGROUP_ADD = "common/empGroup/add";
    //修改用户分组
    public static final String ICOME_EMPGROUP_MODIFY = "common/empGroup/modify";
    //根据groupId查询成员列表
    public static final String ICOME_GET_BY_GROUPID = "common/empGroupMember/getByGroupId";
    //删除用户分组
    public static final String ICOME_DELETE_GROUP = "common/empGroup/delete";
    //添加分组成员
    public static final String ICOME_BATCHADDMEMBER = "common/empGroupMember/batchAddMember";
    //删除分组成员
    public static final String ICOME_DELETE_MEMBER = "common/empGroupMember/delMember";
    //伙伴印象
    public static final String ICOME_LABEL_IMPRESSION = "label/impress/query/partnerimpress";
    //伙伴印象评论
    public static final String ICOME_LABEL_IMPRESSION_COMMENT= "label/impress/query/page/comments";
    //伙伴印象添加标签
    public static final String ICOME_IMPRESSION_ADD_LABEL= "label/impress/add";
    //IM 获取群成员信息列表
    public static final String ICOME_IM_GETMEMBERLIST= "tim/tencentImGroup/getGroupMemberList";
    //伙伴印象添加标签
    public static final String ICOME_NEW_GET_TICKET= "usercenter/getTicket";
    //是否有权限访问新版创值链
    public static final String ICOME_VALUE_CHAIN_HASPERMISSTOACCESS= "petrel/permission/hasPermissToAccess";
    //伙伴详情
    public static final String ICOME_VALUE_CHAIN_PARTNERdETAIL= "petrel/userinfo/homepage";
    //伙伴详情创值记录列表
    public static final String ICOME_VALUE_CHAIN_PARTNEREVARECORD= "petrel/evarecord/getEvarecordByUserOrg";
    //推荐对象列表
    public static final String ICOME_VALUE_CHAIN_RECOMMEND= "petrel/user/recommend";
    //关注对象列表
    public static final String ICOME_VALUE_CHAIN_GET_FOLLOWED= "petrel/user/getFollowed";

    //伙伴详情添加关注
    public static final String ICOME_VALUE_CHAIN_FOLLOW= "petrel/user/follow";
    //伙伴详情取消关注
    public static final String ICOME_VALUE_CHAIN_CANCLEFOLLOW= "petrel/user/unFollow";

    //组织详情
    public static final String ICOME_VALUE_CHAIN_ORGdETAIL= "petrel/orgdetail/homepage";
    //资源配置详情
    public static final String ICOME_VALUE_CHAIN_RESOURSE= "petrel/orgdetail/resourceconfig/list";
    //搜索创值对象
    public static final String ICOME_VALUE_CHAIN_SEARCH_ORG_AND_USER= "petrel/user/search";
    //根据类型查询推荐对象列表
    public static final String ICOME_VALUE_CHAIN_RECOMMEND_BY_TYPE= "petrel/user/recommendByType";
    //根据类型查询已关注对象列表
    public static final String ICOME_VALUE_CHAIN_GET_FOLLOWEDS_BY_TYPE= "petrel/user/getFollowedsByType";
    //事业文档
    public static final String ICOME_VALUE_CHAIN_BUSINESS_DOCUMENT= "petrel/orgdetail/careerfile/list";
    //创值播报列表
    public static final String ICOME_VALUE_CHAIN_INDEX= "petrel/eva/index";
    //创值播报列表
    public static final String ICOME_VALUE_CHAIN_SEARCH= "petrel/eva/search";

    //发布评论
    public static final String ICOME_VALUE_CHAIN_PUBLISH_COMMENT= "petrel/workbench/pushnote";

    //扫码登录
    public static final String ICOME_SCAN_LOGIN = "tim/qrcode/match";

    //示险列表
    public static final String ICOME_VALUE_CHAIN_RISKLIST = "petrel/orgdetail/risk/list";
    //是否显示机器人图标
    public static final String ICOME_MAILLIST_ROBOT = "common/contacts/isShow";

    //查询会议状态
    public static final String ICOME_QUERY_MEETING_STATUS = "videoMeeting/meeting/meetingStatus";
}