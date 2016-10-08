import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public final class sdh
  implements View.OnClickListener
{
  public sdh(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localFileManagerEntity);
    Object localObject1 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Int = 71;
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Long = localFileManagerEntity.fileSize;
    ((FileManagerReporter.fileAssistantReportData)localObject1).c = FileUtil.a(localFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject1).d = FileManagerUtil.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject1);
    Object localObject2 = ForwardFileOption.a(localFileManagerEntity);
    ((ForwardFileInfo)localObject2).b(this.jdField_a_of_type_Int);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("forward_type", 0);
    ((Bundle)localObject1).putParcelable("fileinfo", (Parcelable)localObject2);
    ((Bundle)localObject1).putBoolean("not_forward", true);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("destroy_last_activity", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    ((Intent)localObject2).putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    ((Intent)localObject2).putExtra("forward_text", "已选择" + FileManagerUtil.d(localFileManagerEntity.fileName) + "。");
    ((Intent)localObject2).putExtra("k_favorites", FileManagerUtil.c(localFileManagerEntity));
    if ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7))
    {
      ((Intent)localObject2).putExtra("isFromShare", true);
      if (localFileManagerEntity.nFileType == 0) {
        ((Intent)localObject2).putExtra("forward_type", 1);
      }
    }
    if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
      ((Intent)localObject2).putExtra("forward_type", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ActionBarUtil getFileForwardClick forwardType=" + this.jdField_a_of_type_Int + "newEntity.nFileType=" + localFileManagerEntity.nFileType);
    }
    if ((((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof TroopFileDetailBrowserActivity))) && (((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).f())) {
      ((Intent)localObject2).putExtra("direct_send_if_dataline_forward", true);
    }
    ((Intent)localObject2).putExtra("forward_source_uin_type", localFileManagerEntity.peerType);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 103);
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */