import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsNotifyFragment;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class squ
  extends FreshNewsObserver
{
  public squ(FreshNewsNotifyFragment paramFreshNewsNotifyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, long paramLong, List paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetFreshNewsNotify() isSuccess=").append(paramBoolean).append(", errTip=").append(paramString).append(", maxEventId=").append(paramLong).append(", list.size()=");
      if (paramList == null)
      {
        paramString = "null";
        QLog.i("FreshNewsNotifyFragment", 2, paramString);
      }
    }
    else
    {
      FreshNewsNotifyFragment.a(this.a).H();
      FreshNewsNotifyFragment.a(this.a, false);
      if (paramBoolean) {
        break label150;
      }
      QQToast.a(this.a.getActivity(), "获取失败", 0).b(this.a.getActivity().getTitleBarHeight());
    }
    label150:
    while ((paramList == null) || (paramList.size() <= 0))
    {
      return;
      paramString = paramList.size() + "";
      break;
    }
    Collections.reverse(paramList);
    paramList.addAll(FreshNewsNotifyFragment.a(this.a).a());
    FreshNewsNotifyFragment.a(this.a).a(paramList, true);
    FreshNewsNotifyFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\squ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */