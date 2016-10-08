import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.json.JSONObject;

public final class jcp
  extends Thread
{
  public jcp(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("lastCheckOrientation", System.currentTimeMillis());
    localEditor.commit();
    Object localObject = "http://qm.qq.com/cgi-bin/check_orientation?product=" + Build.PRODUCT + "&os=" + Build.VERSION.RELEASE + "&" + "mType" + "=" + "qb_qrcode";
    try
    {
      String str = HttpUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, "GET", null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRHttpUtil", 2, "open :" + (String)localObject + ", result: " + str);
      }
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).getInt("r") == 0)
      {
        if (((JSONObject)localObject).getInt("orientation") == 1)
        {
          localEditor.putBoolean("needLandScape", true);
          localEditor.commit();
        }
      }
      else {
        throw new IOException();
      }
    }
    catch (Exception localException)
    {
      localEditor.putLong("lastCheckOrientation", 0L);
      localEditor.commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */