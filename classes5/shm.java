import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.ZipPreviewFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class shm
  extends TroopFileProtocol.GetOneFileInfoObserver
{
  public shm(ZipPreviewFileView paramZipPreviewFileView, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      String str = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.a, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin), paramFileInfo.uint64_uploader_uin.get() + "");
      paramFileInfo = new Date(paramFileInfo.uint32_upload_time.get() * 1000L);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
      paramFileInfo = " 于" + localSimpleDateFormat.format(paramFileInfo) + "上传";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.c.setText(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewZipPreviewFileView.d.setText(paramFileInfo);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */