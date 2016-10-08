import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.SSOAccountObserver;

public class sls
  extends SSOAccountObserver
{
  WeakReference a;
  
  public sls(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramForwardSdkBaseOption);
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, "-->onFailed--account = " + paramString + ", ret = " + paramInt2);
    }
    paramString = (ForwardSdkBaseOption)this.a.get();
    if ((paramString != null) && (!paramString.k) && (ForwardSdkBaseOption.a(paramString) != null)) {
      ForwardSdkBaseOption.a(paramString).sendEmptyMessage(0);
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, "-->onGetTicketNoPasswd--recv g_t_n_p, account = " + paramString);
    }
    if (paramInt == 4096) {}
    for (paramString = new String(paramArrayOfByte);; paramString = null)
    {
      paramArrayOfByte = (ForwardSdkBaseOption)this.a.get();
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte.af = paramString;
        paramArrayOfByte.k = true;
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */