package com.dataline.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import cm;
import cn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class DirectForwarder
{
  public static final int a = 0;
  static String a;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 8;
  static final int e = 0;
  static final int f = 32;
  static final int g = 64;
  static final int h = 128;
  static final int i = 268;
  static final int j = 512;
  public QQAppInterface a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "DirectForwarder";
  }
  
  public DirectForwarder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private long a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return 0L;
    }
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l += new File(str).length();
      }
    }
    return l;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = BaseApplicationImpl.a().getBaseContext().getResources().getString(paramInt1);
    if ((str != null) && (str.length() > 0)) {
      a(str, paramInt2);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.a(2130838420);
    localQQToast.c(2000);
    localQQToast.b(paramInt);
    localQQToast.b(paramContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(paramContext, 5.0F));
  }
  
  public static void a(Context paramContext, AsyncTask paramAsyncTask, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    FMDialogUtil.a(paramContext, 2131362855, 2131362851, new cn(paramAsyncTask, paramInt, paramFMDialogInterface));
  }
  
  public static void a(String paramString, int paramInt)
  {
    Context localContext = BaseApplicationImpl.a().getBaseContext();
    QQToast.a(localContext, paramInt, paramString, 1).b(localContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(localContext, 5.0F));
  }
  
  private int b(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_image");
    if ((paramString == null) || (paramString.equals(""))) {
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int m = 0;
    int k = 0;
    if (m < arrayOfString.length)
    {
      if (FileUtil.b(arrayOfString[m]))
      {
        paramString = arrayOfString[m];
        label85:
        if (TextUtils.isEmpty(paramString)) {
          break label248;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label238;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
        }
        if (a(paramString, paramInt, paramBoolean, paramCallBack) == 0) {
          k = 1;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        try
        {
          paramString = URLDecoder.decode(arrayOfString[m], "UTF-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardImage. decode exp. imageUrls[i]=" + arrayOfString[m]);
          }
          continue;
        }
        catch (IllegalArgumentException paramString)
        {
          paramString = arrayOfString[m];
        }
        break label85;
        label238:
        localArrayList.add(paramString);
        continue;
        label248:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        if (localArrayList.size() <= 1) {
          break label368;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report send multi pic:0X8004930.");
        }
      }
      while ((a(localArrayList, 1, paramInt, paramBoolean, paramCallBack) == 0) || (k != 0))
      {
        return 0;
        label368:
        if (localArrayList.size() == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report single pics:0X800492F.");
          }
        }
      }
      return 8;
    }
    if (k != 0) {
      return 0;
    }
    return 4;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
    case 4: 
      a(paramContext, 2131362182);
      return;
    case 8: 
      a("发送失败", 1);
      return;
    }
    a(2131369287, 2);
  }
  
  private int c(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_file");
    if ((paramString == null) || (paramString.equals(""))) {
      return 4;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(";");
    int m = 0;
    int k = 0;
    if (m < arrayOfString.length)
    {
      if (FileUtil.b(arrayOfString[m]))
      {
        paramString = arrayOfString[m];
        label86:
        if (TextUtils.isEmpty(paramString)) {
          break label209;
        }
        if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
          break label199;
        }
        if (a(paramString, paramInt, paramBoolean, paramCallBack) == 0) {
          k = 1;
        }
      }
      for (;;)
      {
        m += 1;
        break;
        try
        {
          paramString = URLDecoder.decode(arrayOfString[m], "UTF-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardFile|decode exp. imageUrls[i]=" + arrayOfString[m]);
          }
          continue;
        }
        catch (IllegalArgumentException paramString)
        {
          paramString = arrayOfString[m];
        }
        break label86;
        label199:
        localArrayList.add(paramString);
        continue;
        label209:
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile|file path invalid. path=" + paramString);
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e("qqdataline", 2, "forwardFile shareFromMigSdk|report send file:0X8004932.");
        }
      }
      if ((a(localArrayList, 0, paramInt, paramBoolean, paramCallBack) == 0) || (k != 0)) {
        return 0;
      }
      return 8;
    }
    if (k != 0) {
      return 0;
    }
    return 4;
  }
  
  private int d(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (Patterns.c.matcher(paramString).find()) {
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_link");
      }
      for (;;)
      {
        return a(paramString, paramInt, paramBoolean, paramCallBack);
        StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_text");
      }
    }
    return 4;
  }
  
  int a(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramCallBack != null) {
        paramCallBack.d();
      }
      return 32;
    }
    if (paramString.length() > 3478)
    {
      if (paramCallBack != null) {
        paramCallBack.c();
      }
      return 64;
    }
    if (paramBoolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramString, paramInt);
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle, DirectForwarder.CallBack paramCallBack)
  {
    int m = 0;
    int k = paramBundle.getInt("dataline_forward_type", -1);
    Object localObject = paramBundle.getStringArrayList("dataline_forward_pathlist");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("fileinfo_array");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    paramBundle = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (AppConstants.aj.equalsIgnoreCase(paramString)) {
      paramBundle.b = AppConstants.aj;
    }
    int n;
    for (paramBundle.ad = 0;; paramBundle.ad = 1)
    {
      n = paramBundle.ad;
      if (k != -1) {
        break label122;
      }
      m = 2;
      return m;
      if (!AppConstants.ak.equalsIgnoreCase(paramString)) {
        break;
      }
      paramBundle.b = AppConstants.ak;
    }
    return 8;
    label122:
    if (k == 100) {}
    for (k = 0;; k = 1)
    {
      if (localObject == null)
      {
        paramString = null;
        if (localArrayList != null) {}
        try
        {
          paramString = (ArrayList)localArrayList;
          if (paramString == null) {
            return 4;
          }
        }
        catch (ClassCastException paramString)
        {
          for (;;)
          {
            paramString = null;
          }
          paramCallBack = new ArrayList();
          paramString = paramString.iterator();
          k = 0;
          if (paramString.hasNext())
          {
            localObject = a((ForwardFileInfo)paramString.next(), false, n);
            if (localObject != null) {
              if (DataLineMsgSet.isSingle((DataLineMsgRecord)localObject))
              {
                localArrayList = new ArrayList();
                localArrayList.add(localObject);
                paramBundle.a(localArrayList, false);
                k = 1;
              }
            }
            for (;;)
            {
              break;
              paramCallBack.add(localObject);
            }
          }
          if (paramCallBack.size() > 0)
          {
            paramBundle.a(paramCallBack, false);
            return 0;
          }
        }
        if (k != 0) {
          break;
        }
        return 4;
      }
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext())
      {
        paramBundle = (String)paramString.next();
        if ((paramBundle == null) || (paramBundle.equals("/"))) {
          paramString.remove();
        }
      }
      if (!((ArrayList)localObject).isEmpty())
      {
        if (a((ArrayList)localObject, k, n, bool, paramCallBack) != 0) {
          break;
        }
        return 0;
      }
      return 4;
    }
  }
  
  int a(ArrayList paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultipleFile paths is null !!!!!!");
      }
      if (paramCallBack != null) {
        paramCallBack.b();
      }
      return 268;
    }
    if (paramBoolean)
    {
      int k = 0;
      localObject = "";
      while (k < paramArrayList.size())
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        localObject = (String)localObject + "sendMultipleFile shareFromMigSdk|report send one from sdk:0X800492D.";
        k += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, (String)localObject);
      }
    }
    Object localObject = new cm(this, paramArrayList, paramInt2);
    long l = a(paramArrayList);
    if (l == 0L)
    {
      if (paramCallBack != null) {
        paramCallBack.a();
      }
      return 128;
    }
    if ((NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (!NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (l > 3145728L))
    {
      if (paramCallBack != null) {
        paramCallBack.a((AsyncTask)localObject, paramInt1);
      }
      return 512;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt1) });
    return 0;
  }
  
  DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b());
    if (localFileManagerEntity == null) {}
    int n;
    do
    {
      return null;
      n = DataLineHandler.a(localFileManagerEntity);
    } while (!DataLineHandler.c(n));
    int m = DataLineHandler.a(paramForwardFileInfo.d(), paramBoolean);
    int k = m;
    if (!paramBoolean)
    {
      k = m;
      if (m == 1) {
        k = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.c(k);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.d();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.d();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.b();
    localDataLineMsgRecord.fileFrom = n;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.f();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.a(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.a())) {}
    for (localDataLineMsgRecord.path = paramForwardFileInfo.d();; localDataLineMsgRecord.path = paramForwardFileInfo.a()) {
      return localDataLineMsgRecord;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  boolean a(ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2)
  {
    if (paramForwardFileInfo == null) {}
    boolean bool;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return false;
        localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b());
      } while (localFileManagerEntity == null);
      QLog.i(jdField_a_of_type_JavaLangString, 1, "forwardFile sendOfflineFile forwardFileType: " + paramInt1 + " devType:" + paramInt2);
      int k = DataLineHandler.a(localFileManagerEntity);
      switch (k)
      {
      case 0: 
      default: 
        QLog.w(jdField_a_of_type_JavaLangString, 1, "forwardFile sendOfflineFile fileFrom " + k + " is not handled");
        return false;
      case 3: 
        if (paramInt1 != 101) {
          break label181;
        }
        bool = true;
        paramForwardFileInfo = a(paramForwardFileInfo, bool, paramInt2);
      }
    } while (paramForwardFileInfo == null);
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(paramForwardFileInfo, false);
    for (;;)
    {
      return true;
      label181:
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3, paramForwardFileInfo.b(), paramInt2);
      continue;
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 7, paramForwardFileInfo.a());
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), 6003, paramForwardFileInfo.a());
      }
    }
  }
  
  public int b(String paramString, Bundle paramBundle, DirectForwarder.CallBack paramCallBack)
  {
    int k = paramBundle.getInt("dataline_forward_type", -1);
    String str1 = paramBundle.getString("dataline_forward_path");
    String str2 = paramBundle.getString("dataline_forward_text");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramBundle.getParcelable("fileinfo");
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (AppConstants.aj.equalsIgnoreCase(paramString)) {
      localDataLineHandler.b = AppConstants.aj;
    }
    int m;
    for (localDataLineHandler.ad = 0;; localDataLineHandler.ad = 1)
    {
      m = localDataLineHandler.ad;
      if (k != -1) {
        break label133;
      }
      return 2;
      if (!AppConstants.ak.equalsIgnoreCase(paramString)) {
        break;
      }
      localDataLineHandler.b = AppConstants.ak;
    }
    return 8;
    label133:
    if (a(localForwardFileInfo, k, m)) {
      return 0;
    }
    switch (k)
    {
    default: 
      StatisticAssist.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_forwardin_other");
      return 4;
    case 101: 
      if ((str1 == null) || (str1.equals(""))) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleForwardRequest forward image, extras: " + paramBundle.toString());
      }
      return b(str1, m, bool, paramCallBack);
    case 100: 
      return c(str1, m, bool, paramCallBack);
    }
    return d(str2, m, bool, paramCallBack);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\core\DirectForwarder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */