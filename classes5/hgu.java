import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hgu
  extends BroadcastReceiver
{
  hgu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NetworkUtil.a(paramContext) == 1) {
      hgp.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */