import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardUtil;

public class nry
  implements FileManagerUtil.IGetVideoCallback
{
  public nry(TroopRewardItemBuilder paramTroopRewardItemBuilder, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      paramBitmap = TroopRewardUtil.a(paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.b.post(new nrz(this, paramBitmap));
      return;
    }
    catch (OutOfMemoryError paramBitmap) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */