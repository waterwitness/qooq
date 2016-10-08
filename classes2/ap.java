import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ap
  implements FMDialogUtil.FMDialogInterface
{
  ap(am paramam, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      FMToastUtil.b(FileManagerUtil.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362813));
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_Am.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(i).c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    FMToastUtil.b(FileManagerUtil.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362813));
    this.jdField_a_of_type_Am.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */