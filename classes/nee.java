import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public final class nee
  extends TroopObserver
{
  public nee(SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      QWalletHelper.b(this.a.a);
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "onOIDB0X88D_0_Ret 群uin：" + this.a.a + " 群成员个数：" + paramTroopInfo.wMemberNum);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */