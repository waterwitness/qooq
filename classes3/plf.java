import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class plf
  implements DialogInterface.OnClickListener
{
  public plf(ShortVideoPreviewActivity paramShortVideoPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = ShortVideoPreviewActivity.a(this.a);
    paramDialogInterface = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    Intent localIntent = new Intent();
    localIntent.setClassName((String)localObject, paramDialogInterface);
    localIntent.addFlags(603979776);
    localIntent.putExtra("file_send_path", this.a.d);
    localIntent.putExtra("file_send_size", this.a.a);
    localIntent.putExtra("file_send_duration", this.a.b);
    localIntent.putExtra("file_source", this.a.c);
    this.a.startActivity(localIntent);
    ShortVideoPreviewActivity.a(this.a);
    localObject = new Intent("key_video_select_confirm_ok_click");
    ((Intent)localObject).putExtra("className", paramDialogInterface);
    this.a.sendBroadcast((Intent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\plf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */