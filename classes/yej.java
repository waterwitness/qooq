import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qlink.QQProxyForQlink;

class yej
  extends BroadcastReceiver
{
  yej(yei paramyei)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (QQProxyForQlink.a(this.a.a) != null))
    {
      QQProxyForQlink.a(this.a.a).dismiss();
      QQProxyForQlink.a(this.a.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */