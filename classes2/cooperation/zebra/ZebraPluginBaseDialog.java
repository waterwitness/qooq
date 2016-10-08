package cooperation.zebra;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ZebraPluginBaseDialog
  extends Dialog
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  
  public ZebraPluginBaseDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\zebra\ZebraPluginBaseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */