import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoCgiService;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;

public class wjy
  extends LruCache
{
  public wjy(WebSoCgiService paramWebSoCgiService, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected WebSoCgiService.WebSoCgiState a(String paramString)
  {
    return new WebSoCgiService.WebSoCgiState();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */