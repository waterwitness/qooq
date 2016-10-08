import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.GVideoUpdateUtil.OnGVideoUpdateListener;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ofd
  implements GVideoUpdateUtil.OnGVideoUpdateListener
{
  public ofd(VideoStatusTipsBar paramVideoStatusTipsBar, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ofd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */