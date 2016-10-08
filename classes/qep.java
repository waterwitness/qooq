import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qep
  extends BroadcastReceiver
{
  public qep(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT")) && (!paramContext.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.a().getPackageName()))) {
      return;
    }
    PreloadProcHitMgr.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */