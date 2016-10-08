import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rqx
  implements FMDialogUtil.FMDialogInterface
{
  rqx(rqu paramrqu, WeiYunFileInfo paramWeiYunFileInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo);
    QfileBaseCloudFileTabView.k(this.jdField_a_of_type_Rqu.a).a().b(localFileManagerEntity);
    QfileBaseCloudFileTabView.l(this.jdField_a_of_type_Rqu.a).a().a(localFileManagerEntity);
    this.jdField_a_of_type_Rqu.a.a(localFileManagerEntity);
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */