import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class riz
  implements EmojiIPCAlarmer.TimeoutObserver
{
  public riz(WebIPCOperator paramWebIPCOperator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    rjb localrjb = this.a.a(paramInt);
    if (localrjb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localrjb.a.putBundle("response", localBundle);
      this.a.a(new rja(this, localrjb));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\riz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */