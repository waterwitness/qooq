import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.video.QzoneLiveVideoInterface;

public final class ypv
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public ypv(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      QZonePluginMangerHelper.a(QzoneLiveVideoInterface.getContext(), this);
    }
    do
    {
      return;
      paramIQZonePluginManager = paramIQZonePluginManager.a(this.a);
    } while (paramIQZonePluginManager == null);
    QzoneLiveVideoInterface.access$002(paramIQZonePluginManager.e);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */