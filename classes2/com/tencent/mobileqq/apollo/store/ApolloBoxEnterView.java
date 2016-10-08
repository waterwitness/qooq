package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;
import pre;
import prf;

public class ApolloBoxEnterView
  extends FrameGifView
  implements Handler.Callback, BusinessObserver
{
  private static final int jdField_a_of_type_Int = 255;
  private static final int b = 256;
  private static final int c = 257;
  private static final String f = "ApolloBoxEnterView";
  private ApolloPandora jdField_a_of_type_ComTencentMobileqqDataApolloPandora;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private String g;
  private String h;
  private String i;
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public ApolloBoxEnterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.g = paramString2;
    this.i = paramQQAppInterface.a();
    this.h = paramString1;
    ThreadManager.b(new pre(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString2)));
    int j;
    boolean bool1;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora = ((ApolloManager)localQQAppInterface.getManager(152)).a(this.g, true);
        if ((TextUtils.isEmpty(ApolloManager.b)) || (!ApolloManager.b.equals(this.g))) {
          break label628;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState ApolloManager.sUinForReload:" + ApolloManager.b);
        }
        ApolloManager.b = null;
        j = 1;
        if ((j == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora != null) && (NetConnInfoCenter.getServerTime() <= this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.checkPoint)) {
          break label472;
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
        if (!QLog.isColorLevel()) {
          break label622;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora == null) {
          break label457;
        }
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.checkPoint:" + this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.checkPoint);
        bool1 = true;
        label198:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBoxEnterView", 2, "checkBoxState check->" + bool1);
        }
        if (!bool1) {
          break;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("6.5.5");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_interact.get_user_chipdata");
        if (!TextUtils.isEmpty(paramString1)) {
          break label598;
        }
        paramString1 = "android";
        label324:
        ((JSONObject)localObject).put("from", paramString1);
        paramString1 = new JSONArray();
        paramString1.put(Long.parseLong(paramString2));
        ((JSONObject)localObject).put("uins", paramString1);
        ((JSONObject)localObject).put("mask", 1);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString1 = new NewIntent(localQQAppInterface.a(), WebSSOAgentServlet.class);
        paramString1.putExtra("extra_cmd", "apollo_interact.get_user_chipdata");
        paramString1.putExtra("extra_data", localUniSsoServerReq.toByteArray());
        paramString1.putExtra("extra_callbackid", paramString2);
        paramString1.setObserver(this);
        localQQAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloBoxEnterView", 2, "queryPandoraInfo failed ", paramString1);
      return;
      label457:
      QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
      bool1 = true;
    }
    label472:
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.needShow(this.i)) {
      if (System.currentTimeMillis() < this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.updateTime + this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.queryInterval * 1000L) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(257);
      }
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      bool1 = bool2;
      if (!QLog.isColorLevel()) {
        break label198;
      }
      QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.canSteal == 1 && mApolloPandora.hadStolen == 0");
      bool1 = bool2;
      break label198;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState updateTime has past need update");
        continue;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(256);
        bool1 = false;
        break label198;
        label598:
        paramString1 = "android." + paramString1;
        break label324;
        label622:
        bool1 = true;
        break label198;
        label628:
        j = 0;
        break;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 8;
    switch (paramMessage.what)
    {
    default: 
    case 255: 
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.needShow(this.i)) {
            j = 0;
          }
          setVisibility(j);
        }
      } while (!QLog.isColorLevel());
      if (this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora != null)
      {
        QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora.checkPoint:" + this.jdField_a_of_type_ComTencentMobileqqDataApolloPandora.checkPoint);
        return false;
      }
      QLog.d("ApolloBoxEnterView", 2, "checkBoxState mApolloPandora == null");
      return false;
    case 257: 
      super.setVisibility(0);
      return false;
    }
    super.setVisibility(8);
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ThreadManager.b(new prf(this, paramBundle));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloBoxEnterView", 2, "handleQueryPandora fail ret: ");
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBoxEnterView", 2, "setVisibility:" + paramInt);
    }
    if (paramInt == 0)
    {
      if (!"drawer".equals(this.h)) {
        break label121;
      }
      paramInt = 0;
      if ((TextUtils.isEmpty(this.g)) || (!this.g.equals(this.i))) {
        break label126;
      }
    }
    label121:
    label126:
    for (int j = 0;; j = 1)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065BF", paramInt, 0, new String[] { String.valueOf(j) });
      if (a() == 3) {
        super.a();
      }
      return;
      paramInt = 1;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloBoxEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */