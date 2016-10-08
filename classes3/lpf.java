import android.os.Message;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.List;
import mqq.os.MqqHandler;

public class lpf
  implements Runnable
{
  public lpf(IndividuationSetActivity paramIndividuationSetActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilList.clear();
    this.a.jdField_b_of_type_JavaUtilList.clear();
    this.a.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = IndividuationSetActivity.a(this.a, 100003);
    if (this.a.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    }
    this.a.c = IndividuationSetActivity.a(this.a, 100006);
    if (this.a.c.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.c);
    }
    this.a.d = IndividuationSetActivity.a(this.a, 100002);
    if (this.a.d.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.d);
    }
    this.a.e = IndividuationSetActivity.a(this.a, 100001);
    if (this.a.e.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.e);
    }
    this.a.f = IndividuationSetActivity.a(this.a, 100011);
    if (this.a.f.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.f);
    }
    this.a.g = IndividuationSetActivity.a(this.a, 100012);
    if (this.a.g.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.g);
    }
    this.a.h = IndividuationSetActivity.a(this.a, 100020);
    if (this.a.h.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.h);
    }
    this.a.i = IndividuationSetActivity.a(this.a, 100019);
    if (this.a.i.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.i);
    }
    this.a.j = IndividuationSetActivity.a(this.a, 100021);
    if (this.a.j.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.j);
    }
    this.a.k = IndividuationSetActivity.a(this.a, 100018);
    if (this.a.k.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.k);
    }
    this.a.m = IndividuationSetActivity.a(this.a, 100028);
    if (this.a.m.iNewFlag.get() != 0) {
      IndividuationSetActivity.a(this.a, this.a.m);
    }
    this.a.l = IndividuationSetActivity.a(this.a, 100022);
    Message localMessage = this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */