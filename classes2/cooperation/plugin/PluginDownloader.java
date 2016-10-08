package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import ydu;
import ydv;

public class PluginDownloader
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener
{
  private static final String jdField_a_of_type_JavaLangString = "plugin_download";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap b;
  
  public PluginDownloader(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.b = new HashMap();
  }
  
  public static final File a(Context paramContext)
  {
    return paramContext.getDir("plugin_download", 0);
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2)
  {
    String str = (String)paramNetReq.a();
    if (paramInt2 > 0)
    {
      paramNetReq = (ydv)this.b.get(str);
      if (paramNetReq == null) {
        break label95;
      }
    }
    label95:
    for (paramNetReq = ydv.a(paramNetReq);; paramNetReq = null)
    {
      if (paramNetReq != null) {
        paramNetReq.a(paramInt1, paramInt2, str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "doOnProgress: " + paramInt1 / paramInt2 + ", " + str);
      }
      return;
    }
  }
  
  private void a(File paramFile, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + paramString);
    }
    if ((paramFile != null) && (paramFile.exists()))
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramFile[i];
          String str = ((File)localObject).getPath();
          if ((str == null) || (!str.startsWith(paramString))) {}
          for (;;)
          {
            i += 1;
            break;
            if (!str.endsWith(".cfg")) {
              if (str.equals(paramString))
              {
                if (paramBoolean)
                {
                  ((File)localObject).delete();
                  if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                  }
                }
              }
              else
              {
                ((File)localObject).delete();
                if (QLog.isColorLevel()) {
                  QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, NetResp paramNetResp)
  {
    HashMap localHashMap = new HashMap();
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      localHashMap.put("mResult", String.valueOf(paramNetResp.e));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.f));
      localHashMap.put("mErrDesc", paramNetResp.jdField_a_of_type_JavaLangString);
      Object localObject = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if ((paramNetResp.e != 0) && (localObject != null) && ((localObject instanceof HttpNetReq))) {
        localHashMap.put("Url", ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString);
      }
      localHashMap.put("mRespProperties[KeyReason]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason"));
      localHashMap.put("mRespProperties[KeyRawRespHttpHeader]", paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      localObject = StatisticCollector.a(BaseApplication.getContext());
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramNetResp.e == 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject).a(str, "NetPluginsDownload", bool, paramString.longValue(), 0L, localHashMap, null);
        return;
      }
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    String str = (String)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = (ydv)this.b.remove(str);
      if (localObject != null)
      {
        localObject = ydv.a((ydv)localObject);
        a(str, paramNetResp);
        a(a(this.jdField_a_of_type_AndroidContentContext), str, false);
        if (QLog.isColorLevel())
        {
          QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + paramNetResp.e + "," + str + ", " + paramNetResp.jdField_a_of_type_Long);
          if ((!bool) && (QLog.isColorLevel())) {
            QLog.e("plugin_tag", 2, "doOnResp. err: " + paramNetResp.f + ", " + paramNetResp.jdField_a_of_type_JavaLangString);
          }
        }
        if (localObject != null) {
          ((PluginDownloader.OnPluginDownLoadListener)localObject).a(bool, str);
        }
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doCancelInstall: " + paramString);
    }
    Object localObject = (ydv)this.b.remove(paramString);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(ydv.a((ydv)localObject));
      localObject = ydv.a((ydv)localObject);
      if (localObject != null) {
        ((PluginDownloader.OnPluginDownLoadListener)localObject).d(paramString);
      }
      c(paramString);
    }
  }
  
  private void c(String paramString)
  {
    paramString = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      paramString = Long.valueOf(0L);
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "0");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "NetPluginsCancelDownload", false, paramString.longValue(), 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65793, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65792, paramNetResp).sendToTarget();
  }
  
  public void a(PluginInfo paramPluginInfo, PluginDownloader.OnPluginDownLoadListener paramOnPluginDownLoadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doDownloadPlugin." + paramPluginInfo.mID);
    }
    if (this.b.containsKey(paramPluginInfo.mID)) {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "downloading already");
      }
    }
    HttpNetReq localHttpNetReq;
    do
    {
      INetEngine localINetEngine;
      do
      {
        return;
        localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
        if ((float)(paramPluginInfo.mLength * 1.75D) <= FileUtils.a()) {
          break;
        }
      } while (paramOnPluginDownLoadListener == null);
      paramOnPluginDownLoadListener.b(paramPluginInfo.mID);
      return;
      if (paramOnPluginDownLoadListener != null) {
        paramOnPluginDownLoadListener.c(paramPluginInfo.mID);
      }
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = paramPluginInfo.mURL;
      localHttpNetReq.c = 0;
      localHttpNetReq.jdField_a_of_type_Boolean = true;
      localHttpNetReq.h = true;
      localHttpNetReq.i = true;
      localHttpNetReq.a(paramPluginInfo.mID);
      localHttpNetReq.b = new File(a(this.jdField_a_of_type_AndroidContentContext), paramPluginInfo.mID).getPath();
      ydv localydv = new ydv(null);
      ydv.a(localydv, localHttpNetReq);
      ydv.a(localydv, paramOnPluginDownLoadListener);
      this.b.put(paramPluginInfo.mID, localydv);
      localINetEngine.a(localHttpNetReq);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramPluginInfo.mID, Long.valueOf(SystemClock.uptimeMillis()));
    } while (!QLog.isColorLevel());
    QLog.d("plugin_tag", 2, "downloadPlugin: " + localHttpNetReq.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(65794, paramString).sendToTarget();
  }
  
  public boolean a(String paramString)
  {
    paramString = a(this.jdField_a_of_type_AndroidContentContext).listFiles(new ydu(this, paramString));
    return (paramString != null) && (paramString.length > 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      continue;
      b((String)paramMessage.obj);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */