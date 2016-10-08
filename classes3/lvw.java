import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class lvw
  extends Handler
{
  public lvw(NearPeopleFilterActivity paramNearPeopleFilterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.a.c();
      QQToast.a(BaseApplication.getContext(), 2131371451, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */