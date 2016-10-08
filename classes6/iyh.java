import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.takevideo.music.MusicComposeDialog;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;

public class iyh
  implements Runnable
{
  public iyh(MusicComposeDialog paramMusicComposeDialog, QQStoryMusicInfo paramQQStoryMusicInfo, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a.a()))
    {
      FileUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a.a());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a = new DownloaderImp();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog.a.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d, this.jdField_a_of_type_JavaLangString, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */