import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class rju
  implements Runnable
{
  public rju(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func initGlobalDataSync begins.");
    }
    EmoticonUtils.b(this.a);
    "insertPluginsArray".hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */