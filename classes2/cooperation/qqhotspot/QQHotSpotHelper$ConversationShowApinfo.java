package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$ConversationShowApinfo
  implements Serializable
{
  public QQHotSpotHelper.HotSpotNodeAPInfo mApInfo;
  public int mStatus;
  
  public QQHotSpotHelper$ConversationShowApinfo(int paramInt, QQHotSpotHelper.HotSpotNodeAPInfo paramHotSpotNodeAPInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mStatus = 0;
    this.mStatus = paramInt;
    this.mApInfo = paramHotSpotNodeAPInfo;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$ConversationShowApinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */