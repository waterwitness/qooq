import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ste
  extends HotChatObserver
{
  public ste(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList, Long paramLong)
  {
    if (!paramLong.equals(this.a.jdField_a_of_type_JavaLangLong)) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.a(new stf(this, paramList), 5, null, true);
      return;
    }
    this.a.stopTitleProgress();
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    switch (paramInt)
    {
    default: 
      QQToast.a(this.a, 1, "拉取热聊房间成员失败", 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    case 1: 
      QQToast.a(this.a, 1, this.a.getString(2131364075), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    QQToast.a(this.a, 1, this.a.getString(2131364076), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatMemberListActivity", 2, "onKickHotChatMember.isSuccess=" + paramBoolean + ",groupuin=" + paramString1 + ",result=" + paramInt + ",memberuin=" + paramString2 + ",strError=" + paramString3);
    }
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      this.a.f = "";
      this.a.jdField_b_of_type_JavaUtilArrayList.add(paramString2);
      paramInt = 0;
      paramBoolean = false;
      if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (sts)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
        boolean bool;
        if (paramString1 == null) {
          bool = paramBoolean;
        }
        for (;;)
        {
          paramInt += 1;
          paramBoolean = bool;
          break;
          if (paramString1.jdField_a_of_type_JavaLangString.equals(paramString2))
          {
            this.a.jdField_a_of_type_JavaUtilList.remove(paramInt);
            bool = paramBoolean;
          }
          else
          {
            bool = paramBoolean;
            if (paramString1.jdField_a_of_type_Int == 0)
            {
              bool = paramBoolean;
              if (!paramBoolean) {
                bool = true;
              }
            }
          }
        }
      }
      if (!paramBoolean)
      {
        this.a.jdField_b_of_type_Boolean = paramBoolean;
        HotChatMemberListActivity.a(this.a);
      }
      if (this.a.jdField_a_of_type_Sty != null) {
        this.a.jdField_a_of_type_Sty.notifyDataSetChanged();
      }
      QQToast.a(this.a, "删除热聊成员成功", 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    QQToast.a(this.a, "删除热聊成员失败", 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    if ((paramBoolean2) || (paramInt1 != 3)) {}
    while ((this.a.j != 1) || (paramString1 == null) || (paramString1.length() == 0) || (!paramString1.equalsIgnoreCase(this.a.jdField_b_of_type_JavaLangString)) || (paramString2 == null) || (paramString2.length() == 0) || (!paramString2.equals(this.a.g)) || (paramInt3 != this.a.k)) {
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatMemberListActivity", new Object[] { "onUpdatePttHotChatSeatsInfo", Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt2), paramString1, paramString2, Integer.valueOf(paramInt3), paramString3 });
    }
    this.a.c();
    if (paramBoolean1)
    {
      this.a.a(true, paramString2, "");
      return;
    }
    if (HotChatUtil.a(paramInt2))
    {
      if (paramString3 != null)
      {
        paramString1 = paramString3;
        if (paramString3.length() != 0) {}
      }
      else
      {
        paramString1 = "操作失败，座位已经被占了~";
      }
      this.a.a(false, "", paramString1);
      return;
    }
    if (paramString3 != null)
    {
      paramString1 = paramString3;
      if (paramString3.length() != 0) {}
    }
    else
    {
      paramString1 = "操作失败，请重试。";
    }
    this.a.a(1, paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ste.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */