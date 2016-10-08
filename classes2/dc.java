import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dc
  implements View.OnClickListener
{
  public dc(DLRouterSessionListAdapter paramDLRouterSessionListAdapter, long paramLong, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (2131305420 == paramView.getId()) {
      i = 11;
    }
    for (;;)
    {
      if ((i != 0) && (i > 0))
      {
        paramView = new dd(this, i);
        de localde = new de(this);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362133), this.jdField_a_of_type_AndroidContentContext.getString(2131362159), 2131367262, 2131362134, paramView, localde).show();
      }
      return;
      if (2131305401 == paramView.getId()) {
        i = 10;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */