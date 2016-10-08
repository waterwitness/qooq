import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.widget.QQToast;

public class ufu
  implements Runnable
{
  public ufu(CompoundProcessor paramCompoundProcessor, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a, this.jdField_a_of_type_JavaLangString, 0).b(200);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */