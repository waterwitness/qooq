package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;

class ThemeJsPlugin$5
  implements DialogInterface.OnClickListener
{
  ThemeJsPlugin$5(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "not wifi network confirm continue to download");
      }
      String str = ThemeUtil.getThemeDownloadFilePath(ThemeJsPlugin.access$000(this.this$0), this.val$id, this.val$version);
      ThemeJsPlugin.access$402(this.this$0, true);
      Object localObject = (ThemeUtil.ThemeInfo)ThemeJsPlugin.access$200(this.this$0).get(this.val$id);
      paramDialogInterface = (DialogInterface)localObject;
      if (localObject == null)
      {
        localObject = ThemeUtil.getThemeInfo(ThemeJsPlugin.access$000(this.this$0), this.val$id);
        paramDialogInterface = (DialogInterface)localObject;
        if (localObject != null)
        {
          ((ThemeUtil.ThemeInfo)localObject).downloadUrl = this.val$url;
          paramDialogInterface = (DialogInterface)localObject;
        }
      }
      if (paramDialogInterface != null)
      {
        localObject = paramDialogInterface;
        if (paramDialogInterface.version.equals(this.val$version)) {}
      }
      else
      {
        localObject = new ThemeUtil.ThemeInfo();
        ((ThemeUtil.ThemeInfo)localObject).themeId = this.val$id;
        ((ThemeUtil.ThemeInfo)localObject).downloadUrl = this.val$url;
        ((ThemeUtil.ThemeInfo)localObject).size = this.val$size;
        ((ThemeUtil.ThemeInfo)localObject).downsize = 0L;
        ((ThemeUtil.ThemeInfo)localObject).version = this.val$version;
        ((ThemeUtil.ThemeInfo)localObject).status = "1";
        if (this.val$voiceFlag != 1) {
          break label362;
        }
      }
      label362:
      for (boolean bool = true;; bool = false)
      {
        ((ThemeUtil.ThemeInfo)localObject).isVoiceTheme = bool;
        ThemeJsPlugin.access$200(this.this$0).put(this.val$id, localObject);
        ThemeJsPlugin.access$502(this.this$0, this.val$id);
        ThemeJsPlugin.loadingThemeIdForJsCall = this.val$id;
        ThemeJsPlugin.access$602(this.this$0, this.val$callbackId);
        paramDialogInterface = new Bundle();
        paramDialogInterface.putString("url", this.val$url);
        paramDialogInterface.putString("themeZipPath", str);
        paramDialogInterface.putString("id", this.val$id);
        paramDialogInterface.putString("version", this.val$version);
        paramDialogInterface.putLong("size", this.val$size);
        paramDialogInterface.putSerializable("themeInfo", (Serializable)localObject);
        paramDialogInterface = DataFactory.a("startDownloadTheme", this.val$callbackId, this.this$0.mOnRemoteResp.key, paramDialogInterface);
        this.this$0.sendRemoteReq(paramDialogInterface, false, true);
        this.this$0.reportTheme(null, 0, this.val$id, 0L, null, null, "200", 153, ThemeReporter.t, 11, this.val$version, "");
        return;
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ThemeJsPlugin", 1, "startDownload dialog Exception：" + paramDialogInterface.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\ThemeJsPlugin$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */