import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x487.oidb_0x487.GroupList;
import tencent.im.oidb.cmd0x487.oidb_0x487.RspBody;

public class hmx
  extends ProtoUtils.TroopProtocolObserver
{
  public hmx(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailActivity.bindTroop", 2, "onResult, errorCode=" + paramInt);
    }
    int i;
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      try
      {
        paramBundle = new oidb_0x487.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        k = paramBundle.uint32_result.get();
        if (k != 0) {
          break label468;
        }
        paramArrayOfByte = new ArrayList();
        if (!paramBundle.msg_groups.has()) {
          break label463;
        }
        localObject1 = paramBundle.msg_groups.get();
        if (localObject1 == null) {
          break label463;
        }
        int j = ((List)localObject1).size();
        i = 0;
        paramInt = j;
        if (i < j)
        {
          localObject2 = ((oidb_0x487.GroupList)((List)localObject1).get(i)).uint64_groupcode.get() + "";
          ((oidb_0x487.GroupList)((List)localObject1).get(i)).bytes_group_name.get().toStringUtf8();
          paramArrayOfByte.add(localObject2);
          if (paramArrayOfByte.size() < 3) {
            break label474;
          }
          paramInt = j;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int k;
        Object localObject1;
        Object localObject2;
        while (QLog.isColorLevel())
        {
          QLog.e("AccountDetailActivity.bindTroop", 2, "getBindedTroops, exception=" + paramArrayOfByte.toString());
          return;
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayOfByte);
      if (paramBundle.uint32_privilege_flag.has())
      {
        localObject1 = this.a;
        if (paramBundle.uint32_privilege_flag.get() != 1) {
          break label483;
        }
      }
    }
    label463:
    label468:
    label474:
    label483:
    for (boolean bool = true;; bool = false)
    {
      ((AccountDetailActivity)localObject1).x = bool;
      localObject1 = (TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("mIsAbleBindTroop", this.a.x);
      ((Bundle)localObject2).putStringArrayList("mBindedTroopUins", paramArrayOfByte);
      ((TroopBindPublicAccountMgr)localObject1).a(this.a.p, (Bundle)localObject2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (QLog.isColorLevel())
      {
        if (paramBundle.bytes_errmsg.has()) {}
        for (paramArrayOfByte = paramBundle.bytes_errmsg.get().toStringUtf8();; paramArrayOfByte = "")
        {
          QLog.d("AccountDetailActivity.bindTroop", 2, "onResult, ret=" + k + "," + paramInt + "," + paramArrayOfByte + "," + this.a.x);
          return;
        }
      }
      return;
      i += 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */