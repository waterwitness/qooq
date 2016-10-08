import android.content.Context;
import android.text.TextUtils;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class hij
  extends Thread
{
  public hij(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 15;
    String str = "";
    if ((i > 0) && (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a != null)) {
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a.get() == null) {
        i = 2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.c = false;
      if (QLog.isDevelopLevel()) {
        QLog.d("SensorApi", 4, "run check end: " + i);
      }
      if (i == 0)
      {
        int j = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a();
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { Util.b(Integer.toString(i)), Util.b(str), Util.b(Integer.toString(j)) });
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check: " + i);
        }
        str = BizWifiConfigManager.a(this.jdField_a_of_type_AndroidContentContext);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          continue;
        }
        try
        {
          Thread.sleep(2000L);
          i -= 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 2;
        }
        continue;
      }
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { Util.b(Integer.toString(i)) });
      return;
      i = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */