package com.tencent.biz.viewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import jgf;
import jgg;

public class ViewPluginManager
{
  public static final String a = "ViewPluginManager";
  static final String b = "SearchViewPluginVersion";
  public static final String c = "leba_search";
  public static final String d = "leba_search_load_builder";
  public static final String e = "leba_search_set_data";
  public SharedPreferences a;
  public ViewPluginContext a;
  public BaseActivity a;
  public ClassLoader a;
  public HashMap a;
  public String f;
  public String g;
  public String h;
  private String i;
  
  public ViewPluginManager(BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = null;
    this.g = paramString1;
    this.f = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.h = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir() + "/searchPlugin/opt");
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getPreferences(0);
  }
  
  public static boolean a(View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      Method localMethod = paramView.getClass().getMethod("setData", new Class[] { String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[] { paramString });
      return true;
    }
    catch (Exception paramView)
    {
      ThreadManager.a(new jgf(paramView), 2, null, true);
    }
    return false;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangClassLoader != null) {}
    Object localObject;
    do
    {
      for (;;)
      {
        try
        {
          Class localClass = this.jdField_a_of_type_JavaLangClassLoader.loadClass("com.tencent.biz.lebsearch.widget.SearchViewBuilder");
          if (localClass != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ViewPluginManager", 2, "plugin:" + this.g + " not find view:" + paramInt);
          }
          return null;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_builder", 0, 0, a(), localClassNotFoundException.getClass().getSimpleName(), null, null);
        }
        localObject = null;
      }
      if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginManager", 2, "plugin:" + this.g + " plugin context is null");
    return null;
    try
    {
      localObject = ((Class)localObject).getMethod("getView", new Class[] { Context.class, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      localObject = (View)((Method)localObject).invoke(null, new Object[] { this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext, Integer.valueOf(paramInt) });
      return (View)localObject;
    }
    catch (Exception localException)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_load_builder", 0, 0, a(), localException.getClass().getSimpleName(), null, null);
    }
    return null;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.i)) {
      this.i = HtmlOffline.d(this.f);
    }
    return this.i;
  }
  
  public void a()
  {
    String str = "http://" + this.g + "?_bid=" + this.f;
    HtmlOffline.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      HtmlOffline.a = bool;
      b();
      Context localContext = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext();
      long l = System.currentTimeMillis();
      if ((!HtmlOffline.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), str, new jgg(this, l, localContext))) && (QLog.isColorLevel())) {
        QLog.i("ViewPluginManager", 2, "plugin:" + this.g + " transToLocalUrl: return false");
      }
      return;
    }
  }
  
  public void b()
  {
    String str = "http://" + this.g + "?_bid=" + this.f;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.b(str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\viewplugin\ViewPluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */