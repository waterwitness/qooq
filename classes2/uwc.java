import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class uwc
  implements View.OnClickListener
{
  public uwc(StructMsgItemLayout12 paramStructMsgItemLayout12)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {
      this.a.a = new Handler(this.a);
    }
    if ((this.a.d) || (this.a.a.hasMessages(0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgItemLayout12", 2, "anim is playing");
      }
      return;
    }
    paramView = new WeakReference(paramView.getContext());
    paramView = this.a.a.obtainMessage(0, paramView);
    this.a.a.sendMessageDelayed(paramView, 100L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */