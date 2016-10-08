import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.now.CgiHelper;
import com.tencent.biz.now.CgiHelper.cigHelperCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hke
  extends Handler
{
  public hke(CgiHelper paramCgiHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1001) && (CgiHelper.a(this.a) != null))
    {
      paramMessage = CgiHelper.a(this.a);
      if (TextUtils.isEmpty(CgiHelper.a(this.a))) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      paramMessage.a(bool, CgiHelper.b(this.a));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */