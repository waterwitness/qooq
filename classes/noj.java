import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class noj
  extends nil
{
  private static int d;
  private QQAppInterface a;
  private int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString;
  
  public noj(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaLangString = "ArkApp.SSODataRequest";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.substring(0, 6).equalsIgnoreCase("sso://")) {
      return null;
    }
    int i = paramString.indexOf('/', 6);
    if (i == -1) {
      return paramString.substring(6);
    }
    return paramString.substring(6, i);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    a(null);
  }
  
  void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != this.jdField_c_of_type_Int) {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# onComplete, req canceled, cookie=%d-%d, ret=%d, rsp=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(paramInt2), paramString }));
    }
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_Int = 0;
      paramString = this.jdField_a_of_type_Nll;
      this.jdField_a_of_type_Nll = null;
    } while (paramString == null);
    paramString.a();
  }
  
  public boolean a(String paramString)
  {
    if (!super.a(paramString))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to open, url=%s", new Object[] { paramString }));
      return false;
    }
    return true;
  }
  
  void b(int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(this);
    DispatchTask.a().a(new nom(this, localWeakReference, paramInt));
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_c_of_type_Int != 0) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, cookie=%d, url=%s, req=%s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_a_of_type_JavaLangString, paramString }));
      return false;
    }
    int i = d + 1;
    d = i;
    this.jdField_c_of_type_Int = i;
    String str = a(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(str))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, cmd is empty, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
      b(i);
      return true;
    }
    ArkAppSSO localArkAppSSO = ((ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a();
    WeakReference localWeakReference = new WeakReference(this);
    if (!localArkAppSSO.a(str, paramString, this.jdField_a_of_type_Int, i, new nok(this, localWeakReference)))
    {
      ArkAppCenter.c("ArkApp.SSODataRequest", String.format("# fail to send, sso.sendAppMsg fail, cookie=%d, url=%s, reqData=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_JavaLangString, paramString }));
      b(i);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\noj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */