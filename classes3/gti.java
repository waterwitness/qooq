import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gti
{
  static final String a = "0X8006F8C";
  static final String b = "0X8006F8B";
  static final String c = "0X8006F8A";
  static final String d = "0X8006F89";
  static final String e = "0X8006F8E";
  static final String f = "0X8006F8D";
  
  gti()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    a("0X8006F8F");
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b()
  {
    a("0X8006F88");
  }
  
  public static void c()
  {
    a("0X8006F87");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */