import android.util.SparseArray;
import android.widget.ProgressBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

public class vsj
  implements Runnable
{
  public vsj(AvatarWallAdapter paramAvatarWallAdapter, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.get(this.jdField_a_of_type_Int);
    if (localProgressBar != null)
    {
      AvatarWallAdapter localAvatarWallAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter;
      int i = localAvatarWallAdapter.p + 1;
      localAvatarWallAdapter.p = i;
      localProgressBar.setProgress(100 - i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */