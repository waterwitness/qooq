package cooperation.secmsg.ipc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UserFaceDrawableResp
  extends BaseResp
{
  public static final String a = "UserFaceDrawableResp.mBitmap";
  public static final String b = "UserFaceDrawableResp.mUin";
  public static final String c = "UserFaceDrawableResp.mUserName";
  public Bitmap a;
  public String d;
  public String e;
  
  public UserFaceDrawableResp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putParcelable("UserFaceDrawableResp.mBitmap", this.a);
    paramBundle.putString("UserFaceDrawableResp.mUin", this.d);
    paramBundle.putString("UserFaceDrawableResp.mUserName", this.e);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.a = ((Bitmap)paramBundle.getParcelable("UserFaceDrawableResp.mBitmap"));
    this.d = paramBundle.getString("UserFaceDrawableResp.mUin");
    this.e = paramBundle.getString("UserFaceDrawableResp.mUserName");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\secmsg\ipc\UserFaceDrawableResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */