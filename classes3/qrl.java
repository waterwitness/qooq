import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qrl
  extends ArkAppCGI.ArkAppCGICallback
{
  public qrl(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, ArrayList paramArrayList, Object arg3)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, fail.", new Object[0]));
    }
    synchronized (ArkLocalAppMgr.a(this.a))
    {
      ArkLocalAppMgr.a(this.a).clear();
      if (paramArrayList != null) {
        ArkLocalAppMgr.a(this.a).addAll(paramArrayList);
      }
      return;
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, success, app-count=%d", new Object[] { Integer.valueOf(paramArrayList.size()) }));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */