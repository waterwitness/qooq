import android.text.Editable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class kob
  implements Runnable
{
  public kob(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if ((BaseChatPie.e(this.a) == i) && (BaseChatPie.b(this.a) != 1)) {
      BaseChatPie.f(this.a);
    }
    while (BaseChatPie.a(this.a) <= BaseChatPie.g(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendMsgSignal();
      BaseChatPie.h(this.a);
      ThreadManager.b().postDelayed(BaseChatPie.a(this.a), 2000L);
      return;
      BaseChatPie.c(this.a, i);
      BaseChatPie.d(this.a, 0);
    }
    BaseChatPie.c(this.a, false);
    BaseChatPie.e(this.a, 50);
    BaseChatPie.d(this.a, 0);
    BaseChatPie.f(this.a, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */