import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Calendar;
import java.util.List;
import mqq.os.MqqHandler;

public class qar
  implements Runnable
{
  public qar(MessageRoamManager paramMessageRoamManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    int j = this.jdField_a_of_type_Int;
    int i = 8;
    while (j < MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).size())
    {
      ((Calendar)localObject).setTimeInMillis(((Long)MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).get(j)).longValue());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)localObject);
      Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a((Calendar)((Calendar)localObject).clone());
      int k = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager), ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      if (i - k <= 0) {
        break;
      }
      j += 1;
      i -= k;
    }
    localObject = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a(ChatHistoryForC2C.class);
    ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(0), 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */