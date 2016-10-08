package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gob;
import goc;

public class SmallScreenActivityPlugin
{
  static final String jdField_a_of_type_JavaLangString = "SmallScreenActivityPlugin";
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  public VideoAppInterface a;
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  
  public SmallScreenActivityPlugin(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.b = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public void a()
  {
    if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenActivityPlugin", 2, "onPauseRender isQuit : " + paramBoolean);
    }
    SessionInfo localSessionInfo;
    if (!paramBoolean)
    {
      if (!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
        break label105;
      }
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = localSessionInfo.f;
      if ((i != 2) && (i != 4)) {
        break label100;
      }
    }
    label100:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.a(new goc(this, paramBoolean), 5, null, false);
      SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), localSessionInfo);
      return;
    }
    label105:
    SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenActivityPlugin", 2, "onResume");
    }
    if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = true;
      ThreadManager.a(new gob(this), 5, null, false);
    }
    SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (SmallScreenUtils.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\SmallScreenActivityPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */