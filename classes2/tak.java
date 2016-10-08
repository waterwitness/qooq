import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.RandomDrawableParam;
import com.tencent.mobileqq.magicface.drawable.PngGifEngine;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class tak
  implements Runnable
{
  public tak(PngFrameManager paramPngFrameManager, String paramString, PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (FileUtils.a(this.jdField_a_of_type_JavaLangString))
    {
      ??? = PngGifEngine.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_JavaLangObject = ???;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager)
      {
        if (PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager) != null) {
          PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).obtainMessage(227, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
        return;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.a.eId;
    ??? = new DownloadTask(EmoticonUtils.h.replace("[eIdSub]", ((String)???).substring(0, 2)).replace("[eId]", (CharSequence)???).replace("[width]", "200").replace("[height]", "200"), new File(this.jdField_a_of_type_JavaLangString));
    ((DownloadTask)???).l = true;
    PngFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager).a((DownloadTask)???, new tal(this), null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */