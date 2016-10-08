import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;

public class rgc
  implements Handler.Callback
{
  public static final int a = 0;
  private String a;
  
  public rgc(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    NearbyProcessMonitor.a(this.a, 1);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */