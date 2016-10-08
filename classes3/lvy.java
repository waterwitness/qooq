import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lvy
  implements IphonePickerView.PickerViewAdapter
{
  public lvy(NearPeopleFilterActivity paramNearPeopleFilterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (this.a.j == 0) {
      return NearPeopleFilterActivity.NearPeopleFilters.a.length;
    }
    if (this.a.j == 2) {
      return NearPeopleFilterActivity.NearPeopleFilters.b.length;
    }
    return NearPeopleFilterActivity.NearPeopleFilters.c.length;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.a.j == 0) {
      return NearPeopleFilterActivity.NearPeopleFilters.a[paramInt2];
    }
    if (this.a.j == 2) {
      return NearPeopleFilterActivity.NearPeopleFilters.b[paramInt2];
    }
    return NearPeopleFilterActivity.NearPeopleFilters.c[paramInt2];
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */