package cooperation.qzone.webviewplugin.personalize;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.MapUtil;
import java.util.Map;

public class QZonePersonalizeH5Service
{
  private static final int a = 18;
  public static final String a = "key_personalize_prefix_18";
  private static final int b = 19;
  public static final String b = "key_personalize_prefix_19";
  private static final int c = 20;
  public static final String c = "key_personalize_prefix_20";
  private static final int d = 21;
  public static final String d = "key_personalize_prefix_21";
  private static final int e = 22;
  public static final String e = "key_personalize_prefix_22";
  private static final int f = 23;
  public static final String f = "key_personalize_prefix_23";
  private static final String g = "key_personalize_prefix";
  private static final String h = "CTIME_MAP";
  
  public QZonePersonalizeH5Service()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static Map a(long paramLong)
  {
    Map localMap = MapUtil.a(LocalMultiProcConfig.a("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static Map a(Long paramLong)
  {
    return a(paramLong.longValue());
  }
  
  public static void a(Integer paramInteger, Long paramLong)
  {
    Map localMap = a(paramLong);
    localMap.put(paramInteger, Long.valueOf(System.currentTimeMillis() / 1000L));
    if (QLog.isColorLevel()) {
      QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + paramInteger + "timestamp: " + System.currentTimeMillis() / 1000L);
    }
    a(localMap, paramLong);
  }
  
  public static void a(Map paramMap, Long paramLong)
  {
    LocalMultiProcConfig.a("CTIME_MAP" + paramLong, MapUtil.a(paramMap));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\personalize\QZonePersonalizeH5Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */