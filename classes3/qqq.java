import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class qqq
  implements INetInfoHandler
{
  public qqq(ArkAppCenter paramArkAppCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetMobile2None()
  {
    ArkAppCenter.a(this.a, 1, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 1, 2);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 2, 1);
  }
  
  public void onNetWifi2None()
  {
    ArkAppCenter.a(this.a, 2, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */