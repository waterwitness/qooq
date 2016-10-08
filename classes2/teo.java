import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class teo
  extends Handler
{
  public teo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public teo(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject = (Object[])paramMessage.obj;
    if (i == 1)
    {
      if (ChatBackgroundManager.e < 3)
      {
        paramMessage = (String)localObject[0];
        localObject = (QQAppInterface)localObject[1];
        ChatBackgroundManager.a((QQAppInterface)localObject, paramMessage, StatisticCollector.a(BaseApplication.getContext()));
        ChatBackgroundManager.e += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "reportTimes is:" + ChatBackgroundManager.e);
        }
        Message localMessage = ChatBackgroundManager.a.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = new Object[] { paramMessage, localObject };
        ChatBackgroundManager.a.sendMessageDelayed(localMessage, 120000L);
      }
    }
    else {
      return;
    }
    ChatBackgroundManager.e = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\teo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */