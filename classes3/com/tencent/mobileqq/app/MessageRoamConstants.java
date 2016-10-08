package com.tencent.mobileqq.app;

import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public abstract interface MessageRoamConstants
{
  public static final String A = "http://mapp.3g.qq.com/touch/psw/verify.jsp";
  public static final String B = "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]";
  public static final String C = "http://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=";
  public static final String D = EmosmUtils.a("VIP_roam_msg_search_cfg", "http://i.gtimg.cn/qqshow/admindata/comdata/searchStrategy/xydata.json");
  public static final String E = BaseApplication.getContext().getFilesDir() + File.separator + "searchInCloudConfig.json";
  public static final String F = "cloudSearchCfgLastModify";
  public static final String G = "http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json";
  public static final int a = 1;
  public static final String a = "devlock_guide_config";
  public static final int b = 2;
  public static final String b = "open_devlock_from_roam";
  public static final int c = 3;
  public static final String c = "open_devlock_verify_passwd";
  public static final int d = 4;
  public static final String d = "devlock_open_source";
  public static final int e = 1;
  public static final String e = "devlock_show_auth_dev_list";
  public static final int f = 0;
  public static final String f = "vip_message_roam_banner_file";
  public static final int g = 1;
  public static final String g = "vip_message_roam_passwordmd5_and_signature_file";
  public static final int h = 0;
  public static final String h = "vip_message_roam_passwordmd5";
  public static final String i = "vip_message_roam_last_request_timestamp";
  public static final String j = "blue_banner_last_update_timestamp";
  public static final String k = "blue_banner_cheak_update_internal";
  public static final String l = "banner_last_show_timestamp";
  public static final String m = "blue_banner_show_internal";
  public static final String n = "blue_banner_notvip_text";
  public static final String o = "blue_banner_vip_text";
  public static final String p = "blue_banner_svip_text";
  public static final String q = "blue_banner_go_url";
  public static final String r = "blue_banner_show_time";
  public static final String s = "message_roam_flag";
  public static final String t = "message_roam_is_set_password";
  public static final String u = "message_roam_is_first_show";
  public static final String v = "auth_mode_";
  public static final String w = "first_use_devlock_for_roam_message_";
  public static final String x = "delServerRoamMSg_";
  public static final String y = "http://mapp.3g.qq.com/touch/psw/create.jsp";
  public static final String z = "http://mapp.3g.qq.com/touch/psw/create.jsp?_wv=5123";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\MessageRoamConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */