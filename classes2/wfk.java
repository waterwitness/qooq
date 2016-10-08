import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.qphone.base.util.QLog;

class wfk
  implements Runnable
{
  wfk(wfj paramwfj, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SSOHttpUtils.a(1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "login receive stepInfoJson:" + this.jdField_a_of_type_JavaLangString);
      }
      SSOHttpUtils.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */