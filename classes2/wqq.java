import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class wqq
  implements Runnable
{
  public wqq(BindGroupConfirmActivity paramBindGroupConfirmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */