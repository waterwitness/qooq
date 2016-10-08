import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class uto
  implements Runnable
{
  uto(utn paramutn, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a, this.jdField_a_of_type_JavaLangString + "泄漏，正在生成dump文件", 2000).a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */