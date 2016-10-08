import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ProgressPieView;

public class xun
  extends Handler
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  
  public xun(ProgressPieView paramProgressPieView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    if (i < this.jdField_a_of_type_ComTencentWidgetProgressPieView.l)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(i);
      sendEmptyMessageDelayed(0, 1L);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_ComTencentWidgetProgressPieView.l);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */