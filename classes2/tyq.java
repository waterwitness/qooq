import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.qphone.base.util.QLog;

public class tyq
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  int[] jdField_a_of_type_ArrayOfInt;
  long jdField_b_of_type_Long;
  int[] jdField_b_of_type_ArrayOfInt;
  
  public tyq(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_ArrayOfInt[0] = paramInt1;
    this.jdField_b_of_type_ArrayOfInt[1] = paramInt2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 0);
    this.jdField_a_of_type_ArrayOfInt[0] = localSharedPreferences.getInt("avaliableflowxg", this.jdField_b_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_ArrayOfInt[1] = localSharedPreferences.getInt("avaliableflowifi", this.jdField_b_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_Long = localSharedPreferences.getLong("lastdaymillion", 0L);
    if (QLog.isDevelopLevel()) {
      QLog.d(PttPreSendManager.a, 4, "PttPreFlowController.loadCfg, lastDayMillion " + this.jdField_a_of_type_Long);
    }
  }
  
  public void a()
  {
    BaseApplicationImpl.a.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 0).edit().putInt("avaliableflowxg", this.jdField_a_of_type_ArrayOfInt[0]).putInt("avaliableflowifi", this.jdField_a_of_type_ArrayOfInt[1]).commit();
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (this.jdField_a_of_type_ArrayOfInt[i] <= this.jdField_b_of_type_ArrayOfInt[i]) {
        break label129;
      }
    }
    label129:
    for (int j = this.jdField_b_of_type_ArrayOfInt[i];; j = this.jdField_a_of_type_ArrayOfInt[i])
    {
      arrayOfInt[i] = j;
      if (QLog.isColorLevel()) {
        QLog.d(PttPreSendManager.a, 2, "doOnRealSend : guess hit, give back  " + paramLong + ", avaliableFlow " + this.jdField_a_of_type_ArrayOfInt[i] + ", iswifi " + paramBoolean);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i;
    int j;
    if (paramBoolean)
    {
      i = 1;
      if (!paramBoolean) {
        break label251;
      }
      j = 10000;
      label14:
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Long <= 0L) || (l <= this.jdField_a_of_type_Long) || (l - this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = this.jdField_b_of_type_ArrayOfInt[0];
        this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ArrayOfInt[1];
        if (QLog.isColorLevel()) {
          QLog.d(PttPreSendManager.a, 2, "check flow : refresh flow avalia， limitation xg: " + this.jdField_b_of_type_ArrayOfInt[0] + ", wifi: " + this.jdField_b_of_type_ArrayOfInt[1]);
        }
        this.jdField_a_of_type_Long = l;
        BaseApplicationImpl.a.getSharedPreferences("PttPreSendSp_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(), 0).edit().putLong("lastdaymillion", this.jdField_a_of_type_Long).commit();
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] < j) {
        break label258;
      }
    }
    label251:
    label258:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e(PttPreSendManager.a, 2, "check flow : support ? " + bool + " iswifi : " + paramBoolean);
      }
      return bool;
      i = 0;
      break;
      j = 4000;
      break label14;
    }
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool = true;
    int i;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 1;
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] - paramLong));
      if (this.jdField_a_of_type_ArrayOfInt[i] < 0) {
        break label144;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PttPreSendManager.a, 2, "flow consume result : " + bool + " flow " + paramLong + ", avaliableFlow " + this.jdField_a_of_type_ArrayOfInt[i] + ", iswifi " + paramBoolean);
      }
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (i >= 3)
      {
        a();
        this.jdField_a_of_type_Int = 0;
      }
      return bool;
      i = 0;
      break;
      label144:
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] = ((int)(arrayOfInt[i] + paramLong));
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */