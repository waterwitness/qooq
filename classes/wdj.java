import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ShortcutUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class wdj
  implements Runnable
{
  public wdj(Context paramContext, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = ShortcutUtils.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_AndroidContentContext.getString(2131367251) });
    if (QLog.isColorLevel()) {
      QLog.d(ShortcutUtils.a(), 2, "createShortcut " + bool + ", " + ShortcutUtils.a());
    }
    if (bool)
    {
      if (ShortcutUtils.b() < 3) {
        ThreadManager.b().postDelayed(this, 1000L);
      }
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.setClassName(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367251));
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2130838592));
    localIntent2.putExtra("duplicate", false);
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast(localIntent2, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */