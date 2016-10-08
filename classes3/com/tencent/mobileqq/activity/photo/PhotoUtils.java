package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.photoedit.PhotoEditPluginProxyActivity;
import cooperation.photoplus.PhotoPlusPluginProxyActivity;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.secmsg.SecMsgHelper;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cooperation.troop.TroopFileProxyActivity;
import cooperation.zebra.ZebraPluginBaseDialog;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class PhotoUtils
{
  public static final int a = 1048576;
  private static final String a = "PhotoUtils";
  public static SimpleDateFormat a = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  private static final String b = "PHOTO_KEY_FRIEND_UIN";
  public static SimpleDateFormat b = new SimpleDateFormat("yyyy年MM月dd HH点");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("照片 ");
    localStringBuilder.append("拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.d * 1000L);
    localStringBuilder.append(a.format(paramLocalMediaInfo));
    if (paramInt1 == 0) {
      localStringBuilder.append(" 图像");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramInt1 == 1) {
        localStringBuilder.append(" 视频");
      } else if (QLog.isColorLevel()) {
        QLog.e("PhotoUtils", 2, "PhotoListActivity createContentDescription mediaType is error");
      }
    }
  }
  
  public static String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("照片 拍摄时间: ");
    paramLocalMediaInfo = new Date(paramLocalMediaInfo.d * 1000L);
    localStringBuilder.append(b.format(paramLocalMediaInfo));
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, float paramFloat)
  {
    paramFloat /= 1000000;
    if (paramFloat >= 10.0F)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 1.0F)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 0.001D)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat * 1000.0F) + "K";
    }
    if (paramFloat >= 1.0E-4D)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat * 1000.0F) + "K";
    }
    return "0.1K";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity != null) && (((BaseActivity)paramActivity).app != null)) {
      a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, ((BaseActivity)paramActivity).app.a());
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    Intent localIntent;
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      localIntent = paramIntent;
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoUtils", 2, "[onSendResult] data = null");
        }
        localIntent = new Intent();
      }
      if (paramInt1 != 7001) {
        break label152;
      }
      paramIntent = paramActivity.getIntent();
      String str1 = paramIntent.getStringExtra("UploadPhoto.key_album_id");
      String str2 = paramIntent.getStringExtra("UploadPhoto.key_album_name");
      QZoneHelper.a(paramString, paramIntent.getStringExtra("uin"), str1, str2);
      paramIntent.putExtras(localIntent);
      paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
      if (!paramBoolean)
      {
        paramIntent.addFlags(603979776);
        paramActivity.startActivity(paramIntent);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AlbumUtil.a(paramActivity, false, false);
      return;
      label152:
      paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
      if (!paramBoolean)
      {
        localIntent.addFlags(603979776);
        StatisticConstants.a(localIntent);
        paramActivity.startActivity(localIntent);
      }
      else
      {
        QLog.e("PhotoUtils", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramActivity, paramIntent, paramInt, paramString1, paramString2, paramString3, paramString4, null, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.putExtra("image_path", paramString1);
    paramIntent.putExtra("market", "photo");
    paramIntent.putExtra("self_nick", paramString3);
    paramIntent.putExtra("qq", Long.parseLong(paramString2));
    paramIntent.putExtra("qq_face_file_path", paramString4);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    paramIntent.putExtra("userQqResources", 2);
    if (!TextUtils.isEmpty(paramString5)) {
      paramIntent.putExtra("btnConfirm", paramString5);
    }
    paramIntent.putExtra("functionControl", paramInt2);
    paramString1 = paramIntent.getStringExtra("uin");
    if (paramString1 != null) {
      paramIntent.putExtra("PHOTO_KEY_FRIEND_UIN", paramString1);
    }
    if (paramInt1 == 7) {
      paramIntent.putExtra("use_paster", true);
    }
    paramString1 = new IPluginManager.PluginParams(0);
    paramString1.jdField_b_of_type_JavaLangString = "Photoplus.apk";
    paramString1.d = "Photoplus";
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    paramString1.e = "com.tencent.zebra.effect.PhotoEffectActivity";
    paramString1.jdField_a_of_type_JavaLangClass = PhotoPlusPluginProxyActivity.class;
    paramString1.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramString1.jdField_b_of_type_Int = paramInt1;
    paramString1.jdField_a_of_type_AndroidAppDialog = new ZebraPluginBaseDialog(paramActivity, 2131559055);
    paramString1.jdField_a_of_type_Boolean = true;
    paramString1.c = 10000;
    if ((paramInt1 != 7) && (paramIntent.getIntExtra("p_e_s_type", 0) != 1) && (paramIntent.getIntExtra("p_e_s_type", 0) != 101)) {
      paramString1.f = "正在启动，请稍候...";
    }
    IPluginManager.a(paramActivity, paramString1);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str1);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "sendPhotoForPhotoPlus , activity = " + paramActivity + ",data = " + paramIntent.getExtras());
    }
    paramIntent.addFlags(603979776);
    if ((Build.VERSION.SDK_INT >= 21) && (str1.contains("ForwardRecentActivity")))
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    String str2;
    if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if (("com.tencent.mobileqq.activity.SplashActivity".equals(paramArrayList)) && ("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) && ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(str2))) {
        paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramArrayList);
      }
      paramActivity.startActivity(paramIntent);
    }
    while (!"qzone_plugin.apk".equals(paramIntent.getStringExtra("PhotoConst.PLUGIN_APK")))
    {
      paramActivity.finish();
      return;
    }
    if ((!str1.contains("QZone")) && (paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME") != null)) {}
    for (paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");; paramArrayList = str1)
    {
      paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      str2 = paramIntent.getStringExtra("PhotoConst.UIN");
      if (!"qzone_plugin.apk".equals(str1)) {
        break;
      }
      QzonePluginProxyActivity.a(paramIntent, paramArrayList);
      paramIntent.putExtra("cleartop", true);
      QZoneHelper.a(paramActivity, str2, paramIntent, -1);
      break;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    String str1 = str3;
    if (str3 == null)
    {
      str3 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str3;
      if (str3 == null) {
        QQToast.a(paramActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      }
    }
    for (;;)
    {
      return;
      paramIntent.setClassName(str2, str1);
      str2 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
      if (str2 != null) {
        paramIntent.putExtra("uin", str2);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      if (paramArrayList.size() == 1) {
        paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
      }
      paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "currActivity is:" + paramActivity.getClass().getName());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "destination activity is:" + str1 + ",intent extra is:" + paramIntent.getExtras());
      }
      paramIntent.addFlags(603979776);
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + bool + "className=" + str1);
      }
      if (!bool) {
        if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
        {
          paramIntent.putExtra("cleartop", true);
          TroopFileProxyActivity.a(paramActivity, paramIntent, 2);
        }
      }
      while (!paramBoolean)
      {
        paramActivity.finish();
        AlbumUtil.a(paramActivity, false, false);
        return;
        paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
        paramActivity.startActivityForResult(paramIntent, 2);
        continue;
        str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
        str3 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        String str4 = paramIntent.getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str3))
        {
          if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
          {
            a(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
          }
          else
          {
            QzonePluginProxyActivity.a(paramIntent, str1);
            paramIntent.putExtra("cleartop", true);
            QZoneHelper.a(paramActivity, str4, paramIntent, -1);
            paramBoolean = false;
          }
        }
        else if ("qqfav.apk".equals(str3))
        {
          QfavHelper.a(paramActivity, str4, paramIntent, 2);
        }
        else if ("secmsg_plugin.apk".equals(str3))
        {
          SecMsgHelper.a(paramActivity, str1, str4, paramIntent);
        }
        else if ("qqsmartdevice.apk".equals(str3))
        {
          paramIntent.putExtra("cleartop", true);
          paramArrayList = new IPluginManager.PluginParams(0);
          paramArrayList.jdField_b_of_type_JavaLangString = str3;
          paramArrayList.d = str2;
          paramArrayList.jdField_a_of_type_JavaLangString = str4;
          paramArrayList.e = str1;
          paramArrayList.jdField_a_of_type_JavaLangClass = SmartDevicePluginProxyActivity.class;
          paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
          paramArrayList.jdField_b_of_type_Int = 2;
          IPluginManager.a(paramActivity, paramArrayList);
        }
        else if ("comic_plugin.apk".equals(str3))
        {
          paramIntent.putExtra("cleartop", true);
          paramArrayList = new IPluginManager.PluginParams(0);
          paramArrayList.jdField_b_of_type_JavaLangString = str3;
          paramArrayList.d = str2;
          paramArrayList.jdField_a_of_type_JavaLangString = str4;
          paramArrayList.e = str1;
          paramArrayList.jdField_a_of_type_JavaLangClass = VipComicProxyActivity.a(str1);
          paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
          paramArrayList.jdField_b_of_type_Int = 2;
          IPluginManager.a(paramActivity, paramArrayList);
        }
        else
        {
          paramIntent.putExtra("cleartop", true);
          paramArrayList = new IPluginManager.PluginParams(0);
          paramArrayList.jdField_b_of_type_JavaLangString = str3;
          paramArrayList.d = str2;
          paramArrayList.jdField_a_of_type_JavaLangString = str4;
          paramArrayList.e = str1;
          paramArrayList.jdField_a_of_type_JavaLangClass = PhotoEditPluginProxyActivity.class;
          paramArrayList.jdField_a_of_type_AndroidContentIntent = paramIntent;
          paramArrayList.jdField_b_of_type_Int = 2;
          IPluginManager.a(paramActivity, paramArrayList);
        }
      }
    }
  }
  
  static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    paramIntent.setClass(paramActivity, PhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    if (100 == paramIntent.getIntExtra("Business_Origin", 0))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    }
    for (;;)
    {
      paramIntent.removeExtra("Business_Origin");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
      paramActivity.startActivity(paramIntent);
      AlbumUtil.a(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    boolean bool = paramIntent1.getBooleanExtra("custom_photopreview_sendbtn_report", false);
    String str1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_reportActionName");
    String str2 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
    paramIntent1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
    paramIntent2.putExtra("custom_photopreview_sendbtn_report", bool);
    paramIntent2.putExtra("custom_photopreview_sendbtn_reportActionName", str1);
    paramIntent2.putExtra("custom_photopreview_sendbtn_album_reportReverse2", str2);
    paramIntent2.putExtra("custom_photopreview_sendbtn_camera_reportReverse2", paramIntent1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      String str;
      Iterator localIterator;
      switch (paramInt)
      {
      case 1: 
      default: 
        str = "Send_compress";
        localIterator = paramArrayList.iterator();
        paramInt = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label135;
        }
        Object localObject = (String)localIterator.next();
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:path == null");
          continue;
          str = "Send_compress";
          break;
          str = "Send_raw";
          break;
        }
        localObject = new File((String)localObject);
        paramInt = (int)(paramInt + ((File)localObject).length());
      }
      label135:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:" + str + ",count:" + paramArrayList.size() + ",totalSize:" + paramInt);
      }
      a(paramQQAppInterface, str, paramArrayList.size(), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    ImageUtil.a(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
    }
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        if (i <= j * 3)
        {
          bool1 = bool2;
          if (j <= i * 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */