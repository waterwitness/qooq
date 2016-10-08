package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.HexUtil;
import igy;
import igz;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoServerInfoManager
  extends BaseManger
{
  public static final int a = 10000;
  public static final String a = "Q.qqstory.publish:VideoServerInfoManager";
  public long a;
  public VideoServerInfoManager.ServerInfo a;
  protected INetEventHandler a;
  public final Object a;
  public AtomicBoolean a;
  
  public VideoServerInfoManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo = new VideoServerInfoManager.ServerInfo();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new igz(this, null);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.b()) {
      d();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    SLog.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo);
    RefreshVideoFileKeyRequest localRefreshVideoFileKeyRequest = new RefreshVideoFileKeyRequest();
    CmdTaskManger.a().a(localRefreshVideoFileKeyRequest, new igy(this));
  }
  
  public String a()
  {
    byte[] arrayOfByte = a();
    if (arrayOfByte == null) {
      return null;
    }
    return HexUtil.a(arrayOfByte);
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public byte[] a()
  {
    if (b()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.a;
    }
    d();
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(10000L);
        SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo;
        if (((VideoServerInfoManager.ServerInfo)???).a()) {
          return ((VideoServerInfoManager.ServerInfo)???).a;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          SLog.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    return null;
  }
  
  public String b()
  {
    if (b()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo.b;
    }
    d();
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(10000L);
        SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager$ServerInfo;
        if (((VideoServerInfoManager.ServerInfo)???).a()) {
          return ((VideoServerInfoManager.ServerInfo)???).b;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          SLog.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
        }
      }
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void c()
  {
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\VideoServerInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */