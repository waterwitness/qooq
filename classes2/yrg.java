import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import java.util.ArrayList;
import java.util.List;

public class yrg
  extends Handler
{
  public yrg(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin)
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
      return;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String[])));
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = (String[])paramMessage.obj;
    localArrayList.add(QzoneDynamicAlbumPlugin.a(this.a, arrayOfString));
    this.a.a(localArrayList, paramMessage.arg1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */