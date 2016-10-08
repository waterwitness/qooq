import android.graphics.Bitmap;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.Callable;

public class qun
  implements Callable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public qun(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public Bitmap a()
  {
    Process.setThreadPriority(10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false, this.jdField_a_of_type_Int);
    QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap == null) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b;
    }
    long l1 = SystemClock.uptimeMillis();
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.jdField_a_of_type_Quj.obtainMessage();
    long l2 = SystemClock.uptimeMillis();
    localMessage.obj = Long.valueOf(Long.valueOf(Math.max(this.jdField_a_of_type_Long - l1, 0L)).longValue() + l2);
    localMessage.sendToTarget();
    return this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */