package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class PhotoMagicStickUtils
{
  private static int a = 19922944;
  private static int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, Activity paramActivity, boolean paramBoolean, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramActivity, paramBoolean, paramInt, paramString2, paramString3, paramString4, false);
  }
  
  public static void a(String paramString1, Activity paramActivity, boolean paramBoolean1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("photoplus", 2, "showActionSheet from camera " + paramBoolean2);
    }
    Intent localIntent = new Intent(paramActivity.getIntent());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("p_e_f_camera", paramBoolean2);
    localIntent.putExtra("p_e_s_type", paramInt);
    PhotoUtils.a(paramActivity, localIntent, 6, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void a(String paramString1, String paramString2, Activity paramActivity, boolean paramBoolean, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, byte[] paramArrayOfByte)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      Intent localIntent = paramActivity.getIntent();
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      int i = localIntent.getIntExtra("PasterConstants.intent_params_refer", -1);
      if (i > 0) {
        paramInt2 = i;
      }
      localIntent.putExtra("PasterConstants.intent_params_refer", paramInt2);
      localIntent.putExtra("PasterConstants.select_image_pasters", paramArrayOfByte);
      localIntent.putExtra("PasterConstants.paster_id", paramString6);
      localIntent.putExtra("PasterConstants.paster_cate_id", paramString7);
      localIntent.putExtra("PasterConstants.paster_original_path", paramString2);
      localIntent.putExtra("p_e_s_type", paramInt1);
      PhotoUtils.a(paramActivity, localIntent, 7, paramString1, paramString3, paramString4, paramString5);
    } while ((TextUtils.isEmpty(paramString7)) && (TextUtils.isEmpty(paramString6)));
    paramActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoMagicStickUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */