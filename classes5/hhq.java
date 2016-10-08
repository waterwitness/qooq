import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hhq
  implements Runnable
{
  public hhq(String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = OfflineSecurity.a(this.a, this.b);
    Message localMessage = OfflineSecurity.a.obtainMessage();
    localMessage.obj = Boolean.valueOf(bool);
    OfflineSecurity.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */