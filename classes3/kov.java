import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kov
  implements Runnable
{
  public kov(BaseChatPie paramBaseChatPie, FrameLayout paramFrameLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */