package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QZoneHelper$QZoneFamousSpaceHomeConstants
{
  public static final String a = "http://mp.qzone.qq.com/u/";
  public static final String b = "http://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}";
  
  public QZoneHelper$QZoneFamousSpaceHomeConstants()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    return LocalMultiProcConfig.a("QzoneFamousSpaceSp", QZoneHelper.UserInfo.a().a, "http://h5.qzone.qq.com/vpage/cover/{uin}/vpage-index?screenWidth={screenWidth}&qua={qua}&_proxy=1&_wv=1029&bottom={bottom}");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHelper$QZoneFamousSpaceHomeConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */