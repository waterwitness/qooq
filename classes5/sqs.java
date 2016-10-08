import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class sqs
  extends Handler
{
  public sqs(FreshNewsNotifyFragment paramFreshNewsNotifyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10: 
      FreshNewsNotifyFragment.a(this.a).H();
      QQToast.a(BaseApplication.getContext(), 1, 2131369008, 0).b(this.a.getActivity().getTitleBarHeight());
      return;
    case 11: 
      FreshNewsNotifyFragment.a(this.a).H();
      return;
    }
    FreshNewsNotifyFragment.a(this.a, false);
    if (FreshNewsNotifyFragment.a(this.a) != null)
    {
      int i = FreshNewsNotifyFragment.a(this.a).size();
      paramMessage = this.a;
      if (i == 100) {}
      for (;;)
      {
        FreshNewsNotifyFragment.b(paramMessage, bool);
        FreshNewsNotifyFragment.b(this.a, FreshNewsNotifyFragment.a(this.a));
        FreshNewsNotifyFragment.a(this.a).a().addAll(FreshNewsNotifyFragment.a(this.a));
        FreshNewsNotifyFragment.a(this.a).notifyDataSetChanged();
        FreshNewsNotifyFragment.a(this.a, null);
        return;
        bool = false;
      }
    }
    FreshNewsNotifyFragment.b(this.a, false);
    FreshNewsNotifyFragment.b(this.a, FreshNewsNotifyFragment.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */