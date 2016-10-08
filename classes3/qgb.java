import android.os.IBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgHandler;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class qgb
  implements OnPluginInstallListener
{
  public qgb(SecMsgHandler paramSecMsgHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallBegin, pluginId:" + paramString);
    }
    SecMsgHandler.a = true;
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallDownloadProgress, pluginId:" + paramString + ",offset:" + paramInt1 + ",total:" + paramInt2);
    }
    SecMsgHandler.a = true;
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallError, pluginId:" + paramString + ",errorCode:" + paramInt);
    }
    paramInt = SecMsgHandler.c;
    SecMsgHandler.c = paramInt - 1;
    if (paramInt > 0)
    {
      this.a.a();
      return;
    }
    SecMsgHandler.a = false;
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SecMsgHandler", 4, "onInstallFinish, pluginId:" + paramString);
    }
    SecMsgHandler.a = false;
    paramString = (SecMsgManager)this.a.b.getManager(56);
    if ((paramString != null) && (paramString.a()) && (SecMsgHandler.a(this.a) != -1L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("SecMsgHandler", 4, "onInstallFinish, show entrance int msg tab, time=" + SecMsgHandler.a(this.a));
      }
      paramString.a(true, SecMsgHandler.a(this.a), 0L);
    }
    SecMsgHandler.a(this.a, -1L, SecMsgUtil.a());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */