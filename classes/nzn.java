import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class nzn
  extends NearbyRelevantObserver
{
  public nzn(NearbyChatPie paramNearbyChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a.al, 4, "onAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    if (!"tag_nearby_chat".equals(paramString1)) {}
    while ((TextUtils.isEmpty(paramString2)) || (this.a.a == null)) {
      return;
    }
    this.a.an();
    this.a.a.setText(paramString2);
    this.a.a.selectAll();
    this.a.am = paramString2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */