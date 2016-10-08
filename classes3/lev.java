import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class lev
  extends Handler
{
  public lev(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.s == 1) || (this.a.s == 2)))
    {
      this.a.b();
      QQToast.a(this.a, 2131371451, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */