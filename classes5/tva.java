import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class tva
  extends CardObserver
{
  public tva(VipProfileCardBaseActivity paramVipProfileCardBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    String str = this.a.app.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_BackgroundId", String.valueOf(this.a.C));
    localHashMap.put("param_StyleId", String.valueOf(this.a.jdField_a_of_type_Long));
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.b();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card)) {
        ThreadManager.a(new tvb(this, (Card)paramObject, localHashMap, str), 5, null, true);
      }
      while (!(paramObject instanceof Pair)) {
        return;
      }
      paramObject = (Pair)paramObject;
      Message localMessage;
      if (((Integer)((Pair)paramObject).first).intValue() == 101107)
      {
        this.a.jdField_a_of_type_Int = 1;
        this.a.d = 2;
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      for (;;)
      {
        localHashMap.put("param_FailCode", String.valueOf(((Pair)paramObject).first));
        StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
        return;
        if (((Integer)((Pair)paramObject).first).intValue() == 101108)
        {
          this.a.jdField_a_of_type_Int = 2;
          this.a.d = 5;
          localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        else
        {
          localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
          if ((((Integer)((Pair)paramObject).first).intValue() >= 400000) && (((Integer)((Pair)paramObject).first).intValue() <= 499999)) {
            localMessage.obj = ((Pair)paramObject).second;
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramObject = "-104";; paramObject = "-105")
    {
      localHashMap.put("param_FailCode", paramObject);
      StatisticCollector.a(this.a.app.a()).a(str, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)paramObject);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */