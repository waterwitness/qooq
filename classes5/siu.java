import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class siu
  implements Runnable
{
  public siu(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b).b(FMToastUtil.a());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\siu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */