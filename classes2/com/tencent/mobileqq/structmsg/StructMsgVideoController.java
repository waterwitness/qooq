package com.tencent.mobileqq.structmsg;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashSet;
import uvu;

public class StructMsgVideoController
{
  public static final int a = 1;
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static StructMsgVideoController jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgVideoController;
  public static final String a = "StructMsgVideoController";
  public static final int b = 2;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private uvu jdField_a_of_type_Uvu = new uvu(this);
  public boolean a;
  public boolean b;
  public int c;
  public boolean c;
  public boolean d;
  public boolean e = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private StructMsgVideoController()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static StructMsgVideoController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgVideoController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgVideoController == null) {
        jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgVideoController = new StructMsgVideoController();
      }
      return jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgVideoController;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) {
      return;
    }
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    int j = localAbsListView.s();
    int k = localAbsListView.t();
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgVideoController", 2, "checkPlay(): firstVisiblePositon=" + j + ", lastVisiblePositon = " + k);
    }
    int i = j;
    label70:
    Object localObject;
    boolean bool1;
    if (i <= k)
    {
      localObject = localAbsListView.getChildAt(i - j);
      if (localObject == null) {
        break label288;
      }
      localObject = (PAVideoView)((View)localObject).findViewById(2131296577);
      if (localObject == null) {
        break label249;
      }
      ((PAVideoView)localObject).getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
      if (((PAVideoView)localObject).getHeight() != jdField_a_of_type_AndroidGraphicsRect.height()) {
        break label213;
      }
      bool1 = true;
      label127:
      boolean bool2 = a(((PAVideoView)localObject).getContext(), ((PAVideoView)localObject).jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgVideoController", 2, "visibilePosition  = " + i + ", completeVisible = " + bool1 + ", canPlay = " + bool2);
      }
      if (!bool2) {
        break label242;
      }
      if (!bool1) {
        break label219;
      }
      ((PAVideoView)localObject).c();
    }
    for (;;)
    {
      i += 1;
      break label70;
      break;
      label213:
      bool1 = false;
      break label127;
      label219:
      localObject = ((PAVideoView)localObject).a();
      if ((localObject != null) && (!((QQLiveDrawable)localObject).isPaused()))
      {
        ((QQLiveDrawable)localObject).pause();
        continue;
        label242:
        ((PAVideoView)localObject).a();
        continue;
        label249:
        if (QLog.isColorLevel())
        {
          QLog.e("StructMsgVideoController", 2, "visiblePosition  = " + i + ", videoView = null");
          continue;
          label288:
          if (QLog.isColorLevel()) {
            QLog.e("StructMsgVideoController", 2, "visiblePosition  = " + i + ", item = null");
          }
        }
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      if (QLog.isColorLevel()) {
        QLog.e("StructMsgVideoController", 2, "handleNetChangeConfirm(): mConfimDlg.isShowing, just return.");
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("StructMsgVideoController", 2, "handleNetChangeConfirm(): mListView == null, just return.");
      return;
      AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
      int j = localAbsListView.s();
      int k = localAbsListView.t();
      localArrayList = new ArrayList();
      int i = j;
      while (i <= k)
      {
        Object localObject = localAbsListView.getChildAt(i - j);
        if (localObject != null)
        {
          localObject = (PAVideoView)((View)localObject).findViewById(2131296577);
          if (localObject != null)
          {
            QQLiveDrawable localQQLiveDrawable = ((PAVideoView)localObject).a();
            if ((localQQLiveDrawable != null) && (!localQQLiveDrawable.isPaused())) {
              localArrayList.add(localObject);
            }
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgVideoController", 2, "handleNetChangeConfirm(): firstVisiblePositon=" + j + ", lastVisiblePositon = " + k + ", playingListSize = " + localArrayList.size());
      }
    } while (localArrayList.size() <= 0);
    QQLiveImage.pauseAll();
  }
  
  public void a()
  {
    if (!a()) {}
    do
    {
      return;
      this.jdField_a_of_type_Uvu.removeMessages(1);
      this.jdField_a_of_type_Uvu.sendEmptyMessageDelayed(1, 200L);
    } while (!QLog.isColorLevel());
    QLog.d("StructMsgVideoController", 2, "#requestPlayCheck():# ");
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet == null) {
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    }
    if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgVideoController", 2, "addAllowMsgInXG(): seq =" + paramLong);
    }
  }
  
  public void a(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    if (NetworkUtils.isMobileConnected(BaseApplication.getContext())) {
      b(paramStructMsgForGeneralShare.message.uniseq);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (!a()) {
      return;
    }
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("StructMsgVideoController", 2, "onSrollStateChanged(): <<==== SCROLL_STATE_IDLE");
      }
      this.e = true;
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StructMsgVideoController", 2, "onSrollStateChanged(): SCROLL_STATE_SCROLL =====>>");
    }
    this.e = false;
    QQLiveImage.pauseAll();
  }
  
  public boolean a()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgVideoController", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 8) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(localObject[7]) != 0) {
          continue;
        }
        this.b = false;
        if (Integer.parseInt(localObject[9]) != 0) {
          continue;
        }
        this.jdField_c_of_type_Boolean = false;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.jdField_c_of_type_Boolean = true;
        continue;
      }
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgVideoController", 2, "isAllowDPC(): mDPCAllow =" + this.b + ", mEnbleAutoPlayInNotPAAIO = " + this.jdField_c_of_type_Boolean);
      }
      return this.b;
      this.b = true;
    }
  }
  
  public boolean a(Context paramContext, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if (NetworkUtils.isWifiConnected(paramContext)) {
      if ((!this.jdField_c_of_type_Boolean) && (!b()))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsgVideoController", 2, "allowPlay(): isWifiConnected, seq =" + paramLong + ", allowPlayInNotPAAIO=" + false);
          bool1 = bool2;
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          return true;
          bool1 = bool2;
        } while (!NetworkUtils.isMobileConnected(paramContext));
        bool1 = bool2;
      } while (this.jdField_a_of_type_JavaUtilHashSet == null);
      bool2 = this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong));
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("StructMsgVideoController", 2, "allowPlay(): isMobileConnected, seq =" + paramLong + ", contain=" + bool2);
    return bool2;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("StructMsgVideoController", 2, "onNetWifi2Mobile(): mApp == null || mListView == null || mContext == null, just return.");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("StructMsgVideoController", 2, "onNetWifi2Mobile(): isChatting = false, just return.");
    return;
    this.jdField_a_of_type_Uvu.removeMessages(2);
    this.jdField_a_of_type_Uvu.sendEmptyMessage(2);
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(Long.valueOf(paramLong));
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgVideoController", 2, "removeAllowMsgInXG(): seq =" + paramLong);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null)
    {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_JavaUtilHashSet = null;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
    this.e = true;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.d = false;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgVideoController", 2, "...destroy()...");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgVideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */