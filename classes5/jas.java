import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jas
  extends Handler
{
  public jas(QRCardActivity paramQRCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_Boolean) || (!(paramMessage.obj instanceof Bitmap)));
      paramMessage = (Bitmap)paramMessage.obj;
    } while (paramMessage == null);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */