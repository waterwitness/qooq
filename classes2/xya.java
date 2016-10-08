import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import common.qzone.component.cache.common.ExtendLruCache;

public class xya
  extends LruCache
{
  public xya(ExtendLruCache paramExtendLruCache, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object create(Object paramObject)
  {
    return this.a.c(paramObject);
  }
  
  protected void entryRemoved(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    this.a.a(paramBoolean, paramObject1, paramObject2, paramObject3);
  }
  
  protected int sizeOf(Object paramObject1, Object paramObject2)
  {
    return this.a.a(paramObject1, paramObject2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */