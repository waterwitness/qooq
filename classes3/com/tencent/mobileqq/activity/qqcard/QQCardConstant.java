package com.tencent.mobileqq.activity.qqcard;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract interface QQCardConstant
{
  public static final int a = 1;
  public static final long a = 3600000L;
  public static final String a = "QCARD.CouponAccessCoroServer.CouponAccessCoroObj";
  public static final SimpleDateFormat a;
  public static final String[] a;
  public static final int b = 2;
  public static final long b = 0L;
  public static final String b = "QQCardAccessSvc.getList";
  public static final int c = 3;
  public static final String c = "QQCardAccessSvc.CollectCoupon";
  public static final int d = 4;
  public static final String d = "QQCardAccessSvc.GetCollectItemMobile";
  public static final int e = 5;
  public static final String e = "即将于%d天后过期";
  public static final int f = 6;
  public static final String f = "即将于明天过期";
  public static final int g = 7;
  public static final String g = "即将于今天过期";
  public static final int h = 8;
  public static final String h = "QQCard";
  public static final int i = 0;
  public static final String i = "qqcard";
  public static final int j = 1;
  public static final String j = "qqcard_page_map";
  public static final int k = 9;
  public static final String k = "qqcard_sequence_631";
  public static final int l = -2000;
  public static final String l = "qqcard_expired_link";
  public static final int m = 1;
  public static final String m = "background_url";
  public static final int n = 2;
  public static final String n = "valid_tips_color";
  public static final int o = 3;
  public static final String o = "from_color";
  public static final int p = 800;
  public static final String p = "recommend_card_id";
  public static final int q = 2000;
  public static final String q = "recommend_card_rsp";
  public static final int r = 7;
  public static final int s = 30;
  public static final int t = (int)(50.0F * DeviceInfoUtil.a() + 0.5F);
  public static final int u = (int)(17.0F * DeviceInfoUtil.a() + 0.5D);
  public static final int v = (int)(10.0F * DeviceInfoUtil.a() + 0.5F);
  public static final int w = (int)(46.0F * DeviceInfoUtil.a() + 0.5F);
  public static final int x = (int)(168.0F * DeviceInfoUtil.a() + 0.5F);
  public static final int y = (int)(-116.0F * DeviceInfoUtil.a() + 0.5D);
  public static final int z = 100;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "QQCardAccessSvc" };
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("有效期至yyyy-MM-dd", Locale.CHINA);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */