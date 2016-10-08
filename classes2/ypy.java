import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneLiveVideoTransparentActivity;

public class ypy
{
  ypy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Class a(String paramString)
  {
    if (QzoneLiveVideoPluginProxyActivity.a(QzoneLiveVideoPluginProxyActivity.a(), paramString)) {
      return QzoneLiveVideoTransparentActivity.class;
    }
    return QzoneLiveVideoGpuProxyActivity.class;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */