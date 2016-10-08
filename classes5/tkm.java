import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class tkm
  implements Runnable
{
  public tkm(NearbyVisitorListActivity paramNearbyVisitorListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.isFinishing()) || (this.a.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) || (TextUtils.isEmpty(this.a.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a()))) {
      return;
    }
    Object localObject = (ArrayList)this.a.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().createEntityManager().a(StrangerInfo.class);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.a.a.clear();
      this.a.a.addAll((Collection)localObject);
    }
    localObject = NearbySPUtil.a("nearby_visitor_file", this.a.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 0);
    this.a.jdField_b_of_type_Long = ((SharedPreferences)localObject).getLong("sp_nearby_total_visitor", 0L);
    this.a.c = ((SharedPreferences)localObject).getLong("sp_nearby_new_visitor", 0L);
    this.a.d = ((SharedPreferences)localObject).getLong("sp_nearby_his_visitor", 0L);
    this.a.runOnUiThread(new tkn(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tkm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */