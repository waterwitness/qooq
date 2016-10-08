import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import java.util.List;

public class yri
  implements Runnable
{
  public yri(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, List paramList, String[] paramArrayOfString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (QzoneDynamicAlbumPlugin.a(BaseApplicationImpl.getContext(), (String)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_ArrayOfJavaLangString[i], QzoneDynamicAlbumPlugin.b()[0], QzoneDynamicAlbumPlugin.b()[1])) {
          RemoteHandleManager.a().a().c(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZLog", 2, "Dynamic" + QzoneDynamicAlbumPlugin.a() + " compress all done  ");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */