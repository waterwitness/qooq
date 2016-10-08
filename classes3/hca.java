import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hca
  implements Runnable
{
  public hca(int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, Object[] paramArrayOfObject)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 9)
    {
      VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      return;
    }
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */