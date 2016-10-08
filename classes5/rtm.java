import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class rtm
  implements Runnable
{
  public rtm(QfileLocalFileDocTabView paramQfileLocalFileDocTabView, FileInfo paramFileInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.e());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {}
    do
    {
      return;
      ((List)localObject).add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.j();
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.setSelect(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */