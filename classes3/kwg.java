import android.database.Cursor;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kwg
  implements Runnable
{
  public kwg(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        ((Cursor)localObject3).getCount();
        localObject1 = localObject3;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        Object localObject2 = null;
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.obtainMessage(8);
    ((Message)localObject3).obj = localObject1;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.sendMessage((Message)localObject3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */