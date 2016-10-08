import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class utp
  implements Runnable
{
  utp(utn paramutn, String paramString1, boolean paramBoolean, String paramString2) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append(" dump");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "成功，文件路径为" + this.b;; str = "失败")
    {
      QQToast.a(localBaseApplicationImpl, str, 2000).a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */