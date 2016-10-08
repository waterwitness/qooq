import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;

public class tia
  implements IRNPreDownloadListener
{
  public tia(NearbyProxy paramNearbyProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    NearbyProxy.a(this.a, 4143, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) });
  }
  
  public void a(int paramInt)
  {
    NearbyProxy.a(this.a, 4143, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt), Long.valueOf(0L), Long.valueOf(0L) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    NearbyProxy.a(this.a, 4143, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */