import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;

class pnf
  implements Runnable
{
  pnf(pnb parampnb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQAVFunnyFaceInvest.a(this.a.a.a)) {
      return;
    }
    AudioUtil.a(2131165187, 1, null, null);
    this.a.a.a.b.setImageResource(2130839126);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */