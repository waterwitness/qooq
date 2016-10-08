package com.tencent.biz.qqstory.channel;

import com.tencent.biz.ProtoServlet;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import iiu;
import iiv;
import iix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class QQStoryCmdHandler
{
  public static final String a = "Q.qqstory.net:QQStoryCmdHandler";
  public static final String b = "sendtimekey";
  public static final String c = "sequence";
  public ConcurrentHashMap a;
  protected AtomicInteger a;
  
  public QQStoryCmdHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i >= 0) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte = new byte[i];
    PkgTools.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    paramFromServiceMsg.putWupBuffer(arrayOfByte);
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getWupBuffer() != null)
    {
      long l = paramToServiceMsg.getWupBuffer().length;
      byte[] arrayOfByte = new byte[(int)l + 4];
      PkgTools.a(arrayOfByte, 0, 4L + l);
      PkgTools.a(arrayOfByte, 4, paramToServiceMsg.getWupBuffer(), (int)l);
      paramToServiceMsg.putWupBuffer(arrayOfByte);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean) {}
  
  public void a(NetworkRequest paramNetworkRequest)
  {
    try
    {
      if (!NetworkUtils.a(QQStoryContext.a().a()))
      {
        Bosses.get().scheduleJobDelayed(new iiu(this, paramNetworkRequest), 100);
        return;
      }
      SLog.a("Q.qqstory.net:QQStoryCmdHandler", "send cmd:%s with request:%s", paramNetworkRequest.a(), paramNetworkRequest);
      long l = System.currentTimeMillis();
      a(paramNetworkRequest.a(), paramNetworkRequest.a(), new iiv(this, l, paramNetworkRequest));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SLog.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramNetworkRequest.a() + " error:" + localIllegalArgumentException.getMessage());
      paramNetworkRequest.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    new iix(this, paramToServiceMsg, paramFromServiceMsg).a(new Void[0]);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = QQStoryContext.a().a();
    NewIntent localNewIntent = new NewIntent(localAppInterface.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.setObserver(paramBusinessObserver);
    localAppInterface.startServlet(localNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\channel\QQStoryCmdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */