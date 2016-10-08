package cooperation.qqpim;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQPimTipsInfoHelper
{
  public QQPimTipsInfoHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null)
    {
      QQPimSharedPrefrenceUtil.a(paramContext, "QQPIM_TIPS_CLICK", System.currentTimeMillis());
      return;
    }
    QQPimSharedPrefrenceUtil.a(paramContext, "QQPIM_TIPS_CLICK" + paramQQPimTipsInfo.f, paramQQPimTipsInfo.jdField_a_of_type_JavaLangString + ";" + paramQQPimTipsInfo.g + ";" + System.currentTimeMillis());
  }
  
  public static void b(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {}
    while (TextUtils.isEmpty(QQPimSharedPrefrenceUtil.a(paramContext, "QQPIM_TIPS_CLICK" + paramQQPimTipsInfo.f))) {
      return;
    }
    switch (paramQQPimTipsInfo.f)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
      return;
    case 2: 
      paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
      return;
    }
    paramQQPimTipsInfo.jdField_a_of_type_Byte = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimTipsInfoHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */