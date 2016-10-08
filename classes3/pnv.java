import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pnv
  implements Runnable
{
  public pnv(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((3 == QQAVFunnyFaceInvest.a(this.a)) && (this.a.e.getVisibility() == 0))
    {
      QLog.e(QQAVFunnyFaceInvest.a, 1, "ShowSlide4UserSelectActionWithDely enter");
      QQAVFunnyFaceInvest.a(this.a, this.a.c);
      QQAVFunnyFaceInvest.a(this.a, this.a.e);
      QQAVFunnyFaceInvest.f(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */