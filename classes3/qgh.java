import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.SqliteExcuteMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class qgh
  implements HookMethodCallback
{
  public qgh(Method paramMethod, AppInterface paramAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    boolean bool = false;
    try
    {
      int i = ((Integer)paramMethodHookParam.args[0]).intValue();
      if (this.jdField_a_of_type_JavaLangReflectMethod != null)
      {
        paramMethodHookParam = this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramMethodHookParam.thisObject, new Object[] { Integer.valueOf(i) });
        if (SqliteExcuteMonitor.a() == null)
        {
          SqliteExcuteMonitor.a(paramMethodHookParam.getClass().getDeclaredField("mStartTime"));
          SqliteExcuteMonitor.a().setAccessible(true);
        }
        if (SqliteExcuteMonitor.b() == null)
        {
          SqliteExcuteMonitor.b(paramMethodHookParam.getClass().getDeclaredField("mEndTime"));
          SqliteExcuteMonitor.b().setAccessible(true);
        }
        if (SqliteExcuteMonitor.c() == null)
        {
          SqliteExcuteMonitor.c(paramMethodHookParam.getClass().getDeclaredField("mSql"));
          SqliteExcuteMonitor.c().setAccessible(true);
        }
        long l1 = ((Long)SqliteExcuteMonitor.a().get(paramMethodHookParam)).longValue();
        long l2 = ((Long)SqliteExcuteMonitor.b().get(paramMethodHookParam)).longValue();
        paramMethodHookParam = ((String)SqliteExcuteMonitor.c().get(paramMethodHookParam)).toUpperCase();
        l1 = l2 - l1;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          bool = true;
        }
        if (SqliteExcuteMonitor.a(paramMethodHookParam, l1, bool)) {
          SqliteExcuteMonitor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMethodHookParam, l1, bool, this.jdField_a_of_type_Int);
        }
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      do
      {
        SqliteExcuteMonitor.a(true);
      } while (!QLog.isColorLevel());
      QLog.i(SqliteExcuteMonitor.a(), 2, "hook exception :" + paramMethodHookParam.getMessage());
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      do
      {
        SqliteExcuteMonitor.a(true);
      } while (!QLog.isColorLevel());
      QLog.i(SqliteExcuteMonitor.a(), 2, "hook exception :" + paramMethodHookParam.getMessage());
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */