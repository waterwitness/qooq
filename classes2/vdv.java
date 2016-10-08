import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.data.NearbyMember;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.lbs.member_lbs.NeighbourInfo;

public class vdv
  implements Runnable
{
  public vdv(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.c == null) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)this.a.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    this.a.jdField_a_of_type_Double = Double.MIN_VALUE;
    Object localObject2 = this.a.c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      member_lbs.NeighbourInfo localNeighbourInfo = (member_lbs.NeighbourInfo)((Iterator)localObject2).next();
      NearbyMember localNearbyMember = new NearbyMember();
      localNearbyMember.jdField_a_of_type_Long = localNeighbourInfo.uint64_uin.get();
      localNearbyMember.c = localNeighbourInfo.double_distance.get();
      localNearbyMember.jdField_a_of_type_JavaLangString = localNeighbourInfo.str_nick.get().toStringUtf8();
      if (TextUtils.isEmpty(localNearbyMember.jdField_a_of_type_JavaLangString)) {
        localNearbyMember.jdField_a_of_type_JavaLangString = ContactUtils.f(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(localNearbyMember.jdField_a_of_type_Long));
      }
      ((TroopManager)localObject1).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(localNeighbourInfo.uint64_uin.get()), null, -100, null, null, -100, -100, -100, -100L, (byte)-100, -100L, localNeighbourInfo.double_distance.get());
      localNearbyMember.jdField_a_of_type_Double = (localNeighbourInfo.int64_latitude.get() / 1000000.0D);
      localNearbyMember.b = (localNeighbourInfo.int64_longitude.get() / 1000000.0D);
      localNearbyMember.e = localNeighbourInfo.uint32_sex.get();
      localNearbyMember.d = localNeighbourInfo.uint32_age.get();
      this.a.jdField_a_of_type_JavaUtilList.add(localNearbyMember);
      if ((localNearbyMember.c / 1000.0D * 100.0D) / 100.0D <= 10.0D) {
        localArrayList.add(localNearbyMember);
      }
      if (localNearbyMember.c > this.a.jdField_a_of_type_Double) {
        this.a.jdField_a_of_type_Double = localNearbyMember.c;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "distanceLimitedMemberList size = " + localArrayList.size());
    }
    localObject2 = this.a;
    boolean bool;
    if (localArrayList.size() == 0)
    {
      localObject1 = this.a.jdField_a_of_type_JavaUtilList;
      ((NearbyMemberActivity)localObject2).b = ((List)localObject1);
      this.a.l();
      localObject1 = this.a;
      if (localArrayList.size() == 0) {
        break label515;
      }
      bool = true;
      label468:
      ((NearbyMemberActivity)localObject1).d = bool;
      localObject1 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      if (!this.a.d) {
        break label521;
      }
    }
    label515:
    label521:
    for (int i = 1;; i = 0)
    {
      ((Message)localObject1).arg1 = i;
      ((Message)localObject1).sendToTarget();
      return;
      localObject1 = localArrayList;
      break;
      bool = false;
      break label468;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */