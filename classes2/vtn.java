import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.ScaleGallery;
import com.tencent.qphone.base.util.QLog;

public class vtn
  extends Handler
{
  public vtn(ScaleGallery paramScaleGallery)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      if (paramMessage.what == 0)
      {
        this.a.a();
        return;
      }
      if (paramMessage.what == 1)
      {
        this.a.b();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      removeCallbacksAndMessages(null);
      this.a.setSelection(this.a.d);
      if (QLog.isColorLevel()) {
        QLog.e("ScaleGallery", 2, "handleMessage:" + paramMessage.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */