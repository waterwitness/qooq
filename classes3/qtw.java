import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class qtw
  extends DownloadListener
{
  public qtw(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|task=" + paramDownloadTask);
    }
    Object localObject = paramDownloadTask.a().getString("name");
    String str = this.a.a(paramDownloadTask.b(), false).getAbsolutePath() + File.separatorChar + (String)localObject;
    File localFile = new File(this.a.a(paramDownloadTask.b(), true), (String)localObject);
    if (!localFile.exists()) {}
    do
    {
      do
      {
        do
        {
          return;
          FileUtils.a(localFile, new File(this.a.a(paramDownloadTask.b(), false), (String)localObject));
          localFile.delete();
          if (QLog.isColorLevel()) {
            QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|bubbleId=" + paramDownloadTask.b() + ",copy temp file to formal dir finish");
          }
          if (!"config.json".equals(localObject)) {
            break;
          }
          localObject = this.a.a(paramDownloadTask.b(), str);
          if (QLog.isColorLevel()) {
            QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|bubbleId=" + paramDownloadTask.b() + ",createBubbleConfig bubbleConfig=" + localObject);
          }
        } while (localObject == null);
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramDownloadTask.b()), localObject);
        this.a.b(paramDownloadTask.b(), "config.json");
        return;
      } while (!"version.json".equals(localObject));
      this.a.b(paramDownloadTask.b(), "global_version");
    } while (!new File(this.a.a(paramDownloadTask.b(), false).getAbsolutePath() + File.separatorChar + "config.json").exists());
    if (this.a.a(paramDownloadTask.b(), "config.json").booleanValue())
    {
      this.a.a(paramDownloadTask.b(), "config.json");
      return;
    }
    this.a.a(paramDownloadTask.b(), true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qtw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */