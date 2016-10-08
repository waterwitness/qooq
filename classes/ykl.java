import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LocalMultiProcConfig;

public final class ykl
  implements Runnable
{
  public ykl(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LocalMultiProcConfig.b(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ykl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */