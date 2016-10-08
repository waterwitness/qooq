import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.FriendChooser;
import com.tencent.qphone.base.util.QLog;

public class wrb
  extends Handler
{
  public wrb(FriendChooser paramFriendChooser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "" + this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */