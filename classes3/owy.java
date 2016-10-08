import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.GuideViewBuilder;

public class owy
  implements View.OnClickListener
{
  public owy(RecentCallHelper paramRecentCallHelper, GuideViewBuilder paramGuideViewBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGuideViewBuilder.a();
    RecentCallHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */