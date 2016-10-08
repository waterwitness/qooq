import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qrk
  implements qrs
{
  public qrk(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", "updateInstalledApps, network not available.");
      return;
    }
    ArkLocalAppMgr.a(this.a);
    ArkLocalAppMgr.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */