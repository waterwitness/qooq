package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import riv;
import riw;
import rix;
import riy;
import riz;
import rjb;

public class WebIPCOperator
{
  private static WebIPCOperator jdField_a_of_type_ComTencentMobileqqEmosmWebWebIPCOperator;
  static final String jdField_a_of_type_JavaLangString = "Q.emoji.web.EmoWebIPCOperator";
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Client jdField_a_of_type_ComTencentMobileqqEmosmClient;
  private EmojiIPCAlarmer.TimeoutObserver jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$TimeoutObserver;
  EmojiIPCAlarmer jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer;
  private Vector jdField_a_of_type_JavaUtilVector;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  private WebIPCOperator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer = null;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$TimeoutObserver = new riz(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient = new Client();
  }
  
  public static WebIPCOperator a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmosmWebWebIPCOperator == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmosmWebWebIPCOperator == null) {
        jdField_a_of_type_ComTencentMobileqqEmosmWebWebIPCOperator = new WebIPCOperator();
      }
      return jdField_a_of_type_ComTencentMobileqqEmosmWebWebIPCOperator;
    }
    finally {}
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onBindedToClient();
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onDisconnectWithService();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "alarm init");
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer = new EmojiIPCAlarmer(this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer$TimeoutObserver);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a();
    }
  }
  
  private void f(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchPushMsg suc");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onPushMsg(paramBundle);
    }
  }
  
  public Client a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmClient;
  }
  
  public rjb a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext())
      {
        rjb localrjb = (rjb)localIterator.next();
        if (localrjb.jdField_a_of_type_Int == paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "remove req queue seq:" + paramInt);
          }
          this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a(localrjb.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_JavaUtilVector.remove(localrjb);
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "after remove req queue size:" + this.jdField_a_of_type_JavaUtilVector.size());
          }
          return localrjb;
        }
      }
      return null;
    }
  }
  
  public rjb a(Bundle paramBundle)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      paramBundle = new rjb(i, paramBundle);
      e();
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "add to req queue seq: " + paramBundle.jdField_a_of_type_Int);
      }
      paramBundle.jdField_a_of_type_JavaLangRunnable = this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a(paramBundle.jdField_a_of_type_Int, 30000L);
      this.jdField_a_of_type_JavaUtilVector.add(paramBundle);
      return paramBundle;
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      QLog.e("Q.emoji.web.EmoWebIPCOperator", 1, "error:reqbundle is null.");
    }
    do
    {
      do
      {
        return;
        localObject = a(paramBundle);
      } while ((localObject == null) || ((this.jdField_a_of_type_ComTencentMobileqqEmosmClient != null) && (this.jdField_a_of_type_ComTencentMobileqqEmosmClient.onReqToServer(((rjb)localObject).jdField_a_of_type_AndroidOsBundle))));
      paramBundle = a(paramBundle.getInt("seq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.jdField_a_of_type_Int);
      }
    } while (paramBundle == null);
    Object localObject = new Bundle();
    a((Bundle)localObject, 1002);
    paramBundle.jdField_a_of_type_AndroidOsBundle.putBundle("response", (Bundle)localObject);
    a(new riv(this, paramBundle));
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle != null) {
      paramBundle.putInt("failcode", paramInt);
    }
  }
  
  public void a(Client.onRemoteRespObserver paramonRemoteRespObserver)
  {
    if (paramonRemoteRespObserver == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "RegisterObserver key:" + paramonRemoteRespObserver.key);
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramonRemoteRespObserver));
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramonRemoteRespObserver);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a(paramRunnable, paramLong);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmClient != null) {
      return this.jdField_a_of_type_ComTencentMobileqqEmosmClient.isClientBinded();
    }
    return false;
  }
  
  public void b()
  {
    d();
  }
  
  public void b(Bundle paramBundle)
  {
    if ((paramBundle != null) && ((this.jdField_a_of_type_ComTencentMobileqqEmosmClient == null) || (!this.jdField_a_of_type_ComTencentMobileqqEmosmClient.onReqToServer(paramBundle))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "sendServiceIpcReq unbind fail seq:" + this.jdField_a_of_type_Int);
      }
      Bundle localBundle = new Bundle();
      a(localBundle, 1002);
      paramBundle.putBundle("response", localBundle);
      a(new riw(this, paramBundle));
    }
  }
  
  public void b(Client.onRemoteRespObserver paramonRemoteRespObserver)
  {
    if (paramonRemoteRespObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "unRegisterObserver key:" + paramonRemoteRespObserver.key);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramonRemoteRespObserver)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramonRemoteRespObserver);
      }
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a(paramRunnable);
  }
  
  public void c(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("seq");
      localObject = a(i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp seq:" + i);
      }
      if (localObject == null) {
        break label75;
      }
      a(paramBundle, 1000);
      a(new rix(this, paramBundle));
    }
    label75:
    do
    {
      return;
      localObject = paramBundle.getString("cmd");
    } while ((localObject == null) || ((!((String)localObject).equals("startDownloadEmoji")) && (!((String)localObject).equals("startDownloadTheme")) && (!((String)localObject).equals("pausedownload")) && (!((String)localObject).equals("stopdownload")) && (!((String)localObject).equals("openEquipmentLock")) && (!((String)localObject).equals("card_setSummaryCard")) && (!((String)localObject).equals("card_getVipInfo")) && (!((String)localObject).equals("closeWeb")) && (!((String)localObject).equals("setMobileResult")) && (!((String)localObject).equals("setWaitingResponse")) && (!((String)localObject).equals("openEmojiMall")) && (!((String)localObject).equals("openProfileCard")) && (!((String)localObject).equals("close_version")) && (!((String)localObject).equals("openEmojiDetail")) && (!((String)localObject).equals("openFontSetting")) && (!((String)localObject).equals("startDownloadColorRing")) && (!((String)localObject).equals("stopDownloadColorRing")) && (!((String)localObject).equals("funcall_download")) && (!((String)localObject).equals("funcall_set")) && (!((String)localObject).equals("getA2")) && (!((String)localObject).equals("openDevLock")) && (!((String)localObject).equals("queryDevLockStatus")) && (!((String)localObject).equals("ipc_funnypic_add")) && (!((String)localObject).equals("ipc_funnypic_add")) && (!((String)localObject).equals("ipc_video_isinstalled")) && (!((String)localObject).equals("ipc_video_install_plugin")) && (!((String)localObject).equals("ipc_apollo_changerole")) && (!((String)localObject).equals("ipc_apollo_preview")) && (!((String)localObject).equals("ipc_apollo_initavatar")) && (!((String)localObject).equals("ipc_apollo_preview_action"))));
    a(paramBundle, 1000);
    a(new riy(this, paramBundle));
  }
  
  public void d(Bundle paramBundle)
  {
    f(paramBundle);
  }
  
  public void e(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchResp suc:" + paramBundle.getString("cmd"));
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Client.onRemoteRespObserver)localIterator.next()).onResponse(paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\web\WebIPCOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */