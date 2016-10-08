import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import java.util.UUID;

public class sdc
  implements View.OnClickListener
{
  public sdc(ActionBarTroopFile paramActionBarTroopFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject1).a = 9;
    FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(), (FileManagerReporter.fileAssistantReportData)localObject1);
    if (NetworkUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()) == 0)
    {
      TroopFileError.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131364197));
      return;
    }
    Object localObject2 = new FileManagerEntity();
    ((FileManagerEntity)localObject2).copyFrom(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    ((FileManagerEntity)localObject2).nSessionId = FileManagerUtil.a().longValue();
    ((FileManagerEntity)localObject2).status = 2;
    localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).a().d((FileManagerEntity)localObject2);
    }
    localObject1 = TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), (FileManagerEntity)localObject2);
    Object localObject3 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject3).b(((FileManagerEntity)localObject2).nSessionId);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).getFilePath())) {
      ((ForwardFileInfo)localObject3).a(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaLangString);
    }
    ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).g);
    ((ForwardFileInfo)localObject3).d(((TroopFileStatusInfo)localObject1).b);
    ((ForwardFileInfo)localObject3).a(((FileManagerEntity)localObject2).TroopUin);
    if (((FileManagerEntity)localObject2).isZipInnerFile)
    {
      ((ForwardFileInfo)localObject3).b(10000);
      ((ForwardFileInfo)localObject3).d(3);
    }
    for (;;)
    {
      ((ForwardFileInfo)localObject3).a(2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", 0);
      ((Bundle)localObject2).putParcelable("fileinfo", (Parcelable)localObject3);
      ((Bundle)localObject2).putBoolean("not_forward", true);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      ((Intent)localObject3).putExtra("forward_text", ((TroopFileStatusInfo)localObject1).g);
      ((Intent)localObject3).putExtra("forward_from_troop_file", true);
      ForwardBaseOption.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), (Intent)localObject3, 103);
      paramView = paramView.getTag();
      if ((paramView instanceof HorizontalListViewAdapter.HlistViewHolder))
      {
        paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView;
        if (paramView.a.isShowing()) {
          paramView.a.dismiss();
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.j();
      return;
      if (((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID != null) {
        ((ForwardFileInfo)localObject3).e(((TroopFileStatusInfo)localObject1).jdField_a_of_type_JavaUtilUUID.toString());
      }
      ((ForwardFileInfo)localObject3).b(10006);
      ((ForwardFileInfo)localObject3).d(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */