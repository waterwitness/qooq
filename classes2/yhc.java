import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.QQHotSpotHelper.AP;
import cooperation.qqhotspot.QQHotSpotHelper.APConnInfo;
import cooperation.qqhotspot.WifiConversationManager;
import java.util.HashMap;

public class yhc
  extends BroadcastReceiver
{
  public yhc(WifiConversationManager paramWifiConversationManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WifiConversationManager.a().size() == 0) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    paramContext = paramIntent.getAction();
                    if (!paramContext.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                      break;
                    }
                    switch (paramIntent.getIntExtra("wifi_state", 4))
                    {
                    default: 
                      return;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: WIFI_STATE_CHANGED_ACTION disabling");
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: WIFI_STATE_CHANGED_ACTION disabled");
                  }
                } while ((this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP == null) || (this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 5));
                this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus = 5;
                this.a.a();
                return;
              } while (!QLog.isColorLevel());
              QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: WIFI_STATE_CHANGED_ACTION enabling");
              return;
            } while (!QLog.isColorLevel());
            QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: WIFI_STATE_CHANGED_ACTION enabled");
            return;
          } while (!paramContext.equals("android.net.wifi.STATE_CHANGE"));
          paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
          if (NetworkInfo.State.CONNECTED == paramContext.getState())
          {
            if (QLog.isColorLevel()) {
              QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: connected");
            }
            this.a.a(1);
            return;
          }
          if (NetworkInfo.State.CONNECTING != paramContext.getState()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: connecting");
        return;
      } while (NetworkInfo.State.DISCONNECTED != paramContext.getState());
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "networkChangedReceiver: disconnected");
      }
    } while ((this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP == null) || (this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus == 5));
    this.a.jdField_a_of_type_CooperationQqhotspotQQHotSpotHelper$AP.ApConnInfo.ConnStatus = 5;
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */