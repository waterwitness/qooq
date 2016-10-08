import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qel
  extends BroadcastReceiver
{
  public qel(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadreq".equals(paramIntent.getAction()))) {
      ThreadManager.a(new qem(this, paramContext, paramIntent), 8, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */