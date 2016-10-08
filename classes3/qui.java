import android.graphics.Bitmap;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qui
  implements Runnable
{
  public qui(QQAnimationDrawable paramQQAnimationDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_b_of_type_Boolean = true;
    Process.setThreadPriority(10);
    Object localObject = this.a;
    QQAnimationDrawable localQQAnimationDrawable = this.a;
    Bitmap localBitmap = this.a.a(true, 0);
    localQQAnimationDrawable.jdField_b_of_type_AndroidGraphicsBitmap = localBitmap;
    ((QQAnimationDrawable)localObject).jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    QQAnimationDrawable.a(this.a, 1);
    if (this.a.jdField_a_of_type_Boolean)
    {
      localObject = this.a.jdField_a_of_type_Quj.obtainMessage();
      ((Message)localObject).obj = Integer.valueOf(0);
      ((Message)localObject).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */