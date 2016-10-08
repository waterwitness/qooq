import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.qqconnect.wtlogin.LoginHelper.Callback;
import mqq.observer.SSOAccountObserver;

public class xhi
  extends SSOAccountObserver
{
  public xhi(LoginHelper paramLoginHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.a.a();
    this.a.a = null;
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {}
    for (paramArrayOfByte = new String(paramArrayOfByte);; paramArrayOfByte = null)
    {
      this.a.a.a(paramString, paramArrayOfByte);
      this.a.a = null;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */