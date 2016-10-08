import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class mji
  extends AccountObserver
{
  public mji(RegisterSendUpSms paramRegisterSendUpSms)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    RegisterSendUpSms.a(this.a, paramInt1);
    if (paramInt1 == 4)
    {
      RegisterSendUpSms.a(this.a).setVisibility(8);
      RegisterSendUpSms.a(this.a).setVisibility(0);
      RegisterSendUpSms.a(this.a).sendMessageDelayed(RegisterSendUpSms.a(this.a).obtainMessage(1), paramInt2 * 1000);
      if (!RegisterSendUpSms.b(this.a))
      {
        RegisterSendUpSms.a(this.a, true);
        RegisterSendUpSms.a(this.a).sendMessageDelayed(RegisterSendUpSms.a(this.a).obtainMessage(2), paramInt3 * 1000);
      }
      return;
    }
    RegisterSendUpSms.a(this.a).setEnabled(true);
    RegisterSendUpSms.a(this.a, false);
    RegisterSendUpSms.a(this.a).removeMessages(1);
    RegisterSendUpSms.a(this.a).removeMessages(2);
    RegisterSendUpSms.a(this.a).setVisibility(8);
    if (paramInt1 == 0)
    {
      RegisterSendUpSms.a(this.a).setVisibility(8);
      RegisterSendUpSms.a(this.a);
      return;
    }
    String str = paramString;
    if (paramInt1 == -1) {}
    try
    {
      str = new String(paramArrayOfByte, "utf-8");
      QQToast.a(this.a, str.trim(), 0).b(this.a.getTitleBarHeight());
      this.a.setResult(0);
      this.a.finish();
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        str = paramString;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */