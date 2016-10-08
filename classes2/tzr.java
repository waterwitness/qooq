import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.qcall.QCallDetailActivity;

public class tzr
  implements Runnable
{
  public tzr(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QCallDetailActivity.a(this.a, CLJumpLightalkConfig.a(this.a.app.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */