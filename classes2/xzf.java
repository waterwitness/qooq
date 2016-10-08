import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.c2b.C2BTakePhotoActivity;

public class xzf
  implements ActionSheet.OnButtonClickListener
{
  public xzf(C2BTakePhotoActivity paramC2BTakePhotoActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      if (this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.b) {
        this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.d();
      }
      this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.j();
      continue;
      if (this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.b) {
        this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.d();
      }
      this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */