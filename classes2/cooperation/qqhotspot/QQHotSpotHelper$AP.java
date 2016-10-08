package cooperation.qqhotspot;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class QQHotSpotHelper$AP
  implements Serializable
{
  public QQHotSpotHelper.APInfoEx APInfoEx;
  public QQHotSpotHelper.APConnInfo ApConnInfo;
  public QQHotSpotHelper.APInfo Apinfo;
  
  public QQHotSpotHelper$AP()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.Apinfo = new QQHotSpotHelper.APInfo();
    this.ApConnInfo = new QQHotSpotHelper.APConnInfo();
    this.APInfoEx = new QQHotSpotHelper.APInfoEx();
  }
  
  public String toString()
  {
    return " AP = {" + this.Apinfo.toString() + ", " + this.ApConnInfo.toString() + ", " + this.APInfoEx.toString() + "} ";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper$AP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */