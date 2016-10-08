import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;

public class let
  implements IphonePickerView.IphonePickListener
{
  public let(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.jdField_a_of_type_Boolean = true;
    DetailProfileActivity localDetailProfileActivity = this.a;
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      localDetailProfileActivity.a(paramInt1, true);
      DetailProfileActivity.a(this.a, true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\let.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */