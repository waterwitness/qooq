import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.ChangeNewPath;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;

class rwv
  implements FileManagerRSWorker.ChangeNewPath
{
  rwv(rwu paramrwu, boolean paramBoolean, long paramLong1, String paramString1, ByteStringMicro paramByteStringMicro, String paramString2, short paramShort, String paramString3, List paramList, int paramInt, String paramString4, long paramLong2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rwu.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Short, this.c, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.d, this.jdField_b_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */