import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class otl
  extends DownloadListener
{
  public otl(PreloadImgManager paramPreloadImgManager, File paramFile, AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    List localList = (List)PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager).get(paramDownloadTask.c);
    int j;
    if ((localList != null) && (!localList.isEmpty()))
    {
      j = localList.size();
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {
        break label168;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
    }
    label168:
    for (Object localObject = PreloadImgManager.a((PreloadImgManager)localObject, MobileQQ.getContext(), this.jdField_a_of_type_JavaIoFile.getPath(), paramDownloadTask.c);; localObject = null)
    {
      int i = 0;
      if (i < j)
      {
        PreloadImgManager.OnSingleDownloadCallback localOnSingleDownloadCallback = (PreloadImgManager.OnSingleDownloadCallback)localList.get(i);
        if (localOnSingleDownloadCallback == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localObject != null) {
            localOnSingleDownloadCallback.a((Bitmap)localObject);
          } else {
            localOnSingleDownloadCallback.a();
          }
        }
      }
      PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager).remove(paramDownloadTask.c);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */