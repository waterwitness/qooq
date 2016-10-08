import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lqc
  implements Runnable
{
  public lqc(JumpActivity paramJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    JumpActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */