import android.view.View;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mel
  implements ActionSheet.OnButtonClickListener
{
  public mel(QQMapActivity paramQQMapActivity, ActionSheet paramActionSheet)
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
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.o();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */