import android.text.TextUtils;
import com.tencent.image.JpegExifReader.JpegExifReaderInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class utu
  implements JpegExifReader.JpegExifReaderInterface
{
  public void doReport(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public boolean readEnableFromDPC()
  {
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("JpegExifReader", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          int i = Integer.parseInt(localObject[8]);
          if (i != 1) {
            break label81;
          }
        }
      }
    }
    catch (Exception localException)
    {
      label81:
      while (!QLog.isColorLevel()) {}
      QLog.e("JpegExifReader", 2, "read dpc", localException);
    }
    return true;
    return false;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */