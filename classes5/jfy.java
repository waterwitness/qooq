import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.ui.PopupMenuPA;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class jfy
  implements ViewPager.OnPageChangeListener
{
  public jfy(PopupMenuPA paramPopupMenuPA, RadioGroup paramRadioGroup, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ((RadioButton)this.jdField_a_of_type_AndroidWidgetRadioGroup.getChildAt(paramInt)).setChecked(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005ECF", "0X8005ECF", 0, 0, this.jdField_a_of_type_ComTencentBizUiPopupMenuPA.a, String.valueOf(paramInt + 1), "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */