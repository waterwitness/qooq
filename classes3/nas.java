import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nas
  extends CardObserver
{
  public nas(VisitorsActivity paramVisitorsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.a())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.a(paramString2, paramInt1, true);
          return;
        }
        this.a.b(paramString2, paramInt1, true);
        return;
      }
    } while (paramInt2 != 0);
    this.a.b(Long.parseLong(paramString2));
  }
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_b_of_type_JavaUtilArrayList;
      if (this.a.jdField_b_of_type_Boolean) {
        paramString = new ArrayList();
      }
      this.a.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_b_of_type_Nbh;
      if (this.a.jdField_b_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramArrayOfByte = paramString;
        if (paramArrayList != null) {
          paramArrayOfByte = LbsPortraitUtil.a(paramString, paramArrayList);
        }
        this.a.b(paramArrayOfByte, paramLong1);
        return;
      }
    }
    this.a.e();
  }
  
  protected void a(boolean paramBoolean, String arg2, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + paramBoolean + ";uin=" + ??? + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList1 != null) {
        QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + paramArrayList1.size());
      }
    }
    if (!this.a.app.a().equals(???)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.j = paramInt1;
      this.a.k = paramInt2;
      if (paramLong1 == 0L) {}
      for (;;)
      {
        synchronized (VisitorsActivity.jdField_b_of_type_JavaLangObject)
        {
          VisitorsActivity.a(this.a, paramArrayList2);
          this.a.a(VisitorsActivity.c, this.a.j);
          this.a.a(VisitorsActivity.d, this.a.k);
          ??? = this.a.jdField_a_of_type_JavaUtilArrayList;
          if (this.a.jdField_a_of_type_Boolean)
          {
            this.a.app.a().c(AppConstants.ao, 1001);
            ??? = new ArrayList();
          }
          this.a.jdField_a_of_type_Long = paramLong2;
          paramArrayList2 = this.a.jdField_a_of_type_Nbh;
          if (this.a.jdField_a_of_type_Long != -1L)
          {
            paramBoolean = true;
            paramArrayList2.a(paramBoolean);
            paramArrayList2 = ???;
            if (paramArrayList1 != null) {
              paramArrayList2 = LbsPortraitUtil.a(???, paramArrayList1);
            }
            this.a.a(paramArrayList2, paramLong1);
            return;
          }
        }
        paramBoolean = false;
      }
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */