package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardPhotoOption
  extends ForwardFileBaseOption
{
  public static final String g = "ForwardOption.ForwardPhotoOption";
  SendMultiPictureHelper a;
  
  public ForwardPhotoOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private String b(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramUri = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(i);
        paramUri.close();
        return str;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  protected Bitmap a(String paramString)
  {
    Bitmap localBitmap2 = BitmapManager.a(paramString, 100, 100);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {
      localBitmap1 = ImageUtil.a(localBitmap2, new File(paramString));
    }
    return localBitmap1;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1003) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 1008) && (localRecentUser.type != 1021) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.i))) && (localRecentUser.type != 7000) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_d_of_type_JavaLangInteger);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    this.jdField_a_of_type_JavaUtilSet.add(j);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b() == 10006)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_dataline", true))
      {
        this.jdField_a_of_type_JavaUtilSet.add(jdField_f_of_type_JavaLangInteger);
        this.jdField_a_of_type_JavaUtilSet.add(l);
      }
      if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_smartdevice", true)) && (m())) {
        this.jdField_a_of_type_JavaUtilSet.add(k);
      }
      return;
      if (h()) {
        this.jdField_a_of_type_JavaUtilSet.add(i);
      }
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localObject != null) {}
    try
    {
      localArrayList1 = (ArrayList)localObject;
      localArrayList3 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList();
        int i = 0;
        while (i < localArrayList3.size())
        {
          localObject = (Uri)localArrayList3.get(i);
          localArrayList1.add(a(this.jdField_a_of_type_AndroidAppActivity, (Uri)localObject));
          i += 1;
        }
        paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList1);
      }
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("sendMultiple", true);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
  
  public boolean a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    return true;
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
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(1)) && (a(k))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  protected void b()
  {
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(null);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    super.b(paramInt);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 101);
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    QLog.d("ForwardOption.ForwardPhotoOption", 1, "sendDatalineSingle filePath: " + (String)localObject2);
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
  }
  
  protected void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  protected boolean c()
  {
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isBack2Root", false);
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uinname");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    Object localObject2 = Boolean.valueOf(this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false));
    boolean bool2 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false);
    boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isJumpAIO", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isSendMultiple=" + localObject2 + "isFromShare=" + bool2);
    }
    if (((Boolean)localObject2).booleanValue())
    {
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isFromShare", false)) {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper = new SendMultiPictureHelper((BaseActivity)this.jdField_a_of_type_AndroidAppActivity);
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      if ((localObject2 != null) && ((localObject2 instanceof ArrayList)))
      {
        localObject2 = (ArrayList)localObject2;
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          localArrayList.add(a((Uri)((ArrayList)localObject2).get(i)));
          i += 1;
        }
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.a(str2, str1, j, (String)localObject1, this.jdField_a_of_type_AndroidOsBundle, localArrayList);
        }
      }
      return true;
    }
    if (j == 1008)
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      ((Intent)localObject1).putExtra("chat_subType", PublicAccountManager.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (bool2)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool2 = a((Intent)localObject1);
        boolean bool3 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromFavorites");
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "ForwardPhotoOption realForwardTo isFromFav=" + bool3 + "isFromAIOFav=" + bool2);
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label545;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      ((Intent)localObject1).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, (Intent)localObject1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localObject1 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label545:
      if (!bool1) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, null);
      }
    }
  }
  
  protected int d()
  {
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("sendMultiple", false))
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_AndroidOsBundle.get("android.intent.extra.STREAM");
      QLog.i("Qfav", 1, "shareToQfav sendMultiple . size = " + ((ArrayList)localObject1).size());
      i = 0;
      if (i >= ((ArrayList)localObject1).size()) {
        break label366;
      }
      if (!QfavBuilder.b(b((Uri)((ArrayList)localObject1).get(i))).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
        i = -1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      i += 1;
      break;
      QLog.i("Qfav", 1, "shareToQfav single pic");
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_d_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if (new File((String)localObject1).exists())
        {
          if (QfavBuilder.b((String)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            i = 0;
          }
        }
        else if (QfavBuilder.a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_photo_md5"), -1, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_download_image_server_path"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_photo_group_fileid", 0L), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra"), this.jdField_a_of_type_AndroidContentIntent.getLongExtra("forward_file_size", 0L)).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
        {
          i = 0;
          continue;
        }
      }
      i = -1;
      continue;
      label366:
      i = 0;
    }
  }
  
  protected String d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131370475);
  }
  
  protected void k()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false))
    {
      if (ForwardSendPicUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"), true, this.jdField_a_of_type_AndroidAppActivity)) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1);
      }
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    p();
  }
  
  protected void m()
  {
    n();
  }
  
  public void q()
  {
    super.q();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySendMultiPictureHelper.d();
    }
  }
  
  protected void t()
  {
    Object localObject2;
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_flag_from_plugin", false)) {
      localObject2 = this.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      Object localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject3 = AppConstants.bj + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
      }
      try
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), (String)localObject2, (String)localObject3, 600, 800);
        localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject3);
        localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        boolean bool;
        if ((((SmartDeviceProxyMgr)localObject3).d(Long.parseLong((String)localObject1))) && (((SmartDeviceProxyMgr)localObject3).a(Long.parseLong((String)localObject1), 17)))
        {
          bool = true;
          label162:
          if (Boolean.valueOf(bool).booleanValue()) {
            break label294;
          }
          ((DeviceMsgHandle)localObject2).a().a(DeviceMsgHandle.jdField_d_of_type_JavaLangString, (String)localObject1, localArrayList);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidAppActivity.finish();
          return;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_extra");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_extra");
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("forward_filepath");
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", (String)localObject2);
          break;
          bool = false;
          break label162;
          label294:
          ((DeviceMsgHandle)localObject2).a().a(DeviceMsgHandle.c, (String)localObject1, localArrayList, 1, 1);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardPhotoOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */