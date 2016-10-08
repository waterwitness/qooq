import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.util.Calendar;

public class gdn
  implements IphonePickerView.IphonePickListener
{
  public int a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public int b;
  public int c;
  
  public gdn(CreateArrageActivity paramCreateArrageActivity, FormSimpleItem paramFormSimpleItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = paramFormSimpleItem;
  }
  
  private long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    int i = localCalendar.get(1);
    localCalendar.setTimeInMillis(0L);
    localCalendar.set(1, i);
    localCalendar.set(6, this.jdField_a_of_type_Int + 1);
    localCalendar.set(11, this.b);
    localCalendar.set(12, this.c * CreateArrageActivity.f(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity));
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public void a()
  {
    CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l;
    switch (paramInt1)
    {
    default: 
      l = a();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, l));
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag().toString().equals("begin_time")) {
          break label231;
        }
        CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, l);
        CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).a(l + 3600000L);
        label97:
        if (!CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity))) {
          break label243;
        }
        CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).b().getPaint().setFlags(16);
        label132:
        if ((CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity) < CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity)) && (!CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity)))) {
          break label263;
        }
        CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).b().getPaint().setFlags(16);
      }
      break;
    }
    for (;;)
    {
      if (CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity) != null) {
        CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).a(2);
      }
      return;
      this.jdField_a_of_type_Int = paramInt2;
      break;
      this.b = paramInt2;
      break;
      this.c = paramInt2;
      break;
      label231:
      CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity, l);
      break label97;
      label243:
      CreateArrageActivity.a(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).b().getPaint().setFlags(0);
      break label132;
      label263:
      CreateArrageActivity.b(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity).b().getPaint().setFlags(0);
    }
  }
  
  public void a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    this.jdField_a_of_type_Int = (localCalendar.get(6) - 1);
    this.b = localCalendar.get(11);
    this.c = (localCalendar.get(12) / CreateArrageActivity.f(this.jdField_a_of_type_ComTencentArrangeUiCreateArrageActivity));
    a(2, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */