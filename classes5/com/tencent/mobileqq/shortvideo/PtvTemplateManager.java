package com.tencent.mobileqq.shortvideo;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import upt;
import upu;
import upv;
import upw;
import upx;
import upz;
import uqb;
import uqc;
import uqd;

public class PtvTemplateManager
{
  public static final int a = 10;
  static PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  public static File a;
  public static final Long a;
  static Object jdField_a_of_type_JavaLangObject;
  public static final String a;
  public static final int b = 21600000;
  public static final String b = "teach_video_download_time";
  public static final String c = "download_teach_video_last_time";
  static final String d = "ptv_template_new.cfg";
  static final String e = "ptv_template_extra_doublevideo.cfg";
  public static final String f = "ptv_template";
  public static String g;
  public static final String h = "ptv_guide_video.mp4";
  public static final String i = "ptv_teach_video.mp4";
  public ArrayList a;
  public boolean a;
  public Object b;
  public ArrayList b;
  public boolean b;
  String j;
  String k;
  public String l;
  public String m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PtvTemplateManager.class.getSimpleName();
    jdField_a_of_type_JavaLangLong = Long.valueOf(60000L);
    g = "ptv_template_usable";
    jdField_a_of_type_JavaLangObject = new Object();
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(AppConstants.bj);; localFile = BaseApplicationImpl.a().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "ptv_template");
      g = jdField_a_of_type_JavaIoFile.getPath() + File.separator + g + File.separator;
      return;
    }
  }
  
  private PtvTemplateManager(AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    d(paramAppInterface);
  }
  
  public static PtvTemplateManager a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null) {
      return jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null)
      {
        paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
        return paramAppInterface;
      }
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = new PtvTemplateManager(paramAppInterface);
    paramAppInterface = jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
    return paramAppInterface;
  }
  
  public static List a(PtvTemplateManager paramPtvTemplateManager, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("content"))
        {
          paramString = localJSONObject.getJSONArray("content");
          str = paramString;
          if (paramPtvTemplateManager == null) {}
        }
      }
      catch (JSONException paramPtvTemplateManager)
      {
        for (;;)
        {
          try
          {
            JSONObject localJSONObject;
            if (localJSONObject.has("guide_video_url")) {
              paramPtvTemplateManager.j = localJSONObject.getString("guide_video_url");
            }
            if (localJSONObject.has("guide_video_md5")) {
              paramPtvTemplateManager.k = localJSONObject.getString("guide_video_md5");
            }
            if (localJSONObject.has("teach_video_url")) {
              paramPtvTemplateManager.l = localJSONObject.getString("teach_video_url");
            }
            str = paramString;
            if (localJSONObject.has("teach_video_md5"))
            {
              paramPtvTemplateManager.m = localJSONObject.getString("teach_video_md5");
              str = paramString;
            }
            if (str == null) {
              break;
            }
            paramPtvTemplateManager = PtvTemplateManager.PtvTemplateInfo.convertFrom(str);
            if ((paramPtvTemplateManager == null) || (paramPtvTemplateManager.isEmpty())) {
              break;
            }
            return paramPtvTemplateManager;
          }
          catch (JSONException paramPtvTemplateManager)
          {
            String str;
            continue;
          }
          paramPtvTemplateManager = paramPtvTemplateManager;
          paramString = null;
          str = paramString;
          if (QLog.isColorLevel())
          {
            paramPtvTemplateManager.printStackTrace();
            str = paramString;
            continue;
            paramString = null;
          }
        }
      }
    }
  }
  
  static void a(String paramString1, String paramString2)
  {
    ThreadManager.a().post(new upu(paramString2, paramString1));
  }
  
  public static boolean a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg").exists();
  }
  
  public static void b()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager != null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = null;
      }
      return;
    }
  }
  
  public static boolean b()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_template_extra_doublevideo.cfg").exists();
  }
  
  public String a()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_guide_video.mp4").getPath();
  }
  
  public String a(File paramFile)
  {
    paramFile = FileUtils.a(paramFile);
    if ((paramFile == null) || (paramFile.length <= 0)) {
      return null;
    }
    if (Build.VERSION.SDK_INT <= 8) {
      return new String(paramFile);
    }
    try
    {
      paramFile = new String(paramFile, "UTF-8");
      return paramFile;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      if (QLog.isDevelopLevel()) {
        paramFile.printStackTrace();
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_JavaUtilArrayList;
    }
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)localIterator.next();
        if (localPtvTemplateInfo != null)
        {
          if ((localPtvTemplateInfo.usable) && (!new File(jdField_a_of_type_JavaIoFile, localPtvTemplateInfo.name).exists())) {
            localPtvTemplateInfo.usable = false;
          }
          if ((!localPtvTemplateInfo.predownload) || (localPtvTemplateInfo.usable)) {
            localArrayList1.add(localPtvTemplateInfo);
          }
        }
      }
    }
    return localArrayList2;
  }
  
  public void a()
  {
    ThreadManager.a(new upt(this), null, false);
  }
  
  void a(AppInterface paramAppInterface)
  {
    ThreadManager.b().postDelayed(new upw(this, paramAppInterface), jdField_a_of_type_JavaLangLong.longValue());
  }
  
  public void a(AppInterface paramAppInterface, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener)
  {
    if (paramPtvTemplateInfo == null) {}
    for (;;)
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new uqd(this, paramPtvTemplateInfo, paramIPtvTemplateDownloadListener);
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo.resurl;
      localHttpNetReq.c = 0;
      localHttpNetReq.b = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name).getPath();
      localHttpNetReq.k = NetworkUtil.a(NetworkCenter.a().a());
      try
      {
        paramAppInterface.a(0).a(localHttpNetReq);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startDownloadTemplate url: " + paramPtvTemplateInfo.resurl);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, File paramFile)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      ??? = jdField_a_of_type_JavaLangString;
      if (paramAppInterface != null)
      {
        bool = true;
        QLog.i((String)???, 2, String.format("rebuildTemplateInfos, app[%s], isUpdateedByServer[%s], cur_runnable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(hashCode()) }));
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
    }
    label74:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          paramFile = a(paramFile);
        } while (TextUtils.isEmpty(paramFile));
        paramFile = a(this, paramFile);
      } while ((paramFile == null) || (paramFile.isEmpty()));
      ??? = paramFile.iterator();
      while (((Iterator)???).hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
        if (localPtvTemplateInfo != null) {
          localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
        }
      }
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramFile);
      this.jdField_b_of_type_Boolean = true;
    } while ((paramAppInterface == null) || (!(paramAppInterface instanceof QQAppInterface)) || (!PtvFilterSoLoad.b()));
    c(paramAppInterface);
    b(paramAppInterface);
  }
  
  public void a(Runnable paramRunnable)
  {
    Object localObject = new File(jdField_a_of_type_JavaIoFile, "ptv_template_extra_doublevideo.cfg");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "双人挂件加载 config file not exist.");
      }
      return;
    }
    localObject = new uqb(this, (File)localObject, paramRunnable);
    String str;
    if (QLog.isDevelopLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (paramRunnable == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, String.format("双人挂件加载, onInitFinishSink[%s], runnable[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localObject.hashCode()) }));
      ThreadManager.a((Runnable)localObject, null, false);
      return;
    }
  }
  
  public void a(String paramString, AppInterface paramAppInterface)
  {
    List localList = a(null, paramString);
    if ((localList == null) || (localList.isEmpty())) {
      return;
    }
    a(paramString, "ptv_template_extra_doublevideo.cfg");
    AudioHelper.a(paramAppInterface.a());
  }
  
  public void a(List paramList)
  {
    if (jdField_a_of_type_JavaIoFile == null) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = jdField_a_of_type_JavaIoFile.listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length == 0));
    int i2 = arrayOfFile.length;
    int n = 0;
    label30:
    File localFile;
    if (n < i2)
    {
      localFile = arrayOfFile[n];
      if ((localFile != null) && (localFile.isFile())) {
        break label62;
      }
    }
    label62:
    label200:
    for (;;)
    {
      n += 1;
      break label30;
      break;
      Object localObject = localFile.getName();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).contains(".")))
      {
        localObject = paramList.iterator();
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
        } while ((localPtvTemplateInfo == null) || (TextUtils.isEmpty(localPtvTemplateInfo.name)) || (!localFile.getName().equalsIgnoreCase(localPtvTemplateInfo.name)));
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label200;
          }
          localFile.deleteOnExit();
          new File(g + localFile.getName()).deleteOnExit();
          break;
        }
      }
    }
  }
  
  public boolean a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if ((paramPtvTemplateInfo == null) || (TextUtils.isEmpty(paramPtvTemplateInfo.name))) {}
    for (;;)
    {
      return false;
      Object localObject = new File(jdField_a_of_type_JavaIoFile, paramPtvTemplateInfo.name);
      if (((File)localObject).exists()) {
        try
        {
          localObject = FileUtils.b(((File)localObject).getPath());
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(paramPtvTemplateInfo.md5))) {
            return true;
          }
        }
        catch (UnsatisfiedLinkError paramPtvTemplateInfo)
        {
          if (QLog.isColorLevel()) {
            paramPtvTemplateInfo.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public String b()
  {
    return new File(jdField_a_of_type_JavaIoFile, "ptv_teach_video.mp4").getPath();
  }
  
  public void b(AppInterface paramAppInterface)
  {
    ThreadManager.a().post(new upx(this, paramAppInterface));
  }
  
  public void b(String paramString, AppInterface paramAppInterface)
  {
    List localList = a(null, paramString);
    if ((localList == null) || (localList.isEmpty())) {}
    do
    {
      return;
      a(paramString, "ptv_template_new.cfg");
      b(localList);
    } while (this.jdField_b_of_type_Boolean);
    ThreadManager.a().post(new upv(this, localList));
    a(paramAppInterface);
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ??? = paramList.iterator();
    while (((Iterator)???).hasNext())
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)???).next();
      if (localPtvTemplateInfo != null) {
        localPtvTemplateInfo.usable = a(localPtvTemplateInfo);
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public void c(AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    int n = 0;
    label20:
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (n < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(n);
      if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.predownload) && (!TextUtils.isEmpty(localPtvTemplateInfo.resurl))) {
        break label71;
      }
    }
    for (;;)
    {
      n += 1;
      break label20;
      break;
      label71:
      ThreadManager.a().post(new upz(this, localPtvTemplateInfo, paramAppInterface));
    }
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (new File(jdField_a_of_type_JavaIoFile, "ptv_guide_video.mp4").exists()) {
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.i(ShortVideoGuideUtil.jdField_a_of_type_JavaLangString, 2, "guide video file not exist.");
    return false;
  }
  
  public void d(AppInterface paramAppInterface)
  {
    Object localObject = new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initLocalTemplateConfigInfo config file not exist.");
      }
      return;
    }
    localObject = new uqc(this, paramAppInterface, (File)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, String.format("initLocalTemplateConfigInfo async, runnable[%s]", new Object[] { Integer.valueOf(localObject.hashCode()) }));
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      ThreadManager.a().postDelayed((Runnable)localObject, jdField_a_of_type_JavaLangLong.longValue());
      return;
    }
    ThreadManager.a((Runnable)localObject, null, false);
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (new File(jdField_a_of_type_JavaIoFile, "ptv_teach_video.mp4").exists()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        bool1 = true;
      }
    }
    if (!bool1)
    {
      if (new File(jdField_a_of_type_JavaIoFile, "ptv_template_new.cfg").exists()) {
        return true;
      }
      QLog.i(ShortVideoGuideUtil.jdField_a_of_type_JavaLangString, 2, "template config not exist.");
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\PtvTemplateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */