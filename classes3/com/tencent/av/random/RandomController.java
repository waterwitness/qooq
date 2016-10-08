package com.tencent.av.random;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.NearbyPeopleProfileHelper;
import com.tencent.av.utils.NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gke;
import gkf;
import gkh;
import gki;
import gkj;
import gkk;
import gkl;
import gkm;
import gkt;
import gku;
import gkw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RandomController
{
  public static final int a = 1;
  private static final RandomController jdField_a_of_type_ComTencentAvRandomRandomController = new RandomController();
  static final String jdField_a_of_type_JavaLangString = "RandomController";
  public static final int b = 2;
  public static final String b = "voice_hall_avatar_";
  public static final int c = 0;
  public static final String c = "http://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050&uidList=%s&anonyInfo=%s";
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = -1;
  public static final int i = -2;
  public static final int j = -3;
  public long a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  public VideoController a;
  public SessionInfo a;
  public VideoAppInterface a;
  RandomWebProtocol.OnRequestListener jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$OnRequestListener = new gke(this);
  public RandomWebProtocol a;
  NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = new gkf(this);
  NearbyPeopleProfileHelper jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
  public Runnable a;
  public List a;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public Runnable b;
  boolean b;
  public Runnable c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  boolean e;
  public String f;
  public boolean f;
  public String g;
  public String h;
  public String i = null;
  public int k = 0;
  public int l = 0;
  public int m;
  public int n = 0;
  int o = 0;
  public int p = -1;
  public int q = 0;
  int r = 0;
  int s = -1;
  int t = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private RandomController()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new gkh(this);
    this.jdField_b_of_type_JavaLangRunnable = new gki(this);
    this.jdField_c_of_type_JavaLangRunnable = new gkj(this);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static RandomController a(VideoAppInterface paramVideoAppInterface)
  {
    jdField_a_of_type_ComTencentAvRandomRandomController.a(paramVideoAppInterface);
    return jdField_a_of_type_ComTencentAvRandomRandomController;
  }
  
  private String a(int paramInt)
  {
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getString(2131363823);
    int i2 = paramInt / 86400;
    int i3 = paramInt % 86400 / 3600;
    int i1 = paramInt % 3600 / 60;
    if ((i2 == 0) && (i3 == 0) && (i1 == 0)) {
      i1 = 1;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (i2 > 0)
      {
        str1 = String.format("%d天", new Object[] { Integer.valueOf(i2) });
        localStringBuilder = new StringBuilder().append(str1);
        if (i3 <= 0) {
          break label229;
        }
        str1 = String.format("%d小时", new Object[] { Integer.valueOf(i3) });
        label119:
        str1 = str1;
        localStringBuilder = new StringBuilder().append(str1);
        if (i1 <= 0) {
          break label235;
        }
      }
      label229:
      label235:
      for (String str1 = String.format("%d分钟", new Object[] { Integer.valueOf(i1) });; str1 = "")
      {
        str1 = str2.replace("%t", str1);
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "getBlockedPromoteText：" + paramInt + ",promtString:" + str1);
        }
        return str1;
        str1 = "";
        break;
        str1 = "";
        break label119;
      }
    }
  }
  
  int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "requestDoubleChat");
    }
    int i2 = -1;
    int i1;
    if ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.a()) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.b()))
    {
      i1 = i2;
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()) {}
    }
    else
    {
      if (this.jdField_b_of_type_Boolean) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString;
      i1 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0, 4, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.i, this.jdField_a_of_type_ComTencentAvAppSessionInfo.g, this.p, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte, this.jdField_e_of_type_JavaLangString, null, 0, 0, null, null);
    }
    label146:
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean);
      i1 = i2;
    } while (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString));
    return this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0, 4);
  }
  
  public int a(String paramString)
  {
    if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(paramString)) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Int == -1))
    {
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
      if ((paramString == null) || (paramString.jdField_b_of_type_Int == -1)) {
        return -1;
      }
    }
    else
    {
      return this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Int;
    }
    return paramString.jdField_b_of_type_Int;
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "StartOrEnterGAudio already in room");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "StartOrEnterGAudio ,retry :" + paramBoolean + ", mCurRetryTimes:" + this.t + ", mGroupIds: " + this.jdField_a_of_type_ArrayOfLong.length);
    }
    if (this.s < 0) {
      this.s = 150;
    }
    int i1 = -1;
    int i2;
    do
    {
      do
      {
        i2 = i1;
        if (this.t >= this.jdField_a_of_type_ArrayOfLong.length) {
          break;
        }
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfLong[this.t];
        this.t += 1;
      } while (this.jdField_a_of_type_Long == 0L);
      String str = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = SessionMgr.a(this.r, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      SessionMgr.a().a(str, this.jdField_d_of_type_JavaLangString);
      QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localQAVNotification != null) && (localQAVNotification.a())) {
        localQAVNotification.a(str, this.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_d_of_type_JavaLangString);
      i2 = this.jdField_a_of_type_ComTencentAvVideoController.a(this.r, this.jdField_a_of_type_Long, this.s, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_ArrayOfLong, false);
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "StartOrEnterGAudio: ret(" + i2 + ")==0 mCurrGroupId(" + this.jdField_a_of_type_Long + ") mRelationType(" + this.r + ") mBusinessId(" + this.s + ")");
      }
      i1 = i2;
    } while (i2 != 0);
    if (QLog.isColorLevel()) {
      QLog.e("RandomController", 2, "StartOrEnterGAudio -->mCurrGroupId == " + this.jdField_a_of_type_Long);
    }
    return i2;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      paramString = null;
    }
    Bitmap localBitmap;
    do
    {
      return paramString;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[pullhead] ~~~~~~ getRandomFaceBitmap ~~~~~~ uin(" + paramString + "), isMask(" + this.jdField_a_of_type_Boolean + ")");
      }
      if (!this.jdField_a_of_type_Boolean) {
        return this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
      }
      if (this.k != 1) {
        break;
      }
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, true);
      paramString = localBitmap;
    } while (localBitmap != null);
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_f_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString);
    return null;
    if (this.k == 2)
    {
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, true);
      int i1;
      if ((localBitmap == null) || (paramBoolean))
      {
        i1 = a(paramString);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RandomController", 2, "getRandomFaceBitmap-->uin=" + paramString + ", gender" + i1);
          }
          a(paramString);
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[pullhead] call pull Head uin(" + paramString + "), isMask(" + this.jdField_a_of_type_Boolean + ")");
        }
        if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
          break label301;
        }
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.m, 1, paramString, i1, this.jdField_a_of_type_Long);
      }
      for (;;)
      {
        return localBitmap;
        label301:
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.m, 2, paramString, i1, this.jdField_a_of_type_Long);
      }
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(null);
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController = null;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RandomController", 2, "setType type: " + paramInt);
    }
    this.k = paramInt;
    this.jdField_e_of_type_Boolean = false;
    paramIntent = paramIntent.getStringExtra("session_name");
    if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (!TextUtils.equals(paramIntent, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_d_of_type_JavaLangString = paramIntent;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.a()))
    {
      this.jdField_e_of_type_Boolean = true;
      label129:
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) && (QLog.isColorLevel())) {
        QLog.e("RandomController", 2, "fail to create session");
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramIntent)) {
        break label187;
      }
    }
    label187:
    for (this.jdField_d_of_type_JavaLangString = paramIntent;; this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
      this.jdField_e_of_type_Boolean = false;
      break label129;
      break;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.e();
    GraphicRenderMgr.getInstance();
    c(paramIntent);
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = NearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack);
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$OnRequestListener);
  }
  
  void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null)
    {
      if (jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      }
      if (jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol = new RandomWebProtocol(paramVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    }
  }
  
  public void a(RandomController.RandomListener paramRandomListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramRandomListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramRandomListener);
    }
  }
  
  public void a(gkt paramgkt)
  {
    Object localObject1 = null;
    this.p = 1011;
    this.q = paramgkt.w;
    Object localObject2;
    if ((paramgkt instanceof gku))
    {
      localObject2 = (gku)paramgkt;
      this.jdField_f_of_type_JavaLangString = ((gku)localObject2).jdField_b_of_type_JavaLangString;
      this.g = ((gku)localObject2).jdField_c_of_type_JavaLangString;
      Object localObject3 = ((gku)localObject2).jdField_a_of_type_ArrayOfByte;
      if (localObject3 != null)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[localObject3.length + 3];
        this.jdField_a_of_type_ArrayOfByte[0] = 1;
        this.jdField_a_of_type_ArrayOfByte[1] = 1;
        this.jdField_a_of_type_ArrayOfByte[2] = -118;
        System.arraycopy(localObject3, 0, this.jdField_a_of_type_ArrayOfByte, 3, localObject3.length);
        this.jdField_h_of_type_JavaLangString = ((gku)localObject2).jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((gku)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
        this.i = ((gku)localObject2).jdField_d_of_type_JavaLangString;
        if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_Boolean)
        {
          if (((gku)localObject2).x <= 0) {
            break label441;
          }
          this.jdField_a_of_type_Boolean = true;
        }
        label149:
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_f_of_type_JavaLangString, this.g, this.jdField_h_of_type_JavaLangString);
        label168:
        localObject2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = SessionMgr.a(3, this.jdField_f_of_type_JavaLangString, new int[0]);
        SessionMgr.a().a((String)localObject2, this.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
        {
          localObject3 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject3 != null) && (((QAVNotification)localObject3).a())) {
            ((QAVNotification)localObject3).a((String)localObject2, this.jdField_d_of_type_JavaLangString);
          }
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_d_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.l != 1011) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0);
        }
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentAvVideoController.a().getResources().getString(2131363808) + this.i);
        }
        if (this.k != 1) {
          break label954;
        }
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break label516;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "uin is empty");
        }
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfByte = new byte[] { 1, 1, -118 };
      break;
      label441:
      if (((gku)localObject2).x != 0) {
        break label149;
      }
      this.jdField_a_of_type_Boolean = false;
      break label149;
      if (!(paramgkt instanceof gkw)) {
        break label168;
      }
      localObject2 = (gkw)paramgkt;
      if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.jdField_a_of_type_Boolean) {
        break label168;
      }
      if (((gkw)localObject2).x > 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        this.s = ((gkw)localObject2).y;
        break;
        if (((gkw)localObject2).x == 0) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      label516:
      this.o = 1;
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue() > Long.valueOf(this.jdField_f_of_type_JavaLangString).longValue()))
      {
        this.jdField_b_of_type_Boolean = false;
        label560:
        this.jdField_a_of_type_ComTencentAvVideoController.J();
        if (!this.jdField_a_of_type_Boolean) {
          break label918;
        }
      }
      try
      {
        paramgkt = BitmapTools.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2);
        if (paramgkt != null) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramgkt;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_JavaLangString = this.g;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = this.g;
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int = this.o;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.l = this.p;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.K = true;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.C = false;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int = this.o;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "processWebProtocol  uinType = " + this.p + " # peerUin = " + this.jdField_f_of_type_JavaLangString + " # signature = " + this.jdField_a_of_type_ArrayOfByte + " # BeginSessionType = " + this.o + " # nickName = " + this.g + " # roomTopic = " + this.jdField_e_of_type_JavaLangString + " # topTips = " + this.i + ", isMask: " + this.jdField_a_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          PopupDialog.a();
          int i1 = 0;
          while (i1 < this.jdField_a_of_type_JavaUtilList.size())
          {
            ((RandomController.RandomListener)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
            i1 += 1;
          }
          this.jdField_b_of_type_Boolean = true;
          break label560;
          label918:
          a(this.jdField_f_of_type_JavaLangString);
          paramgkt = a(this.jdField_f_of_type_JavaLangString, false);
          if (paramgkt != null)
          {
            this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramgkt;
            continue;
            label954:
            if (this.k == 2)
            {
              this.o = 3;
              this.r = 7;
              this.t = 0;
              if (!(paramgkt instanceof gkw)) {
                break label1267;
              }
              paramgkt = ((gkw)paramgkt).jdField_b_of_type_JavaLangString;
              if ((paramgkt == null) || (paramgkt.equals(""))) {
                break;
              }
              paramgkt = paramgkt.split(",");
              this.jdField_a_of_type_ArrayOfLong = new long[paramgkt.length];
              i1 = 0;
              for (;;)
              {
                if (i1 < paramgkt.length) {
                  try
                  {
                    this.jdField_a_of_type_ArrayOfLong[i1] = Long.parseLong(paramgkt[i1].trim());
                    i1 += 1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      this.jdField_a_of_type_ArrayOfLong[i1] = 0L;
                      localNumberFormatException.printStackTrace();
                    }
                  }
                }
              }
              if ((this.o == 3) || (this.o == 4))
              {
                this.jdField_a_of_type_ComTencentAvAppSessionInfo.s = String.valueOf(this.jdField_a_of_type_Long);
                this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Long = this.jdField_a_of_type_Long;
              }
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.F = this.r;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
              this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Boolean = false;
            }
          }
        }
        if ((this.l == 2) || (this.l == 3)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[warning] already in connecting. status = " + this.l);
        }
        this.l = 2;
        if (this.k == 1)
        {
          a();
          return;
        }
        if (this.k != 2) {
          continue;
        }
        a(false);
        return;
      }
      catch (OutOfMemoryError paramgkt)
      {
        for (;;)
        {
          paramgkt = localNumberFormatException;
        }
      }
      catch (Exception paramgkt)
      {
        for (;;)
        {
          paramgkt = localNumberFormatException;
          continue;
          label1267:
          paramgkt = null;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString);
    }
  }
  
  public boolean a()
  {
    if (this.l == 4) {}
    do
    {
      return false;
      if (this.t < this.jdField_a_of_type_ArrayOfLong.length)
      {
        a(true);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("RandomController", 2, "enterNextGroup fail");
      }
    } while (PopupDialog.a());
    j();
    return false;
  }
  
  public int b()
  {
    if ((this.l == 2) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.f())) {
      this.l = 3;
    }
    return this.l;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "start random matching");
    }
    this.i = null;
    if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = NearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a(this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      if (!SessionMgr.a().a(this.jdField_d_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "start random matching mSessionInfo is null!");
      }
      return;
    }
    this.l = 1;
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 7000L);
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
    }
    if (this.k == 1) {
      if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a())
      {
        this.jdField_c_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      label266:
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Boolean = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        return;
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_a_of_type_Boolean, this.m, this.n);
        break;
        if (this.k == 2)
        {
          if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a()) {
            break label413;
          }
          this.jdField_d_of_type_Boolean = true;
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 3, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString);
      break label266;
      break;
      label413:
      this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.jdField_a_of_type_Boolean, this.m);
    }
  }
  
  public void b(Intent paramIntent)
  {
    c(paramIntent);
  }
  
  public void b(RandomController.RandomListener paramRandomListener)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramRandomListener);
  }
  
  public void b(gkt paramgkt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.l == -3) {
      return;
    }
    PopupDialog.a();
    if (this.k == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005728", "0X8005728", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.l = -3;
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RandomController.RandomListener)((Iterator)localObject).next()).a();
      }
      if (this.k == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005726", "0X8005726", 0, 0, "", "", "", "");
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext();
    this.q = paramgkt.w;
    PopupDialog.b((Context)localObject, 230, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getString(2131363822), a(this.q), 2131363160, 0, null, new gkk(this));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
    this.q -= 60;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "isAccompanyReturn: " + this.jdField_e_of_type_Boolean);
    }
    return this.jdField_e_of_type_Boolean;
  }
  
  public void c()
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "stop random matching");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    PopupDialog.a();
    if (this.l == 4) {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching is already closed!");
      }
    }
    label365:
    do
    {
      do
      {
        do
        {
          return;
          if ((this.k == 1) || (this.k == 2)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RandomController", 2, "stop random matching type is invalid!");
        return;
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RandomController", 2, "stop random matching mSessionInfo = null!");
      return;
      Object localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.E();
      if (this.l == 1) {
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a();
      }
      if (this.l == -3)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        PopupDialog.a();
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      if (this.k == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
        if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(localObject)))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 0);
          if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.z == -1) {
            break label365;
          }
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.o = true;
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.c((String)localObject, this.jdField_a_of_type_ComTencentAvAppSessionInfo.z);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper.a();
          this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
        }
        this.l = 4;
        SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentAvVideoController.a(0, 0, null);
        while (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          ((RandomController.RandomListener)this.jdField_a_of_type_JavaUtilList.get(i1)).b();
          i1 += 1;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.z = 0;
        break;
        if (this.k == 2)
        {
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long != 0L))
          {
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
            this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.m, 4, (String)localObject, a((String)localObject), this.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.r, this.jdField_a_of_type_Long, 0, new int[0]);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching mSessionId = " + this.jdField_d_of_type_JavaLangString);
      }
      if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(SessionMgr.a().a().jdField_c_of_type_JavaLangString))) {
        SessionMgr.a().a().b();
      }
      SessionMgr.a().a().c();
      SessionMgr.a().c(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = null;
      this.jdField_d_of_type_JavaLangString = null;
      SmallScreenUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "stop random matching end");
  }
  
  void c(Intent paramIntent)
  {
    if (b())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
      this.p = this.jdField_a_of_type_ComTencentAvAppSessionInfo.l;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
      this.o = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_h_of_type_Int;
      this.g = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_Boolean;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "processIntentData isMask: " + this.jdField_a_of_type_Boolean);
      }
      return;
      this.m = 121;
      String str = paramIntent.getStringExtra("session_type");
      if (str != null) {}
      try
      {
        this.m = Integer.parseInt(str);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("session_name");
        str = paramIntent.getStringExtra("is_mask");
        this.n = paramIntent.getIntExtra("peer_gender", 0);
        if ((this.n < 0) || (this.n > 2)) {
          this.n = 0;
        }
        if (str != null) {
          try
          {
            if (Integer.parseInt(str) >= 1) {
              this.jdField_a_of_type_Boolean = true;
            }
          }
          catch (NumberFormatException paramIntent)
          {
            paramIntent.printStackTrace();
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "reStart");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupDialog.a();
    if (this.jdField_e_of_type_JavaLangString != null)
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      break label121;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) && (!SessionMgr.a().a(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "reStart mSessionInfo is null!");
      }
      label121:
      return;
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString != null) && (b()))
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_d_of_type_JavaLangString;
        this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      }
    }
    String str;
    if (this.k == 1)
    {
      str = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.z != -1) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.c(str, this.jdField_a_of_type_ComTencentAvAppSessionInfo.z);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.c();
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "reStart mSessionId : " + this.jdField_d_of_type_JavaLangString);
        }
        if (!SessionMgr.a().a(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
        }
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
          break label333;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "reStart RANDOM_TYPE_DOUBLE mSessionInfo is null!");
        return;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.z = 0;
      }
      label333:
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.c();
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 2;
    }
    for (;;)
    {
      b();
      return;
      if (this.k == 2)
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
        {
          str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.m, 4, str, a(str), this.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.r, this.jdField_a_of_type_Long, 0, new int[0]);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.c();
        this.jdField_d_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        if (!SessionMgr.a().a(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(this.jdField_d_of_type_JavaLangString, false);
        }
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RandomController", 2, "reStart RANDOM_TYPE_MULTI mSessionInfo is null!");
          return;
        }
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.c();
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_e_of_type_JavaLangString = null;
        this.i = null;
      }
    }
  }
  
  public void e()
  {
    if (PopupDialog.a())
    {
      if (this.l == -3) {
        PopupDialog.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getString(2131363822), a(this.q));
      }
    }
    else {
      return;
    }
    PopupDialog.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext());
  }
  
  public void f()
  {
    if ((this.l == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchTimeout trigger, show timeOutDialog!");
    }
    this.l = -1;
  }
  
  public void g()
  {
    if ((this.l == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchError trigger, show timeOutDialog!");
    }
    this.l = -2;
  }
  
  public void h()
  {
    if (PopupDialog.a()) {
      PopupDialog.b();
    }
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.m, 3, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()), this.jdField_a_of_type_Long);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "showTimeoutDialog");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.D == 0) {}
    for (;;)
    {
      return;
      if (!this.jdField_f_of_type_Boolean)
      {
        if (this.k == 1) {
          ReportController.b(null, "CliOper", "", "", "0X80053B3", "0X80053B3", 0, 0, "", "", "", "");
        }
        while (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.f())
        {
          Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext();
          PopupDialog.b(localContext, 230, null, localContext.getString(2131363818), 2131363161, 2131363789, new gkl(this), new gkm(this));
          this.jdField_f_of_type_Boolean = true;
          return;
          if (this.k == 2) {
            ReportController.b(null, "CliOper", "", "", "0X80053BF", "0X80053BF", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\random\RandomController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */