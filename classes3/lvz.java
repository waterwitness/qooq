import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.ActionSheet;

public class lvz
  implements IphonePickerView.IphonePickListener
{
  public lvz(NearPeopleFilterActivity paramNearPeopleFilterActivity)
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
    if (this.a.j == 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.a[paramInt2]);
      this.a.jdField_c_of_type_Int = paramInt2;
    }
    do
    {
      return;
      if (this.a.j == 1)
      {
        this.a.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.c[paramInt2]);
        this.a.e = paramInt2;
        return;
      }
    } while (this.a.j != 2);
    this.a.b.setRightText(com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.b[paramInt2]);
    this.a.d = paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */