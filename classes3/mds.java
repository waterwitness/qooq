import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class mds
  implements View.OnClickListener
{
  public mds(QQMapActivity paramQQMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      this.a.w();
      return;
    }
    if (NetworkUtil.b(this.a))
    {
      this.a.r();
      return;
    }
    DialogUtil.a(this.a, 230).setTitle(this.a.getString(2131370597)).setMessage(2131370596).setPositiveButton(2131370598, new mdu(this)).setNegativeButton(2131367262, new mdt(this)).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */