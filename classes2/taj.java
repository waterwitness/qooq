import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;

public class taj
  implements Runnable
{
  public taj(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    File localFile = new File(EmoticonUtils.n.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString));
    EmoticonManager localEmoticonManager = (EmoticonManager)PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).getManager(13);
    ??? = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString);
    Object localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
    {
      if (PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) != null)
      {
        if (!localFile.exists()) {
          break label160;
        }
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int = PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).a(localFile);
        PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(224, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        ((EmoticonPackage)localObject1).rscType = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int;
        localEmoticonManager.a((EmoticonPackage)localObject1);
      }
      label160:
      DownloadTask localDownloadTask;
      do
      {
        return;
        localDownloadTask = new DownloadTask(EmosmUtils.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString), localFile);
        localDownloadTask.h = true;
      } while ((DownloaderFactory.a(localDownloadTask, PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)) != 0) || (PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) == null) || (PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) == null));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int = PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).a(localFile);
      ((EmoticonPackage)localObject1).rscType = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_Int;
      localEmoticonManager.a((EmoticonPackage)localObject1);
      PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(224, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\taj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */