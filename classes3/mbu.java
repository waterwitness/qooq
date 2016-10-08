import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mbu
{
  public PublicAccountInfo a;
  public String a;
  public String b;
  
  public mbu(PublicAccountInfo paramPublicAccountInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
  }
  
  public void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */