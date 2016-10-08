import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.msg.data.DeviceCommonMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONArray;
import org.json.JSONObject;

public class kar
  implements Runnable
{
  public Session a;
  public boolean a;
  
  public kar(Session paramSession, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentLitetransfersdkSession = paramSession;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    ThreadManager.a(this, 8, null, false);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentLitetransfersdkSession == null) || (this.jdField_a_of_type_ComTencentLitetransfersdkSession.actionInfo == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONObject(new String(this.jdField_a_of_type_ComTencentLitetransfersdkSession.actionInfo.vServiceInfo)).getJSONArray("datapoint");
        if (localJSONArray == null) {
          break;
        }
        int j = localJSONArray.length();
        if (j <= 0) {
          break;
        }
        int i = 0;
        if (i >= j) {
          break;
        }
        try
        {
          localObject2 = localJSONArray.getJSONObject(i);
          localDataPoint = new DataPoint(((JSONObject)localObject2).optString("apiName"), ((JSONObject)localObject2).optInt("id"), ((JSONObject)localObject2).optString("type"), ((JSONObject)localObject2).optString("value"));
          localDataPoint.mSeq = ((JSONObject)localObject2).optString("seq", "0");
          localDataPoint.mDin = ((JSONObject)localObject2).optLong("din");
          if ((DeviceMsgHandle.d.equalsIgnoreCase(this.jdField_a_of_type_ComTencentLitetransfersdkSession.actionInfo.strServiceName)) || (DeviceMsgHandle.e.equalsIgnoreCase(this.jdField_a_of_type_ComTencentLitetransfersdkSession.actionInfo.strServiceName)) || (DeviceMsgHandle.l.equalsIgnoreCase(this.jdField_a_of_type_ComTencentLitetransfersdkSession.actionInfo.strServiceName)))
          {
            boolean bool = TextUtils.isEmpty(localDataPoint.mValue);
            if (!bool) {
              continue;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            DataPoint localDataPoint;
            Object localObject1;
            Object localObject3;
            kaq localkaq;
            localException2.printStackTrace();
            continue;
            String str = "1";
          }
        }
        i += 1;
        continue;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject1 = null;
        continue;
        localObject3 = new kaq();
        ((kaq)localObject3).a = "path";
        ((kaq)localObject3).b = localDataPoint.mValue;
        localkaq = new kaq();
        localkaq.a = "ret";
        if (!this.jdField_a_of_type_Boolean) {
          break label351;
        }
      }
      localObject2 = "0";
      localkaq.b = ((String)localObject2);
      localDataPoint.mValue = DeviceCommonMsgProcessor.a((kaq)localObject3, localkaq);
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("SmartDevice_receiveDPMsg");
      localObject3 = new Bundle();
      ((Bundle)localObject3).putParcelable("dataPoint", localDataPoint);
      ((Intent)localObject2).putExtras((Bundle)localObject3);
      BaseApplicationImpl.a().sendBroadcast((Intent)localObject2, "com.tencent.smartdevice.permission.broadcast");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */