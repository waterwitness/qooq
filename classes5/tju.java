import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.util.InputMethodUtil;

public class tju
  implements AbsListView.OnScrollListener
{
  public tju(ChooseInterestTagActivity paramChooseInterestTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */