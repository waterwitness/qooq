import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ProgressPieView;

public class xum
  extends Handler
{
  int jdField_a_of_type_Int;
  public boolean a;
  
  public xum(ProgressPieView paramProgressPieView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView.m > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_ComTencentWidgetProgressPieView.m - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentWidgetProgressPieView.p);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetProgressPieView.m < this.jdField_a_of_type_Int)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetProgressPieView.m + this.jdField_a_of_type_ComTencentWidgetProgressPieView.q;
        if (i <= this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(i);
        }
        for (;;)
        {
          sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentWidgetProgressPieView.p);
          return;
          this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(this.jdField_a_of_type_Int);
        }
      }
      removeMessages(0);
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setShowImage(false);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.f = true;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */