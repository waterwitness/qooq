package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoPlayUtils
{
  public static final long a = 1000L;
  public static final String a = "shouq_bus_type";
  public static final String b = "bus_type_kandian_feeds";
  public static final String c = "bus_type_full_screen";
  
  public VideoPlayUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    int i = NetworkUtil.a(BaseApplication.getContext());
    if (i == 1) {
      return "shd";
    }
    if ((i == 4) || (i == 3)) {
      return "hd";
    }
    return "sd";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\VideoPlayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */