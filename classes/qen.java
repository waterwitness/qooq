import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class qen
  extends Handler
{
  public qen(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    Intent localIntent;
    if (paramMessage.what == 990)
    {
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.a(this.a))
      {
        paramMessage.addAll(QQAppInterface.a(this.a));
        QQAppInterface.a(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(990);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break label172;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.a.a(1, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      localIntent = new Intent("com.tencent.qqhead.getheadresp");
      localIntent.putStringArrayListExtra("uinList", paramMessage);
      localIntent.putStringArrayListExtra("headPathList", ???);
      this.a.a().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      label172:
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.what != 991);
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.b(this.a))
      {
        paramMessage.addAll(QQAppInterface.b(this.a));
        QQAppInterface.b(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(991);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          continue;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.a.a(4, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      localIntent = new Intent("com.tencent.qqhead.getheadresp");
      localIntent.setPackage(QQAppInterface.e(this.a).getPackageName());
      localIntent.putStringArrayListExtra("uinList", paramMessage);
      localIntent.putStringArrayListExtra("headPathList", ???);
      localIntent.putExtra("faceType", 4);
      this.a.a().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead resp uinList: ", paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */