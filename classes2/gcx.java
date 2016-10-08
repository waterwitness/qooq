import android.os.Handler;
import android.os.Message;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.MyGridView;

public class gcx
  extends Handler
{
  public gcx(AVMeetingActivity paramAVMeetingActivity)
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
      return;
    } while (this.a.jdField_a_of_type_JavaUtilList == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.a.b, 0, this.a.c, this.a.e);
    this.a.jdField_a_of_type_Gdd.notifyDataSetChanged();
    removeMessages(1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */