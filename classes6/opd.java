import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class opd
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public opd(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length == 1)
    {
      this.jdField_a_of_type_JavaLangString = arrayOfString[0];
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (arrayOfString.length == 4)
    {
      this.b = arrayOfString[0];
      this.c = arrayOfString[1];
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = arrayOfString[3];
      return;
    }
    if (arrayOfString.length > 4)
    {
      int j = arrayOfString.length;
      paramString = "";
      int i = 0;
      while (i < j - 4)
      {
        paramString = paramString + arrayOfString[i] + " ";
        i += 1;
      }
      this.d = paramString;
      this.b = arrayOfString[(j - 4)];
      this.c = arrayOfString[(j - 3)];
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = arrayOfString[(j - 1)];
      return;
    }
    throw new RuntimeException("format error!");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */