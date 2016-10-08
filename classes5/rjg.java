import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rjg
  implements Runnable
{
  public rjg(EmojiManager paramEmojiManager, EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 2) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */