import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.vas.SigTlpGridViewAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;

public class uig
  implements AdapterView.OnItemClickListener
{
  public uig(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (SignatureManager)this.a.app.getManager(57);
    int i = paramView.e;
    this.a.a(paramView.g, paramInt);
    paramAdapterView = (SigTlpGridViewAdapter)paramAdapterView.a();
    paramAdapterView.b = paramInt;
    paramAdapterView.notifyDataSetChanged();
    if (i != paramView.g) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < EditActivity.a(this.a).getChildCount())
      {
        paramAdapterView = (SigTlpGridViewAdapter)((GridView)EditActivity.a(this.a).getChildAt(paramInt)).a();
        if (paramAdapterView.a == i)
        {
          paramAdapterView.b = -1;
          paramAdapterView.notifyDataSetChanged();
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */