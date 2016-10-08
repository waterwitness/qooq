import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

class vpy
  implements Runnable
{
  vpy(vpx paramvpx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = BaseApplicationImpl.a.getResources().getDimensionPixelSize(2131492908);
    QQToast.a(BaseApplicationImpl.a, "转发成功", 0).b(i);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */