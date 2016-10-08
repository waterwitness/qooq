import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class srh
  extends Handler
{
  public srh(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      MyFreshNewsFragment.a(this.a).H();
      MyFreshNewsFragment.a(this.a, false);
      QQToast.a(BaseApplication.getContext(), 1, 2131369008, 0).b(this.a.getActivity().getTitleBarHeight());
      return;
      MyFreshNewsFragment.a(this.a).H();
      ((MyFreshNewsActivity)this.a.getActivity()).b(false);
      return;
      List localList = (List)paramMessage.obj;
      if (MyFreshNewsFragment.a(this.a) != null) {
        MyFreshNewsFragment.a(this.a).a(localList);
      }
      if ((localList == null) || (localList.size() <= 0))
      {
        MyFreshNewsFragment.a(this.a).setVisibility(8);
        MyFreshNewsFragment.b(this.a).setVisibility(8);
      }
      while (MyFreshNewsFragment.b(this.a))
      {
        MyFreshNewsFragment.a(this.a, false);
        this.a.a(null);
        return;
        if (paramMessage.arg1 == 1)
        {
          MyFreshNewsFragment.a(this.a).setVisibility(0);
          MyFreshNewsFragment.b(this.a).setVisibility(8);
        }
        else
        {
          MyFreshNewsFragment.a(this.a).setVisibility(8);
          MyFreshNewsFragment.b(this.a).setVisibility(0);
        }
      }
      continue;
      if (paramMessage.arg1 == 0) {}
      for (int i = 0; (paramMessage.obj instanceof String); i = paramMessage.arg1)
      {
        paramMessage = (String)paramMessage.obj;
        QQToast.a(BaseApplication.getContext(), i, paramMessage, 0).b(this.a.a.getTitleBarHeight());
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */