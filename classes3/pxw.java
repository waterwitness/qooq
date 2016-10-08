import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxw
  implements Runnable
{
  public pxw(FriendListHandler paramFriendListHandler, int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Byte, this.jdField_b_of_type_Byte, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */