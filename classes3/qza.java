import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class qza
  extends Handler
{
  public qza(ConditionSearchFriendActivity paramConditionSearchFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.n == 1) || (this.a.n == 2)))
    {
      this.a.a();
      QQToast.a(this.a, 2131371451, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */