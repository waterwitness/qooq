import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.c2b.C2BVideoPreviewActivity;

public class xzy
  extends BroadcastReceiver
{
  public xzy(C2BVideoPreviewActivity paramC2BVideoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("C2BVideoPreviewActivity", 2, "avRequestReceiver onReceive action = " + paramContext + ", time=" + System.currentTimeMillis());
    }
    if ((paramContext.equals("tencent.av.v2q.AudioVideoRequest")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED"))) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */