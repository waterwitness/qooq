import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class igt
  extends LruCache
{
  public igt(OneObjectCacheList paramOneObjectCacheList, int paramInt)
  {
    super(paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject, Copyable paramCopyable1, Copyable paramCopyable2)
  {
    SLog.b("OneObjectCacheList", String.format("insert data %s %s to second cache", new Object[] { paramObject, paramCopyable1 }));
    this.a.a.put(paramObject, new WeakReference(paramCopyable1));
    OneObjectCacheList.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */