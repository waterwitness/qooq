import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import java.lang.ref.WeakReference;

public class ufz
  extends Handler
{
  final WeakReference a;
  
  public ufz(Looper paramLooper, RichmediaClient paramRichmediaClient)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramRichmediaClient);
  }
  
  public void handleMessage(Message paramMessage)
  {
    LOG.a("PTV.RichmediaClient", "handleMessage, msg.what = " + paramMessage.what);
    RichmediaClient localRichmediaClient = (RichmediaClient)this.a.get();
    if (localRichmediaClient == null) {}
    do
    {
      return;
      if (paramMessage.getData() != null) {
        paramMessage.getData().getInt("msg_sub_cmd");
      }
      switch (paramMessage.what)
      {
      case 1001: 
      default: 
        super.handleMessage(paramMessage);
        return;
      case 1000: 
        LOG.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
        return;
      }
      LOG.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    paramMessage = paramMessage.getString("vidoe_record_uniseq");
    localRichmediaClient.a().a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */