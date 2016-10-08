package cooperation.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class QRAioCmdReceiver
  extends BroadcastReceiver
{
  public static final String a = "QRAioCmdReceiver";
  public static final String b = "cooperation.qqreader.aioback2reader";
  
  public QRAioCmdReceiver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QRAioCmdReceiver", 2, "action : " + (String)localObject + ", intent = " + paramIntent);
    }
    if ("cooperation.qqreader.aioback2reader".equals(localObject))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).putExtra("readtype", "15");
      ((Intent)localObject).setClassName(paramContext, "cooperation.qqreader.QRBridgeActivity");
      ((Intent)localObject).addFlags(268435456);
      paramContext.startActivity((Intent)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRAioCmdReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */