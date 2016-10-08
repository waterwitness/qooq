import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListView.OnGroupCollapseListener;

public class rre
  implements ExpandableListView.OnGroupCollapseListener
{
  public rre(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getGroupCount() - 1) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */