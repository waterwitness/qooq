import android.content.Intent;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;

public class ybb
  extends FriendListObserver
{
  public ybb(DingdongPluginManager paramDingdongPluginManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = ContactUtils.c(DingdongPluginManager.a(this.a), paramString, false);
      if ((str != null) && (!str.equalsIgnoreCase(paramString)))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("_uin_", paramString);
        localIntent.putExtra("_nick_", str);
        DingdongPluginHelper.a(4, localIntent);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */