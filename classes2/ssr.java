import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ssr
  extends AsyncTask
{
  WeakReference a;
  
  public ssr(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramContext);
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        paramVarArgs = BaseApplicationImpl.a().a();
        if ((paramVarArgs != null) && ((paramVarArgs instanceof QQAppInterface)))
        {
          paramVarArgs = (QQAppInterface)paramVarArgs;
          if (!paramVarArgs.isLogin()) {
            return Boolean.valueOf(false);
          }
        }
        else
        {
          return Boolean.valueOf(false);
        }
        ConfigServlet.b(paramVarArgs);
        if ((!ConfigServlet.jdField_a_of_type_Boolean) || (ConfigServlet.c) || (ConfigServlet.jdField_a_of_type_AndroidContentIntent == null)) {
          return Boolean.valueOf(false);
        }
        if ((ConfigServlet.z != 0) && (Build.VERSION.SDK_INT > ConfigServlet.z)) {
          return Boolean.valueOf(false);
        }
        if (QQToast.a() != 0) {
          break label387;
        }
        if (i != 0)
        {
          Object localObject = PreferenceManager.getDefaultSharedPreferences((Context)this.a.get());
          long l2 = System.currentTimeMillis();
          if (GesturePWDUtils.a() == -1L) {
            GesturePWDUtils.a(((SharedPreferences)localObject).getLong(paramVarArgs.f() + "_" + "push_open_notify_lasttime", l2));
          }
          i = ((SharedPreferences)localObject).getInt(paramVarArgs.f() + "_" + "push_open_notify_count", 0);
          if (ConfigServlet.jdField_a_of_type_Long == 0L)
          {
            if (i >= 3) {
              break label392;
            }
            l1 = 604800000L;
            if ((l2 - GesturePWDUtils.a() > l1) || (i == 0))
            {
              GesturePWDUtils.a(l2);
              localObject = ((SharedPreferences)localObject).edit();
              ((SharedPreferences.Editor)localObject).putInt(paramVarArgs.f() + "_" + "push_open_notify_count", i + 1);
              ((SharedPreferences.Editor)localObject).putLong(paramVarArgs.f() + "_" + "push_open_notify_lasttime", l2);
              ((SharedPreferences.Editor)localObject).commit();
              return Boolean.valueOf(true);
            }
          }
          else
          {
            if (ConfigServlet.jdField_a_of_type_Long <= 0L) {
              break label381;
            }
            l1 = ConfigServlet.jdField_a_of_type_Long;
            l1 = l1 * 24L * 60L * 60L * 1000L;
            continue;
          }
        }
        return Boolean.valueOf(false);
      }
      catch (Exception paramVarArgs)
      {
        return Boolean.valueOf(false);
      }
      label381:
      long l1 = 0L;
      continue;
      label387:
      i = 0;
      continue;
      label392:
      l1 = 2592000000L;
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    try
    {
      if (paramBoolean.booleanValue())
      {
        if (this.a.get() == null) {
          return;
        }
        DialogUtil.a((Context)this.a.get(), 232, null, ConfigServlet.j, "取消", "去打开", new sss(this), new sst(this)).show();
        return;
      }
    }
    catch (Exception paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushOpenNotify", 2, "popOpenMsgNotifation, exception: " + paramBoolean.getStackTrace());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ssr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */