package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.util.file.MediaStoreUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;
import siz;
import sja;
import sjb;
import sjc;
import sjd;
import sjf;
import sjg;
import sjh;
import sji;
import sjj;
import sjk;
import sjl;
import sjm;

public class FileManagerUtil
{
  private static final int jdField_a_of_type_Int = 16;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public static final String a = "sdCard";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static final String b = "externalSdCard";
  private static ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap jdField_b_of_type_JavaUtilHashMap;
  public static final String c = "ExternalFileOfFM";
  private static final String d = "FileManagerUtil<FileAssistant>";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "unknow peer type[" + String.valueOf(paramInt) + "]!");
      }
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    }
    return 3000;
  }
  
  public static int a(long paramLong)
  {
    return (short)((int)(0xFFFFFFFFFFFFFFFF & paramLong) & 0xFFFF);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    if ((paramMessageForFile.tempMsg != null) && (paramMessageForFile.tempMsg.length > 0)) {}
    for (Object localObject = paramMessageForFile.tempMsg[0].substring(1);; localObject = "")
    {
      paramMessageForFile.url = ((String)localObject);
      if (paramMessageForFile.url.length() == 0)
      {
        localObject = paramQQAppInterface.a().createEntityManager();
        paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.a(), paramMessageForFile.frienduin });
        ((EntityManager)localObject).a();
        if (paramQQAppInterface != null) {
          paramMessageForFile.url = paramQQAppInterface.fileName;
        }
      }
      if ((paramMessageForFile.url == null) || (paramMessageForFile.url.length() <= 0)) {
        break;
      }
      return a(paramMessageForFile.url);
    }
    return -1;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int k = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = k;
      if (paramFileManagerEntity.bSend)
      {
        j = k;
        if (8 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (5 != paramFileManagerEntity.nOpType)
          {
            j = k;
            if (1 != paramFileManagerEntity.nOpType) {
              j = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((j != 0) && ((j == 0) || (i == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  public static int a(String paramString)
  {
    for (;;)
    {
      try
      {
        String str1 = FileUtil.a(paramString);
        if (str1 != null)
        {
          i = str1.length();
          if (i != 0) {}
        }
        else
        {
          i = -1;
          return i;
        }
        if (jdField_b_of_type_JavaUtilHashMap == null) {
          jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        try
        {
          Object localObject = Class.forName("android.media.MediaFile").getDeclaredField("sFileTypeMap");
          ((Field)localObject).setAccessible(true);
          localObject = ((HashMap)((Field)localObject).get(null)).keySet().iterator();
          if (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            str2 = "." + str2;
            jdField_b_of_type_JavaUtilHashMap.put(str2.toLowerCase(), Integer.valueOf(1));
            continue;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
          jdField_b_of_type_JavaUtilHashMap.remove(".flv");
          jdField_b_of_type_JavaUtilHashMap.remove(".m");
          jdField_b_of_type_JavaUtilHashMap.remove(".webp");
          jdField_b_of_type_JavaUtilHashMap.remove(".vcf");
          jdField_b_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".ico", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".webp", Integer.valueOf(0));
          jdField_b_of_type_JavaUtilHashMap.put(".psd", Integer.valueOf(12));
          jdField_b_of_type_JavaUtilHashMap.put(".swf", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".wmf", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".flv", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".f4a", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".webm", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mod", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".fla", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4r", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
          jdField_b_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".wps", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(3));
          jdField_b_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".iso", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put("gz", Integer.valueOf(4));
          jdField_b_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
          jdField_b_of_type_JavaUtilHashMap.put(".apk.rename", Integer.valueOf(5));
          jdField_b_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".et", Integer.valueOf(6));
          jdField_b_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".dps", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".keynotes", Integer.valueOf(7));
          jdField_b_of_type_JavaUtilHashMap.put(".htm", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".html", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".php", Integer.valueOf(8));
          jdField_b_of_type_JavaUtilHashMap.put(".pdf", Integer.valueOf(9));
          jdField_b_of_type_JavaUtilHashMap.put(".txt", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".rtf", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".c", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".conf", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".cpp", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".h", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".java", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".log", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".prop", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".rc", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".sh", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(10));
          jdField_b_of_type_JavaUtilHashMap.put(".xml", Integer.valueOf(10));
          if (jdField_b_of_type_JavaUtilHashMap.containsKey(str1.toLowerCase())) {
            i = ((Integer)jdField_b_of_type_JavaUtilHashMap.get(str1.toLowerCase())).intValue();
          }
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          localClassNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          if (jdField_b_of_type_JavaUtilHashMap == null)
          {
            i = 11;
            continue;
          }
          jdField_b_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wave", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".midi", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".wma", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".ape", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".acc", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".aac", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".aiff", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mid", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".xmf", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".rtttl", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".flac", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".amr", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mp2", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m3u", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4b", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".m4p", Integer.valueOf(1));
          jdField_b_of_type_JavaUtilHashMap.put(".mpga", Integer.valueOf(1));
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label1585;
        }
      }
      finally {}
      QLog.w("FileManagerUtil<FileAssistant>", 2, "Unknow file Type[" + paramString + "]");
      label1585:
      int i = 11;
    }
  }
  
  public static int a(List paramList, long paramLong)
  {
    int i = 0;
    int j = paramList.size() - 1;
    int k = i;
    if (i <= j)
    {
      k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (localFileInfo.b() >= paramLong) {
          break label109;
        }
        k -= 1;
        j = i;
        i = k;
      }
    }
    label109:
    return k;
  }
  
  public static long a()
  {
    int i = MobileQQService.jdField_c_of_type_Int;
    MobileQQService.jdField_c_of_type_Int = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFFFFFFFFFF) & 0xFFFF);
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    return 3145728L;
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static SpannableString a(String paramString1, String paramString2, FileManagerUtil.TipsClickedInterface paramTipsClickedInterface)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new sji(paramTipsClickedInterface);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(2131427352), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = FMDataCache.c();
    Object localObject2 = FMDataCache.b();
    Object localObject1 = FMDataCache.e();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).b() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (a(((WeiYunFileInfo)localObject2).jdField_b_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    DataLineHandler localDataLineHandler;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_a_of_type_Int)
    {
      localFileManagerEntity.status = 3;
      localFileManagerEntity.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.setFilePath(paramMpfileTaskInfo.jdField_e_of_type_JavaLangString);
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      if (localFileManagerEntity.nFileType == 0)
      {
        localDataLineHandler = (DataLineHandler)((QQAppInterface)BaseApplicationImpl.a().a()).a(8);
        if (localDataLineHandler.a().a() != null) {
          break label275;
        }
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
    }
    for (;;)
    {
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      localFileManagerEntity.peerDin = paramLong;
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_c_of_type_Int)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
        break;
      }
      if ((paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_d_of_type_Int) || (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_e_of_type_Int))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
        break;
      }
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      break;
      label275:
      localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { localDataLineHandler.a().a(), paramMpfileTaskInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = paramQQAppInterface.a().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.a(), paramMessageForFile.frienduin });
      ((EntityManager)localObject).a();
      localFileManagerEntity.status = d(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label418;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label407;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label463;
        }
        localObject = new String(localTransFileInfo.uuid);
        label265:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label469;
      }
    }
    label407:
    label418:
    label463:
    label469:
    for (int i = 0;; i = 1)
    {
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.fProgress = ((float)paramQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.a().d(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return (FileManagerEntity)localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label265;
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    if (paramDataLineMsgRecord.fileMsgStatus == 0L) {
      if (!paramDataLineMsgRecord.issuc)
      {
        localFileManagerEntity2.status = 0;
        if (paramDataLineMsgRecord.nOpType == 1) {
          localFileManagerEntity2.bSend = false;
        }
        localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
          localFileManagerEntity2.setFilePath(paramDataLineMsgRecord.path);
        }
        localFileManagerEntity2.Uuid = paramDataLineMsgRecord.serverPath;
        if (1 != DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid)) {
          break label382;
        }
        localFileManagerEntity2.peerType = 6003;
        localFileManagerEntity2.peerUin = AppConstants.ak;
        label172:
        localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
        localFileManagerEntity2.strFileMd5 = com.tencent.mobileqq.utils.HexUtil.a(paramDataLineMsgRecord.md5);
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.filename);
        if (localFileManagerEntity2.nFileType != 0) {
          break label399;
        }
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
        localFileManagerEntity2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      if (paramDataLineMsgRecord.strMoloKey != null)
      {
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.path);
        localFileManagerEntity2.isFromrMolo = true;
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      if ((localFileManagerEntity2.fProgress == 1.0D) && ((localFileManagerEntity2.status == 3) || (localFileManagerEntity2.status == -1))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2.nOpType = paramDataLineMsgRecord.nOpType;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        localFileManagerEntity2.status = 2;
        break;
      }
      localFileManagerEntity2.status = 1;
      break;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        if (paramDataLineMsgRecord.progress == 0.0F)
        {
          localFileManagerEntity2.status = 0;
          break;
        }
        localFileManagerEntity2.status = 3;
        break;
      }
      localFileManagerEntity2.status = 3;
      break;
      label382:
      localFileManagerEntity2.peerType = 6000;
      localFileManagerEntity2.peerUin = AppConstants.aj;
      break label172;
      label399:
      if ((localFileManagerEntity2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == 63536)) {
        localFileManagerEntity2.nFileType = 0;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceFile.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceFile.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceFile.isSendFromLocal();
    localFileManagerEntity2.nOpType = 1;
    if (localFileManagerEntity2.bSend) {
      localFileManagerEntity2.nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus == 3) || (paramMessageForDeviceFile.nFileStatus == 1) || (paramMessageForDeviceFile.nFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = a(paramMessageForDeviceFile.filePath);
      if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceFile.filePath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceFile.fileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceFile.filePath);
      if ((localFileManagerEntity2.nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(DeviceMsgHandle.jdField_d_of_type_JavaLangString))) {
        localFileManagerEntity2.nFileType = 0;
      }
      localFileManagerEntity2.fProgress = paramMessageForDeviceFile.progress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceFile.uSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceFile.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceFile.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceFile.uniseq;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        localFileManagerEntity2.status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        localFileManagerEntity2.status = -1;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceSingleStruct.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus == 3) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 1) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
      localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
      localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
      localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
      if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceSingleStruct.strMediaFileName);
      localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int i = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (i >= 0) {}
    for (localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(i + 1);; localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename)
    {
      File localFile = new File(localFileManagerEntity.getFilePath());
      if (localFile.exists()) {
        localFileManagerEntity.fileSize = localFile.length();
      }
      localFileManagerEntity.nFileType = a(paramPrinterItemMsgRecord.filename);
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(RouterMsgRecord paramRouterMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramRouterMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramRouterMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramRouterMsgRecord.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramRouterMsgRecord.isSendFromLocal();
    if ((paramRouterMsgRecord.status == 2) || (paramRouterMsgRecord.status == 1)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = a(paramRouterMsgRecord.filename);
      localFileManagerEntity2.setFilePath(paramRouterMsgRecord.filename);
      localFileManagerEntity2.fileSize = paramRouterMsgRecord.fileSize;
      localFileManagerEntity2.nFileType = a(paramRouterMsgRecord.filename);
      localFileManagerEntity2.fProgress = ((float)paramRouterMsgRecord.progress);
      localFileManagerEntity2.uniseq = paramRouterMsgRecord.uSessionID;
      localFileManagerEntity2.peerDin = paramRouterMsgRecord.peerDin;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramRouterMsgRecord.status == 3) {
        localFileManagerEntity2.status = 1;
      } else if (paramRouterMsgRecord.status == 4) {
        localFileManagerEntity2.status = 0;
      } else if (paramRouterMsgRecord.status == 5) {
        localFileManagerEntity2.status = 3;
      }
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.e();
    localFileManagerEntity.setFilePath(paramFileInfo.d());
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.b() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = a(paramFileInfo.e()))
    {
      localFileManagerEntity.status = -1;
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramOfflineFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.jdField_d_of_type_Long;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    localQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity.nFileType = a(paramWeiYunFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.strThumbPath = paramWeiYunFileInfo.g;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nWeiYunSrcType = paramWeiYunFileInfo.jdField_c_of_type_Int;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.h;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    paramWeiYunFileInfo = localQQAppInterface.a().d(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (paramWeiYunFileInfo != null)
    {
      localFileManagerEntity.imgWidth = paramWeiYunFileInfo.imgWidth;
      localFileManagerEntity.imgHeight = paramWeiYunFileInfo.imgHeight;
    }
    localQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = paramTroopFileStatusInfo.g;
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    if (FileUtil.a(paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramTroopFileStatusInfo.g);
      if ((6 <= paramTroopFileStatusInfo.jdField_b_of_type_Int) && (13 != paramTroopFileStatusInfo.jdField_b_of_type_Int)) {
        break label232;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.strTroopFileSha1 = paramTroopFileStatusInfo.f;
      localFileManagerEntity.busId = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      localFileManagerEntity.TroopUin = paramTroopFileStatusInfo.jdField_a_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_a_of_type_Long);
      ((QQAppInterface)BaseApplicationImpl.a().a()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (!FileUtil.a(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
      break;
      label232:
      if (12 == paramTroopFileStatusInfo.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface)
  {
    return new sjm(paramQQAppInterface);
  }
  
  public static IForwardCallBack a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new sjl(paramQQAppInterface, paramInt);
  }
  
  public static CharSequence a(FileManagerEntity paramFileManagerEntity)
  {
    return QfileTimeUtils.c(paramFileManagerEntity.srvTime) + "  " + b(paramFileManagerEntity);
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String a()
  {
    String str = "";
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if (QLog.isColorLevel()) {
          QLog.e("FMERROR", 1, localStackTraceElement.toString());
        }
        str = str + localStackTraceElement.toString() + "\n";
        i += 1;
      }
      return str;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return "文件";
    case 1: 
      return "音乐";
    case 0: 
      return "图片";
    case 2: 
      return "视频";
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return "文档";
    }
    return "应用";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    if (paramLong <= 512000L) {
      return "0-500k";
    }
    if (paramLong <= 1048576L) {
      return "500k-1m";
    }
    if (paramLong <= 3145728L) {
      return "1m-3m";
    }
    if (paramLong <= 5242880L) {
      return "3m-5m";
    }
    if (paramLong <= 10485760L) {
      return "5m-10m";
    }
    return ">10m";
  }
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    long l2 = 604800000L;
    long l1 = l2;
    int i;
    int j;
    label136:
    label171:
    String str2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    case 0: 
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1 + paramLong);
      paramInt = localCalendar.get(1);
      i = localCalendar.get(2) + 1;
      j = localCalendar.get(5);
      str1 = paramInt + "-";
      if (i < 10)
      {
        str1 = str1 + "0" + i;
        if (j >= 10) {
          break label346;
        }
        str1 = str1 + "-0" + j;
        str2 = str1;
        if (paramBoolean)
        {
          paramInt = localCalendar.get(11);
          i = localCalendar.get(12);
          str1 = str1 + " ";
          if (paramInt >= 10) {
            break label377;
          }
        }
      }
      break;
    }
    label346:
    label377:
    for (String str1 = str1 + "0" + paramInt;; str1 = str1 + paramInt)
    {
      str1 = str1 + ":";
      if (i >= 10) {
        break label401;
      }
      str2 = str1 + "0" + i;
      return str2;
      l1 = 2592000000L;
      break;
      str1 = str1 + i;
      break label136;
      str1 = str1 + "-" + j;
      break label171;
    }
    label401:
    return str1 + i;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.getFilePath());
    }
    paramMessage = a(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + d(paramQQAppInterface.fileName);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = a(a(paramDataLineMsgRecord.path));
    return "[" + paramQQAppInterface + "]" + d(paramDataLineMsgRecord.filename);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (AppConstants.aj.equalsIgnoreCase(paramString1)) {
      return "我的电脑";
    }
    if (AppConstants.ak.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (AppConstants.af.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return ContactUtils.b(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.uniseq));
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.fProgress);
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgSeq));
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgUid));
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgTime));
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(e(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(e(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      return "";
    }
    int i = paramString.length();
    int j = paramString.lastIndexOf('/') + 1;
    if ((j < 0) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
    }
    return paramString.substring(j, i);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject2 = new File(FMSettings.a().d());
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = FMSettings.a().d() + a(paramString) + ".JPG";
    if (FileUtil.b((String)localObject2)) {
      localObject1 = localObject2;
    }
    int i;
    do
    {
      Bitmap localBitmap;
      do
      {
        return (String)localObject1;
        i = a(paramString);
        if (i != 0) {
          break;
        }
        localBitmap = MediaStoreUtil.a(paramString, paramInt1, paramInt2);
      } while (localBitmap == null);
      try
      {
        FileUtil.a(localBitmap, (String)localObject2);
        localBitmap.recycle();
        MediaStoreUtil.a((String)localObject2, MediaStoreUtil.a(paramString));
        return (String)localObject2;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
        return null;
      }
    } while (i != 2);
    a(paramString, true, paramInt1, paramInt2, 3, new sjj((String)localObject2, paramString));
    return (String)localObject2;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    if (paramString2 == null) {}
    for (int i = 0;; i = -1)
    {
      if (paramString3 == null) {}
      for (int j = paramString1.length();; j = -1)
      {
        int k = i;
        if (i == -1) {
          k = paramString1.indexOf(paramString2) + paramString2.length();
        }
        i = j;
        if (j == -1) {
          i = paramString1.indexOf(paramString3, k);
        }
        try
        {
          String str = paramString1.substring(k, i);
          return str;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 2, "srcString[" + String.valueOf(paramString1) + "],beginString[" + String.valueOf(paramString2) + "],endString[" + String.valueOf(paramString3) + "],benginPos[" + String.valueOf(k) + "],endPos[" + String.valueOf(i) + "]");
        return null;
      }
    }
  }
  
  public static String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, File paramFile)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l + "|1";
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static ArrayList a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject2 = new File(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (FileUtil.a((String)localObject2))
          {
            localObject2 = new File((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).d(((File)localObject2).getName());
            ((FileInfo)localObject3).a(((File)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((File)localObject2).getPath());
            ((FileInfo)localObject3).a(((File)localObject2).length());
            ((FileInfo)localObject3).b(((File)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label289;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new FileUtil.MyFileCompare());
    for (;;)
    {
      return localArrayList;
      label289:
      Collections.sort(localArrayList, new FileCompare());
    }
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int i = 0;
    if (i < paramString.length)
    {
      localObject = paramString[i].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  /* Error */
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 187	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 1466	java/util/HashMap:<init>	(I)V
    //   9: astore_3
    //   10: new 33	java/util/ArrayList
    //   13: dup
    //   14: bipush 10
    //   16: invokespecial 1467	java/util/ArrayList:<init>	(I)V
    //   19: astore 4
    //   21: new 33	java/util/ArrayList
    //   24: dup
    //   25: bipush 10
    //   27: invokespecial 1467	java/util/ArrayList:<init>	(I)V
    //   30: astore 5
    //   32: aload 4
    //   34: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   37: invokeinterface 1471 2 0
    //   42: pop
    //   43: aload 5
    //   45: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   48: invokeinterface 1471 2 0
    //   53: pop
    //   54: new 492	java/io/File
    //   57: dup
    //   58: ldc_w 1473
    //   61: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 498	java/io/File:exists	()Z
    //   69: ifeq +81 -> 150
    //   72: new 1475	java/util/Scanner
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 1478	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 1479	java/util/Scanner:hasNext	()Z
    //   85: ifeq +473 -> 558
    //   88: aload_1
    //   89: invokevirtual 1482	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload_2
    //   94: ldc_w 1484
    //   97: invokevirtual 1372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifne +13 -> 113
    //   103: aload_2
    //   104: ldc_w 1486
    //   107: invokevirtual 1372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   110: ifeq -29 -> 81
    //   113: aload_2
    //   114: ldc_w 1114
    //   117: invokevirtual 1455	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   120: iconst_1
    //   121: aaload
    //   122: astore_2
    //   123: aload_2
    //   124: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   127: invokevirtual 846	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifne -49 -> 81
    //   133: aload 4
    //   135: aload_2
    //   136: invokeinterface 1471 2 0
    //   141: pop
    //   142: goto -61 -> 81
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   150: new 492	java/io/File
    //   153: dup
    //   154: ldc_w 1488
    //   157: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 498	java/io/File:exists	()Z
    //   165: ifeq +99 -> 264
    //   168: new 1475	java/util/Scanner
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 1478	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   176: astore 6
    //   178: aload 6
    //   180: invokevirtual 1479	java/util/Scanner:hasNext	()Z
    //   183: ifeq +382 -> 565
    //   186: aload 6
    //   188: invokevirtual 1482	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   191: astore_1
    //   192: aload_1
    //   193: ldc_w 1490
    //   196: invokevirtual 1372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   199: ifeq -21 -> 178
    //   202: aload_1
    //   203: ldc_w 1114
    //   206: invokevirtual 1455	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: iconst_2
    //   210: aaload
    //   211: astore_2
    //   212: aload_2
    //   213: astore_1
    //   214: aload_2
    //   215: ldc_w 1116
    //   218: invokevirtual 1493	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   221: ifeq +16 -> 237
    //   224: aload_2
    //   225: iconst_0
    //   226: aload_2
    //   227: ldc_w 1116
    //   230: invokevirtual 513	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   233: invokevirtual 1248	java/lang/String:substring	(II)Ljava/lang/String;
    //   236: astore_1
    //   237: aload_1
    //   238: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   241: invokevirtual 846	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne -66 -> 178
    //   247: aload 5
    //   249: aload_1
    //   250: invokeinterface 1471 2 0
    //   255: pop
    //   256: goto -78 -> 178
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   264: new 492	java/io/File
    //   267: dup
    //   268: ldc_w 1495
    //   271: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 498	java/io/File:exists	()Z
    //   279: ifeq +99 -> 378
    //   282: new 1475	java/util/Scanner
    //   285: dup
    //   286: aload_1
    //   287: invokespecial 1478	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   290: astore 6
    //   292: aload 6
    //   294: invokevirtual 1479	java/util/Scanner:hasNext	()Z
    //   297: ifeq +276 -> 573
    //   300: aload 6
    //   302: invokevirtual 1482	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   305: astore_1
    //   306: aload_1
    //   307: ldc_w 1490
    //   310: invokevirtual 1372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   313: ifeq -21 -> 292
    //   316: aload_1
    //   317: ldc_w 1114
    //   320: invokevirtual 1455	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   323: iconst_2
    //   324: aaload
    //   325: astore_2
    //   326: aload_2
    //   327: astore_1
    //   328: aload_2
    //   329: ldc_w 1116
    //   332: invokevirtual 1493	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   335: ifeq +16 -> 351
    //   338: aload_2
    //   339: iconst_0
    //   340: aload_2
    //   341: ldc_w 1116
    //   344: invokevirtual 513	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   347: invokevirtual 1248	java/lang/String:substring	(II)Ljava/lang/String;
    //   350: astore_1
    //   351: aload_1
    //   352: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   355: invokevirtual 846	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   358: ifne -66 -> 292
    //   361: aload 5
    //   363: aload_1
    //   364: invokeinterface 1471 2 0
    //   369: pop
    //   370: goto -78 -> 292
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   378: new 492	java/io/File
    //   381: dup
    //   382: ldc_w 1497
    //   385: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 498	java/io/File:exists	()Z
    //   393: ifeq +99 -> 492
    //   396: new 1475	java/util/Scanner
    //   399: dup
    //   400: aload_1
    //   401: invokespecial 1478	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   404: astore 6
    //   406: aload 6
    //   408: invokevirtual 1479	java/util/Scanner:hasNext	()Z
    //   411: ifeq +170 -> 581
    //   414: aload 6
    //   416: invokevirtual 1482	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   419: astore_1
    //   420: aload_1
    //   421: ldc_w 1490
    //   424: invokevirtual 1372	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   427: ifeq -21 -> 406
    //   430: aload_1
    //   431: ldc_w 1114
    //   434: invokevirtual 1455	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   437: iconst_2
    //   438: aaload
    //   439: astore_2
    //   440: aload_2
    //   441: astore_1
    //   442: aload_2
    //   443: ldc_w 1116
    //   446: invokevirtual 1493	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   449: ifeq +16 -> 465
    //   452: aload_2
    //   453: iconst_0
    //   454: aload_2
    //   455: ldc_w 1116
    //   458: invokevirtual 513	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   461: invokevirtual 1248	java/lang/String:substring	(II)Ljava/lang/String;
    //   464: astore_1
    //   465: aload_1
    //   466: getstatic 1470	com/tencent/mobileqq/app/AppConstants:bh	Ljava/lang/String;
    //   469: invokevirtual 846	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   472: ifne -66 -> 406
    //   475: aload 5
    //   477: aload_1
    //   478: invokeinterface 1471 2 0
    //   483: pop
    //   484: goto -78 -> 406
    //   487: astore_1
    //   488: aload_1
    //   489: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   492: iconst_0
    //   493: istore 9
    //   495: iload 9
    //   497: aload 4
    //   499: invokeinterface 457 1 0
    //   504: if_icmpge +85 -> 589
    //   507: iload 9
    //   509: istore 10
    //   511: aload 5
    //   513: aload 4
    //   515: iload 9
    //   517: invokeinterface 460 2 0
    //   522: checkcast 58	java/lang/String
    //   525: invokeinterface 1499 2 0
    //   530: ifne +19 -> 549
    //   533: aload 4
    //   535: iload 9
    //   537: invokeinterface 1501 2 0
    //   542: pop
    //   543: iload 9
    //   545: iconst_1
    //   546: isub
    //   547: istore 10
    //   549: iload 10
    //   551: iconst_1
    //   552: iadd
    //   553: istore 9
    //   555: goto -60 -> 495
    //   558: aload_1
    //   559: invokevirtual 1504	java/util/Scanner:close	()V
    //   562: goto -412 -> 150
    //   565: aload 6
    //   567: invokevirtual 1504	java/util/Scanner:close	()V
    //   570: goto -306 -> 264
    //   573: aload 6
    //   575: invokevirtual 1504	java/util/Scanner:close	()V
    //   578: goto -200 -> 378
    //   581: aload 6
    //   583: invokevirtual 1504	java/util/Scanner:close	()V
    //   586: goto -94 -> 492
    //   589: aload 5
    //   591: invokeinterface 1507 1 0
    //   596: new 33	java/util/ArrayList
    //   599: dup
    //   600: bipush 10
    //   602: invokespecial 1467	java/util/ArrayList:<init>	(I)V
    //   605: astore_2
    //   606: aload 4
    //   608: invokeinterface 1508 1 0
    //   613: astore 5
    //   615: aload 5
    //   617: invokeinterface 227 1 0
    //   622: ifeq +270 -> 892
    //   625: new 492	java/io/File
    //   628: dup
    //   629: aload 5
    //   631: invokeinterface 231 1 0
    //   636: checkcast 58	java/lang/String
    //   639: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   642: astore 6
    //   644: aload 6
    //   646: invokevirtual 498	java/io/File:exists	()Z
    //   649: ifeq -34 -> 615
    //   652: aload 6
    //   654: invokevirtual 1409	java/io/File:isDirectory	()Z
    //   657: ifeq -42 -> 615
    //   660: aload 6
    //   662: invokevirtual 1511	java/io/File:canWrite	()Z
    //   665: ifeq -50 -> 615
    //   668: aload 6
    //   670: invokevirtual 1363	java/io/File:listFiles	()[Ljava/io/File;
    //   673: astore_1
    //   674: aload_1
    //   675: ifnonnull +102 -> 777
    //   678: iconst_2
    //   679: istore 9
    //   681: new 49	java/lang/StringBuilder
    //   684: dup
    //   685: iload 9
    //   687: invokespecial 1512	java/lang/StringBuilder:<init>	(I)V
    //   690: astore 7
    //   692: aload 7
    //   694: ldc_w 1128
    //   697: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload_1
    //   702: ifnull +87 -> 789
    //   705: aload_1
    //   706: arraylength
    //   707: istore 10
    //   709: iconst_0
    //   710: istore 9
    //   712: iload 9
    //   714: iload 10
    //   716: if_icmpge +73 -> 789
    //   719: aload_1
    //   720: iload 9
    //   722: aaload
    //   723: astore 8
    //   725: aload 7
    //   727: aload 8
    //   729: invokevirtual 1369	java/io/File:getName	()Ljava/lang/String;
    //   732: invokevirtual 1515	java/lang/String:hashCode	()I
    //   735: invokevirtual 1108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 7
    //   741: ldc_w 1116
    //   744: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload 7
    //   750: aload 8
    //   752: invokevirtual 504	java/io/File:length	()J
    //   755: invokevirtual 1153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 7
    //   761: ldc_w 1517
    //   764: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: iload 9
    //   770: iconst_1
    //   771: iadd
    //   772: istore 9
    //   774: goto -62 -> 712
    //   777: aload_1
    //   778: arraylength
    //   779: bipush 15
    //   781: imul
    //   782: iconst_2
    //   783: iadd
    //   784: istore 9
    //   786: goto -105 -> 681
    //   789: aload 7
    //   791: ldc_w 448
    //   794: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 7
    //   800: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: astore 7
    //   805: aload_2
    //   806: aload 7
    //   808: invokeinterface 1499 2 0
    //   813: ifne -198 -> 615
    //   816: new 49	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 1519
    //   826: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload_3
    //   830: invokeinterface 1392 1 0
    //   835: invokevirtual 1108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   838: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: astore_1
    //   842: aload_3
    //   843: invokeinterface 1392 1 0
    //   848: ifne +28 -> 876
    //   851: ldc 12
    //   853: astore_1
    //   854: aload_2
    //   855: aload 7
    //   857: invokeinterface 1471 2 0
    //   862: pop
    //   863: aload_3
    //   864: aload_1
    //   865: aload 6
    //   867: invokeinterface 1520 3 0
    //   872: pop
    //   873: goto -258 -> 615
    //   876: aload_3
    //   877: invokeinterface 1392 1 0
    //   882: iconst_1
    //   883: if_icmpne -29 -> 854
    //   886: ldc 17
    //   888: astore_1
    //   889: goto -35 -> 854
    //   892: aload_0
    //   893: ldc_w 1522
    //   896: invokevirtual 1528	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   899: checkcast 1530	android/os/storage/StorageManager
    //   902: astore_1
    //   903: aload_1
    //   904: invokevirtual 1534	java/lang/Object:getClass	()Ljava/lang/Class;
    //   907: ldc_w 1536
    //   910: aconst_null
    //   911: invokevirtual 1540	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   914: aload_1
    //   915: aconst_null
    //   916: invokevirtual 1546	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   919: checkcast 1547	[Ljava/lang/String;
    //   922: checkcast 1547	[Ljava/lang/String;
    //   925: astore_1
    //   926: aload_1
    //   927: arraylength
    //   928: istore 11
    //   930: iconst_0
    //   931: istore 9
    //   933: iload 9
    //   935: iload 11
    //   937: if_icmpge +126 -> 1063
    //   940: aload_1
    //   941: iload 9
    //   943: aaload
    //   944: astore_2
    //   945: new 492	java/io/File
    //   948: dup
    //   949: aload_2
    //   950: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
    //   953: astore 5
    //   955: getstatic 1552	android/os/Build$VERSION:SDK_INT	I
    //   958: bipush 9
    //   960: if_icmple +298 -> 1258
    //   963: aload 5
    //   965: invokevirtual 1555	java/io/File:getUsableSpace	()J
    //   968: lconst_0
    //   969: lcmp
    //   970: ifgt +6 -> 976
    //   973: goto +285 -> 1258
    //   976: aload_3
    //   977: invokeinterface 1557 1 0
    //   982: ifne +62 -> 1044
    //   985: aload_3
    //   986: invokeinterface 1558 1 0
    //   991: invokeinterface 222 1 0
    //   996: astore 6
    //   998: aload 6
    //   1000: invokeinterface 227 1 0
    //   1005: ifeq +247 -> 1252
    //   1008: aload_3
    //   1009: aload 6
    //   1011: invokeinterface 231 1 0
    //   1016: checkcast 58	java/lang/String
    //   1019: invokeinterface 1048 2 0
    //   1024: checkcast 492	java/io/File
    //   1027: invokevirtual 1366	java/io/File:getPath	()Ljava/lang/String;
    //   1030: aload_2
    //   1031: invokevirtual 1134	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1034: iconst_1
    //   1035: if_icmpne -37 -> 998
    //   1038: iconst_1
    //   1039: istore 10
    //   1041: goto +226 -> 1267
    //   1044: aload_3
    //   1045: ldc 17
    //   1047: aload 5
    //   1049: invokeinterface 1520 3 0
    //   1054: pop
    //   1055: goto +203 -> 1258
    //   1058: astore_1
    //   1059: aload_1
    //   1060: invokevirtual 1559	java/lang/IllegalArgumentException:printStackTrace	()V
    //   1063: aload 4
    //   1065: invokeinterface 1507 1 0
    //   1070: aload_3
    //   1071: invokeinterface 1557 1 0
    //   1076: ifeq +15 -> 1091
    //   1079: aload_3
    //   1080: ldc 12
    //   1082: invokestatic 1565	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   1085: invokeinterface 1520 3 0
    //   1090: pop
    //   1091: aload_3
    //   1092: ldc 17
    //   1094: invokeinterface 1566 2 0
    //   1099: ifne +76 -> 1175
    //   1102: aload_0
    //   1103: aconst_null
    //   1104: invokevirtual 1570	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   1107: astore_0
    //   1108: aload_0
    //   1109: ifnull +100 -> 1209
    //   1112: ldc 23
    //   1114: iconst_1
    //   1115: new 49	java/lang/StringBuilder
    //   1118: dup
    //   1119: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1122: ldc_w 1572
    //   1125: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: aload_0
    //   1129: invokevirtual 1366	java/io/File:getPath	()Ljava/lang/String;
    //   1132: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokestatic 1326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1141: aload_0
    //   1142: invokevirtual 1575	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1145: aload_3
    //   1146: ldc 12
    //   1148: invokeinterface 1048 2 0
    //   1153: checkcast 492	java/io/File
    //   1156: invokevirtual 1575	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1159: invokevirtual 1493	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1162: ifne +13 -> 1175
    //   1165: aload_3
    //   1166: ldc 17
    //   1168: aload_0
    //   1169: invokeinterface 1520 3 0
    //   1174: pop
    //   1175: aload_3
    //   1176: areturn
    //   1177: astore_1
    //   1178: aload_1
    //   1179: invokevirtual 1576	java/lang/IllegalAccessException:printStackTrace	()V
    //   1182: goto -119 -> 1063
    //   1185: astore_1
    //   1186: aload_1
    //   1187: invokevirtual 1577	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   1190: goto -127 -> 1063
    //   1193: astore_1
    //   1194: aload_1
    //   1195: invokevirtual 1578	java/lang/NoSuchMethodException:printStackTrace	()V
    //   1198: goto -135 -> 1063
    //   1201: astore_1
    //   1202: aload_1
    //   1203: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   1206: goto -143 -> 1063
    //   1209: ldc 23
    //   1211: iconst_1
    //   1212: ldc_w 1580
    //   1215: invokestatic 1326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1218: aload_3
    //   1219: areturn
    //   1220: astore_0
    //   1221: ldc 23
    //   1223: iconst_1
    //   1224: new 49	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   1231: ldc_w 1582
    //   1234: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: aload_0
    //   1238: invokevirtual 1583	java/lang/Exception:toString	()Ljava/lang/String;
    //   1241: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: invokestatic 1326	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1250: aload_3
    //   1251: areturn
    //   1252: iconst_0
    //   1253: istore 10
    //   1255: goto +12 -> 1267
    //   1258: iload 9
    //   1260: iconst_1
    //   1261: iadd
    //   1262: istore 9
    //   1264: goto -331 -> 933
    //   1267: iload 10
    //   1269: iconst_1
    //   1270: if_icmpeq -12 -> 1258
    //   1273: goto -229 -> 1044
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1276	0	paramContext	Context
    //   64	25	1	localObject1	Object
    //   145	2	1	localException1	Exception
    //   160	90	1	localObject2	Object
    //   259	2	1	localException2	Exception
    //   274	90	1	localObject3	Object
    //   373	2	1	localException3	Exception
    //   388	90	1	localObject4	Object
    //   487	72	1	localException4	Exception
    //   673	268	1	localObject5	Object
    //   1058	2	1	localIllegalArgumentException	IllegalArgumentException
    //   1177	2	1	localIllegalAccessException	IllegalAccessException
    //   1185	2	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1193	2	1	localNoSuchMethodException	NoSuchMethodException
    //   1201	2	1	localException5	Exception
    //   92	939	2	localObject6	Object
    //   9	1242	3	localHashMap	HashMap
    //   19	1045	4	localArrayList	ArrayList
    //   30	1018	5	localObject7	Object
    //   176	834	6	localObject8	Object
    //   690	166	7	localObject9	Object
    //   723	28	8	localObject10	Object
    //   493	770	9	i	int
    //   509	762	10	j	int
    //   928	10	11	k	int
    // Exception table:
    //   from	to	target	type
    //   54	81	145	java/lang/Exception
    //   81	113	145	java/lang/Exception
    //   113	142	145	java/lang/Exception
    //   558	562	145	java/lang/Exception
    //   150	178	259	java/lang/Exception
    //   178	212	259	java/lang/Exception
    //   214	237	259	java/lang/Exception
    //   237	256	259	java/lang/Exception
    //   565	570	259	java/lang/Exception
    //   264	292	373	java/lang/Exception
    //   292	326	373	java/lang/Exception
    //   328	351	373	java/lang/Exception
    //   351	370	373	java/lang/Exception
    //   573	578	373	java/lang/Exception
    //   378	406	487	java/lang/Exception
    //   406	440	487	java/lang/Exception
    //   442	465	487	java/lang/Exception
    //   465	484	487	java/lang/Exception
    //   581	586	487	java/lang/Exception
    //   892	930	1058	java/lang/IllegalArgumentException
    //   945	973	1058	java/lang/IllegalArgumentException
    //   976	998	1058	java/lang/IllegalArgumentException
    //   998	1038	1058	java/lang/IllegalArgumentException
    //   1044	1055	1058	java/lang/IllegalArgumentException
    //   892	930	1177	java/lang/IllegalAccessException
    //   945	973	1177	java/lang/IllegalAccessException
    //   976	998	1177	java/lang/IllegalAccessException
    //   998	1038	1177	java/lang/IllegalAccessException
    //   1044	1055	1177	java/lang/IllegalAccessException
    //   892	930	1185	java/lang/reflect/InvocationTargetException
    //   945	973	1185	java/lang/reflect/InvocationTargetException
    //   976	998	1185	java/lang/reflect/InvocationTargetException
    //   998	1038	1185	java/lang/reflect/InvocationTargetException
    //   1044	1055	1185	java/lang/reflect/InvocationTargetException
    //   892	930	1193	java/lang/NoSuchMethodException
    //   945	973	1193	java/lang/NoSuchMethodException
    //   976	998	1193	java/lang/NoSuchMethodException
    //   998	1038	1193	java/lang/NoSuchMethodException
    //   1044	1055	1193	java/lang/NoSuchMethodException
    //   892	930	1201	java/lang/Exception
    //   945	973	1201	java/lang/Exception
    //   976	998	1201	java/lang/Exception
    //   998	1038	1201	java/lang/Exception
    //   1044	1055	1201	java/lang/Exception
    //   1102	1108	1220	java/lang/Exception
    //   1112	1175	1220	java/lang/Exception
    //   1209	1218	1220	java/lang/Exception
  }
  
  public static void a()
  {
    ThreadManager.a(new siz(), 8, null, false);
  }
  
  public static void a(long paramLong)
  {
    Object localObject = ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(paramLong);
    if (localObject == null) {
      return;
    }
    switch (((FileManagerEntity)localObject).nOpType)
    {
    case -1: 
    case 0: 
    case 3: 
    case 7: 
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return;
    case 1: 
    case 5: 
    case 8: 
      localObject = d(((FileManagerEntity)localObject).fileName);
      FMToastUtil.c((String)localObject + BaseApplicationImpl.getContext().getString(2131362773) + FMSettings.a().b());
      return;
    }
    FMToastUtil.c(d(((FileManagerEntity)localObject).fileName) + BaseApplicationImpl.getContext().getString(2131362817));
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.a().a()).a().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (localFileManagerEntity.nOpType)
            {
            case -1: 
            case 2: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            default: 
              return;
            }
          } while (a(paramInt, localFileManagerEntity.fileName));
          if ((paramString == null) || (paramString.length() <= 0)) {
            break;
          }
          a(paramString);
          return;
          if ((paramString != null) && (paramString.length() > 0))
          {
            a(paramString);
            return;
          }
        } while (a(paramInt, localFileManagerEntity.fileName));
        a(13, localFileManagerEntity.fileName);
        return;
      } while (a(paramInt, localFileManagerEntity.fileName));
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString);
        return;
      }
      a(d(localFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131362816));
      return;
    } while (a(paramInt, localFileManagerEntity.fileName));
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(11, localFileManagerEntity.fileName);
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(13, localFileManagerEntity.fileName);
    return;
    a(13, localFileManagerEntity.fileName);
    return;
    a(paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      try
      {
        String str = a(paramString);
        Object localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        localObject = MimeTypesTools.a(paramActivity, str);
        Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int i = MediaStoreUtil.a(paramString);
        ContentValues localContentValues = new ContentValues(7);
        localContentValues.put("title", str);
        localContentValues.put("_display_name", localFile.getName());
        localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
        localContentValues.put("mime_type", (String)localObject);
        localContentValues.put("orientation", Integer.valueOf(i));
        localContentValues.put("_data", paramString);
        localContentValues.put("_size", Long.valueOf(localFile.length()));
        paramActivity.getContentResolver().insert(localUri, localContentValues);
        FMToastUtil.b(2131362836);
        return;
      }
      catch (Exception paramActivity)
      {
        FMToastUtil.a(2131362835);
        return;
      }
      catch (OutOfMemoryError paramActivity)
      {
        FMToastUtil.a(2131362835);
        return;
      }
    }
    FMToastUtil.a(2131362835);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2130968585, 2130968586);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 1, paramString1);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2130968590, 2130968591);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "[QFILE] QQ - startQFile failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), "加载失败，请重试", 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QfileFileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2131362851;
    }
    while (NetworkUtil.e(paramContext)) {
      if ((a()) && (!b(paramFileManagerEntity)))
      {
        FMDialogUtil.a(paramContext, 2131362855, i, new sjf(paramFileManagerEntity, paramQQAppInterface));
        return;
        i = 2131362852;
      }
      else
      {
        c(paramFileManagerEntity.nSessionId);
        paramQQAppInterface.a().a(paramFileManagerEntity.nSessionId);
        return;
      }
    }
    FMToastUtil.a(2131362941);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent2 = new Intent("android.intent.action.MAIN");
    localIntent2.addCategory("android.intent.category.LAUNCHER");
    localIntent2.putExtra(paramString1, true);
    localIntent2.setClassName(paramContext, JumpActivity.class.getName());
    Intent localIntent1 = new Intent();
    localIntent2.setFlags(337641472);
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramString2);
    paramString1 = new BitmapFactory.Options();
    paramString1.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramContext.getResources(), paramInt, paramString1);
    paramString1.inSampleSize = 1;
    paramString1.inJustDecodeBounds = false;
    paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), paramInt, paramString1);
    paramInt = DisplayUtils.b(paramContext);
    paramString1 = paramString2;
    if (paramString2.getWidth() != paramInt) {
      if (MobileIssueSettings.c) {
        break label227;
      }
    }
    label227:
    for (paramString1 = KapalaiAdapterUtil.a().a(paramString2, paramInt);; paramString1 = Bitmap.createScaledBitmap(paramString2, paramInt, paramInt, false))
    {
      localIntent1.putExtra("android.intent.extra.shortcut.ICON", paramString1);
      localIntent1.putExtra("duplicate", false);
      localIntent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramContext.sendBroadcast(localIntent1);
      paramContext = paramContext.getSharedPreferences("Offline_Flags", 0).edit();
      paramContext.clear();
      paramContext.putBoolean("TMPFLAG", true).commit();
      return;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130840398);
      return;
    }
    paramImageView.setImageResource(b(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = FileUtil.a(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130840398);
      label21:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (a(str3) == 0)
    {
      if (!FileUtils.b(paramDataLineMsgRecord.path)) {
        break label103;
      }
      str1 = paramDataLineMsgRecord.path;
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(b(str3));
      switch (a(str3))
      {
      default: 
        int i = b(str3);
        if (i == 0) {
          break label21;
        }
        paramAsyncImageView.setImageResource(i);
        return;
        label103:
        str1 = str2;
        if (FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
          str1 = paramDataLineMsgRecord.thumbPath;
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(str1);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838319);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
      if (QLog.isColorLevel()) {
        QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "]");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    long l = paramLong2;
    if (paramLong2 == 0L) {
      l = System.currentTimeMillis();
    }
    if (l < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int j = 0;
          int i = j;
          if (paramString9 != null)
          {
            i = j;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label775;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (NetworkUtil.e(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (i == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            paramString2 = new HashMap();
            paramString2.put("serverip", String.valueOf(str1));
            paramString2.put("param_Server", String.valueOf(str1));
            paramString2.put("param_ftnIP", String.valueOf(str1));
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.a() + "]"));
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "]");
            }
            if (QLog.isColorLevel()) {
              QLog.e("@@@@@@@", 2, "ReportFilemanagerInfo Color Log actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], errMsg[" + String.valueOf(paramString9) + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l;
            break;
            label775:
            if (paramString9.indexOf("No route to host") > 0)
            {
              i = 1;
            }
            else
            {
              i = j;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                i = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramQQAppInterface.a(), paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.bSend)
    {
      paramQQAppInterface = new sjg();
      DialogUtil.a(paramContext, 230, paramContext.getString(2131366192), paramContext.getString(2131366191), 2131367258, 2131367263, paramQQAppInterface, null).show();
      return;
    }
    paramQQAppInterface = paramContext.getString(2131362736);
    paramFileManagerEntity = paramContext.getString(2131362734);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    localActionSheet.c(paramQQAppInterface);
    localActionSheet.d(paramContext.getString(2131367262));
    localActionSheet.a(paramFileManagerEntity);
    localActionSheet.a(new sjh(localActionSheet));
    localActionSheet.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramChatMessage instanceof MessageForFile));
      MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
      localFileManagerEntity = a(paramQQAppInterface, localMessageForFile);
      switch (localFileManagerEntity.getCloudType())
      {
      case 2: 
      case 4: 
      default: 
        return;
      case 1: 
        if (paramChatMessage.isSend()) {}
        for (paramChatMessage = paramQQAppInterface.a();; paramChatMessage = localMessageForFile.frienduin)
        {
          FMToastUtil.b(d(localFileManagerEntity.fileName) + paramContext.getString(2131362814));
          paramQQAppInterface.a().a(localFileManagerEntity, paramChatMessage);
          paramQQAppInterface.a().c(localFileManagerEntity);
          if (QLog.isColorLevel()) {
            QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] No reInit,Show Juhua");
          }
          paramChatMessage = new FileManagerReporter.fileAssistantReportData();
          paramChatMessage.jdField_b_of_type_JavaLangString = "file_to_weiyun";
          paramChatMessage.jdField_a_of_type_Int = 9;
          paramChatMessage.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
          paramChatMessage.jdField_c_of_type_JavaLangString = FileUtil.a(localFileManagerEntity.fileName);
          FileManagerReporter.a(paramQQAppInterface.a(), paramChatMessage);
          return;
        }
      }
      if (a()) {
        try
        {
          FMDialogUtil.a(paramContext, 2131362855, 2131362851, new sjc(localMessageForFile, paramContext, paramQQAppInterface, localFileManagerEntity));
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          return;
        }
      }
      FMToastUtil.b(d(localFileManagerEntity.fileName) + paramContext.getString(2131362814));
      paramQQAppInterface.a().a(localFileManagerEntity.getFilePath(), null, paramQQAppInterface.getAccount(), 0, false);
      paramQQAppInterface.a().c(localFileManagerEntity);
    } while (!QLog.isColorLevel());
    QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] reInit");
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: aconst_null
    //   4: astore 9
    //   6: new 492	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 2156	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   14: invokevirtual 2161	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   17: ldc_w 2163
    //   20: invokespecial 2166	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 10
    //   25: aload_1
    //   26: ldc_w 1114
    //   29: ldc_w 2168
    //   32: invokevirtual 1442	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   35: pop
    //   36: iconst_5
    //   37: istore 13
    //   39: iload 13
    //   41: ifle +511 -> 552
    //   44: new 1345	java/net/URL
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 2169	java/net/URL:<init>	(Ljava/lang/String;)V
    //   52: invokevirtual 2173	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: checkcast 2175	java/net/HttpURLConnection
    //   58: astore 4
    //   60: aload 4
    //   62: sipush 30000
    //   65: invokevirtual 2178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   68: aload 4
    //   70: sipush 30000
    //   73: invokevirtual 2181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   76: aload 4
    //   78: ldc_w 2183
    //   81: ldc_w 2185
    //   84: invokevirtual 2188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 4
    //   89: invokevirtual 2192	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: astore 5
    //   94: new 2194	java/io/FileOutputStream
    //   97: dup
    //   98: aload 10
    //   100: invokespecial 2195	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore 7
    //   105: sipush 1024
    //   108: newarray <illegal type>
    //   110: astore 6
    //   112: aload 5
    //   114: aload 6
    //   116: invokevirtual 2201	java/io/InputStream:read	([B)I
    //   119: istore 12
    //   121: iload 12
    //   123: iconst_m1
    //   124: if_icmpeq +112 -> 236
    //   127: aload 7
    //   129: aload 6
    //   131: iconst_0
    //   132: iload 12
    //   134: invokevirtual 2205	java/io/FileOutputStream:write	([BII)V
    //   137: goto -25 -> 112
    //   140: astore 8
    //   142: aload 4
    //   144: astore 6
    //   146: aload 7
    //   148: astore 4
    //   150: aload 8
    //   152: astore 7
    //   154: aload 7
    //   156: invokevirtual 1418	java/lang/Exception:printStackTrace	()V
    //   159: aload 6
    //   161: ifnull +8 -> 169
    //   164: aload 6
    //   166: invokevirtual 2208	java/net/HttpURLConnection:disconnect	()V
    //   169: iload 11
    //   171: istore 12
    //   173: aload 5
    //   175: ifnull +370 -> 545
    //   178: aload 5
    //   180: invokevirtual 2209	java/io/InputStream:close	()V
    //   183: aload 4
    //   185: invokevirtual 2210	java/io/FileOutputStream:close	()V
    //   188: iload 11
    //   190: ifeq +188 -> 378
    //   193: iload 11
    //   195: ifeq +231 -> 426
    //   198: new 2212	com/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler
    //   201: dup
    //   202: invokespecial 2213	com/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler:<init>	()V
    //   205: astore_1
    //   206: invokestatic 2219	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   209: invokevirtual 2223	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   212: aload 10
    //   214: aload_1
    //   215: invokevirtual 2229	javax/xml/parsers/SAXParser:parse	(Ljava/io/File;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   218: new 2231	com/tencent/mobileqq/filemanager/data/FMConfig
    //   221: dup
    //   222: aload_0
    //   223: aload_1
    //   224: lload_2
    //   225: invokespecial 2234	com/tencent/mobileqq/filemanager/data/FMConfig:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/filemanager/util/FileManagerUtil$PreViewDataHandler;J)V
    //   228: pop
    //   229: aload 10
    //   231: invokevirtual 2237	java/io/File:delete	()Z
    //   234: pop
    //   235: return
    //   236: iconst_1
    //   237: istore 12
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 2208	java/net/HttpURLConnection:disconnect	()V
    //   249: aload 5
    //   251: ifnull +294 -> 545
    //   254: aload 5
    //   256: invokevirtual 2209	java/io/InputStream:close	()V
    //   259: aload 7
    //   261: invokevirtual 2210	java/io/FileOutputStream:close	()V
    //   264: iconst_1
    //   265: istore 11
    //   267: goto -79 -> 188
    //   270: astore 4
    //   272: aload 4
    //   274: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   277: iconst_1
    //   278: istore 11
    //   280: goto -92 -> 188
    //   283: astore 4
    //   285: aload 4
    //   287: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   290: goto -102 -> 188
    //   293: aload_1
    //   294: ifnull +7 -> 301
    //   297: aload_1
    //   298: invokevirtual 2208	java/net/HttpURLConnection:disconnect	()V
    //   301: aload 5
    //   303: ifnull +13 -> 316
    //   306: aload 5
    //   308: invokevirtual 2209	java/io/InputStream:close	()V
    //   311: aload 4
    //   313: invokevirtual 2210	java/io/FileOutputStream:close	()V
    //   316: aload_0
    //   317: athrow
    //   318: astore_0
    //   319: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +32 -> 354
    //   325: ldc 23
    //   327: iconst_2
    //   328: new 49	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 2239
    //   338: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: invokestatic 2243	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 690	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 10
    //   356: invokevirtual 2237	java/io/File:delete	()Z
    //   359: pop
    //   360: return
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   366: goto -50 -> 316
    //   369: astore_0
    //   370: aload 10
    //   372: invokevirtual 2237	java/io/File:delete	()Z
    //   375: pop
    //   376: aload_0
    //   377: athrow
    //   378: iload 13
    //   380: iconst_1
    //   381: isub
    //   382: istore 13
    //   384: goto -345 -> 39
    //   387: astore_0
    //   388: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq -162 -> 229
    //   394: ldc 23
    //   396: iconst_2
    //   397: new 49	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 2239
    //   407: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: invokestatic 2243	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   414: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 690	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -194 -> 229
    //   426: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq -200 -> 229
    //   432: ldc 23
    //   434: iconst_2
    //   435: new 49	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 2245
    //   445: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_1
    //   449: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 690	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: goto -229 -> 229
    //   461: astore_0
    //   462: aconst_null
    //   463: astore 5
    //   465: aload 4
    //   467: astore_1
    //   468: aload 9
    //   470: astore 4
    //   472: goto -179 -> 293
    //   475: astore_0
    //   476: aload 4
    //   478: astore_1
    //   479: aload 9
    //   481: astore 4
    //   483: goto -190 -> 293
    //   486: astore_0
    //   487: aload 4
    //   489: astore_1
    //   490: aload 7
    //   492: astore 4
    //   494: goto -201 -> 293
    //   497: astore_0
    //   498: aload 6
    //   500: astore_1
    //   501: goto -208 -> 293
    //   504: astore 7
    //   506: aconst_null
    //   507: astore 4
    //   509: aconst_null
    //   510: astore 5
    //   512: aconst_null
    //   513: astore 6
    //   515: goto -361 -> 154
    //   518: astore 7
    //   520: aconst_null
    //   521: astore 5
    //   523: aload 4
    //   525: astore 6
    //   527: aconst_null
    //   528: astore 4
    //   530: goto -376 -> 154
    //   533: astore 7
    //   535: aload 4
    //   537: astore 6
    //   539: aconst_null
    //   540: astore 4
    //   542: goto -388 -> 154
    //   545: iload 12
    //   547: istore 11
    //   549: goto -361 -> 188
    //   552: goto -359 -> 193
    //   555: astore_0
    //   556: aconst_null
    //   557: astore 5
    //   559: aconst_null
    //   560: astore_1
    //   561: aload 9
    //   563: astore 4
    //   565: goto -272 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	paramQQAppInterface	QQAppInterface
    //   0	568	1	paramString	String
    //   0	568	2	paramLong	long
    //   58	187	4	localObject1	Object
    //   270	3	4	localIOException1	IOException
    //   283	183	4	localIOException2	IOException
    //   470	94	4	localObject2	Object
    //   92	466	5	localInputStream	java.io.InputStream
    //   110	428	6	localObject3	Object
    //   103	388	7	localObject4	Object
    //   504	1	7	localException1	Exception
    //   518	1	7	localException2	Exception
    //   533	1	7	localException3	Exception
    //   140	11	8	localException4	Exception
    //   4	558	9	localObject5	Object
    //   23	348	10	localFile	File
    //   1	547	11	i	int
    //   119	427	12	j	int
    //   37	346	13	k	int
    // Exception table:
    //   from	to	target	type
    //   105	112	140	java/lang/Exception
    //   112	121	140	java/lang/Exception
    //   127	137	140	java/lang/Exception
    //   254	264	270	java/io/IOException
    //   178	188	283	java/io/IOException
    //   25	36	318	java/lang/Exception
    //   164	169	318	java/lang/Exception
    //   178	188	318	java/lang/Exception
    //   198	206	318	java/lang/Exception
    //   206	229	318	java/lang/Exception
    //   244	249	318	java/lang/Exception
    //   254	264	318	java/lang/Exception
    //   272	277	318	java/lang/Exception
    //   285	290	318	java/lang/Exception
    //   297	301	318	java/lang/Exception
    //   306	316	318	java/lang/Exception
    //   316	318	318	java/lang/Exception
    //   362	366	318	java/lang/Exception
    //   388	423	318	java/lang/Exception
    //   426	458	318	java/lang/Exception
    //   306	316	361	java/io/IOException
    //   25	36	369	finally
    //   164	169	369	finally
    //   178	188	369	finally
    //   198	206	369	finally
    //   206	229	369	finally
    //   244	249	369	finally
    //   254	264	369	finally
    //   272	277	369	finally
    //   285	290	369	finally
    //   297	301	369	finally
    //   306	316	369	finally
    //   316	318	369	finally
    //   319	354	369	finally
    //   362	366	369	finally
    //   388	423	369	finally
    //   426	458	369	finally
    //   206	229	387	java/lang/Throwable
    //   60	94	461	finally
    //   94	105	475	finally
    //   105	112	486	finally
    //   112	121	486	finally
    //   127	137	486	finally
    //   154	159	497	finally
    //   44	60	504	java/lang/Exception
    //   60	94	518	java/lang/Exception
    //   94	105	533	java/lang/Exception
    //   44	60	555	finally
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    int i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Complete_download_2_0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = StatisticAssist.a(paramContext, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.a(new sjb(paramString2, paramQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, a());
      }
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 2, "setTempParam[" + i + "]");
    }
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    switch (i)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.g());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.nFileType == -1) || (paramFileManagerEntity.nFileType == 5))
    {
      if (paramFileManagerEntity.getFilePath() != null) {
        paramFileManagerEntity.nFileType = a(paramFileManagerEntity.getFilePath());
      }
    }
    else {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (FileUtils.b(paramFileManagerEntity.getFilePath())) {
        str = paramFileManagerEntity.getFilePath();
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (FileUtils.b(paramFileManagerEntity.strThumbPath))
      {
        str = paramFileManagerEntity.strThumbPath;
      }
      else if (FileUtils.b(paramFileManagerEntity.strThumbPath))
      {
        str = paramFileManagerEntity.strThumbPath;
        continue;
        if (paramFileManagerEntity.nFileType == 2) {
          if (FileUtils.b(paramFileManagerEntity.strThumbPath)) {
            str = paramFileManagerEntity.strThumbPath;
          } else {
            str = null;
          }
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setImageResource(c(a(paramString)));
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      paramAsyncImageView.setImageResource(c(paramInt));
    }
    do
    {
      do
      {
        return;
        paramAsyncImageView.setDefaultImage(2130840362);
        paramAsyncImageView.setAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130840343);
      } while (!FileUtil.b(paramString));
      paramAsyncImageView.setApkIconAsyncImage(paramString);
      return;
      paramAsyncImageView.setDefaultImage(2130840399);
    } while (!FileUtil.b(paramString));
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = FileUtil.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130840398);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(b(paramString));
    } while (!paramBoolean);
    switch (a(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130840362);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130840399);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    FMToastUtil.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_flag_" + paramString;
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, FileManagerUtil.IGetVideoCallback paramIGetVideoCallback)
  {
    ThreadManager.a(new sjk(paramString, paramInt3, paramBoolean, paramIGetVideoCallback, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(List paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject = (FileManagerEntity)paramList.next();
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(10001);
        localForwardFileInfo.d(((FileManagerEntity)localObject).getCloudType());
        localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
        localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
        localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
        localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
        localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
        localForwardFileInfo.a(((FileManagerEntity)localObject).getFilePath());
        localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
        if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
          localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
        }
        for (;;)
        {
          localArrayList1.add(localForwardFileInfo);
          break;
          localArrayList2.add(Uri.parse(""));
        }
      }
    }
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", 0);
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", 0);
    paramList = "转发文件";
    if (localArrayList1.size() == 1) {
      paramList = "已选择" + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("forward_text", paramList);
      ((Intent)localObject).putExtra("k_favorites", false);
      ForwardBaseOption.a(paramActivity, (Intent)localObject, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramList = "已选择" + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + "等" + localArrayList1.size() + "个文件。";
      }
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == FMConstants.dr;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 6: 
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362811));
      return true;
    case 2: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 3: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362811));
      return true;
    case 4: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362811));
      return true;
    case 5: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 7: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 9: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 10: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 11: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    case 12: 
      FMToastUtil.a(2131362821);
      return true;
    case 16: 
      FMToastUtil.a(2131362822);
      return true;
    case 13: 
      FMToastUtil.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131362812));
      return true;
    }
    FMToastUtil.a(2131362882);
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {}
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(paramLong) + "]是否在队列中[" + String.valueOf(jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) + "]");
      }
    } while (!jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong)));
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQMusic", "FunctionalSwitch");
    if (paramQQAppInterface == null) {
      return false;
    }
    return Boolean.valueOf(paramQQAppInterface).booleanValue();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.fileName == null) || ("".equals(paramFileManagerEntity.fileName))) {}
    while (f("com.tencent.mtt") < 561300) {
      return false;
    }
    return a(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String str = FileUtil.a(paramString);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "mtt/" + str.replace(".", ""));
    paramQQAppInterface = paramQQAppInterface.a().getApplicationContext().getPackageManager().queryIntentActivities(localIntent, 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext()) {
        if (((ResolveInfo)paramQQAppInterface.next()).activityInfo.packageName.contains("com.tencent.mtt")) {
          return true;
        }
      }
    }
    paramQQAppInterface = str + "|";
    return (paramQQAppInterface != null) && (paramQQAppInterface.length() > 0) && (".rar|.zip|.7z|.doc|.docx|.ppt|.pptx|.xls|.xlsx|.txt|.pdf|.epub|.chm|.ini|.log|.bat|.php|.js|.lrc|.m3u8|.mp4|.flv|.avi|.3gp|.3gpp|.webm|.ts|.ogv|.asf|.wmv|.rmvb|.rm|.f4v|.mov|.mpg|.mkv|.mpeg|".contains(paramQQAppInterface.toLowerCase()));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = FMConfig.a(paramQQAppInterface.getApplication().getBaseContext(), paramString, "FileMaxSize");
    if (paramQQAppInterface == null) {}
    while (Integer.parseInt(paramQQAppInterface) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    }
    for (l1 = l2; l1 + l3 <= System.currentTimeMillis(); l1 = 2592000000L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.d();
    int j = paramIFileViewerAdapter.e();
    String str = paramIFileViewerAdapter.e();
    paramIFileViewerAdapter = paramIFileViewerAdapter.f();
    return (i == 3) && (j == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramIFileViewerAdapter)));
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().k(paramString);
    case 102: 
      return paramQQAppInterface.a().f(paramString);
    case 109: 
      return paramQQAppInterface.a().n(paramString);
    }
    return paramQQAppInterface.a().d(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 2598	java/io/BufferedInputStream
    //   5: dup
    //   6: new 2600	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 2601	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 2604	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray <illegal type>
    //   23: astore_3
    //   24: ldc_w 2606
    //   27: invokestatic 2611	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore_1
    //   31: aload_0
    //   32: aload_3
    //   33: invokevirtual 2201	java/io/InputStream:read	([B)I
    //   36: istore 4
    //   38: iload 4
    //   40: ifle +39 -> 79
    //   43: aload_1
    //   44: aload_3
    //   45: iconst_0
    //   46: iload 4
    //   48: invokevirtual 2614	java/security/MessageDigest:update	([BII)V
    //   51: goto -20 -> 31
    //   54: astore_1
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 2209	java/io/InputStream:close	()V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 2615	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -45 -> 31
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 2209	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: ifnull +25 -> 113
    //   91: aload_1
    //   92: invokevirtual 2619	java/security/MessageDigest:digest	()[B
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 2209	java/io/InputStream:close	()V
    //   108: aload_2
    //   109: areturn
    //   110: astore_0
    //   111: aload_2
    //   112: areturn
    //   113: aload_2
    //   114: astore_1
    //   115: aload_0
    //   116: ifnull -49 -> 67
    //   119: aload_0
    //   120: invokevirtual 2209	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_2
    //   132: astore_1
    //   133: aload_0
    //   134: ifnull -67 -> 67
    //   137: aload_0
    //   138: invokevirtual 2209	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 2209	java/io/InputStream:close	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_3
    //   160: goto -73 -> 87
    //   163: astore_0
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: goto -10 -> 157
    //   170: astore_1
    //   171: goto -22 -> 149
    //   174: astore_1
    //   175: goto -44 -> 131
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -126 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   30	14	1	localMessageDigest	java.security.MessageDigest
    //   54	1	1	localFileNotFoundException	FileNotFoundException
    //   56	12	1	localObject1	Object
    //   69	2	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	1	localObject2	Object
    //   146	12	1	localObject3	Object
    //   170	1	1	localObject4	Object
    //   174	1	1	localIOException1	IOException
    //   1	131	2	localObject5	Object
    //   23	22	3	arrayOfByte	byte[]
    //   159	1	3	localIOException2	IOException
    //   36	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   18	24	54	java/io/FileNotFoundException
    //   24	31	54	java/io/FileNotFoundException
    //   31	38	54	java/io/FileNotFoundException
    //   43	51	54	java/io/FileNotFoundException
    //   70	74	54	java/io/FileNotFoundException
    //   83	87	54	java/io/FileNotFoundException
    //   91	96	54	java/io/FileNotFoundException
    //   24	31	69	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   119	123	125	java/io/IOException
    //   2	18	128	java/io/IOException
    //   137	141	143	java/io/IOException
    //   2	18	146	finally
    //   83	87	159	java/io/IOException
    //   61	65	163	java/io/IOException
    //   153	157	166	java/io/IOException
    //   18	24	170	finally
    //   24	31	170	finally
    //   31	38	170	finally
    //   43	51	170	finally
    //   70	74	170	finally
    //   83	87	170	finally
    //   91	96	170	finally
    //   18	24	174	java/io/IOException
    //   24	31	174	java/io/IOException
    //   31	38	174	java/io/IOException
    //   43	51	174	java/io/IOException
    //   70	74	174	java/io/IOException
    //   91	96	174	java/io/IOException
    //   2	18	178	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 2600	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 2601	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 2621
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 2627	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 2628	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 2621
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   58: ldc 23
    //   60: iconst_1
    //   61: new 49	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 2630
    //   71: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: invokevirtual 2631	java/io/IOException:toString	()Ljava/lang/String;
    //   78: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_0
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_0
    //   93: aload_0
    //   94: astore_3
    //   95: ldc 23
    //   97: iconst_1
    //   98: new 49	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 2633
    //   108: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 5
    //   113: invokevirtual 2631	java/io/IOException:toString	()Ljava/lang/String;
    //   116: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 6
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull -85 -> 44
    //   132: aload_0
    //   133: invokevirtual 2628	java/io/FileInputStream:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   143: ldc 23
    //   145: iconst_1
    //   146: new 49	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 2630
    //   156: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: invokevirtual 2631	java/io/IOException:toString	()Ljava/lang/String;
    //   163: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 2628	java/io/FileInputStream:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_3
    //   188: aload_3
    //   189: invokevirtual 1292	java/io/IOException:printStackTrace	()V
    //   192: ldc 23
    //   194: iconst_1
    //   195: new 49	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 2630
    //   205: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_3
    //   209: invokevirtual 2631	java/io/IOException:toString	()Ljava/lang/String;
    //   212: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: goto -36 -> 185
    //   224: astore_0
    //   225: goto -48 -> 177
    //   228: astore 5
    //   230: aload 4
    //   232: astore_0
    //   233: goto -140 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   0	236	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	22	3	localIOException1	IOException
    //   94	88	3	localObject2	Object
    //   187	22	3	localIOException2	IOException
    //   11	220	4	localFileInputStream	java.io.FileInputStream
    //   89	23	5	localIOException3	IOException
    //   228	1	5	localIOException4	IOException
    //   1	125	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	89	java/io/IOException
    //   132	136	138	java/io/IOException
    //   3	13	174	finally
    //   181	185	187	java/io/IOException
    //   24	30	224	finally
    //   95	125	224	finally
    //   24	30	228	java/io/IOException
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2008: 
    default: 
      return -1;
    case 1000: 
    case 1001: 
    case 1002: 
    case 2000: 
    case 2001: 
    case 2002: 
      return 2;
    case 1004: 
    case 2004: 
      return 3;
    case 1005: 
    case 2005: 
    case 2006: 
      return 0;
    }
    return 1;
  }
  
  public static int b(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (paramString == null) {
      return 2130840398;
    }
    return c(a(paramString));
  }
  
  public static long b()
  {
    return MessageUtils.a(MessageUtils.a());
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((j < 0) || (i < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        j = Math.max(0, j / 2);
        i = Math.max(0, i / 2);
        localObject2 = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
        i = (paramInt1 - ((Rect)localObject2).width()) / 2;
        j = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
        return (Bitmap)localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label224:
        if (paramMatrix == null) {
          break label376;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
        if (paramMatrix != paramBitmap) {
          paramBitmap.recycle();
        }
        i = Math.max(0, paramMatrix.getWidth() - paramInt1);
        j = Math.max(0, paramMatrix.getHeight() - paramInt2);
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
      try
      {
        localObject2 = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
        localObject1 = localObject2;
        if (localObject2 == paramMatrix) {
          break;
        }
        localObject1 = localObject2;
        if (paramMatrix == paramBitmap) {
          break;
        }
        paramMatrix.recycle();
        return (Bitmap)localObject2;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
      }
      paramMatrix = null;
      break label224;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label224;
      }
      paramMatrix = null;
      break label224;
      label376:
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static IForwardCallBack b(QQAppInterface paramQQAppInterface)
  {
    return new sja(paramQQAppInterface);
  }
  
  public static String b()
  {
    return FMSettings.a().b();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static String b(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("##0.0");
    double d1 = 1024.0D * 1024.0D;
    double d2 = 1024.0D * d1;
    if (paramLong < 1024.0D) {
      return localDecimalFormat.format(paramLong) + "B/s";
    }
    if (paramLong < d1) {
      return localDecimalFormat.format(paramLong / 1024.0D) + "K/s";
    }
    if (paramLong < d2) {
      return localDecimalFormat.format(paramLong / d1) + "M/s";
    }
    return localDecimalFormat.format(paramLong / d2) + "G/s";
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject6 = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject1;
    label234:
    Object localObject2;
    label243:
    Object localObject5;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.getCloudType() == 0) {
        localObject1 = localBaseApplication.getString(2131362762);
      }
      if (paramFileManagerEntity.getCloudType() != 5) {
        break label1055;
      }
      if (paramFileManagerEntity.bSend)
      {
        localObject1 = localBaseApplication.getString(2131362764);
        localObject4 = paramFileManagerEntity.peerNick;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject2 == null) || (((String)localObject2).equals(localBaseApplication.getString(2131362752))) || (((String)localObject2).equals(localBaseApplication.getString(2131362763)))) {
          break label1049;
        }
        localObject5 = paramFileManagerEntity.peerNick;
        label283:
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = localBaseApplication.getString(2131362764);
          }
        }
        localObject4 = localObject5;
      }
      break;
    }
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
        localObject4 = localObject5;
        localObject2 = a(localQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
      }
      catch (Exception localException1)
      {
        QQAppInterface localQQAppInterface;
        label388:
        label425:
        localObject3 = localObject4;
        continue;
        if ((localObject1 != null) && (localObject3 != null)) {
          return (String)localObject1 + " " + (String)localObject3;
        }
        paramFileManagerEntity = (FileManagerEntity)localObject1;
        if (localObject1 != null) {
          continue;
        }
        return (String)localObject3;
      }
      try
      {
        if (paramFileManagerEntity.TroopUin == 0L) {
          break label1046;
        }
        localObject4 = ((TroopManager)localQQAppInterface.getManager(51)).a(String.valueOf(paramFileManagerEntity.TroopUin));
        if ((localObject4 != null) && (((TroopInfo)localObject4).troopname != null)) {
          continue;
        }
        localObject2 = "";
        localObject4 = localObject2;
        if (!paramFileManagerEntity.bSend) {
          continue;
        }
        localObject4 = localObject2;
        localObject2 = localBaseApplication.getString(2131362902) + (String)localObject2;
        localObject1 = null;
      }
      catch (Exception localException2)
      {
        continue;
      }
    }
    Object localObject4 = localObject2;
    if (localObject1 != null) {
      localObject4 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (((String)localObject1).equals(localBaseApplication.getString(2131362752))) {
          localObject4 = null;
        }
        localObject2 = localObject4;
        if ((paramFileManagerEntity.peerType != 3000) || (localObject1 == null)) {
          continue;
        }
        localObject2 = localObject4;
        if (((String)localObject1).equals(localBaseApplication.getString(2131362752))) {
          continue;
        }
        localObject2 = localObject4;
        localObject5 = ((DiscussionManager)localQQAppInterface.getManager(52)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if (localObject5 == null) {
          break label1062;
        }
        localObject2 = localObject4;
        if (((DiscussionInfo)localObject5).discussionName != null) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        continue;
        localObject3 = localObject1;
        localObject1 = localException3;
        continue;
      }
      localObject2 = localObject4;
      if (paramFileManagerEntity.bSend)
      {
        localObject2 = localObject4;
        localObject4 = localBaseApplication.getString(2131362903) + (String)localObject4;
        localObject1 = localObject4;
        localObject2 = localObject6;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(localBaseApplication.getString(2131362763))) || (!paramFileManagerEntity.bSend)) {
          continue;
        }
        paramFileManagerEntity = localBaseApplication.getString(2131362764) + " " + (String)localObject2;
        return paramFileManagerEntity;
        localObject1 = localBaseApplication.getString(2131362762);
        break;
        localObject1 = localBaseApplication.getString(2131362752);
        break;
        localObject1 = localBaseApplication.getString(2131362764);
        break;
        localObject1 = localBaseApplication.getString(2131362763);
        break;
        if (paramFileManagerEntity.bSend)
        {
          localObject1 = localBaseApplication.getString(2131362764);
          break;
        }
        localObject1 = localBaseApplication.getString(2131362762);
        break;
        localObject1 = localBaseApplication.getString(2131362884);
        break;
        localObject1 = localBaseApplication.getString(2131362885);
        break;
        localObject1 = localBaseApplication.getString(2131362886);
        break;
        localObject1 = localBaseApplication.getString(2131362887);
        break;
        localObject1 = localBaseApplication.getString(2131362888);
        break;
        localObject1 = localBaseApplication.getString(2131362889);
        break;
        localObject1 = localBaseApplication.getString(2131362890);
        break;
        localObject1 = localBaseApplication.getString(2131362891);
        break;
        localObject1 = localBaseApplication.getString(2131362762);
        break label234;
        if ((localObject4 != null) && (((TroopInfo)localObject4).troopname != null) && (((TroopInfo)localObject4).troopname.length() > 14))
        {
          localObject4 = ((TroopInfo)localObject4).troopname;
          localObject2 = localObject4;
          break label388;
        }
        localObject4 = ((TroopInfo)localObject4).troopname;
        localObject2 = localObject4;
        break label388;
        localObject4 = localObject2;
        localObject2 = localBaseApplication.getString(2131362901) + (String)localObject2;
        break label425;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((DiscussionInfo)localObject5).discussionName != null)
          {
            localObject2 = localObject4;
            if (((DiscussionInfo)localObject5).discussionName.length() > 14)
            {
              localObject2 = localObject4;
              localObject4 = ((DiscussionInfo)localObject5).discussionName;
              continue;
            }
          }
        }
        localObject2 = localObject4;
        localObject4 = ((DiscussionInfo)localObject5).discussionName;
        continue;
      }
      localObject2 = localObject4;
      localObject4 = localBaseApplication.getString(2131362904) + (String)localObject4;
      localObject1 = localObject4;
      localObject2 = localObject6;
      continue;
      label1046:
      label1049:
      localObject5 = localObject1;
      break label283;
      label1055:
      Object localObject3 = localObject1;
      localObject1 = null;
      break label243;
      label1062:
      String str = "";
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf(File.separator);
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label163;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      File localFile = new File(paramString);
      i = 1;
      str2 = paramString;
      paramString = localFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new File(str2);
        i += 1;
      }
      label163:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static URL b(String paramString, int paramInt1, int paramInt2, File paramFile)
  {
    long l = paramFile.lastModified();
    paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + l;
    try
    {
      paramString = new URL("fileassistantimage", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public static void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a().a();
    Object localObject = localQQAppInterface.a().a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        localQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.bSend);
      }
    }
    localQQAppInterface.a().f();
  }
  
  /* Error */
  public static void b(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 33	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 36	java/util/ArrayList:<init>	()V
    //   16: putstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: getstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 1035	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 2473	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 1035	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1376	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 619
    //   58: iconst_2
    //   59: new 49	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 2470
    //   69: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 113	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 2797
    //   82: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_2
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   94	5	2	localObject	Object
    //   29	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      FMToastUtil.a(2131362811);
      return;
    }
    String str = MimeTypesTools.a(paramActivity, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
    paramString = paramActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((paramString.size() == 1) && (((ResolveInfo)paramString.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int i = 1;; i = 0)
    {
      if ((paramString.size() > 0) && (i == 0)) {
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity)
        {
          FMToastUtil.a(2131362160);
          return;
        }
      }
      FMToastUtil.a(2131362160);
      return;
    }
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    QQProxyForQlink.a(paramActivity, 3, paramString1);
  }
  
  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {}
    sjd localsjd;
    int i;
    do
    {
      do
      {
        return;
      } while (!(paramChatMessage instanceof MessageForFile));
      Object localObject = a(paramQQAppInterface, (MessageForFile)paramChatMessage);
      paramChatMessage = new Bundle();
      paramChatMessage.putInt("forward_type", 0);
      paramChatMessage.putBoolean("not_forward", true);
      paramChatMessage.putInt("dataline_forward_type", 100);
      paramChatMessage.putString("dataline_forward_path", ((FileManagerEntity)localObject).getFilePath());
      paramChatMessage.putParcelable("fileinfo", ForwardFileOption.a((FileManagerEntity)localObject));
      localObject = (DataLineHandler)paramQQAppInterface.a(8);
      localsjd = new sjd(paramContext);
      i = ((DataLineHandler)localObject).a().b(AppConstants.aj, paramChatMessage, localsjd);
    } while ((localsjd.jdField_a_of_type_Boolean) && (i != 0));
    if (i == 0) {}
    DirectForwarder.b(paramContext, i);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.strSrcName == null) {
      paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
    }
    while (paramFileManagerEntity.strSrcName.length() != 0) {
      return;
    }
    paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
  }
  
  public static void b(String paramString)
  {
    try
    {
      BaseApplicationImpl.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_guide_flag_" + paramString;
    localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean b()
  {
    return AppNetConnInfo.isWifiConn();
  }
  
  public static boolean b(long paramLong)
  {
    if (jdField_b_of_type_JavaUtilArrayList == null) {
      jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (jdField_b_of_type_JavaUtilArrayList.size() == 0)
    {
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-6101L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-7004L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-7010L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-20103L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-25081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-25092L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-30017L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-9527L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91245L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91354L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-91999L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98064L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98071L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98075L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98084L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98085L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98090L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98091L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(-98095L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(8L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(900L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(4606L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9001L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9003L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9004L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9005L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9009L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9014L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9023L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9024L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9035L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9037L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9040L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9041L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9042L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9043L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9045L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9047L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9048L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9049L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9050L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9051L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9052L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9053L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9054L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9056L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9057L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9060L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9061L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9072L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9080L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9081L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9322L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(9361L));
      jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(90451L));
    }
    return jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQBrowse", "FunctionalSwitch");
    if (paramQQAppInterface == null) {
      return false;
    }
    return Boolean.valueOf(paramQQAppInterface).booleanValue();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.fileName == null) || ("".equals(paramFileManagerEntity.fileName))) {}
    int i;
    do
    {
      String str;
      do
      {
        return false;
        str = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQMusic", "SupportVersion");
      } while (str == null);
      i = Integer.valueOf(str).intValue();
    } while (f("com.tencent.qqmusic") < i);
    return b(paramQQAppInterface, paramFileManagerEntity.fileName);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = FMConfig.d(paramQQAppInterface.getApplication().getBaseContext(), "OpenForQQMusic", "FormatSupport");
    String str = FileUtil.a(paramString);
    if ((paramQQAppInterface != null) && (str != null) && (str.length() > 0) && (paramQQAppInterface.indexOf(str) >= 0)) {}
    while (a(paramString) == 1) {
      return true;
    }
    return false;
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() == 3) {
      return false;
    }
    switch (paramFileManagerEntity.nOpType)
    {
    case 0: 
    case 1: 
    case 5: 
    case 6: 
    case 8: 
    case 2: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(IFileViewerAdapter paramIFileViewerAdapter)
  {
    int i = paramIFileViewerAdapter.d();
    int j = paramIFileViewerAdapter.e();
    return (i == 3) && (j == 1);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore 6
    //   5: ldc_w 2606
    //   8: invokestatic 2611	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +29 -> 42
    //   16: aload_3
    //   17: astore_0
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 2982	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 2983	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: aload_0
    //   31: areturn
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 2615	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   37: aconst_null
    //   38: astore_2
    //   39: goto -27 -> 12
    //   42: new 2598	java/io/BufferedInputStream
    //   45: dup
    //   46: new 2600	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 2601	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 2604	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_1
    //   58: sipush 10240
    //   61: newarray <illegal type>
    //   63: astore 4
    //   65: aload_0
    //   66: invokestatic 2985	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)J
    //   69: lstore 7
    //   71: iconst_0
    //   72: istore 5
    //   74: iload 5
    //   76: sipush 1024
    //   79: if_icmpge +25 -> 104
    //   82: aload_2
    //   83: aload 4
    //   85: iconst_0
    //   86: aload_1
    //   87: aload 4
    //   89: invokevirtual 2201	java/io/InputStream:read	([B)I
    //   92: invokevirtual 2614	java/security/MessageDigest:update	([BII)V
    //   95: iload 5
    //   97: iconst_1
    //   98: iadd
    //   99: istore 5
    //   101: goto -27 -> 74
    //   104: aload_1
    //   105: lload 7
    //   107: ldc2_w 811
    //   110: ldiv
    //   111: ldc2_w 1083
    //   114: lsub
    //   115: ldc2_w 1087
    //   118: lsub
    //   119: invokevirtual 2989	java/io/InputStream:skip	(J)J
    //   122: pop2
    //   123: iconst_0
    //   124: istore 5
    //   126: iload 5
    //   128: sipush 1024
    //   131: if_icmpge +25 -> 156
    //   134: aload_2
    //   135: aload 4
    //   137: iconst_0
    //   138: aload_1
    //   139: aload 4
    //   141: invokevirtual 2201	java/io/InputStream:read	([B)I
    //   144: invokevirtual 2614	java/security/MessageDigest:update	([BII)V
    //   147: iload 5
    //   149: iconst_1
    //   150: iadd
    //   151: istore 5
    //   153: goto -27 -> 126
    //   156: aload_1
    //   157: lload 7
    //   159: ldc2_w 811
    //   162: ldiv
    //   163: ldc2_w 2990
    //   166: lsub
    //   167: lconst_1
    //   168: ladd
    //   169: invokevirtual 2989	java/io/InputStream:skip	(J)J
    //   172: pop2
    //   173: iconst_0
    //   174: istore 5
    //   176: iload 5
    //   178: sipush 1024
    //   181: if_icmpge +25 -> 206
    //   184: aload_2
    //   185: aload 4
    //   187: iconst_0
    //   188: aload_1
    //   189: aload 4
    //   191: invokevirtual 2201	java/io/InputStream:read	([B)I
    //   194: invokevirtual 2614	java/security/MessageDigest:update	([BII)V
    //   197: iload 5
    //   199: iconst_1
    //   200: iadd
    //   201: istore 5
    //   203: goto -27 -> 176
    //   206: bipush 8
    //   208: newarray <illegal type>
    //   210: astore_0
    //   211: iload 6
    //   213: istore 5
    //   215: goto +130 -> 345
    //   218: aload_2
    //   219: aload_0
    //   220: iconst_0
    //   221: bipush 8
    //   223: invokevirtual 2614	java/security/MessageDigest:update	([BII)V
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 2209	java/io/InputStream:close	()V
    //   234: aload_2
    //   235: ifnull +23 -> 258
    //   238: aload_2
    //   239: invokevirtual 2619	java/security/MessageDigest:digest	()[B
    //   242: astore_2
    //   243: aload_2
    //   244: astore_0
    //   245: aload_1
    //   246: ifnull -216 -> 30
    //   249: aload_1
    //   250: invokevirtual 2209	java/io/InputStream:close	()V
    //   253: aload_2
    //   254: areturn
    //   255: astore_0
    //   256: aload_2
    //   257: areturn
    //   258: aload_3
    //   259: astore_0
    //   260: aload_1
    //   261: ifnull -231 -> 30
    //   264: aload_1
    //   265: invokevirtual 2209	java/io/InputStream:close	()V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_0
    //   271: aconst_null
    //   272: areturn
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload_3
    //   277: astore_0
    //   278: aload_1
    //   279: ifnull -249 -> 30
    //   282: aload_1
    //   283: invokevirtual 2209	java/io/InputStream:close	()V
    //   286: aconst_null
    //   287: areturn
    //   288: astore_0
    //   289: aconst_null
    //   290: areturn
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_3
    //   295: astore_0
    //   296: aload_1
    //   297: ifnull -267 -> 30
    //   300: aload_1
    //   301: invokevirtual 2209	java/io/InputStream:close	()V
    //   304: aconst_null
    //   305: areturn
    //   306: astore_0
    //   307: aconst_null
    //   308: areturn
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 2209	java/io/InputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: aconst_null
    //   324: areturn
    //   325: astore_0
    //   326: goto -92 -> 234
    //   329: astore_1
    //   330: goto -10 -> 320
    //   333: astore_0
    //   334: goto -22 -> 312
    //   337: astore_0
    //   338: goto -44 -> 294
    //   341: astore_0
    //   342: goto -66 -> 276
    //   345: iload 5
    //   347: bipush 8
    //   349: if_icmpge -131 -> 218
    //   352: aload_0
    //   353: bipush 8
    //   355: iload 5
    //   357: isub
    //   358: iconst_1
    //   359: isub
    //   360: lload 7
    //   362: bipush 64
    //   364: iload 5
    //   366: iconst_1
    //   367: iadd
    //   368: bipush 8
    //   370: imul
    //   371: isub
    //   372: lshr
    //   373: ldc2_w 2992
    //   376: land
    //   377: l2i
    //   378: i2b
    //   379: bastore
    //   380: iload 5
    //   382: iconst_1
    //   383: iadd
    //   384: istore 5
    //   386: goto -41 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString	String
    //   32	2	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   57	260	1	localBufferedInputStream	java.io.BufferedInputStream
    //   329	1	1	localIOException	IOException
    //   11	246	2	localObject1	Object
    //   1	294	3	localObject2	Object
    //   63	127	4	arrayOfByte	byte[]
    //   72	313	5	i	int
    //   3	209	6	j	int
    //   69	292	7	l	long
    // Exception table:
    //   from	to	target	type
    //   5	12	32	java/security/NoSuchAlgorithmException
    //   249	253	255	java/io/IOException
    //   264	268	270	java/io/IOException
    //   5	12	273	java/io/FileNotFoundException
    //   33	37	273	java/io/FileNotFoundException
    //   42	58	273	java/io/FileNotFoundException
    //   282	286	288	java/io/IOException
    //   5	12	291	java/io/IOException
    //   33	37	291	java/io/IOException
    //   42	58	291	java/io/IOException
    //   300	304	306	java/io/IOException
    //   5	12	309	finally
    //   33	37	309	finally
    //   42	58	309	finally
    //   22	30	322	java/io/IOException
    //   230	234	325	java/io/IOException
    //   316	320	329	java/io/IOException
    //   58	71	333	finally
    //   82	95	333	finally
    //   104	123	333	finally
    //   134	147	333	finally
    //   156	173	333	finally
    //   184	197	333	finally
    //   206	211	333	finally
    //   218	226	333	finally
    //   230	234	333	finally
    //   238	243	333	finally
    //   58	71	337	java/io/IOException
    //   82	95	337	java/io/IOException
    //   104	123	337	java/io/IOException
    //   134	147	337	java/io/IOException
    //   156	173	337	java/io/IOException
    //   184	197	337	java/io/IOException
    //   206	211	337	java/io/IOException
    //   218	226	337	java/io/IOException
    //   238	243	337	java/io/IOException
    //   58	71	341	java/io/FileNotFoundException
    //   82	95	341	java/io/FileNotFoundException
    //   104	123	341	java/io/FileNotFoundException
    //   134	147	341	java/io/FileNotFoundException
    //   156	173	341	java/io/FileNotFoundException
    //   184	197	341	java/io/FileNotFoundException
    //   206	211	341	java/io/FileNotFoundException
    //   218	226	341	java/io/FileNotFoundException
    //   230	234	341	java/io/FileNotFoundException
    //   238	243	341	java/io/FileNotFoundException
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 2130840398;
    case 2: 
      return 2130840399;
    case 0: 
      return 2130840362;
    case 1: 
      return 2130840363;
    case 3: 
      return 2130840349;
    case 4: 
      return 2130840425;
    case 6: 
      return 2130840424;
    case 5: 
      return 2130840343;
    case 7: 
      return 2130840382;
    case 8: 
      return 2130840350;
    case 9: 
      return 2130840380;
    case 10: 
      return 2130840392;
    }
    return 2130840384;
  }
  
  public static int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileType", "8");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfPreviewMode", "3");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileType", "13");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileType", "14");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileType", "15");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOfflineFileListMerge", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicFunctionalSwitch", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicSupportVersion", "95");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQMusicFormatSupport", ".mp3|.m4a|.ogg|");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigOpenForQQBrowseFunctionalSwitch", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewPreloadPreviewFirstPreloadSwitch", "true");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewPreloadPreviewMorePreloadSwitch", "true");
    }
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  /* Error */
  public static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 2468	com/tencent/mobileqq/filemanager/util/FileManagerUtil:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 1035	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 3164	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 619
    //   35: iconst_2
    //   36: new 49	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 2470
    //   46: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 113	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 3166
    //   59: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto -57 -> 11
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   71	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   15	68	71	finally
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    boolean bool;
    do
    {
      return;
      bool = FileUtil.a(paramFileManagerEntity.getFilePath());
      if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == -1)))
      {
        paramFileManagerEntity.cloudType = 3;
        paramFileManagerEntity.status = 1;
        return;
      }
    } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && (paramFileManagerEntity.nOpType == 0)));
    if (paramFileManagerEntity.nFileType == 5) {
      FileCategoryUtil.a(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.status == 1)
    {
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
      if ((paramFileManagerEntity.WeiYunFileId != null) && (paramFileManagerEntity.WeiYunFileId.length() > 0))
      {
        paramFileManagerEntity.setCloudType(2);
        paramFileManagerEntity.status = -1;
        return;
      }
      paramFileManagerEntity.status = 16;
      return;
    }
    paramFileManagerEntity.status = 16;
  }
  
  static boolean c(long paramLong)
  {
    boolean bool2 = false;
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localCalendar.set(i, j, k + 1, 0, 0, 0);
    long l = localCalendar.getTimeInMillis();
    localCalendar.set(i, j, k, 0, 0, 0);
    boolean bool1 = bool2;
    if (paramLong >= localCalendar.getTimeInMillis())
    {
      bool1 = bool2;
      if (paramLong < l) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {}
    while (paramFileManagerEntity.isZipInnerFile) {
      return false;
    }
    switch (a(paramFileManagerEntity))
    {
    case 3: 
    case 5: 
    default: 
      return false;
    case 1: 
    case 2: 
    case 4: 
      return true;
    }
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString, true);
  }
  
  public static byte[] c(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static int d(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = FileUtil.b(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static String d(String paramString)
  {
    int i = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = a(paramString);
    if (FontSettingManager.a() >= 20.0F) {
      if (bool) {
        i = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - i) {
        break;
      }
      int j = paramString.length();
      str = paramString.substring(0, (16 - i) / 2);
      paramString = paramString.substring(j - (16 - i) / 2);
      return str + "..." + paramString;
      if (FontSettingManager.a() >= 18.0F)
      {
        if (bool) {
          i = 5;
        } else {
          i = 2;
        }
      }
      else if (FontSettingManager.a() >= 17.0F)
      {
        if (!bool) {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
      return false;
    }
    return true;
  }
  
  public static boolean d(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_guide_flag_" + paramString, true);
  }
  
  public static int e(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static String e(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    label177:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int i = 0;
          int j = 0;
          if (j < paramString.length())
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label177;
            }
            i %= "AnDrDQ_Fm_String".length();
            int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(i);
            int k = m;
            if (m > 65535) {
              k = m % 65535;
            }
            localByteArrayBuffer.append(k);
            j += 1;
            i += 1;
            continue;
          }
        }
        paramString = com.qq.taf.jce.HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static int f(String paramString)
  {
    Object localObject2 = BaseApplication.getContext().getPackageManager();
    Object localObject1 = ((PackageManager)localObject2).getInstalledPackages(0);
    localObject2 = ((PackageManager)localObject2).getInstalledApplications(0);
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject3 = (PackageInfo)((List)localObject1).get(i);
      localObject3 = ((ApplicationInfo)((List)localObject2).get(i)).publicSourceDir;
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PackageInfo)((Iterator)localObject1).next();
      if (((PackageInfo)localObject2).packageName.equalsIgnoreCase(paramString)) {
        return ((PackageInfo)localObject2).versionCode;
      }
    }
    return -1;
  }
  
  public static String f(String paramString)
  {
    int i = 0;
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return (String)localObject;
    }
    for (;;)
    {
      try
      {
        paramString.toUpperCase();
        byte[] arrayOfByte = com.qq.taf.jce.HexUtil.hexStr2Bytes(paramString);
        String str = "";
        localObject = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        localObject = str;
        if (!paramString.equals("AnDrDQ_Fm_String"))
        {
          int j = 0;
          paramString = str;
          localObject = paramString;
          if (j < arrayOfByte.length)
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label175;
            }
            i %= "AnDrDQ_Fm_String".length();
            m = "AnDrDQ_Fm_String".codePointAt(i);
            if (arrayOfByte[j] < 0)
            {
              k = arrayOfByte[j] + 256;
              break label178;
              paramString = paramString + (char)k;
              i += 1;
              j += 1;
              continue;
            }
            k = arrayOfByte[j];
            break label178;
          }
        }
        break;
      }
      finally {}
      label175:
      continue;
      label178:
      int m = k + 65535 - m;
      int k = m;
      if (m > 65535) {
        k = m % 65535;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileManagerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */