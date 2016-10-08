import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.troop.widget.RadarMembersView.OnScaleListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class vdq
  implements RadarMembersView.OnScaleListener
{
  public vdq(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(double paramDouble, HashSet paramHashSet)
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.a.a.size();
    int i = 0;
    if (i < j)
    {
      NearbyMember localNearbyMember = (NearbyMember)this.a.a.get(i);
      if ((!paramHashSet.contains(Long.valueOf(localNearbyMember.a))) || ((this.a.jdField_b_of_type_Int != 2) && (this.a.jdField_b_of_type_Int != localNearbyMember.e))) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localNearbyMember);
      }
    }
    this.a.jdField_b_of_type_JavaUtilList = localArrayList;
    this.a.a(paramDouble / 1000.0D);
  }
  
  public void b(double paramDouble, HashSet paramHashSet) {}
  
  public void c(double paramDouble, HashSet paramHashSet) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */