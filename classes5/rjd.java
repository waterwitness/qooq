import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class rjd
  extends DownloadListener
{
  public rjd(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Bundle localBundle = paramDownloadTask.a();
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)localBundle.getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    if ((QLog.isColorLevel()) && (localEmoticonPackage != null)) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "jsonDownloadListener : onDone epid = " + localEmoticonPackage.epId + ";task status = " + paramDownloadTask.a());
    }
    if (paramDownloadTask.a() == 3)
    {
      boolean bool = localBundle.getBoolean("isSmallEmotion");
      String str = EmotionJsonUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDownloadTask, bool);
      if (str != null)
      {
        QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : parse json error : = " + str);
        this.a.a(localEmoticonPackage, 11008, 0L, paramDownloadTask.d);
        return;
      }
      EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 0, localBundle);
      return;
    }
    QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "jsonDownloadListener : ondone error , reportCode = " + paramDownloadTask.z);
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, -1, localBundle);
    VasReportUtils.a("emotionType", "emotionActionDownload", "3", localEmoticonPackage.epId, "", "", paramDownloadTask.z + "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */