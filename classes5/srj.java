import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class srj
  extends FreshNewsObserver
{
  public srj(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshnewsFragment onDeleteFeed isSuccess=" + paramBoolean + ",feedid=" + paramString1 + ",errTip=" + paramString2);
    }
    if ((!MyFreshNewsFragment.d(this.a)) || (!MyFreshNewsFragment.a(this.a))) {}
    do
    {
      return;
      if (MyFreshNewsFragment.a(this.a) != null) {
        MyFreshNewsFragment.a(this.a).e();
      }
      if (!paramBoolean)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "删除失败";
        }
        this.a.a(1, paramString1, 0L);
        return;
      }
    } while (MyFreshNewsFragment.a(this.a) == null);
    MyFreshNewsFragment.a(this.a).a(paramString1);
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyFreshNewsFragment", 2, "MyFreshnewsFragment onPublishComment isSuccess=" + paramBoolean + ",feedid=" + paramString1 + ",errTip=" + paramString2);
    }
    if (MyFreshNewsFragment.a(this.a) != null) {
      MyFreshNewsFragment.a(this.a).e();
    }
    if (!MyFreshNewsFragment.d(this.a)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = "评论失败";
          }
          this.a.a(1, paramString1, 0L);
          return;
        }
      } while (MyFreshNewsFragment.a(this.a) == null);
      paramString1 = MyFreshNewsFragment.a(this.a).a(paramString1);
    } while ((paramString1 == null) || (!(paramString1 instanceof FNDefaultItemData)));
    paramString1 = (FNDefaultItemData)paramString1;
    paramString1.h = paramInt1;
    MyFreshNewsFragment.a(this.a).a(paramString1);
  }
  
  public void a(boolean paramBoolean1, String paramString, byte[] paramArrayOfByte, List paramList, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetUserFreshNews() isSuccess=").append(paramBoolean1).append(", errTip=").append(paramString).append(", cookie=").append(paramArrayOfByte).append(", list.size()=");
      if (paramList == null)
      {
        paramArrayOfByte = "null";
        QLog.d("MyFreshNewsFragment", 2, paramArrayOfByte + ",complete=" + paramBoolean2);
      }
    }
    else
    {
      if ((!MyFreshNewsFragment.a(this.a)) && (this.a.a != null)) {
        this.a.a.e();
      }
      MyFreshNewsFragment.b(this.a, false);
      MyFreshNewsFragment.a(this.a).H();
      MyFreshNewsFragment.a(this.a, false);
      if (paramBoolean1) {
        break label249;
      }
      if ((this.a.a != null) || (this.a.getActivity() != null)) {
        if (this.a.a == null) {
          break label238;
        }
      }
    }
    label238:
    for (paramArrayOfByte = this.a.a;; paramArrayOfByte = this.a.getActivity())
    {
      paramList = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramList = "加载失败";
      }
      QQToast.a(paramArrayOfByte, paramList, 1).b(paramArrayOfByte.getTitleBarHeight());
      return;
      paramArrayOfByte = paramList.size() + "";
      break;
    }
    label249:
    if (paramBoolean3)
    {
      MyFreshNewsFragment.a(this.a, System.currentTimeMillis());
      if (!MyFreshNewsFragment.a(this.a)) {
        break label301;
      }
      MyFreshNewsFragment.a(this.a).e(MyFreshNewsFragment.a(this.a));
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      label301:
      MyFreshNewsFragment.a(this.a).f(MyFreshNewsFragment.a(this.a));
      if (MyFreshNewsFragment.c(this.a)) {
        if (MyFreshNewsFragment.b(this.a) > 0L) {
          MyFreshNewsFragment.a(this.a).a(Long.valueOf(MyFreshNewsFragment.b(this.a)), paramList);
        } else {
          MyFreshNewsFragment.a(this.a).a(Long.valueOf(Long.parseLong(MyFreshNewsFragment.a(this.a))), paramList);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */