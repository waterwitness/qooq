import android.os.Vibrator;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsDragGridView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spm
  implements Runnable
{
  public spm(FreshNewsDragGridView paramFreshNewsDragGridView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FreshNewsDragGridView.a(this.a, true);
    FreshNewsDragGridView.a(this.a).vibrate(50L);
    FreshNewsDragGridView.a(this.a).setVisibility(4);
    FreshNewsDragGridView.a(this.a, FreshNewsDragGridView.a(this.a), FreshNewsDragGridView.a(this.a), FreshNewsDragGridView.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */