import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public final class ksd
  implements Runnable
{
  public ksd(Emoticon paramEmoticon, EmoticonManager paramEmoticonManager, EmojiManager paramEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 0)
    {
      localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d(ChatActivityFacade.a(), 2, "func tryFetchEmosmKey, try fetch normal emotion keys. epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ",cur emo id:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 4));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, localArrayList);
    } while (!QLog.isColorLevel());
    QLog.d(ChatActivityFacade.a(), 2, "func tryFetchEmosmKey, try fetch magic emotion key. epId:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ",cur emo id:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ksd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */