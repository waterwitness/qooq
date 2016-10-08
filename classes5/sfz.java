import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.OfflineVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

class sfz
  extends TroopFileProtocol.GetFilePreviewObserver
{
  sfz(sfy paramsfy, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    paramByteStringMicro1 = ZipPreviewFileView.a(paramByteStringMicro1);
    paramString2 = null;
    paramString1 = paramString2;
    if (paramBoolean)
    {
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipType;
        paramString1 = "http://" + paramString3 + ":" + paramInt3 + "/ftn_compress_getfile/rkey=" + paramByteStringMicro1 + "&filetype=" + paramInt1 + "&path=" + URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath) + "&";
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_Sfy.a.b = paramString1;
      this.jdField_a_of_type_Sfy.a.c = paramString4;
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "url = " + this.jdField_a_of_type_Sfy.a.b + ", cookies = " + this.jdField_a_of_type_Sfy.a.c);
      }
      this.jdField_a_of_type_Sfy.a.a.sendMessage(this.jdField_a_of_type_Sfy.a.a.obtainMessage(3));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("zivonchen", 2, "url = " + this.jdField_a_of_type_Sfy.a.b + ", cookies = " + this.jdField_a_of_type_Sfy.a.c);
    }
    this.jdField_a_of_type_Sfy.a.a.sendMessage(this.jdField_a_of_type_Sfy.a.a.obtainMessage(4));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */