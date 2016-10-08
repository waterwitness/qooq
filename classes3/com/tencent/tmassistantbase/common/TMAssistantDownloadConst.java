package com.tencent.tmassistantbase.common;

public class TMAssistantDownloadConst
{
  public static final int BATCH_SDKDOWNLOAD_ACTION_CANCEL = 3;
  public static final int BATCH_SDKDOWNLOAD_ACTION_DELETE = 4;
  public static final int BATCH_SDKDOWNLOAD_ACTION_INSTALL = 5;
  public static final int BATCH_SDKDOWNLOAD_ACTION_OPEN = 6;
  public static final int BATCH_SDKDOWNLOAD_ACTION_PAUSE = 2;
  public static final int BATCH_SDKDOWNLOAD_ACTION_START = 1;
  public static final String CLIENT_KEY = "client_key";
  public static final byte DOWNLOADTYPE_DIFF_UPDATE = 3;
  public static final byte DOWNLOADTYPE_FULL_UPDATE = 1;
  public static final byte DOWNLOADTYPE_NORMAL_DOWNLOAD = 2;
  public static String PARAM_APPID = "appId";
  public static String PARAM_APP_NAME;
  public static String PARAM_CHANNELID;
  public static String PARAM_DOWNLOADTYPE;
  public static String PARAM_EXTRA_DATA;
  public static String PARAM_ICON_URL;
  public static String PARAM_SHOW_NOTIFICATION;
  public static String PARAM_TASK_PACKNAME = "packageName";
  public static String PARAM_TASK_VERSION = "versionCode";
  public static String PARAM_UIN;
  public static String PARAM_UIN_TYPE;
  public static String PARAM_VIA = "via";
  public static int SHOW_NOTIFICATION_FALSE = 0;
  public static int SHOW_NOTIFICATION_TRUE = 0;
  public static final String UINTYPE_CODE = "code";
  public static final String UINTYPE_COMMONID = "commonId";
  public static final String UINTYPE_OPENID = "game_openId";
  public static final String UINTYPE_QQ_NUM = "qqNumber";
  
  static
  {
    PARAM_DOWNLOADTYPE = "downloadType";
    PARAM_UIN = "uin";
    PARAM_UIN_TYPE = "uinType";
    PARAM_CHANNELID = "channelId";
    PARAM_EXTRA_DATA = "extra_data";
    PARAM_ICON_URL = "icon_url";
    PARAM_APP_NAME = "app_name";
    PARAM_SHOW_NOTIFICATION = "show_notification";
    SHOW_NOTIFICATION_TRUE = 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\common\TMAssistantDownloadConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */