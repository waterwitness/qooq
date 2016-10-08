import android.view.View;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mpn
  implements ActionSheet.OnButtonClickListener
{
  public mpn(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a.a(2, 2131369008, 1500);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
      while (paramInt != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.app.a(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
        break;
        paramInt = 1;
        continue;
        paramInt = 4;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopAssistantActivity", 2, paramView.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */