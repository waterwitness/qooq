import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DataReport;

public class ugg
  extends Handler
{
  public ugg(DCAIOPreview paramDCAIOPreview, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = DataReport.a();
    int j = DCAIOPreview.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      ugh localugh = (ugh)DCAIOPreview.a(this.a).valueAt(i);
      paramMessage.a(new ugy("Pic.AioPreview", localugh.a("Pic.AioPreview")));
      paramMessage.a(new ugy("Pic.AioPreview.Preload", localugh.a("Pic.AioPreview.Preload")));
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */