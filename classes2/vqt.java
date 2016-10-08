import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vqt
  extends TroopObserver
{
  public vqt(TroopGagMgr paramTroopGagMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopGagMgr", 2, localStringBuilder.toString());
    }
    ThreadManager.a(new vqu(this, paramInt1, paramBoolean, paramList, paramLong1), 5, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */