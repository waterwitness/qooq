import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pvs
  implements Runnable
{
  public pvs(ConditionSearchManager paramConditionSearchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = this.a.a();
    int i = -1;
    if (j != 0) {
      i = this.a.a(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "pendCardParseRequest | check reuslt = " + j + " | update result = " + i);
    }
    if (j == 0) {
      ConditionSearchManager.a(this.a).a(new pvt(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */