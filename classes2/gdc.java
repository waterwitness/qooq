import android.content.res.Resources;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class gdc
  implements IphonePickerView.PickerViewAdapter
{
  boolean jdField_a_of_type_Boolean;
  
  public gdc(AVMeetingActivity paramAVMeetingActivity, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(6, 1);
    localCalendar.roll(6, -1);
    return localCalendar.get(6);
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 730;
    case 1: 
      return 24;
    }
    return 60 / AVMeetingActivity.jdField_a_of_type_Int;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      if (this.jdField_a_of_type_Boolean)
      {
        if (paramInt2 == 0) {
          return this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.getResources().getString(2131363979);
        }
        localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        localCalendar.set(6, this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.q + paramInt2);
        if (this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat == null) {
          this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        return this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime());
      }
      if (paramInt2 == 0) {
        return this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.getResources().getString(2131363979);
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      localCalendar.set(6, this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.r + paramInt2);
      if (this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat == null) {
        this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      }
      return this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.jdField_a_of_type_JavaTextSimpleDateFormat.format(localCalendar.getTime());
    case 1: 
      return paramInt2 + this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.getResources().getString(2131363981);
    }
    return AVMeetingActivity.jdField_a_of_type_Int * paramInt2 + this.jdField_a_of_type_ComTencentArrangeUiAVMeetingActivity.getResources().getString(2131363982);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */