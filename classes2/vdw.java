import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.lbs.member_lbs.Location;
import tencent.im.lbs.member_lbs.NeighbourNumber;
import tencent.im.lbs.member_lbs.RspBody;

public class vdw
  extends BizTroopObserver
{
  public vdw(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString)) {
      return;
    }
    this.a.app.b(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if ((!paramBoolean) || (paramObject == null))
    {
      this.a.m();
      return;
    }
    this.a.jdField_b_of_type_Boolean = true;
    paramString = (member_lbs.RspBody)paramObject;
    paramObject = (member_lbs.NeighbourNumber)paramString.msg_neighbour_number.get();
    this.a.jdField_a_of_type_Long = ((member_lbs.NeighbourNumber)paramObject).uint64_located_number.get();
    this.a.jdField_c_of_type_JavaUtilList = paramString.rpt_msg_neighbours_info.get();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyMemberActivity.troop.nearby_mem", 2, "rsp isSuccess:" + paramBoolean + "|list size = " + this.a.jdField_c_of_type_JavaUtilList.size());
    }
    this.a.jdField_b_of_type_Double = (paramString.msg_location.int64_latitude.get() / 1000000.0D);
    this.a.jdField_c_of_type_Double = (paramString.msg_location.int64_longitude.get() / 1000000.0D);
    if ((this.a.jdField_c_of_type_JavaUtilList != null) && (this.a.jdField_c_of_type_JavaUtilList.size() > 0))
    {
      ThreadManager.a(this.a.jdField_a_of_type_JavaLangRunnable, null, false);
      return;
    }
    this.a.m();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */