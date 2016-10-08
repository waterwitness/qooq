import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gxd
  extends GAudioUIObserver
{
  public gxd(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Gxe != null)) {
      this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, int paramInt)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Gxe != null)) {
      this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramBoolean);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Gxe != null) {
        this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
      }
      this.a.c();
    }
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (!this.a.jdField_a_of_type_Boolean)
    {
      if (this.a.jdField_a_of_type_Gxe != null) {
        this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
      }
      this.a.c();
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Gxe != null)) {
      this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Gxe != null)) {
      this.a.jdField_a_of_type_Gxe.notifyDataSetChanged();
    }
  }
  
  protected void f(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoMembersListviewAvtivity", 2, "onCloseMemberListActivity --> RelationId = " + paramLong + "mRelationUin = " + this.a.jdField_a_of_type_Long);
    }
    if (paramLong == this.a.jdField_a_of_type_Long) {
      MultiVideoMembersListviewAvtivity.b(this.a);
    }
    super.f(paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */