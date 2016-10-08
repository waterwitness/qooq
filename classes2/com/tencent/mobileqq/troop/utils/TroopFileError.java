package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;
import vpk;
import vpl;
import vpn;
import vpo;

public class TroopFileError
{
  public static final int A = 305;
  public static final int B = 306;
  public static final int C = 307;
  public static final int D = 308;
  public static final int E = 309;
  public static final int F = 400;
  public static final int G = 401;
  public static final int H = 402;
  public static final int I = 403;
  public static final int J = 500;
  public static final int K = 501;
  public static final int L = 502;
  public static final int M = 503;
  public static final int N = 504;
  public static final int O = 505;
  public static final int P = 600;
  public static final int Q = 601;
  public static final int R = 602;
  public static final int S = 603;
  public static final int T = 604;
  public static final int U = 605;
  public static final int V = 700;
  public static final int W = 701;
  public static final int X = 702;
  public static final int Y = 703;
  public static final int Z = 704;
  public static final int a = 0;
  public static final String a;
  public static WeakReference a;
  public static final int aa = 705;
  public static final int ab = 706;
  public static final int ac = 801;
  public static final int ad = 802;
  public static final int b = 1;
  public static final int c = 100;
  public static final int d = 101;
  public static final int e = 102;
  public static final int f = 103;
  public static final int g = 104;
  public static final int h = 105;
  public static final int i = 106;
  public static final int j = 107;
  public static final int k = 200;
  public static final int l = 201;
  public static final int m = 202;
  public static final int n = 203;
  public static final int o = 204;
  public static final int p = 205;
  public static final int q = 206;
  public static final int r = 207;
  public static final int s = 208;
  public static final int t = 209;
  public static final int u = 210;
  public static final int v = 300;
  public static final int w = 301;
  public static final int x = 302;
  public static final int y = 303;
  public static final int z = 304;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopFileError.class.getSimpleName();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramQQAppInterface.getApplication().getResources().getString(paramInt);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, int paramInt, Object... paramVarArgs)
  {
    return String.format(a(paramQQAppInterface, paramInt), paramVarArgs);
  }
  
  private static void a(Context paramContext, long paramLong)
  {
    vpo localvpo = new vpo(paramLong);
    DialogUtil.a(paramContext, 230, paramContext.getResources().getString(2131364223), paramContext.getResources().getString(2131364224), 2131364152, 2131364153, localvpo, localvpo).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new vpl(paramContext, paramString1, paramString2, paramInt));
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.b(paramContext, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    localQQCustomDialog.setPositiveButton(paramContext.getResources().getString(paramInt), new vpn());
    localQQCustomDialog.show();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i1;
    try
    {
      i1 = paramContext.getResources().getDimensionPixelSize(2131492908);
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        new Handler(Looper.getMainLooper()).post(new vpk(paramBoolean, paramContext, paramString, i1));
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(paramContext, 2, paramString, 0).b(i1);
      return;
    }
    QQToast.a(paramContext, 2130838454, paramString, 0).b(i1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    a(paramQQAppInterface, paramLong, 7, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramLong, null, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramInt2 == 0)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("reportSimpleError==> troopUin:");
        localStringBuilder.append(paramLong).append(",filename:").append(paramString).append(",status:").append(paramInt1).append(",errorCode:").append(paramInt2);
        QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(new TroopFileError.SimpleErrorInfo(paramString, paramLong, paramInt1, paramInt2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if ((paramQQAppInterface == null) || (paramSimpleErrorInfo == null) || (paramSimpleErrorInfo.jdField_a_of_type_Int == 0)) {}
    do
    {
      return;
      paramQQAppInterface = (BizTroopHandler)paramQQAppInterface.a(22);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramSimpleErrorInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramQQAppInterface.b((BusinessObserver)jdField_a_of_type_JavaLangRefWeakReference.get());
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopFileErrorObserver);
    paramQQAppInterface.a(paramTroopFileErrorObserver);
  }
  
  public static void a(TroopFileError.SimpleErrorInfo paramSimpleErrorInfo, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramSimpleErrorInfo == null) || (paramContext == null)) {
      return;
    }
    Object localObject2 = TroopFileUtils.a(paramSimpleErrorInfo.jdField_a_of_type_JavaLangString);
    int i2 = 2131367263;
    int i1 = 0;
    Object localObject1;
    switch (paramSimpleErrorInfo.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = null;
      paramQQAppInterface = null;
    }
    for (;;)
    {
      if (i1 == 0) {
        break label1402;
      }
      if (jdField_a_of_type_JavaLangRefWeakReference == null) {
        break;
      }
      localObject2 = (TroopFileError.TroopFileErrorObserver)jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject2 == null) || (((TroopFileError.TroopFileErrorObserver)localObject2).jdField_a_of_type_Int == paramSimpleErrorInfo.jdField_a_of_type_Int)) {
        break;
      }
      ((TroopFileError.TroopFileErrorObserver)localObject2).jdField_a_of_type_Int = paramSimpleErrorInfo.jdField_a_of_type_Int;
      a(paramContext, paramQQAppInterface, (String)localObject1, i2);
      return;
      localObject1 = a(paramQQAppInterface, 2131364195);
      localObject2 = a(paramQQAppInterface, 2131364196);
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364197);
      paramQQAppInterface = null;
      continue;
      a(paramContext, paramLong);
      localObject1 = null;
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364198);
      localObject2 = a(paramQQAppInterface, 2131364199, new Object[] { localObject2 });
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364200);
      localObject2 = a(paramQQAppInterface, 2131364201, new Object[] { localObject2 });
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364202);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364203);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364207);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364200);
      localObject2 = a(paramQQAppInterface, 2131364204, new Object[] { localObject2 });
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364205);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364206);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364222);
      paramQQAppInterface = null;
      continue;
      localObject2 = a(paramQQAppInterface, 2131364237);
      localObject1 = a(paramQQAppInterface, 2131364238);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, String.format("%d", new Object[] { Long.valueOf(paramLong) }), "2", "", "");
      i1 = 1;
      i2 = 2131364236;
      paramQQAppInterface = (QQAppInterface)localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364210);
      localObject2 = a(paramQQAppInterface, 2131364208, new Object[] { localObject2 });
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364200);
      localObject2 = a(paramQQAppInterface, 2131364209, new Object[] { localObject2 });
      i1 = 1;
      paramQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = localObject2;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364212, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364213, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364214, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364196);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364110);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364111);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364215);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364216);
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364217, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364218, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      localObject1 = a(paramQQAppInterface, 2131364219, new Object[] { localObject2 });
      paramQQAppInterface = null;
      continue;
      if (TroopFileInfo.FileStatus.a(paramSimpleErrorInfo.jdField_b_of_type_Int))
      {
        localObject1 = a(paramQQAppInterface, 2131364220, new Object[] { localObject2 });
        paramQQAppInterface = null;
      }
      else
      {
        localObject1 = a(paramQQAppInterface, 2131364221, new Object[] { localObject2 });
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364222);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364227);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364228);
        paramQQAppInterface = null;
        continue;
        a(paramContext, a(paramQQAppInterface, 2131364229, new Object[] { localObject2 }), true);
        return;
        localObject1 = a(paramQQAppInterface, 2131364230);
        paramQQAppInterface = null;
        continue;
        localObject1 = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364231);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364233);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364234);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364235);
        paramQQAppInterface = null;
        continue;
        if (!TextUtils.isEmpty(paramSimpleErrorInfo.jdField_b_of_type_JavaLangString)) {}
        for (paramQQAppInterface = paramSimpleErrorInfo.jdField_b_of_type_JavaLangString;; paramQQAppInterface = a(paramQQAppInterface, 2131364239))
        {
          i2 = 2131364236;
          localObject2 = null;
          localObject1 = paramQQAppInterface;
          i1 = 1;
          paramQQAppInterface = (QQAppInterface)localObject2;
          break;
        }
        localObject1 = a(paramQQAppInterface, 2131364240);
        paramQQAppInterface = null;
        continue;
        localObject1 = a(paramQQAppInterface, 2131364241);
        paramQQAppInterface = null;
      }
    }
    label1402:
    a(paramContext, (String)localObject1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, TroopFileError.TroopFileErrorObserver paramTroopFileErrorObserver)
  {
    paramQQAppInterface.b(paramTroopFileErrorObserver);
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() == paramTroopFileErrorObserver)) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */