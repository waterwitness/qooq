import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.HYControlUI;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class guj
  extends BroadcastReceiver
{
  private boolean jdField_a_of_type_Boolean;
  
  private guj(HYControlUI paramHYControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("HYControlUI", 2, "DTMFRequestReceiver onReceive action = " + (String)localObject);
    }
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("HYControlUI", 2, "DTMFRequestReceiver onReceive action = null or mApp == null ");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((!TextUtils.isEmpty(paramIntent.getPackage())) && (paramIntent.getPackage().equals(this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName()))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("HYControlUI", 2, "receive broadcast from wrong package:" + paramIntent.getPackage() + ",action:" + (String)localObject);
          return;
          if ("tencent.c2b.action.REQUEST_SEND_DTMF".equals(localObject))
          {
            localObject = paramIntent.getStringExtra("dtmf");
            String str = paramIntent.getStringExtra("destaction");
            if ((localObject != null) && (((String)localObject).length() > 0)) {
              this.jdField_a_of_type_ComTencentAvUiHYControlUI.a(this.jdField_a_of_type_ComTencentAvUiHYControlUI.t, ((String)localObject).charAt(0));
            }
            localObject = new Intent(str);
            ((Intent)localObject).putExtras(paramIntent);
            ((Intent)localObject).putExtra("result", 0);
            ((Intent)localObject).setPackage(paramContext.getPackageName());
            this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
            return;
          }
          if (!"tencent.c2b.action.C2BBrowser.destory".equals(localObject)) {
            break;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            HYControlUI.a(this.jdField_a_of_type_ComTencentAvUiHYControlUI);
            this.jdField_a_of_type_Boolean = false;
            return;
          }
          paramContext = paramIntent.getStringExtra("dtmf");
        } while (TextUtils.isEmpty(paramContext));
        this.jdField_a_of_type_ComTencentAvUiHYControlUI.a(this.jdField_a_of_type_ComTencentAvUiHYControlUI.t, paramContext.charAt(0));
        return;
        if ("tencent.c2b.action.C2BBrowser.call.arti".equals(localObject))
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        if (!"tencent.c2b.action.REQUEST_MIC_STATE".equals(localObject)) {
          break;
        }
        localObject = paramIntent.getStringExtra("mic_state_type");
        if (((String)localObject).equals("close"))
        {
          this.jdField_a_of_type_ComTencentAvUiHYControlUI.m(true);
          localObject = new Intent(paramIntent.getStringExtra("destaction"));
          ((Intent)localObject).putExtras(paramIntent);
          ((Intent)localObject).putExtra("mic_state_result", this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvVideoController.a().k);
          ((Intent)localObject).setPackage(paramContext.getPackageName());
          this.jdField_a_of_type_ComTencentAvUiHYControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
          return;
        }
      } while ((!((String)localObject).equals("open")) || (this.jdField_a_of_type_ComTencentAvUiHYControlUI.k));
      this.jdField_a_of_type_ComTencentAvUiHYControlUI.m(false);
      return;
    } while (!"tencent.c2b.action.tel.authorisation".equals(localObject));
    paramContext = paramIntent.getStringExtra("param_callback");
    int i = paramIntent.getIntExtra("error_info", -1);
    paramIntent = paramIntent.getStringExtra("token_info");
    localObject = Long.toString(i);
    QLog.i("HYControlUI", 2, "ACTION_TEL_AUTHORISATION onReceive strCallback = " + paramContext + ", strTokenString=" + paramIntent + ", strErrCode=" + (String)localObject);
    HYControlUI.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window." + paramContext + "(" + (String)localObject + "," + paramIntent + ")");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */