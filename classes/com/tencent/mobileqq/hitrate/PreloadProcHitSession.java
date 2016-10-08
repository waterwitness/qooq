package com.tencent.mobileqq.hitrate;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class PreloadProcHitSession
{
  public static final boolean a = false;
  public HashMap a;
  public String b;
  protected boolean b;
  public String c;
  public boolean c;
  public String d;
  
  public PreloadProcHitSession(String paramString1, String paramString2)
  {
    this("default", paramString1, paramString2);
  }
  
  protected PreloadProcHitSession(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.d = paramString3;
    c();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramString.equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  protected String a()
  {
    return this.d + this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      d();
    }
    PreloadProcHitMgr.a(this);
    this.jdField_b_of_type_Boolean = true;
    if (!(this instanceof PreloadProcHitPluginSessionProc)) {
      PreloadProcHitMgr.e(this.d);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadProcHitSession", 2, String.format("[%s] [%s] %s", new Object[] { this.d, this.jdField_b_of_type_JavaLangString, paramString }));
    }
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = true;
    } while ((this instanceof PreloadProcHitPluginSessionProc));
    PreloadProcHitMgr.d(this.d);
  }
  
  void c()
  {
    this.a.put("loss", "0");
    this.a.put("benefit", "0");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = BaseApplicationImpl.a();
    Context localContext;
    String str;
    if (localObject != null)
    {
      localContext = ((BaseApplicationImpl)localObject).getApplicationContext();
      localObject = ((BaseApplicationImpl)localObject).a();
      if (localObject != null)
      {
        localObject = ((AppRuntime)localObject).getAccount();
        str = this.jdField_c_of_type_JavaLangString;
        if (!this.jdField_c_of_type_Boolean) {
          break label69;
        }
        StatisticCollector.a(localContext).a((String)localObject, str, true, 0L, 0L, this.a, null);
      }
    }
    for (;;)
    {
      c();
      return;
      label69:
      StatisticCollector.a(localContext).a((String)localObject, str, false, 0L, 0L, this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\hitrate\PreloadProcHitSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */