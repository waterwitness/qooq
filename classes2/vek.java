import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.OnClickSayHelloListener;
import com.tencent.mobileqq.troop.data.NearbyMember;

public class vek
  implements View.OnClickListener
{
  public vek(NearbyMemberAdapter paramNearbyMemberAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof NearbyMember)))
    {
      paramView = (NearbyMember)paramView.getTag();
      this.a.a.a(String.valueOf(paramView.jdField_a_of_type_Long), paramView.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */