import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public final class siw
  implements Runnable
{
  public siw(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130838420);
    localQQToast.c(3000);
    localQQToast.b(this.a);
    localQQToast.b(FMToastUtil.a());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\siw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */