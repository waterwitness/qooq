import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.openapi.entity.ThirdPartyApp;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class tsg
  extends MessageObserver
{
  public tsg(OpenApiManager paramOpenApiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    a(false, paramString1, paramLong2);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    Intent localIntent;
    if (OpenApiManager.b(this.a).containsKey(Long.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Manager", 2, "onSendResult, isSuccess = " + paramBoolean + ", uniseq = " + paramLong);
      }
      paramString = (String)OpenApiManager.b(this.a).remove(Long.valueOf(paramLong));
      paramString = (ThirdPartyApp)OpenApiManager.a(this.a).get(paramString);
      if (paramString != null)
      {
        localIntent = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + paramString.b);
        localIntent.putExtra("msgid", paramString.a(String.valueOf(paramLong)));
        if (!paramBoolean) {
          break label171;
        }
      }
    }
    label171:
    for (int i = 0;; i = -9)
    {
      localIntent.putExtra("rs_code", i);
      BaseApplicationImpl.a.sendBroadcast(localIntent, paramString.c);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */