import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;

class tix
  implements Runnable
{
  tix(tiw paramtiw, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Tiw.a.l();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Tiw.a.a(2, "编辑资料成功");
      this.jdField_a_of_type_Tiw.a.a(true);
      this.jdField_a_of_type_Tiw.a.finish();
      NearbySPUtil.a(this.jdField_a_of_type_Tiw.a.app.getAccount(), "nearby_need_show_guide", Boolean.valueOf(false));
      return;
    }
    this.jdField_a_of_type_Tiw.a.a(1, "更新交友资料失败，请重试。");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */