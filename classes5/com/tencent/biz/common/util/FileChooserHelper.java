package com.tencent.biz.common.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.widget.ActionSheet;
import hhj;
import hhk;
import hhl;
import hhm;
import hhn;
import java.io.File;
import java.util.List;

public class FileChooserHelper
{
  private static final String jdField_a_of_type_JavaLangString = "FileChooserHelper";
  private static final String b = "camera";
  private static final String c = "camcorder";
  private static final String d = "microphone";
  private static final String e = "image/";
  private static final String f = "video/";
  private static final String g = "audio/";
  private static final String h = "*/*";
  private static final String i = "IMG_";
  private static final String j = "VID_";
  private static final String k = ".mp4";
  private static final String l = ".jpg";
  private int jdField_a_of_type_Int;
  private Uri jdField_a_of_type_AndroidNetUri;
  private ValueCallback jdField_a_of_type_ComTencentSmttSdkValueCallback;
  
  public FileChooserHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
    {
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback.onReceiveValue(null);
      this.jdField_a_of_type_Int = Integer.MIN_VALUE;
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
      this.jdField_a_of_type_AndroidNetUri = null;
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = new File(AppConstants.bj + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      a();
      QQToast.a(paramActivity, 1, paramActivity.getString(2131369226), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File((File)localObject, "IMG_" + System.currentTimeMillis() + ".jpg"));
    localObject = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
    a(paramActivity, (Intent)localObject, 2131368991);
  }
  
  private void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      List localList = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localList == null) || (localList.isEmpty())) {}
    }
    else
    {
      try
      {
        paramActivity.startActivityForResult(paramIntent, this.jdField_a_of_type_Int);
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FileChooserHelper", 2, "Caution: activity for intent was queried but can't started because " + paramIntent.getMessage());
        }
      }
    }
    a();
    QQToast.a(paramActivity, 1, paramInt, 0).a();
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*/*";
    }
    localIntent.setType(str);
    a(paramActivity, localIntent, 2131369227);
  }
  
  private void b(Activity paramActivity)
  {
    Object localObject = new File(AppConstants.bj + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      a();
      QQToast.a(paramActivity, 1, paramActivity.getString(2131369226), 0).a();
      return;
    }
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File((File)localObject, "VID_" + System.currentTimeMillis() + ".mp4"));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    a(paramActivity, (Intent)localObject, 2131368991);
  }
  
  private void c(Activity paramActivity)
  {
    a(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131369229);
  }
  
  public void a(Activity paramActivity, int paramInt, ValueCallback paramValueCallback, String paramString1, String paramString2)
  {
    if ((paramActivity == null) || (paramValueCallback == null)) {
      return;
    }
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)) {
      QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentSmttSdkValueCallback = paramValueCallback;
    this.jdField_a_of_type_AndroidNetUri = null;
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if (paramString2 == null) {
        break label90;
      }
    }
    label90:
    for (paramValueCallback = paramString2.toLowerCase();; paramValueCallback = "")
    {
      if (!TextUtils.isEmpty(paramValueCallback)) {
        break label96;
      }
      a(paramActivity, paramString1);
      return;
      paramString1 = "";
      break;
    }
    label96:
    if (("camera".equals(paramValueCallback)) || ("camcorder".equals(paramValueCallback)) || ("microphone".equals(paramValueCallback)))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label400;
      }
      if (!paramString1.contains("image/")) {
        break label244;
      }
      paramValueCallback = "camera";
      paramInt = 1;
    }
    label144:
    label244:
    label400:
    for (;;)
    {
      if (paramInt != 0)
      {
        paramString2 = ActionSheet.a(paramActivity);
        paramString2.a(new hhj(this));
        paramString2.setOnCancelListener(new hhk(this));
        if (paramValueCallback.equals("camera"))
        {
          paramString2.a(paramActivity.getString(2131369188), 0);
          paramString2.a(paramActivity.getString(2131369848), 0);
          paramString2.a(new hhl(this, paramActivity, paramString1, paramString2));
        }
        for (;;)
        {
          paramString2.show();
          return;
          paramInt = 0;
          break;
          if (paramString1.contains("video/"))
          {
            paramValueCallback = "camcorder";
            paramInt = 1;
            break label144;
          }
          if (!paramString1.contains("audio/")) {
            break label400;
          }
          paramValueCallback = "microphone";
          paramInt = 1;
          break label144;
          if (paramValueCallback.equals("camcorder"))
          {
            paramString2.a(paramActivity.getString(2131370358), 0);
            paramString2.a(paramActivity.getString(2131369848), 0);
            paramString2.a(new hhm(this, paramActivity, paramString1, paramString2));
          }
          else if (paramValueCallback.equals("microphone"))
          {
            paramString2.a(paramActivity.getString(2131369228), 0);
            paramString2.a(paramActivity.getString(2131369848), 0);
            paramString2.a(new hhn(this, paramActivity, paramString1, paramString2));
          }
        }
      }
      a(paramActivity, paramString1);
      return;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri1;
    if (this.jdField_a_of_type_Int == paramInt1) {
      if (this.jdField_a_of_type_ComTencentSmttSdkValueCallback != null)
      {
        if (-1 != paramInt2) {
          break label100;
        }
        Uri localUri2 = this.jdField_a_of_type_AndroidNetUri;
        localUri1 = localUri2;
        if (localUri2 == null)
        {
          if (paramIntent == null) {
            break label74;
          }
          localUri1 = paramIntent.getData();
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSmttSdkValueCallback.onReceiveValue(localUri1);
      for (;;)
      {
        this.jdField_a_of_type_Int = Integer.MIN_VALUE;
        this.jdField_a_of_type_ComTencentSmttSdkValueCallback = null;
        this.jdField_a_of_type_AndroidNetUri = null;
        return true;
        label74:
        localUri1 = null;
        break;
        if (QLog.isColorLevel()) {
          QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback should not be null!");
        }
      }
      return false;
      label100:
      localUri1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\FileChooserHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */