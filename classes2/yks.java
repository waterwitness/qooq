import android.net.Proxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneHttpUtil.HttpProxy;

public final class yks
  extends QZoneHttpUtil.HttpProxy
{
  public yks()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return Proxy.getDefaultPort();
  }
  
  public String a()
  {
    return Proxy.getDefaultHost();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */