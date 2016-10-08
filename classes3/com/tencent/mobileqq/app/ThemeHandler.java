package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.mobileqq.theme.ThemeReporter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.pb.theme.ThemeAuth.ReqBody;
import com.tencent.pb.theme.ThemeAuth.RspBody;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2ReqCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x2RspCheck;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth.SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth.ThemeFileInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import qgp;
import qgq;
import qgr;

public class ThemeHandler
  extends BusinessHandler
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a = "Theme.ThemeHandler";
  static final int jdField_b_of_type_Int = 2;
  public static final String b = "need_check_theme_ver";
  static final int jdField_c_of_type_Int = 3;
  private static String jdField_c_of_type_JavaLangString;
  ThemeDownloader.ThemeDownloadListener jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener;
  public ThemeDownloader.ThemeUnzipListener a;
  ThemeDownloader jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader;
  public Object a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public JSONArray a;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public int d;
  int e;
  
  ThemeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = new qgq(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener = new qgr(this);
  }
  
  private HashMap a(String paramString)
  {
    paramString = FileUtils.a(paramString);
    HashMap localHashMap = new HashMap();
    int i = 0;
    while ((i < 3) && (i < paramString.size()))
    {
      String str1 = (String)paramString.get(new Random().nextInt(paramString.size() - 1));
      String str2 = str1.substring(str1.substring(0, str1.lastIndexOf(47)).lastIndexOf('/') + 1);
      if ((str2 != null) && (str2.length() > 0) && (!localHashMap.containsKey(str2)))
      {
        String str3 = FileUtils.a(str1, "MD5");
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str1 + ",key=" + str2 + ",md5=" + str3);
        }
        if ((str3 != null) && (str3.length() > 0)) {
          localHashMap.put(str2, str3);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "server theme preDownload loadIndex:" + this.e);
        }
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.e < this.jdField_a_of_type_JavaUtilArrayList.size())) {
          break;
        }
        return;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Theme.ThemeHandler", 2, "7day theme preDownload loadIndex:" + this.e);
      }
    }
    paramBundle = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.get(this.e);
    this.e += 1;
    if (paramBundle == null)
    {
      a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader = new ThemeDownloader(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "203");
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramBundle, this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"AuthSvr.ThemeAuth".equals(paramFromServiceMsg.getServiceCmd())) {}
    Object localObject1;
    int i;
    int k;
    int j;
    boolean bool;
    label847:
    label853:
    label922:
    label940:
    label1071:
    label1088:
    label1205:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "ThemeHandler onReceive~ handleThemeAuth res.isSuccess=" + paramFromServiceMsg.isSuccess() + ",data=" + PkgTools.b((byte[])paramObject));
            }
            for (;;)
            {
              try
              {
                localObject1 = new ThemeAuth.RspBody();
                if (paramObject != null) {
                  ((ThemeAuth.RspBody)localObject1).mergeFrom((byte[])paramObject);
                }
                if (((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.has())
                {
                  i = ((ThemeAuth.RspBody)localObject1).uint32_sub_cmd.get();
                  if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
                    break label847;
                  }
                  k = 1;
                  j = i;
                  if (k == 0)
                  {
                    j = i;
                    if (-1 == i)
                    {
                      paramFromServiceMsg = new ThemeAuth.ReqBody();
                      paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
                      j = paramFromServiceMsg.uint32_sub_cmd.get();
                    }
                    if (1 == j) {
                      ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putLong("authTime", 0L).commit();
                    }
                    QLog.e("Theme.ThemeHandler", 1, "ThemeHandler onReceive Error: isSuccess=false, data=" + PkgTools.b((byte[])paramObject) + ", subCmd=" + j);
                    if (3 != j) {
                      break;
                    }
                  }
                  if (1 != j) {
                    break label1205;
                  }
                  paramObject = (ThemeAuth.SubCmd0x1RspAuth)((ThemeAuth.RspBody)localObject1).msg_subcmd0x1_rsp_auth.get();
                  i = ((ThemeAuth.SubCmd0x1RspAuth)paramObject).int32_result.get();
                  if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + i);
                  }
                  paramFromServiceMsg = new ThemeAuth.ReqBody();
                  paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
                  paramFromServiceMsg = (ThemeAuth.SubCmd0x1ReqAuth)paramFromServiceMsg.msg_subcmd0x1_req_auth.get();
                  paramToServiceMsg = String.valueOf(paramFromServiceMsg.uint32_theme_id.get());
                  localObject1 = paramFromServiceMsg.str_theme_version.get();
                  if (i == 0) {
                    break label853;
                  }
                  QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, error, ret:" + i + ", themeid:" + paramToServiceMsg + ", themeVersion:" + (String)localObject1);
                  ThemeReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 0 - i, paramToServiceMsg, (String)localObject1, "1", "");
                }
              }
              catch (Exception paramToServiceMsg)
              {
                QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Exception=" + paramToServiceMsg.getMessage());
                return;
              }
              try
              {
                paramFromServiceMsg = new HashMap();
                paramFromServiceMsg.put("param_themeId", paramToServiceMsg);
                paramFromServiceMsg.put("param_themeVersion", localObject1);
                paramFromServiceMsg.put("param_FailCode", String.valueOf(i));
                localObject1 = StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
                localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
                if (i >= 1) {
                  break label1867;
                }
                bool = true;
                ((StatisticCollector)localObject1).a((String)localObject2, "VipThemeAuthHandleError", bool, 1L, 0L, paramFromServiceMsg, "", false);
              }
              catch (Exception paramFromServiceMsg)
              {
                QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, StatisticCollector error=" + paramFromServiceMsg.toString());
                continue;
              }
              if ((i < 1) || (i == 5) || (i > 13)) {
                break label940;
              }
              QLog.i("Theme.ThemeHandler", 1, "handleThemeAuth Error, authResult=" + i);
              ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).edit().putInt("themeAuthResult", i).commit();
              ThemeUtil.setCurrentThemeIdVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "1000", "0");
              if (3 != i) {
                break label922;
              }
              ThemeUtil.setErrorThemeId(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramToServiceMsg, false);
              paramFromServiceMsg = ThemeUtil.getUserCurrentThemeVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
              ThemeUtil.getThemeResourcePath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramToServiceMsg, paramFromServiceMsg);
              bool = SkinEngine.getInstances().setSkinRootPath(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), null);
              if (QLog.isColorLevel()) {
                QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, set default theme");
              }
              if (bool == true) {
                ThreadManager.c().post(new qgp(this));
              }
              paramFromServiceMsg = ThemeUtil.getThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramToServiceMsg);
              if (!"5".equals(paramFromServiceMsg.status)) {
                break;
              }
              paramFromServiceMsg.status = "3";
              ThemeUtil.setThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramFromServiceMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, theme id = " + paramToServiceMsg);
              return;
              i = -1;
              continue;
              k = 0;
              continue;
              if (QLog.isColorLevel()) {
                QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + i);
              }
            }
          } while (i == 4);
          ThemeUtil.setWeekLoopTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, 0L);
          return;
        } while (i != 0);
        localObject1 = String.valueOf(((ThemeAuth.SubCmd0x1RspAuth)paramObject).uint32_theme_id.get());
        paramToServiceMsg = ((ThemeAuth.SubCmd0x1RspAuth)paramObject).str_version.get();
        paramFromServiceMsg = ((ThemeAuth.SubCmd0x1RspAuth)paramObject).str_download_url.get();
        i = ((ThemeAuth.SubCmd0x1RspAuth)paramObject).int32_suit_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + (String)localObject1 + ",ver=" + paramToServiceMsg + ",Url=" + paramFromServiceMsg + ", seriesId=" + i);
        }
        if ("999".equals(localObject1)) {
          break label1873;
        }
        if (!"1000".equals(localObject1)) {
          break label1864;
        }
        break label1873;
        Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if (i == 0) {
          break label1880;
        }
        paramFromServiceMsg = String.valueOf(i);
        ThemeUtil.setWeekLoopTheme((AppRuntime)localObject2, paramFromServiceMsg, null, 0L);
      } while (("0".equals(localObject1)) || (TextUtils.isEmpty(paramToServiceMsg)));
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putString("url", ((ThemeAuth.SubCmd0x1RspAuth)paramObject).str_download_url.get());
      paramFromServiceMsg.putString("themeId", (String)localObject1);
      paramFromServiceMsg.putString("version", paramToServiceMsg);
      paramFromServiceMsg.putLong("size", ((ThemeAuth.SubCmd0x1RspAuth)paramObject).uint32_size.get());
      paramFromServiceMsg.putLong("isSound", ((ThemeAuth.SubCmd0x1RspAuth)paramObject).int32_is_sound_theme.get());
      paramFromServiceMsg.putInt("themeType", 1);
      ThemeUtil.setSkinTheme(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1, paramToServiceMsg, paramFromServiceMsg);
      return;
      if (2 != j) {
        break;
      }
      i = ((ThemeAuth.SubCmd0x2RspCheck)((ThemeAuth.RspBody)localObject1).msg_subcmd0x2_rsp_check.get()).int32_result.get();
      if (QLog.isColorLevel()) {
        QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i);
      }
      paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (!TextUtils.isEmpty(paramToServiceMsg))
      {
        paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences(paramToServiceMsg, 0);
        if (i == 6) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", true).commit();
        }
        if (paramToServiceMsg.getBoolean("need_check_theme_ver", false)) {
          paramToServiceMsg.edit().putBoolean("need_check_theme_ver", false).commit();
        }
      }
    } while (i != 0);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(Conversation.class);
    paramFromServiceMsg = new Message();
    paramFromServiceMsg.what = 1038;
    paramFromServiceMsg.obj = c;
    paramToServiceMsg.sendMessage(paramFromServiceMsg);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
    paramFromServiceMsg = new Message();
    paramFromServiceMsg.what = 1039;
    paramToServiceMsg.sendMessageDelayed(paramFromServiceMsg, 90000L);
    return;
    if (3 == j)
    {
      if (k != 0)
      {
        paramToServiceMsg = (ThemeAuth.SubCmd0x3RspSet)((ThemeAuth.RspBody)localObject1).msg_subcmd0x3_rsp_set.get();
        i = paramToServiceMsg.int32_result.get();
        j = paramToServiceMsg.uint32_theme_id.get();
      }
      for (paramToServiceMsg = String.valueOf(j);; paramToServiceMsg = String.valueOf(j))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth Set result:" + i + ", themeId:" + paramToServiceMsg);
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null)) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == mServiceWeakRef || null == mReqbundle, result:" + i);
        return;
        paramFromServiceMsg = new ThemeAuth.ReqBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
        j = ((ThemeAuth.SubCmd0x3ReqSet)paramFromServiceMsg.msg_subcmd0x3_req_set.get()).uint32_theme_id.get();
        i = 65132;
      }
      paramFromServiceMsg = (ThemeDiyStyleLogic.StyleCallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramObject = (Bundle)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((paramFromServiceMsg == null) || (paramObject == null))
      {
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i);
        return;
      }
      if ((!TextUtils.isEmpty(paramToServiceMsg)) && (paramToServiceMsg.equals(((Bundle)paramObject).getString("themeId"))))
      {
        if (!QLog.isColorLevel()) {
          break label1885;
        }
        QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + paramToServiceMsg + ", result=" + i);
        break label1885;
      }
    }
    for (;;)
    {
      paramFromServiceMsg.callback(16, i, (Bundle)paramObject, null);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + paramToServiceMsg + ", rbThemeid=" + ((Bundle)paramObject).getString("themeId"));
      return;
      QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth subCmd error, subCmd:" + j);
      return;
      label1864:
      break label1071;
      label1867:
      bool = false;
      break;
      label1873:
      paramToServiceMsg = "580";
      break label1071;
      label1880:
      paramFromServiceMsg = null;
      break label1088;
      label1885:
      if (i == 0) {
        i = 4;
      } else {
        i = 8;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = ThemeUtil.getCurrentThemeInfo();
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = ((Bundle)localObject1).getString("version");
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "0";
      }
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = ((Bundle)localObject1).getString("themeId");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "1000";
      }
    }
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        paramString2 = ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface).getString("currentThemeId_6.3.5", null);
        localObject2 = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir() + "/authSp" + "6.5.5");
        QLog.i("Theme.ThemeHandler", 1, "sendThemeAuth data: themeId:" + paramString1 + ", currentThemeId:" + paramString2 + ", wfileDir.exists():" + ((File)localObject2).exists() + ", AppSetting.subVersion:" + "6.5.5");
        if (!((File)localObject2).exists())
        {
          ((File)localObject2).mkdirs();
          if (TextUtils.isEmpty(paramString2)) {
            ThemeUtil.setCurrentThemeIdVersion(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1, str);
          }
          paramString2 = ((Bundle)localObject1).getString("themePath");
          if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "Theme Auth themeId=" + paramString1 + ",version=" + str + ",currentThemeResPath=" + paramString2);
          }
          try
          {
            localObject1 = new ThemeAuth.SubCmd0x1ReqAuth();
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).uint32_op_type.set(1);
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).uint32_theme_id.set(Integer.parseInt(paramString1));
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).str_theme_version.set(str);
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
            localObject2 = ThemeUtil.getUinThemePreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
            if ("1000".equals(paramString1)) {
              break label1117;
            }
            Object localObject3 = a(paramString2);
            if (((HashMap)localObject3).size() < 3) {
              QLog.e("Theme.ThemeHandler", 2, "ThemeHandler sendThemeAuth fileMD5 size error:size=" + ((HashMap)localObject3).size());
            }
            localObject3 = ((HashMap)localObject3).entrySet().iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label798;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            if (QLog.isColorLevel()) {
              QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + (String)localEntry.getKey() + ",FileMd5=" + (String)localEntry.getValue());
            }
            ThemeAuth.ThemeFileInfo localThemeFileInfo = new ThemeAuth.ThemeFileInfo();
            localThemeFileInfo.str_file_path.set((String)localEntry.getKey());
            localThemeFileInfo.str_file_md5.set((String)localEntry.getValue());
            ((ThemeAuth.SubCmd0x1ReqAuth)localObject1).rpt_msg_topic_file_info.add(localThemeFileInfo);
            continue;
            if (BaseApplicationImpl.a) {
              continue;
            }
          }
          catch (Exception paramString2)
          {
            QLog.e("Theme.ThemeHandler", 1, "Theme Auth send Exception:" + paramString2.getMessage() + ", themeId=" + paramString1 + ", version=" + str);
          }
          QLog.e("Theme.ThemeHandler", 1, "ThemeHandler sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
          int j = NetworkUtil.a(null);
          if (!BaseApplicationImpl.a) {
            break label1216;
          }
          i = 1;
          ThemeReporter.a(null, "theme_detail", "205", 157, j, i, paramString1, str, "1", "");
          paramString1 = new File(AppConstants.cG);
          if (!paramString1.exists()) {
            paramString1.mkdirs();
          }
          return;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          continue;
        }
        paramString2 = new HashMap();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "VipThemeShareprefNull", false, 1L, 0L, paramString2, "", false);
        ThemeReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 137, paramString1, str, "0", "");
        continue;
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth StatisticCollector error" + paramString2.getMessage());
        paramString2 = paramString1;
      }
      continue;
      label798:
      ((SharedPreferences)localObject2).edit().putLong("authTime", 0L).commit();
      for (;;)
      {
        localObject2 = new ThemeAuth.ReqBody();
        ((ThemeAuth.ReqBody)localObject2).uint32_sub_cmd.set(1);
        ((ThemeAuth.ReqBody)localObject2).int32_plat_id.set(109);
        ((ThemeAuth.ReqBody)localObject2).str_qq_version.set("6.5.5.2880");
        ((ThemeAuth.ReqBody)localObject2).uint32_qq_version.set(Integer.parseInt("2880"));
        ((ThemeAuth.ReqBody)localObject2).msg_subcmd0x1_req_auth.set((MessageMicro)localObject1);
        ((ThemeAuth.ReqBody)localObject2).setHasFlag(true);
        localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "AuthSvr.ThemeAuth");
        ((ToServiceMsg)localObject1).putWupBuffer(((ThemeAuth.ReqBody)localObject2).toByteArray());
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request");
        }
        super.b((ToServiceMsg)localObject1);
        localObject1 = new File(paramString2);
        localObject2 = ThemeUtil.getThemeInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramString1);
        if ((!((File)localObject1).isDirectory()) || (localObject2 == null)) {
          break label1187;
        }
        i = ThemeJsPlugin.getFileNumInFile((File)localObject1);
        if ((i > 0) && ((((ThemeUtil.ThemeInfo)localObject2).fileNum <= 0) || (i >= ((ThemeUtil.ThemeInfo)localObject2).fileNum))) {
          break;
        }
        QLog.e("Theme.ThemeHandler", 1, "ThemeHandler sendThemeAuth fileNum Error:, themeInfo.fileNum:" + ((ThemeUtil.ThemeInfo)localObject2).fileNum + ", fileNum:" + i + ", themeId=" + paramString1 + ", version=" + str + ", currentThemeResPath:" + paramString2);
        ThemeReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "theme_detail", "204", 157, NetworkUtil.a(null), 101, paramString1, str, String.valueOf(i), String.valueOf(((ThemeUtil.ThemeInfo)localObject2).fileNum));
        break;
        label1117:
        long l1 = ((SharedPreferences)localObject2).getLong("authTime", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 <= l1 + 7200000L) {
          break label1171;
        }
        ((SharedPreferences)localObject2).edit().putLong("authTime", l2).commit();
      }
      label1171:
      if (QLog.isColorLevel())
      {
        QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
        return;
        label1187:
        QLog.e("Theme.ThemeHandler", 1, "ThemeHandler sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + paramString2);
        continue;
        label1216:
        i = -40;
      }
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 10
    //   11: iconst_2
    //   12: new 113	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 843
    //   22: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 750
    //   32: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 845
    //   42: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_3
    //   46: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +8 -> 67
    //   62: aload 4
    //   64: ifnonnull +13 -> 77
    //   67: ldc 10
    //   69: iconst_2
    //   70: ldc_w 847
    //   73: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: return
    //   77: aload 4
    //   79: ldc_w 478
    //   82: aload_1
    //   83: invokevirtual 476	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: new 590	java/lang/ref/WeakReference
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 850	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   96: putfield 576	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   99: aload_0
    //   100: new 590	java/lang/ref/WeakReference
    //   103: dup
    //   104: aload 4
    //   106: invokespecial 850	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   109: putfield 578	com/tencent/mobileqq/app/ThemeHandler:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   112: new 586	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet
    //   115: dup
    //   116: invokespecial 851	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:<init>	()V
    //   119: astore_2
    //   120: aload_2
    //   121: getfield 588	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_theme_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   124: aload_1
    //   125: invokestatic 677	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: invokevirtual 671	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   131: aload_3
    //   132: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: istore 8
    //   137: iload 7
    //   139: istore 6
    //   141: iload 8
    //   143: ifne +9 -> 152
    //   146: aload_3
    //   147: invokestatic 677	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   150: istore 6
    //   152: aload_2
    //   153: getfield 854	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:uint32_suit_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: iload 6
    //   158: invokevirtual 671	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   161: new 229	com/tencent/pb/theme/ThemeAuth$ReqBody
    //   164: dup
    //   165: invokespecial 230	com/tencent/pb/theme/ThemeAuth$ReqBody:<init>	()V
    //   168: astore_1
    //   169: aload_1
    //   170: getfield 240	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   173: iconst_3
    //   174: invokevirtual 671	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   177: aload_1
    //   178: getfield 770	com/tencent/pb/theme/ThemeAuth$ReqBody:int32_plat_id	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   181: bipush 109
    //   183: invokevirtual 771	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   186: aload_1
    //   187: getfield 774	com/tencent/pb/theme/ThemeAuth$ReqBody:str_qq_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   190: ldc_w 776
    //   193: invokevirtual 679	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   196: aload_1
    //   197: getfield 779	com/tencent/pb/theme/ThemeAuth$ReqBody:uint32_qq_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   200: ldc_w 781
    //   203: invokestatic 677	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   206: invokevirtual 671	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   209: aload_1
    //   210: getfield 584	com/tencent/pb/theme/ThemeAuth$ReqBody:msg_subcmd0x3_req_set	Lcom/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet;
    //   213: aload_2
    //   214: invokevirtual 855	com/tencent/pb/theme/ThemeAuth$SubCmd0x3ReqSet:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   217: aload_1
    //   218: iconst_1
    //   219: invokevirtual 787	com/tencent/pb/theme/ThemeAuth$ReqBody:setHasFlag	(Z)V
    //   222: new 232	com/tencent/qphone/base/remote/ToServiceMsg
    //   225: dup
    //   226: ldc_w 789
    //   229: aload_0
    //   230: getfield 164	com/tencent/mobileqq/app/ThemeHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   233: invokevirtual 791	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   236: ldc -72
    //   238: invokespecial 794	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   241: astore_2
    //   242: aload_2
    //   243: aload_1
    //   244: invokevirtual 797	com/tencent/pb/theme/ThemeAuth$ReqBody:toByteArray	()[B
    //   247: invokevirtual 801	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   250: aload_0
    //   251: aload_2
    //   252: invokespecial 806	com/tencent/mobileqq/app/BusinessHandler:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   255: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -182 -> 76
    //   261: ldc 10
    //   263: iconst_2
    //   264: ldc_w 857
    //   267: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: return
    //   271: astore_1
    //   272: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq -199 -> 76
    //   278: ldc 10
    //   280: iconst_2
    //   281: new 113	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 859
    //   291: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_1
    //   295: invokevirtual 439	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: astore_1
    //   309: ldc 10
    //   311: iconst_1
    //   312: ldc_w 861
    //   315: aload_1
    //   316: invokestatic 864	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: iload 7
    //   321: istore 6
    //   323: goto -171 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	ThemeHandler
    //   0	326	1	paramString1	String
    //   0	326	2	paramString2	String
    //   0	326	3	paramString3	String
    //   0	326	4	paramBundle	Bundle
    //   0	326	5	paramStyleCallBack	ThemeDiyStyleLogic.StyleCallBack
    //   139	183	6	i	int
    //   1	319	7	j	int
    //   135	7	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   77	137	271	java/lang/Exception
    //   152	270	271	java/lang/Exception
    //   309	319	271	java/lang/Exception
    //   146	152	308	java/lang/Exception
  }
  
  public void a(JSONArray paramJSONArray, int paramInt1, String arg3, int paramInt2)
  {
    if ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() <= this.d)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Theme.ThemeHandler", 2, "preDownloadWeekTheme nIndex:" + paramInt1 + ", from:" + ??? + ",loadType:" + paramInt2);
    }
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
      this.d = paramInt1;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), null, null);
    }
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject;
      try
      {
        if ((this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() <= this.d)) {
          break;
        }
        paramJSONArray = new ArrayList();
        localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label453;
        }
        localObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(paramInt1);
        if (localObject == null) {
          break label497;
        }
        String str1 = ((JSONObject)localObject).getString("url");
        String str2 = ((JSONObject)localObject).getString("id");
        String str3 = ((JSONObject)localObject).getString("version");
        long l = ((JSONObject)localObject).getInt("size");
        if (((JSONObject)localObject).has("isSound"))
        {
          paramInt2 = ((JSONObject)localObject).getInt("isSound");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (l <= 0L)) {
            break label497;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", str1);
          ((Bundle)localObject).putString("themeId", str2);
          ((Bundle)localObject).putString("version", str3);
          ((Bundle)localObject).putLong("size", l);
          ((Bundle)localObject).putLong("isSound", paramInt2);
          if (!"203".equals(???)) {
            break label411;
          }
          ((Bundle)localObject).putInt("net_type", 1);
          if (paramInt1 >= this.d) {
            break label443;
          }
          localArrayList.add(localObject);
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("Theme.ThemeHandler", 1, "preDownloadWeekTheme error:" + paramJSONArray.getMessage());
        return;
      }
      paramInt2 = 0;
      continue;
      label411:
      if (paramInt1 != this.d)
      {
        ((Bundle)localObject).putInt("net_type", 3);
      }
      else
      {
        ((Bundle)localObject).putInt("themeType", 1);
        continue;
        label443:
        paramJSONArray.add(localObject);
        break label497;
        label453:
        paramJSONArray.addAll(localArrayList);
        if (paramJSONArray.size() <= 0) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList = paramJSONArray;
          this.e = 0;
          a(null);
          return;
        }
        label497:
        paramInt1 += 1;
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {}
    }
    else
    {
      paramString2 = ThemeUtil.getCurrentThemeInfo();
      paramString1 = paramString2.getString("themeId");
      str = paramString2.getString("version");
    }
    if (("1000".equals(paramString1)) || ("999".equals(paramString1))) {
      return;
    }
    c = paramString1;
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt(str) % 10000;
        paramString2 = ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        if (!"m".equals(paramString2)) {
          break label329;
        }
        i -= 1000;
        if (QLog.isColorLevel()) {
          QLog.i("Theme.ThemeHandler", 2, "ver = " + i);
        }
        paramString2 = new ThemeAuth.SubCmd0x2ReqCheck();
        paramString2.str_theme_version.set(String.valueOf(i));
        paramString2.uint32_theme_id.set(Integer.parseInt(paramString1));
        paramString1 = new ThemeAuth.ReqBody();
        paramString1.uint32_sub_cmd.set(2);
        paramString1.int32_plat_id.set(109);
        paramString1.str_qq_version.set("6.5.5.2880");
        paramString1.uint32_qq_version.set(Integer.parseInt("2880"));
        paramString1.msg_subcmd0x2_req_check.set(paramString2);
        paramString1.setHasFlag(true);
        paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "AuthSvr.ThemeAuth");
        paramString2.putWupBuffer(paramString1.toByteArray());
        super.b(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Theme.ThemeHandler", 2, "ThemeVersion Check sent,cur_ver = " + i);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Theme.ThemeHandler", 2, "Exception:" + paramString1.toString());
      return;
      label329:
      boolean bool = "h".equals(paramString2);
      if (bool) {
        i -= 2000;
      } else {
        i -= 3000;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ThemeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */