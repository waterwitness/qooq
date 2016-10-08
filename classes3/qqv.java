import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayOutputStream;

public final class qqv
  implements INetEngine.INetEngineListener
{
  public qqv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.e == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (paramNetResp.a.a != null)
      {
        paramNetResp = new String(((ByteArrayOutputStream)paramNetResp.a.a).toByteArray());
        Log.d("ArkApp.DataReport", "report_realtime_monitor, reply=" + paramNetResp);
      }
      return;
    }
    Log.d("ArkApp.DataReport", "report_realtime_monitor, fail");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */