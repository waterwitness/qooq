import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class vxs
  extends WeakReference
{
  private final String a;
  
  public vxs(String paramString, Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vxs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */