package com.tencent.bitapp.module;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.compression.CompressionFactory;
import com.tencent.bitapp.compression.ICompression;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.statemachine.StateMachine;
import com.tencent.bitapp.thread.ThreadManager;
import com.tencent.bitapp.utils.AES;
import com.tencent.bitapp.utils.AbstractBitAppCache;
import com.tencent.bitapp.utils.DownloaderUtils;
import com.tencent.bitapp.utils.FileUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ModuleCache
  extends AbstractBitAppCache<Module>
{
  private static final String TAG = ModuleCache.class.getSimpleName();
  
  private void decryptFile(String paramString1, String paramString2)
  {
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "DecryptFile for " + paramString1);
    }
    File localFile1 = new File(paramString1);
    if (!localFile1.exists()) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString2 = AES.getKey(paramString2);
        File localFile2 = new File(FileUtils.getDecodedFileNameFromEncoded(paramString1));
        if (!localFile2.exists())
        {
          boolean bool = AES.genDecodedFile(paramString1, paramString2);
          if (FLog.isLoggable(3))
          {
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder("decryptFile fileName : ").append(paramString1);
            if (!bool) {
              continue;
            }
            paramString2 = " success";
            FLog.i(str, paramString2);
          }
        }
        localFile1.delete();
        localFile2.renameTo(localFile1);
      }
      catch (Exception paramString2)
      {
        if (!FLog.isLoggable(3)) {
          continue;
        }
        FLog.i(TAG, "decryptFile fail for fileName : " + paramString1);
        paramString2.printStackTrace();
        continue;
      }
      if (!Const.isTestPerformance) {
        break;
      }
      FLog.i("bitapp_performance", "End decryptFile for " + paramString1);
      return;
      paramString2 = " fail";
    }
  }
  
  public static final ModuleCache getInstance()
  {
    return Holder.INSTANCE;
  }
  
  private boolean isChange(String paramString)
  {
    Context localContext = ContextUtils.INSTANCE.getApplicationContext();
    String str1 = Module.getJsFile(paramString);
    String str2 = Bundle.getFile(paramString);
    boolean bool2;
    boolean bool1;
    if ((!FileUtils.isChange(localContext, str1)) && (!FileUtils.isChange(localContext, str2)))
    {
      bool2 = false;
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!Bundle.isBase(paramString)) {
          bool1 = FileUtils.isChange(localContext, Module.getListFile(paramString));
        }
      }
      if ((bool1) || (Bundle.isBase(paramString))) {
        break label105;
      }
      bool2 = isDependenciesChangeInFile(paramString);
    }
    for (;;)
    {
      if (!Const.isCheckBundleModify) {
        bool2 = false;
      }
      return bool2;
      bool2 = true;
      break;
      label105:
      bool2 = bool1;
      if (FLog.isLoggable(3))
      {
        FLog.i(TAG, "module key: " + paramString + " is not in file");
        bool2 = bool1;
      }
    }
  }
  
  public boolean downloadDependencies(String paramString, final StateMachine paramStateMachine, boolean paramBoolean)
  {
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Begin to downloadDependencies for " + paramString);
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Begin to downloadDependencies, key: " + paramString);
    }
    Object localObject = ModuleDependency.INSTANCE.getDependenciesStruct(paramString);
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      final HashSet localHashSet = new HashSet(((Set)localObject).size());
      paramString = new ModuleListener()
      {
        public void onLoadFail(String paramAnonymousString, int paramAnonymousInt)
        {
          if (Const.isTestPerformance) {
            FLog.i("bitapp_performance", "End downloadDependencies onLoadFail for " + paramAnonymousString);
          }
          if (FLog.isLoggable(3)) {
            FLog.i(ModuleCache.TAG, "downloadDependencies onLoadFail key: " + paramAnonymousString);
          }
          if ((!TextUtils.isEmpty(paramAnonymousString)) && (localHashSet.contains(paramAnonymousString))) {
            paramStateMachine.sendMessage(paramStateMachine.obtainMessage(3));
          }
          while (!FLog.isLoggable(3)) {
            return;
          }
          FLog.i(ModuleCache.TAG, "downloadDependencies onLoadFail dont' contain this key: " + paramAnonymousString);
        }
        
        public void onLoadSuccess(String paramAnonymousString, Module paramAnonymousModule)
        {
          if (Const.isTestPerformance) {
            FLog.i("bitapp_performance", "End downloadDependencies onLoadSuccess for " + paramAnonymousString);
          }
          if (FLog.isLoggable(3)) {
            FLog.i(ModuleCache.TAG, "downloadDependencies onLoadSuccess key: " + paramAnonymousString);
          }
          if ((!TextUtils.isEmpty(paramAnonymousString)) && (localHashSet.contains(paramAnonymousString)))
          {
            localHashSet.remove(paramAnonymousString);
            if (FLog.isLoggable(3)) {
              FLog.i(ModuleCache.TAG, "downloadDependencies dependenciesMap size: " + localHashSet.size());
            }
            if (localHashSet.size() == 0) {
              paramStateMachine.sendMessage(paramStateMachine.obtainMessage(2));
            }
          }
          while (!FLog.isLoggable(3)) {
            return;
          }
          FLog.i(ModuleCache.TAG, "downloadDependencies onLoadSuccess dont' contain this key: " + paramAnonymousString);
        }
      };
      paramStateMachine = ((Set)localObject).iterator();
      if (!paramStateMachine.hasNext()) {
        paramStateMachine = ((Set)localObject).iterator();
      }
      for (;;)
      {
        if (!paramStateMachine.hasNext())
        {
          return false;
          localHashSet.add(((BundleStruct)paramStateMachine.next()).getKey());
          break;
        }
        localObject = (BundleStruct)paramStateMachine.next();
        try
        {
          ModuleFacade.getModule((BundleStruct)localObject, paramString, false);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "key: " + paramString + " no dependencies");
    }
    paramStateMachine.sendMessage(paramStateMachine.obtainMessage(2));
    return false;
  }
  
  public String getDownloadUrl(String paramString)
  {
    Object localObject4 = ContextUtils.INSTANCE.getApplicationContext();
    localObject3 = "";
    try
    {
      localObject1 = ((Context)localObject4).getPackageName();
      localObject4 = ((Context)localObject4).getResources();
      int i = ((Resources)localObject4).getIdentifier("download_module_host", "string", (String)localObject1);
      localObject1 = localObject3;
      if (i > 0) {
        localObject1 = ((Resources)localObject4).getString(i);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Get download url is: " + (String)localObject1);
    }
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = "http://mp.gtimg.cn/sites/client/lola/";
    }
    localObject1 = localObject3;
    if (((String)localObject3).charAt(((String)localObject3).length() - 1) != '/') {
      localObject1 = localObject3 + "/";
    }
    return (String)localObject1 + paramString + ".zip";
  }
  
  public boolean isDependenciesChangeInFile(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = ModuleDependency.INSTANCE.getDependencies(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      bool1 = bool2;
    }
    do
    {
      if (!paramString.hasNext()) {
        return bool1;
      }
      bool2 = isChange((String)paramString.next());
      bool1 = bool2;
    } while (!bool2);
    return bool2;
  }
  
  public boolean isDependenciesExistInFile(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    paramString = ModuleDependency.INSTANCE.getDependencies(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      bool1 = bool2;
    }
    do
    {
      if (!paramString.hasNext()) {
        return bool1;
      }
      bool2 = isExistInFile((String)paramString.next());
      bool1 = bool2;
    } while (bool2);
    return bool2;
  }
  
  public boolean isExistInCache(String paramString)
  {
    boolean bool2 = super.isExistInCache(paramString);
    boolean bool1;
    if (bool2) {
      if (isChange(paramString)) {
        bool1 = false;
      }
    }
    do
    {
      return bool1;
      return true;
      bool1 = bool2;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "module key: " + paramString + " is not in cache");
    return bool2;
  }
  
  public boolean isExistInFile(String paramString)
  {
    String str = Module.getJsFile(paramString);
    Object localObject1 = Bundle.getFile(paramString);
    boolean bool1 = FileUtils.isFileExist(str);
    Object localObject2;
    boolean bool2;
    if (FLog.isLoggable(3))
    {
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder("File[").append(str).append("] is ");
      if (bool1)
      {
        str = "exist";
        FLog.i((String)localObject2, str);
      }
    }
    else
    {
      bool2 = FileUtils.isFileExist((String)localObject1);
      if (FLog.isLoggable(3))
      {
        localObject2 = TAG;
        localObject1 = new StringBuilder("File[").append((String)localObject1).append("] is ");
        if (!bool2) {
          break label275;
        }
        str = "exist";
        label121:
        FLog.i((String)localObject2, str);
      }
      if ((!bool1) || (!bool2)) {
        break label282;
      }
      bool2 = true;
      label147:
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!Bundle.isBase(paramString))
        {
          str = Module.getListFile(paramString);
          bool1 = FileUtils.isFileExist(str);
          if (FLog.isLoggable(3))
          {
            localObject1 = TAG;
            localObject2 = new StringBuilder("File[").append(str).append("] is ");
            if (!bool1) {
              break label288;
            }
            str = "exist";
            label220:
            FLog.i((String)localObject1, str);
          }
        }
      }
      if (!bool1) {
        break label301;
      }
      if (!isChange(paramString)) {
        break label295;
      }
      bool1 = false;
      label249:
      bool2 = bool1;
      if (bool1) {
        bool2 = isDependenciesExistInFile(paramString);
      }
    }
    label275:
    label282:
    label288:
    label295:
    label301:
    do
    {
      return bool2;
      str = "not exist";
      break;
      str = "not exist";
      break label121;
      bool2 = false;
      break label147;
      str = "not exist";
      break label220;
      bool1 = true;
      break label249;
      bool2 = bool1;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "module key: " + paramString + " is not in file");
    return bool1;
  }
  
  public boolean loadFromNet(String paramString1, String paramString2)
  {
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Download for " + paramString1);
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Begin to loadFromNet, key: " + paramString1);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    RNReport.reportStageStart(paramString1, 4);
    boolean bool = DownloaderUtils.download(paramString2, Module.getZipFile(paramString1));
    if (bool) {}
    for (int i = 0;; i = 6)
    {
      RNReport.reportStageEnd(paramString1, 4, i, 0);
      return bool;
    }
  }
  
  public int loadUrl(BundleStruct paramBundleStruct, final StateMachine paramStateMachine, boolean paramBoolean)
  {
    final int i = 3;
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "loadUrl");
    }
    String str1 = paramBundleStruct.download_url;
    boolean bool3 = paramBundleStruct.decrypt;
    String str2 = paramBundleStruct.pwd;
    boolean bool2 = false;
    boolean bool1;
    if (!TextUtils.isEmpty(str1))
    {
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str2)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    str1 = paramBundleStruct.getKey();
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      RNReport.addStageFlag(str1, 22, 2, i);
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramBoolean;
      }
      i = paramBundleStruct.module_id;
      if (Const.isTestPerformance) {
        FLog.i("bitapp_performance", "Load url " + i + " | isNeedRequest: " + bool2);
      }
      if (!bool2) {
        break;
      }
      ThreadManager.INSTANCE.execute(new Runnable()
      {
        public void run()
        {
          RNReport.reportStageStart(String.valueOf(i), 3);
          ModuleDetailDownload.getInstance().downloadDetail(i, new IDownloadListener()
          {
            public void downloadFailure()
            {
              if (Const.isTestPerformance) {
                FLog.i("bitapp_performance", "Load url downloadFailure for " + this.val$moduleId);
              }
              if (FLog.isLoggable(3)) {
                FLog.i(ModuleCache.TAG, "downloadFailure");
              }
              this.val$stateMachine.sendMessage(this.val$stateMachine.obtainMessage(3));
              RNReport.reportStageEnd(String.valueOf(this.val$moduleId), 3, 6, 0);
            }
            
            public void downloadSuccessful(BundleStruct paramAnonymous2BundleStruct)
            {
              if (Const.isTestPerformance) {
                FLog.i("bitapp_performance", "Load url downloadSuccessful for " + this.val$moduleId);
              }
              if ((this.val$stateMachine instanceof ModuleStateMachine))
              {
                ((ModuleStateMachine)this.val$stateMachine).setBundleStruct(paramAnonymous2BundleStruct);
                BundleStructCache.INSTANCE.add(paramAnonymous2BundleStruct);
              }
              if (FLog.isLoggable(3)) {
                FLog.i(ModuleCache.TAG, "downloadSuccessful");
              }
              if ((paramAnonymous2BundleStruct != null) && (paramAnonymous2BundleStruct.module_state == 1)) {
                this.val$stateMachine.sendMessage(this.val$stateMachine.obtainMessage(2));
              }
              for (;;)
              {
                RNReport.reportStageEnd(String.valueOf(this.val$moduleId), 3, 0, 0);
                return;
                this.val$stateMachine.sendMessage(this.val$stateMachine.obtainMessage(3));
              }
            }
          });
        }
      });
      return 0;
      if (bool1) {
        i = 2;
      }
    }
    return 1;
  }
  
  public boolean unZip(String paramString, BundleStruct paramBundleStruct)
  {
    RNReport.reportStageStart(paramString, 5);
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Begin to unZip for " + paramString);
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "Begin to unZip, key: " + paramString);
    }
    String str = Module.getZipFile(paramString);
    if (paramBundleStruct.decrypt) {
      decryptFile(str, paramBundleStruct.pwd);
    }
    paramBundleStruct = Module.getFolder(paramString);
    boolean bool = CompressionFactory.getCompression(1).decompress(str, paramBundleStruct);
    if (Const.isTestPerformance) {
      Log.d("bitapp_performance", "End to unZip for " + paramString + " | result is " + bool);
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "End unZip, key: " + paramString + " | result is " + bool);
    }
    FileUtils.delete(str);
    if (bool) {
      ModuleDependency.INSTANCE.addDependencies(paramString);
    }
    if (bool) {}
    for (int i = 0;; i = 6)
    {
      RNReport.reportStageEnd(paramString, 5, i, 0);
      return bool;
    }
  }
  
  private static class Holder
  {
    private static final ModuleCache INSTANCE = new ModuleCache();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */