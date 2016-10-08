import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gtx
  extends GAudioUIObserver
{
  public gtx(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioMemberMicChanged-->uin=" + paramLong + ",isMicOff=" + paramBoolean);
    }
    GAudioMembersCtrlActivity.c(this.a, new gua(this, paramLong, paramInt1, paramInt2, paramBoolean));
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.a != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a + " ,isQQUser = " + paramBoolean);
      }
      return;
    }
    super.a(paramLong1, paramLong2, paramBoolean);
    this.a.a(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.a.a != paramLong1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "onMemberJoin,wrong group uin.GroupUin = " + paramLong1 + " ,mGroupId = " + this.a.a + " ,isQQUser = " + paramBoolean2);
      }
      return;
    }
    this.a.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2);
    if (paramBoolean1) {}
    for (int i = 42;; i = 43)
    {
      this.a.a(paramLong, 2, paramBoolean2, i);
      return;
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    GAudioMembersCtrlActivity.d(this.a, new gub(this, paramArrayList));
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GAudioMembersCtrlActivity", 2, "onGAudioRoomMicModeChanged-->uin=" + paramLong + ",isRoomMicOff=" + paramBoolean);
    }
    GAudioMembersCtrlActivity.b(this.a, new gtz(this));
  }
  
  protected void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onDestroyUI");
    }
    this.a.finish();
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.a.finish();
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onUpdatePstnInfo --> Start");
    }
    GAudioMembersCtrlActivity.a(this.a, new gty(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gtx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */