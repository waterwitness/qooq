import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qrh
  extends ArkAppCGI.ArkAppCGICallback
{
  public qrh(ArkLocalAppMgr paramArkLocalAppMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ArkLocalAppMgr.a(this.a, paramBoolean, paramArrayOfByte, (ArkLocalAppMgr.UpdateAppByNameTask)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */