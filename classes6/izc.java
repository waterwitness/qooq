import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class izc
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  
  izc(boolean paramBoolean, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static izc a()
  {
    return new izc(false, "");
  }
  
  static izc a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = izn.a(paramProcess.getInputStream());; str = izn.a(paramProcess.getErrorStream())) {
      return new izc(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */