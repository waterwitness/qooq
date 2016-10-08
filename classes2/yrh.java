import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import java.util.ArrayList;
import java.util.Date;

public class yrh
  implements Runnable
{
  public yrh(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, ArrayList paramArrayList, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = QzoneDynamicAlbumPlugin.d + (new Date().getTime() + i);
        String str2 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (QzoneDynamicAlbumPlugin.a(BaseApplicationImpl.getContext(), str2, str1, QzoneDynamicAlbumPlugin.b()[0], QzoneDynamicAlbumPlugin.b()[1])) {
          RemoteHandleManager.a().a().c(str1);
        }
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.arg1 = this.jdField_a_of_type_Int;
        localMessage.obj = new String[] { str2, str1 };
        this.jdField_a_of_type_CooperationQzoneWebviewpluginQzoneDynamicAlbumPlugin.a.sendMessage(localMessage);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */