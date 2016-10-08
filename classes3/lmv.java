import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class lmv
  implements AdapterView.OnItemSelectedListener
{
  public lmv(FriendProfileImageActivity paramFriendProfileImageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView = paramView;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(paramInt);
    this.a.a(paramAdapterView, paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */