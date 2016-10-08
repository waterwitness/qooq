package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$HotSpotNodeApEx
  implements Serializable
{
  public String mBssid;
  public Integer mLevel;
  public String mSsid;
  
  public QQHotSpotHelper$HotSpotNodeApEx(Integer paramInteger, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mLevel = paramInteger;
    this.mSsid = paramString1;
    this.mBssid = paramString2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$HotSpotNodeApEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */