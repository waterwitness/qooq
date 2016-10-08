import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tjd
  implements ActionSheet.OnButtonClickListener
{
  public tjd(NearbyGuideActivity paramNearbyGuideActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity.h();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGuideNearbyGuideActivity.i();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */