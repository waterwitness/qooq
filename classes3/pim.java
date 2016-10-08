import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pim
  extends Handler
{
  public pim(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
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
        TroopMemberListInnerFrame.a(this.a, paramMessage);
        return;
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Double += TroopMemberListInnerFrame.jdField_b_of_type_Double;
      } while ((this.a.jdField_a_of_type_Double >= 90.0D) || (this.a.c <= 0));
      if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.a.jdField_a_of_type_Double);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf(Math.min((int)(this.a.c * this.a.jdField_a_of_type_Double / 100.0D), this.a.c)), Integer.valueOf(this.a.c) }));
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4), 800L);
      return;
      TroopMemberListInnerFrame.a(this.a, paramMessage.arg1);
      TroopMemberListInnerFrame localTroopMemberListInnerFrame = this.a;
      localTroopMemberListInnerFrame.jdField_d_of_type_Int -= 1;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame", 2, "handleMessage mJobCount: " + this.a.jdField_d_of_type_Int);
      }
    } while (this.a.jdField_d_of_type_Int > 0);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    paramMessage.obj = TroopMemberListInnerFrame.a(this.a);
    TroopMemberListInnerFrame.a(this.a, paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */