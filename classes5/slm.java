import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class slm
  implements Runnable
{
  public slm(ForwardSdkBaseOption paramForwardSdkBaseOption)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.a.jdField_k_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null))) {
        if (this.a.b()) {
          break label55;
        }
      }
      label55:
      Object localObject1;
      Object localObject2;
      String str2;
      Object localObject3;
      HashMap localHashMap;
      String str3;
      String str4;
      long l1;
      long l2;
      try
      {
        Thread.sleep(1000L);
        i += 1;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    if ((!this.a.jdField_k_of_type_Boolean) || (TextUtils.isEmpty(this.a.af)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 2, "-->asyncUploadImageAndSendToBuddy--skey not ready");
      }
      this.a.v();
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sln(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
      localObject2 = Share.a(this.a.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
      if (((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", ((GetAppInfoProto.AndroidInfo)localObject1).sourceUrl.get());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)localObject2);
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).messagetail != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", ((GetAppInfoProto.AndroidInfo)localObject1).messagetail.get());
      }
      if (((GetAppInfoProto.AndroidInfo)localObject1).packName != null) {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", ((GetAppInfoProto.AndroidInfo)localObject1).packName.get());
      }
    }
    str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_url");
    localObject3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
    localHashMap = new HashMap();
    str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    if (CGILoader.a(str3))
    {
      str4 = CGILoader.a(this.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), str2, str3);
      if (!TextUtils.isEmpty(str4))
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("video_url", str4);
        this.a.jdField_a_of_type_AndroidOsBundle.putBoolean("video_url_load", true);
      }
    }
    if ((!TextUtils.isEmpty(str3)) && (str3.length() > 150)) {
      localHashMap.put("targetUrl", str3);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localHashMap.put("sourceUrl", localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localHashMap.put("sourceIcon", localObject3);
    }
    if (this.a.jdField_k_of_type_JavaLangString != null) {
      this.a.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.a.jdField_k_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "-->asyncUploadImageAndSendToBuddy--mForwardSubType = " + this.a.b);
    }
    if (this.a.b == 5)
    {
      localObject2 = new ImageInfo();
      ((ImageInfo)localObject2).h = str2;
      ((ImageInfo)localObject2).c = this.a.jdField_a_of_type_AndroidOsBundle.getString("uin");
      localObject2 = StructMsgForImageShare.scaleLocalImage(this.a.jdField_a_of_type_AndroidAppActivity, (ImageInfo)localObject2, (String)localObject1, this.a.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
      if (localObject2 == null) {}
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url", (String)localObject1);
        this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url_remote");
        this.a.jdField_a_of_type_AndroidOsBundle.remove("title");
        this.a.jdField_a_of_type_AndroidOsBundle.remove("desc");
        this.a.jdField_a_of_type_AndroidOsBundle.remove("detail_url");
        l1 = SystemClock.elapsedRealtime();
        localObject1 = HttpUtil.a(BaseApplication.getContext(), str2, this.a.af, 1, localHashMap);
        l2 = SystemClock.elapsedRealtime();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", str2);
        ((Bundle)localObject2).putString("openid", "");
        ((Bundle)localObject2).putString("report_type", "10");
        ((Bundle)localObject2).putString("act_type", "25");
        ((Bundle)localObject2).putString("via", "2");
        ((Bundle)localObject2).putString("type", "1");
        ((Bundle)localObject2).putString("to_uin", "0");
        ((Bundle)localObject2).putString("to_type", "0");
        ((Bundle)localObject2).putString("intext_1", l2 - l1 + "");
        ((Bundle)localObject2).putString("result", "0");
        ReportCenter.a().a((Bundle)localObject2, "", str2, false);
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new slo(this, (HashMap)localObject1));
        return;
        localObject1 = localObject2;
      }
    }
    if (this.a.b == 2)
    {
      localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
      if (HttpUtil.a((String)localObject2)) {
        localHashMap.put("audioUrl", localObject2);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new HashMap();
      ((Map)localObject2).put("Connection", "keep-alive");
      ((Map)localObject2).put("Referer", "http://www.qq.com");
      localObject3 = new HashMap();
      ((Map)localObject3).put("share_image", localObject1);
      localObject1 = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", str2, this.a.af, null, (Map)localObject3, (Map)localObject2);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if ((((JSONObject)localObject1).getInt("retcode") == 0) && (((JSONObject)localObject1).has("result")))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("result").getString("url");
          this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject1);
          this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
        }
        l1 = SystemClock.elapsedRealtime();
        localObject1 = HttpUtil.a(BaseApplication.getContext(), str2, this.a.af, 1, localHashMap);
        l2 = SystemClock.elapsedRealtime();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", str2);
        ((Bundle)localObject2).putString("openid", "");
        ((Bundle)localObject2).putString("report_type", "10");
        ((Bundle)localObject2).putString("act_type", "25");
        ((Bundle)localObject2).putString("via", "2");
        ((Bundle)localObject2).putString("type", "1");
        ((Bundle)localObject2).putString("to_uin", "0");
        ((Bundle)localObject2).putString("to_type", "0");
        ((Bundle)localObject2).putString("intext_1", l2 - l1 + "");
        ((Bundle)localObject2).putString("result", "0");
        ReportCenter.a().a((Bundle)localObject2, "", str2, false);
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new slp(this, (HashMap)localObject1));
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("sdk_share", 4, localJSONException.getMessage());
        continue;
      }
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
      if (HttpUtil.a(str1)) {
        localHashMap.put("imageUrl", str1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */