import android.os.Bundle;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.BubbleInfoLruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

public class qtx
  extends DownloadListener
{
  public qtx(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onCancel| task:" + paramDownloadTask);
    }
    String str = paramDownloadTask.a().getString("name");
    this.a.a("Bubble_download_cancel", paramDownloadTask.b(), str, 0L);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    String str;
    do
    {
      do
      {
        return;
        if (paramDownloadTask.a() != -1) {
          break;
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (!paramDownloadTask.a().containsKey("callbackId")));
      this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramDownloadTask.b(), -1, paramDownloadTask.a());
      return;
      str = paramDownloadTask.a().getString("name");
    } while (str == null);
    Object localObject1;
    if ("all.zip".equals(str))
    {
      localObject1 = this.a.a(paramDownloadTask.b(), false);
      if (DownloaderFactory.a((File)paramDownloadTask.a.get(paramDownloadTask.c), (File)localObject1, true))
      {
        if (this.a.a(paramDownloadTask.b(), false)) {
          this.a.b(paramDownloadTask.b(), null);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramDownloadTask.b(), 3, paramDownloadTask.a());
        }
      }
    }
    for (;;)
    {
      long l1 = paramDownloadTask.h;
      long l2 = paramDownloadTask.g;
      this.a.a("Bubble_download_succ", paramDownloadTask.b(), str, l1 - l2);
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId")))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.a(paramDownloadTask.b(), -2, paramDownloadTask.a());
        continue;
        localObject1 = new File(this.a.a(paramDownloadTask.b(), true), str);
        int i = str.lastIndexOf(".zip");
        if (i < 0) {
          break;
        }
        Object localObject2 = str.substring(0, i);
        if (DownloaderFactory.a((File)localObject1, new File(this.a.a(paramDownloadTask.b(), false), (String)localObject2), true))
        {
          if (this.a.a(paramDownloadTask.b(), false)) {
            this.a.b(paramDownloadTask.b(), (String)localObject2);
          }
          if (!"static".equals(localObject2))
          {
            localObject1 = this.a.a(paramDownloadTask.b(), (String)localObject2);
            localObject1 = this.a.a(paramDownloadTask.b(), (AnimationConfig)localObject1, false);
            if (localObject1 != null)
            {
              localObject2 = (BubbleInfo)this.a.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramDownloadTask.b()));
              if (localObject2 != null) {
                ((BubbleInfo)localObject2).a.add(localObject1);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onStart| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b() == 0) {
      return false;
    }
    String str = paramDownloadTask.a().getString("name");
    this.a.a("Bubble_download", paramDownloadTask.b(), str, 0L);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qtx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */