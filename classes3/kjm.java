import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class kjm
  implements DialogInterface.OnClickListener
{
  public kjm(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.a()).longValue();
      this.a.showDialog(2);
      this.a.a.a(l, Long.valueOf(AddRequestActivity.a(this.a)).longValue(), 1);
      return;
    }
    QQToast.a(this.a, 2131369008, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */