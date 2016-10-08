import SummaryCard.RespCondSearch;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class pvu
  extends FriendListObserver
{
  public pvu(ConditionSearchManager paramConditionSearchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "searchseq = " + this.a.a + " | seq = " + paramLong);
    }
    if (this.a.a != paramLong) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      paramObject = (RespCondSearch)paramObject;
      ConditionSearchManager localConditionSearchManager = this.a;
      if (((RespCondSearch)paramObject).cEndFlag == 0)
      {
        paramBoolean = true;
        localConditionSearchManager.d = paramBoolean;
        this.a.u = ((RespCondSearch)paramObject).iPage;
        this.a.jdField_b_of_type_Long = ((RespCondSearch)paramObject).dwSessionID;
        if (this.a.jdField_b_of_type_JavaUtilList != null) {
          break label313;
        }
        this.a.jdField_b_of_type_JavaUtilList = ((RespCondSearch)paramObject).vUserList;
      }
      for (;;)
      {
        if ((this.a.v >= 2) || ((this.a.jdField_b_of_type_JavaUtilList != null) && (this.a.jdField_b_of_type_JavaUtilList.size() >= 10)) || (!this.a.d)) {
          break label353;
        }
        paramObject = this.a;
        ((ConditionSearchManager)paramObject).v += 1;
        ((FriendListHandler)ConditionSearchManager.a(this.a).a(1)).a(this.a.a, this.a.u + 1, this.a.jdField_b_of_type_Long, this.a.k, this.a.p, this.a.q, this.a.r, this.a.f, this.a.g, this.a.s, this.a.t, paramInt2);
        return;
        paramBoolean = false;
        break;
        label313:
        if ((((RespCondSearch)paramObject).vUserList != null) && (!((RespCondSearch)paramObject).vUserList.isEmpty())) {
          this.a.jdField_b_of_type_JavaUtilList.addAll(((RespCondSearch)paramObject).vUserList);
        }
      }
      label353:
      if ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < 6)) {
        this.a.d = false;
      }
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.d, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      this.a.d = false;
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.d, paramInt2);
      return;
    }
    if (this.a.v == 0)
    {
      this.a.a(false, null, this.a.d, paramInt2);
      return;
    }
    this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.d, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */