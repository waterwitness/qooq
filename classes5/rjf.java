import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class rjf
  extends DownloadListener
{
  public rjf(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    EmojiManager.c(this.a, paramDownloadTask);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.a();
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile epId=" + ((EmoticonPackage)localObject).epId + ",task:" + paramDownloadTask);
    }
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.b((EmoticonPackage)localObject, (int)paramDownloadTask.a, (int)paramDownloadTask.b);
    if (paramDownloadTask.z != 0)
    {
      QLog.e(this.a.jdField_a_of_type_JavaLangString, 1, "onDoneFile : ondone error , reportCode = " + paramDownloadTask.z);
      VasReportUtils.a("emotionType", "emotionActionDownload", "10", ((EmoticonPackage)localObject).epId, "", "", paramDownloadTask.z + "", "", "", "");
    }
    for (;;)
    {
      return;
      if (this.a.a(i)) {
        EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject, i, 0, 0);
      }
      while ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5))
      {
        EmojiManager.b(this.a, paramDownloadTask);
        return;
        if (i == 7) {
          EmojiManager.a(this.a, paramDownloadTask);
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    EmojiManager.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */