import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class run
  implements View.OnClickListener
{
  public run(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "qfilebaserecenttabview del error, tag is null");
      }
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramView.getTag();
    if (localFileManagerEntity != null)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(null);
      }
      this.a.jdField_a_of_type_Long = localFileManagerEntity.nSessionId;
      if (QfileBaseRecentFileTabView.k(this.a).a().b(this.a.jdField_a_of_type_Long)) {
        this.a.a(localFileManagerEntity);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.a(Integer.valueOf(-1));
    paramView.setVisibility(4);
    this.a.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\run.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */