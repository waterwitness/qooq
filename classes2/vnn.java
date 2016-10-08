import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;

public class vnn
  extends BroadcastReceiver
{
  public vnn(TroopNoticeJsHandler paramTroopNoticeJsHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */