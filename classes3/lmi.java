import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StackBlur;

public class lmi
  implements Runnable
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public lmi(Handler paramHandler, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void run()
  {
    Object localObject = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.125F), (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.125F), true);
    StackBlur.a((Bitmap)localObject, 2);
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, localObject);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */