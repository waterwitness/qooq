import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;

public class vmx
  extends TroopFileProtocol.GetFilePreviewObserver
{
  public vmx(TroopFileItemOperation paramTroopFileItemOperation, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramString1 = ZipPreviewFileView.a(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipType;
    paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramString1 + "&filetype=" + paramInt1 + "&path=" + URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath) + "&";
    TroopFileTransferManager.a((QQAppInterface)this.b.get(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */