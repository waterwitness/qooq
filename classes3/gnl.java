import android.content.Intent;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class gnl
  extends TroopObserver
{
  public gnl(QQServiceForAV paramQQServiceForAV)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    if ((paramBoolean) && (paramInt1 == 2))
    {
      if (TextUtils.isEmpty(this.a.d)) {
        this.a.d = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      paramLong2 = Long.valueOf(this.a.d).longValue();
      if (paramList == null)
      {
        paramInt1 = 0;
        paramInt2 = 0;
        label66:
        if (paramInt2 >= paramInt1) {
          break label151;
        }
        paramString = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((paramString != null) && (paramString.uint64_member_uin.has())) {
          break label124;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        break label66;
        paramInt1 = paramList.size();
        break;
        label124:
        if (paramString.uint64_member_uin.get() == paramLong2) {
          this.a.a(paramLong1, paramLong2);
        }
      }
      label151:
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a.a());
    }
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("onJoinOrExitOpenTroop --> success: %b, troopUin: %s, errorTips: %s isJoin: %b , visitorSpeakEnabled: %b, speakInterval: %d, startSpeakInterval: %d", new Object[] { Boolean.valueOf(paramBoolean1), paramString, str, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    if (paramBoolean2)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.JoinOpenGroup");
      localIntent.putExtra("troopUin", paramString);
      localIntent.putExtra("success", paramBoolean1);
      localIntent.putExtra("errorTips", str);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean3);
      localIntent.putExtra("speakInterval", paramInt2);
      localIntent.putExtra("startSpeakInterval", paramInt3);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  protected void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    synchronized (this.a.jdField_a_of_type_AndroidOsRemoteCallbackList)
    {
      int j = this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IQQServiceCallback)this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(paramArrayOfRecvGVideoLevelInfo);
            i += 1;
          }
          catch (RemoteException paramArrayOfRecvGVideoLevelInfo)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramArrayOfRecvGVideoLevelInfo);
            }
          }
        }
      }
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */