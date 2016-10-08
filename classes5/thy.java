import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;

public final class thy
  implements Runnable
{
  public thy(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NearbyProcessMonitor.b(this.a);
    NearbyProcessMonitor.a(this.a);
    NearbyProcessMonitor.h += 1;
    NearbySPUtil.a(this.a);
    NearbyProcessMonitor.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */