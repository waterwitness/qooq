import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;

public class tez
  extends EmotionJsonDownloadListener
{
  public tez(EmoticonManager paramEmoticonManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    super.a(paramEmoticonPackage, paramInt, paramBundle);
    if ((paramBundle != null) && (paramBundle.getInt("jsonType") == EmojiManager.f) && (paramEmoticonPackage != null)) {
      EmoticonManager.a(this.a, paramEmoticonPackage.epId);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */