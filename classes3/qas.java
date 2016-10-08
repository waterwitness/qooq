import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class qas
  implements Runnable
{
  public qas(MessageRoamManager paramMessageRoamManager, Calendar paramCalendar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone());
    int i = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager), ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    if (i >= 8)
    {
      localObject = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a(ChatHistoryForC2C.class);
      ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(0), 0L);
      return;
    }
    MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a(MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager), (Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone(), true, 8 - i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */