import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kjq
  implements ActionSheet.OnButtonClickListener
{
  public kjq(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet)
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.a()).longValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.a(l, Long.valueOf(AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity)).longValue(), 1);
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131369008, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */