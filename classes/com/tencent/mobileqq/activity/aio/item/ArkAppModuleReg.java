package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ArkAppModuleReg
{
  private static final int jdField_a_of_type_Int = 0;
  private static final String jdField_a_of_type_JavaLangString = "ArkApp";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "QQ";
  
  public ArkAppModuleReg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected static Intent a(Context paramContext, String paramString, boolean paramBoolean, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    localIntent.putExtra("param_force_internal_browser", paramBoolean);
    localIntent.putExtra("injectrecommend", false);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("appShareID", paramLong);
    localIntent.addFlags(603979776);
    if (paramContext != null) {
      paramContext.startActivity(localIntent);
    }
    return localIntent;
  }
  
  protected static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.a.a();
  }
  
  public static void a(long paramLong, String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.indexOf("com.tencent.", 0) == -1) {
        l1 = 1L;
      }
    }
    paramString = new ArkAppModuleReg.ModuleQQ();
    paramString.a(l1);
    ark.arkModuleRegCallbackWrapper(paramLong, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\ArkAppModuleReg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */