package cooperation.c2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.BaseActivity;
import xzw;
import xzx;

public class C2BUploadImageActivity
  extends BaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "C2BUploadImageActivity";
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  public boolean c;
  
  public C2BUploadImageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = false;
    this.b = false;
    this.c = true;
  }
  
  private void a()
  {
    ActionSheet localActionSheet = ActionSheet.c(this);
    localActionSheet.c("拍照");
    localActionSheet.c("从相册选择");
    localActionSheet.d("取消");
    localActionSheet.a(new xzw(this));
    localActionSheet.a(new xzx(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(getIntent());
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", C2BUploadImageActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "cooperation.c2b");
    localIntent.setClassName("com.tencent.mobileqq", PhotoListActivity.class.getName());
    startActivity(localIntent);
    try
    {
      AlbumUtil.a(this, false, true);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    if ((QavCameraUsage.b(BaseApplicationImpl.getContext())) && (QLog.isColorLevel())) {
      QLog.d("C2BUploadImageActivity", 2, "uploadImageByTakingPhoto: camera is using!");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    this.a = true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.b) {
      return;
    }
    Object localObject = getIntent().getStringExtra("destaction");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).putExtra("photo_video_path", paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
      ((Intent)localObject).putExtra("error_code", 0);
      ((Intent)localObject).setPackage(getPackageName());
      sendBroadcast((Intent)localObject);
    }
    finish();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a)
    {
      this.a = false;
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BUploadImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */