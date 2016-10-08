import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryDoodle;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iur
  implements FaceListPage.FacePackagePageEventListener
{
  public iur(NewStoryDoodle paramNewStoryDoodle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "用户点击重新拉取地理贴纸");
    ((DoodleEmojiManager)SuperManager.a(8)).a(this.a.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager$POIPostersRequestCallback);
  }
  
  public void a(String paramString)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "用户点击下载：" + paramString);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("video_edit", "download_face", 0, 0, new String[] { str, paramString });
      if (!((DoodleEmojiManager)SuperManager.a(8)).a(paramString, true)) {
        SLog.d("Q.qqstory.record.StoryDoodle", "用户点击下载启动失败");
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "用户点击下载取消：" + paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */