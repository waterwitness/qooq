package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

class AvatarPendantJsPlugin$5
  implements ActionSheet.OnButtonClickListener
{
  AvatarPendantJsPlugin$5(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      if (!QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        paramView = new File(AppConstants.bj + "photo/");
        if (!paramView.exists()) {
          paramView.mkdirs();
        }
        paramView = Uri.fromFile(new File(AppConstants.bj + "photo/" + System.currentTimeMillis() + ".jpg"));
        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        localIntent.putExtra("output", paramView);
        localIntent.putExtra("android.intent.extra.videoQuality", 100);
        this.this$0.mRuntime.a().startActivityForResult(localIntent, 1);
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
        AvatarPendantUiPlugin.sUploadPhotoUri = paramView;
        continue;
        paramView = new Intent();
        paramView.putExtra("Business_Origin", 100);
        paramInt = Math.min(482, ProfileCardUtil.a(this.this$0.mRuntime.a()));
        PhotoUtils.a(paramView, this.this$0.mRuntime.a(), AvatarPendantMarketActivity.class.getName(), paramInt, paramInt, 640, 640, ProfileCardUtil.a());
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\AvatarPendantJsPlugin$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */