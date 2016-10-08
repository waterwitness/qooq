import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class wej
  extends QQCustomDialog
{
  public wej(ColorRingPlayer paramColorRingPlayer, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */