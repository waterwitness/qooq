import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class qnq
  implements Runnable
{
  qnq(qnp paramqnp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "getTroopsMemberList after 24 h");
    }
    FTSTroopOperator.a(this.a.a).d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qnq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */