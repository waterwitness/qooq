import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class qzw
  implements Runnable
{
  public qzw(AddressData paramAddressData, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      QQToast.a(BaseApplicationImpl.a, "条件搜素配置文件存在不同code对应相同name的问题！！！ name = " + this.jdField_a_of_type_JavaLangString, 1).a();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */