package cooperation.qzone;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import yks;

public abstract class QZoneHttpUtil$HttpProxy
{
  public static HttpProxy a = new yks();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public abstract int a();
  
  public abstract String a();
  
  public String toString()
  {
    return a() + ':' + a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\QZoneHttpUtil$HttpProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */