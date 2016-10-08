package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.download.DownloadParams;
import grd;
import gre;
import grf;
import grg;
import grh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConferenceFlyTicketActivity
  extends BaseActivity
{
  static final int jdField_a_of_type_Int = -160;
  static final String jdField_a_of_type_JavaLangString = "ConferenceFlyTicketActivity";
  static final int b = -161;
  static final int c = 0;
  static final int d = -1;
  static final int e = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  public DiscussionHandler a;
  grf jdField_a_of_type_Grf;
  public grg a;
  grh jdField_a_of_type_Grh;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public ConferenceFlyTicketActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  void a()
  {
    Intent localIntent = super.getIntent();
    this.b = localIntent.getStringExtra("confid");
    this.c = localIntent.getStringExtra("subject");
    this.d = localIntent.getStringExtra("ticket");
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "processExtraData mConfid = " + this.b + ", mSubject = " + this.c + ", mTicket = " + this.d);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "showFailMessage type = " + paramInt1 + ", errorCode = " + paramInt2);
    }
    String str;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = "加入会议失败，请重试。";
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new grd(this, str));
      return;
      str = "多人聊天不存在";
      continue;
      str = "超出人数限制，无法加入会议。";
      continue;
      str = "非法多人聊天链接";
      continue;
      return;
      str = "网络错误，请稍后重试";
      continue;
      if (paramInt1 == 0) {
        str = "获取多人聊天信息失败，请稍后重试";
      } else {
        str = "";
      }
    }
  }
  
  public void a(String paramString)
  {
    ThreadManager.a(new gre(this, paramString), 5, null, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConferenceFlyTicketActivity", 2, "startGAudioOnCreateDiscussion strRoomId = " + paramString1 + ", discussName = " + paramString2);
    }
    if (AVNotifyCenter.c())
    {
      QQToast.a(getApplicationContext(), 2131363475, 1).b(getApplicationContext().getResources().getDimensionPixelSize(2131492908));
      if (QLog.isColorLevel()) {
        QLog.d("ConferenceFlyTicketActivity", 2, "startGAudioOnCreateDiscussion is on Double video invite");
      }
      return;
    }
    paramString2 = new HashMap();
    paramString2.put("MultiAVType", String.valueOf(1));
    paramString2.put("isConferenceFlyTicket", String.valueOf(true));
    ChatActivityUtils.a(this.app, this.app.a(), 3000, paramString1, true, true, null, paramString2);
  }
  
  void b()
  {
    if (NetworkUtil.e(this))
    {
      if ((this.d != null) && (this.d.length() > 0))
      {
        a("http://url.cn/" + this.d);
        return;
      }
      this.jdField_a_of_type_Grh = new grh(this);
      ArrayList localArrayList = new ArrayList();
      DownloadParams localDownloadParams = new DownloadParams();
      localDownloadParams.a = ("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_ticket_with_flag?confid=" + this.b);
      localArrayList.add(localDownloadParams);
      this.jdField_a_of_type_Grh.execute(new ArrayList[] { localArrayList });
      return;
    }
    a(0, 65376);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    this.jdField_a_of_type_Grf = new grf(this);
    addObserver(this.jdField_a_of_type_Grf);
    a();
    b();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    return bool;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Grf);
    this.jdField_a_of_type_AndroidOsHandler = null;
    super.doOnDestroy();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\ConferenceFlyTicketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */