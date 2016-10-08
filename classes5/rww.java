import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.ChangeNewPath;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rww
  implements FileManagerRSWorker.ChangeNewPath
{
  rww(rwu paramrwu, boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rwu.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, this.d, this.e, this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */