package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VasWebviewConstants
{
  public static final int ACTIVITY_TYPE_HOMEPAGE = 1;
  public static final int ACTIVITY_TYPE_SUB_HOMEPAGE = 3;
  public static final int ACTIVITY_TYPE_SUB_PAGE = 2;
  public static final String APOLLO_MY_PROFILE_URL;
  public static final String APOLLO_MY_TASK_URL;
  public static final String APOLLO_STORE_URL;
  public static final String BUSINESS = "business";
  public static final int FLAG_HARDWARE_ACCELERATED = 16777216;
  public static final String FROM_INDIVIDUATION_SET = "FromIndividuationSet";
  public static final String FROM_THEME_NOVICE_GUIDE = "FromThemeNoviceGuide";
  public static final String FROM_WHERE_KEY = "FromWhere";
  public static final String INDIVIDUATION_URL_SOURCE_TYPE = "individuation_url_type";
  public static final String KEY_ADTAG = "adTag";
  public static final String KEY_EMOJIMALL_CLOSE_BACK = "back_from_emojimall";
  public static final String KEY_EMOJIMALL_DETAIL_CHAT_TYPE = "key_emojimall_detail_chat_type";
  public static final String KEY_EMOJIMALL_DETAIL_CHAT_UIN = "key_emojimall_detail_chat_uin";
  public static final String KEY_EMOJIMALL_DETAIL_ID = "emojimall_detail_id";
  public static final String KEY_EMOJIMALL_QFACE = "emojimall_qFace";
  public static final String KEY_EMOJIMALL_SID = "emojimall_sid";
  public static final String KEY_EMOJIMALL_SRC_FROM = "emojimall_src";
  public static final String KEY_MALL_NEW_TIMESTAMP = "emomall_new_time";
  public static final String KEY_OPEN_PAGE_TIME = "startOpenPageTime";
  public static final String KEY_PAGE_TITLE = "pageTitle";
  public static final String KEY_PAGE_URL = "pageUrl";
  public static final String KEY_PLUGIN_FINISHED_TIME = "pluginFinished";
  public static final String KEY_SERVICE_ID = "key_service_id";
  public static final String KEY_UPDATE_FLAG = "updateFlag";
  public static final String KEY_UPDATE_ID = "updateId";
  public static final String KEY_UPDATE_TIME = "updateTime";
  public static final String KEY_URL = "url";
  public static final String KEY_VAS_USE_PREWEBVIEW = "vasUsePreWebview";
  public static final Boolean LOCAL_URL_NEED_KEY_SWITCHER;
  public static final int REPORT_FROM_AIO = 40300;
  public static final int REPORT_FROM_AIO_BACKGROUND_SETTING = 40305;
  public static final int REPORT_FROM_AIO_COLORRING = 40303;
  public static final int REPORT_FROM_AIO_DOUBLE_CLICK = 40301;
  public static final int REPORT_FROM_AIO_EMOTICON_MANAGER = 40313;
  public static final int REPORT_FROM_AIO_EMOTICON_PANEL = 40310;
  public static final int REPORT_FROM_AIO_EMOTICON_PANEL_AD = 40311;
  public static final int REPORT_FROM_AIO_EMOTICON_PANEL_MAGIC = 40312;
  public static final int REPORT_FROM_AIO_RENEWAL_GRAY_TIPS = 40306;
  public static final int REPORT_FROM_CALLDETAIL = 40304;
  public static final int REPORT_FROM_FRIEND_PROFILE_CARD = 40201;
  public static final int REPORT_FROM_INDIVIDUATION_MAINPAGE = 40302;
  public static final int REPORT_FROM_INDIVIDUATION_SET = 40100;
  public static final int REPORT_FROM_MY_INDIVIDUATION_SET = 40101;
  public static final int REPORT_FROM_OTHER_PROFILE_CARD = 40203;
  public static final int REPORT_FROM_PROFILE_CARD_MALL_BUTON = 40204;
  public static final int REPORT_FROM_USER_PROFILE_CARD = 40202;
  public static final String REPORT_KEY_PERSONAL_WEB_PRELOAD_HIT_RIT = "personal_web_preload_hit_rit";
  public static final String REPORT_NAME_EMOTICON_PANEL_PLUS_ENTRANCE = "emoticon_main_panel_plus";
  public static final int REQUEST_CODE_QFACE = 201;
  public static final int RESULT_QFACE_LOSSY = 102;
  public static final int RESULT_QFACE_PATH_ERROR = 101;
  public static final int SRC_TYPE_AIO_EMOPANEL = 1;
  public static final int SRC_TYPE_AIO_RENEWAL_GRAY_TIPS = 10;
  public static final int SRC_TYPE_EMO_DIRECT_AUTHOR = 5;
  public static final int SRC_TYPE_EMO_DIRECT_DETAIL_AIO = 8;
  public static final int SRC_TYPE_EMO_DIRECT_DETAIL_OTHER = 4;
  public static final int SRC_TYPE_EMO_LIST_DIRECT_DETAIL_AIO = 11;
  public static final int SRC_TYPE_EMO_MANAGER = 2;
  public static final int SRC_TYPE_INDIVID_CENTER = 3;
  public static final int SRC_TYPE_MAGIC_EMO_AIO = 6;
  public static final int SRC_TYPE_MAGIC_PROMOTION = 9;
  public static final int SRC_TYPE_OTHER_UNKNOWN = 7;
  public static final int STEP_BEFORE_LOAD_URL = 2;
  public static final int STEP_WEBVIEW_CREATED = 1;
  public static final String TAG = "VasWebviewPlugin";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    LOCAL_URL_NEED_KEY_SWITCHER = Boolean.valueOf(false);
    StringBuilder localStringBuilder = new StringBuilder("http://cmshow.qq.com/apollo/html/index_v2.html");
    localStringBuilder.append("?client=androidQQ").append("&version=").append("6.5.5.2880").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&_bid=2423");
    APOLLO_STORE_URL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder("http://cmshow.qq.com/apollo/html/task.html");
    localStringBuilder.append("?client=androidQQ").append("&version=").append("6.5.5.2880").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&_wv=1027").append("&_bid=2345");
    APOLLO_MY_TASK_URL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder("http://cmshow.qq.com/apollo/html/profile.html?_wv=1027");
    localStringBuilder.append("&client=androidQQ").append("&version=").append("6.5.5.2880").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&_bid=2282");
    APOLLO_MY_PROFILE_URL = localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VasWebviewConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */