import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.bitapp.BitAppHandlerThread;
import com.tencent.bitapp.MessageForBitApp;
import com.tencent.bitapp.MessageForBitAppTmp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class hdj
  extends Handler
{
  public hdj(BitAppHandlerThread paramBitAppHandlerThread, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.d("BitAppHandlerThread", 2, "handleMessage id: " + i);
    }
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        return;
        paramMessage = paramMessage.obj;
        if ((paramMessage == null) || (!(paramMessage instanceof List))) {
          break;
        }
        paramMessage = ((List)paramMessage).iterator();
        while (paramMessage.hasNext())
        {
          Object localObject = paramMessage.next();
          if ((localObject != null) && ((localObject instanceof MessageForBitApp))) {
            this.a.a(new MessageForBitAppTmp((MessageForBitApp)localObject));
          } else if (QLog.isColorLevel()) {
            QLog.d("BitAppHandlerThread", 2, "MSG_BIT_APP_DOWNLOAD obj isn't MessageForBitApp");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BitAppHandlerThread", 2, "MSG_BIT_APP_DOWNLOAD obj is null or isn't list");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */