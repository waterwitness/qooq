import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class syu
  implements BusinessObserver
{
  public syu(UiApiPlugin paramUiApiPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    byte[] arrayOfByte;
    if (paramBoolean)
    {
      arrayOfByte = paramBundle.getByteArray("data");
      paramBundle.getString("openId");
      if (arrayOfByte != null) {
        paramBundle = new oidb_sso.OIDBSSOPkg();
      }
    }
    try
    {
      paramBundle = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])arrayOfByte);
      paramInt = paramBundle.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d(UiApiPlugin.a + ".troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x716_48Rsp, resultCode:" + paramInt);
      }
      paramBundle = paramBundle.bytes_bodybuffer.get().toByteArray();
      if (paramInt == 0)
      {
        arrayOfByte = new byte[4];
        System.arraycopy(paramBundle, 0, arrayOfByte, 0, 4);
        paramBundle = TroopInfoActivity.a(String.valueOf(ByteBuffer.wrap(arrayOfByte).getInt() + ""), 32);
        ChatSettingForTroop.a(UiApiPlugin.a(this.a), paramBundle, -1);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(UiApiPlugin.a + ".troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + paramBundle.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */