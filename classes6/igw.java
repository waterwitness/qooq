import android.os.Bundle;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class igw
  extends DownloadListener
{
  public igw(QQStoryManager paramQQStoryManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "animationDownloadListener onDone. task:" + paramDownloadTask);
    }
    if (paramDownloadTask.z == 0)
    {
      localFile = new File(paramDownloadTask.a().getString("animation_path_key"));
      if (!localFile.exists()) {}
    }
    while (paramDownloadTask.z != -1) {
      try
      {
        FileUtils.a(localFile.getAbsolutePath(), AppConstants.dc, false);
        ((StoryConfigManager)SuperManager.a(10)).b("easter_animation_is_ready", Boolean.valueOf(true));
        localFile.delete();
        StoryReportor.b("story_easter_egg", "download_package", 0, 0, new String[] { StoryReportor.a(null) });
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.pgc", 2, "animationDownloadListener onDone. task:" + paramDownloadTask + " uncompress failed");
        }
        localIOException.printStackTrace();
        return;
      }
      finally
      {
        File localFile;
        localFile.delete();
      }
    }
    StoryReportor.b("story_easter_egg", "download_package", 0, 1, new String[] { StoryReportor.a(null) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */