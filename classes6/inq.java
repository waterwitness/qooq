import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.view.VideoCoverView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class inq
  implements PlayingListPreloader.OnVideoDownloadListener
{
  public inq(VideoCoverView paramVideoCoverView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onPause. vid=" + paramString1 + " url=" + paramString2);
    }
    if (((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString1))) || ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString2)) && (QLog.isColorLevel()))) {
      QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onPause and will handle. vid=" + paramString1 + " url=" + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onError. vid=" + paramString1 + " url=" + paramString2 + " error=" + paramErrorMessage);
    }
    if (((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString1))) || ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onError and will handle. vid=" + paramString1 + " url=" + paramString2 + " error=" + paramErrorMessage);
      }
      ((Activity)VideoCoverView.c(this.a)).runOnUiThread(new ins(this));
      StoryReportor.b("story_play", "cover_video_play", 0, 1, new String[] { this.a.a(), StoryReportor.a(VideoCoverView.d(this.a).getApplicationContext()), "2", this.a.b() });
    }
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onSuccess. vid=" + paramString1 + " url=" + paramString2 + " fileCache=" + paramFile);
    }
    if (((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString1))) || ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid.equals(paramString2))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc" + this.a.jdField_a_of_type_JavaLangString, 2, "registerVideoDownloadListener onSuccess and will handle. vid=" + paramString1 + " url=" + paramString2 + " fileCache=" + paramFile);
      }
      ((Activity)VideoCoverView.b(this.a)).runOnUiThread(new inr(this, paramFile));
    }
  }
  
  public void b(String paramString1, String paramString2, File paramFile) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */