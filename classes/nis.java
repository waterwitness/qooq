import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.open.base.MD5Utils;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class nis
  implements View.OnClickListener
{
  public nis(DeviceSingleStructBuilder paramDeviceSingleStructBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)AIOUtils.a(paramView);
    if (localMessageForDeviceSingleStruct == null) {}
    do
    {
      return;
      if ((TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaFileName)) && (localMessageForDeviceSingleStruct.nMediaChannelType == 2) && (!TextUtils.isEmpty(localMessageForDeviceSingleStruct.strMediaKey))) {
        localMessageForDeviceSingleStruct.strMediaFileName = (MD5Utils.d(localMessageForDeviceSingleStruct.strMediaKey) + localMessageForDeviceSingleStruct.strMediaKey.substring(localMessageForDeviceSingleStruct.strMediaKey.lastIndexOf(".")));
      }
      localDeviceInfo = ((SmartDeviceProxyMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(localMessageForDeviceSingleStruct.senderuin));
    } while (localDeviceInfo == null);
    if (localDeviceInfo.isAdmin == 1) {
      i = 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("title", localMessageForDeviceSingleStruct.strTitle);
        ((JSONObject)localObject1).put("digest", localMessageForDeviceSingleStruct.strDigest);
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        paramView = localMessageForDeviceSingleStruct.strMediaPath;
        ((JSONObject)localObject1).put("file_path_url", paramView);
        ((JSONObject)localObject1).put("thumb_path_url", localMessageForDeviceSingleStruct.strCoverPath);
        ((JSONObject)localObject1).put("guide_words", localMessageForDeviceSingleStruct.strGuideWords);
        ((JSONObject)localObject1).put("appear_time", localMessageForDeviceSingleStruct.nAppearTime);
        ((JSONObject)localObject1).put("data_type", localMessageForDeviceSingleStruct.nDataType);
        ((JSONObject)localObject1).put("face", localMessageForDeviceSingleStruct.faceRect);
        ((JSONObject)localObject1).put("cover_session_id", localMessageForDeviceSingleStruct.nCoverSessionID);
        ((JSONObject)localObject1).put("media_session_id", localMessageForDeviceSingleStruct.nMediaSessionID);
        if (localMessageForDeviceSingleStruct.nCoverChannelType != 1) {
          continue;
        }
        ((JSONObject)localObject1).put("cover_key", localMessageForDeviceSingleStruct.strCoverKey);
      }
      catch (JSONException paramView)
      {
        long l;
        int j;
        paramView.printStackTrace();
        paramView = null;
        continue;
        ((JSONObject)localObject1).put("cover_url", localMessageForDeviceSingleStruct.strCoverKey);
        continue;
        if (localMessageForDeviceSingleStruct.nMediaChannelType != 3) {
          continue;
        }
        ((JSONObject)localObject1).put("media_mini", localMessageForDeviceSingleStruct.strMediaKey);
        ((JSONObject)localObject1).put("fkey2", localMessageForDeviceSingleStruct.strCoverKey2);
        continue;
        ((JSONObject)localObject1).put("media_url", localMessageForDeviceSingleStruct.strMediaKey);
        continue;
        Object localObject1 = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localMessageForDeviceSingleStruct.url);
        if ((localObject1 == null) || (!"openLightApp".equals(((JumpAction)localObject1).ft)) || (!"url".equals(((JumpAction)localObject1).fu))) {
          continue;
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("param_meta_data", paramView);
        SmartDeviceUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localDeviceInfo, ((JumpAction)localObject1).a("url_prefix"), (Bundle)localObject2);
        continue;
        if ((i == 0) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.faceRect)) || (!DeviceSingleStructBuilder.a(this.a, localMessageForDeviceSingleStruct.faceRect)) || (TextUtils.isEmpty(localMessageForDeviceSingleStruct.strCoverPath))) {
          continue;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("device_id", localDeviceInfo.din + "");
        if (localMessageForDeviceSingleStruct.nMediaFileStatus != 5) {
          continue;
        }
        paramView = localMessageForDeviceSingleStruct.strMediaPath;
        ((Intent)localObject1).putExtra("filepath", paramView);
        ((Intent)localObject1).putExtra("rect", localMessageForDeviceSingleStruct.faceRect);
        ((Intent)localObject1).putExtra("from", 0);
        SmartDevicePluginLoader.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.face.FaceRegisterActivity", -1, null, SmartDevicePluginProxyActivity.class);
        continue;
        paramView = localMessageForDeviceSingleStruct.strCoverPath;
        continue;
        i = FileManagerUtil.a(FileUtil.a(localMessageForDeviceSingleStruct.strMediaFileName));
        paramView = FileManagerUtil.a(localMessageForDeviceSingleStruct);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).b(10009);
        ((ForwardFileInfo)localObject2).d(8);
        ((ForwardFileInfo)localObject2).b(paramView.nSessionId);
        ((ForwardFileInfo)localObject2).d(paramView.fileName);
        ((ForwardFileInfo)localObject2).c(paramView.uniseq);
        ((ForwardFileInfo)localObject2).d(paramView.fileSize);
        ((ForwardFileInfo)localObject2).f(paramView.strThumbPath);
        ((ForwardFileInfo)localObject2).a(paramView.getFilePath());
        localObject1 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
        localObject2 = new ArrayList();
        if ((i != 0) && (i != 1)) {
          continue;
        }
        ((ArrayList)localObject2).add(String.valueOf(paramView.nSessionId));
        ((Intent)localObject1).putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject2);
        ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 102);
        continue;
        i = 3;
        continue;
      }
      if (localMessageForDeviceSingleStruct.nMediaChannelType != 1) {
        continue;
      }
      ((JSONObject)localObject1).put("media_key", localMessageForDeviceSingleStruct.strMediaKey);
      ((JSONObject)localObject1).put("jump_url", localMessageForDeviceSingleStruct.url);
      ((JSONObject)localObject1).put("msg_time", localMessageForDeviceSingleStruct.time);
      ((JSONObject)localObject1).put("ext", localMessageForDeviceSingleStruct.ext);
      paramView = new JSONObject();
      paramView.put("struct_msg", localObject1);
      paramView = paramView.toString();
      if (TextUtils.isEmpty(localMessageForDeviceSingleStruct.url)) {
        continue;
      }
      if ((!localMessageForDeviceSingleStruct.url.startsWith("http://")) && (!localMessageForDeviceSingleStruct.url.startsWith("https://"))) {
        continue;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("url", localMessageForDeviceSingleStruct.url);
      ((Intent)localObject1).putExtra("device_info", localDeviceInfo);
      ((Intent)localObject1).putExtra("param_meta_data", paramView);
      SmartDevicePluginLoader.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.lightapp.DeviceWebViewActivity", -1, null, SmartDevicePluginProxyActivity.class);
      if (localMessageForDeviceSingleStruct.nDataType != 2) {
        continue;
      }
      i = 4;
      l = Long.parseLong(localMessageForDeviceSingleStruct.senderuin);
      j = localDeviceInfo.productId;
      SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_ReceiveMsg_Click", i, 0, j);
      return;
      i = 0;
      continue;
      paramView = localMessageForDeviceSingleStruct.strCoverPath;
      continue;
      if (localMessageForDeviceSingleStruct.nCoverChannelType != 3) {
        continue;
      }
      ((JSONObject)localObject1).put("cover_mini", localMessageForDeviceSingleStruct.strCoverKey);
      ((JSONObject)localObject1).put("ckey2", localMessageForDeviceSingleStruct.strCoverKey2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */