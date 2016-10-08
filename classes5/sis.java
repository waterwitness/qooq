import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class sis
  implements Runnable
{
  public sis(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.a, 1).b(FMToastUtil.a());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */