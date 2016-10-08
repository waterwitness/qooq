import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryManager.OnAnimationReadiedListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class igu
  implements Runnable
{
  public igu(QQStoryManager paramQQStoryManager, String paramString, StoryConfigManager paramStoryConfigManager, QQStoryManager.OnAnimationReadiedListener paramOnAnimationReadiedListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "loadAnimationResource run.");
    }
    Object localObject2 = new File(AppConstants.dc + this.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if ((((File)localObject2).exists()) && (TroopGiftUtil.a((File)localObject2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "loadAnimationResource run. play Animation");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("easter_animation_is_ready", Boolean.valueOf(true));
      localObject1 = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      while (i < localObject2.length)
      {
        if (localObject2[i].getAbsolutePath().endsWith(".png")) {
          ((List)localObject1).add(localObject2[i].getAbsolutePath());
        }
        i += 1;
      }
      new Handler(Looper.getMainLooper()).post(new igv(this, (List)localObject1));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "loadAnimationResource run. download Animation");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("easter_animation_is_ready", Boolean.valueOf(false));
      localObject2 = AppConstants.dc + "d5421100bd454ee1bffec912bceb0c89.zip";
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("animation_path_key", (String)localObject2);
      localObject2 = new DownloadTask("http://pub.idqqimg.com/pc/misc/files/20160826/d5421100bd454ee1bffec912bceb0c89.zip", new File((String)localObject2));
      ((DownloadTask)localObject2).A = 2;
      ((DownloaderFactory)this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(46)).a(1).a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.pgc", 2, "start Download animation.");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */