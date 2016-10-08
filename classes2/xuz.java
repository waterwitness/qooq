import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TCWDatePicker;
import com.tencent.widget.TCWNumberPicker;
import com.tencent.widget.TCWNumberPicker.OnChangedListener;
import java.util.Calendar;

public class xuz
  implements TCWNumberPicker.OnChangedListener
{
  public xuz(TCWDatePicker paramTCWDatePicker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(TCWNumberPicker paramTCWNumberPicker, int paramInt1, int paramInt2)
  {
    TCWDatePicker.b(this.a).setTimeInMillis(TCWDatePicker.a(this.a).getTimeInMillis());
    int i;
    if (paramTCWNumberPicker == TCWDatePicker.a(this.a))
    {
      i = TCWDatePicker.b(this.a).getActualMaximum(5);
      if ((paramInt1 == i) && (paramInt2 == 1)) {
        TCWDatePicker.b(this.a).add(5, 1);
      }
    }
    for (;;)
    {
      TCWDatePicker.a(this.a, TCWDatePicker.b(this.a).get(1), TCWDatePicker.b(this.a).get(2), TCWDatePicker.b(this.a).get(5));
      TCWDatePicker.b(this.a);
      TCWDatePicker.c(this.a);
      return;
      if ((paramInt1 == 1) && (paramInt2 == i))
      {
        TCWDatePicker.b(this.a).add(5, -1);
      }
      else
      {
        TCWDatePicker.b(this.a).add(5, paramInt2 - paramInt1);
        continue;
        if (paramTCWNumberPicker == TCWDatePicker.b(this.a))
        {
          TCWDatePicker.a(this.a);
          if ((paramInt1 == 11) && (paramInt2 == 0)) {
            TCWDatePicker.b(this.a).add(2, 1);
          } else if ((paramInt1 == 0) && (paramInt2 == 11)) {
            TCWDatePicker.b(this.a).add(2, -1);
          } else {
            TCWDatePicker.b(this.a).add(2, paramInt2 - paramInt1);
          }
        }
        else if (paramTCWNumberPicker == TCWDatePicker.c(this.a))
        {
          TCWDatePicker.b(this.a).set(1, paramInt2);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */