import android.view.View;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oun
  implements Runnable
{
  public oun(QzoneHbFragment paramQzoneHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QzoneHbFragment.a(this.a).startAnimation(QzoneHbFragment.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */