import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import java.io.File;
import java.util.ArrayList;

public class slh
  implements Runnable
{
  public slh(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1 = EmoticonUtils.n.replace("[epId]", this.jdField_a_of_type_JavaLangString);
    boolean bool = FileUtils.a((String)localObject1);
    Object localObject2 = EmoticonUtils.b.replace("[epId]", this.jdField_a_of_type_JavaLangString);
    localObject1 = new File((String)localObject1);
    if (!bool)
    {
      localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
      ((DownloadTask)localObject2).h = true;
      if (DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqForwardForwardPluginShareStructMsgOption.a) != 0) {
        return;
      }
    }
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).epId = this.jdField_a_of_type_JavaLangString;
    ((EmoticonPackage)localObject2).jobType = 4;
    localObject1 = FileUtils.a((File)localObject1);
    ArrayList localArrayList = new ArrayList();
    EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardPluginShareStructMsgOption.a, (EmoticonPackage)localObject2, EmojiManager.e, (byte[])localObject1, localArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */