import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class idc
  extends MqqHandler
{
  public idc(SubscriptFeedsActivity paramSubscriptFeedsActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1002: 
            try
            {
              paramMessage = TroopBarAssistantManager.a().b(this.a.app);
              this.a.runOnUiThread(new idd(this, paramMessage));
              return;
            }
            catch (Exception paramMessage) {}
          }
        } while (!QLog.isColorLevel());
        QLog.i(SubscriptFeedsActivity.a(), 2, paramMessage.toString());
        return;
        this.a.runOnUiThread(new ide(this));
        return;
        paramMessage = paramMessage.getData();
      } while ((paramMessage == null) || (!ReadInJoyHelper.a()));
      paramMessage = paramMessage.getSerializable("ReadInJoyArticleList");
    } while ((paramMessage == null) || (!(paramMessage instanceof ArrayList)));
    if ((!SubscriptFeedsActivity.a(this.a, (ArrayList)paramMessage)) && (QLog.isColorLevel())) {
      QLog.d(SubscriptFeedsActivity.a(), 2, "onGetRecommendReadInJoyArticleList data save to sp fail");
    }
    this.a.runOnUiThread(new idf(this, paramMessage));
    return;
    this.a.runOnUiThread(new idg(this));
    return;
    this.a.runOnUiThread(new idh(this));
    return;
    this.a.runOnUiThread(new idi(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\idc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */