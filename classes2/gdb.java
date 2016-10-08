import android.text.TextPaint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Calendar;

public class gdb
  implements IphonePickerView.IphonePickListener
{
  public int a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public int c;
  
  public gdb(AVMeetingActivity paramAVMeetingActivity, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298967));
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  long a(boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    int i = localCalendar.get(1);
    localCalendar.setTimeInMillis(0L);
    localCalendar.set(1, i);
    if (paramBoolean) {
      localCalendar.set(6, this.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.q);
    }
    for (;;)
    {
      localCalendar.set(11, this.b);
      localCalendar.set(12, this.c * AVMeetingActivity.jdField_a_of_type_Int);
      localCalendar.set(13, 0);
      return localCalendar.getTimeInMillis();
      localCalendar.set(6, this.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.r);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l;
    switch (paramInt1)
    {
    default: 
      l = a(this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(l));
        if (!this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag().toString().equals("begin_time")) {
          break label285;
        }
        this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_b_of_type_Gdb.a(l + 3660000L, false);
        label105:
        if (!this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_Long)) {
          break label297;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(16);
        label134:
        if ((this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_Long < this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_b_of_type_Long))) {
          break label311;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(16);
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)
      {
        View localView = this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
        if ((localView != null) && (localView.getVisibility() == 4)) {
          localView.setVisibility(0);
        }
        localView = this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
        if ((localView != null) && (localView.getVisibility() == 4)) {
          localView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      }
      return;
      this.jdField_a_of_type_Int = paramInt2;
      break;
      this.b = paramInt2;
      break;
      this.c = paramInt2;
      break;
      label285:
      this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_b_of_type_Long = l;
      break label105;
      label297:
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(0);
      break label134;
      label311:
      this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFlags(0);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      this.b = localCalendar.get(11);
      this.c = (localCalendar.get(12) / AVMeetingActivity.jdField_a_of_type_Int);
      if ((!paramBoolean) || (!this.jdField_a_of_type_Boolean)) {
        break;
      }
      a(0, 0);
      this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(1, this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(paramLong, true);
      } else {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.a(paramLong, false);
      }
    }
    a(2, this.c);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */