import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class sfh
  implements TbsReaderView.ReaderCallback
{
  public sfh(LocalTbsViewManager paramLocalTbsViewManager, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalTbsViewManager<FileAssistant>", 1, "recv actionType[" + paramInteger + "]");
    }
    if (paramInteger.intValue() == 5012)
    {
      int i = ((Integer)paramObject1).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("LocalTbsViewManager<FileAssistant>", 1, "err Code[" + i + "]");
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "canOpenFile return ok 1-------");
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback.b(true);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "canOpenFile return ok 2-------");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback.b(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */