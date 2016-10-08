import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gxj
  implements Runnable
{
  public gxj(PSTNC2CActivity paramPSTNC2CActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.c.setText(this.a.getResources().getString(2131364009));
    this.a.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(1);
    this.a.a(this.a.b, false, 2130839044);
    this.a.b.setClickable(true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = 2;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */