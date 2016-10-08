import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.os.MqqHandler;

class qok
  implements Runnable
{
  qok(qoj paramqoj, long paramLong, int paramInt, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Qoj.a.a(this.jdField_a_of_type_JavaLangString, (Calendar)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int)) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_Qoj.a.b.a(ChatHistoryForC2C.class);
    } while (localObject == null);
    Message localMessage = ((MqqHandler)localObject).obtainMessage(0);
    localMessage.obj = Long.valueOf(this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    localMessage.arg1 = i;
    ((MqqHandler)localObject).sendMessageDelayed(localMessage, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */