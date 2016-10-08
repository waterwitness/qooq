import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class guk
{
  private guk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  @JavascriptInterface
  public int a()
  {
    return ImmersiveUtils.isSupporImmersive();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */