import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.common.util.CommUtils;
import com.tencent.biz.common.util.CommUtils.IHttpGetString;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class hhi
  extends AsyncTask
{
  String jdField_a_of_type_JavaLangString;
  
  public hhi(CommUtils.IHttpGetString paramIHttpGetString, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = CommUtils.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */