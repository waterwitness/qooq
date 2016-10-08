import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class qqs
  implements BusinessObserver
{
  public qqs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ArkAppCenter.c("ArkApp.ArkAppCenterTest", String.format("onSendGenericMsgResult, %s", new Object[] { (String)paramObject }));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */