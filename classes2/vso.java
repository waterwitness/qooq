import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.widget.GridView;

public class vso
  implements Runnable
{
  public vso(AvatarWallAdapter paramAvatarWallAdapter, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.setNumColumns(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vso.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */