import android.view.View;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;

public class mls
  implements ActionSheet.OnButtonClickListener
{
  public mls(SoundAndVibrateActivity paramSoundAndVibrateActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) && (paramInt >= SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).size())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(paramInt);
      SoundAndVibrateActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity, paramInt);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */