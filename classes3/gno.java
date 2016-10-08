import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class gno
  implements ConditionSearchManager.IConfigListener
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public gno(gnq paramgnq, ConditionSearchManager paramConditionSearchManager, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramgnq);
    this.b = new WeakReference(paramConditionSearchManager);
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ConditionSearchManager)this.b.get();
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this);
    }
    localObject = (gnq)this.a.get();
    IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)this.c.get();
    if ((localObject != null) && (localIQQServiceLocationCallback != null)) {
      ((gnq)localObject).a(paramBoolean, localIQQServiceLocationCallback);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */