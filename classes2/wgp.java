import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class wgp
  extends DownloadListener
{
  public wgp(VoiceChangeManager paramVoiceChangeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (String)this.a.jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size()=" + this.a.jdField_a_of_type_JavaUtilArrayList.size() + ", url=" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("VoiceChangeManager", 1, "picDownloadListener url = null");
          onDone(null);
        }
      }
      else
      {
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VoiceChangeManager", 2, "picDownloadListener mUrlList.size() = 0");
        return;
      }
      File localFile = new File(VoiceChangeManager.b + ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1));
      if ((localFile.isFile()) && (localFile.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "picDownloadListener  file.exists()");
        }
        onDone(null);
        return;
      }
      paramDownloadTask = new Bundle();
      Object localObject = new DownloadTask((String)localObject, localFile);
      ((DownloadTask)localObject).l = true;
      ((DownloaderFactory)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a((DownloadTask)localObject, this.a.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramDownloadTask);
      return;
    }
    super.onDone(paramDownloadTask);
    paramDownloadTask.a();
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceChangeManager", 2, "picDownloadListener downloadOk task.key = " + paramDownloadTask.a);
      }
    }
    for (;;)
    {
      onDone(null);
      return;
      QLog.e("VoiceChangeManager", 1, "picDownloadListener download Error task.key = " + paramDownloadTask.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */