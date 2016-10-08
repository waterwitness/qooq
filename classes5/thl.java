import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nearby.NearbyAppInterface;

public class thl
  implements INetInfoHandler
{
  private thl(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetMobile2None()
  {
    if (NearbyAppInterface.i(this.a) != null) {
      NearbyAppInterface.j(this.a).onNetMobile2None();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (NearbyAppInterface.g(this.a) != null) {
      NearbyAppInterface.h(this.a).onNetMobile2Wifi(paramString);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (NearbyAppInterface.a(this.a) != null) {
      NearbyAppInterface.b(this.a).onNetNone2Mobile(paramString);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (NearbyAppInterface.e(this.a) != null) {
      NearbyAppInterface.f(this.a).onNetNone2Wifi(paramString);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (NearbyAppInterface.c(this.a) != null) {
      NearbyAppInterface.d(this.a).onNetWifi2Mobile(paramString);
    }
  }
  
  public void onNetWifi2None()
  {
    if (NearbyAppInterface.k(this.a) != null) {
      NearbyAppInterface.l(this.a).onNetWifi2None();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */