import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nia
  implements ark.ApplicationCallback
{
  public nia(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void AppCreate(String paramString, ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramString);
  }
  
  public void AppDestroy(String paramString, ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(1, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */