import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pnk
  implements Runnable
{
  public pnk(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    QQAVFunnyFaceInvest.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */