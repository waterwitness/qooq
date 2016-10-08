import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class iuv
  extends QQUIEventReceiver
{
  public iuv(NewStoryDoodle paramNewStoryDoodle)
  {
    super(paramNewStoryDoodle);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NewStoryDoodle paramNewStoryDoodle, DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent)
  {
    iuw localiuw = NewStoryDoodle.a(paramNewStoryDoodle);
    if (localiuw != null) {
      localiuw.a(NewStoryDoodle.a(paramNewStoryDoodle, false));
    }
    for (;;)
    {
      StoryReportor.b("edit_video", "face_list_success", 0, paramDoodleEmojiUpdateEvent.a.errorCode, new String[0]);
      return;
      SLog.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdateEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */