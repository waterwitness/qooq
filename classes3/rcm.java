import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

abstract interface rcm
{
  public static final Uri a = Uri.parse("content://qqlite");
  public static final Uri b = Uri.parse("content://qqlite/external/friendlist");
  public static final Uri c = Uri.parse("content://qqlite/external/historylist");
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */