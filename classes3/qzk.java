import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class qzk
  implements IphonePickerView.PickerViewAdapter
{
  public qzk(LocationSelectActivity paramLocationSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.a.j;
  }
  
  public int a(int paramInt)
  {
    if (this.a.a[paramInt] != null) {
      return ((List)this.a.a[paramInt]).size();
    }
    return 0;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.a.a[paramInt1] != null)
      {
        if (((BaseAddress)((List)this.a.a[paramInt1]).get(paramInt2)).b.equals("0")) {
          return "----";
        }
        String str = ((BaseAddress)((List)this.a.a[paramInt1]).get(paramInt2)).a;
        return str;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(LocationSelectActivity.a(), 2, "", localIndexOutOfBoundsException);
      }
    }
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */