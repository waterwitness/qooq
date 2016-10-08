import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class gid
  extends GAudioUIObserver
{
  public gid(GaInviteActivity paramGaInviteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    super.a();
    this.a.f();
  }
  
  protected void a(long paramLong, int paramInt)
  {
    super.c(paramLong);
    if (((this.a.c == paramLong) || (0L == paramLong)) && ((!this.a.e) || (paramInt == 1) || (paramInt == 4)))
    {
      if (this.a.e) {
        ReportController.b(null, "CliOper", "", "", "0X8005575", "0X8005575", 0, 0, "", "", "", "");
      }
      this.a.finish();
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.c == paramLong) && (this.a.jdField_b_of_type_JavaLangString.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).a).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.finish();
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GaInviteActivity.jdField_a_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.c);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.c)) {
      this.a.finish();
    }
  }
  
  protected void g(long paramLong)
  {
    if (this.a.c != paramLong) {
      this.a.c();
    }
    this.a.finish();
  }
  
  protected void h(long paramLong)
  {
    if (this.a.c == paramLong) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */