import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class lrj
  extends Handler
{
  public lrj(Leba paramLeba)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_AndroidContentIntent == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    EcshopReportHandler localEcshopReportHandler;
    label405:
    label517:
    do
    {
      do
      {
        for (;;)
        {
          return;
          localEcshopReportHandler = (EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
          if ((4 == paramMessage.what) && (1 == paramMessage.arg1))
          {
            String str1 = String.valueOf(System.currentTimeMillis() - this.a.c);
            new AuthCodeRsp();
            try
            {
              Object localObject = (AuthCodeRsp)paramMessage.obj;
              i = ((AuthCodeRsp)localObject).items.size() - 1;
              if (i >= 0)
              {
                paramMessage = (AuthCodeItem)((AuthCodeRsp)localObject).items.get(i);
                if (paramMessage.appid != 100273020L) {
                  break label517;
                }
                localObject = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
                String str2 = paramMessage.authCode;
                if (str2 == null) {
                  return;
                }
                localObject = URLUtil.a((String)localObject, "code", paramMessage.authCode);
                this.a.jdField_a_of_type_AndroidContentIntent.putExtra("url", (String)localObject);
                this.a.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
                if (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
                  break label405;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("AuthCode", 2, "newUrl:" + (String)localObject);
                }
                this.a.a(this.a.jdField_a_of_type_AndroidContentIntent);
                this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                this.a.q();
                if (localEcshopReportHandler != null) {
                  localEcshopReportHandler.a(134246777, null, "jump", str1, "hascode", 0L, false);
                }
              }
              for (;;)
              {
                return;
                if (localEcshopReportHandler != null) {
                  localEcshopReportHandler.a(134246777, null, "not_jump", str1, "", 0L, false);
                }
                this.a.jdField_a_of_type_WalletAuthCodeItem = paramMessage;
              }
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                int i;
                QLog.e("AuthCode", 1, "authcode resp exception:" + paramMessage);
                return;
                i -= 1;
              }
            }
            finally
            {
              if (!this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                if (localEcshopReportHandler != null) {
                  localEcshopReportHandler.a(134246777, null, "jump", str1, "no_code", 0L, false);
                }
                this.a.a(this.a.jdField_a_of_type_AndroidContentIntent);
                this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              }
            }
          }
        }
      } while ((1 != paramMessage.what) || (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
      if (QLog.isColorLevel()) {
        QLog.e("AuthCode", 2, "time out jump!");
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.a(this.a.jdField_a_of_type_AndroidContentIntent);
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    } while (localEcshopReportHandler == null);
    localEcshopReportHandler.a(134246777, null, "jump", "time_out", "no_code", 0L, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */