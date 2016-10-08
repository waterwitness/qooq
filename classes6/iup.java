import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iup
  implements MessageQueue.IdleHandler
{
  public iup(NewStoryDoodle paramNewStoryDoodle, DoodleEmojiManager paramDoodleEmojiManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */