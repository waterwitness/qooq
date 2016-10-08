package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.biz.common.util.ShareToQZoneBack;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import slt;
import slu;
import slv;
import slw;
import slx;
import sly;
import slz;
import sma;
import smb;

public class ForwardSdkShareOption
  extends ForwardSdkBaseOption
  implements ShareToQZoneBack
{
  public static final int A = 60;
  public static final String a = "ForwardOption.ForwardSdkShareOption";
  public static final String ag = "UTF-8";
  public static final int z = 45;
  protected OpenIdObserver a;
  private Handler b;
  protected QQCustomDialog b;
  protected long d;
  private boolean l;
  private boolean m;
  
  public ForwardSdkShareOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_AndroidOsHandler = new slu(this);
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new slw(this);
  }
  
  private int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return 1;
    }
    if (paramArrayList.size() > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.more than 5");
      }
      return 3;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (QfavUtil.a(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        QfavReport.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    Object localObject = "";
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty(str2)) {
      paramBundle = "" + str2;
    }
    localObject = paramBundle;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label164;
      }
      paramBundle = paramBundle + "\n";
    }
    label164:
    for (localObject = paramBundle + str1; !TextUtils.isEmpty(paramString); localObject = str1)
    {
      paramBundle = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = (String)localObject + "\n";
        paramBundle = paramBundle + paramString;
      }
      return paramBundle;
    }
    return (String)localObject;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131367262;
    }
    return super.a();
  }
  
  public String a()
  {
    String str2 = this.jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (SubString.a(str2, "UTF-8") > 105) {
        str1 = SubString.a(str2, 105, "UTF-8", "...");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, "DialogContent:mForwardText=" + str1);
    }
    return str1;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 1022) && (localRecentUser.type != 7000) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.jdField_i_of_type_JavaLangInteger))) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.jdField_b_of_type_Boolean))) {
        localArrayList.add(localRecentUser);
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
      this.jdField_a_of_type_JavaUtilSet.add(jdField_c_of_type_JavaLangInteger);
    }
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_i_of_type_JavaLangInteger);
    }
    if (l()) {
      this.jdField_a_of_type_JavaUtilSet.add(e);
    }
    this.jdField_a_of_type_JavaUtilSet.add(f);
    this.jdField_a_of_type_JavaUtilSet.add(jdField_l_of_type_JavaLangInteger);
    g();
    if (super.m()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_k_of_type_JavaLangInteger);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    a(paramInt, e.intValue());
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean, "shareToQQ", this.jdField_b_of_type_Long);
  }
  
  public boolean a()
  {
    super.a();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", Integer.MAX_VALUE);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
    this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("share_uin");
    this.jdField_g_of_type_Boolean = "login".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jfrom"));
    this.jdField_k_of_type_JavaLangString = "";
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_qzone", false);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("k_send", true))) {}
    for (boolean bool = true;; bool = false)
    {
      this.m = bool;
      if ((this.jdField_b_of_type_Int != 5) || (!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
      }
      a(-1, "请选择图片", "分享的图片不存在");
      long l1;
      String str;
      try
      {
        OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
        return false;
      }
      catch (Exception localException2) {}
    }
    if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
      u();
    }
    localObject2 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((Bundle)localObject2).putString("image_url_remote", (String)localObject1);
    }
    localObject1 = StructMsgFactory.a((Bundle)localObject2);
    if (!AbsShareMsg.class.isInstance(localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
      }
      a(-1, "分享类型错误", "类型错误");
      try
      {
        OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
        return false;
      }
      catch (Exception localException1)
      {
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localException1);
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name") != null))
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_j_of_type_Boolean = true;
      l1 = System.currentTimeMillis() / 1000L;
      str = AgentActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), l1 + "");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, getting appinfo in construct. sign: " + str);
      }
      Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_Long, str, l1, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    ThreadManager.a(new slt(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 5, null, false);
    v();
    this.jdField_a_of_type_AndroidOsBundle.putInt("emoInputType", 1);
    return true;
    return false;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text")))
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForGeneralShare)) {
        break label142;
      }
      localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
      }
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
        a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, paramQQCustomDialog);
      }
      return true;
      label142:
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
        localLayoutParams.setMargins(0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      } else if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
        localLayoutParams.setMargins(AIOUtils.a(-10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      }
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    localObject = new LightAppUtil();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((LightAppUtil)localObject).a(localDeviceInfo);
        if ((a(jdField_k_of_type_JavaLangInteger)) && (super.a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131365997;
    }
    return super.b();
  }
  
  public void b(int paramInt)
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("audio_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, LiteActivity.class);
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qqfav_extra_multi_pic");
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qdshare_file");
    if (paramInt == jdField_l_of_type_JavaLangInteger.intValue())
    {
      localIntent.putExtra("targetUin", AppConstants.ak);
      localIntent.putExtra("device_type", 1);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1113;
      }
      switch (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", "无效的图片链接");
      }
    }
    Bundle localBundle;
    for (;;)
    {
      localBundle = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      localBundle.putBoolean("isBack2Root", false);
      localBundle.putBoolean("is_share_flag", true);
      localBundle.putLong("res_share_id", AppShareIDUtil.a(this.jdField_b_of_type_Long));
      localBundle.putString("res_pkg_name", str2);
      localBundle.putString("res_detail_url", str1);
      localBundle.putString("app_name", str3);
      localBundle.putString("image_url_remote", (String)localObject2);
      localBundle.putString("image_url", str5);
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("audio_url", str4);
      }
      if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
        str1 = Share.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 16);
        if (((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl != null) {
          break label1200;
        }
        localObject1 = "";
        label398:
        localBundle.putString("struct_share_key_source_url", (String)localObject1);
        if (str1 != null) {
          break label1212;
        }
        localObject1 = "";
        label414:
        localBundle.putString("struct_share_key_source_icon", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).messagetail != null) {
          break label1217;
        }
        localObject1 = "";
        label434:
        localBundle.putString("struct_share_key_source_name", (String)localObject1);
        if (((GetAppInfoProto.AndroidInfo)localObject2).packName != null) {
          break label1229;
        }
        localObject1 = "";
        label454:
        localBundle.putString("struct_share_key_source_a_action_data", (String)localObject1);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.jdField_b_of_type_Long), "shareToQQ" })));
      ((Intent)localObject1).setPackage(str2);
      localIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject1, 268435456));
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) && (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      localIntent.setFlags(67108864);
      localIntent.addFlags(268435456);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) {
        break label1241;
      }
      localBundle.putBoolean("MigSdkShareNotDone", false);
      localBundle.putBoolean("isMigSdkShare", true);
      localObject1 = (LiteActivity)this.jdField_a_of_type_AndroidAppActivity;
      localIntent.putExtras(localBundle);
      ((LiteActivity)localObject1).e(localIntent);
      return;
      localIntent.putExtra("targetUin", AppConstants.aj);
      localIntent.putExtra("device_type", 0);
      break;
      if (bool2)
      {
        localIntent.putExtra("dataline_forward_type", 100);
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localIntent.putExtra("dataline_forward_path", (String)localObject1);
        } else {
          localIntent.putExtra("dataline_forward_path", str5);
        }
      }
      else
      {
        localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, "");
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send text:0X8004931.");
          continue;
          localIntent.putExtra("dataline_forward_type", 101);
          QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 1 filePath: " + str5);
          localIntent.putExtra("dataline_forward_path", str5);
          continue;
          localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str4);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
            continue;
            if (bool1)
            {
              localIntent.putExtra("dataline_forward_type", 101);
              if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
              {
                localIntent.putExtra("dataline_forward_path", (String)localObject1);
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 2 filePath: " + (String)localObject1);
              }
              else
              {
                localIntent.putExtra("dataline_forward_path", str5);
                QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 3 filePath: " + str5);
              }
            }
            else
            {
              localObject1 = a(this.jdField_a_of_type_AndroidOsBundle, str1);
              localIntent.putExtra("dataline_forward_type", 102);
              localIntent.putExtra("dataline_forward_text", (String)localObject1);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
              if (QLog.isColorLevel())
              {
                QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                continue;
                label1113:
                if (this.jdField_a_of_type_AndroidOsBundle.getInt("req_type") != 5) {
                  break label1152;
                }
                localIntent.putExtra("dataline_forward_type", 101);
                localIntent.putExtra("dataline_forward_path", str5);
              }
            }
          }
        }
      }
    }
    label1152:
    if (TextUtils.isEmpty(str1))
    {
      if (HttpUtil.a((String)localObject2)) {
        break label1268;
      }
      localObject1 = "无效的图片链接";
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject1);
      break;
      localObject1 = str1;
      continue;
      label1200:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).sourceUrl.get();
      break label398;
      label1212:
      localObject1 = str1;
      break label414;
      label1217:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).messagetail.get();
      break label434;
      label1229:
      localObject1 = ((GetAppInfoProto.AndroidInfo)localObject2).packName.get();
      break label454;
      label1241:
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      a(0, "", "");
      return;
      label1268:
      localObject1 = localObject2;
    }
  }
  
  protected boolean b()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_j_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            jdField_a_of_type_JavaLangObject.wait(20000L);
            if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, response is null and show result dialog.");
            }
            return true;
          }
          catch (InterruptedException localInterruptedException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException1);
            continue;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)
      {
        this.jdField_j_of_type_Boolean = true;
        long l1 = System.currentTimeMillis() / 1000L;
        String str = AgentActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name"), l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str + ", appinfo is null.");
        }
        Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_Long, str, l1, this.jdField_a_of_type_MqqObserverBusinessObserver);
        try
        {
          jdField_a_of_type_JavaLangObject.wait(20000L);
        }
        catch (InterruptedException localInterruptedException2) {}
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException2);
        }
      }
    }
    int i = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.ret.get();
    if ((i == 110507) || (i == 110401))
    {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sly(this, i));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, response ret: " + i + " and show result dialog.");
      }
      return false;
    }
    return true;
  }
  
  protected int c()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("key_forward_ability_type");
    if ((i == jdField_g_of_type_JavaLangInteger.intValue()) || (i == f.intValue()) || (i == jdField_l_of_type_JavaLangInteger.intValue())) {
      return 0;
    }
    if (i == e.intValue()) {
      return 1;
    }
    return 2;
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131365996);
    }
    if (this.jdField_b_of_type_Long == 55901189L) {
      return null;
    }
    return super.c();
  }
  
  public void c()
  {
    String str = String.valueOf(this.jdField_b_of_type_Long);
    int i = 0;
    label156:
    Object localObject;
    if (!this.jdField_g_of_type_Boolean) {
      if ((!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (!this.jdField_j_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        y();
        if ((i != 0) && (this.m))
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
          this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
          this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", e.intValue());
          h();
        }
        i = e();
        if (this.jdField_b_of_type_Int != 5) {
          break label396;
        }
        Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "connect_sharepic", "pageview", this.jdField_b_of_type_Long, i, "");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_pageview", 1, "", "", str);
        if (this.jdField_b_of_type_Int != 1) {
          break label418;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_i_of_type_JavaLangString, str, "10", "11", "0", (String)localObject, "0", "0", false);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (localObject == null)
        {
          a(2131364603);
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new slv(this), 3000L);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(str);
          break;
        }
        if (!this.jdField_i_of_type_JavaLangString.equals(((OpenID)localObject).openID))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
          }
          y();
          break;
        }
        i = 1;
        break;
      }
      i = 1;
      break;
      i = 1;
      break;
      label396:
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, "pageview", this.jdField_b_of_type_Long, i, "");
      break label156;
      label418:
      if (this.jdField_b_of_type_Int == 2) {
        localObject = "3";
      } else if (this.jdField_b_of_type_Int == 5) {
        localObject = "2";
      } else {
        localObject = "4";
      }
    }
  }
  
  protected boolean c()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    w();
    int i;
    switch (j)
    {
    default: 
      i = 1;
    }
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      String str1;
      label117:
      String str2;
      if (this.jdField_b_of_type_Int == 1)
      {
        str1 = "1";
        str2 = "1";
        if (j != 0) {
          break label237;
        }
        str2 = "1";
      }
      for (;;)
      {
        ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", this.jdField_b_of_type_Long + "", "10", "12", "0", str1, str3, str2, false);
        return true;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        if (this.jdField_b_of_type_Int == 2)
        {
          str1 = "3";
          break label117;
        }
        if (this.jdField_b_of_type_Int == 5)
        {
          str1 = "2";
          break label117;
        }
        str1 = "4";
        break label117;
        label237:
        if (1 == j) {
          str2 = "2";
        } else if (3000 == j) {
          str2 = "3";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected int d()
  {
    k = -1;
    for (;;)
    {
      int j;
      int i;
      int n;
      try
      {
        l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
      }
      catch (Exception localException1)
      {
        String str1;
        Object localObject2;
        Object localObject1;
        long l1 = 0L;
        localException1.printStackTrace();
        String str2 = "";
        continue;
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title");
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--image share");
          }
          localObject2 = QfavUtil.a((StructMsgForImageShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg);
          n = k;
          ArrayList localArrayList;
          if (localObject2 != null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(((StructMsgItemImage)localObject2).o);
            n = a(localArrayList);
            if (n == 0) {}
          }
          else
          {
            j = 1;
            i = 3;
            k = n;
            continue;
          }
          n = k;
          if (!QfavBuilder.a(localArrayList, true, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
            continue;
          }
          n = 0;
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_pic_share", false))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--extra pic share");
          }
          i = 8;
          localObject2 = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("qqfav_extra_multi_pic_path_list");
          boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_only_pic", true);
          if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
            break label783;
          }
          i = a((ArrayList)localObject2);
          if (i != 0)
          {
            k = i;
            if ((bool) && (1 == ((ArrayList)localObject2).size()))
            {
              i = 3;
              j = ((ArrayList)localObject2).size();
            }
          }
          else
          {
            if (!QfavBuilder.a((ArrayList)localObject2, bool, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidContentIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
              continue;
            }
            k = 0;
            continue;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--default share");
          }
          localObject1 = QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getXmlBytes());
          n = 0;
          if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
            break label770;
          }
          n = 2;
          i = 10;
          j = i;
          if (QfavBuilder.a(n, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentTitle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSummary, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentCover, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mContentSrc, (byte[])localObject1, true, this.jdField_b_of_type_Long).a(l1, str2).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null))
          {
            k = 0;
            j = 0;
            continue;
          }
        }
      }
      try
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131366007);
        }
        j = -1;
        if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_sdk_share_pure_text")) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->realShareToQfav--pure text share");
        }
        j = 1;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg")))) {
          break label756;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"))) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg");
        if (!QfavBuilder.a(null, false, this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_richmedia_title"), this.jdField_a_of_type_AndroidOsBundle.getString("qqfav_extra_mixed_msg"), true, this.jdField_b_of_type_Long, (String)localObject1).a(l1, str1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), -1, null)) {
          break label789;
        }
        i = 0;
      }
      catch (Exception localException2)
      {
        continue;
        n = 0;
        i = j;
        j = n;
        continue;
        i = 2;
        continue;
        i = 8;
        continue;
        j = 0;
        continue;
        i = -1;
      }
    }
    j = 0;
    n = 1;
    k = i;
    i = n;
    if (k == 0) {
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_AddFav", i, 0, 69, j, "", "");
    }
    return k;
  }
  
  protected void d(int paramInt)
  {
    boolean bool = false;
    if ((!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      super.d(paramInt);
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->showQfavResultDialog--ret = " + paramInt);
      }
      Object localObject;
      String str;
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("mobileQQ", 0);
        str = "favorites_first_share_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        bool = ((SharedPreferences)localObject).getBoolean(str, true);
        if (!bool) {
          QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131366000, 2);
        }
      }
      while (!bool)
      {
        a(this.jdField_a_of_type_AndroidAppActivity, true, "addToQQFavorites", this.jdField_b_of_type_Long);
        return;
        ((SharedPreferences)localObject).edit().putBoolean(str, false).commit();
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131366003);
        str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131366004);
        }
        localObject = (String)localObject;
        localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131365924), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131366001), (String)localObject, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131365927), new slz(this), new sma(this));
        ((QQCustomDialog)localObject).setOnDismissListener(new smb(this));
        if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
          ((QQCustomDialog)localObject).show();
          continue;
          if (2 == paramInt) {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131365964, 1);
          } else if (3 == paramInt) {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131366002, 1);
          } else {
            QfavUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131365999, 1);
          }
        }
      }
    }
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected void k()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    p();
  }
  
  protected void l()
  {
    super.l();
    if ((this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      a(this.jdField_a_of_type_AndroidAppActivity, false, "addToQQFavorites", this.jdField_b_of_type_Long);
    }
    do
    {
      return;
      super.l();
    } while ((!(this.jdField_a_of_type_AndroidAppActivity instanceof LiteActivity)) || (this.jdField_b_of_type_Long == 0L));
    a(this.jdField_a_of_type_AndroidAppActivity, false, "sendToMyComputer", this.jdField_b_of_type_Long);
  }
  
  protected boolean l()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public void q()
  {
    super.q();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  protected void t()
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if (localAbsStructMsg != null) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), localAbsStructMsg);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void y()
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131364481);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131364602);
    slx localslx = new slx(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131367262, localslx);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131364482, localslx);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardSdkShareOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */