import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class iwr
  extends TimerTask
{
  protected QQStoryMusicInfo a;
  
  public iwr(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.q();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */