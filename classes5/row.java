import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class row
  implements View.OnClickListener
{
  public row(LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
    paramView = ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    if (paramView.a()) {
      LocalFileBrowserActivity.a(this.a, paramView.d(), true);
    }
    do
    {
      return;
      if (this.a.f())
      {
        if (FMDataCache.a(paramView)) {
          FMDataCache.b(paramView);
        }
        for (;;)
        {
          this.a.k();
          if (!this.a.f()) {
            break;
          }
          ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(paramView));
          return;
          if (this.a.f) {
            FMDataCache.b();
          }
          if (paramView.b() == -1) {
            paramView.b(FileManagerUtil.a(paramView.d()));
          }
          FMDataCache.a(paramView);
          if (this.a.f) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        ((LocalFileAdapter.LocalFileItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        return;
      }
      if (this.a.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(LocalFileBrowserActivity.e, 2, "click too fast , wait a minute.");
    return;
    this.a.e();
    Object localObject2 = FileManagerUtil.a(paramView);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject2).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    localForwardFileInfo.a(paramView.d());
    localForwardFileInfo.d(paramView.e());
    localForwardFileInfo.d(paramView.a());
    localObject1 = new Intent(this.a.getApplicationContext(), FileBrowserActivity.class);
    ((Intent)localObject1).putExtra("fileinfo", localForwardFileInfo);
    if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1))
    {
      FMDataCache.a(this.a.b);
      ((Intent)localObject1).putExtra("clicked_file_hashcode", paramView.hashCode());
    }
    localObject2 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject2).b = "file_viewer_in";
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Int = 80;
    ((FileManagerReporter.fileAssistantReportData)localObject2).c = FileUtil.a(paramView.e());
    ((FileManagerReporter.fileAssistantReportData)localObject2).jdField_a_of_type_Long = paramView.a();
    FileManagerReporter.a(this.a.app.a(), (FileManagerReporter.fileAssistantReportData)localObject2);
    this.a.startActivityForResult((Intent)localObject1, 102);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\row.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */