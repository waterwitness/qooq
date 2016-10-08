import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class tan
  extends DownloadListener
{
  tan(tam paramtam, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PngFrameManager.a(), 2, "func onDone.【pngZip】");
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
      {
        if (PngFrameManager.a(this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) != null)
        {
          if (paramDownloadTask.a() != 3) {
            PngFrameManager.a(this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(226, this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
          }
        }
        else {
          return;
        }
      }
      try
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString, EmoticonUtils.t.replace("[epId]", this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangString), false);
        new File(this.jdField_a_of_type_JavaLangString).delete();
        this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.b(this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.epId);
        PngFrameManager.a(this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(225, this.jdField_a_of_type_Tam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        continue;
        paramDownloadTask = finally;
        throw paramDownloadTask;
      }
      catch (IOException paramDownloadTask)
      {
        for (;;)
        {
          paramDownloadTask.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */