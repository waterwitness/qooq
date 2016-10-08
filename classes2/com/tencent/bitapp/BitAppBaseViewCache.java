package com.tencent.bitapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import hde;
import hdf;
import java.util.List;

public class BitAppBaseViewCache
{
  public static final int a = -1;
  public static final String a;
  public static final int b = -2;
  public static final int c = 4;
  private LruCache a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = BitAppMsg.class.getSimpleName();
  }
  
  public BitAppBaseViewCache()
  {
    this(4);
  }
  
  public BitAppBaseViewCache(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new hde(this, 4);
  }
  
  private static BitAppMsg.CreateViewListener a(Context paramContext, BitAppBaseViewCache.BitAppGetViewListener paramBitAppGetViewListener, String paramString)
  {
    return new hdf(paramString, paramBitAppGetViewListener);
  }
  
  private BitAppBaseView a(Context paramContext, String paramString, MessageForBitApp paramMessageForBitApp, int paramInt1, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, int paramInt2, BitAppBaseViewCache.BitAppGetViewListener paramBitAppGetViewListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createView for msgId: " + paramString + " | state: " + paramInt1);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("peerUin", paramMessageForBitApp.frienduin);
    ((Bundle)localObject1).putString("puin", paramMessageForBitApp.senderuin);
    ((Bundle)localObject1).putInt("aioType", paramMessageForBitApp.istroop);
    ((Bundle)localObject1).putLong("msgState", paramInt1);
    ((Bundle)localObject1).putLong("width", paramInt2);
    ((Bundle)localObject1).putString("msgid", paramString);
    ((Bundle)localObject1).putLong("reportMsgId", paramMessageForBitApp.bitAppMsg.getMsgId());
    if ((!TextUtils.isEmpty(paramMessageForBitApp.getExtInfoFromExtStr("isAdMsg"))) && (paramMessageForBitApp.getExtInfoFromExtStr("isAdMsg").equals("1")))
    {
      ((Bundle)localObject1).putBoolean("isAdMsg", true);
      ((Bundle)localObject1).putString("gdt_Cli_Data", paramMessageForBitApp.getExtInfoFromExtStr("gdt_msgClick"));
      Object localObject2 = a(paramContext, paramBitAppGetViewListener, paramString);
      localObject1 = paramMessageForBitApp.bitAppMsg.getView(paramContext, (Bundle)localObject1, (BitAppMsg.CreateViewListener)localObject2);
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label336;
      }
      localObject2 = (BitAppBaseView)((List)localObject1).get(0);
      paramBitAppGetViewListener.a((BitAppBaseView)localObject2);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject2);
        if (paramOnLongClickAndTouchListener != null)
        {
          ((BitAppBaseView)localObject2).setLongClickable(true);
          ((BitAppBaseView)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
          ((BitAppBaseView)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
        }
        ((BitAppBaseView)localObject2).setOnFactSizeChangedListener(new BitAppMonitorFrameLayout(paramMessageForBitApp, paramContext, paramString, (BitAppBaseView)localObject2, this));
      }
    }
    for (;;)
    {
      paramString = null;
      paramContext = paramString;
      if (localObject1 != null)
      {
        paramContext = paramString;
        if (((List)localObject1).size() > 0) {
          paramContext = (BitAppBaseView)((List)localObject1).get(0);
        }
      }
      return paramContext;
      ((Bundle)localObject1).putBoolean("isAdMsg", false);
      break;
      label336:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createView empty BitAppBaseView for msgId: " + paramString);
      }
    }
  }
  
  public BitAppBaseView a(Context paramContext, MessageForBitApp paramMessageForBitApp, int paramInt, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, BitAppBaseViewCache.BitAppGetViewListener paramBitAppGetViewListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getView:  | context: " + paramContext + " | bitAppMr: " + paramMessageForBitApp + " | longClick: " + paramOnLongClickAndTouchListener + " | listener: " + paramBitAppGetViewListener);
    }
    if ((!RNPreDownloadFacade.a()) || ((BitAppInstanceManager.getInstance() != null) && (BitAppInstanceManager.getInstance().isException()))) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "React exception");
    }
    do
    {
      return null;
      if ((paramBitAppGetViewListener != null) && (paramContext != null) && (paramMessageForBitApp != null) && (paramMessageForBitApp.bitAppMsg != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getView input params is null");
      }
      if ((paramBitAppGetViewListener != null) && (paramMessageForBitApp != null))
      {
        paramBitAppGetViewListener.a(String.valueOf(paramMessageForBitApp.uniseq), -2);
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "listener is null so don't notify");
    return null;
    String str = String.valueOf(paramMessageForBitApp.uniseq);
    BitAppBaseView localBitAppBaseView = (BitAppBaseView)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
    int i = paramMessageForBitApp.bitAppMsg.getModuleId();
    BundleStruct localBundleStruct = BundleStructCache.INSTANCE.get(i);
    if (localBundleStruct != null) {
      i = localBundleStruct.module_state;
    }
    if (localBitAppBaseView == null) {
      return a(paramContext, str, paramMessageForBitApp, paramMessageForBitApp.bitAppMsg.mState, paramOnLongClickAndTouchListener, paramInt, paramBitAppGetViewListener);
    }
    if ((localBitAppBaseView.getParent() != null) && (((ViewGroup)localBitAppBaseView.getParent()).getChildCount() > 0)) {
      ((ViewGroup)localBitAppBaseView.getParent()).removeView(localBitAppBaseView);
    }
    paramBitAppGetViewListener.a(str, localBitAppBaseView);
    return localBitAppBaseView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    if ((RNPreDownloadFacade.a()) && (BitAppInstanceManager.getInstance() != null) && (BaseActivity.sTopActivity != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "BaseActivity.sTopActivity: " + BaseActivity.sTopActivity);
      }
      if ((BaseActivity.sTopActivity instanceof ChatActivity)) {
        break label85;
      }
      BitAppExitBroadcastReceiver.b(ContextUtils.INSTANCE.getApplicationContext());
      BitAppInstanceManager.getInstance().onDestroy();
    }
    label85:
    label228:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            Object localObject = (ChatFragment)((ChatActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            if (localObject != null)
            {
              localObject = ((ChatFragment)localObject).a();
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "BaseActivity.sTopActivity chatPie: " + localObject);
              }
              if ((localObject instanceof PublicAccountChatPie)) {
                break label228;
              }
              BitAppExitBroadcastReceiver.b(ContextUtils.INSTANCE.getApplicationContext());
              BitAppInstanceManager.getInstance().onDestroy();
              return;
            }
          }
          catch (Exception localException)
          {
            BitAppExitBroadcastReceiver.b(ContextUtils.INSTANCE.getApplicationContext());
            BitAppInstanceManager.getInstance().onDestroy();
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Check chatPie error: " + localException.getMessage());
      return;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "it's PublicAccountChatPie, so no need clear");
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "setMsgHeight peerUin: " + paramString1 + " | type: " + paramString2 + " | uniseq: " + paramString3 + " height:" + paramInt);
    }
    int i = -1;
    long l1 = -1L;
    try
    {
      j = Integer.parseInt(paramString2);
      i = j;
      long l2 = Long.parseLong(paramString3);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                paramString2.printStackTrace();
                j = i;
              }
              paramString2 = BaseActivity.sTopActivity.getAppInterface();
              if (!(paramString2 instanceof QQAppInterface)) {
                break label400;
              }
              QQMessageFacade localQQMessageFacade = ((QQAppInterface)paramString2).a();
              paramString2 = localQQMessageFacade.a(paramString1, j, l1);
              if (paramString2 == null) {
                break label344;
              }
              if (!(paramString2 instanceof MessageForBitApp)) {
                break;
              }
              paramString3 = ((MessageForBitApp)paramString2).bitAppMsg;
              if (paramString3 != null)
              {
                paramString3.setHeight(paramInt);
                paramString2 = null;
                try
                {
                  paramString3 = paramString3.getBytes();
                  paramString2 = paramString3;
                }
                catch (Exception paramString3)
                {
                  for (;;)
                  {
                    paramString3.printStackTrace();
                  }
                }
                localQQMessageFacade.a(paramString1, j, l1, paramString2);
                return;
              }
            } while (!QLog.isColorLevel());
            QLog.d(jdField_a_of_type_JavaLangString, 4, "Find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1 + " bitAppMsg is null");
            return;
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 4, "Find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1 + " isn't MessageForBitApp");
          return;
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 4, "Can't find message for peerUin: " + paramString1 + " | type: " + j + " | uniseq: " + l1);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 4, "Current runtime isn't QQAppInterface");
    }
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "setMsgHeight msgId error");
      }
      return;
    }
    label344:
    label400:
    return;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppBaseViewCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */