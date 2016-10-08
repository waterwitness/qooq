package com.tencent.mobileqq.qipc;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.precover.ipc.PrecoverIPCServer;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.open.downloadnew.DownloaderGetCodeServer;
import cooperation.photoplus.PhotoPlusModule;

public class QIPCServerModuleFactory
{
  public QIPCServerModuleFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static QIPCModule a(String paramString)
  {
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return DownloaderGetCodeServer.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return PhotoPlusModule.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return PrecoverIPCServer.a().a();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qipc\QIPCServerModuleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */