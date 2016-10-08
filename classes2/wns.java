import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProgressPieDrawable;

public class wns
  extends Handler
{
  public int a;
  
  public wns(ProgressPieDrawable paramProgressPieDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.isVisible())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.k = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.k > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.k - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.n);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.k < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.k + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.r;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.n);
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.e(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */