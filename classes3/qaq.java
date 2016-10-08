import android.database.SQLException;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class qaq
  implements Runnable
{
  public qaq(MessageRoamManager paramMessageRoamManager, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {}
    for (long l1 = SystemClock.uptimeMillis();; l1 = 0L)
    {
      MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a().c();
      MqqHandler localMqqHandler = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a(ChatHistoryForC2C.class);
      ArrayList localArrayList;
      try
      {
        List localList1 = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager, this.jdField_a_of_type_JavaLangString, this.b, this.c);
        if (localList1 == null) {
          break label279;
        }
        localObject2 = localMqqHandler.obtainMessage(22);
        localArrayList = new ArrayList(localList1.size());
        Iterator localIterator = localList1.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((ChatMessage)localIterator.next());
        }
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          List localList2 = ((MessageRecordEntityManager)MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a().createMessageRecordEntityManager()).a(MessageRecord.class, this.jdField_a_of_type_JavaLangString, false, this.c, null, null, null, null, null);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localException.printStackTrace();
            QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: ", localException);
          }
          Object localObject1 = null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
        }
      }
      do
      {
        return;
        ((Message)localObject2).obj = localArrayList;
        localMqqHandler.sendMessage((Message)localObject2);
      } while (!QLog.isColorLevel());
      long l2 = SystemClock.uptimeMillis();
      Object localObject2 = new StringBuilder().append("queryMessageByDayFromDB: costTime: ").append(l2 - l1).append(",records num: ");
      if (localOutOfMemoryError == null) {}
      for (int i = 0;; i = localOutOfMemoryError.size())
      {
        QLog.d("Q.roammsg.MessageRoamManager", 2, i);
        return;
        label279:
        localObject2 = localMqqHandler.obtainMessage(21);
        ((Message)localObject2).obj = null;
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */