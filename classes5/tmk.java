import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;

public class tmk
  implements Handler.Callback
{
  public tmk(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      NearbyProfileDisplayPanel.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */