package com.example.administrator.icome.icomeutils.utils;

public interface ILoginType {

    int TYPE_DEFAULT = -1;
    int TYPE_IM_SUCCESS_OF_LOGIN_OUT = 102;
    int TYPE_IM_ERROR_OF_LOGIN_OUT = 103;
    int TYPE_NO_IM_SUCCESS_OF_LOGIN_OUT = 104;
    int TYPE_LOCAL_SERVER_SUCCESS = 200;
    int TYPE_LOCAL_SERVER_ERROR = 201;
    int TYPE_LOCAL_USER_INFO_SUCCESS = 300;
    int TYPE_LOCAL_USER_INFO_ERROR = 301;
    String PUBLIC_KEY_STR =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGFdk9jblkPCEic+0NlZNtb3VgjtVxWSNjsiNRE/4YQW3" +
                    "/EuNMLVLdL4Gy1Qvmei3sac19Ve/WRvI1HskioX" +
                    "+0TYKdvm7630trvzLgcSkKtNQSBkRKMYsEgERMbEdzsCpkNLPZfO8" +
                    "+3dJ7DVjdBnSObxFVt3fzW4ubkSjWjJ4BoQIDAQAB";
}
