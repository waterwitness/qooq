import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.PstnSmallScreenService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.qphone.base.util.QLog;

public class gnz
  extends PstnObserver
{
  public gnz(PstnSmallScreenService paramPstnSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PstnSmallScreenService", 2, " callId = " + paramString + "time = " + paramInt);
    }
    this.a.a().removeCallbacks(this.a.c);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131364012);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = 2;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g = true;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */