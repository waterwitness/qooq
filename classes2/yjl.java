import VIP.RespCheckPayAuth;
import Wallet.PrePayRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.OpenPayActivity;

public class yjl
  extends Handler
{
  int jdField_a_of_type_Int;
  OpenPayActivity jdField_a_of_type_CooperationQwalletOpenOpenPayActivity;
  
  public yjl(OpenPayActivity paramOpenPayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity = paramOpenPayActivity;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity = null;
    super.removeCallbacksAndMessages(null);
  }
  
  protected void a(Object paramObject, int paramInt)
  {
    boolean bool = false;
    paramObject = (RespCheckPayAuth)paramObject;
    OpenPayActivity.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity, ((RespCheckPayAuth)paramObject).openId);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayActivity", 2, "app pay openid=" + OpenPayActivity.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ret=").append(((RespCheckPayAuth)paramObject).ret);
    ((StringBuilder)localObject).append("&openId=").append(((RespCheckPayAuth)paramObject).openId);
    ((StringBuilder)localObject).append("&retry=").append(paramInt);
    if (((RespCheckPayAuth)paramObject).ret != 0)
    {
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a(64524, ((RespCheckPayAuth)paramObject).errMsg, null, null);
      VACDReportUtil.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_Long, "payauthresult", ((StringBuilder)localObject).toString(), 668806, ((RespCheckPayAuth)paramObject).errMsg);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doOpenPayCheck !isSuccess");
      }
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_Long, null, "payauthresult", ((StringBuilder)localObject).toString(), 0, null);
    if (((RespCheckPayAuth)paramObject).mpuin > 0L)
    {
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("pubAcc", ((RespCheckPayAuth)paramObject).mpuin + "");
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("pubAccHint", ((RespCheckPayAuth)paramObject).attentionTips);
      localObject = this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle;
      if (((RespCheckPayAuth)paramObject).defaultSelected == 1) {
        bool = true;
      }
      ((Bundle)localObject).putBoolean("careFlag", bool);
    }
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle);
  }
  
  protected void b(Object paramObject, int paramInt)
  {
    boolean bool = false;
    paramObject = (PrePayRsp)paramObject;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ret=").append(((PrePayRsp)paramObject).ret);
    ((StringBuilder)localObject).append("&retry=").append(paramInt);
    if (((PrePayRsp)paramObject).ret != 0)
    {
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a(64522, ((PrePayRsp)paramObject).msg, null, null);
      VACDReportUtil.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_Long, "payauthresult", ((StringBuilder)localObject).toString(), 668806, ((PrePayRsp)paramObject).msg);
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.doPubAccPayCheck !isSuccess");
      }
      return;
    }
    ((StringBuilder)localObject).append("&ti=").append(((PrePayRsp)paramObject).tokenId);
    ((StringBuilder)localObject).append("&bi=").append(((PrePayRsp)paramObject).mchId);
    ((StringBuilder)localObject).append("&pa=").append(((PrePayRsp)paramObject).pubUin);
    ((StringBuilder)localObject).append("&pah=").append(((PrePayRsp)paramObject).subscribeInfo);
    ((StringBuilder)localObject).append("&cf=").append(((PrePayRsp)paramObject).careFlag);
    VACDReportUtil.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_Long, null, "payauthresult", ((StringBuilder)localObject).toString(), 0, null);
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("tokenId", ((PrePayRsp)paramObject).tokenId);
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("bargainorId", ((PrePayRsp)paramObject).mchId);
    if (!TextUtils.isEmpty(((PrePayRsp)paramObject).pubUin))
    {
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("pubAcc", ((PrePayRsp)paramObject).pubUin);
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle.putString("pubAccHint", ((PrePayRsp)paramObject).subscribeInfo);
      localObject = this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle;
      if (((PrePayRsp)paramObject).careFlag == 1) {
        bool = true;
      }
      ((Bundle)localObject).putBoolean("careFlag", bool);
    }
    this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity == null) || (this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.isFinishing())) {}
    int j;
    label151:
    do
    {
      return;
      j = paramMessage.what;
      if (paramMessage.arg1 == 1) {}
      for (int i = 1;; i = 0)
      {
        paramMessage = paramMessage.obj;
        if ((j != 3) && (j != 4)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " OpenPayActivity.handleMessage recevice");
        }
        if ((paramMessage != null) || (this.jdField_a_of_type_Int >= 1) || (!NetworkUtil.e(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity))) {
          break label151;
        }
        this.jdField_a_of_type_Int += 1;
        if (!this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a()) {
          break label151;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.qwallet.pay", 2, "OpenPayActivity.handleMessage retry");
        return;
      }
      String str = "retryCount=" + this.jdField_a_of_type_Int;
      if ((i != 0) && (paramMessage != null)) {
        break;
      }
      this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.a(64525, "Connection error.", null, null);
      VACDReportUtil.a(this.jdField_a_of_type_CooperationQwalletOpenOpenPayActivity.jdField_a_of_type_Long, "payauthresult", str, 668806, "connection error.");
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.pay", 2, "OpenPayActivity.handleMessage !isSuccess || data == null");
    return;
    if (j == 3)
    {
      a(paramMessage, this.jdField_a_of_type_Int);
      return;
    }
    b(paramMessage, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */