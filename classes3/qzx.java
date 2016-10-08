import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qzx
  implements View.OnClickListener
{
  public qzx(IphonePickerView paramIphonePickerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */