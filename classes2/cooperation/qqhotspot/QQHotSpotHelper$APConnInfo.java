package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$APConnInfo
  implements Serializable
{
  public int ConnErrorCode;
  public int ConnStatus;
  
  public QQHotSpotHelper$APConnInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ConnStatus = -1;
    this.ConnErrorCode = -1;
  }
  
  public void reSet()
  {
    this.ConnStatus = -1;
    this.ConnErrorCode = -1;
  }
  
  public String toString()
  {
    return " APConnInfo = {ConnStatus = " + this.ConnStatus + " ,ConnErrorCode = " + this.ConnErrorCode + " } ";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$APConnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */