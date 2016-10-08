import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class tal
  extends DownloadListener
{
  tal(tak paramtak)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngFrameManager.a(), 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
    {
      if (PngFrameManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) != null)
      {
        if (paramDownloadTask.a() != 3) {
          PngFrameManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(226, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
      }
      else {
        return;
      }
      paramDownloadTask = PngGifEngine.a(this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.a = paramDownloadTask;
      PngFrameManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(227, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
      BaseApplicationImpl.a.put(this.a.jdField_a_of_type_JavaLangString, paramDownloadTask);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */