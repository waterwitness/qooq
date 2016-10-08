import android.support.v4.util.LruCache;
import com.rookery.translate.model.TransMemCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gco
  extends LruCache
{
  public gco(TransMemCache paramTransMemCache, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */