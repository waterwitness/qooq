package com.tencent.biz.now;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import hkh;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NowVideoController
{
  public static final int a = 1;
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static NowVideoController jdField_a_of_type_ComTencentBizNowNowVideoController;
  public static final String a = "NowVideoController";
  public static final int b = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new hkh(this, Looper.getMainLooper());
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public boolean b = true;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static NowVideoController a()
  {
    if (jdField_a_of_type_ComTencentBizNowNowVideoController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizNowNowVideoController == null) {
        jdField_a_of_type_ComTencentBizNowNowVideoController = new NowVideoController();
      }
      return jdField_a_of_type_ComTencentBizNowNowVideoController;
    }
    finally {}
  }
  
  private void d()
  {
    QLog.d("NowVideoController", 2, "Check play()");
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 0) {
      return;
    }
    AbsListView localAbsListView = this.jdField_a_of_type_ComTencentWidgetAbsListView;
    int k = localAbsListView.s();
    int m = localAbsListView.t();
    int i = k;
    label46:
    Object localObject;
    int j;
    if (i <= m)
    {
      localObject = localAbsListView.getChildAt(i - k);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131296578);
        if ((localObject instanceof NowVideoView))
        {
          localObject = (NowVideoView)localObject;
          ((NowVideoView)localObject).getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
          ((NowVideoView)localObject).getHeight();
          if (jdField_a_of_type_AndroidGraphicsRect.height() <= 0) {
            break label138;
          }
          j = 1;
          label109:
          if (!a(((NowVideoView)localObject).getContext(), (NowVideoView)localObject)) {
            break label167;
          }
          if (j == 0) {
            break label144;
          }
          ((NowVideoView)localObject).a(true);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label138:
      j = 0;
      break label109;
      label144:
      localObject = ((NowVideoView)localObject).a();
      if ((localObject != null) && (!((QQLiveDrawable)localObject).isPaused()))
      {
        ((QQLiveDrawable)localObject).pause();
        continue;
        label167:
        ((NowVideoView)localObject).a();
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 200L);
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "#requestPlayCheck():# ");
    }
  }
  
  public void a(NowVideoView paramNowVideoView)
  {
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramNowVideoView));
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      paramQQAppInterface = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramQQAppInterface.a();
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = true;
      d();
      return;
    }
    this.b = false;
    QQLiveImage.pauseAll();
  }
  
  public boolean a(Context paramContext, NowVideoView paramNowVideoView)
  {
    return NetworkUtil.i(paramContext);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((NowVideoView)localWeakReference.get()).e();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentWidgetAbsListView = null;
    this.b = true;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\NowVideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */