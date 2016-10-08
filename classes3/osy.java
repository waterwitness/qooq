import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;

public class osy
  extends Handler
{
  public osy(PasswdRedBagManager paramPasswdRedBagManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    if (paramMessage.arg1 == 1)
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(PasswdRedBagManager.a, 2, "receive passwdredbags from group or disgroup, isSuccess = " + bool);
      }
      if (bool) {
        break label61;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label61:
      if ((i == 1) || (i == 0))
      {
        ThreadManager.a().post(new osz(this, i));
        paramMessage = (List)paramMessage.obj;
        if (paramMessage != null)
        {
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext())
          {
            oidb_0x438.RedBagInfo localRedBagInfo = (oidb_0x438.RedBagInfo)paramMessage.next();
            this.a.a(localRedBagInfo);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */