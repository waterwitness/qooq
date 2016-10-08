import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class uzg
  implements Runnable
{
  public uzg(QQText.SmallEmojiSpan paramSmallEmojiSpan)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject3 = EmoticonUtils.n.replace("[epId]", Integer.toString(this.a.f));
    if (FileUtils.a((String)localObject3)) {
      if (QQText.SmallEmojiSpan.a(this.a) == null) {
        break label283;
      }
    }
    label283:
    Object localObject2;
    for (Object localObject1 = QQText.SmallEmojiSpan.a(this.a).a(Integer.toString(this.a.f), Integer.toString(this.a.g));; localObject2 = null)
    {
      if (localObject1 != null) {}
      for (;;)
      {
        return;
        Object localObject4 = EmoticonUtils.b.replace("[epId]", Integer.toString(this.a.f));
        localObject3 = new File((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.a.f + ",downloadUrl:" + (String)localObject4);
        }
        try
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.a().getAppRuntime(QQText.c());
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QQText", 2, "appInterface is null. return");
          }
        }
        catch (ClassCastException localClassCastException)
        {
          AppRuntime localAppRuntime;
          for (;;)
          {
            localClassCastException.printStackTrace();
            localAppRuntime = null;
          }
          localObject4 = new DownloadTask((String)localObject4, (File)localObject3);
          ((DownloadTask)localObject4).h = true;
          int i = DownloaderFactory.a((DownloadTask)localObject4, localAppRuntime);
          localObject4 = new EmoticonPackage();
          ((EmoticonPackage)localObject4).epId = Integer.toString(this.a.f);
          ((EmoticonPackage)localObject4).jobType = 4;
          if (i == 0)
          {
            if (((File)localObject3).exists()) {}
            for (localObject3 = FileUtils.a((File)localObject3);; localObject3 = null)
            {
              ArrayList localArrayList = new ArrayList();
              EmotionJsonUtils.a(localAppRuntime, (EmoticonPackage)localObject4, EmojiManager.e, (byte[])localObject3, localArrayList);
              return;
            }
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          return;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */