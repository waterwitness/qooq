package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardShortVideoOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardShortVideoOption";
  
  public ForwardShortVideoOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    paramList = paramList.iterator();
    label176:
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (((!Utils.a(localRecentUser.uin)) && (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin)) && ((localRecentUser.type == 0) || (localRecentUser.type == 1) || (localRecentUser.type == 3000))) || (((localRecentUser.type == 1004) || (localRecentUser.type == 1000)) && (this.jdField_b_of_type_Boolean))))
      {
        if ((localHotChatManager != null) && (localHotChatManager.b(localRecentUser.uin))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label176;
          }
          localArrayList.add(localRecentUser);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (m()) {
      this.jdField_a_of_type_JavaUtilSet.add(k);
    }
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_forward_ptv", false))
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
      try
      {
        paramQQCustomDialog.setPreviewImage(ForwardOptionUtils.a(SkinUtils.a(new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), this.jdField_d_of_type_JavaLangString))), true, 1);
        return false;
      }
      catch (OutOfMemoryError paramQQCustomDialog)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", paramQQCustomDialog);
        return false;
      }
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false))
    {
      String str1 = AppConstants.bu + "pic/" + this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_md5") + "_0";
      String str2 = this.jdField_d_of_type_JavaLangString;
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!new File(str2).exists()) && (new File(str1).exists())) {
        FileUtils.d(str1, str2);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    try
    {
      paramQQCustomDialog.setPreviewImage(new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), this.jdField_d_of_type_JavaLangString));
      return true;
    }
    catch (OutOfMemoryError paramQQCustomDialog)
    {
      for (;;)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", paramQQCustomDialog);
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localSmartDeviceProxyMgr.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(2)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected boolean c()
  {
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorite", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_need_sendmsg", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forwardShortvideo realForwardTo isNeedSendMsg=" + bool2 + "isFromFavorite=" + bool1);
    }
    if (bool1)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localObject = ShortVideoBusiManager.a(localIntent, ShortVideoBusiManager.a(0, 2));
      ((ShortVideoUploadInfo)localObject).c = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      ((ShortVideoUploadInfo)localObject).b = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_Int = 2;
      new AioShortVideoOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((ShortVideoUploadInfo)localObject);
      localObject = localIntent;
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavoriteDetail", false))
      {
        localObject = AIOUtils.a(localIntent, null);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      }
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject = AIOUtils.a((Intent)localObject, null);
    ((Intent)localObject).putExtra("isBack2Root", true);
    if (bool2) {
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    }
  }
  
  protected void k()
  {
    super.k();
    int i;
    String str;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("NeedReportForwardShortVideo", false))
    {
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
      if (i != 3) {
        break label90;
      }
      str = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
      return;
      label90:
      if (i == 2) {
        str = "2";
      } else if (i == 0) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  protected void t()
  {
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("uin"));
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"));
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 9501));
    ((Intent)localObject2).putExtra("file_send_size", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_size", 0));
    ((Intent)localObject2).putExtra("file_send_business_type", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_business_type", -1));
    ((Intent)localObject2).putExtra("file_send_duration", this.jdField_a_of_type_AndroidOsBundle.getInt("file_send_duration", -1));
    ((Intent)localObject2).putExtra("file_send_path", this.jdField_a_of_type_AndroidOsBundle.getString("file_send_path"));
    ((Intent)localObject2).putExtra("thumbfile_send_path", this.jdField_a_of_type_AndroidOsBundle.getString("thumbfile_send_path"));
    ((Intent)localObject2).putExtra("file_shortvideo_md5", this.jdField_a_of_type_AndroidOsBundle.getString("file_shortvideo_md5"));
    ((Intent)localObject2).putExtra("thumbfile_send_width", this.jdField_a_of_type_AndroidOsBundle.getInt("thumbfile_send_width", 0));
    ((Intent)localObject2).putExtra("thumbfile_send_height", this.jdField_a_of_type_AndroidOsBundle.getInt("thumbfile_send_height", 0));
    ((Intent)localObject2).putExtra("thumbfile_md5", this.jdField_a_of_type_AndroidOsBundle.getString("thumbfile_md5"));
    ((Intent)localObject2).putExtra("file_source", this.jdField_a_of_type_AndroidOsBundle.getString("file_source"));
    ((Intent)localObject2).putExtra("file_video_source_dir", this.jdField_a_of_type_AndroidOsBundle.getString("file_video_source_dir"));
    Object localObject1 = ShortVideoBusiManager.a(0, 4);
    localObject2 = ShortVideoBusiManager.a(localObject2, (ShortVideoReq)localObject1);
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    DevLittleVideoOperator localDevLittleVideoOperator = new DevLittleVideoOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MessageRecord localMessageRecord = localDevLittleVideoOperator.a((ShortVideoUploadInfo)localObject2);
    localDevLittleVideoOperator.a(localMessageRecord);
    ((ShortVideoUploadInfo)localObject2).jdField_a_of_type_JavaLangObject = localMessageRecord;
    ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject2);
    ShortVideoBusiManager.a((ShortVideoReq)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject1 = AIOUtils.a((Intent)localObject1, null);
    ((Intent)localObject1).putExtra("isBack2Root", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardShortVideoOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */