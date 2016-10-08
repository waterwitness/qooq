import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardUtil;

public class nrm
  implements Runnable
{
  public nrm(TroopRewardItemBuilder paramTroopRewardItemBuilder, String paramString, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = TroopRewardUtil.a(this.jdField_a_of_type_JavaLangString, 200, 200);
      if (localBitmap == null) {
        return;
      }
      localBitmap = TroopRewardUtil.a(localBitmap);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.put(this.jdField_a_of_type_JavaLangString, localBitmap);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.b.post(new nrn(this, localBitmap));
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */