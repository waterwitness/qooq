import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader;
import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class qno
  implements Runnable
{
  public qno(FTSMsgUpgrader paramFTSMsgUpgrader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!FTSMsgUpgrader.a(this.a)) && (FTSMsgUpgrader.a(this.a).a().a())) {
      if ((FTSMsgUpgrader.a(this.a) != null) && (FTSMsgUpgrader.a(this.a).a()))
      {
        if (!this.a.a) {
          FTSMsgUpgrader.a(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.a.a + " mUpgradeCursor=" + FTSMsgUpgrader.a(this.a) + " mUpgradeMaxIndex=" + FTSMsgUpgrader.b(this.a));
        }
        if (this.a.a)
        {
          if (FTSMsgUpgrader.a(this.a) >= FTSMsgUpgrader.b(this.a)) {
            break label201;
          }
          if (!FTSMsgUpgrader.b(this.a)) {
            break label186;
          }
        }
      }
    }
    label186:
    label201:
    while (!QLog.isColorLevel())
    {
      do
      {
        FTSMsgUpgrader.a(this.a).postDelayed(this, 20L);
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        FTSMsgUpgrader.b(this.a);
        FTSMsgUpgrader.a(this.a).c();
        return;
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (FTSMsgUpgrader.a(this.a) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle isDestroy = " + FTSMsgUpgrader.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */