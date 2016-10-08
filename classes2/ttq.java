import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PrepareView;
import com.tencent.mobileqq.portal.ProgressViewRed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;

public class ttq
  implements HongBaoListViewListener
{
  public ttq(ConversationHongBao paramConversationHongBao)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "tryCountdown" + this.a.k);
    }
    if (this.a.k == 3) {
      this.a.b(-1L);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    paramInt1 = -paramInt2;
    switch (this.a.k)
    {
    }
    while (this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.t)
    {
      this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.d = true;
      label64:
      return;
      if (paramInt1 <= 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.a();
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqPortalPrepareView.b();
        continue;
        if (paramInt1 <= 0)
        {
          this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.G();
          this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(false);
          continue;
          if (paramInt1 <= 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
            continue;
            if (paramInt1 <= this.a.h)
            {
              this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(255);
              this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setVisibility(0);
              this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.d = (-this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j);
              this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a();
            }
            else
            {
              if (-paramInt2 > this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j) {
                break label462;
              }
            }
          }
        }
      }
    }
    label462:
    for (paramInt1 = -(int)((this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j + paramInt2) * 1.0F / this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j * this.a.h);; paramInt1 = 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.d = paramInt1;
      paramInt1 = this.a.h * 2;
      if (-paramInt2 <= paramInt1)
      {
        paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.a.h * 255.0F);
        this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(paramInt1);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(true);
        break;
        this.a.jdField_a_of_type_ComTencentMobileqqPortalProgressViewRed.setAlpha(0);
      }
      paramInt1 = this.a.h * 2;
      switch (this.a.k)
      {
      case 4: 
      default: 
        return;
      case 2: 
      case 5: 
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.d = true;
        return;
      }
      if ((paramInt2 >= 0) || (paramInt2 < -paramInt1)) {
        break label64;
      }
      paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / paramInt1 * 255.0F);
      return;
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchDown, " + this.a.k);
    }
  }
  
  public boolean a()
  {
    if (this.a.k == 4)
    {
      localObject = this.a;
      ((ConversationHongBao)localObject).j += 1;
      localObject = (PortalManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      ((PortalManager)localObject).a();
      l1 = System.currentTimeMillis();
      if (this.a.j == 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.a.j, this.a.jdField_a_of_type_JavaLangString);
        this.a.e = l1;
        ((PortalManager)localObject).a(this.a.j);
      }
    }
    label254:
    while (this.a.k != 5) {
      for (;;)
      {
        Object localObject;
        long l1;
        return false;
        long l2 = l1 - this.a.e;
        this.a.e = l1;
        if (l2 > 600L)
        {
          this.a.j = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(1);
        }
        for (;;)
        {
          if (this.a.e - this.a.d <= 400L) {
            break label254;
          }
          this.a.d = 0L;
          this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.a(this.a.j, this.a.jdField_a_of_type_JavaLangString);
          ((PortalManager)localObject).b(0);
          break;
          if (l2 > 400L) {
            this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(2);
          } else {
            this.a.jdField_a_of_type_ComTencentMobileqqPortalFormalView.setHBSpeed(3);
          }
        }
      }
    }
    ((PortalManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78)).a(this.a.jdField_a_of_type_AndroidAppActivity);
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onHongBaoPendantClick" + this.a.k);
    }
    switch (this.a.k)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j / 2);
    }
    for (;;)
    {
      PortalManager localPortalManager = (PortalManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(78);
      if (localPortalManager != null) {}
      try
      {
        localPortalManager.i();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.a(this.a.g);
    }
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onTouchRelease, " + this.a.k);
    }
    int i = paramHongBaoListView.getScrollY();
    if (-i > this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j / 2)
    {
      paramHongBaoListView = (PortalManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getAppInterface().getManager(78);
      if (paramHongBaoListView != null) {
        paramHongBaoListView.g();
      }
    }
    switch (this.a.k)
    {
    default: 
      if ((-i < this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j / 2) && (-i > 0))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      }
      break;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 2000L);
      return;
      if ((-i < this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.j / 2) && (-i > 0))
      {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.a.h);
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.d(this.a.jdField_a_of_type_ComTencentWidgetHongBaoListView.c);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */