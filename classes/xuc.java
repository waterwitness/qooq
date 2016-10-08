import android.view.animation.Interpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.ListView;

public class xuc
  implements Interpolator
{
  private xuc(ListView paramListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public float getInterpolation(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */