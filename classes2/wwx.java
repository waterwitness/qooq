import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import mqq.os.MqqHandler;

public class wwx
  implements TicketUtils.TicketCallback
{
  public wwx(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle, long paramLong, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    ThreadManager.b().post(new wxa(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1");
    ThreadManager.b().post(new wwy(this, paramArrayOfByte, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wwx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */