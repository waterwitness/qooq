import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class guw
  extends GAudioUIObserver
{
  public guw(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, int paramInt)
  {
    super.c(paramLong);
    if (this.a.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiIncomingCallsActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyInviteUI, doubleVideoMeeting, groupId:" + paramLong + ", mPeerUin:" + this.a.c);
      }
      if ((this.a.c != null) && (this.a.c.equals(String.valueOf(paramLong))))
      {
        this.a.b();
        this.a.a(paramInt);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MultiIncomingCallsActivity.jdField_a_of_type_JavaLangString, 2, "onDestroyInviteUI, groupId:" + paramLong + ", reason:" + paramInt + ", mGroupId:" + this.a.b + ",mIsScheduleMeeting:" + this.a.d);
      }
      return;
      if (((this.a.b == paramLong) || (0L == paramLong)) && ((!this.a.d) || (paramInt == 1) || (paramInt == 4))) {
        this.a.b();
      }
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.b == paramLong) && (this.a.e.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MultiIncomingCallsActivity.jdField_a_of_type_JavaLangString + ".troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_a_of_type_Long + ", mGroupId:" + this.a.b);
    }
    if ((paramLong2 == this.a.jdField_a_of_type_Long) && (paramLong1 == this.a.b)) {
      this.a.finish();
    }
  }
  
  protected void g(long paramLong)
  {
    if (this.a.b != paramLong) {
      this.a.a(0);
    }
    this.a.b();
    this.a.finish();
  }
  
  protected void h(long paramLong)
  {
    if (this.a.b == paramLong)
    {
      this.a.b();
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */