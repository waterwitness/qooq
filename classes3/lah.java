import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lah
  implements Runnable
{
  public lah(ChatSettingForTroop paramChatSettingForTroop, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      ChatSettingForTroop.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.c, localBitmap);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */