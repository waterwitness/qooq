import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqTransFileObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileRspBody;

public class vps
  extends TroopFileProtocol.ReqTransFileObserver
{
  public vps(TroopFileManager paramTroopFileManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.TransFileRspBody paramTransFileRspBody, Bundle paramBundle)
  {
    Object localObject = this.a;
    ((TroopFileManager)localObject).jdField_c_of_type_Int -= 1;
    if ((!paramBoolean) || (paramTransFileRspBody == null)) {
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileManager", 4, "onTransFileResult, isSuccess:" + paramBoolean + "transFileResp:" + paramTransFileRspBody);
      }
    }
    do
    {
      return;
      localObject = paramBundle.getString("fileId");
      paramBundle = (TroopFileInfo)this.a.jdField_c_of_type_JavaUtilMap.get(localObject);
    } while (paramBundle == null);
    int i = paramTransFileRspBody.int32_ret_code.get();
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileManager", 4, String.format("onRspTransFile - retCode: %d", new Object[] { Integer.valueOf(i) }));
    }
    if (i < 0)
    {
      paramInt = 501;
      switch (i)
      {
      }
      for (;;)
      {
        this.a.a(paramBundle, paramInt);
        return;
        paramInt = 504;
        continue;
        paramInt = 103;
        continue;
        paramInt = 101;
        continue;
        paramInt = 503;
        continue;
        paramInt = 502;
      }
    }
    paramTransFileRspBody = paramTransFileRspBody.str_save_file_path.get();
    this.a.a.a(paramBundle.jdField_a_of_type_JavaUtilUUID, paramTransFileRspBody);
    paramBundle.b = paramTransFileRspBody;
    paramBundle.jdField_a_of_type_Int = 102;
    paramBundle.jdField_c_of_type_Int = 0;
    this.a.jdField_c_of_type_JavaUtilMap.remove(localObject);
    this.a.jdField_c_of_type_JavaUtilMap.put(paramTransFileRspBody, paramBundle);
    this.a.d(paramBundle);
    paramTransFileRspBody = (TroopFileManager.FileManagerStatus)this.a.d.get(paramBundle.f);
    if (paramTransFileRspBody != null) {
      paramTransFileRspBody.a = null;
    }
    this.a.a(paramBundle, 505);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */