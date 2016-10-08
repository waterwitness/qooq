import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class gvl
  extends GAudioUIObserver
{
  public gvl(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onServiceConnected");
    }
    super.a();
    if (this.a.jdField_b_of_type_Long != 0L)
    {
      int i = this.a.jdField_c_of_type_Int;
      Object localObject = String.valueOf(this.a.jdField_b_of_type_Long);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject);
      if ((this.a.jdField_a_of_type_ArrayOfLong != null) && (this.a.jdField_a_of_type_ArrayOfLong.length == 0) && (this.a.jdField_b_of_type_Int == 0))
      {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject != null))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
          i = ConfigSystemImpl.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
          this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false, i, 1);
        }
      }
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onInviteUserNotice --> Count = " + paramInt + " ,firstName = " + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_Gwg.a(paramInt, paramString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_Gwg, 500L);
    }
  }
  
  protected void a(int paramInt, ArrayList paramArrayList)
  {
    super.a(paramInt, paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onUpdatePstnInfo --> Start ");
    }
    String str1;
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      if (paramArrayList == null) {
        break label465;
      }
      if (((paramArrayList == null) || (paramArrayList.size() == 0)) && (QLog.isColorLevel())) {
        QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "onPstnErrorMsg --> List is null Or Empty. Type = " + paramInt);
      }
      str1 = new String();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((AVPhoneUserInfo)localIterator.next()).telInfo.mobile;
        str2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(str2);
        str1 = str1 + str2 + " ";
      }
      switch (paramInt)
      {
      default: 
        paramArrayList = null;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a.put(Integer.valueOf(paramInt), paramArrayList);
      if (!this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b()) {
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.i();
      }
      label465:
      do
      {
        return;
        if (paramArrayList.size() == 1)
        {
          paramArrayList = str1 + "的电话号码被呼叫限制";
          break;
        }
        float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
        str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.j, f);
        paramArrayList = str1 + "等" + paramArrayList.size() + "人电话号码被呼叫限制";
        break;
        if (paramArrayList.size() == 1)
        {
          paramArrayList = "被叫次数已达上限，" + str1 + "无法呼叫";
          break;
        }
        f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
        str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.j, f);
        paramArrayList = "被叫次数已达上限，" + str1 + "等" + paramArrayList.size() + "人无法呼叫";
        break;
        switch (paramInt)
        {
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "onPstnErrorMsg --> type is Wrong. Type = " + paramInt);
      return;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363626);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363627);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363628);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363629);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363624);
      continue;
      paramArrayList = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363625);
      continue;
      paramArrayList = "剩余时长不足，部分用户呼叫失败。";
      continue;
      paramArrayList = "呼叫手机失败，请先购买时长。";
      continue;
      paramArrayList = "呼叫手机失败，请稍候再试。";
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onCreateRoomSuc-->GroupID = " + paramLong);
    }
    super.a(paramLong);
    this.a.n();
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().aj = true;
    if ((this.a.jdField_d_of_type_Boolean) && (this.a.jdField_d_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gvn(this), 500L);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
      this.a.Q();
    }
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    String str1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.a.jdField_b_of_type_Long), this.a.jdField_d_of_type_Int);
    float f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493966);
    String str2;
    if (i == 1)
    {
      paramArrayOfString = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363500);
      if (paramString.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
        break label301;
      }
      str2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.a.jdField_b_of_type_Long), this.a.jdField_d_of_type_Int);
      f = this.a.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493971);
      str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.j, f);
      str2 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str2, this.a.j, f);
    }
    for (this.a.jdField_c_of_type_JavaLangString = (str2 + this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363497) + str1 + paramArrayOfString);; this.a.jdField_c_of_type_JavaLangString = (this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363498) + str1 + paramArrayOfString))
    {
      this.a.b(Long.valueOf(paramString).longValue(), 82, true, -1);
      return;
      paramArrayOfString = String.format(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363499), new Object[] { Integer.valueOf(i) });
      break;
      label301:
      str1 = UITools.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.a.j, f);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x == 1))
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
          this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.d();
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
        }
        this.a.a(0L, 11, true, 0);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
        }
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiPstnCallbackWaitingUi.e();
      }
    } while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x != 1));
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setMultiPstnCallback(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(8);
    }
    this.a.a(0L, 12, true, 0);
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    this.a.a(paramInt);
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onEnterRoomSuc-->GroupID=" + paramLong);
    }
    super.b(paramLong);
    this.a.n();
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gvs(this.a), 500L);
    if ((this.a.jdField_d_of_type_Boolean) && (this.a.jdField_d_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gvo(this), 600L);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f) {
      this.a.Q();
    }
    this.a.Z();
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onInviteSomeoneEnter-->firstUin = " + paramLong + " , length = " + paramInt);
    }
    super.b(paramLong, paramInt);
    this.a.f = paramInt;
    this.a.b(paramLong, 68, true, -1);
  }
  
  protected void c()
  {
    super.c();
    if (this.a.jdField_d_of_type_Int != 2) {}
    while (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(3)) {
      return;
    }
    int i = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(Long.toString(this.a.jdField_b_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onDiscussionMembersChange-->Discuss Num = " + i);
    }
    if (i >= 100)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363376));
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(3, true);
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(3, true);
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(3, this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363399));
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
    if (paramInt > 0)
    {
      this.a.f(paramInt);
      return;
    }
    this.a.J();
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new gvm(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "onUpdatePstnInfo-->Can not get AVActivity");
  }
  
  protected void e()
  {
    super.e();
    this.a.J();
  }
  
  protected void f()
  {
    super.f();
    this.a.aa();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */