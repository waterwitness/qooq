import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class sbx
  implements View.OnClickListener
{
  public sbx(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j = 2131362852;
    if (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      BaseActionBarDataLineFile.b(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131362941);
      return;
    }
    Object localObject;
    int i;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 6) {
      if (FileManagerUtil.a())
      {
        paramView = new sby(this);
        localObject = new sbz(this);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break label954;
        }
        i = 2131362851;
        j = 2131362128;
      }
    }
    for (;;)
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(i);
      DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 230, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(j), str, 2131367262, 2131362134, paramView, (DialogInterface.OnClickListener)localObject).show();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        i = DataLineMsgRecord.getDevTypeBySeId(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(i).a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        if (paramView != null) {
          paramView.setPaused(false);
        }
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        BaseActionBarDataLineFile.c(this.a);
      }
      for (;;)
      {
        this.a.k();
        return;
        BaseActionBarDataLineFile.d(this.a);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 7)
      {
        if (FileManagerUtil.a())
        {
          paramView = new sca(this);
          localObject = new scb(this);
          str = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362855);
          DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 230, str, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(2131362852), 2131367262, 2131362134, paramView, (DialogInterface.OnClickListener)localObject).show();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
        {
          BaseActionBarDataLineFile.b(this.a, System.currentTimeMillis());
          FMToastUtil.a("'" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "'" + BaseApplication.getContext().getResources().getString(2131362193));
          return;
        }
        BaseActionBarDataLineFile.e(this.a);
        this.a.k();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 8) {
        break;
      }
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq);
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(BaseActionBarDataLineFile.a(), 2, "get mr is null ");
        return;
      }
      if (paramView.isSendFromLocal())
      {
        if (!(paramView instanceof MessageForDeviceFile)) {
          break;
        }
        paramView = (MessageForDeviceFile)paramView;
        paramView = ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49)).a().a(paramView.strServiceName, paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramView.uSessionID;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = paramView.uniseq;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        this.a.k();
        return;
      }
      if ((paramView instanceof MessageForDeviceSingleStruct))
      {
        paramView = (MessageForDeviceSingleStruct)paramView;
        paramView = ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(49)).a().a(paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = paramView.nMediaSessionID;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = paramView.uniseq;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        this.a.k();
        return;
      }
      if (!(paramView instanceof MessageForDeviceFile)) {
        break;
      }
      if (FileManagerUtil.a())
      {
        paramView = new scc(this, paramView);
        localObject = new scd(this);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break label946;
        }
        j = 2131362851;
      }
      label946:
      for (i = 2131362128;; i = 2131362131)
      {
        str = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(j);
        DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 230, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(i), str, 2131367262, 2131362134, paramView, (DialogInterface.OnClickListener)localObject).show();
        return;
        this.a.a(paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = ((MessageForDeviceFile)paramView).uSessionID;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = ((MessageForDeviceFile)paramView).uniseq;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        this.a.k();
        return;
      }
      label954:
      j = 2131362131;
      i = 2131362852;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */