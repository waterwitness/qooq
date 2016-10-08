import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class gdo
  implements IphonePickerView.PickerViewAdapter
{
  private gdo(CreateArrageActivity paramCreateArrageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
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
      return b();
    case 1: 
      return 24;
    }
    return 60 / CreateArrageActivity.f(this.a);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      localCalendar.set(6, paramInt2 + 1);
      if (CreateArrageActivity.a(this.a) == null) {
        CreateArrageActivity.a(this.a, new SimpleDateFormat("yyyy-MM-dd"));
      }
      return CreateArrageActivity.a(this.a).format(localCalendar.getTime());
    case 1: 
      return paramInt2 + "点";
    }
    return CreateArrageActivity.f(this.a) * paramInt2 + "分";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */