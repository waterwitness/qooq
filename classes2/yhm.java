import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqhotspot.QQHotSpotHelper.APInfo;
import cooperation.qqhotspot.hotspotnode.QQHotSpotWiFiScanTool;
import java.util.Comparator;

public class yhm
  implements Comparator
{
  public yhm(QQHotSpotWiFiScanTool paramQQHotSpotWiFiScanTool)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(QQHotSpotHelper.APInfo paramAPInfo1, QQHotSpotHelper.APInfo paramAPInfo2)
  {
    return paramAPInfo2.SignLevel - paramAPInfo1.SignLevel;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */