import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public final class ypu
  implements Runnable
{
  public ypu(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new AlertDialog.Builder(BaseApplication.getContext());
    ((AlertDialog.Builder)localObject).setMessage(this.a).setTitle("点击上报成功");
    localObject = ((AlertDialog.Builder)localObject).create();
    ((AlertDialog)localObject).getWindow().setType(2003);
    try
    {
      ((AlertDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */