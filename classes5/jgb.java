import android.os.Handler;
import android.os.Message;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jgb
  extends Handler
{
  public jgb(RefreshView paramRefreshView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */