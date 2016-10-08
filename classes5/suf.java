import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class suf
  implements Runnable
{
  public suf(HotChatPttStageControl paramHotChatPttStageControl, List paramList, PttShowRoomMng paramPttShowRoomMng)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng.a(localMessageForPtt);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */