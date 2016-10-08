import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qsc
  implements Runnable
{
  public qsc(DynamicAvatarDownloadManager paramDynamicAvatarDownloadManager, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long).append("#").append(0);
    BaseApplicationImpl.a().getSharedPreferences("dynamic_avatar", 4).edit().putString("dynamic_load_count_one_day", localStringBuilder.toString()).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */