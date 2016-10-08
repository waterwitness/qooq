import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VasUtils;

public class tg
  implements Runnable
{
  public tg(FontManager paramFontManager, FriendsManager paramFriendsManager, String paramString, ChatMessage paramChatMessage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localExtensionInfo) != null) {
      VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */