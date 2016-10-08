import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class wjz
  extends LruCache
{
  public wjz(WebSoService paramWebSoService, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected WebSoService.WebSoState a(String paramString)
  {
    return new WebSoService.WebSoState();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */