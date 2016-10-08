import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dx
  implements View.OnClickListener
{
  public dx(RouterSessionAdapter paramRouterSessionAdapter, RouterMsgRecord paramRouterMsgRecord, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (2131305406 == paramView.getId())
    {
      paramView = new dy(this);
      dz localdz = new dz(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362133), this.jdField_a_of_type_AndroidContentContext.getString(2131362159), 2131367262, 2131362134, paramView, localdz).show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */