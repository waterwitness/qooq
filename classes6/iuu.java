import com.tencent.biz.qqstory.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class iuu
  extends QQUIEventReceiver
{
  public iuu(NewStoryDoodle paramNewStoryDoodle)
  {
    super(paramNewStoryDoodle);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NewStoryDoodle paramNewStoryDoodle, DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    if (paramDoodleEmojiDownloadEvent.jdField_b_of_type_Int != 0) {
      StoryReportor.a("video_edit", "fail_face", 0, 0, new String[0]);
    }
    iuw localiuw = NewStoryDoodle.a(paramNewStoryDoodle);
    if (localiuw != null)
    {
      Object localObject = localiuw.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem.a);
      if (!(localObject instanceof NormalFacePackage)) {
        return;
      }
      localObject = (NormalFacePackage)localObject;
      if (paramDoodleEmojiDownloadEvent.jdField_b_of_type_Int == 0)
      {
        if (localObject != null)
        {
          if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean)
          {
            SLog.b(this.TAG, "notify ui we finish downloading");
            ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = false;
            ((NormalFacePackage)localObject).g = paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem.a();
            ((NormalFacePackage)localObject).jdField_a_of_type_Int = 0;
            ((NormalFacePackage)localObject).jdField_b_of_type_Int = 0;
            localiuw.a((FacePackage)localObject);
            return;
          }
          SLog.a(this.TAG, "notify ui we new progress : " + paramDoodleEmojiDownloadEvent.jdField_b_of_type_Long + " / " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
          ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = true;
          ((NormalFacePackage)localObject).g = null;
          ((NormalFacePackage)localObject).jdField_a_of_type_Int = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
          ((NormalFacePackage)localObject).jdField_b_of_type_Int = ((int)paramDoodleEmojiDownloadEvent.jdField_b_of_type_Long);
          localiuw.a((FacePackage)localObject);
          return;
        }
        SLog.d(this.TAG, "DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = " + paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemDoodleEmojiItem.a);
        return;
      }
      ((NormalFacePackage)localObject).jdField_a_of_type_Boolean = false;
      ((NormalFacePackage)localObject).g = null;
      ((NormalFacePackage)localObject).jdField_a_of_type_Int = 0;
      ((NormalFacePackage)localObject).jdField_b_of_type_Int = 0;
      localiuw.a((FacePackage)localObject);
      SLog.e(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + paramDoodleEmojiDownloadEvent.jdField_b_of_type_Int);
      QQToast.a(paramNewStoryDoodle.a, "下载失败，请稍后重试", 1).a();
      return;
    }
    SLog.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iuu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */