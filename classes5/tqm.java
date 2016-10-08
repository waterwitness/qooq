import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.smooth.ItemManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class tqm
  implements AdapterView.OnItemSelectedListener
{
  private tqm(ItemManager paramItemManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.a.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.a(paramAdapterView);
    }
  }
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.d != 0)
    {
      this.a.d = 0;
      this.a.b();
    }
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.a.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.b(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */