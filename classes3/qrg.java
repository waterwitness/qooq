import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCGI.QueryAppInfoByAppNameBatchResult;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qrg
  extends ArkAppCGI.ArkAppCGICallback
{
  public qrg(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ArkAppCGI.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, Object paramObject)
  {
    paramObject = (HashMap)paramObject;
    ArkLocalAppMgr.a(this.a, paramQueryAppInfoByAppNameBatchResult, (HashMap)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */