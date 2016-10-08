import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hgx
  implements AsyncBack
{
  public hgx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (HtmlOffline.a.a())) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */