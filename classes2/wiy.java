import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import mqq.os.MqqHandler;

public class wiy
  implements URLDrawable.URLDrawableListener
{
  public wiy(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SwiftBrowserTBSHandler.a(this.a).sendMessage(SwiftBrowserTBSHandler.a(this.a).obtainMessage(103, paramURLDrawable));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wiy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */