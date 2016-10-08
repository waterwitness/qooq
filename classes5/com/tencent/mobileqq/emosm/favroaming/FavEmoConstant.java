package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FavEmoConstant
{
  public static int a = 144;
  public static final String a = "scbqmanyou";
  public static int b = 300;
  public static final String b = "Faceroam.OpReq";
  public static final int c = 100;
  public static final String c = "cmd_fav_subcmd";
  public static final int d = 200;
  public static final String d = "fav_roaming_sp";
  public static final String e = "fav_roaming_isclick";
  public static final String f = "fav_roaming_time";
  public static final String g = "fav_roaming_isshow";
  public static final String h = "local_overflow";
  public static final String i = "fav_roaming_max";
  public static final String j = "init";
  public static final String k = "isUpdate";
  public static final String l = "needDownload";
  public static final String m = "overflow";
  public static final String n = "overflow_downloaded";
  public static final String o = "needDel";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return AppConstants.bs + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("http://p.qpic.cn/");
    localStringBuilder.append(paramString2).append("/").append(paramString3).append("/").append(paramString1).append("/0");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\favroaming\FavEmoConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */