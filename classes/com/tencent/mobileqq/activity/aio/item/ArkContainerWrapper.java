package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ContainerCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import nhu;
import nhw;
import nhx;
import nhy;
import nhz;
import nia;
import nib;
import nid;
import nie;
import nif;
import nig;
import nih;
import nii;

public class ArkContainerWrapper
{
  public static final int a = 0;
  public static String a;
  public static ArrayList a;
  public static final int b = 1;
  private static final String b = "ArkApp";
  protected static boolean b = false;
  public static final int c = 2;
  public volatile Rect a;
  GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  public ark.ApplicationCallback a;
  public ark.Container a;
  public ark.ContainerCallback a;
  public ArkContainerWrapper.AppInfo a;
  protected ArkContainerWrapper.ErrorInfo a;
  public volatile ArkUIView a;
  public DispatchTask a;
  public ArkAppMessage.Config a;
  public WeakReference a;
  protected boolean a;
  protected boolean c;
  public boolean d;
  public volatile boolean e;
  public volatile boolean f;
  
  public ArkContainerWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo = new ArkContainerWrapper.ErrorInfo(this);
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask = DispatchTask.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo = new ArkContainerWrapper.AppInfo(this);
    ArkAppCenter.b();
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(this));
    this.jdField_a_of_type_ComTencentArkArk$ContainerCallback = new nhu(this);
    this.jdField_a_of_type_ComTencentArkArk$ApplicationCallback = new nia(this);
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new nib(this);
  }
  
  public static Rect a(Rect paramRect, float paramFloat)
  {
    if (paramRect == null) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((int)(paramRect.left * paramFloat));
    localRect.top = ((int)(paramRect.top * paramFloat));
    localRect.right = ((int)Math.ceil(paramRect.right * paramFloat));
    localRect.bottom = ((int)Math.ceil(paramRect.bottom * paramFloat));
    return localRect;
  }
  
  protected static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.a.a();
  }
  
  public static MessageForArkApp a(String paramString)
  {
    int i;
    if (jdField_a_of_type_JavaUtilArrayList != null) {
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject != null) {
          break label35;
        }
      }
      label35:
      MessageForArkApp localMessageForArkApp;
      do
      {
        do
        {
          do
          {
            return null;
            localObject = (ArkContainerWrapper)((WeakReference)localObject).get();
          } while (localObject == null);
          localObject = ((ArkContainerWrapper)localObject).jdField_a_of_type_JavaLangRefWeakReference;
        } while (localObject == null);
        localMessageForArkApp = (MessageForArkApp)((WeakReference)localObject).get();
      } while (localMessageForArkApp == null);
      if ((paramString.equals(localMessageForArkApp.getExtInfoFromExtStr("pa_msgId"))) || (paramString.equals(String.valueOf(localMessageForArkApp.uniseq)))) {
        return (MessageForArkApp)((WeakReference)localObject).get();
      }
      i += 1;
    }
  }
  
  public static String a(MessageForArkApp paramMessageForArkApp, String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramMessageForArkApp == null);
        str = paramString;
      } while (paramMessageForArkApp.ark_app_message == null);
      str = paramString;
      if (paramMessageForArkApp.ark_app_message.appDesc != null) {
        str = paramString.replace("%APP_DESC%", paramMessageForArkApp.ark_app_message.appDesc).replace("$APP_DESC$", paramMessageForArkApp.ark_app_message.appDesc);
      }
      paramString = str;
      if (paramMessageForArkApp.ark_app_message.appName != null) {
        paramString = str.replace("%APP_NAME%", paramMessageForArkApp.ark_app_message.appName).replace("$APP_NAME$", paramMessageForArkApp.ark_app_message.appName);
      }
      str = paramString;
    } while (paramMessageForArkApp.ark_app_message.promptText == null);
    return paramString.replace("%PROMPT%", paramMessageForArkApp.ark_app_message.promptText).replace("$PROMPT$", paramMessageForArkApp.ark_app_message.promptText);
  }
  
  public static void a(int paramInt)
  {
    QLog.d("ArkApp", 4, String.format("ark container doArkAppEvent type:%d", new Object[] { Integer.valueOf(paramInt) }));
    if (jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < jdField_a_of_type_JavaUtilArrayList.size())
      {
        WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((ArkContainerWrapper)localWeakReference.get()).b(paramInt);
          if (paramInt == 2)
          {
            localWeakReference = ((ArkContainerWrapper)localWeakReference.get()).jdField_a_of_type_JavaLangRefWeakReference;
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((MessageForArkApp)localWeakReference.get()).arkContainer = null;
            }
          }
        }
        i += 1;
      }
    }
    if ((paramInt == 2) && (jdField_a_of_type_JavaUtilArrayList != null))
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public static Rect b(Rect paramRect, float paramFloat)
  {
    if (paramRect == null) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((int)Math.ceil(paramRect.left / paramFloat));
    localRect.top = ((int)Math.ceil(paramRect.top / paramFloat));
    localRect.right = ((int)(paramRect.right / paramFloat));
    localRect.bottom = ((int)(paramRect.bottom / paramFloat));
    return localRect;
  }
  
  private boolean b(ArkUIView paramArkUIView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView = paramArkUIView;
    if (this.c)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_Boolean);
      }
      QLog.i("ArkApp", 1, "ark container initArkContainer mLoadFailed true!!!");
      return true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nid(this));
      QLog.d("ArkApp", 4, "ark container initArkContainer mInit true!!!");
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    paramArkUIView = a();
    if (paramArkUIView == null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.c = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a(null, true);
      }
      return true;
    }
    paramArkUIView = ((ArkAppCenter)paramArkUIView.getManager(120)).a();
    Object localObject = paramArkUIView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.e);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, "ark container getAppPathByNameFromLocal In!!!!");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a();
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo, 0, null);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a();
    }
    localObject = new WeakReference(this);
    paramArkUIView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo, new nie(this, (WeakReference)localObject));
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nhx(this));
    b();
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nhy(this));
    if (QLog.isColorLevel()) {
      QLog.i("ark.rect", 2, String.format("ArkDestroy. wrapper: %s", new Object[] { toString() }));
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Boolean = true;
    this.c = false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_b_of_type_Float;
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
      return this.jdField_a_of_type_AndroidGraphicsRect.height();
    }
    synchronized (ArkAppCenter.a)
    {
      Long localLong = (Long)ArkAppCenter.a.get(String.format("%s_%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.c }));
      if (localLong != null)
      {
        int i = localLong.intValue();
        return i;
      }
    }
    return 0;
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public Rect a(Rect paramRect)
  {
    return a(paramRect, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Float);
  }
  
  public void a()
  {
    if (this.c)
    {
      this.c = false;
      if (!this.jdField_a_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView);
  }
  
  public void a(Rect paramRect)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.rect", 2, String.format("setViewRect.1.rect: %s, wrapper: %s", new Object[] { paramRect.toString(), toString() }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nih(this, paramRect));
  }
  
  public void a(ArkContainerWrapper.AppInfo paramAppInfo, int paramInt, String paramString)
  {
    boolean bool = true;
    this.c = false;
    this.d = false;
    QLog.d("ArkApp", 4, "ark container LoadArkApp In!!!!");
    if ((paramInt != 0) || (paramAppInfo == null) || (paramAppInfo.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      this.c = true;
      if (paramInt != -2) {
        break label339;
      }
    }
    label333:
    label339:
    for (bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_Boolean);
      }
      paramString = Boolean.toString(this.c);
      if (paramAppInfo != null) {}
      for (paramAppInfo = Boolean.toString(paramAppInfo.jdField_a_of_type_Boolean);; paramAppInfo = "")
      {
        QLog.i("ArkApp", 1, String.format("ark container LoadArkApp Failed!!!! mLoadFailed:%s info.canceled:%s", new Object[] { paramString, paramAppInfo }));
        return;
      }
      String str = ArkAppCenter.c;
      paramString = new File(str);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      if (!b)
      {
        ark.arkSetStoragePath(str);
        ark.arkHTTPStartup();
        ark.arkHTTPSetDownloadDirectory(str);
        ark.arkSetPixelScale(paramAppInfo.jdField_b_of_type_Float);
        b = true;
      }
      ArkAppCenter.c();
      MessageForArkApp localMessageForArkApp;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localMessageForArkApp = (MessageForArkApp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localMessageForArkApp != null)
        {
          paramString = localMessageForArkApp.getExtInfoFromExtStr("pa_msgId");
          if (TextUtils.isEmpty(paramString))
          {
            this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nif(this, paramAppInfo, str, paramString));
            paramAppInfo = new StringBuilder().append("ark container LoadArkApp UI view init : ");
            if (this.c) {
              break label333;
            }
          }
        }
      }
      for (;;)
      {
        QLog.d("ArkApp", 4, bool);
        return;
        paramString = String.valueOf(localMessageForArkApp.uniseq);
        break;
        paramString = "";
        break;
        paramString = "";
        break;
        bool = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nhz(this, paramBoolean));
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentArkArk$Container == null) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Float;
    int i = (int)(paramMotionEvent.getX() / f1);
    int j = (int)(paramMotionEvent.getY() / f1);
    int k = paramMotionEvent.getAction();
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nii(this, k, i, j));
    return true;
  }
  
  public boolean a(ArkUIView paramArkUIView)
  {
    this.f = true;
    QLog.i("ark.rect", 1, String.format("attachView.1.wrapper: %s", new Object[] { toString() }));
    return b(paramArkUIView);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, MessageForArkApp paramMessageForArkApp, SessionInfo paramSessionInfo, int paramInt)
  {
    jdField_a_of_type_JavaLangString = null;
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    if (this.c)
    {
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$ErrorInfo.jdField_a_of_type_Boolean);
      }
      QLog.i("ArkApp", 1, "ark container initArkContainer mLoadFailed true!!!");
    }
    do
    {
      return true;
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.d("ArkApp", 4, "ark container initArkContainer mInit true!!!");
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.fromString(paramMessageForArkApp.ark_app_message.config);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_b_of_type_Float = Math.round(paramFloat);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.c = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.d = paramString4;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.e = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForArkApp);
    } while (paramInt <= 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Int = ((int)(paramInt / paramFloat));
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Float;
  }
  
  public int b()
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) {
      return this.jdField_a_of_type_AndroidGraphicsRect.width();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Int;
  }
  
  public Rect b(Rect paramRect)
  {
    return b(paramRect, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.jdField_a_of_type_Float);
  }
  
  public void b()
  {
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkUIView = null;
    if (QLog.isColorLevel()) {
      QLog.i("ark.rect", 2, String.format("detachView.1.wrapper: %s", new Object[] { toString() }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nig(this));
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nhw(this));
        return;
      }
    } while (paramInt != 2);
    c();
  }
  
  protected void finalize()
  {
    super.finalize();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkContainerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */