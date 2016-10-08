import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class tzv
  implements AdapterView.OnItemClickListener
{
  public tzv(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = PhoneContactHelper.a(((TextView)paramView.findViewById(2131301418)).getText().toString());
    this.a.a(this.a.getActivity(), paramAdapterView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */