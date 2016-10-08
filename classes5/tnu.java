import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import java.util.Calendar;

public class tnu
  implements IphonePickerView.PickerViewAdapter
{
  public tnu(NearbyProfileEditPanel paramNearbyProfileEditPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
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
      return this.a.e - 1896 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.a.h + 1896);
    localCalendar.set(2, this.a.i);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1896 + "年";
    case 1: 
      return paramInt2 + 1 + "月";
    }
    return paramInt2 + 1 + "日";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */