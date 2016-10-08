import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class wqj
  implements Runnable
{
  public wqj(BindGroupActivity paramBindGroupActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId timeout.");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c = true;
    this.a.b.hide();
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */