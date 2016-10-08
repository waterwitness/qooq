package com.tencent.biz.qqstory.model.pendant;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.network.request.GetConfigFileRequest;
import com.tencent.biz.qqstory.network.response.GetConfigFileResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.ttpic.model.VideoMaterial;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import ijv;
import ijw;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class PendantManager
  implements CmdTaskManger.CommandCallback, IManager
{
  public static final String a = "PendantManager";
  public static final String b;
  public static final String c = "pendant.json";
  public final Downloader a;
  public NewStoryPendantInfo a;
  public NewStoryPendantItem a;
  public final Object a;
  public final Queue a;
  public AtomicBoolean a;
  public final AtomicBoolean b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = QQStoryConstant.o + "pendant";
  }
  
  public PendantManager()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static NewStoryPendantInfo a(File paramFile)
  {
    try
    {
      if ((!paramFile.exists()) || (!paramFile.isFile()) || (!paramFile.canRead()))
      {
        SLog.d("PendantManager", "generateNewStoryPendantInfoByJsonFile failed, file is illegal %s", new Object[] { paramFile });
        return null;
      }
      paramFile = ((NewStoryPendantInfo.Proxy)JsonORM.a(new JSONObject(new String(FileUtils.a(paramFile), "UTF-8")), NewStoryPendantInfo.Proxy.class)).a();
      return paramFile;
    }
    catch (Exception paramFile)
    {
      SLog.b("PendantManager", "generateNewStoryPendantInfoByJsonFile failed", paramFile);
    }
    return null;
  }
  
  public static NewStoryPendantItem a(NewStoryPendantInfo paramNewStoryPendantInfo, String paramString)
  {
    if ((paramNewStoryPendantInfo != null) && (paramNewStoryPendantInfo.a != null))
    {
      paramNewStoryPendantInfo = paramNewStoryPendantInfo.a;
      int k = paramNewStoryPendantInfo.length;
      int i = 0;
      while (i < k)
      {
        NewStoryPendantItem[] arrayOfNewStoryPendantItem = paramNewStoryPendantInfo[i];
        if ((arrayOfNewStoryPendantItem != null) && (arrayOfNewStoryPendantItem.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem != null))
        {
          arrayOfNewStoryPendantItem = arrayOfNewStoryPendantItem.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem;
          int m = arrayOfNewStoryPendantItem.length;
          int j = 0;
          while (j < m)
          {
            NewStoryPendantItem localNewStoryPendantItem = arrayOfNewStoryPendantItem[j];
            if ((localNewStoryPendantItem != null) && (TextUtils.equals(localNewStoryPendantItem.jdField_a_of_type_JavaLangString, paramString)))
            {
              SLog.a("PendantManager", "getPendantItemById %s find %s", paramString, localNewStoryPendantItem);
              return localNewStoryPendantItem;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    SLog.d("PendantManager", "getPendantItemById %s find none", new Object[] { paramString });
    return null;
  }
  
  public static String a(NewStoryPendantItem paramNewStoryPendantItem)
  {
    return "pendant_" + paramNewStoryPendantItem.jdField_a_of_type_JavaLangString;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile()) {
      SLog.d("PendantManager", "delete file : %s", new Object[] { Boolean.valueOf(paramString.delete()) });
    }
    if (!paramString.exists()) {
      SLog.d("PendantManager", "create folder : %s", new Object[] { Boolean.valueOf(paramString.mkdirs()) });
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    SLog.a("PendantManager", "downloadConfigFile : %s", paramString1);
    try
    {
      FileUtils.d(paramString2);
      long l = SystemClock.uptimeMillis();
      new ijw(this, this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader, l).executeOnExecutor(Bosses.get().getExecutor(16), new FileDownloadTask.Input[] { new FileDownloadTask.Input(paramString1, paramString2, paramString3) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      File localFile = new File(paramFile, "params.json");
      if ((localFile.exists()) && (localFile.isFile())) {}
      do
      {
        return true;
        localFile = new File(paramFile, "params.dat");
      } while (((localFile.exists()) && (localFile.isFile())) || (TemplateParser.a(paramFile.getPath(), "params").getMinAppVersion() != 0));
    }
    return false;
  }
  
  public static String b(NewStoryPendantItem paramNewStoryPendantItem)
  {
    return jdField_b_of_type_JavaLangString + File.separator + a(paramNewStoryPendantItem);
  }
  
  public static String c(NewStoryPendantItem paramNewStoryPendantItem)
  {
    return jdField_b_of_type_JavaLangString + File.separator + a(paramNewStoryPendantItem) + ".zip";
  }
  
  private void e()
  {
    SLog.b("PendantManager", "startDownload");
    c();
    long l = SystemClock.uptimeMillis();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem = ((NewStoryPendantItem)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null)
        {
          SLog.a("PendantManager", "downloader startDownload : %s", this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem);
          Bosses.get().postJob(new ijv(this, this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem, l));
        }
        return;
      }
      SLog.a("PendantManager", "can not start download because find one is still downloading : %s", this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem);
    }
  }
  
  private void f()
  {
    SLog.b("PendantManager", "fireGetConfigFile");
    c();
    if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      CmdTaskManger.a().a(new GetConfigFileRequest(1), this);
    }
  }
  
  private void g()
  {
    NewStoryPendantInfo localNewStoryPendantInfo = a(new File(jdField_b_of_type_JavaLangString, "pendant.json"));
    SLog.b("PendantManager", "loadLocalJsonFile %s", localNewStoryPendantInfo);
    if ((localNewStoryPendantInfo != null) && (localNewStoryPendantInfo.a != null))
    {
      NewStoryPendantType[] arrayOfNewStoryPendantType = localNewStoryPendantInfo.a;
      int n = arrayOfNewStoryPendantType.length;
      int j = 0;
      int m;
      for (int i = 0;; i = m)
      {
        k = i;
        if (j >= n) {
          break;
        }
        Object localObject = arrayOfNewStoryPendantType[j];
        m = i;
        if (localObject != null)
        {
          m = i;
          if (((NewStoryPendantType)localObject).jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem != null)
          {
            localObject = ((NewStoryPendantType)localObject).jdField_a_of_type_ArrayOfComTencentBizQqstoryModelPendantNewStoryPendantItem;
            int i1 = localObject.length;
            k = 0;
            m = i;
            if (k < i1)
            {
              NewStoryPendantItem localNewStoryPendantItem = localObject[k];
              m = i;
              File localFile;
              if (localNewStoryPendantItem != null)
              {
                localFile = new File(b(localNewStoryPendantItem));
                if (!a(localFile)) {
                  break label185;
                }
                localNewStoryPendantItem.a(localFile.getPath());
                SLog.b("PendantManager", "load local pendant : %s", localNewStoryPendantItem);
                m = i + 1;
              }
              for (;;)
              {
                k += 1;
                i = m;
                break;
                try
                {
                  label185:
                  SLog.b("PendantManager", "remove illegal item folder");
                  FileUtils.d(localFile.getPath());
                  m = i;
                }
                catch (Exception localException)
                {
                  SLog.c("PendantManager", "remove illegal item folder failed", localException);
                  m = i;
                }
              }
            }
          }
        }
        j += 1;
      }
    }
    int k = 0;
    SLog.b("PendantManager", "load %d local pendants", Integer.valueOf(k));
    if (localNewStoryPendantInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantInfo = localNewStoryPendantInfo;
      Dispatchers.get().dispatch(new NewStoryPendantUpdateEvent());
    }
  }
  
  public NewStoryPendantType a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantInfo;
    if ((localObject1 != null) && (((NewStoryPendantInfo)localObject1).a != null))
    {
      localObject1 = ((NewStoryPendantInfo)localObject1).a;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 != null) && (TextUtils.equals(((NewStoryPendantType)localObject2).jdField_a_of_type_JavaLangString, paramString)))
        {
          SLog.a("PendantManager", "getPendantTypeById %s find %s", paramString, localObject2);
          return (NewStoryPendantType)localObject2;
        }
        i += 1;
      }
    }
    SLog.d("PendantManager", "getPendantTypeById %s find none", new Object[] { paramString });
    return null;
  }
  
  public List a(boolean paramBoolean)
  {
    c();
    NewStoryPendantInfo localNewStoryPendantInfo = this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantInfo;
    if ((localNewStoryPendantInfo == null) || (localNewStoryPendantInfo.a == null) || (localNewStoryPendantInfo.a.length <= 0) || (paramBoolean)) {
      f();
    }
    if ((localNewStoryPendantInfo != null) && (localNewStoryPendantInfo.a != null)) {
      return Collections.unmodifiableList(Arrays.asList(localNewStoryPendantInfo.a));
    }
    return Collections.EMPTY_LIST;
  }
  
  public void a()
  {
    SLog.b("PendantManager", "onInit");
    c();
  }
  
  public void a(GetConfigFileRequest paramGetConfigFileRequest, GetConfigFileResponse paramGetConfigFileResponse, ErrorMessage paramErrorMessage)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    SLog.a("PendantManager", "onCmdRespond : %s", paramGetConfigFileResponse);
    SLog.a("PendantManager", "onCmdRespond : %s", paramErrorMessage.toString());
    StoryReportor.b("edit_video", "get_pendant_config", 0, paramErrorMessage.errorCode, new String[0]);
    if ((paramGetConfigFileResponse != null) && (paramErrorMessage.isSuccess()))
    {
      paramGetConfigFileRequest = new File(jdField_b_of_type_JavaLangString, "pendant.json");
      if (paramGetConfigFileRequest.isDirectory()) {}
      try
      {
        SLog.b("PendantManager", "remove directory");
        FileUtils.d(paramGetConfigFileRequest.getPath());
        if (paramGetConfigFileRequest.exists()) {
          if (FileDownloadTask.a(paramGetConfigFileRequest.getPath(), paramGetConfigFileResponse.c)) {
            break label174;
          }
        }
      }
      catch (Exception paramErrorMessage)
      {
        try
        {
          SLog.b("PendantManager", "remove file because of md5 mismatch");
          FileUtils.d(paramGetConfigFileRequest.getPath());
          a(paramGetConfigFileResponse.jdField_b_of_type_JavaLangString, paramGetConfigFileRequest.getPath(), paramGetConfigFileResponse.c);
          return;
          paramErrorMessage = paramErrorMessage;
          SLog.c("PendantManager", "remove directory failed", paramErrorMessage);
        }
        catch (Exception paramErrorMessage)
        {
          for (;;)
          {
            SLog.c("PendantManager", "remove directory failed", paramErrorMessage);
          }
        }
        label174:
        SLog.b("PendantManager", "we already has local file, don't need download again");
        return;
      }
    }
    Dispatchers.get().dispatch(new NewStoryPendantUpdateEvent(paramErrorMessage));
  }
  
  public boolean a(NewStoryPendantItem paramNewStoryPendantItem, boolean paramBoolean)
  {
    SLog.a("PendantManager", "downloadPendantPack : %s", paramNewStoryPendantItem);
    c();
    if (paramNewStoryPendantItem == null) {
      throw new IllegalArgumentException("item should not be null");
    }
    paramNewStoryPendantItem = a(this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantInfo, paramNewStoryPendantItem.jdField_a_of_type_JavaLangString);
    if (paramNewStoryPendantItem == null)
    {
      SLog.d("PendantManager", "illegal item ! can not start download");
      return false;
    }
    ??? = new File(jdField_b_of_type_JavaLangString, a(paramNewStoryPendantItem));
    if ((((File)???).exists()) && (((File)???).isDirectory()) && (!paramBoolean))
    {
      SLog.d("PendantManager", "already has local folder, notify download success directly");
      paramNewStoryPendantItem.a(1.0F);
      paramNewStoryPendantItem.a(false, 0);
      paramNewStoryPendantItem.a(((File)???).getPath());
      Dispatchers.get().dispatch(new NewStoryPendantDownloadEvent(paramNewStoryPendantItem, 0.0F));
      return true;
    }
    if (!TextUtils.isEmpty(paramNewStoryPendantItem.a()))
    {
      SLog.d("PendantManager", "local folder is missing or force download : %s", new Object[] { Boolean.valueOf(paramBoolean) });
      paramNewStoryPendantItem.a(null);
    }
    if (TextUtils.isEmpty(paramNewStoryPendantItem.d))
    {
      SLog.d("PendantManager", "can not start download because of empty download-url is found");
      return false;
    }
    paramNewStoryPendantItem.a(0.0F);
    paramNewStoryPendantItem.a(true, 0);
    Dispatchers.get().dispatch(new NewStoryPendantDownloadEvent(paramNewStoryPendantItem, 0.0F));
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(paramNewStoryPendantItem)) {
        this.jdField_a_of_type_JavaUtilQueue.offer(paramNewStoryPendantItem);
      }
      e();
      return true;
    }
  }
  
  public void b()
  {
    SLog.b("PendantManager", "onDestroy");
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      a(jdField_b_of_type_JavaLangString);
      g();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantInfo = null;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilQueue.clear();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\PendantManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */