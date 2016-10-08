import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class pwp
  implements INetInfoHandler
{
  public pwp(DataLineHandler paramDataLineHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.c();
  }
  
  public void onNetWifi2None()
  {
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */