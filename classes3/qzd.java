import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

public class qzd
  extends LBSObserver
{
  public qzd(ConditionSearchFriendActivity paramConditionSearchFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Object localObject = null;
    if (paramBoolean) {
      localObject = paramLBSInfo.a();
    }
    if (localObject != null)
    {
      paramLBSInfo = (LBSInfo)localObject;
      if (localObject.length == 4) {}
    }
    else
    {
      paramLBSInfo = new String[4];
      paramLBSInfo[0] = "-1";
      paramLBSInfo[1] = "-1";
      paramLBSInfo[2] = "-1";
      paramLBSInfo[3] = "-1";
    }
    if (!"-1".equals(paramLBSInfo[0]))
    {
      paramLBSInfo[3] = "0";
      this.a.a.a(paramLBSInfo);
      if (this.a.jdField_b_of_type_Boolean)
      {
        localObject = this.a.a.b(paramLBSInfo);
        this.a.a.a(0, (String)localObject);
        this.a.a.b(paramLBSInfo);
        this.a.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.a.a.b((String)localObject));
      }
      ConditionSearchFriendActivity.a(this.a, 1);
      ConditionSearchFriendActivity.a(this.a);
      this.a.c = true;
      this.a.d = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetUserLocation|isSuccess : " + paramBoolean + ", mIsFirstReqLocation : " + this.a.jdField_b_of_type_Boolean + ", locationCodes[0] : " + paramLBSInfo[0]);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */