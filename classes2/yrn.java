import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import java.io.File;
import java.util.TimerTask;

class yrn
  extends TimerTask
{
  yrn(yrm paramyrm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(this.a.b);
    if (HttpDownloadUtil.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_JavaLangString, localFile))
    {
      QzoneOfflineCacheHelper.a().a(this.a.b, true);
      if (QLog.isColorLevel()) {
        QLog.i("QzoneOfflineCacheHelper", 2, String.format("download succ,path:%s", new Object[] { this.a.b }));
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (localFile.exists()) {
          FileUtil.a(localFile);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("QzoneOfflineCacheHelper", 2, String.format("download fail,url:%s,path:%s", new Object[] { this.a.jdField_a_of_type_JavaLangString, this.a.b }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */