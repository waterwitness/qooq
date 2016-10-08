package com.tencent.mobileqq.rn;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard.NearbyMyTabConfig;
import java.net.URLEncoder;

public class RNTest
{
  static final String a = RNTest.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static NearbyMyTabCard.NearbyMyTabConfig a(int paramInt1, int paramInt2, NearbyMyTabCard.NearbyMyTabConfig paramNearbyMyTabConfig)
  {
    if (paramNearbyMyTabConfig == null) {
      return null;
    }
    NearbyMyTabCard.NearbyMyTabConfig localNearbyMyTabConfig = new NearbyMyTabCard.NearbyMyTabConfig();
    localNearbyMyTabConfig.configId = paramNearbyMyTabConfig.configId;
    localNearbyMyTabConfig.iconUrl = paramNearbyMyTabConfig.iconUrl;
    localNearbyMyTabConfig.extraVal = paramNearbyMyTabConfig.extraVal;
    localNearbyMyTabConfig.redTouch = paramNearbyMyTabConfig.redTouch;
    String str4 = "";
    String str3 = "";
    String str2 = "#FFF8F8F8";
    String str1 = "#FF12B7F5";
    paramNearbyMyTabConfig = "#777777";
    String str5;
    if (paramInt1 == 24)
    {
      localNearbyMyTabConfig.strName = "附近校友";
      paramInt2 = 25;
      str5 = "nearby";
    }
    for (int i = 8;; i = 1)
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("mqqapi://nearby_entry/rn_busi").append("?").append("busi_id").append("=").append(paramInt1).append("&").append("busi_version").append("=").append(paramInt2).append("&").append("busi_from").append("=").append(str5).append("&").append("busi_title").append("=").append(str4).append("&").append("busi_extra").append("=").append("").append("&").append("busi_url").append("=").append(str3).append("&").append("busi_load").append("=").append(i).append("&").append("busi_bgclr").append("=").append(str2).append("&").append("busi_headerclr").append("=").append(str1).append("&").append("busi_tipclr").append("=").append(paramNearbyMyTabConfig);
      NearbyUtils.a(a, new Object[] { "makeTestEntry", localStringBuilder.toString() });
      localNearbyMyTabConfig.strUrl = localStringBuilder.toString();
      return localNearbyMyTabConfig;
      localNearbyMyTabConfig.strName = "RN框架测试";
      str3 = Base64.a("http://www.qq.com");
      str2 = "#FF00FF00";
      str1 = "#FFFF0000";
      paramNearbyMyTabConfig = "#FFFFFF";
      str5 = "test_nearby";
      str4 = "RN框架测试";
    }
  }
  
  public static NearbyMyTabCard.NearbyMyTabConfig a(NearbyMyTabCard.NearbyMyTabConfig paramNearbyMyTabConfig)
  {
    if (paramNearbyMyTabConfig == null) {
      return null;
    }
    NearbyMyTabCard.NearbyMyTabConfig localNearbyMyTabConfig = new NearbyMyTabCard.NearbyMyTabConfig();
    localNearbyMyTabConfig.strName = "附近找校友H5入口";
    localNearbyMyTabConfig.configId = paramNearbyMyTabConfig.configId;
    localNearbyMyTabConfig.iconUrl = paramNearbyMyTabConfig.iconUrl;
    localNearbyMyTabConfig.extraVal = paramNearbyMyTabConfig.extraVal;
    localNearbyMyTabConfig.redTouch = paramNearbyMyTabConfig.redTouch;
    paramNearbyMyTabConfig = "深圳大学";
    try
    {
      String str = URLEncoder.encode("深圳大学");
      paramNearbyMyTabConfig = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localNearbyMyTabConfig.strUrl = String.format("%s?nativeFrom=%s&editSchoolName=%s", new Object[] { "http://sqimg.qq.com/qq_product_operations/nearbyschool/index.html", "nearby", paramNearbyMyTabConfig });
    return localNearbyMyTabConfig;
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (paramInt == 24) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RNTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */