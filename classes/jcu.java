import android.os.Bundle;
import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class jcu
  implements BusinessObserver
{
  public jcu(QRCodeEncodeCallback paramQRCodeEncodeCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    for (paramBundle = paramBundle.getString("result");; paramBundle = null)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (paramBundle.getInt("r") != 0) {
          continue;
        }
        paramBundle = paramBundle.getString("url");
        if (paramBundle != null)
        {
          this.a.a(true, paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
      }
      this.a.a(false, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */