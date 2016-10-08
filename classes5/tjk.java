import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback;
import java.util.ArrayList;

public class tjk
  implements ShowTagNamePopupWindow.IShowTagNamePopupWindowCallback
{
  public tjk(ChooseInterestTagActivity paramChooseInterestTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong)
  {
    int i = 0;
    while (i < ChooseInterestTagActivity.a(this.a).getChildCount())
    {
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)ChooseInterestTagActivity.a(this.a).getChildAt(i).getTag();
      if ((localInterestTagInfo != null) && (paramLong == localInterestTagInfo.tagId))
      {
        ChooseInterestTagActivity.a(this.a).remove(localInterestTagInfo);
        ChooseInterestTagActivity.a(this.a, localInterestTagInfo);
        ChooseInterestTagActivity.b(this.a, localInterestTagInfo);
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */