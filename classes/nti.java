import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

public class nti
  extends MqqHandler
{
  public nti(AIOGalleryScene paramAIOGalleryScene)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        QQToast.a(AIOGalleryScene.c(this.a), 2131371520, 0).a();
        return;
        String str = AIOGalleryScene.d(this.a).getString(2131371521);
        paramMessage = (String)paramMessage.obj;
        QQToast.a(AIOGalleryScene.e(this.a), 2, str + paramMessage, 0).a();
        ImageUtil.a(AIOGalleryScene.f(this.a), paramMessage);
        return;
      } while (paramMessage.obj == null);
      paramMessage = new File((String)paramMessage.obj);
    } while (!paramMessage.exists());
    paramMessage = DialogUtil.a(AIOGalleryScene.g(this.a), 232, AIOGalleryScene.h(this.a).getResources().getString(2131371546), AIOGalleryScene.i(this.a).getResources().getString(2131371547), 2131371548, 2131368782, new ntj(this, paramMessage), new ntk(this));
    try
    {
      paramMessage.show();
      return;
    }
    catch (Throwable paramMessage) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */