package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$HotSpotNodeAPInfo
  implements Serializable
{
  public QQHotSpotHelper.APInfo mApInfo;
  public QQHotSpotHelper.APInfoEx mApInfoEx;
  
  public QQHotSpotHelper$HotSpotNodeAPInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mApInfo = new QQHotSpotHelper.APInfo();
    this.mApInfoEx = new QQHotSpotHelper.APInfoEx();
  }
  
  public QQHotSpotHelper$HotSpotNodeAPInfo(QQHotSpotHelper.APInfo paramAPInfo, QQHotSpotHelper.APInfoEx paramAPInfoEx)
  {
    this.mApInfo = paramAPInfo;
    this.mApInfoEx = paramAPInfoEx;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$HotSpotNodeAPInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */