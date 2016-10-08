import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

public class vqk
  extends TroopFileProtocol.ReqDownloadFileObserver
{
  public vqk(TroopFileTransferManager paramTroopFileTransferManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      localObject = UUID.fromString(str);
      try
      {
        localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.b.get(localObject);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    paramInt = paramBundle.getInt("thumbNail");
    boolean bool = paramBundle.getBoolean("isPreview", false);
    paramBundle = new TroopFileTransferManager.PreviewInfo();
    paramBundle.jdField_a_of_type_Int = -1;
    try
    {
      paramBundle.e = ((TroopFileTransferManager.Item)localObject).Id.toString();
      if ((paramDownloadFileRspBody == null) || (!paramBoolean)) {
        if (paramInt == 128)
        {
          ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Small = false;
          return;
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        paramBundle.e = null;
      }
      if (paramInt == 640)
      {
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Large = false;
        return;
      }
      if (paramInt == 383)
      {
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Middle = false;
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Middle_Fail = true;
        this.a.a((TroopFileTransferManager.Item)localObject);
        return;
      }
      if (bool)
      {
        TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.g, 700);
        paramBundle.jdField_a_of_type_Boolean = false;
        ((BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
      this.a.a((TroopFileTransferManager.Item)localObject, 10, 103);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    paramBundle.jdField_a_of_type_Int = i;
    if (bool)
    {
      paramBundle.jdField_a_of_type_Boolean = false;
      paramBundle.jdField_a_of_type_JavaLangString = paramDownloadFileRspBody.str_download_ip.get();
      if ((TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) || (paramBundle.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        paramBundle.jdField_a_of_type_JavaLangString = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      paramBundle.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      paramBundle.c = paramDownloadFileRspBody.str_ret_msg.get();
      paramBundle.d = HexUtil.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileTransferManager", 4, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(i) }));
    }
    ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Middle_Fail = false;
    if (i < 0)
    {
      if (paramInt == 128)
      {
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Small = false;
        return;
      }
      if (paramInt == 640)
      {
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Large = false;
        return;
      }
      if (paramInt == 383)
      {
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Middle = false;
        ((TroopFileTransferManager.Item)localObject).ThumbnailDownloading_Middle_Fail = true;
        this.a.a((TroopFileTransferManager.Item)localObject);
        return;
      }
      if (bool)
      {
        TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.g, 700);
        if (TextUtils.isEmpty(paramBundle.c)) {
          paramBundle.c = "生成预览文件失败";
        }
        paramBundle.jdField_a_of_type_Boolean = false;
        ((BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
    }
    switch (i)
    {
    case -134: 
    default: 
      if (bool)
      {
        paramBundle.jdField_a_of_type_Boolean = true;
        ((BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).c(paramBundle);
        return;
      }
      break;
    case -107: 
    case -102: 
      this.a.a((TroopFileTransferManager.Item)localObject, 10, 101);
      return;
    case -302: 
    case -301: 
    case -103: 
      this.a.b((TroopFileTransferManager.Item)localObject, 301);
      if (((TroopFileTransferManager.Item)localObject).TmpFile != null) {
        new File(((TroopFileTransferManager.Item)localObject).TmpFile).delete();
      }
      if (((TroopFileTransferManager.Item)localObject).HasThumbnailFile_Small) {
        new File(((TroopFileTransferManager.Item)localObject).getThumbnailFile(this.a.g, 128)).delete();
      }
      for (;;)
      {
        TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject);
        return;
        if (((TroopFileTransferManager.Item)localObject).HasThumbnailFile_Large) {
          new File(((TroopFileTransferManager.Item)localObject).getThumbnailFile(this.a.g, 640)).delete();
        }
      }
    }
    ((TroopFileTransferManager.Item)localObject).cookieValue = HexUtil.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
      ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
    }
    ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    ((TroopFileTransferManager.Item)localObject).DownloadUrl = HexUtil.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if ((i == 65403) || (i == 65404)) {
      this.a.a((TroopFileTransferManager.Item)localObject, ((TroopFileTransferManager.Item)localObject).Status, 309);
    }
    while ((paramInt == 128) || (paramInt == 383) || (paramInt == 640))
    {
      new TroopFileTransferManager.TaskHttpDownloadThumbnail(this.a, (TroopFileTransferManager.Item)localObject, paramInt);
      return;
      if (i == 65402)
      {
        this.a.a((TroopFileTransferManager.Item)localObject, 10, 302);
        return;
      }
    }
    if (!this.a.b((TroopFileTransferManager.Item)localObject)) {
      new TroopFileTransferManager.TaskHttpDownload(this.a, (TroopFileTransferManager.Item)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */