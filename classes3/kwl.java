import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class kwl
  implements FMDialogUtil.FMDialogInterface
{
  public kwl(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, FileManagerEngine paramFileManagerEngine)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.b(localFileManagerEntity);
    }
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kwl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */