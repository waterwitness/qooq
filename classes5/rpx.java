import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class rpx
  implements FMDialogUtil.FMDialogInterface
{
  rpx(rpv paramrpv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    UniformDownloadActivity.a(this.a.a);
  }
  
  public void b()
  {
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */