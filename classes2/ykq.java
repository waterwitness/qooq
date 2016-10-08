import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.QZonePluginManger;

public final class ykq
  implements Runnable
{
  public ykq(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QZonePluginManger localQZonePluginManger = (QZonePluginManger)this.a.getManager(174);
    if (localQZonePluginManger != null) {
      localQZonePluginManger.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ykq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */