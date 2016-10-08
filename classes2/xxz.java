import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class xxz
  extends ContentObserver
{
  public xxz(QzoneConfig paramQzoneConfig, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onChange(boolean paramBoolean)
  {
    String str = QZConfigProviderUtil.b();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneConfig", 2, "QZoneConfigService onChange from:" + str + " ,processName:" + BaseApplicationImpl.processName + " ,selfChange:" + paramBoolean);
    }
    if ((str != null) && (!str.equals(BaseApplicationImpl.processName)))
    {
      QzoneConfig.a().b();
      QzoneConfig.a().c();
    }
    QzoneConfig.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */