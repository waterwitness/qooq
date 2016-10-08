package com.tencent.av;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.arrange.op.MeetingInfo;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.DeviceSharpController;
import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVInviteAccount;
import com.tencent.av.gaudio.AVInvitePSTNPhone;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.gaudio.AVUserInfo;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.gaudio.TelInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.random.RandomController;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VChatActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.PstnNumberManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import gej;
import gel;
import gem;
import gen;
import geo;
import gep;
import geq;
import ger;
import ges;
import get;
import geu;
import gev;
import gew;
import gex;
import gey;
import gez;
import gfa;
import gfb;
import gfc;
import gfd;
import gfe;
import gff;
import gfg;
import gfi;
import gfj;
import gfk;
import gfl;
import gfo;
import gfp;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify;

public class VideoController
  extends AbstractNetChannel
  implements IVideoSession, IVideoEventListener
{
  public static final int J = 20;
  public static final int K = 60;
  public static final int L = 100000;
  public static final int P = 0;
  public static final int Q = 1;
  public static final int R = 0;
  public static final int S = 1;
  public static final int T = 2;
  public static final int U = 0;
  public static final int V = 1;
  public static final int W = 1;
  public static final int X = 0;
  public static final int Y = 1;
  public static final int Z = 2;
  static volatile VideoController jdField_a_of_type_ComTencentAvVideoController;
  static gfp jdField_a_of_type_Gfp;
  public static String a;
  public static final int aa = 3;
  public static final int ab = 4;
  public static final int ae = 0;
  public static final int af = 1;
  public static final int ag = 2;
  public static final int ah = 3;
  public static final int ai = 4;
  static gfp jdField_b_of_type_Gfp;
  static final String jdField_b_of_type_JavaLangString = "03162412023";
  public static final String c = "com.tencent.qav.meeting.";
  public static String d;
  public static String e;
  public static String f;
  private static long jdField_g_of_type_Long = 0L;
  private static final String jdField_g_of_type_JavaLangString = "lastMeetingTime";
  private static String jdField_h_of_type_JavaLangString;
  private boolean A;
  private boolean B;
  int C = -1;
  public int D;
  public int E;
  public int F;
  public int G;
  public int H;
  public int I;
  public int M = 20;
  public int N = 60;
  public int O = 100000;
  public long a;
  Activity jdField_a_of_type_AndroidAppActivity = null;
  public Context a;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new gfc(this);
  public SessionMgr a;
  private VideoController.CameraDataUpdataInterface jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface;
  public VideoAppInterface a;
  public DeviceSharpController a;
  public VcControllerImpl a;
  QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
  public PhoneStatusMonitor.PhoneStatusListener a;
  public PhoneStatusMonitor a;
  public TraeHelper a;
  GAClientLogReport jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = null;
  gfg jdField_a_of_type_Gfg = null;
  gfi jdField_a_of_type_Gfi;
  gfj jdField_a_of_type_Gfj = null;
  gfk jdField_a_of_type_Gfk = null;
  public gfl a;
  public gfo a;
  Runnable jdField_a_of_type_JavaLangRunnable = new gej(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = true;
  public byte[] a;
  public float[] a;
  public int ac;
  int ad = 0;
  int aj = 1;
  int ak = 2;
  int al = 3;
  int am = 4;
  public int an = 0;
  public int ao = -1;
  int ap = 0;
  public long b;
  public MediaPlayer.OnCompletionListener b;
  Runnable jdField_b_of_type_JavaLangRunnable = new gev(this);
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long = 0L;
  MediaPlayer.OnCompletionListener jdField_c_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new gfe(this);
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  boolean jdField_c_of_type_Boolean = false;
  public long d;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = false;
  public long e;
  Runnable e;
  public boolean e;
  long jdField_f_of_type_Long = 0L;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  public boolean f;
  Runnable jdField_g_of_type_JavaLangRunnable = null;
  public boolean g;
  Runnable jdField_h_of_type_JavaLangRunnable = null;
  boolean jdField_h_of_type_Boolean = true;
  public Runnable i;
  public boolean i;
  Runnable jdField_j_of_type_JavaLangRunnable = new gew(this);
  boolean jdField_j_of_type_Boolean = false;
  boolean k;
  boolean l = false;
  public boolean m;
  public boolean n;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  public boolean r;
  public boolean s;
  public boolean t;
  public boolean u = true;
  boolean v = false;
  boolean w = false;
  boolean x = false;
  private boolean y;
  private boolean z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "VideoController";
    jdField_h_of_type_JavaLangString = "com.tencent.av.count";
    jdField_d_of_type_JavaLangString = "WifiQQCall";
    jdField_e_of_type_JavaLangString = "WifiRandom";
    jdField_f_of_type_JavaLangString = "WifiGuild";
  }
  
  private VideoController()
  {
    this.jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_E_of_type_Int = 0;
    this.jdField_d_of_type_Long = 6000L;
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
    this.jdField_I_of_type_Int = 0;
    this.jdField_a_of_type_Gfl = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_A_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new gfd(this);
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_i_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Gfo = null;
  }
  
  private void W()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null)
    {
      this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController = new DeviceSharpController(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().l = 9500;
      if (QLog.isColorLevel()) {
        QLog.w("BaseIMSharp", 2, "init device sharp");
      }
    }
  }
  
  public static int a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean)
    {
      switch (paramInt1)
      {
      default: 
        paramInt2 = -1;
        return paramInt2;
      case 0: 
      case 9500: 
        if (paramInt2 == 2) {
          return 22;
        }
        return 0;
      case 1006: 
        return 5;
      case 1000: 
        return 8;
      case 1004: 
        return 9;
      case 1001: 
        return 12;
      case 1021: 
        return 10;
      case 1024: 
      case 1025: 
        return 19;
      case 1010: 
        return 20;
      case 1011: 
        return 21;
      case 8: 
        return 22;
      case 1008: 
        return 51;
      case 24: 
        return 24;
      case 25: 
        return 25;
      }
      return 26;
    }
    paramInt2 = paramInt1;
    switch (paramInt1)
    {
    case 19: 
    default: 
      return -1;
    case 0: 
    case 9500: 
      return 0;
    case 4: 
    case 5: 
      return 1006;
    case 8: 
      return 1000;
    case 9: 
      return 1004;
    case 12: 
      return 1001;
    case 10: 
      return 1021;
    case 20: 
      return 1010;
    case 21: 
      return 1011;
    case 22: 
      return 22;
    case 1008: 
      return 51;
    case 24: 
      return 24;
    case 25: 
      return 25;
    }
    return 26;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    int i3 = 0;
    int i2 = i3;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        i2 = i3;
      }
    }
    else {
      return i2;
    }
    i3 = 0;
    for (;;)
    {
      i2 = i1;
      if (i3 >= paramInt) {
        break;
      }
      i1 = (int)(i1 | (paramArrayOfByte[i3] & 0xFF) << (paramInt - i3 - 1) * 8);
      i3 += 1;
    }
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int i2;
    for (int i1 = 0;; i1 = i2)
    {
      l2 = l1;
      if (i1 >= paramInt) {
        break;
      }
      l2 = paramArrayOfByte[i1];
      i2 = i1 + 1;
      l1 = (l2 & 0xFF) << (paramInt - i1 - 1) * 8 | l1;
    }
  }
  
  public static VideoController a()
  {
    if (jdField_a_of_type_ComTencentAvVideoController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvVideoController == null) {
        jdField_a_of_type_ComTencentAvVideoController = new VideoController();
      }
      return jdField_a_of_type_ComTencentAvVideoController;
    }
    finally {}
  }
  
  private void a(int paramInt, long paramLong1, AVUserInfo paramAVUserInfo, boolean paramBoolean, long paramLong2, int... paramVarArgs)
  {
    long l1 = paramAVUserInfo.jdField_a_of_type_Long;
    long l2 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    if (l2 == l1)
    {
      bool1 = true;
      localObject = SessionMgr.a(paramInt, String.valueOf(paramLong1), paramVarArgs);
      if (paramInt == 3) {
        localObject = SessionMgr.a(10, String.valueOf(paramLong1), new int[0]);
      }
      if (paramInt != 1) {
        break label84;
      }
    }
    label84:
    for (Object localObject = a();; localObject = SessionMgr.a().a((String)localObject))
    {
      if (localObject != null) {
        break label97;
      }
      return;
      bool1 = false;
      break;
    }
    label97:
    if ((paramBoolean) && (bool1))
    {
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_E_of_type_Int = paramInt;
      if (localObject != null) {
        ((SessionInfo)localObject).P = true;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      if (!this.q) {
        break label480;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend();
      if (((this.jdField_E_of_type_Int == 1) && (((SessionInfo)localObject).jdField_D_of_type_Int == 10)) || (this.jdField_E_of_type_Int == 2)) {
        if (paramLong2 != 0L) {
          break label491;
        }
      }
    }
    label480:
    label491:
    for (boolean bool2 = false;; bool2 = true)
    {
      ((SessionInfo)localObject).ab = bool2;
      if ((this.jdField_E_of_type_Int == 2) && (((SessionInfo)localObject).n()) && (((SessionInfo)localObject).o()) && ((((SessionInfo)localObject).jdField_y_of_type_Int == 2) || (((SessionInfo)localObject).jdField_y_of_type_Int == 1) || (((SessionInfo)localObject).jdField_y_of_type_Int == 4)) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f() >= 6) && (!((SessionInfo)localObject).jdField_D_of_type_Boolean) && (((SessionInfo)localObject).ab))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave roomower enter again");
        }
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->RelationId = " + paramLong1 + " UserInfo = " + paramAVUserInfo + " isEnter = " + paramBoolean + " bSelfIn = " + bool1 + " selfUin = " + l2 + " extroInfo = " + paramLong2);
      }
      if ((paramBoolean) || (l1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) || (paramLong1 != this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long)) {
        break label497;
      }
      a(paramInt, paramLong1, 0, paramVarArgs);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend();
      break;
    }
    label497:
    a(paramAVUserInfo, paramBoolean);
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011))
    {
      if (!paramBoolean) {
        break label990;
      }
      if (j() != 1) {
        break label973;
      }
      if (!bool1) {
        break label956;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
      label567:
      if ((!bool1) && ((o()) || (n())) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f())) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165195, null, 0, null);
      }
      label614:
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 3, null);
      paramVarArgs = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((paramVarArgs != null) && (paramVarArgs.a())) {
        k();
      }
    }
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j < 10)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (bool1))
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 9;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().ad = false;
        }
      }
      else
      {
        label718:
        if ((a().jdField_f_of_type_Long != l1) && (l1 != l2)) {
          TipsManager.c(105);
        }
        if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().U) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().S)) {
          break label1157;
        }
        ReportController.b(null, "CliOper", "", "", "0X800667D", "0X800667D", 0, 0, "", "", "", "");
        label803:
        if (!paramBoolean) {
          break label1287;
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
        if (paramAVUserInfo.jdField_a_of_type_Int != 0) {
          break label1281;
        }
        bool1 = true;
        label825:
        paramVarArgs.a(new Object[] { Integer.valueOf(61), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool1) });
      }
    }
    for (;;)
    {
      Q();
      if (!a().jdField_z_of_type_Boolean) {
        break label1475;
      }
      if (paramBoolean) {
        break;
      }
      if (a().jdField_A_of_type_Boolean)
      {
        paramAVUserInfo = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        E();
        if (paramAVUserInfo.a()) {
          paramAVUserInfo.a(a().jdField_b_of_type_JavaLangString);
        }
      }
      if (!a().an) {
        break;
      }
      a(paramLong1, false, 2);
      a();
      return;
      label956:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 1;
      break label567;
      label973:
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
      break label567;
      label990:
      if (j() == 1) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 4;
      }
      if ((bool1) || ((!o()) && (!n())) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) || (!o())) {
        break label614;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165196, null, 0, null);
      break label614;
      if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().ad) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 9)) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 10;
      D();
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long != 0L) {
        break label718;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      break label718;
      label1157:
      if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().T) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().S)) {
        break label803;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006416", "0X8006416", 0, 0, "", "", "", "");
      break label803;
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == l2))
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 9;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().ad = true;
      }
      TipsManager.c(105);
      break label803;
      label1281:
      bool1 = false;
      break label825;
      label1287:
      if (paramLong2 != 1L) {
        break label1302;
      }
      f(true);
    }
    label1302:
    if (paramLong2 == 0L)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      if (paramAVUserInfo.jdField_a_of_type_Int == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
        break;
      }
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramAVUserInfo.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramVarArgs.a(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong1), Long.valueOf(l1), Boolean.valueOf(bool1) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioUserEnterOrLeave-->Extro Info is Wrong.Extro Info = " + paramLong2);
      break;
    }
    label1475:
    paramAVUserInfo = new Intent();
    paramAVUserInfo.setAction("tencent.av.v2q.MultiVideo");
    if (paramBoolean)
    {
      paramAVUserInfo.putExtra("type", 22);
      paramAVUserInfo.putExtra("isStart", this.v);
    }
    for (;;)
    {
      paramAVUserInfo.putExtra("roomUserNum", this.jdField_a_of_type_JavaUtilArrayList.size());
      paramAVUserInfo.putExtra("relationType", paramInt);
      paramAVUserInfo.putExtra("relationId", paramLong1);
      paramAVUserInfo.putExtra("friendUin", l1);
      paramAVUserInfo.putExtra("MultiAVType", a().jdField_D_of_type_Int);
      paramAVUserInfo.putExtra("from", "VideoController5");
      paramAVUserInfo.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramAVUserInfo);
      return;
      paramAVUserInfo.putExtra("type", 23);
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatVideoInOrOut-->Groupid=" + paramLong1 + " user = " + paramLong2 + " bVideoIn = " + paramBoolean + " extraInfo = " + paramLong3);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean) && (paramLong2 != l1) && (paramInt1 == 3)) {
      return;
    }
    if ((!paramBoolean) && (paramInt1 == 1) && (paramInt2 == 2) && (paramLong2 != CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())))
    {
      i1 = 0;
      label141:
      if (i1 < this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size()) {
        if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong2) {}
      }
    }
    for (int i1 = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;; i1 = 1)
    {
      a(paramLong2, paramBoolean, paramInt1, paramLong3);
      if (paramBoolean)
      {
        if ((paramInt1 != 2) && (paramInt1 != 3) && ((paramInt1 != 1) || (paramInt2 != 10))) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(69), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        return;
        i1 += 1;
        break label141;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i1) });
      return;
    }
  }
  
  private void a(long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, long paramLong3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaChatPPTInOrOut,groupUin=" + paramLong1 + " uin = " + paramLong2 + " bIn = " + paramBoolean1 + " bIsPPT = " + paramBoolean2 + " extraInfo = " + paramLong3);
    }
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    if ((paramLong3 == 1L) && (!paramBoolean1) && (paramLong2 != l1) && (paramInt1 == 3) && (paramInt2 != 10)) {
      return;
    }
    a(paramLong2, paramBoolean1, paramInt1, paramBoolean2, paramInt2);
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(77), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(78), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i1 = b(paramLong1);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + paramLong1);
          }
          return;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localGAudioFriends.jdField_b_of_type_Boolean = paramBoolean;
        if ((paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong1, 1) != -1)) {
          return;
        }
      }
      if (paramBoolean)
      {
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localVideoViewInfo.jdField_a_of_type_Long = paramLong1;
        localVideoViewInfo.jdField_a_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong1, localVideoViewInfo.jdField_a_of_type_Int) != -1) {
          return;
        }
        localVideoViewInfo.jdField_b_of_type_Long = paramLong2;
        if ((paramInt == 1) && (paramLong2 != 4L) && (paramLong2 != 2L) && (paramLong2 != 3L)) {
          localVideoViewInfo.jdField_b_of_type_Long = 5L;
        }
        if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().m())
        {
          localVideoViewInfo.jdField_a_of_type_Boolean = true;
          if ((i() == 4) || (paramInt == 3)) {
            break label388;
          }
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) != -1) {
            break label379;
          }
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          label295:
          if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
            break label406;
          }
          localVideoViewInfo.jdField_b_of_type_Boolean = true;
          localVideoViewInfo.jdField_d_of_type_Boolean = true;
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().m()) {
            break label397;
          }
          localVideoViewInfo.jdField_a_of_type_Boolean = true;
          label354:
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(localVideoViewInfo);
        }
        for (;;)
        {
          return;
          localVideoViewInfo.jdField_a_of_type_Boolean = false;
          break;
          label379:
          localVideoViewInfo.jdField_c_of_type_Boolean = false;
          break label295;
          label388:
          localVideoViewInfo.jdField_c_of_type_Boolean = true;
          break label295;
          label397:
          localVideoViewInfo.jdField_a_of_type_Boolean = false;
          break label354;
          label406:
          localVideoViewInfo.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(localVideoViewInfo);
        }
      }
      if (paramInt == 2) {
        a(paramLong1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
      }
      for (;;)
      {
        F();
        break;
        if (paramInt == 1)
        {
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_D_of_type_Int == 10) {
            a(paramLong1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
          } else {
            a(paramLong1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 0, true);
          }
        }
        else if (paramInt == 3) {
          a(paramLong1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 1, false);
        }
      }
    }
  }
  
  private void a(long paramLong, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 == 2)) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberShareSrcInOrOut-->relationtype is not discuss,uin=" + paramLong + ",bin=" + paramBoolean1 + ",relationType=" + paramInt1 + ",isPPT=" + paramBoolean2);
      }
    }
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      paramInt1 = b(paramLong);
      if (paramInt1 == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
        }
        return;
      }
    }
    Object localObject2 = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    VideoViewInfo localVideoViewInfo;
    if (paramBoolean1)
    {
      localVideoViewInfo = new VideoViewInfo();
      if (paramBoolean2) {}
      for (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 2;; ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 1)
      {
        localVideoViewInfo.jdField_a_of_type_Long = paramLong;
        localVideoViewInfo.jdField_a_of_type_Int = 2;
        localVideoViewInfo.jdField_a_of_type_Boolean = true;
        localVideoViewInfo.jdField_b_of_type_Boolean = false;
        localVideoViewInfo.jdField_b_of_type_Long = 5L;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong, localVideoViewInfo.jdField_a_of_type_Int) == -1) {
          break;
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
      {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = false;
        if (i() != 4)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue());
          if (paramInt1 != -1) {
            ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_c_of_type_Boolean = false;
          }
        }
      }
      localVideoViewInfo.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size() > 1)
      {
        localObject2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().a((VideoViewInfo)localObject2);
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(0, localVideoViewInfo);
      continue;
      ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Int = 0;
      a(paramLong, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 2, false);
      F();
    }
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    Intent localIntent = new Intent(paramVideoAppInterface.getApplication(), VChatActivity.class);
    localIntent.addFlags(524288);
    paramVideoAppInterface.getApplication().startActivity(localIntent);
  }
  
  private boolean b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i1 = b(paramLong);
        if (i1 == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->Can not find the.Uin=" + paramLong);
          }
          return false;
        }
        ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Boolean = paramBoolean;
        return false;
      }
    }
    return false;
  }
  
  public static int d(String paramString)
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences(jdField_h_of_type_JavaLangString, 0);
    int i1 = ((SharedPreferences)localObject).getInt(paramString, 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, i1 + 1);
    ((SharedPreferences.Editor)localObject).commit();
    return i1;
  }
  
  void A()
  {
    jdField_g_of_type_Long = System.currentTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getSharedPreferences("com.tencent.qav.meeting." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 1).edit();
    localEditor.putLong("lastMeetingTime", jdField_g_of_type_Long);
    localEditor.commit();
  }
  
  public void A(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().ak = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    y(paramString);
  }
  
  public void B()
  {
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 0;
    }
  }
  
  public void B(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetQCallNickName nickName : " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(600), paramString });
  }
  
  public void C()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (l1 == ((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long)) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 9;
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 10;
  }
  
  public void D()
  {
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 4) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 10) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 14) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int >= 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Chatting Timer-->Start");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_j_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_j_of_type_JavaLangRunnable);
  }
  
  public void F()
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      if (i() == 4) {
        break label357;
      }
      i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().a();
      if (i1 != -1) {
        break label83;
      }
      ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
      ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
    }
    label83:
    VideoViewInfo localVideoViewInfo1;
    do
    {
      for (;;)
      {
        return;
        localVideoViewInfo1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        localVideoViewInfo1.jdField_a_of_type_Boolean = true;
        if (localVideoViewInfo1.jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
          break;
        }
        if (i1 != 0)
        {
          localVideoViewInfo2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0);
          localVideoViewInfo2.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
        }
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) == -1)
        {
          i1 = 0;
          while (i1 < this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size())
          {
            if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
              ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Boolean = true;
            }
            i1 += 1;
          }
        }
      }
    } while (i1 == 0);
    VideoViewInfo localVideoViewInfo2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0);
    localVideoViewInfo2.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.set(0, localVideoViewInfo1);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.set(i1, localVideoViewInfo2);
    return;
    label357:
    ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_F_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoSend();
        return;
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_F_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_D_of_type_Int == 10)) {
          ReportController.b(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
        }
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOffStage-->mGAudioCtrl is null");
  }
  
  public void H()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.BindContact");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void I()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.OpenContactList");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startRandomTimeout");
    }
    if (this.jdField_a_of_type_Gfg == null) {
      this.jdField_a_of_type_Gfg = new gfg(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gfg, 30000L);
  }
  
  public void K()
  {
    a().a(a().jdField_g_of_type_JavaUtilArrayList);
    j();
    a(a().jdField_g_of_type_JavaUtilArrayList);
    a().jdField_g_of_type_JavaUtilArrayList.clear();
  }
  
  public void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "kickOutPstnUsers");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.KickOutPstnUsers();
    }
  }
  
  public void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPstnBill");
    }
  }
  
  public void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onKickOutSuc");
    }
  }
  
  public void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onKickOutFail");
    }
  }
  
  public void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMultiPstnTimeLess");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(704) });
    }
  }
  
  public void Q()
  {
    if ((a().jdField_F_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      int i1 = d().size();
      if (i1 > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(703), Integer.valueOf(i1) });
      }
    }
    else
    {
      return;
    }
    a().jdField_E_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(702) });
  }
  
  public void R()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "requestForVideoMode :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideoMode(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void S()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptVideoModeRequest :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideoMode(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void T()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "rejectVideoModeRequest :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideoMode(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void U()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelVideoModeRequest :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.cancelVideoMode(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void V()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG onHowling");
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setHowlingDetectEnable(false);
    if (ConfigSystemImpl.d(this.jdField_a_of_type_AndroidContentContext))
    {
      boolean bool1 = h();
      if (!bool1)
      {
        a(this.jdField_a_of_type_Long, false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      boolean bool2 = a().H;
      if (bool2) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
      }
      PopupDialog.b(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131364031), 2131367262, 2131367263, new gex(this), new gey(this, bool1, bool2));
      ReportController.b(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
    }
  }
  
  public float a()
  {
    if ((a().f()) || (this.jdField_e_of_type_Boolean))
    {
      float f2 = 0.0F;
      float f1;
      if (a().jdField_f_of_type_Int == 1)
      {
        f1 = f2;
        if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
          f1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getVolume();
        }
      }
      do
      {
        do
        {
          return f1;
          f1 = f2;
        } while (a().jdField_f_of_type_Int != 3);
        f1 = f2;
      } while (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null);
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVolume();
    }
    return 255.0F;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onLogOutByKicked();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && (paramString != null)) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.doReport(paramInt1, paramInt2, paramInt3, paramString, paramLong);
    }
    return -1;
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    c(false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startGAudioChat relationType:" + paramInt1 + ", relationId: " + paramLong + ", uinList: " + paramArrayOfLong + " ,isVideo = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return -1;
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[] { a().jdField_D_of_type_Int }))) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[] { a().jdField_D_of_type_Int }), true);
    }
    this.jdField_r_of_type_Boolean = false;
    long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    int i2;
    int i1;
    if ((paramInt1 == 7) || (paramInt1 == 9))
    {
      i2 = 1;
      i1 = paramInt2;
      paramInt2 = i2;
      if (paramBoolean) {
        paramInt2 = 2;
      }
      b();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_f_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j();
      i2 = ConfigSystemImpl.c(a());
      if (!a().O) {
        break label462;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(1, i2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startGAudio(paramInt1, i1, paramInt2, paramLong, paramArrayOfLong, d(), l1, a().O);
      if (this.jdField_i_of_type_JavaLangRunnable == null) {
        this.jdField_i_of_type_JavaLangRunnable = new get(this, paramInt1, paramLong);
      }
      this.v = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 8;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().s = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
      s();
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString, 3, false, false, false);
      return 0;
      if (paramInt1 == 2)
      {
        i1 = 1;
        if (a().jdField_f_of_type_Boolean) {}
        for (paramInt2 = 2;; paramInt2 = 1) {
          break;
        }
      }
      if (paramInt1 == 1)
      {
        i1 = a().jdField_D_of_type_Int;
        paramInt2 = 1;
        break;
      }
      return -1;
      label462:
      if (a().ac) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(2, i2);
      } else {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setPstnInviteInfo(3, i2);
      }
    }
  }
  
  public int a(int paramInt, long paramLong, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptGAudioChat groupId: " + paramLong + " relationType=" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    c(false);
    this.jdField_r_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 8;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().s = String.valueOf(paramLong);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().af = true;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().ap = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " --> SetAccepting True. SessionId = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
    }
    long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    int i1 = 2;
    int i2 = 2;
    if (paramInt == 2)
    {
      int i3 = 1;
      if (a().jdField_f_of_type_Boolean)
      {
        i1 = 2;
        i2 = i1;
        i1 = i3;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        i1 = 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getSessionInfo().localHasVideo = " + a().jdField_f_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.acceptGAudio(paramInt, i1, i2, paramLong, paramArrayOfLong, d(), l1);
      if (this.jdField_i_of_type_JavaLangRunnable == null) {
        this.jdField_i_of_type_JavaLangRunnable = new geu(this, paramInt, paramLong);
      }
      this.v = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_i_of_type_JavaLangRunnable, 30000L);
      s();
      return 0;
      i1 = 1;
      break;
      if (paramInt == 1)
      {
        i1 = a().jdField_D_of_type_Int;
        i2 = 1;
      }
      else if (paramInt == 3)
      {
        i1 = 8;
        i2 = 1;
      }
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    if (!a().f()) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendAVFunChatMsg(a().jdField_c_of_type_JavaLangString, paramInt, paramString);
  }
  
  public int a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if ((!paramBoolean) && (19 == paramInt1) && (!TextUtils.isEmpty(paramString)))
    {
      if (BmqqSegmentUtil.b(a(), paramString)) {
        return 1025;
      }
      return 1024;
    }
    return a(paramInt1, paramBoolean, paramInt2);
  }
  
  public int a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVolume();
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.UpdateSelfUin(paramString);
    }
    return -1;
  }
  
  public int a(String paramString, char paramChar)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    try
    {
      long l1 = CharacterUtil.a(paramString);
      int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendDTMFMessage(l1, paramChar);
      return i1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptRequest: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString);
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramInt1 = -2;
      return paramInt1;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 21)) {
      a(15000L);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j();
    int i1 = -1;
    if (paramInt1 == 0) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, d(), 0, paramInt2);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptRequest: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + i1);
      }
      if (i1 == 0)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 3;
        v();
      }
      paramInt1 = i1;
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
        break;
      }
      SmartDeviceReport.a(null, "Usr_TV_Video", 4, 0, 0);
      return i1;
      if (1 == paramInt1) {
        i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.acceptVideo(paramString, 0L, d(), 2, paramInt2);
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6, byte[] paramArrayOfByte, String paramString7, String paramString8, int paramInt4, int paramInt5, String paramString9, String paramString10)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "request selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin: " + paramString1 + ", businessType: " + paramInt1 + ", relationType: " + paramInt2 + ", fromNation: " + paramString2 + ", fromMobile: " + paramString3 + ", toMobile: " + paramString4 + ", uinType: " + paramInt3 + ", extraUin: " + paramString5 + ", sig: " + paramArrayOfByte + ", bindID: " + paramString8 + ", bindType: " + paramInt4 + ", subServiceType: " + paramInt5);
      if (paramArrayOfByte != null) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
      }
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "network not support!");
      }
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "controller is null!");
      }
      return -1;
    }
    if ((paramInt3 == 1006) && (paramString1.startsWith("+"))) {
      paramString1 = paramString1.substring(1);
    }
    for (;;)
    {
      int i1 = a(paramInt3, paramString1, true, 1);
      if (i1 == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "request accostType = " + i1);
        }
        return -1;
      }
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a() != null) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().d()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString != null) && (paramString1.equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "request----already receive invite, return~");
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean = true;
        return -1;
      }
      if (paramInt3 == 9500) {
        W();
      }
      long l1 = 0L;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().ag)
      {
        l1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Long;
        q();
      }
      String str = BaseApplicationImpl.a().getSharedPreferences("fun_call_sp_file", 4).getString("key_fun_call_buff", "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request funcall buffer:" + str);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j();
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 21))
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "request Anychat Mode ");
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = true;
        if (Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue() > Long.valueOf(paramString1).longValue()) {
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, 0L, d(), 0, 4, paramString2, paramString3, paramString4, 21, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
        }
      }
      for (;;)
      {
        AVReport.a().o = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "request result = " + paramInt1 + ", uinType = " + paramInt3 + ", accostType = " + i1);
        }
        if (paramInt1 == 0)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().l = paramInt3;
          if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 4)) {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
          }
          s();
          if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) {
            break label1216;
          }
        }
        label1216:
        for (paramInt2 = 1;; paramInt2 = 2)
        {
          a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString, paramInt2, false, false, true);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = -1;
          this.p = false;
          x(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().ae = false;
          return paramInt1;
          paramInt1 = 0;
          break;
          if (paramInt3 == 9500) {
            try
            {
              l1 = CharacterUtil.a(paramString1);
              if (QLog.isColorLevel()) {
                QLog.d("SDVideo", 2, "request smart tv");
              }
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(d());
              paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestUnQQ(l1, paramInt1, paramInt2, 4200);
            }
            catch (NumberFormatException paramString1)
            {
              paramString1.printStackTrace();
              return -1;
            }
          }
          if (paramInt1 == 0)
          {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = true;
            if ((paramString10 != null) && (!TextUtils.isEmpty(paramString10)))
            {
              paramString10 = C2BUserInfo.a(paramString10);
              if (paramString10 != null) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number");
              }
              for (paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, 0L, d(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9, paramString10);; paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, 0L, d(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9))
              {
                break;
                QLog.e(jdField_a_of_type_JavaLangString, 2, "requestVideo new number is null");
              }
            }
            paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, 0L, d(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
            break;
          }
          if (1 != paramInt1) {
            break label1221;
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
          paramInt1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, 0L, d(), paramInt1, paramInt2, paramString2, paramString3, paramString4, i1, paramString5, paramString6, l1, paramArrayOfByte, str, paramString7, paramString8, paramInt4, paramInt5, paramString9);
          break;
        }
        label1221:
        paramInt1 = -1;
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString2, int paramInt3)
  {
    if ((paramInt3 == 2) && (paramArrayOfByte != null))
    {
      paramArrayOfByte[0] = 1;
      paramArrayOfByte[1] = 1;
      paramArrayOfByte[2] = -117;
    }
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestFromQQ2UnQQ selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin: " + paramString1 + ", businessType: " + paramInt1 + ", relationType: " + paramInt2 + ", uinType: " + paramInt2 + ", bindId: " + paramString2 + ", bindType: " + paramInt3);
      if (paramArrayOfByte != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "request sigLength: " + paramArrayOfByte.length);
        HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
      }
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "network not support!");
      }
      return -2;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "controller is null!");
      }
      return -1;
    }
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.requestVideo(paramString1, d(), paramInt1, paramInt2, paramArrayOfByte, paramString2, paramInt3);
    }
    if (i1 == 0)
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 1;
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 4)) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      }
      s();
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) {}
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString, paramInt1, false, false, true);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = -1;
        this.p = false;
        x(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
        return i1;
      }
    }
    return -1;
  }
  
  public int a(ArrayList paramArrayList)
  {
    String[] arrayOfString = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "invitePstn");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "invitePstn --> info list is null or no data");
      }
      return -1;
    }
    Object localObject = new String();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      localObject = (String)localObject + " " + ((AVPhoneUserInfo)paramArrayList.get(i1)).toString() + " .";
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "invitePstn --> InfoList = " + (String)localObject);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    i1 = 0;
    if (i1 < paramArrayList.size())
    {
      localObject = (AVPhoneUserInfo)paramArrayList.get(i1);
      if ((((AVPhoneUserInfo)localObject).accountType == 1) || (((AVPhoneUserInfo)localObject).accountType == 2))
      {
        localArrayList1.add(Long.valueOf(((AVPhoneUserInfo)localObject).accountType));
        localArrayList1.add(Long.valueOf(((AVPhoneUserInfo)localObject).account));
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((AVPhoneUserInfo)localObject).accountType == 3)
        {
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.nation);
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.prefix);
          localArrayList2.add(((AVPhoneUserInfo)localObject).telInfo.mobile);
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      paramArrayList = new long[localArrayList1.size()];
      i1 = 0;
      while (i1 < localArrayList1.size())
      {
        paramArrayList[i1] = ((Long)localArrayList1.get(i1)).longValue();
        i1 += 1;
      }
    }
    for (;;)
    {
      localObject = arrayOfString;
      if (localArrayList2.size() > 0)
      {
        arrayOfString = new String[localArrayList2.size()];
        i1 = 0;
        for (;;)
        {
          localObject = arrayOfString;
          if (i1 >= localArrayList2.size()) {
            break;
          }
          arrayOfString[i1] = ((String)localArrayList2.get(i1));
          i1 += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite(paramArrayList, localArrayList1.size() / 2, (String[])localObject, localArrayList2.size() / 3, 0, false, false, 0);
      }
      return -1;
      paramArrayList = null;
    }
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setBackground(paramBoolean);
    }
    if (!paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
    return 0;
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sharp SetAudioInputMute: " + paramBoolean);
      }
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioInputMute(paramString, paramBoolean);
    }
    return 0;
  }
  
  public long a()
  {
    return 0L;
  }
  
  long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str2;
    do
    {
      for (;;)
      {
        return 0L;
        String str1 = paramString;
        str2 = paramString;
        try
        {
          if (paramString.startsWith("+"))
          {
            str2 = paramString;
            str1 = paramString.substring(1);
          }
          str2 = str1;
          long l1 = CharacterUtil.a(str1);
          if (l1 >= 10000L) {
            return l1;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "uin = " + str2 + " is error");
    return 0L;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestStrangerFace: " + paramString + ", uinType = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().l);
    }
    Bitmap localBitmap = a(paramString, false);
    if (localBitmap != null) {
      return localBitmap;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().l);
    return null;
  }
  
  public Bitmap a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1004;
    int i1;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
      i1 = 0;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, paramString1, paramString2, paramBoolean2, paramBoolean1);
      if (paramInt == 1)
      {
        i1 = 1000;
      }
      else
      {
        i1 = i2;
        if (paramInt == 2) {
          i1 = i2;
        }
      }
    }
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (paramString == null) {}
    label142:
    do
    {
      VideoController.GAudioFriends localGAudioFriends;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 25);
            if (!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
              break label142;
            }
            if (!paramBoolean) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap == null);
          return this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap;
        } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap == null);
        return this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
          break;
        }
        localGAudioFriends = a(paramString);
      } while ((localGAudioFriends == null) || (localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getRandomFaceFromCache uin: " + paramString + ", face :" + localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      return localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap;
    } while ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap == null));
    return this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public VideoController.GAudioFriends a(String paramString)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(paramString).longValue()) {
        return (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvSessionMgr.a();
  }
  
  public VideoAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  }
  
  public AVPhoneUserInfo a(long paramLong, ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if (paramLong == localAVPhoneUserInfo.account) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processQCallPush in VideoController");
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      AVPbInfo localAVPbInfo = new AVPbInfo();
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.processQCallPush(paramArrayOfByte, localAVPbInfo);
      if ((localAVPbInfo != null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processQCallPush result, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      return localAVPbInfo;
    }
    return null;
  }
  
  String a()
  {
    try
    {
      String str = ((TelephonyManager)a().getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException) {}
    return "1234567890";
  }
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getPhoneNameByPhoneNum --> phoneNum = " + paramString);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString);
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    int i2 = 1004;
    int i1;
    if (paramInt == 1) {
      i1 = 1000;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, paramString1, paramString2);
      i1 = i2;
      if (paramInt != 2)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString1)) {
          i1 = 0;
        }
      }
    }
  }
  
  public String a(ArrayList paramArrayList)
  {
    localObject = new String();
    int i1 = 0;
    try
    {
      while (i1 < paramArrayList.size())
      {
        String str = (String)localObject + ((VideoViewInfo)paramArrayList.get(i1)).toString();
        localObject = str;
        i1 += 1;
      }
      return (String)localObject;
    }
    catch (Exception paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "getVideoViewInfoListInfo --> Get Exception = " + Log.getStackTraceString(paramArrayList));
      }
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_ComTencentAvSessionMgr.a();
  }
  
  public ArrayList a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        ArrayList localArrayList2 = new ArrayList();
        long l1 = System.currentTimeMillis();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localGAudioFriends.jdField_a_of_type_Long == paramLong1)
          {
            if (!localGAudioFriends.jdField_g_of_type_Boolean)
            {
              localGAudioFriends.jdField_h_of_type_Boolean = paramBoolean;
              localGAudioFriends.jdField_c_of_type_Long = l1;
              localGAudioFriends.jdField_d_of_type_Long = paramLong2;
            }
          }
          else
          {
            if (!localGAudioFriends.jdField_h_of_type_Boolean) {
              break label159;
            }
            localArrayList2.add(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
            break label159;
          }
          if (!localGAudioFriends.jdField_h_of_type_Boolean) {
            continue;
          }
          localGAudioFriends.jdField_h_of_type_Boolean = false;
        }
      }
      return localArrayList3;
      label159:
      i1 += 1;
    }
  }
  
  public void a()
  {
    h(0);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      if (jdField_a_of_type_Gfp != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_a_of_type_Gfp);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 1) || (jdField_b_of_type_Gfp == null));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_b_of_type_Gfp);
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int != 1);
    c(2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startTimer type = " + paramInt1 + ", act = " + paramInt2 + ", delayMillis = " + paramInt3);
    }
    if (paramInt1 == 0)
    {
      if (jdField_a_of_type_Gfp == null) {
        jdField_a_of_type_Gfp = new gfp(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_a_of_type_Gfp);
      jdField_a_of_type_Gfp.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(jdField_a_of_type_Gfp, paramInt3);
    }
    while (paramInt1 != 1) {
      return;
    }
    if (jdField_b_of_type_Gfp == null) {
      jdField_b_of_type_Gfp = new gfp(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(jdField_b_of_type_Gfp);
    jdField_b_of_type_Gfp.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(jdField_b_of_type_Gfp, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->videoSrcType=" + paramInt1 + "relationType=" + paramInt2 + "userUin=" + paramLong1 + "groupUin=" + paramLong2);
    }
    int i1 = b(paramLong1);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onVideoSrcChange-->can not find the user");
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject1 = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        i1 = 0;
        if (i1 >= this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size()) {
          break label570;
        }
        if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong1)
        {
          i2 = ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
          if (paramInt1 != 4) {
            continue;
          }
          if (i1 == -1) {
            break label564;
          }
          a(paramLong1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 0, true);
          F();
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(70), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(i2) });
          i1 = 0;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(73), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt2) });
          if (i1 == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(87), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
        }
        i1 += 1;
        continue;
        if (paramInt1 == 0) {
          break label579;
        }
        i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong1, 0);
        if (i1 == -1)
        {
          a(paramLong1, true, paramInt2, 5L);
          a((VideoController.GAudioFriends)localObject1, paramInt1);
          i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong1, 0);
          ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = paramInt1;
          i1 = 1;
          continue;
        }
        localObject1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1);
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localVideoViewInfo.jdField_a_of_type_Long = ((VideoViewInfo)localObject1).jdField_a_of_type_Long;
        localVideoViewInfo.jdField_a_of_type_Int = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(localVideoViewInfo);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList2 });
        ((VideoViewInfo)localObject1).jdField_a_of_type_Int = paramInt1;
        i1 = 1;
      }
      label564:
      i1 = 1;
      continue;
      label570:
      i1 = -1;
      int i2 = 1;
      continue;
      label579:
      i1 = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "playRing");
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (!this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt1, null, paramInt2, paramOnCompletionListener))
    {
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 0);
      c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_z_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().L)
    {
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 0);
      c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_z_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setRandomChatStatus: " + paramInt1 + ", chatType" + paramInt2 + " ,sessionName: " + paramString);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    if (localObject != null) {
      ((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int = paramInt2;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("tencent.video.v2q.setChatStatus");
    ((Intent)localObject).putExtra("status", paramInt1);
    ((Intent)localObject).putExtra("type", paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("sessionName", paramString);
    }
    if (o())
    {
      ((Intent)localObject).putExtra("guild_group_id", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long);
      ((Intent)localObject).putExtra("guild_member_num", j());
      ((Intent)localObject).putExtra("guild_business_type", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m);
    }
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    QLog.d("Lightalk-openSdk", 2, String.format("sendLightalkMsgToQQ: uinType=%d, friendUin=%s, extraUin=%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2 }));
    Intent localIntent;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddLightalkMsg");
      if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().d()) || (paramInt2 != 1)) {
        break label286;
      }
      bool1 = true;
    }
    for (;;)
    {
      localIntent.putExtra("uinType", paramInt1);
      localIntent.putExtra("msgType", paramInt2);
      localIntent.putExtra("isVideoMsg", false);
      localIntent.putExtra("isRead", bool1);
      localIntent.putExtra("bindType", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_A_of_type_Int);
      localIntent.putExtra("bindId", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_q_of_type_JavaLangString);
      if (paramInt1 == 26)
      {
        localIntent.putExtra("friendUin", paramString2);
        label178:
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean) {
          break label318;
        }
      }
      label286:
      label318:
      for (bool1 = bool2;; bool1 = false)
      {
        localIntent.putExtra("isSender", bool1);
        paramString1 = null;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long > 0L) {
          paramString1 = UITools.a(b());
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
        return;
        if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().f()) {
          break label324;
        }
        bool1 = true;
        break;
        localIntent.putExtra("friendUin", paramString1);
        break label178;
      }
      label324:
      bool1 = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartDoubleVideoMeeting");
      localIntent.putExtra("sessionType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("isReceiver", true);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize dataTransfered: dirction = " + paramInt + ", size = " + paramLong);
      }
      Intent localIntent = new Intent("tencent.video.v2q.VideoFlowSize");
      localIntent.putExtra("direction", paramInt);
      localIntent.putExtra("size", paramLong);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGAudioRoomMemList() #relationType:" + paramInt1 + " # discussId: " + paramLong + " # avtype: " + paramInt2);
    }
    if ((paramLong > 0L) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null))
    {
      this.jdField_r_of_type_Boolean = true;
      if (paramInt1 != 1) {
        break label93;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.updateRoomInfo(paramInt1, paramLong, paramInt2, true, true, true);
      return;
      label93:
      if (paramInt1 == 2)
      {
        paramInt2 = 1;
      }
      else if (paramInt1 == 3)
      {
        paramInt2 = 8;
      }
      else
      {
        paramInt2 = 0;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "Can't Support UpdateRoomInfo" + paramInt1);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramLong, paramInt2, paramInt3, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioSDKError-->GroupId=" + paramLong + "reason=" + paramInt2);
    }
    if (paramLong == 0L) {
      return;
    }
    if ((n()) && ((paramInt2 == 16) || (paramInt2 == 17)))
    {
      if (this.jdField_e_of_type_Boolean) {
        a(paramInt1, paramLong, 0, new int[0]);
      }
      c();
      if ((-19 == paramInt3) || (19 == paramInt3))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        this.jdField_i_of_type_JavaLangRunnable = null;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(200), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      return;
    }
    int i1 = UITools.b(paramInt1);
    a(a().jdField_b_of_type_JavaLangString, i1, paramInt2, false, String.valueOf(paramLong), String.valueOf(paramInt3), false);
    if (this.jdField_e_of_type_Boolean) {
      a(paramInt1, paramLong, 0, new int[] { this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_D_of_type_Int });
    }
    c();
    if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
    a();
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    String str1;
    Object localObject;
    if (paramInt1 == 3)
    {
      str1 = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (paramInt1 != 1) {
          break label91;
        }
        i1 = 2;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.ignore(paramInt1, paramLong, i1);
      if (localObject != null) {
        break label147;
      }
      return;
      str1 = SessionMgr.a(paramInt1, String.valueOf(paramLong), new int[] { SessionMgr.a().a().jdField_D_of_type_Int });
      break;
      label91:
      if (paramInt1 == 2)
      {
        i1 = 1;
      }
      else if (paramInt1 == 3)
      {
        i1 = 8;
      }
      else
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "Can't Support Ignore" + paramInt1);
        i1 = 0;
      }
    }
    label147:
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ignoreGAudioChat groupId: " + paramLong + " iFlag:" + paramInt2 + " sessionInfo.state:" + ((SessionInfo)localObject).j);
    }
    ((SessionInfo)localObject).af = true;
    int i1 = 4;
    label240:
    String str2;
    if (((SessionInfo)localObject).j == 7)
    {
      ((SessionInfo)localObject).j = 0;
      if (paramInt2 != -1)
      {
        i1 = paramInt2;
        t();
        paramInt2 = UITools.b(paramInt1);
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (i1 != 10) {
          break label361;
        }
        b(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, UITools.b(paramInt1), ((SessionInfo)localObject).t, String.valueOf(((SessionInfo)localObject).jdField_e_of_type_Long));
      }
    }
    for (;;)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str1);
      if (!paramBoolean) {
        break;
      }
      k();
      return;
      i1 = 3;
      break label240;
      if (paramInt2 == -1) {
        break label240;
      }
      i1 = paramInt2;
      break label240;
      label361:
      if (paramInt1 == 3) {
        a(str1, paramInt2, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString, String.valueOf(paramLong), i1, ((SessionInfo)localObject).t, paramBoolean, false);
      } else {
        a(str1, paramInt2, str2, String.valueOf(paramLong), i1, ((SessionInfo)localObject).t, paramBoolean, false);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int... paramVarArgs)
  {
    label1398:
    label1460:
    label1510:
    label1651:
    label1685:
    label1687:
    label1721:
    label1723:
    label1759:
    label1768:
    label1781:
    label1818:
    label1824:
    for (;;)
    {
      Object localObject1;
      long l1;
      int i1;
      Object localObject3;
      boolean bool2;
      boolean bool1;
      try
      {
        paramVarArgs = SessionMgr.a(paramInt1, String.valueOf(paramLong), paramVarArgs);
        if (paramInt1 != 3) {
          break label1824;
        }
        paramVarArgs = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
        localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "quitGAudioChat groupId: " + paramLong + ", relationType: " + paramInt1 + ", reason: " + paramInt2 + "| sessionId(" + paramVarArgs + ") sessionInfo(" + localObject1 + ")");
        }
        if (localObject1 == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
        this.jdField_i_of_type_JavaLangRunnable = null;
        if (this.jdField_f_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
          this.jdField_f_of_type_JavaLangRunnable = null;
        }
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
          continue;
        }
        if ((a().jdField_f_of_type_JavaUtilArrayList.size() > 0) && (a().ab)) {
          L();
        }
        Object localObject2;
        if ((paramInt1 == 2) && (!((SessionInfo)localObject1).ab) && (((SessionInfo)localObject1).jdField_f_of_type_JavaUtilArrayList != null))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject2).putExtra("type", 411);
          ((Intent)localObject2).putExtra("phoneList", a().jdField_f_of_type_JavaUtilArrayList);
          ((Intent)localObject2).putExtra("relationType", a().jdField_F_of_type_Int);
          ((Intent)localObject2).putExtra("relationId", a().jdField_e_of_type_Long);
          ((Intent)localObject2).putExtra("MultiAVType", a().jdField_D_of_type_Int);
          ((Intent)localObject2).putExtra("from", "VideoController2");
          ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject2);
        }
        if (paramInt1 == 7) {
          a(0, 0, null);
        }
        if (paramInt1 == 9)
        {
          ((SessionInfo)localObject1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          ((SessionInfo)localObject1).d();
          ((SessionInfo)localObject1).c();
        }
        if (paramInt1 != 2) {
          break label1398;
        }
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject1).jdField_r_of_type_JavaLangString)) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE5", "0X8004CE5", 0, 0, "", "", "", "");
        }
        if (h()) {
          ReportController.b(null, "CliOper", "", "", "0X8004CE8", "0X8004CE8", 0, 0, "", "", "", "");
        }
        if (((SessionInfo)localObject1).jdField_f_of_type_Boolean)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004CEB", "0X8004CEB", 0, 0, "", "", "", "");
          if (!((SessionInfo)localObject1).jdField_h_of_type_Boolean) {}
        }
        else
        {
          long l3 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetTrafficSize(paramLong);
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(paramInt2);
          if ((!this.jdField_e_of_type_Boolean) || (((SessionInfo)localObject1).j != 9) || (((SessionInfo)localObject1).ad)) {
            break label1759;
          }
          l1 = 0L;
          this.q = false;
          if ((((SessionInfo)localObject1).n()) && (((SessionInfo)localObject1).jdField_F_of_type_Int == 2) && (((SessionInfo)localObject1).v == 4) && (((SessionInfo)localObject1).ab) && (((SessionInfo)localObject1).jdField_f_of_type_JavaUtilArrayList.size() > 0))
          {
            localObject2 = new Intent("tencent.av.v2q.multiPsntTryEnd");
            ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject2);
          }
          if ((this.jdField_a_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != 0L)) {
            break label1818;
          }
          paramInt2 = 1;
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_e_of_type_Boolean = false;
          ((SessionInfo)localObject1).P = false;
          this.jdField_a_of_type_Long = 0L;
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
          long l2 = 0L;
          if (localObject2 != null) {
            l2 = CharacterUtil.a((String)localObject2);
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setAction("tencent.av.v2q.MultiVideo");
            ((Intent)localObject3).putExtra("type", 23);
            ((Intent)localObject3).putExtra("friendUin", l2);
            ((Intent)localObject3).putExtra("relationId", paramLong);
            ((Intent)localObject3).putExtra("relationType", paramInt1);
            ((Intent)localObject3).putExtra("MultiAVType", ((SessionInfo)localObject1).jdField_D_of_type_Int);
            ((Intent)localObject3).putExtra("time", l1);
            ((Intent)localObject3).putExtra("isStart", this.v);
            ((Intent)localObject3).putExtra("PLACE", a().jdField_u_of_type_JavaLangString);
            ((Intent)localObject3).putExtra("from", "VideoController3");
            if (i1 <= 1) {
              break label1768;
            }
            ((Intent)localObject3).putExtra("roomUserNum", i1 - 1);
            bool2 = false;
            if (!((SessionInfo)localObject1).ab) {
              break label1781;
            }
            bool1 = bool2;
            if (((SessionInfo)localObject1).jdField_e_of_type_JavaUtilArrayList != null)
            {
              bool1 = bool2;
              if (((SessionInfo)localObject1).jdField_e_of_type_JavaUtilArrayList.size() > 0) {
                bool1 = true;
              }
            }
            ((Intent)localObject3).putExtra("hasPstn", bool1);
            ((Intent)localObject3).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "quitGAudioChat: send broadcast of quit chatting");
            }
          }
          ((SessionInfo)localObject1).jdField_r_of_type_JavaLangString = null;
          ((SessionInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString = null;
          t();
          if (((SessionInfo)localObject1).jdField_c_of_type_JavaUtilArrayList.size() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), ((SessionInfo)localObject1).jdField_c_of_type_JavaUtilArrayList });
          }
          if (((SessionInfo)localObject1).jdField_F_of_type_Int == 1) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(410), Long.valueOf(paramLong) });
          }
          localObject3 = ((SessionInfo)localObject1).t;
          if (((SessionInfo)localObject1).jdField_F_of_type_Int == 1) {
            ((SessionInfo)localObject1).jdField_f_of_type_Boolean = false;
          }
          ((SessionInfo)localObject1).e();
          r();
          TipsManager.c(108);
          if (paramInt2 == 0) {
            a(paramVarArgs, UITools.b(paramInt1), (String)localObject2, String.valueOf(paramLong), 7, (String)localObject3, false, false);
          }
          ((SessionInfo)localObject1).l = -1;
          ((SessionInfo)localObject1).l = -1;
          ((SessionInfo)localObject1).jdField_k_of_type_Boolean = true;
          this.jdField_b_of_type_Long = l3;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "netTrafficSize size = " + l3);
          }
          localObject1 = new Intent("tencent.video.v2q.VideoFlowSize");
          ((Intent)localObject1).putExtra("size", l3);
          ((Intent)localObject1).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
          if (paramInt2 == 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject1);
          }
          bool1 = this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
          localObject1 = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          if ((localObject1 != null) && (((QAVNotification)localObject1).a()))
          {
            ((QAVNotification)localObject1).a(paramVarArgs);
            if (bool1) {
              k();
            }
          }
          PopupDialog.a();
          continue;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CEF ", "0X8004CEF ", 0, 0, "", "", "", "");
      }
      finally {}
      continue;
      if (paramInt1 == 1)
      {
        if ("DEVICE_EARPHONE".equals(((SessionInfo)localObject1).jdField_r_of_type_JavaLangString))
        {
          if (((SessionInfo)localObject1).jdField_D_of_type_Int == 10) {
            ReportController.b(null, "CliOper", "", "", "0X8005942", "0X8005942", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (h())
          {
            if (((SessionInfo)localObject1).jdField_D_of_type_Int != 10) {
              break label1651;
            }
            ReportController.b(null, "CliOper", "", "", "0X8005943", "0X8005943", 0, 0, "", "", "", "");
          }
          if (!((SessionInfo)localObject1).jdField_f_of_type_Boolean) {
            break label1685;
          }
          if (((SessionInfo)localObject1).jdField_D_of_type_Int != 10) {
            break label1687;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005944", "0X8005944", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (((SessionInfo)localObject1).jdField_h_of_type_Boolean) {
            break label1721;
          }
          if (((SessionInfo)localObject1).jdField_D_of_type_Int != 10) {
            break label1723;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005945 ", "0X8005945 ", 0, 0, "", "", "", "");
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004F54", "0X8004F54", 0, 0, "", "", "", "");
          break label1460;
          ReportController.b(null, "CliOper", "", "", "0X8004F55", "0X8004F55", 0, 0, "", "", "", "");
          break label1510;
          break;
          ReportController.b(null, "CliOper", "", "", "0X8004F56", "0X8004F56", 0, 0, "", "", "", "");
        }
        continue;
        ReportController.b(null, "CliOper", "", "", "0X8004F57 ", "0X8004F57 ", 0, 0, "", "", "", "");
        continue;
        l1 = b();
        continue;
        ((Intent)localObject3).putExtra("roomUserNum", 0);
        continue;
        bool1 = bool2;
        if (((SessionInfo)localObject1).jdField_f_of_type_JavaUtilArrayList != null)
        {
          i1 = ((SessionInfo)localObject1).jdField_f_of_type_JavaUtilArrayList.size();
          bool1 = bool2;
          if (i1 > 0)
          {
            bool1 = true;
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (paramInt1 == 90) {
      if (paramLong1 == 3L) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(true, false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      }
      return;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(false, false);
      continue;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(false, false);
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(502), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(500), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean, int paramInt2, int paramInt3, MeetingInfo paramMeetingInfo)
  {
    c(false);
    boolean bool = a().jdField_B_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite: " + paramLong2 + " # groupId: " + paramLong1 + " # multiSubType: " + paramInt3 + " # relationType:" + paramInt1);
    }
    if (paramInt1 == 1) {}
    Object localObject;
    do
    {
      return;
      i();
      localObject = SessionMgr.a(paramInt1, String.valueOf(paramLong1), new int[] { paramInt2 });
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "Session already exists, just return.");
    return;
    SessionInfo localSessionInfo1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject, false);
    localSessionInfo1.jdField_e_of_type_Long = paramLong1;
    localSessionInfo1.jdField_F_of_type_Int = paramInt1;
    localSessionInfo1.jdField_D_of_type_Int = paramInt2;
    localSessionInfo1.af = false;
    if (paramMeetingInfo != null)
    {
      paramBoolean = true;
      localSessionInfo1.S = paramBoolean;
      if (paramMeetingInfo == null) {
        break label292;
      }
      if (paramMeetingInfo.getType() != 2) {
        break label286;
      }
      paramBoolean = true;
      label205:
      localSessionInfo1.T = paramBoolean;
      if (paramMeetingInfo == null) {
        break label304;
      }
      if (paramMeetingInfo.getType() != 3) {
        break label298;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      localSessionInfo1.U = paramBoolean;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() < 2) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite->pending session exists, just reject.");
      }
      a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
      return;
      paramBoolean = false;
      break;
      label286:
      paramBoolean = false;
      break label205;
      label292:
      paramBoolean = false;
      break label205;
      label298:
      paramBoolean = false;
      continue;
      label304:
      paramBoolean = false;
    }
    label310:
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
    }
    SessionInfo localSessionInfo2 = SessionMgr.a().a();
    if ((localSessionInfo2 != null) && (!localSessionInfo2.a())) {
      paramInt2 = 1;
    }
    for (;;)
    {
      label351:
      if (this.jdField_g_of_type_JavaLangRunnable != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite not online");
        }
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
        }
        this.jdField_g_of_type_JavaLangRunnable = null;
        localSessionInfo1.j = 0;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
      for (paramBoolean = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext());; paramBoolean = false)
      {
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j <= 4) && (paramInt3 != 3) && (paramBoolean))
        {
          a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
          return;
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g())) {
            break label2711;
          }
          paramInt2 = 1;
          break label351;
        }
        if ((7 == this.jdField_a_of_type_ComTencentAvSessionMgr.a().j) && (paramBoolean))
        {
          a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
          return;
        }
        if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1) && (paramBoolean))
        {
          a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
          return;
        }
        if (((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 14) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 13)) && (paramBoolean))
        {
          a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
          return;
        }
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) && (paramBoolean))
        {
          a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite->matchStatus = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + ", chatType = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + ", SessionType = " + localSessionInfo1.jdField_f_of_type_Int);
        }
        if (localSessionInfo1.jdField_f_of_type_Int == 0)
        {
          localSessionInfo1.jdField_a_of_type_Boolean = true;
          localSessionInfo1.jdField_f_of_type_Int = 3;
          localSessionInfo1.l = UITools.b(paramInt1);
          localSessionInfo1.jdField_c_of_type_JavaLangString = String.valueOf(paramLong2);
          localSessionInfo1.jdField_a_of_type_Boolean = true;
          a((String)localObject, localSessionInfo1.jdField_f_of_type_Int, false, false, false);
        }
        this.jdField_e_of_type_Long = paramLong1;
        this.an = paramInt1;
        if (localSessionInfo1.j == 0) {
          localSessionInfo1.j = 7;
        }
        int i1;
        if ((paramInt3 == 3) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long == 0L))
        {
          i1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString != null)
          {
            i1 = paramInt2;
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(paramLong2)))
            {
              localSessionInfo1.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean;
              i1 = 0;
              try
              {
                if (paramLong2 != Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue()) {
                  break label2116;
                }
                if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_z_of_type_Int == 0)
                {
                  this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 0;
                  this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
                  return;
                }
              }
              catch (Exception paramArrayOfLong)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramArrayOfLong.getMessage());
                }
                this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
                return;
              }
              if ((this.jdField_c_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              }
              if (!a().O) {
                a(2131165195, 1, null);
              }
              paramInt2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).H = this.jdField_a_of_type_ComTencentAvSessionMgr.a().H;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_r_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_r_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_k_of_type_Int = 12;
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_k_of_type_Int = 12;
              c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 21);
              if (paramInt2 == 1)
              {
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_f_of_type_Int = 3;
                label1289:
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).l = 3000;
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_e_of_type_Long = paramLong1;
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).s = Long.toString(paramLong1);
                if (paramArrayOfLong != null) {
                  this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_b_of_type_ArrayOfLong = paramArrayOfLong;
                }
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_E_of_type_Int = 1;
                if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() <= 0) {
                  break label1521;
                }
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).O = true;
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
              }
              for (;;)
              {
                paramArrayOfLong = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                paramBoolean = false;
                if (paramArrayOfLong != null)
                {
                  bool = paramArrayOfLong.a();
                  paramBoolean = bool;
                  if (bool)
                  {
                    paramArrayOfLong.a((String)localObject);
                    paramBoolean = bool;
                  }
                }
                if (!paramBoolean) {
                  break;
                }
                k();
                return;
                if (paramInt2 == 2)
                {
                  this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_f_of_type_Int = 4;
                  break label1289;
                }
                if (paramInt2 == 4)
                {
                  this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_f_of_type_Int = 4;
                  break label1289;
                }
                this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_f_of_type_Int = 3;
                break label1289;
                label1521:
                if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop)
                {
                  this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).O = false;
                  a(paramInt1, paramLong1, paramArrayOfLong, false);
                }
              }
            }
          }
        }
        else
        {
          i1 = paramInt2;
          if (paramInt3 == 4)
          {
            i1 = paramInt2;
            if (bool)
            {
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_B_of_type_Boolean = false;
              i1 = paramInt2;
              if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString != null)
              {
                i1 = paramInt2;
                if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString.equalsIgnoreCase(String.valueOf(paramLong2))) {
                  for (;;)
                  {
                    try
                    {
                      localSessionInfo1.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean;
                      i1 = 0;
                      if (paramLong2 != Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue()) {
                        break label2116;
                      }
                      if ((this.jdField_d_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
                        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
                      }
                      if (!a().O) {
                        a(2131165195, 1, null);
                      }
                      paramInt2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int;
                      this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString;
                      if ((a().j == 15) || (a().jdField_A_of_type_Boolean)) {
                        f(false);
                      }
                      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_k_of_type_Int = 12;
                      if (paramInt2 == 1)
                      {
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 3;
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().l = 3000;
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long = paramLong1;
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().s = Long.toString(paramLong1);
                        if (paramArrayOfLong != null) {
                          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_ArrayOfLong = paramArrayOfLong;
                        }
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_E_of_type_Int = 1;
                        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
                        {
                          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() <= 0) {
                            break label2082;
                          }
                          this.jdField_a_of_type_ComTencentAvSessionMgr.a().O = true;
                          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
                        }
                        paramArrayOfLong = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                        paramBoolean = false;
                        if (paramArrayOfLong != null)
                        {
                          bool = paramArrayOfLong.a();
                          paramBoolean = bool;
                          if (bool)
                          {
                            paramArrayOfLong.a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
                            paramBoolean = bool;
                          }
                        }
                        if (!paramBoolean) {
                          break;
                        }
                        k();
                        return;
                      }
                    }
                    catch (Exception paramArrayOfLong)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteError-->Exception=" + paramArrayOfLong.getMessage());
                      }
                      this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
                      return;
                    }
                    if (paramInt2 == 2)
                    {
                      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 4;
                    }
                    else if (paramInt2 == 4)
                    {
                      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 4;
                    }
                    else
                    {
                      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 3;
                      continue;
                      label2082:
                      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop)
                      {
                        this.jdField_a_of_type_ComTencentAvSessionMgr.a().O = false;
                        a(paramInt1, paramLong1, paramArrayOfLong, false);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label2116:
        if (i1 != 0)
        {
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite->a session exists,isScreenLocked:true, just reject.");
            }
            a((String)localObject, paramInt1, String.valueOf(paramLong2), String.valueOf(paramLong1));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite->a session exists,isScreenLocked:false");
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvite phone is calling");
          }
          paramArrayOfLong = new Intent();
          paramArrayOfLong.setAction("tencent.video.v2q.CallingDialogMulti");
          paramArrayOfLong.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
          paramArrayOfLong.putExtra("friendUin", paramLong2);
          paramArrayOfLong.putExtra("sessionType", 3);
          paramArrayOfLong.putExtra("uinType", 3000);
          paramArrayOfLong.putExtra("relationType", paramInt1);
          paramArrayOfLong.putExtra("extraUin", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_JavaLangString);
          paramArrayOfLong.putExtra("discussId", paramLong1);
          paramArrayOfLong.putExtra("type", 13);
          paramArrayOfLong.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          paramArrayOfLong.putExtra("isSender", false);
          paramArrayOfLong.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
          paramArrayOfLong.putExtra("realSenderUin", this.jdField_a_of_type_ComTencentAvSessionMgr.a().t);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramArrayOfLong);
          a(this.an, paramLong1, true);
          new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a(0, 2131165196, null, null, false, 1, false, true, 0);
          this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
          return;
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().t = ("" + paramLong2);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
          break;
        }
        if (i1 != 0)
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), MultiIncomingCallsActivity.class);
          ((Intent)localObject).putExtra("uinType", UITools.b(paramInt1));
          ((Intent)localObject).putExtra("peerUin", String.valueOf(paramLong2));
        }
        for (;;)
        {
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).putExtra("friendUin", paramLong2);
          ((Intent)localObject).putExtra("relationType", paramInt1);
          ((Intent)localObject).putExtra("discussId", paramLong1);
          ((Intent)localObject).putExtra("memberList", paramArrayOfLong);
          if (paramMeetingInfo != null)
          {
            paramArrayOfLong = new Bundle();
            paramArrayOfLong.putParcelable("meetingInfo", paramMeetingInfo);
            ((Intent)localObject).putExtras(paramArrayOfLong);
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity((Intent)localObject);
          return;
          if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext()))
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), GaInviteLockActivity.class);
            u();
          }
          else
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), GaInviteDialogActivity.class);
          }
        }
      }
      label2711:
      paramInt2 = 0;
    }
  }
  
  public void a(int paramInt, long paramLong, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPstnErrorMsgCome --> Msg Type = " + paramInt + " , relationId = " + paramLong);
    }
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onPstnErrorMsgCome --> Is not in GAudioRoom Or RelationId is not equal. --> IsInRoom = " + this.jdField_a_of_type_Long + " ,mGAudioGroupId = " + this.jdField_a_of_type_Long);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(407), Integer.valueOf(paramInt), paramArrayList });
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt, paramLong, -1, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioTerminalEnterRoom,relationTye: " + paramInt + " GroupId: " + paramLong);
    }
    paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong), paramVarArgs);
    if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs)) && (paramInt == 3)) {
      paramVarArgs = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
    }
    for (;;)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs);
      if ((localSessionInfo != null) && ((localSessionInfo.j == 7) || (localSessionInfo.j == 2)))
      {
        localSessionInfo.j = 0;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(1) });
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs))
        {
          if (paramInt == 3)
          {
            localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramVarArgs);
            paramInt = UITools.b(paramInt);
            a(localSessionInfo.jdField_b_of_type_JavaLangString, paramInt, 7, true, String.valueOf(paramLong), null, false);
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramVarArgs);
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioTerminalEnterRoom not in invite");
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr == null) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a() == null) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString == null)) {}
    while (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    switch (paramInt)
    {
    case 0: 
    case 3: 
    default: 
      return;
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onAVShiftEvent remote switch to video mode,waiting for confirm");
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "remote confirm switch to video");
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    int i1 = 2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendAnotherChatingBroadcast session:" + paramInt2 + ", peerUin:" + paramString + "， roomid：" + paramLong);
      }
      if (paramInt2 != 3) {
        break label289;
      }
      i1 = 10;
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr;
      localObject1 = SessionMgr.a(SessionMgr.a(paramInt1), paramString, new int[] { i1 });
      Object localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("tencent.av.v2q.AnotherTerChating");
      ((Intent)localObject2).putExtra("sessionType", paramInt2);
      if ((((SessionInfo)localObject1).jdField_h_of_type_Int == paramInt2) && (paramString.equalsIgnoreCase(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString)) && (((SessionInfo)localObject1).jdField_a_of_type_Boolean)) {
        ((Intent)localObject2).putExtra("isReceiver", true);
      }
      ((Intent)localObject2).putExtra("uinType", paramInt1);
      ((Intent)localObject2).putExtra("peerUin", paramString);
      ((Intent)localObject2).putExtra("bindType", ((SessionInfo)localObject1).jdField_A_of_type_Int);
      ((Intent)localObject2).putExtra("bindId", ((SessionInfo)localObject1).jdField_q_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("roomId", paramLong);
      ((Intent)localObject2).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject2);
      return;
      label289:
      if (paramInt2 != 4) {
        i1 = -1;
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendReplyMsgToAio uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", replyMsg: " + paramString4 + ", isDiyMsg: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.replyMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("replyMsg", paramString4);
      localIntent.putExtra("isDiyMsg", paramBoolean);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendLeaveMsg uinType: " + paramInt + ", friendUin: " + paramString1 + ", friendName: " + paramString2 + ", extraUin: " + paramString3 + ", isPtt: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.leaveMsg");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("friendUin", paramString1);
      localIntent.putExtra("friendName", paramString2);
      paramString2 = paramString3;
      if (paramInt == 1006)
      {
        paramString2 = paramString3;
        if (paramString3 == null) {
          paramString2 = paramString1;
        }
      }
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("isPtt", paramBoolean);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgSigBroadcast uinType: " + paramInt + ", peerUin: " + paramString1 + ", extraUin: " + paramString2 + ", sig = " + paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      localIntent.setAction("tencent.video.v2q.AddMsgSig");
      localIntent.putExtra("uinType", paramInt);
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("extraUin", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean, String paramString3, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo uinType = " + paramInt1 + ", fromUin = " + paramString1 + ", extraUin = " + paramString2 + ", sig = " + paramArrayOfByte + ", onlyAudio = " + paramBoolean + ", bindID=" + paramString3 + " ,bindType=" + paramInt2);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {
      return;
    }
    if ((Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) || (!VcSystemInfo.d())) {}
    for (boolean bool1 = true;; bool1 = paramBoolean)
    {
      VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
      paramInt1 = a(paramInt1, paramString1, false, paramInt2);
      if (paramInt3 == 2800) {
        paramInt1 = 2800;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo converted uinType = " + paramInt1);
      }
      String str;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists");
        }
        int i1 = -1;
        str = null;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() != null)
        {
          i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().l;
          str = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString;
        }
        if ((paramInt1 != 1011) || (i1 != 1011) || (str == null) || (!str.equals(paramString1))) {
          break label457;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists, equals to the current one.");
        }
      }
      boolean bool2 = false;
      paramBoolean = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->isScreenLocked:" + paramBoolean);
      }
      if ((paramInt1 != 21) && (paramInt1 != 1011) && ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || (this.jdField_f_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in Random Double");
        }
        if (paramBoolean)
        {
          a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
          return;
          label457:
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo->pending session exists, just reject.");
          }
          a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
          return;
        }
        paramBoolean = true;
        if (this.jdField_f_of_type_Boolean) {
          break label1878;
        }
        a(30000L);
        paramBoolean = true;
        label508:
        str = SessionMgr.a(3, paramString1, new int[0]);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_A_of_type_Int = paramInt2;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_q_of_type_JavaLangString = paramString3;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_B_of_type_Int = paramInt1;
        if (!VideoUtils.a(paramInt1, paramInt2)) {
          break label1983;
        }
        if ((paramString2 == null) || (paramString2.startsWith("+"))) {
          break label1980;
        }
        paramString2 = "+" + paramString2;
        label628:
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_g_of_type_JavaLangString = paramString2;
        a(paramArrayOfByte, paramString1, paramInt2, paramInt1, paramString2);
      }
      label1878:
      label1897:
      label1980:
      label1983:
      for (;;)
      {
        if (this.jdField_g_of_type_JavaLangRunnable != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_g_of_type_JavaLangRunnable);
          this.jdField_g_of_type_JavaLangRunnable = null;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).j = 0;
        }
        if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
          paramInt1 = 9500;
        }
        for (;;)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = bool1;
          if (bool1) {}
          for (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_h_of_type_Int = 1;; this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_h_of_type_Int = 2)
          {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).l = paramInt1;
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_c_of_type_JavaLangString = paramString1;
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_e_of_type_JavaLangString = paramString2;
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).j = 2;
            this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_r_of_type_Int = paramInt3;
            a(paramInt1, paramString1, paramString2, paramArrayOfByte);
            if ((!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b() == -1)) {
              break label1897;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "recv video request when phone isn't idle: fromUin = " + paramString1);
            }
            paramString2 = new Intent();
            paramString2.setAction("tencent.video.v2q.CallingDialog");
            paramString2.putExtra("isAudio", bool1);
            paramString2.putExtra("friendUin", paramString1);
            paramString2.putExtra("uinType", paramInt1);
            paramString2.putExtra("type", 1);
            paramString2.putExtra("senderUin", paramString1);
            paramString2.putExtra("isSender", false);
            paramString2.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramString2);
            new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a(0, 2131165196, null, null, false, 1, false, true, 0);
            this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, d(), 3);
            a(paramString1, 0);
            c(paramString1, 1);
            return;
            if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in Random mulit");
              }
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              paramBoolean = true;
              break label508;
            }
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a())
            {
              if (paramInt1 == -1)
              {
                this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString1, d());
                this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString1, 0);
                a();
                return;
              }
              paramBoolean = bool2;
              if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g()) {
                break label1878;
              }
              paramBoolean = true;
              break label508;
            }
            if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().g()) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().h()))
            {
              l();
              c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 2);
              paramBoolean = false;
              break label508;
            }
            if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 7) && (this.jdField_e_of_type_Long != 0L))
            {
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              paramBoolean = true;
              break label508;
            }
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 14)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when double video meeting connected: fromUin = " + paramString1);
              }
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              paramBoolean = true;
              break label508;
            }
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 13)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when double video meeting invite: fromUin = " + paramString1);
              }
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              paramBoolean = true;
              break label508;
            }
            if (!this.jdField_e_of_type_Boolean)
            {
              if (((paramInt1 == 21) || (paramInt1 == 1011)) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString != null))
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo  auto Accept");
                }
                if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString.equals(paramString1)))
                {
                  a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                  return;
                }
                a(30000L);
                paramBoolean = false;
                break label508;
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when chatting: fromUin = " + paramString1);
              }
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              bool2 = true;
              paramBoolean = bool2;
              if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString == null) {
                break label1878;
              }
              paramBoolean = bool2;
              if (!paramString1.equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) {
                break label1878;
              }
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when request: fromUin = " + paramString1);
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
              paramBoolean = false;
              break label508;
            }
            if ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 8))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when in group chat, fromUin = " + paramString1);
              }
              if (paramBoolean)
              {
                a(false, paramInt1, paramString1, paramString2, paramInt2, paramString3, bool1);
                return;
              }
              paramBoolean = true;
              break label508;
            }
            paramBoolean = bool2;
            if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideo when is inviting, fromUin = " + paramString1);
              }
              paramBoolean = bool2;
              if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString != null)
              {
                if (paramString1.equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) {
                  break;
                }
                paramBoolean = bool2;
              }
            }
            break label508;
          }
          if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).l != 21) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).l != 1011)) {
            a(str, this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_h_of_type_Int, false, false, true);
          }
          a(str, paramInt1, paramString1, paramString2, bool1, false, paramBoolean, paramInt2);
          return;
        }
        break label628;
      }
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramInt)
    {
      AVUserInfo localAVUserInfo = (AVUserInfo)paramArrayList.get(i1);
      a(localAVUserInfo.jdField_a_of_type_Long, localAVUserInfo.jdField_a_of_type_Int, localAVUserInfo.jdField_b_of_type_Int, false);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(141), paramArrayList });
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyOtherTerminalChatStatus time:" + paramInt + ", camera:" + paramBoolean1 + ", mic:" + paramBoolean2);
    }
    int i1;
    if (paramBoolean1)
    {
      i1 = 1;
      if (!paramBoolean2) {
        break label122;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherTerChatStatus(Long.valueOf(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString).longValue(), (i2 << 21) + ((i1 << 20) + (paramInt & 0xFFFFF)));
      }
      return;
      i1 = 0;
      break;
      label122:
      i2 = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startCheckAnyChatReqTimeout ms: " + paramLong);
    }
    if (this.jdField_a_of_type_Gfg == null) {
      this.jdField_a_of_type_Gfg = new gfg(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gfg, paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    String str = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
    Object localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + paramLong);
      }
      return;
    }
    ((SessionInfo)localObject).j = 0;
    if (paramInt == 23) {
      a(str, 0, true, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 403);
      localIntent.putExtra("relationType", 3);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("friendUin", paramLong);
      localIntent.putExtra("MultiAVType", ((SessionInfo)localObject).jdField_D_of_type_Int);
      localIntent.putExtra("from", "VideoController4");
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      boolean bool = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject == null) || (!((QAVNotification)localObject).a())) {
        break;
      }
      ((QAVNotification)localObject).a(str);
      if (!bool) {
        break;
      }
      k();
      return;
      a(str, 0, paramInt, true, "" + paramLong, "" + paramLong, false);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioKickOut-->Groupid=" + paramLong + " relationType=" + paramInt1);
    }
    int i1 = UITools.b(paramInt1);
    if ((this.jdField_e_of_type_Boolean) && (paramLong == this.jdField_a_of_type_Long))
    {
      this.y = true;
      if (paramInt1 != 3) {
        break label233;
      }
      a(a().jdField_b_of_type_JavaLangString, i1, 7, false, String.valueOf(paramLong), null, false);
      if (i1 != 3000) {
        break label258;
      }
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (a().jdField_z_of_type_Boolean) {
        ReportController.b(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
      }
      a(this.jdField_E_of_type_Int, this.jdField_a_of_type_Long, 0, new int[] { paramInt2 });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong) });
      a();
      return;
      label233:
      a(a().jdField_b_of_type_JavaLangString, i1, 20, false, String.valueOf(paramLong), null, false);
      break;
      label258:
      if (i1 == 1) {
        if (a().jdField_D_of_type_Int == 10) {
          ReportController.b(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = a(paramLong, paramInt1, paramInt2, paramBoolean);
    if ((paramLong == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin()) && (this.q != paramBoolean) && (QLog.isColorLevel())) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "uin = " + paramLong + "mGAudioMute = " + this.q + "  isMicOff = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(138), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (bool)) {
      a(0L, false, 0L);
    }
  }
  
  public void a(long paramLong, int paramInt, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onEnterSuc-->GroupId=" + paramLong);
    }
    c();
    a().ap = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, " OnEnterSuc--> SetAccepting False. SessionId = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
    }
    if (paramInt == 3)
    {
      a().j = 14;
      a().jdField_A_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(80), Long.valueOf(paramLong) });
      return;
      this.jdField_e_of_type_Boolean = true;
      paramVarArgs = SessionMgr.a(paramInt, String.valueOf(paramLong), paramVarArgs);
      paramVarArgs = SessionMgr.a().a(paramVarArgs);
      if (paramVarArgs != null)
      {
        paramVarArgs.P = true;
        paramVarArgs.jdField_D_of_type_Boolean = false;
      }
      if (a().jdField_g_of_type_JavaUtilArrayList.size() > 0) {
        K();
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(90), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        paramInt1 = b(paramLong2);
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        if (paramInt2 == 1)
        {
          return;
          localGAudioFriends.jdField_d_of_type_Boolean = false;
        }
      }
      if (paramInt2 != 3) {
        if (paramInt2 != 4) {}
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int paramInt3)
  {
    if (paramLong2 == 0L) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGaChatUserInOrOut-->userUin is 0,OpType = " + paramInt1);
      }
    }
    do
    {
      return;
      switch (paramInt1)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "Wrong type of GaChatMemBerInType,and Type = " + paramInt1 + " groupUin=" + paramLong1 + " userUin=" + paramLong2);
    return;
    a(paramLong1, paramLong2, true);
    return;
    a(paramLong1, paramLong2, false);
    return;
    a(paramLong1, paramLong2, true, paramInt2, paramLong3, paramInt3);
    return;
    a(paramLong1, paramLong2, false, paramInt2, paramLong3, paramInt3);
    return;
    a(paramLong1, paramLong2, true, paramInt2, false, paramLong3, paramInt3);
    return;
    a(paramLong1, paramLong2, false, paramInt2, false, paramLong3, paramInt3);
    return;
    a(Long.valueOf(paramLong1), paramLong2, paramInt2, true);
    return;
    a(Long.valueOf(paramLong1), paramLong2, paramInt2, false);
    return;
    a(paramLong1, paramLong2, true, paramInt2, true, paramLong3, paramInt3);
    return;
    a(paramLong1, paramLong2, false, paramInt2, true, paramLong3, paramInt3);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt2)
    {
    }
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, true);
        }
      } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().aa = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(302), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(paramLong1) });
      return;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.modifyGroupAdmin(paramLong2, false);
      }
    } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Long != paramLong1));
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().aa = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(303), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong1)) {
      a(1, paramLong1, 0, new int[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(89), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 0;
      a(1, paramLong1, 17, 0);
    }
  }
  
  void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMemberSpeak-->setSpeakingUin,uin=" + paramLong2 + "isSpeaking" + paramBoolean);
    }
    boolean bool = b(paramLong2, paramBoolean);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(63), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long != paramLong) || (paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(82), paramString, paramArrayOfString });
  }
  
  public void a(long paramLong, ArrayList paramArrayList)
  {
    int i2 = paramArrayList.size();
    long[] arrayOfLong = new long[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)paramArrayList.get(i1);
      if (str != null) {
        arrayOfLong[i1] = Long.valueOf(str).longValue();
      }
      i1 += 1;
    }
    a(arrayOfLong, false, 1, ConfigSystemImpl.c(a()));
  }
  
  void a(long paramLong, ArrayList paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          ((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int = paramInt;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate-->mSimpleDataList is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
      localGAudioFriends.jdField_a_of_type_Long = ((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Long;
      localGAudioFriends.jdField_c_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Int;
      localGAudioFriends.jdField_d_of_type_Int = ((AVUserInfo)paramArrayList.get(i1)).jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaUtilArrayList.add(localGAudioFriends);
      if (((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) {
        localArrayList.add(Long.valueOf(((AVUserInfo)paramArrayList.get(i1)).jdField_a_of_type_Long));
      }
      i1 += 1;
    }
    if (localArrayList.size() > 0) {
      a(localArrayList);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void a(long paramLong, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size()) {
        if (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong)
        {
          if (paramBoolean)
          {
            paramArrayList.remove(i1);
          }
          else
          {
            if (paramInt == ((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int)
            {
              paramArrayList.remove(i1);
              return;
            }
            i1 += 1;
          }
        }
        else {
          i1 += 1;
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend();
      if (paramBoolean) {
        break label80;
      }
    }
    label69:
    label80:
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      paramLong = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      if ((!paramBoolean) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        a(this.jdField_a_of_type_Long, paramLong, paramBoolean);
      }
      return;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend();
      break;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "quitDoubleVideoMeeting-->RelationId = " + paramLong);
    }
    String str = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
    if (localSessionInfo == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 402);
    localIntent.putExtra("relationType", 3);
    localIntent.putExtra("relationId", paramLong);
    localIntent.putExtra("friendUin", paramLong);
    localIntent.putExtra("MultiAVType", localSessionInfo.jdField_D_of_type_Int);
    localIntent.putExtra("from", "VideoController6");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    a(str, 0, paramInt, true, "" + paramLong, "" + paramLong, false);
    if (paramBoolean)
    {
      a(3, paramLong, 0, new int[0]);
      localSessionInfo.jdField_A_of_type_Boolean = false;
      localSessionInfo.jdField_z_of_type_Boolean = false;
      return;
    }
    localSessionInfo.j = 15;
    a(2131165198, 1, this.jdField_c_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    ArrayList localArrayList = a(paramLong1, paramBoolean, paramLong2);
    if (localArrayList != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(142), localArrayList, Integer.valueOf(localArrayList.size()) });
    }
    if (paramLong1 == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue())
    {
      if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
      }
      ReportController.b(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getSharedPreferences(jdField_h_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 0).edit();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte.length > 0) {
        localObject1 = new String(paramArrayOfByte);
      }
    }
    localEditor.putLong("reoldEngineC2CSwitch", paramLong);
    localEditor.putString("reoldEngineC2CMsg", (String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "[reoldEngine] recv onOldRequestC2CMsgSwitch, disable(" + paramLong + ") promptMsg(" + (String)localObject1 + ")");
    }
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate");
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onGAudioMemAllUpdate-->mSimpleDataList is null");
      }
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (paramArrayOfLong == null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    paramInt2 = 0;
    while (paramInt2 < paramArrayOfLong.length)
    {
      VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends(this);
      localGAudioFriends.jdField_a_of_type_Long = paramArrayOfLong[paramInt2];
      this.jdField_b_of_type_JavaUtilArrayList.add(localGAudioFriends);
      paramInt2 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(64), Long.valueOf(paramLong), this.jdField_b_of_type_JavaUtilArrayList, Integer.valueOf(paramInt1) });
  }
  
  public void a(long paramLong, long[] paramArrayOfLong, ArrayList paramArrayList)
  {
    Object localObject;
    int i1;
    if (paramArrayOfLong != null)
    {
      localObject = SessionMgr.a(2, String.valueOf(paramLong), new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject, false);
      if (paramArrayList != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(PstnUtils.a((String)paramArrayList.next()));
        }
        ((SessionInfo)localObject).a(localArrayList);
        ((SessionInfo)localObject).jdField_g_of_type_JavaUtilArrayList = localArrayList;
      }
      i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int;
      ((SessionInfo)localObject).jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean;
      ((SessionInfo)localObject).jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean;
      ((SessionInfo)localObject).H = this.jdField_a_of_type_ComTencentAvSessionMgr.a().H;
      ((SessionInfo)localObject).jdField_r_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_r_of_type_JavaLangString;
      ((SessionInfo)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString;
      ((SessionInfo)localObject).jdField_D_of_type_Int = 1;
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_z_of_type_Boolean) {
        break label404;
      }
      boolean bool = this.q;
      a(Long.valueOf(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString).longValue(), true, 0);
      this.q = bool;
      this.H = 2;
      ((SessionInfo)localObject).jdField_b_of_type_ArrayOfLong = paramArrayOfLong;
      ((SessionInfo)localObject).jdField_z_of_type_Int = -1;
      if (i1 != 1) {
        break label443;
      }
      ((SessionInfo)localObject).jdField_f_of_type_Int = 3;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      ((SessionInfo)localObject).l = 3000;
      ((SessionInfo)localObject).jdField_e_of_type_Long = paramLong;
      ((SessionInfo)localObject).s = Long.toString(paramLong);
      ((SessionInfo)localObject).O = true;
      ((SessionInfo)localObject).jdField_E_of_type_Int = 0;
      ((SessionInfo)localObject).jdField_u_of_type_Int = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
      ((SessionInfo)localObject).v = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d();
      paramArrayOfLong = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 3))
      {
        this.M = paramArrayOfLong[1];
        this.N = paramArrayOfLong[2];
        this.O = paramArrayOfLong[0];
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      return;
      label404:
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 1);
      c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 21);
      this.H = 1;
      break;
      label443:
      if (i1 == 2) {
        ((SessionInfo)localObject).jdField_f_of_type_Int = 4;
      } else if (i1 == 3) {
        ((SessionInfo)localObject).jdField_f_of_type_Int = 3;
      } else if (i1 == 4) {
        ((SessionInfo)localObject).jdField_f_of_type_Int = 3;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(Bundle paramBundle)
  {
    g(4);
    boolean bool1 = paramBundle.getBoolean("m2m", false);
    String str = paramBundle.getString("fromUin");
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool2 = paramBundle.getBoolean("isFriend");
    if (bool1) {}
    for (int i1 = b(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);; i1 = a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null))
    {
      a(0, 0, 5000);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvVideoCallData m2m = " + bool1 + ", selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", fromUin = " + str + ", buffer[2] = " + arrayOfByte[2] + ", result = " + i1 + ", isFriend = " + bool2);
      }
      return;
    }
  }
  
  public void a(MeetingInfo paramMeetingInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "MeetingReady, info:" + paramMeetingInfo);
    }
    try
    {
      l1 = Long.parseLong(paramMeetingInfo.getDiscuss_uin());
      while (!QLog.isColorLevel()) {}
    }
    catch (NumberFormatException paramMeetingInfo)
    {
      try
      {
        Long.parseLong(paramMeetingInfo.getCreator_uin());
        a(2, l1, Long.parseLong(paramMeetingInfo.getCreator_uin()), new long[paramMeetingInfo.getParticipants().size()], true, 0, 0, paramMeetingInfo);
        A();
        return;
      }
      catch (NumberFormatException paramMeetingInfo)
      {
        long l1;
        for (;;) {}
      }
      paramMeetingInfo = paramMeetingInfo;
      l1 = -1L;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "exception when parsing relationId or inviteUin, relationId:" + l1 + ", inviteUin:" + -1L, paramMeetingInfo);
  }
  
  public void a(VideoController.CameraDataUpdataInterface paramCameraDataUpdataInterface)
  {
    this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface = paramCameraDataUpdataInterface;
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, int paramInt)
  {
    paramGAudioFriends.jdField_a_of_type_Int = 0;
    paramGAudioFriends.jdField_b_of_type_Boolean = false;
    paramGAudioFriends.jdField_c_of_type_Boolean = false;
    paramGAudioFriends.jdField_d_of_type_Boolean = false;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + paramInt);
      }
    case 0: 
      return;
    case 1: 
      paramGAudioFriends.jdField_b_of_type_Boolean = true;
      return;
    case 3: 
      paramGAudioFriends.jdField_c_of_type_Boolean = true;
      return;
    case 2: 
      paramGAudioFriends.jdField_a_of_type_Int = 1;
      return;
    }
    paramGAudioFriends.jdField_d_of_type_Boolean = true;
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramVideoAppInterface.a().getApplicationContext();
    gez localgez = new gez(this);
    paramVideoAppInterface.a().post(localgez);
    d();
    x();
    if ((this.ap == 0) && (SmallScreenUtils.h(paramVideoAppInterface.a()))) {
      this.ap = 1;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a(this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  public void a(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut--> UserInfo = " + paramAVUserInfo.toString() + " ,relationId = " + paramLong1 + " ,opType = " + paramInt1 + " ,relationType = " + paramInt2 + " ,extroInfo = " + paramLong2);
    }
    AVPhoneUserInfo localAVPhoneUserInfo;
    if (paramInt1 == 70)
    {
      if (paramAVUserInfo.jdField_a_of_type_Int == 1)
      {
        if (a().a(paramAVUserInfo.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList) == null) {
          break label186;
        }
        localAVPhoneUserInfo = a().a(paramAVUserInfo.jdField_a_of_type_Long, a().jdField_f_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + localAVPhoneUserInfo.toString());
        }
      }
      a(paramInt2, paramLong1, paramAVUserInfo, true, paramLong2, paramVarArgs);
    }
    label186:
    do
    {
      return;
      localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.account = paramAVUserInfo.jdField_a_of_type_Long;
      localAVPhoneUserInfo.accountType = 2;
      a().a(localAVPhoneUserInfo);
      d(paramAVUserInfo.jdField_a_of_type_Long);
      break;
      if (paramInt1 == 71)
      {
        if (paramAVUserInfo.jdField_a_of_type_Int == 1)
        {
          localAVPhoneUserInfo = new AVPhoneUserInfo();
          localAVPhoneUserInfo.account = paramAVUserInfo.jdField_a_of_type_Long;
          localAVPhoneUserInfo.accountType = 2;
        }
        a(paramInt2, paramLong1, paramAVUserInfo, false, paramLong2, paramVarArgs);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
  }
  
  void a(AVUserInfo paramAVUserInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramBoolean) {
        try
        {
          if (b(paramAVUserInfo.jdField_a_of_type_Long) != -1) {
            return;
          }
          localGAudioFriends = new VideoController.GAudioFriends(this);
          localGAudioFriends.jdField_a_of_type_Long = paramAVUserInfo.jdField_a_of_type_Long;
          localGAudioFriends.jdField_c_of_type_Int = paramAVUserInfo.jdField_a_of_type_Int;
          localGAudioFriends.jdField_d_of_type_Int = paramAVUserInfo.jdField_b_of_type_Int;
          this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
          return;
        }
        finally {}
      }
      int i1 = b(paramAVUserInfo.jdField_a_of_type_Long);
      if (i1 != -1) {}
      for (VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.remove(i1);; localGAudioFriends = null)
      {
        a(paramAVUserInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList, 0, true);
        F();
        if ((localGAudioFriends == null) || (localGAudioFriends.jdField_g_of_type_Boolean) || (!localGAudioFriends.jdField_h_of_type_Boolean)) {
          break;
        }
        a(0L, false, 0L);
        break;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onMemberInOrOut-->can not find the member.userInfo = " + paramAVUserInfo);
        }
      }
    }
  }
  
  void a(Long paramLong, long paramLong1, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onBanAudio-->relationId" + paramLong + " uin=" + paramLong1 + " relationType=" + paramInt + " bBan=" + paramBoolean);
    }
    if (paramLong1 != Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().Z = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(71), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      return;
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().Z = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(72), paramLong, Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.ignoreVideo(paramString, d());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ignoreVideo: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + i1);
    }
    t();
    w();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.b()) {}
    int i1;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Gfo != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
          this.jdField_a_of_type_Gfo = null;
        }
      } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null);
      if ((1 != d()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (!b()))
      {
        a(0, this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getTrafficSize(paramString));
        this.jdField_c_of_type_Boolean = true;
      }
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, paramInt);
    } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    QLog.d(jdField_a_of_type_JavaLangString, 2, "closeVideo: isSharp = " + this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp() + ", selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + i1 + ", emCloseReason = " + paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendTransferMsg(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString2, String paramString3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsgBroadcast uinType: " + paramInt1 + ", msgType: " + paramInt2 + ", friendUin: " + paramString2 + ", selfUin: " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", isReceiver = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean + ", isVideoMsg = " + paramBoolean1 + ", extraUin: " + paramString3 + ", forceUnread:" + paramBoolean2);
    }
    Intent localIntent;
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AddVideoMsg");
      localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1);
      if (localSessionInfo != null) {}
    }
    else
    {
      return;
    }
    label192:
    int i1;
    if (paramInt2 == 21) {
      if ((localSessionInfo.jdField_k_of_type_Int == 11) || (localSessionInfo.jdField_k_of_type_Int == 12))
      {
        paramInt1 = 47;
        localSessionInfo.jdField_k_of_type_Int = 0;
        i1 = 0;
        paramInt2 = paramInt1;
      }
    }
    for (;;)
    {
      boolean bool = false;
      if ((localSessionInfo.d()) && (paramInt2 == 1)) {
        bool = true;
      }
      String str;
      label430:
      float f1;
      for (;;)
      {
        if (paramBoolean2) {
          bool = false;
        }
        localIntent.putExtra("uinType", i1);
        localIntent.putExtra("msgType", paramInt2);
        localIntent.putExtra("isVideoMsg", paramBoolean1);
        localIntent.putExtra("isRead", bool);
        localIntent.putExtra("bindType", localSessionInfo.jdField_A_of_type_Int);
        localIntent.putExtra("bindId", localSessionInfo.jdField_q_of_type_JavaLangString);
        localIntent.putExtra("MultiAVType", localSessionInfo.jdField_D_of_type_Int);
        if (paramInt2 == 17) {
          localIntent.putExtra("msgDetail", Integer.parseInt(paramString3));
        }
        str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if ((i1 != 1004) && (i1 != 1000)) {
          break label619;
        }
        paramString1 = paramString3;
        if (paramInt2 == 20) {
          paramString1 = str;
        }
        paramString3 = paramString1;
        if (TextUtils.isEmpty(paramString1)) {
          paramString3 = str;
        }
        localIntent.putExtra("friendUin", paramString2);
        localIntent.putExtra("senderUin", paramString3);
        localIntent.putExtra("selfUin", str);
        if (localSessionInfo.jdField_a_of_type_Boolean) {
          break label682;
        }
        paramBoolean1 = true;
        localIntent.putExtra("isSender", paramBoolean1);
        if (paramInt2 != 41) {
          break label733;
        }
        if (this.jdField_b_of_type_Long <= 0L) {
          break;
        }
        f1 = (float)this.jdField_b_of_type_Long / 1024.0F;
        if (f1 >= 1024.0F) {
          break label688;
        }
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1) }) + "KB";
        label514:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getConnectedTime():" + b() + " extra:" + paramString1);
        }
        localIntent.putExtra("extra", paramString1);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
        return;
        paramInt1 = 48;
        break label192;
        if (localSessionInfo.f()) {
          bool = true;
        }
      }
      label619:
      if (i1 == 1006) {
        if (paramString2.startsWith("+")) {
          break label759;
        }
      }
      for (;;)
      {
        if (localSessionInfo.jdField_a_of_type_Boolean) {}
        for (paramString1 = paramString3;; paramString1 = str)
        {
          paramString2 = paramString3;
          break;
        }
        if (localSessionInfo.jdField_a_of_type_Boolean)
        {
          paramString1 = paramString2;
          break;
        }
        paramString1 = str;
        break;
        label682:
        paramBoolean1 = false;
        break label430;
        label688:
        paramString1 = String.format("%.01f", new Object[] { Float.valueOf(f1 / 1024.0F) }) + "MB";
        break label514;
        label733:
        if (localSessionInfo.jdField_c_of_type_Long > 0L)
        {
          paramString1 = UITools.a(b());
          break label514;
        }
        paramString1 = null;
        break label514;
        label759:
        paramString3 = paramString2;
      }
      i1 = paramInt1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fromUin = " + paramString + ", reason = " + paramInt + ", extraParam = " + paramLong);
    }
    if (((this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 21)) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fWaitAutoAnswer = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.closeVideo(paramString, 0);
      m();
      return;
    }
    l();
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 13: 
    case 16: 
    case 17: 
    default: 
    case 0: 
      for (paramInt = 5;; paramInt = 0)
      {
        c(paramString, paramInt);
        return;
      }
    case 1: 
      if (paramLong == 9L) {
        paramInt = 43;
      }
      break;
    }
    for (;;)
    {
      if ((paramLong == 12L) || (paramLong == 13L) || (paramLong == 15L) || (paramLong == 16L))
      {
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 2) {
          break label662;
        }
        ReportController.b(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b(paramString, paramInt);
        return;
        if (paramLong == 10L)
        {
          paramInt = 54;
          break;
        }
        if (paramLong == 5L)
        {
          paramInt = 49;
          break;
        }
        if ((paramLong == 12L) || (paramLong == 16L))
        {
          a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().l, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Long, 0);
          paramInt = 52;
          break;
        }
        if (paramLong == 13L)
        {
          paramInt = 50;
          break;
        }
        if (paramLong == 14L)
        {
          paramInt = 51;
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 2)
          {
            ReportController.b(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
            break;
          }
          ReportController.b(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong == 15L)
        {
          paramInt = 55;
          break;
        }
        if (paramLong == 17L)
        {
          paramInt = 56;
          ReportController.b(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
          break;
        }
        if (paramLong != 6L) {
          break label797;
        }
        paramInt = 24;
        break;
        label662:
        ReportController.b(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
      }
      paramInt = 3;
      if (paramLong == 3L) {
        paramInt = 42;
      }
      b(paramString, paramInt);
      return;
      paramInt = 5;
      break;
      b(paramString, 25);
      return;
      paramInt = 9;
      break;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 10;
      break;
      paramInt = 28;
      break;
      paramInt = 29;
      break;
      paramInt = 39;
      break;
      paramInt = 35;
      break;
      b(paramString, 12);
      return;
      paramInt = 21;
      break;
      paramInt = 51;
      break;
      label797:
      paramInt = 2;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached state:" + paramInt + " # extraParam0 = " + paramLong + " # subState = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a() != null)
    {
      if (0L != this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long) {
        break label300;
      }
      if (0L != paramLong) {}
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a() == null) || (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().f())) {
        break label363;
      }
    }
    label300:
    label363:
    label399:
    label845:
    do
    {
      int i1;
      do
      {
        do
        {
          do
          {
            return;
            if (1L == paramLong)
            {
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long = 1L;
              if (paramArrayOfByte == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_JavaLangString = new String(paramArrayOfByte);
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_JavaLangString);
              }
              if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(400), this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_JavaLangString });
              break;
            }
            if (2L != paramLong) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long = 2L;
          } while (paramArrayOfByte == null);
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_JavaLangString = new String(paramArrayOfByte);
          return;
          if (1L != this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long) {
            break;
          }
          if (0L == paramLong)
          {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long = 0L;
            return;
          }
        } while (1L == paramLong);
        if (2L != paramLong) {
          break;
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long = 0L;
        f();
        return;
        i1 = 0x80000 & paramInt;
        if ((i1 <= 0) || (!this.p)) {
          break label399;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached :has get phone state");
      return;
      if (i1 == 0) {
        this.p = true;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = 0;
      if ((0x10000 & paramInt) > 0)
      {
        i1 = 0x40000 & paramInt;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_n_of_type_Int = (0x20000 & paramInt);
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().o = i1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached pcOnLine:" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_n_of_type_Int + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().o);
        }
        if (((0x100000 & paramInt) > 0) && (i1 > 0))
        {
          if ((0xFFFF & paramInt & 0x1) > 0) {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = 1;
          }
          if (this.jdField_a_of_type_Gfo != null)
          {
            if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
            }
            this.jdField_a_of_type_Gfo = null;
          }
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
          {
            if ((a() != null) && (a().jdField_b_of_type_Long == 1L) && (!TextUtils.isEmpty(a().jdField_p_of_type_JavaLangString))) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString, a().jdField_p_of_type_JavaLangString });
            }
          }
          else if (!a().ag) {
            g();
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_n_of_type_Boolean = true;
          return;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), paramString });
          break;
          paramInt &= 0xFFFF;
          if ((paramInt & 0x2) > 0) {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = 2;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label845;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteReached low 16bit value is" + paramInt);
            break;
            if ((paramInt & 0x4) > 0)
            {
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = 3;
              ReportController.b(null, "CliOper", "", "", "0x80049A5", "0x80049A5", 0, 0, "", "", "", "");
            }
            else if ((paramInt & 0x8) > 0)
            {
              this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_p_of_type_Int = 4;
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_n_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().o = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pc and phone both not online");
      }
      if (this.jdField_a_of_type_Gfo != null)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
        }
        this.jdField_a_of_type_Gfo = null;
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_n_of_type_Boolean = false;
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 0);
      this.jdField_g_of_type_JavaLangRunnable = new ges(this);
    } while ((this.jdField_g_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_g_of_type_JavaLangRunnable, 2000L);
  }
  
  void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reject3rdMultiCall, sessionId:" + paramString1 + ", relationType:" + paramInt + ", senderUin:" + paramString2 + ", extraUin:" + paramString3);
    }
    b(paramString1, UITools.b(paramInt), paramString2, paramString3);
    this.jdField_a_of_type_ComTencentAvSessionMgr.c(paramString1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendStopVideoBroadcast uinType: " + paramInt1 + ", peerUin: " + paramString2 + ", extraUin: " + paramString3 + ", stopReason: " + paramInt2 + ", senderUin: " + paramString4 + ", isSystemCalling:" + paramBoolean1 + ", selfUin :" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", sessionType = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_f_of_type_Int);
    }
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1);
      if (localSessionInfo != null) {}
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    localIntent.setAction("tencent.av.v2q.StopVideoChat");
    localIntent.putExtra("sessionId", paramString1);
    localIntent.putExtra("uinType", paramInt1);
    localIntent.putExtra("bindType", localSessionInfo.jdField_A_of_type_Int);
    localIntent.putExtra("bindId", localSessionInfo.jdField_q_of_type_JavaLangString);
    localIntent.putExtra("peerUin", paramString2);
    localIntent.putExtra("sessionType", localSessionInfo.jdField_f_of_type_Int);
    localIntent.putExtra("extraUin", paramString3);
    localIntent.putExtra("stopReason", paramInt2);
    localIntent.putExtra("isSystemCalling", paramBoolean1);
    localIntent.putExtra("isDouble", paramBoolean2);
    localIntent.putExtra("selfUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    if (!paramBoolean2)
    {
      localIntent.putExtra("relationType", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_F_of_type_Int);
      localIntent.putExtra("relationId", this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_e_of_type_Long);
    }
    if (TextUtils.isEmpty(paramString4)) {
      localIntent.putExtra("senderUin", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      return;
      localIntent.putExtra("senderUin", paramString4);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processVideoRequest uinType = " + paramInt1 + ", peerUin = " + paramString2 + ", extraUin = " + paramString3 + ", onlyAudio = " + paramBoolean1 + ", isDoubleVideoMeeting = " + paramBoolean2);
    }
    if ((paramBoolean1) && (!ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())))
    {
      a(paramString2, 0, paramBoolean2);
      c(paramString2, 0);
    }
    int i1;
    Object localObject;
    label605:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) != null)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_K_of_type_Boolean = paramBoolean1;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).j = 2;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).ae = false;
          AVReport.a().o = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_K_of_type_Boolean;
        }
        i1 = 0;
        if (!paramBoolean3) {
          break;
        }
        localObject = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), MultiIncomingCallsActivity.class);
        ((Intent)localObject).putExtra("isScreenLocked", a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext()));
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("uinType", paramInt1);
        ((Intent)localObject).putExtra("peerUin", paramString2);
        ((Intent)localObject).putExtra("extraUin", paramString3);
        ((Intent)localObject).putExtra("isAudioMode", paramBoolean1);
        ((Intent)localObject).putExtra("curUserStatus", this.ad);
        ((Intent)localObject).putExtra("isDoubleVideoMeeting", paramBoolean2);
        ((Intent)localObject).putExtra("bindType", paramInt2);
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) || ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L))) {
          ((Intent)localObject).putExtra("isPlayRing", false);
        }
        if ((paramInt1 != 21) && (paramInt1 != 1011)) {
          break label684;
        }
        s();
        if (!TextUtils.equals(paramString2, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString)) {
          break label605;
        }
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) != null)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString = paramString2;
          a(this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString, 0, 4);
        }
      } while (this.jdField_a_of_type_Gfg == null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfg);
      this.jdField_a_of_type_Gfg = null;
      return;
      if (a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext())) {}
      for (Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), VideoInviteLock.class);; localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), VideoInviteFull.class))
      {
        int i2 = 1;
        localObject = localIntent;
        i1 = i2;
        if (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
          break;
        }
        localIntent.addFlags(262144);
        localObject = localIntent;
        i1 = i2;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processVideoRequest UIN_TYPE_ANYONE wait for  activity accept");
      }
    } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1) == null);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).j = 0;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).l = paramInt1;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString = paramString2;
    return;
    label684:
    i();
    if ((i1 != 0) && (Build.VERSION.SDK_INT >= 16))
    {
      paramString1 = ActivityOptions.makeCustomAnimation(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), 2130968714, 0);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity((Intent)localObject, paramString1.toBundle());
    }
    for (;;)
    {
      s();
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().startActivity((Intent)localObject);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    TraeHelper localTraeHelper = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (!paramBoolean) {}
    for (paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString, d(), paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "rejectVideo: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + paramString + ", result = " + paramInt);
      }
      t();
      w();
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
        break;
      }
      SmartDeviceReport.a(null, "Usr_TV_Video", 3, 0, 0);
      return;
    }
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, 2, paramBoolean, paramString2, paramString3, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.StartVideoChat");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("sessionId", paramString);
      if (this.jdField_a_of_type_ComTencentAvSessionMgr != null)
      {
        paramString = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString);
        if (paramString != null)
        {
          localIntent.putExtra("uinType", paramString.l);
          if (paramString.l != 26) {
            break label262;
          }
          localIntent.putExtra("peerUin", paramString.jdField_e_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      if ((paramInt == 3) || (paramInt == 4))
      {
        localIntent.putExtra("peerUin", paramString.s);
        localIntent.putExtra("relationType", paramString.jdField_F_of_type_Int);
        localIntent.putExtra("relationId", paramString.jdField_e_of_type_Long);
      }
      localIntent.putExtra("extraUin", paramString.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("bindType", paramString.jdField_A_of_type_Int);
      localIntent.putExtra("bindId", paramString.jdField_q_of_type_JavaLangString);
      localIntent.putExtra("isReceiver", paramString.jdField_a_of_type_Boolean);
      localIntent.putExtra("updateTime", paramBoolean1);
      localIntent.putExtra("isDouble", paramBoolean3);
      localIntent.putExtra("showTime", paramBoolean2);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      return;
      label262:
      localIntent.putExtra("peerUin", paramString.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.receiveTransferMsg(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(122), paramString });
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0")))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onOtherTerminalChatingStatus invalid uin");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onOtherTerminalChatingStatus fromUin: " + paramString + ", roomid: " + paramLong + ", type: " + paramInt);
    }
    Object localObject = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject);
      if (localObject != null) {
        if ((!paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) || (((SessionInfo)localObject).l != 2800)) {
          break label258;
        }
      }
    }
    label258:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        ((SessionInfo)localObject).jdField_f_of_type_Int = paramInt;
      }
      if ((paramInt != 0) && (!TextUtils.isEmpty(a().jdField_c_of_type_JavaLangString)) && ((!a().jdField_c_of_type_JavaLangString.equals(paramString)) || (a().jdField_f_of_type_Int == 0))) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.sendQueryRoomInfoRequest(paramLong, Long.valueOf(paramString).longValue());
      }
      a(0, paramString, paramLong, paramInt);
      return;
      localObject = SessionMgr.a(3, paramString, new int[0]);
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject);
      break;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMultiVideoMsg");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    a(localNewIntent);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + CharacterUtil.a(paramLong) + ", uinType = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().l);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
      localNewIntent.putExtra("toUin", paramLong);
      localNewIntent.putExtra("vMsg", paramArrayOfByte);
      a(localNewIntent);
      return;
      localNewIntent.putExtra("reqType", 4);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetStrangerFaceSuc uin:" + paramString + ",face :" + paramBitmap);
    }
    a(paramString, paramBitmap, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(201), paramString, paramBitmap });
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin: " + paramString + ", anonymous: " + paramBoolean);
    }
    if (!n()) {}
    do
    {
      do
      {
        return;
        if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          if (paramBoolean)
          {
            this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
            return;
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
          break;
        }
        VideoController.GAudioFriends localGAudioFriends = a(paramString);
        if (localGAudioFriends != null)
        {
          localGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomFace uin:" + paramString + ", audiofrind null");
      return;
    } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  void a(String paramString1, String paramString2, int paramInt)
  {
    int i1;
    String str;
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).ae)
    {
      i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).l;
      str = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_e_of_type_JavaLangString;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString.contains(paramString2))) {
        break label283;
      }
      paramString2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_c_of_type_JavaLangString;
    }
    label219:
    label283:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
        i1 = 9500;
      }
      boolean bool = false;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_h_of_type_Int == 2) {
        bool = true;
      }
      if (VideoUtils.a(i1, this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).jdField_A_of_type_Int))
      {
        a(i1, paramInt, paramString2, str);
        if (!this.jdField_e_of_type_Boolean) {
          break label219;
        }
        a(paramString1, i1, paramString2, str, 1, this.jdField_a_of_type_ComTencentAvSessionMgr.a().t, false, true);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).ae = true;
        return;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) {
          break;
        }
        a(paramString1, i1, paramInt, bool, paramString2, str, false);
        break;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) {
          a(paramString1, i1, paramString2, str, 2, this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).t, true, true);
        } else {
          a(paramString1, i1, paramString2, str, 0, this.jdField_a_of_type_ComTencentAvSessionMgr.a(paramString1).t, false, true);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateRandomChatInfo uin: " + paramString1 + ", nickName: " + paramString2 + ", headUrl: " + paramString3);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.updateChatInfo");
    if (!TextUtils.isEmpty(paramString1))
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("nickName", paramString2);
      localIntent.putExtra("headUrl", paramString3);
    }
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ",nickname:" + paramString2 + ", anonymous = " + paramBoolean);
    }
    if ((TextUtils.isEmpty(paramString2)) || (!n())) {}
    label140:
    label164:
    label204:
    do
    {
      do
      {
        return;
        if (paramString1.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount()))
        {
          if (!paramBoolean) {
            break label140;
          }
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_g_of_type_JavaLangString = paramString2;
        }
        VideoController.GAudioFriends localGAudioFriends;
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 3) {
            break label204;
          }
          localGAudioFriends = a(paramString1);
          if (localGAudioFriends == null) {
            break label164;
          }
          if (!paramBoolean) {
            break;
          }
          localGAudioFriends.jdField_b_of_type_JavaLangString = paramString2;
          return;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_JavaLangString = paramString2;
        }
        localGAudioFriends.jdField_a_of_type_JavaLangString = paramString2;
        return;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "saveRandomNickName uin:" + paramString1 + ", audiofrind null");
      return;
    } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsg buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 0);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("cVerifyType", Byte.valueOf((byte)0));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherIsRing isCalling = " + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().L = paramBoolean;
    if (paramBoolean) {
      DataReport.s(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(23), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.onRecvVideoRequest(paramString, paramArrayOfByte);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad,detail is null");
      }
    }
    label186:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramLong != 1L) {
              break label186;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo_TRAE:network is bad");
            }
            if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) {
              try
              {
                paramArrayOfByte = new String(paramArrayOfByte, "GBK");
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(26), paramArrayOfByte });
                return;
              }
              catch (NullPointerException paramArrayOfByte)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
                  return;
                }
              }
              catch (UnsupportedEncodingException paramArrayOfByte) {}
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
        return;
      } while (paramLong != 0L);
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(19), paramArrayOfByte });
        return;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkMonitorInfo fromUin = " + paramString + ", info = " + paramLong, paramArrayOfByte);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> tinyIDList is null Or size is 0");
      }
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  void a(NewIntent paramNewIntent)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsg", paramNewIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_z_of_type_Boolean = paramBoolean;
  }
  
  void a(boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reject3rdDoubleCall, isDoubleVideoMeeting:" + paramBoolean1 + ", uinType:" + paramInt1 + ", fromUin:" + paramString1 + ", extraUin:" + paramString2 + ", bindType: " + paramInt2 + ", bindID:" + paramString3 + ", onlyAudio:" + paramBoolean2);
    }
    String str;
    long l2;
    if (paramBoolean1)
    {
      str = SessionMgr.a(10, paramString1, new int[0]);
      SessionInfo localSessionInfo2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
      SessionInfo localSessionInfo1 = localSessionInfo2;
      if (localSessionInfo2 == null) {
        localSessionInfo1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
      }
      localSessionInfo1.l = paramInt1;
      localSessionInfo1.jdField_A_of_type_Int = paramInt2;
      localSessionInfo1.jdField_q_of_type_JavaLangString = paramString3;
      localSessionInfo1.jdField_a_of_type_Boolean = true;
      paramInt1 = localSessionInfo1.l;
      if (paramBoolean2) {
        break label245;
      }
      paramBoolean2 = bool;
      a(str, paramInt1, paramBoolean2, paramString1, paramString2);
      if (!paramBoolean1) {
        break label280;
      }
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString1);
        b(3, l1);
        SessionMgr.a().c(str);
        return;
        str = SessionMgr.a(3, paramString1, new int[0]);
        break;
        label245:
        paramBoolean2 = false;
      }
      catch (NumberFormatException paramString1)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramString1);
        l1 = l2;
        continue;
      }
      label280:
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(paramString1, d(), 3);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, int... paramVarArgs)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    if (localSessionInfo.j == 0) {}
    do
    {
      do
      {
        return;
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if (localQAVNotification != null) {
          localQAVNotification.a(localSessionInfo.jdField_b_of_type_JavaLangString);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "closeMainSession  " + localSessionInfo.jdField_f_of_type_Int + " " + localSessionInfo.jdField_c_of_type_JavaLangString);
        }
        if ((n()) || (o()))
        {
          g(true);
          return;
        }
        if ((localSessionInfo.jdField_f_of_type_Int != 3) && (localSessionInfo.jdField_f_of_type_Int != 4)) {
          break;
        }
      } while (!this.jdField_e_of_type_Boolean);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localSessionInfo.s, Boolean.valueOf(true) });
      }
      if (localSessionInfo.jdField_z_of_type_Boolean)
      {
        a(this.jdField_a_of_type_Long, true, 0);
        return;
      }
      a(this.jdField_E_of_type_Int, this.jdField_a_of_type_Long, 0, paramVarArgs);
      return;
    } while ((localSessionInfo.jdField_f_of_type_Int != 1) && (localSessionInfo.jdField_f_of_type_Int != 2));
    if ((localSessionInfo.j == 2) || (localSessionInfo.j == 13))
    {
      if (localSessionInfo.jdField_z_of_type_Boolean)
      {
        a(localSessionInfo.jdField_c_of_type_JavaLangString, 1, true);
        long l1 = Long.valueOf(localSessionInfo.jdField_c_of_type_JavaLangString).longValue();
        b(3, l1);
        a(l1, 1);
        return;
      }
      a(localSessionInfo.jdField_c_of_type_JavaLangString, 1, false);
      a(localSessionInfo.jdField_c_of_type_JavaLangString, paramInt);
      c(localSessionInfo.jdField_c_of_type_JavaLangString, 0);
      return;
    }
    if (localSessionInfo.jdField_z_of_type_Boolean)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
      }
      a(Long.valueOf(localSessionInfo.jdField_c_of_type_JavaLangString).longValue(), true, 0);
      return;
    }
    a(localSessionInfo.jdField_c_of_type_JavaLangString, paramInt);
    c(localSessionInfo.jdField_c_of_type_JavaLangString, 0);
    b(2, true, true);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.jdField_z_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface != null) {
        this.jdField_a_of_type_ComTencentAvVideoController$CameraDataUpdataInterface.a();
      }
      this.jdField_z_of_type_Boolean = false;
      this.jdField_A_of_type_Boolean = false;
    }
    int i2 = paramArrayOfByte.length;
    int i1;
    if ((this.G <= 30) && (!this.jdField_g_of_type_Boolean)) {
      i1 = 0;
    }
    for (;;)
    {
      if ((i1 > 10) || (paramArrayOfByte[((int)(Math.random() * i2))] != 0))
      {
        if (i1 < 10) {
          this.jdField_g_of_type_Boolean = true;
        }
        this.G += 1;
        if ((this.G == 30) && (!this.jdField_g_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "30 video frames has no image");
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1) });
        }
        if (i2 != AndroidCamera.l * AndroidCamera.m * 3 / 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OnPreviewData", 2, "datalen != preview size");
          }
          if (i2 == 460800)
          {
            AndroidCamera.l = 640;
            AndroidCamera.m = 480;
          }
          if (i2 == 115200)
          {
            AndroidCamera.l = 320;
            AndroidCamera.m = 240;
          }
        }
        if ((!this.jdField_n_of_type_Boolean) || (a().jdField_K_of_type_Int != 0) || (a().jdField_f_of_type_Int != 2)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.m = paramBoolean;
        this.ac = paramInt;
        return;
      }
      i1 += 1;
    }
    GraphicRenderMgr.getInstance().sendCameraFrame2Native(paramArrayOfByte, AndroidCamera.jdField_n_of_type_Int, AndroidCamera.l, AndroidCamera.m, paramInt, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoCall: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", toUin = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AddLightalkSig");
      localIntent.putExtra("peerUin", paramString1);
      localIntent.putExtra("bindType", paramInt1);
      localIntent.putExtra("uinType", paramInt2);
      localIntent.putExtra("phoneNum", paramString2);
      localIntent.putExtra("sig", paramArrayOfByte);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      HexUtil.a(jdField_a_of_type_JavaLangString, paramArrayOfByte);
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public void a(long[] paramArrayOfLong)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (str != null)
    {
      long l1 = CharacterUtil.a(str);
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setInviteUserList(l1, paramArrayOfLong);
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      for (;;)
      {
        int i1;
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          int i2 = paramArrayOfLong.length;
          i1 = 0;
          if (i1 >= i2) {
            break;
          }
          long l1 = paramArrayOfLong[i1];
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
            if (localGAudioFriends.jdField_a_of_type_Long != l1) {
              continue;
            }
            localGAudioFriends.jdField_a_of_type_Boolean = paramBoolean;
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "inviteNewMemJoin --> uinList = " + paramArrayOfLong + " ,needNotifyUI = " + paramBoolean + " ,original = " + paramInt1 + " ,pstnLevel = " + paramInt2 + " ,mMultiInviteEntranceFlag=" + this.jdField_I_of_type_Int);
    }
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return;
    }
    if (a().jdField_y_of_type_Int == 4) {
      a().jdField_y_of_type_Int = 2;
    }
    Object localObject;
    if (this.jdField_I_of_type_Int == 1)
    {
      paramInt2 = paramArrayOfLong.length;
      localObject = new long[paramInt2 * 2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject[(paramInt1 * 2)] = 1L;
        localObject[(paramInt1 * 2 + 1)] = paramArrayOfLong[paramInt1];
        paramInt1 += 1;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f() >= 6)
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject, paramInt2, null, 0);
      }
    }
    for (;;)
    {
      if ((a().n()) && (a().jdField_F_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null))
      {
        if (this.jdField_a_of_type_Gfk == null) {
          this.jdField_a_of_type_Gfk = new gfk(this);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gfk, this.M * 1000);
      }
      if (!paramBoolean) {
        break;
      }
      paramInt1 = paramArrayOfLong.length;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(68), Long.valueOf(paramArrayOfLong[0]), Integer.valueOf(paramInt1) });
      return;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite((long[])localObject, paramInt2, null, 0, 0, false, false, 0);
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramArrayOfLong[paramInt1]))) {
          a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramArrayOfLong[paramInt1]));
        }
        paramInt1 += 1;
      }
      continue;
      if (this.jdField_I_of_type_Int == 2)
      {
        ArrayList localArrayList1 = new ArrayList();
        if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
        {
          paramInt1 = 0;
          while (paramInt1 < paramArrayOfLong.length)
          {
            localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(paramArrayOfLong[paramInt1] + "");
            if (localObject != null)
            {
              localArrayList1.add(localObject);
              a().jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramArrayOfLong[paramInt1]));
            }
            paramInt1 += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "inviteNewMemJoin --> inviteByPhoneList = " + localArrayList1);
        }
        paramInt2 = localArrayList1.size();
        localObject = null;
        if (paramInt2 > 0)
        {
          localObject = new String[paramInt2 * 3];
          ArrayList localArrayList2 = new ArrayList();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            AVPhoneUserInfo localAVPhoneUserInfo = PstnUtils.a((String)localArrayList1.get(paramInt1));
            localArrayList2.add(localAVPhoneUserInfo);
            localObject[(paramInt1 * 3)] = localAVPhoneUserInfo.telInfo.nation;
            localObject[(paramInt1 * 3 + 1)] = localAVPhoneUserInfo.telInfo.prefix;
            localObject[(paramInt1 * 3 + 2)] = localAVPhoneUserInfo.telInfo.mobile;
            paramInt1 += 1;
          }
          a().a(localArrayList2);
          j();
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite(null, 0, (String[])localObject, paramInt2, 0, false, false, 0);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null;
  }
  
  public boolean a(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    C2CType0x211_SubC2CType0xb.MsgBody localMsgBody = new C2CType0x211_SubC2CType0xb.MsgBody();
    Object localObject = null;
    if (paramInt2 == 1006) {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_JavaLangString;
    }
    C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader localMsgHeader = new C2CType0x211_SubC2CType0xb.MsgBody.MsgHeader();
    localMsgHeader.uint32_body_type.set(101);
    localMsgHeader.uint64_to_uin.set(paramLong);
    if (localObject != null) {
      localMsgHeader.str_to_mobile.set((String)localObject);
    }
    localObject = new C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localMsgBody.msg_msg_header.set(localMsgHeader);
      paramString = localMsgBody.toByteArray();
      localObject = Long.toString(paramLong);
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject, 529, 11, paramString);
      ((C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify)localObject).enum_reject_reason.set(201);
      continue;
      ((C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify)localObject).enum_reject_reason.set(202);
      continue;
      ((C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify)localObject).enum_reject_reason.set(203);
      continue;
      if (paramString != null) {
        ((C2CType0x211_SubC2CType0xb.MsgBody.RejectNotify)localObject).str_msg.set(paramString);
      }
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long != paramLong) {
          break label66;
        }
        bool1 = bool2;
        if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_c_of_type_Int == 0) {
          bool1 = true;
        }
      }
      return bool1;
      label66:
      i1 += 1;
    }
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        i1 = 0;
        if (i1 >= i2) {
          break label135;
        }
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localGAudioFriends.jdField_a_of_type_Long == paramLong)
        {
          localGAudioFriends.jdField_g_of_type_Boolean = paramBoolean;
          localGAudioFriends.jdField_c_of_type_Int = paramInt1;
          localGAudioFriends.jdField_d_of_type_Int = paramInt2;
          bool = localGAudioFriends.jdField_h_of_type_Boolean;
          if (!paramBoolean) {
            break label141;
          }
          localGAudioFriends.jdField_h_of_type_Boolean = false;
          paramBoolean = bool;
          return paramBoolean;
        }
      }
      i1 += 1;
      continue;
      label135:
      paramBoolean = false;
      continue;
      label141:
      paramBoolean = bool;
    }
  }
  
  boolean a(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)paramArrayList.get(i1)).jdField_a_of_type_Int == paramInt)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(paramLong, paramBoolean);
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {}
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
    if (paramBoolean) {
      i1 = 1;
    }
    return localQQGAudioCtrl.setMicMode(i1);
  }
  
  public byte[] a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getInterestingString(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getInterestingString --> VcCtrl is null. PeerUin = " + paramString);
    }
    return null;
  }
  
  public int b()
  {
    return this.ad;
  }
  
  int b(long paramLong)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == paramLong) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(paramString);
    }
    return -1;
  }
  
  int b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return -1;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend();
      }
    }
    else {
      return 0;
    }
    if (this.q) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      break;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend();
    }
  }
  
  public int b(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp()) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetAudioOutput(paramString, paramBoolean);
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long == 0L) {
      return 0L;
    }
    long l1 = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long) / 1000L + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Long;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(l1);
    return l1;
  }
  
  public long b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getChatRoomID(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getChatRoomId --> VcCtrl is null. PeerUin = " + paramString);
    }
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getAVGQuality();
    }
    return null;
  }
  
  public ArrayList b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startNetWorkTimer");
    }
    if (this.jdField_B_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_B_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApnChanged netType = " + paramInt);
    }
    if (this.jdField_D_of_type_Int != paramInt)
    {
      this.jdField_D_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label155;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        int i2 = d();
        int i1 = i2;
        if (i2 > 13) {
          i1 = 0;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
      }
      if ((this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) && ((paramInt == 1) || (paramInt == 2))) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setApType(d());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(21), Integer.valueOf(paramInt) });
      return;
      label155:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean) || (((paramInt1 < AndroidCamera.l) || (paramInt2 < AndroidCamera.m)) && ((AndroidCamera.l <= 640) || (AndroidCamera.m <= 480)))) {}
    while ((AndroidCamera.l == paramInt1) && (AndroidCamera.m == paramInt2)) {
      return;
    }
    AndroidCamera.l = paramInt1;
    AndroidCamera.m = paramInt2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(32) });
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_Long = paramInt3;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioNoiseCtrlParam(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void b(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, -1, false);
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().am) {}
    while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(paramLong, paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRemoteVideoDataComeIn-->uin = " + paramLong + ", videoSrcType=" + paramInt2);
    }
    paramInt1 = 0;
    while (paramInt1 < this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if ((((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Long == paramLong) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Int == paramInt2)) {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).jdField_d_of_type_Boolean = true;
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(81), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(false, false);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(l1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.uploadSharpNode(paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("SharpReport_Node", 2, "report_node is" + paramInt);
      }
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    boolean bool;
    GraphicRenderMgr localGraphicRenderMgr;
    if ((paramInt == 4) || (paramInt == 3))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setEncodeDecodePtr-->SessionType = " + paramInt + " ,clean = " + paramBoolean1 + " ,isRemote = " + paramBoolean2 + " ,isMultiEngine = " + bool);
      }
      localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      if (!bool) {
        break label241;
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        if (!paramBoolean2) {
          break label216;
        }
        if (!paramBoolean1) {
          break label180;
        }
        if (localGraphicRenderMgr.decoderPtrRef > 0) {
          localGraphicRenderMgr.decoderPtrRef -= 1;
        }
        if (localGraphicRenderMgr.decoderPtrRef == 0) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
        }
      }
    }
    label180:
    label216:
    label241:
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
    {
      do
      {
        return;
        if (((paramInt == 2) || (paramInt == 1)) && (a().jdField_z_of_type_Boolean))
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        localGraphicRenderMgr.decoderPtrRef += 1;
      } while (localGraphicRenderMgr.decoderPtrRef != 1);
      paramInt = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr();
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(paramInt);
      return;
      if (paramBoolean1) {}
      for (paramInt = i1;; paramInt = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getEncodeFrameFunctionPtrFunPtr())
      {
        localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramInt);
        return;
      }
    }
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      for (paramInt = i2;; paramInt = localGraphicRenderMgr.getRecvDecoderFrameFunctionptr())
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setProcessDecoderFrameFunctionptr(paramInt);
        return;
      }
    }
    if (paramBoolean1) {}
    for (paramInt = i3;; paramInt = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getEncodeFrameFunctionPtrFunPtr())
    {
      localGraphicRenderMgr.setProcessEncodeFrameFunctionPtr(paramInt);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->InviteUin = " + paramLong);
    }
    if (((Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()) == 1) || (VcSystemInfo.d())) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a() >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeeting->pending session exists, just reject.");
      }
      a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
      return;
    }
    String str = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a(str, false);
    VideoConstants.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e();
    boolean bool2 = false;
    boolean bool3 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getApplicationContext());
    if ((TextUtils.equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, String.valueOf(paramLong))) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_k_of_type_Int == 11))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).j = 2;
      c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 2);
    }
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().a())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.g()) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_K_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_h_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).l = 0;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_c_of_type_JavaLangString = String.valueOf(paramLong);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_e_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).j = 2;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).jdField_z_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).t = String.valueOf(paramLong);
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "recv double video meeting when phone is not idle:from uin=" + paramLong);
      }
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.CallingDialog");
      localIntent.putExtra("isAudio", true);
      localIntent.putExtra("friendUin", String.valueOf(paramLong));
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("type", 1);
      localIntent.putExtra("senderUin", paramLong);
      localIntent.putExtra("isSender", false);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      new TraeMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null).a(0, 2131165196, null, null, false, 1, false, true, 0);
      b(3, paramLong);
      a(paramLong, 1);
      a();
      this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
      return;
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().g()) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().h()) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().i()))
      {
        l();
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 2) && (String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)))
        {
          bool1 = true;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a(str).j = 2;
          c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 2);
        }
        else if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().g())
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().h()) {}
        }
        else
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 7) && (this.jdField_e_of_type_Long != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->reject video request when GAUDIO_INVITE: fromUin = " + paramLong);
        }
        if (bool3)
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
      else if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 14)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->reject video request when chatting1: fromUin = " + paramLong);
        }
        if (bool3)
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
      else if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j == 13)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->reject video request when chatting2: fromUin = " + paramLong);
        }
        if (bool3)
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
      else if (!this.jdField_e_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
        }
        if (bool3)
        {
          a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
          return;
        }
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (this.jdField_e_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "recv 3rd call when in group chat, fromUin = " + paramLong);
          }
          if (bool3)
          {
            a(true, 0, String.valueOf(paramLong), String.valueOf(paramLong), 0, null, false);
            return;
          }
          bool1 = true;
        }
      }
    }
    a(str, 0, String.valueOf(paramLong), null, true, true, bool1, 0);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 105: 
    case 106: 
    default: 
      return;
    case 101: 
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().V = true;
      d(paramInt1, paramLong, paramInt2);
      return;
    case 104: 
    case 107: 
    case 108: 
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_I_of_type_Int = paramInt2;
      d(paramInt1, paramLong, paramInt2);
      return;
    }
    c(paramInt1, paramLong, paramInt2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (b(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString) == paramLong2) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().al = true;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(37) });
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    long l1 = this.jdField_a_of_type_Long;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(l1, bool);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(140), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void b(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    W();
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    d(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), paramArrayOfByte, null);
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpOfflineMsg");
    }
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    g(4);
    int i1 = d(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveSharpVideoCall result: " + i1 + ", buf.length: " + arrayOfByte.length);
    }
    if ((bool) && (this.C == -1)) {
      this.C = 1;
    }
    a(0, 0, 5000);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "pauseVideo");
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int <= 2) && (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)) {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().f()) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.pauseVideo(paramString);
    }
    QLog.d("VideoController", 2, "pauseVideo end");
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fromUin = " + paramString + ", type = " + paramInt);
    }
    Object localObject = SessionMgr.a(3, paramString, new int[0]);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject)) {}
    for (SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject); localSessionInfo == null; localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCloseVideo fail to find session");
      }
      return;
      localObject = SessionMgr.a(10, paramString, new int[0]);
    }
    w();
    h();
    if ((localSessionInfo.jdField_b_of_type_Long == 1L) && ((paramInt == 2) || (paramInt == 24)))
    {
      a((String)localObject, paramString, 3);
      label156:
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a((String)localObject).d()) {
        break label284;
      }
      localSessionInfo.jdField_z_of_type_Int = paramInt;
      if ((localSessionInfo.d()) && (paramInt == localSessionInfo.jdField_f_of_type_Int)) {
        localSessionInfo.jdField_c_of_type_Long = 0L;
      }
      localSessionInfo.j = 6;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
      c(localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_z_of_type_Int);
    }
    for (;;)
    {
      label244:
      if ((this.jdField_a_of_type_Gfo != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
        return;
        a((String)localObject, paramString, paramInt);
        break label156;
        label284:
        if (localSessionInfo.c())
        {
          localSessionInfo.jdField_z_of_type_Int = paramInt;
          localSessionInfo.jdField_c_of_type_Long = 0L;
          int i2;
          switch (paramInt)
          {
          default: 
            i2 = 2131165198;
            i1 = 0;
            label368:
            if (i1 == 0) {
              break;
            }
          }
          for (int i1 = 4;; i1 = 2)
          {
            a(i2, i1, this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            localSessionInfo.j = 5;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
            break label244;
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            i1 = 0;
            i2 = 2131165197;
            break label368;
            if (n()) {
              break;
            }
            if (a().jdField_b_of_type_Long != 2L)
            {
              ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
              i1 = 0;
              i2 = 2131165197;
              break label368;
            }
            i2 = 2131165198;
            i1 = 1;
            break label368;
            a(2131165198, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            localSessionInfo.j = 6;
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
            return;
            if (n()) {
              break;
            }
            ReportController.b(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
            i1 = 0;
            i2 = 2131165197;
            break label368;
            i2 = 2131165197;
            i1 = 0;
            break label368;
          }
        }
        if (!localSessionInfo.g())
        {
          localSessionInfo.jdField_z_of_type_Int = paramInt;
          if (localSessionInfo.d()) {
            localSessionInfo.jdField_c_of_type_Long = 0L;
          }
          if (((paramInt == 2) || (paramInt == 24)) && (localSessionInfo.l == 1011))
          {
            localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
            if (paramInt == 2)
            {
              localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 6;
              this.jdField_f_of_type_Boolean = true;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label867;
            }
            a(6, 0, null);
            label750:
            localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            if (this.jdField_f_of_type_Boolean) {
              break label883;
            }
            if (localObject != null) {
              ((QAVNotification)localObject).a();
            }
          }
          label776:
          localSessionInfo.j = 6;
          if (!PhoneStatusTools.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {
            break label890;
          }
          a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, 0);
          c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_z_of_type_Int);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(paramInt), paramString });
      break label244;
      break;
      label867:
      a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 0, null);
      break label750;
      label883:
      k();
      break label776;
      label890:
      a(2131165198, 1, this.jdField_b_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
    }
  }
  
  public void b(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramInt == 1) && (1L == this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long = 0L;
      f();
    }
  }
  
  void b(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramString3, 5, paramString2, false, false);
  }
  
  void b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoMsg buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 1);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C:flag is:" + paramLong);
    }
    if (paramLong != 0L) {
      try
      {
        String str = new String(paramArrayOfByte, "UTF-8");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf((int)paramLong), str });
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localNullPointerException);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkInfo_S2C fromUin = " + paramString + ", info = " + paramArrayOfByte, localUnsupportedEncodingException);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(31), Integer.valueOf(0), null });
  }
  
  public void b(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInvitePhoneUser --> Size = " + paramArrayList.size());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      paramArrayList = localResultRecord.jdField_a_of_type_JavaLangString;
      if (localResultRecord.jdField_a_of_type_Int == 5) {
        break label186;
      }
      paramArrayList = localResultRecord.jdField_d_of_type_JavaLangString;
    }
    label186:
    for (;;)
    {
      localArrayList.add(paramArrayList);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramArrayList) == null)) {
        break;
      }
      a().jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramArrayList))));
      break;
      paramArrayList = PstnUtils.a(localArrayList);
      a().jdField_g_of_type_JavaUtilArrayList = paramArrayList;
      a().a(paramArrayList);
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        K();
      }
      Q();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_Boolean == paramBoolean) {}
    for (;;)
    {
      return;
      this.jdField_k_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j <= 4))
        {
          if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean)) {
            b(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
          }
          if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean) {
            a(true, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
          }
          b(false, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
        }
      }
      while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.notifyAnotherSelfIsRing(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, paramBoolean);
        return;
        b(true);
        continue;
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().j > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().j <= 4))
        {
          if ((!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean)) {
            c(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
          }
          if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean) {
            a(false, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
          }
          b(true, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
        }
        else
        {
          b(false);
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().H)
          {
            if (this.jdField_f_of_type_JavaLangRunnable == null) {
              this.jdField_f_of_type_JavaLangRunnable = new ger(this);
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_f_of_type_JavaLangRunnable, 2000L);
          }
        }
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoCallData buf: " + paramArrayOfByte);
    }
    l();
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      x();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.aj, paramArrayOfByte);
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString, paramArrayOfByte);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp();
  }
  
  public boolean b(Context paramContext)
  {
    if (!NetworkUtil.e(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkChatAvilable network not support!");
      }
      QQToast.a(paramContext, 2131367256, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkChatAvilable isPhoneCalling!");
      }
      paramContext = new Intent();
      paramContext.setAction("tencent.av.v2q.CheckChatAbility");
      paramContext.putExtra("reason", "phoneCalling");
      paramContext.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramContext);
      return false;
    }
    return true;
  }
  
  public int c()
  {
    int i4 = 0;
    int i1 = 0;
    if (i4 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i4);
      if (localGAudioFriends.jdField_a_of_type_Long == CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) {}
      for (;;)
      {
        i4 += 1;
        break;
        int i2 = i1;
        if (localGAudioFriends.jdField_b_of_type_Boolean) {
          i2 = i1 + 1;
        }
        int i3 = i2;
        if (localGAudioFriends.jdField_d_of_type_Boolean) {
          i3 = i2 + 1;
        }
        i1 = i3;
        if (localGAudioFriends.jdField_c_of_type_Boolean) {
          i1 = i3 + 1;
        }
      }
    }
    return i1;
  }
  
  public int c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      return this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(paramString);
    }
    return -1;
  }
  
  public long c()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public ArrayList c()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelNetWorkTimer");
    }
    this.jdField_B_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    PopupDialog.a();
  }
  
  public void c(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 10);
    localNewIntent.putExtra("status", paramInt);
    a(localNewIntent);
  }
  
  public void c(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy groupId " + paramLong + ", relationType : " + paramInt);
    }
    String str1 = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    if (paramInt == 3) {
      str1 = SessionMgr.a(10, String.valueOf(paramLong), new int[0]);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "OnDestoryRoom--> SessionId = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString + " , State = " + ((SessionInfo)localObject).j);
      }
      if (!((SessionInfo)localObject).ap) {
        break label196;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "Is Accepting MultiAV , Can not remove the session");
      }
    }
    label178:
    label196:
    do
    {
      do
      {
        do
        {
          do
          {
            break label178;
            break label178;
            do
            {
              return;
            } while (!QLog.isColorLevel());
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDestroy has no session");
            return;
            if (this.jdField_e_of_type_Long == paramLong)
            {
              this.jdField_e_of_type_Long = 0L;
              this.an = 0;
            }
            if ((paramInt != 3) || (!((SessionInfo)localObject).jdField_z_of_type_Boolean) || ((((SessionInfo)localObject).jdField_c_of_type_JavaLangString != null) && (paramLong == Long.valueOf(((SessionInfo)localObject).jdField_c_of_type_JavaLangString).longValue()))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioRoomDistroy-->RelationId is wrong-->PeerUin = " + ((SessionInfo)localObject).jdField_c_of_type_JavaLangString + " ,relationId = " + paramLong);
          return;
          if ((!((SessionInfo)localObject).af) && (!((SessionInfo)localObject).jdField_z_of_type_Boolean))
          {
            int i1 = 6;
            if (((SessionInfo)localObject).j == 7) {
              i1 = 5;
            }
            String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
            a(str1, UITools.b(paramInt), str2, String.valueOf(paramLong), i1, ((SessionInfo)localObject).t, false, false);
          }
          ((SessionInfo)localObject).j = 0;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(2) });
        } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1));
        if (paramInt == 3)
        {
          localObject = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
          paramInt = UITools.b(paramInt);
          a(((SessionInfo)localObject).jdField_b_of_type_JavaLangString, paramInt, 10, true, String.valueOf(paramLong), null, true);
        }
      } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1));
      localObject = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    } while ((localObject == null) || (!((QAVNotification)localObject).a()));
    ((QAVNotification)localObject).a(str1);
    k();
  }
  
  void c(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaRoomSettingChanged-->relationType = " + paramInt1 + " relationUin = " + paramLong + " changedType = " + paramInt2);
    }
    if (paramInt2 == 102) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().W = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(85), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      if (paramInt2 == 103) {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().W = false;
      }
    }
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaSwitchVideoResult-->result=" + paramInt1 + "info=" + paramLong1);
    }
    if (paramInt1 == 96) {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(true, true);
        this.jdField_d_of_type_Boolean = true;
        int i1 = 0;
        if (i1 < this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size())
        {
          localObject = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.get(i1);
          if (((VideoViewInfo)localObject).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (a(((VideoViewInfo)localObject).jdField_a_of_type_Long, ((VideoViewInfo)localObject).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList)) {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = true;
            } else {
              ((VideoViewInfo)localObject).jdField_b_of_type_Boolean = false;
            }
          }
        }
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), false, true);
        Object localObject = a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGaSwitchVideoResult-->Display VideoViewInfo List = " + (String)localObject);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
      }
      return;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), true, true);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onInviteUser --> Count = " + paramInt + " , firstName = " + paramString);
    }
    if ((paramInt > 0) && (paramString != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(409), Integer.valueOf(paramInt), paramString });
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioQuitCallBack groupId " + paramLong);
    }
    a();
  }
  
  public void c(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.y)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGroupVideoClosed --> MAV is be kicked out. Relation id = " + paramLong + " ,relationType = " + paramInt1);
      }
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
      a(1, paramLong, 0, new int[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(88), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_i_of_type_JavaLangRunnable);
      this.jdField_i_of_type_JavaLangRunnable = null;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 0;
      a(1, paramLong, 17, 0, paramInt1);
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean == a().R) {
      return;
    }
    long l1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin();
    a().R = paramBoolean;
    if ((paramLong != l1) || (!paramBoolean))
    {
      l1 = this.jdField_a_of_type_Long;
      if (paramBoolean) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      a(l1, bool);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(139), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      return;
    }
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoOfflineMsg");
    }
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    g(4);
    paramBundle = paramBundle.getByteArray("buffer");
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      x();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.al, paramBundle);
    }
    a(0, 0, 5000);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "resumeVideo SessionType :" + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int);
    }
    GraphicRenderMgr.getInstance().clearCameraFrames();
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int > 2) || (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().f())) {}
    while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.resumeVideo(paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (paramInt == 23) {}
    for (int i1 = 1;; i1 = paramInt)
    {
      String str1 = SessionMgr.a(3, paramString, new int[0]);
      SessionInfo localSessionInfo;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1))
      {
        localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
        if (localSessionInfo != null) {
          break label84;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "closeSession fail to find session");
        }
      }
      label84:
      do
      {
        return;
        str1 = SessionMgr.a(10, paramString, new int[0]);
        localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1);
        break;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "closeSession type = " + i1 + ", peerUin = " + paramString + ", mPeerUin = " + localSessionInfo.jdField_c_of_type_JavaLangString + ", mIsAudioMode = " + localSessionInfo.jdField_K_of_type_Boolean + ", mNetTrafficAllSize = " + this.jdField_b_of_type_Long + ", sessionType = " + localSessionInfo.jdField_f_of_type_Int + ", mAnyChatCloseByFriend = " + this.jdField_f_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Gfg != null)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfg);
          this.jdField_a_of_type_Gfg = null;
        }
        if (!localSessionInfo.a()) {
          break label247;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession state error!!!");
      return;
      label247:
      if ((localSessionInfo.jdField_f_of_type_Int == 2) && (!localSessionInfo.jdField_z_of_type_Boolean) && (localSessionInfo.j >= 4) && (localSessionInfo.jdField_c_of_type_Long > 0L))
      {
        int i2 = AVNotifyCenter.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession double video call end with beauty: " + i2 + " | " + localSessionInfo.jdField_c_of_type_Long + " | " + localSessionInfo.j + " | " + localSessionInfo.jdField_r_of_type_Boolean);
        }
        if ((localSessionInfo.jdField_r_of_type_Boolean) || (i2 > 0)) {
          ReportController.b(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
        }
      }
      localSessionInfo.jdField_b_of_type_Long = 0L;
      localSessionInfo.jdField_p_of_type_JavaLangString = null;
      String str2 = paramString;
      if (!TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString))
      {
        str2 = paramString;
        if (localSessionInfo.jdField_c_of_type_JavaLangString.contains(paramString)) {
          str2 = localSessionInfo.jdField_c_of_type_JavaLangString;
        }
      }
      if ((localSessionInfo.g()) || (localSessionInfo.h())) {
        localSessionInfo.jdField_z_of_type_Int = i1;
      }
      if ((localSessionInfo.c()) || ((localSessionInfo.d()) && (i1 == localSessionInfo.jdField_z_of_type_Int))) {
        localSessionInfo.jdField_c_of_type_Long = 0L;
      }
      if ((localSessionInfo.ag) && (this.jdField_e_of_type_JavaLangRunnable != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        this.jdField_e_of_type_JavaLangRunnable = null;
      }
      boolean bool;
      if (paramInt == 23)
      {
        bool = false;
        if (localSessionInfo.jdField_f_of_type_Int == 2) {
          bool = true;
        }
        a(localSessionInfo.jdField_b_of_type_JavaLangString, localSessionInfo.l, bool, localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.jdField_e_of_type_JavaLangString);
        label601:
        this.jdField_b_of_type_Long = 0L;
        if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a())
        {
          t();
          w();
          E();
          h();
        }
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Boolean = false;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_JavaLangString = null;
        localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_c_of_type_JavaLangString = null;
        if (this.jdField_a_of_type_Boolean)
        {
          DataReport.c(this, false);
          DataReport.e(this, false);
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0) {
            DataReport.p(this);
          }
        }
        localSessionInfo.j = 0;
        localSessionInfo.jdField_f_of_type_Int = 0;
        localSessionInfo.jdField_h_of_type_Int = 0;
        if ((localSessionInfo.jdField_K_of_type_Int != -1) && (localSessionInfo.jdField_h_of_type_Long != 0L))
        {
          long l1 = (System.currentTimeMillis() - localSessionInfo.jdField_h_of_type_Long) / 1000L;
          paramString = new HashMap();
          paramString.put("tempID", localSessionInfo.jdField_z_of_type_JavaLangString);
          paramString.put("duration", l1 + "");
          UserAction.onUserAction(EffectsRenderController.jdField_b_of_type_JavaLangString, true, -1L, -1L, paramString, true);
          if (QLog.isColorLevel()) {
            QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, "closeSession  path:  " + localSessionInfo.jdField_y_of_type_JavaLangString + "  gadTime: " + l1);
          }
          if (QLog.isColorLevel()) {
            QLog.d(EffectsRenderController.jdField_a_of_type_JavaLangString, 2, EffectsRenderController.jdField_b_of_type_JavaLangString + "   ID:  " + a().a().jdField_z_of_type_JavaLangString + "  gadTime: " + l1);
          }
        }
        localSessionInfo.jdField_K_of_type_Int = -1;
        localSessionInfo.jdField_h_of_type_Long = 0L;
        GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(0, 1);
        localSessionInfo.jdField_z_of_type_JavaLangString = "";
        localSessionInfo.at = false;
        localSessionInfo.jdField_a_of_type_ArrayOfJavaLangString = null;
        localSessionInfo.jdField_r_of_type_JavaLangString = null;
        localSessionInfo.jdField_k_of_type_Boolean = true;
        localSessionInfo.jdField_g_of_type_Int = 0;
        localSessionInfo.jdField_a_of_type_ComTencentAvUiJSInterfacePushData = null;
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "closeSession uinType = " + localSessionInfo.l + " # matchStatus = " + localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int);
        }
        if ((i1 != 21) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (!this.jdField_f_of_type_Boolean))
        {
          localSessionInfo.l = -1;
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() <= 0) {
            break label1386;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), str2, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        label1121:
        if ((localSessionInfo.l != 1011) || ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 2) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6))) {
          break label1417;
        }
        if ((!this.jdField_f_of_type_Boolean) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int != 6)) {
          break label1400;
        }
        a(6, 1, null);
        label1185:
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), str2, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        label1225:
        if ((n()) && (this.jdField_a_of_type_Boolean) && ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 2)))
        {
          localSessionInfo.c();
          a(0, 0, null);
        }
        localSessionInfo.jdField_c_of_type_Long = 0L;
        localSessionInfo.b();
        bool = false;
        if (this.jdField_f_of_type_Boolean) {
          break label1470;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "close session removeSession sessionId = " + str1);
        bool = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str1);
      }
      for (;;)
      {
        paramString = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((paramString == null) || (!paramString.a()) || (this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramString.a(str1);
        if (!bool) {
          break;
        }
        k();
        return;
        a(str1, str2, i1);
        break label601;
        label1386:
        if (!this.jdField_a_of_type_Boolean) {
          break label1121;
        }
        a();
        break label1121;
        label1400:
        a(localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
        break label1185;
        label1417:
        if (!this.jdField_f_of_type_Boolean) {
          break label1225;
        }
        a(6, 1, null);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(203), str2, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        break label1225;
        label1470:
        this.jdField_a_of_type_ComTencentAvSessionMgr.a(str1, 3);
      }
    }
  }
  
  void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchGroup is:" + paramLong);
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 4)) {}
    while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString.compareToIgnoreCase(paramString) != 0) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().O) {
      a(2131165195, 1, null);
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().O = true;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_k_of_type_Int = 11;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
    o();
  }
  
  public void c(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "on 0x626Recv --> Size = " + paramArrayList.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "on0x626Recv --> no data");
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    paramArrayList = paramArrayList.iterator();
    AVPhoneUserInfo localAVPhoneUserInfo;
    Iterator localIterator;
    int i1;
    label114:
    Object localObject;
    if (paramArrayList.hasNext())
    {
      localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      localIterator = a().jdField_f_of_type_JavaUtilArrayList.iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        localObject = (AVPhoneUserInfo)localIterator.next();
        if ((((AVPhoneUserInfo)localObject).account == 0L) || (((AVPhoneUserInfo)localObject).account != localAVPhoneUserInfo.account)) {
          break label442;
        }
        ((AVPhoneUserInfo)localObject).telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
        ((AVPhoneUserInfo)localObject).telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
        ((AVPhoneUserInfo)localObject).telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        i1 = 1;
      }
    }
    label442:
    for (;;)
    {
      break label114;
      if ((i1 == 0) && (QLog.isColorLevel()))
      {
        localStringBuilder.append("on0x626Recv --> can not find the item . Info = ");
        localStringBuilder.append(localAVPhoneUserInfo.toString());
        localStringBuilder.append("\n");
      }
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoController.GAudioFriends)localIterator.next();
        if ((((VideoController.GAudioFriends)localObject).jdField_c_of_type_Int == 1) && (((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long == localAVPhoneUserInfo.account))
        {
          if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo == null) {
            ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = new AVPhoneUserInfo();
          }
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.accountType = 2;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.account = localAVPhoneUserInfo.account;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.mobile = localAVPhoneUserInfo.telInfo.mobile;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.nation = localAVPhoneUserInfo.telInfo.nation;
          ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo.telInfo.prefix = localAVPhoneUserInfo.telInfo.prefix;
        }
      }
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(406) });
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioOpt(paramBoolean);
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvMultiVideoAck");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      x();
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.onRecvGAudioCMD(this.ak, paramArrayOfByte);
  }
  
  public void c(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null)
    {
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController.b(paramArrayOfByte, paramLong);
  }
  
  public boolean c()
  {
    boolean bool2 = true;
    int i1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().l;
    if ((i1 == 21) || (i1 == 22) || (i1 == 26)) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int != 1) {
        break;
      }
    } while (!this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp());
    String str2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1006)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_JavaLangString != null) {
          str1 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_JavaLangString;
        }
      }
    }
    try
    {
      long l1 = CharacterUtil.a(str1);
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.hasAVShiftAbility(l1);
      if (i1 == -1) {
        break label257;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i2;
        label257:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "Can not get Number. PeerUin = " + str1);
        }
        boolean bool1 = false;
        continue;
        label303:
        if (i1 == 5)
        {
          bool1 = bool2;
          if (i2 >= 5437) {}
        }
        else
        {
          bool1 = false;
        }
      }
    }
    if (!bool1)
    {
      i1 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerTerminalType(str1);
      i2 = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getPeerSdkVersion(str1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canAVShift peerTerminalType: " + i1 + ", peerSharpVersion: " + i2);
      }
      if (i2 >= 16)
      {
        bool1 = bool2;
        if (i1 != 4)
        {
          bool1 = bool2;
          if (i1 != 2)
          {
            if (i1 != 3) {
              break label303;
            }
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      break;
      return true;
    }
  }
  
  public int d()
  {
    Object localObject = AppNetConnInfo.getRecentNetworkInfo();
    if (localObject == null) {}
    do
    {
      return 0;
      if (((NetworkInfo)localObject).getType() == 1) {
        return 1;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo();
    } while (localObject == null);
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_c_of_type_JavaLangString)) {
      return 3;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_d_of_type_JavaLangString)) {
      return 2;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_a_of_type_JavaLangString)) {
      return 7;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_b_of_type_JavaLangString)) {
      return 6;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_e_of_type_JavaLangString)) {
      return 5;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_f_of_type_JavaLangString)) {
      return 4;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_g_of_type_JavaLangString)) {
      return 9;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_h_of_type_JavaLangString)) {
      return 8;
    }
    int i1 = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
    if (i1 == 4)
    {
      localObject = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSimOperator();
        if (localObject != null)
        {
          if ((((String)localObject).equals("46000")) || (((String)localObject).equals("46002")) || (((String)localObject).equals("46007"))) {
            return 11;
          }
          if (((String)localObject).equals("46001")) {
            return 12;
          }
          if (((String)localObject).equals("46003")) {
            return 13;
          }
        }
      }
      return 11;
    }
    if (i1 == 3) {
      return 10;
    }
    if (i1 == 2) {
      return 2;
    }
    return 100;
  }
  
  public ArrayList d()
  {
    ArrayList localArrayList = new ArrayList();
    if (a() == null) {
      return localArrayList;
    }
    Iterator localIterator = a().jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((Long)localIterator.next());
    }
    localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)localIterator.next();
      if ((localGAudioFriends.jdField_c_of_type_Int == 0) && (localArrayList.contains(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long)))) {
        localArrayList.remove(Long.valueOf(localGAudioFriends.jdField_a_of_type_Long));
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 992	com/tencent/av/VideoController:a	()Landroid/content/Context;
    //   4: invokestatic 1080	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   7: ifne +176 -> 183
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 2927	com/tencent/av/VideoController:jdField_D_of_type_Int	I
    //   15: aload_0
    //   16: invokevirtual 992	com/tencent/av/VideoController:a	()Landroid/content/Context;
    //   19: ldc_w 3348
    //   22: invokevirtual 1415	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   25: checkcast 3350	android/view/WindowManager
    //   28: astore_1
    //   29: new 1334	android/util/DisplayMetrics
    //   32: dup
    //   33: invokespecial 3351	android/util/DisplayMetrics:<init>	()V
    //   36: astore_2
    //   37: aload_1
    //   38: invokeinterface 3355 1 0
    //   43: aload_2
    //   44: invokevirtual 3361	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   47: aload_2
    //   48: getfield 3364	android/util/DisplayMetrics:widthPixels	I
    //   51: istore 4
    //   53: aload_2
    //   54: getfield 3367	android/util/DisplayMetrics:heightPixels	I
    //   57: istore 5
    //   59: aload_0
    //   60: invokevirtual 1003	com/tencent/av/VideoController:d	()I
    //   63: istore 6
    //   65: new 884	com/tencent/av/core/VcControllerImpl
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 992	com/tencent/av/VideoController:a	()Landroid/content/Context;
    //   73: getstatic 3370	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   76: invokestatic 1614	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: aload_0
    //   80: aload_0
    //   81: iload 4
    //   83: iload 5
    //   85: iload 6
    //   87: invokespecial 3373	com/tencent/av/core/VcControllerImpl:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/av/core/AbstractNetChannel;Lcom/tencent/av/core/IVideoEventListener;III)V
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 165	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   95: invokevirtual 356	com/tencent/av/app/VideoAppInterface:a	()Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: astore_2
    //   101: aload_1
    //   102: invokestatic 1050	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +7 -> 112
    //   108: ldc_w 2570
    //   111: astore_2
    //   112: aload_2
    //   113: invokestatic 361	com/tencent/av/utils/CharacterUtil:a	(Ljava/lang/String;)J
    //   116: lstore 7
    //   118: aload_0
    //   119: getfield 165	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   122: invokevirtual 635	com/tencent/av/app/VideoAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   125: invokevirtual 640	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   128: astore_1
    //   129: aload_3
    //   130: aload_0
    //   131: invokevirtual 992	com/tencent/av/VideoController:a	()Landroid/content/Context;
    //   134: lload 7
    //   136: ldc_w 3375
    //   139: getstatic 3380	android/os/Build:MODEL	Ljava/lang/String;
    //   142: getstatic 3370	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   145: invokestatic 1614	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   148: aload_1
    //   149: invokestatic 3381	com/tencent/common/config/AppSetting:a	()Ljava/lang/String;
    //   152: aload_0
    //   153: invokevirtual 3382	com/tencent/av/VideoController:a	()Ljava/lang/String;
    //   156: invokestatic 3383	com/tencent/av/core/VcSystemInfo:a	()Ljava/lang/String;
    //   159: getstatic 3386	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   162: getstatic 3389	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   165: getstatic 3392	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   168: invokestatic 3394	com/tencent/av/core/VcSystemInfo:c	()Ljava/lang/String;
    //   171: iload 6
    //   173: invokevirtual 3398	com/tencent/av/core/VcControllerImpl:init	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
    //   176: pop
    //   177: aload_0
    //   178: aload_3
    //   179: putfield 163	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvCoreVcControllerImpl	Lcom/tencent/av/core/VcControllerImpl;
    //   182: return
    //   183: aload_0
    //   184: invokevirtual 992	com/tencent/av/VideoController:a	()Landroid/content/Context;
    //   187: invokestatic 3400	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   190: ifeq +11 -> 201
    //   193: aload_0
    //   194: iconst_1
    //   195: putfield 2927	com/tencent/av/VideoController:jdField_D_of_type_Int	I
    //   198: goto -183 -> 15
    //   201: aload_0
    //   202: iconst_2
    //   203: putfield 2927	com/tencent/av/VideoController:jdField_D_of_type_Int	I
    //   206: goto -191 -> 15
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 1070	java/lang/NumberFormatException:printStackTrace	()V
    //   214: return
    //   215: astore_1
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 163	com/tencent/av/VideoController:jdField_a_of_type_ComTencentAvCoreVcControllerImpl	Lcom/tencent/av/core/VcControllerImpl;
    //   221: return
    //   222: astore_1
    //   223: invokestatic 330	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +13 -> 239
    //   229: getstatic 132	com/tencent/av/VideoController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: iconst_2
    //   233: ldc_w 3402
    //   236: invokestatic 684	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -112 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	VideoController
    //   28	121	1	localObject1	Object
    //   209	2	1	localNumberFormatException	NumberFormatException
    //   215	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   222	1	1	localException	Exception
    //   240	1	1	localObject2	Object
    //   36	77	2	localObject3	Object
    //   90	89	3	localVcControllerImpl	VcControllerImpl
    //   51	31	4	i1	int
    //   57	27	5	i2	int
    //   63	109	6	i3	int
    //   116	19	7	l1	long
    // Exception table:
    //   from	to	target	type
    //   101	108	209	java/lang/NumberFormatException
    //   112	118	209	java/lang/NumberFormatException
    //   59	99	215	java/lang/UnsatisfiedLinkError
    //   101	108	215	java/lang/UnsatisfiedLinkError
    //   112	118	215	java/lang/UnsatisfiedLinkError
    //   118	129	215	java/lang/UnsatisfiedLinkError
    //   129	182	215	java/lang/UnsatisfiedLinkError
    //   210	214	215	java/lang/UnsatisfiedLinkError
    //   223	239	215	java/lang/UnsatisfiedLinkError
    //   118	129	222	java/lang/Exception
  }
  
  public void d(int paramInt)
  {
    l();
    this.ad = paramInt;
  }
  
  public void d(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->GroupId=" + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->mGAudioCtrl is null");
      }
      return;
    }
    a().jdField_D_of_type_Boolean = true;
    Object localObject3;
    Object localObject1;
    int i1;
    Object localObject2;
    int i2;
    label746:
    long l1;
    int i3;
    if (paramInt == 2)
    {
      a().jdField_a_of_type_JavaUtilArrayList.clear();
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->double to multi-->invite type:" + a().jdField_y_of_type_Int);
        }
        if (a().jdField_y_of_type_Int == 1)
        {
          localArrayList = new ArrayList();
          localObject3 = new ArrayList();
          if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->double to multi-->uinList:" + this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList);
            }
            paramInt = 0;
            if (paramInt < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
            {
              localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(paramInt) + "");
              if (localObject1 != null) {
                ((ArrayList)localObject3).add(localObject1);
              }
              for (;;)
              {
                paramInt += 1;
                break;
                localArrayList.add(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(paramInt));
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc-->double to multi-->inviteByIpList:" + localArrayList + "-->inviteByPhoneList:" + localObject3);
          }
          i1 = localArrayList.size();
          localObject1 = null;
          if (i1 > 0)
          {
            localObject2 = new long[i1 * 2];
            paramInt = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (paramInt >= i1) {
                break;
              }
              localObject2[(paramInt * 2)] = 1L;
              localObject2[(paramInt * 2 + 1)] = ((Long)localArrayList.get(paramInt)).longValue();
              if (!a().jdField_a_of_type_JavaUtilArrayList.contains(localArrayList.get(paramInt))) {
                a().jdField_a_of_type_JavaUtilArrayList.add(localArrayList.get(paramInt));
              }
              paramInt += 1;
            }
          }
          i2 = ((ArrayList)localObject3).size();
          localObject2 = null;
          if (i2 > 0)
          {
            localObject2 = new String[i2 * 3];
            localArrayList = new ArrayList();
            paramInt = 0;
            while (paramInt < i2)
            {
              localAVPhoneUserInfo = PstnUtils.a((String)((ArrayList)localObject3).get(paramInt));
              localArrayList.add(localAVPhoneUserInfo);
              localObject2[(paramInt * 3)] = localAVPhoneUserInfo.telInfo.nation;
              localObject2[(paramInt * 3 + 1)] = localAVPhoneUserInfo.telInfo.prefix;
              localObject2[(paramInt * 3 + 2)] = localAVPhoneUserInfo.telInfo.mobile;
              paramInt += 1;
            }
            a().a(localArrayList);
            j();
          }
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite((long[])localObject1, i1, (String[])localObject2, i2, 0, false, true, 0);
          a().x = 1;
          a().jdField_F_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(true) });
        }
        while ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList == null) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() <= 0))
        {
          ArrayList localArrayList;
          AVPhoneUserInfo localAVPhoneUserInfo;
          if (((a().jdField_y_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mIsSwitchGroup)) && (a().jdField_g_of_type_JavaUtilArrayList != null) && (a().jdField_g_of_type_JavaUtilArrayList.size() > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc send invite-->discussion , invite phone size = " + a().jdField_g_of_type_JavaUtilArrayList.size());
            }
            K();
          }
          c();
          this.jdField_e_of_type_Boolean = true;
          a().ap = false;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, " OnCreateSuc--> SetAccepting False. SessionId = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(83), Long.valueOf(paramLong) });
          if ((!a().n()) || (a().jdField_F_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {
            break;
          }
          if (this.jdField_a_of_type_Gfk == null) {
            this.jdField_a_of_type_Gfk = new gfk(this);
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gfk, this.M * 1000);
          return;
        }
        i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
        l1 = a().jdField_f_of_type_Long;
        localObject1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
        paramInt = this.H;
        i1 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnLevel;
        ((QQGAudioCtrl)localObject1).inviteUser(new long[] { l1 }, paramInt, 1, i1);
        i3 = i2 - 1;
        localObject1 = new long[i3 * 2];
        paramInt = 0;
        i1 = 0;
        label1007:
        if (i1 < i2)
        {
          if ((((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue() == l1) || (paramInt >= i3)) {
            break label2115;
          }
          localObject1[(paramInt * 2)] = 1L;
          localObject1[(paramInt * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
          paramInt += 1;
        }
      }
    }
    label2115:
    for (;;)
    {
      i1 += 1;
      break label1007;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f() >= 6)
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject1, i3, null, 0);
        break;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite((long[])localObject1, i3, null, 0, 0, false, false, 0);
      break;
      localObject2 = null;
      i1 = 0;
      localObject1 = localObject2;
      paramInt = i1;
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null)
      {
        localObject1 = localObject2;
        paramInt = i1;
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size() > 0)
        {
          i2 = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size();
          localObject2 = new long[i2 * 2];
          i1 = 0;
          for (;;)
          {
            localObject1 = localObject2;
            paramInt = i2;
            if (i1 >= i2) {
              break;
            }
            localObject2[(i1 * 2)] = 1L;
            localObject2[(i1 * 2 + 1)] = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
            i1 += 1;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc send invite-->discussion , invite type = " + a().jdField_y_of_type_Int);
      }
      i3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.f();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc send invite-->discussion , self bind state = " + i3);
      }
      if ((this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null) && (a().jdField_g_of_type_JavaUtilArrayList != null) && ((a().jdField_y_of_type_Int == 0) || (a().jdField_y_of_type_Int == 2)))
      {
        i1 = 0;
        if (i1 < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
        {
          l1 = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1)).longValue();
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(l1 + "");
          if (localObject2 != null)
          {
            localObject2 = PstnUtils.a((String)localObject2);
            i2 = 0;
          }
          for (;;)
          {
            if (i2 < a().jdField_g_of_type_JavaUtilArrayList.size())
            {
              localObject3 = (AVPhoneUserInfo)a().jdField_g_of_type_JavaUtilArrayList.get(i2);
              if ((((AVPhoneUserInfo)localObject2).telInfo.mobile != null) && (((AVPhoneUserInfo)localObject3).telInfo.mobile != null) && (((AVPhoneUserInfo)localObject2).telInfo.mobile.equals(((AVPhoneUserInfo)localObject3).telInfo.mobile))) {
                a().jdField_g_of_type_JavaUtilArrayList.remove(i2);
              }
            }
            else
            {
              i1 += 1;
              break;
            }
            i2 += 1;
          }
        }
      }
      if ((a().jdField_y_of_type_Int == 0) || (i3 < 6))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateSuc getSessionInfo().isConferenceFlyTicket = " + a().as);
        }
        if (!a().as) {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite((long[])localObject1, paramInt, null, 0, 0, false, false, 0);
        }
        i1 = 0;
        while (i1 < paramInt)
        {
          if (!a().jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(i1));
          }
          i1 += 1;
        }
        break;
      }
      if (a().jdField_y_of_type_Int == 2)
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy((long[])localObject1, paramInt, null, 0);
        break;
      }
      if (a().jdField_y_of_type_Int == 1)
      {
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
        break;
      }
      if (a().jdField_y_of_type_Int != 4) {
        break;
      }
      localObject3 = new ArrayList();
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList != null)
      {
        paramInt = 0;
        if (paramInt < this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.size())
        {
          l1 = ((Long)this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.mInviteGAudioUinList.get(paramInt)).longValue();
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(l1 + "");
          if (localObject1 != null) {
            a().jdField_g_of_type_JavaUtilArrayList.add(PstnUtils.a((String)localObject1));
          }
          for (;;)
          {
            paramInt += 1;
            break;
            ((ArrayList)localObject3).add(Long.valueOf(l1));
            if (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(l1))) {
              a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l1));
            }
          }
        }
        i1 = ((ArrayList)localObject3).size();
        localObject1 = null;
        if (i1 > 0)
        {
          localObject2 = new long[i1 * 2];
          paramInt = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (paramInt >= i1) {
              break;
            }
            localObject2[(paramInt * 2)] = 1L;
            localObject2[(paramInt * 2 + 1)] = ((Long)((ArrayList)localObject3).get(paramInt)).longValue();
            paramInt += 1;
          }
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite((long[])localObject1, i1, null, 0, 0, false, false, 0);
      }
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getInviteStrategy(null, 0, null, 0);
      break;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "send invite-->group.");
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.inviteUser(null, 0, this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnOriginal, this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.pstnLevel);
      break label746;
    }
  }
  
  void d(int paramInt1, long paramLong, int paramInt2)
  {
    boolean bool;
    if (paramInt2 == 108)
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().Y = true;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
      if (!h())
      {
        bool = true;
        localSessionInfo.X = bool;
        a(this.jdField_a_of_type_Long, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(86), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().Y)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().Y = false;
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().X) {
          a(this.jdField_a_of_type_Long, true);
        } else {
          a(this.jdField_a_of_type_Long, false);
        }
      }
    }
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void d(Bundle paramBundle)
  {
    g(4);
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int i1 = d(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() + ", fromUin = " + str + ", result = " + i1 + ",isFriend:" + bool);
    }
    this.C = 0;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if ((a().f()) && (a().l == 1006) && (!a().jdField_a_of_type_Boolean))
    {
      a().jdField_e_of_type_JavaLangString = str;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoCallData: CONTACT_STRANGER_FRIEND  peerUin = " + str);
      }
    }
    a(0, 0, 5000);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideo fromUin = " + paramString);
    }
    c(paramString, 3);
  }
  
  public void d(String paramString, int paramInt)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess fromUin = " + paramString + ", info :" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    label296:
    do
    {
      return;
      if (this.jdField_e_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
        this.jdField_e_of_type_JavaLangRunnable = null;
      }
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().ah)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().ah = false;
        boolean bool2;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), a().jdField_c_of_type_JavaLangString, Boolean.valueOf(false) });
          bool2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean;
          if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int == 1) && (bool2))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess, notify local has video");
            }
            if ((-1 == this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchVideo(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "onSwitchTerminalSuccess, notify local has video success");
            }
          }
          paramInt = (int)b();
          bool2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean;
          if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean) {
            break label296;
          }
        }
        for (;;)
        {
          a(paramInt, bool2, bool1);
          return;
          paramString = new gem(this);
          this.jdField_a_of_type_JavaUtilList.add(paramString);
          break;
          bool1 = false;
        }
      }
    } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().ag);
    k(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
  }
  
  public void d(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteResp");
    }
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInviteResp avInviteAccountList size " + paramArrayList.size());
      }
      if (a().jdField_a_of_type_JavaUtilArrayList != null)
      {
        int i1 = 0;
        while (i1 < paramArrayList.size())
        {
          if ((((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Int == 1) && (((AVInviteAccount)paramArrayList.get(i1)).jdField_c_of_type_Int == 1) && (!a().jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Long)))) {
            a().jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((AVInviteAccount)paramArrayList.get(i1)).jdField_a_of_type_Long));
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(true) });
      }
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(24), Boolean.valueOf(false) });
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    c(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), paramArrayOfByte, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvVideoCloudConfig cloud-config msg.");
    }
  }
  
  public void d(byte[] paramArrayOfByte, long paramLong)
  {
    String str = null;
    if (paramLong == 0L) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_I_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(27), str });
      return;
      if (paramLong == 1L)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_I_of_type_Boolean = true;
      }
      else if (paramLong == 100L)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().J = false;
      }
      else if (paramLong == 101L)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().J = true;
        if (paramArrayOfByte != null) {
          str = new String(paramArrayOfByte);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_I_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().J = false;
      }
    }
  }
  
  public boolean d()
  {
    int i1 = a().l;
    if (i1 == 1011) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift uinType: " + i1);
      }
    }
    int i2;
    do
    {
      do
      {
        do
        {
          return false;
          i2 = a().jdField_A_of_type_Int;
          if (!VideoUtils.a(i1, i2)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("canMultiShift uinType:%d, bindType:%d ", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
        return false;
        if ((a().C) && (i1 == 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift isFriend: false");
      return false;
      i1 = c(a().jdField_c_of_type_JavaLangString);
      i2 = b(a().jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "canMultiShift peerTerminalType: " + i2 + ", peerSharpVersion: " + i1);
      }
      if ((i1 >= 16) && ((i2 == 4) || (i2 == 2) || (i2 == 3))) {
        return true;
      }
    } while ((i2 != 5) || (i1 < 5437));
    return true;
  }
  
  public int e()
  {
    return d();
  }
  
  public ArrayList e()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().iterator();
    label104:
    while (localIterator.hasNext())
    {
      Object localObject = (VideoController.GAudioFriends)localIterator.next();
      if (((VideoController.GAudioFriends)localObject).jdField_c_of_type_Int != 0)
      {
        long l1 = ((VideoController.GAudioFriends)localObject).jdField_a_of_type_Long;
        if (((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null) {}
        for (localObject = ((VideoController.GAudioFriends)localObject).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;; localObject = a(l1, a().jdField_f_of_type_JavaUtilArrayList))
        {
          if ((localObject == null) || (((AVPhoneUserInfo)localObject).telInfo.mobile == null)) {
            break label104;
          }
          localArrayList.add(((AVPhoneUserInfo)localObject).telInfo.mobile);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendGetGatewayIpReq");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void e(int paramInt)
  {
    h(paramInt);
  }
  
  public void e(Bundle paramBundle)
  {
    g(4);
    paramBundle = paramBundle.getByteArray("buffer");
    int i1 = e(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue(), paramBundle, null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvSharpVideoAck: result = " + i1);
    }
    a(0, 0, 3000);
  }
  
  public void e(String paramString)
  {
    w();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelRequest: fromUin = " + paramString);
    }
    c(paramString, 10);
  }
  
  public void e(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTerminalFail fromUin = " + paramString + ", info :" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(false) });
  }
  
  public void e(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp");
    }
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp size " + paramArrayList.size());
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        Object localObject = ((AVInvitePSTNPhone)paramArrayList.get(i1)).a;
        String str1 = ((TelInfo)localObject).jdField_a_of_type_JavaLangString;
        String str2 = ((TelInfo)localObject).jdField_b_of_type_JavaLangString;
        localObject = ((TelInfo)localObject).jdField_c_of_type_JavaLangString;
        str1 = str1 + str2 + (String)localObject;
        PstnNumberManager.a(str1, 0);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGAudioInvitePSTNResp insert number code= " + str1);
        i1 += 1;
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvFirstAudioData recvFirstAudio = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) {
        break label123;
      }
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        if (-1 != this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.switchAudio(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString)) {
          break label115;
        }
        this.l = false;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(25), Boolean.valueOf(paramBoolean) });
      return;
      label115:
      this.l = true;
      continue;
      label123:
      this.l = true;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvIVRPush");
    }
  }
  
  public boolean e()
  {
    boolean bool = false;
    String str = a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->info=" + str);
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      i1 = 0;
      if (i1 < this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.size())
      {
        if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Long == Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue()) {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.remove(i1);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoRecv(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList) == 0) {
          break label159;
        }
        bool = true;
      }
    }
    label159:
    do
    {
      return bool;
      i1 += 1;
      break;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,ViewInfos=" + str);
      }
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.clear();
      return false;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_JavaUtilArrayList.clear();
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "RequestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + str);
    return false;
  }
  
  public int f()
  {
    return this.C;
  }
  
  public ArrayList f()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)localIterator.next();
      if ((localAVPhoneUserInfo != null) && (localAVPhoneUserInfo.telInfo.mobile != null)) {
        localArrayList.add(localAVPhoneUserInfo.telInfo.mobile);
      }
    }
    return localArrayList;
  }
  
  public void f()
  {
    TraeHelper localTraeHelper = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    w();
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 4;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13) });
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean) {
        break label175;
      }
      a(true, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gfb(this), 50L);
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int, true, true, true);
      DataReport.m(this);
      DataReport.e(this, true);
      DataReport.c(this, true);
      return;
      k();
      break;
      label175:
      a(false, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.AvSwitch");
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", this.jdField_a_of_type_ComTencentAvSessionMgr.a().l);
      localIntent.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_JavaLangString);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptedVideo: fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 3;
  }
  
  public void f(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().ag)
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "not start StartByTerminalSwitch but receive onSyncOtherTerminalChatStatus message");
      }
      return;
    }
    int i2 = paramInt & 0xFFFFF;
    int i1 = paramInt >> 20 & 0x1;
    int i3 = paramInt >> 21 & 0x1;
    paramInt = i1;
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().ai)
    {
      paramInt = i1;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 1)
      {
        paramInt = i1;
        if (c())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "switch start frome video entry, open camera");
          }
          paramInt = 1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Long = i2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onSyncOtherTerminalChatStatus time:" + i2 + ", isCamreOpen:" + paramInt + ", isMicOpen:" + i3);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(34), Integer.valueOf(paramInt), Integer.valueOf(i3) });
  }
  
  public void f(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy");
    }
    if (paramArrayList == null) {
      this.jdField_j_of_type_Boolean = false;
    }
    do
    {
      boolean bool;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy avInviteAccountList size " + paramArrayList.size());
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject1 = new StringBuilder("onGetGAudioInviteStrategy Result:\n");
        int i1 = 0;
        int i2 = 0;
        Object localObject2;
        Object localObject3;
        if (i2 < paramArrayList.size())
        {
          localObject2 = (AVInviteAccount)paramArrayList.get(i2);
          ((StringBuilder)localObject1).append("AccountType:" + ((AVInviteAccount)localObject2).jdField_a_of_type_Int + "|Account:" + ((AVInviteAccount)localObject2).jdField_a_of_type_Long + "|InviteType:" + ((AVInviteAccount)localObject2).jdField_c_of_type_Int + "\n");
          if (((AVInviteAccount)localObject2).jdField_a_of_type_Int != 1) {}
          for (;;)
          {
            i2 += 1;
            break;
            if (((AVInviteAccount)localObject2).jdField_a_of_type_Long == CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
            {
              if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 2) {
                i1 = 1;
              }
            }
            else if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 1)
            {
              localArrayList1.add(Long.valueOf(((AVInviteAccount)localObject2).jdField_a_of_type_Long));
            }
            else if (((AVInviteAccount)localObject2).jdField_c_of_type_Int == 2)
            {
              localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(((AVInviteAccount)localObject2).jdField_a_of_type_Long + "");
              if (localObject3 != null) {
                localArrayList2.add(localObject3);
              } else {
                localArrayList1.add(Long.valueOf(((AVInviteAccount)localObject2).jdField_a_of_type_Long));
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject1).toString());
        }
        int i3 = localArrayList1.size();
        paramArrayList = null;
        if (i3 > 0)
        {
          localObject1 = new long[i3 * 2];
          i2 = 0;
          for (;;)
          {
            paramArrayList = (ArrayList)localObject1;
            if (i2 >= i3) {
              break;
            }
            localObject1[(i2 * 2)] = 1L;
            localObject1[(i2 * 2 + 1)] = ((Long)localArrayList1.get(i2)).longValue();
            i2 += 1;
          }
        }
        int i4 = localArrayList2.size();
        localObject1 = null;
        if (i4 > 0)
        {
          localObject1 = new String[i4 * 3];
          localObject2 = new ArrayList();
          i2 = 0;
          while (i2 < i4)
          {
            localObject3 = PstnUtils.a((String)localArrayList2.get(i2));
            ((ArrayList)localObject2).add(localObject3);
            localObject1[(i2 * 3)] = ((AVPhoneUserInfo)localObject3).telInfo.nation;
            localObject1[(i2 * 3 + 1)] = ((AVPhoneUserInfo)localObject3).telInfo.prefix;
            localObject1[(i2 * 3 + 2)] = ((AVPhoneUserInfo)localObject3).telInfo.mobile;
            i2 += 1;
          }
          a().a((ArrayList)localObject2);
          j();
        }
        if ((this.jdField_j_of_type_Boolean) && (i1 != 0)) {}
        for (bool = true;; bool = false)
        {
          this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.Invite(paramArrayList, i3, (String[])localObject1, i4, 0, false, bool, 0);
          this.jdField_j_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetGAudioInviteStrategy invite qqAccount size:" + i3 + ",phoneAccount size:" + i4 + ",callMySelf:" + bool);
          }
          i1 = 0;
          while (i1 < localArrayList1.size())
          {
            if (!a().jdField_a_of_type_JavaUtilArrayList.contains(localArrayList1.get(i1))) {
              a().jdField_a_of_type_JavaUtilArrayList.add(localArrayList1.get(i1));
            }
            i1 += 1;
          }
        }
      } while (!bool);
      a().x = 1;
      a().jdField_F_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(705), Boolean.valueOf(true) });
  }
  
  void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyChangeDoubleVideoMeeting2MultiVideo");
    }
    long l1 = Long.valueOf(a().jdField_c_of_type_JavaLangString).longValue();
    int i1 = a().jdField_f_of_type_Int;
    long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
    boolean bool = h();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0)
    {
      VideoViewInfo localVideoViewInfo1 = new VideoViewInfo();
      VideoViewInfo localVideoViewInfo2 = new VideoViewInfo();
      localVideoViewInfo1.jdField_a_of_type_Long = l1;
      localVideoViewInfo1.jdField_a_of_type_Int = 1;
      localVideoViewInfo2.jdField_a_of_type_Long = l1;
      localVideoViewInfo2.jdField_a_of_type_Int = 2;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localVideoViewInfo2);
      localArrayList.add(localVideoViewInfo1);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(104), localArrayList });
      if (a().jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
    }
    for (;;)
    {
      a(l1, true, 0);
      a().jdField_f_of_type_Int = i1;
      a().jdField_z_of_type_Boolean = false;
      a().jdField_A_of_type_Boolean = false;
      a().jdField_B_of_type_Boolean = true;
      this.q = bool;
      if (paramBoolean)
      {
        p();
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_k_of_type_Int = 11;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().O = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(101) });
      }
      return;
      if (a().a(l2, 1) != -1) {
        a().a(true, false);
      }
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopVideoRecv() != 0)
      {
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaUtilArrayList.size() == 0) {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().a(false, true);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "StopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
    }
    return false;
  }
  
  public int g()
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetState();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 21)) {}
    while (a().jdField_b_of_type_Long != 0L) {
      return;
    }
    long l1 = a().jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startReachedRing, peer colorRingId=" + l1);
    }
    String str = ColorRingManager.a(l1, 3);
    if (new File(str).exists())
    {
      TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, str, -1, null);
      a().jdField_b_of_type_Boolean = true;
      int i1 = a().jdField_q_of_type_Int;
      ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + i1, l1 + "", "", "");
      return;
    }
    TraeHelper.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131165200, null, -1, null);
    a().jdField_b_of_type_Boolean = true;
  }
  
  public void g(int paramInt)
  {
    int i1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int;
    switch (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkProcessStatus: " + i1 + " -> " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int + " act: " + paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int == 0) {
        m();
      }
      return;
      if (paramInt == 0)
      {
        c(1);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int = 1;
        a(1, 3, 1600);
      }
      else if (paramInt == 4)
      {
        a(1);
        a(0);
        continue;
        if (paramInt == 4)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int = 2;
          c(2);
          a(1);
        }
        else if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int = 0;
          c(0);
        }
        else if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.jdField_d_of_type_Int = 0;
        }
      }
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRequestVideoMode fromUin = " + paramString);
    }
    a().G = 2;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(205), paramString });
  }
  
  public void g(String paramString, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.SetNetIPAndPort(paramString, paramInt);
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setNetIPAndPort(paramString, paramInt);
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "SetNetIPAndPort UnsatisfiedLinkError");
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat:" + paramBoolean + " # matchStatus = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int + " # chatType = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int + " # state = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().j + " # sessionId = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString);
    }
    if (o())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long), Boolean.valueOf(paramBoolean) });
      }
      SessionInfo localSessionInfo = a();
      if (paramBoolean)
      {
        a(this.jdField_E_of_type_Int, this.jdField_a_of_type_Long, 0, new int[0]);
        if (localSessionInfo != null)
        {
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_f_of_type_Boolean = false;
          localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 0;
          a(0, 0, null);
          localSessionInfo.c();
          localSessionInfo.d();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = false;
      }
      if (paramBoolean) {
        RandomController.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).c();
      }
      return;
      if ((n()) || (this.jdField_f_of_type_Boolean)) {
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3)
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(202), Long.valueOf(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_e_of_type_Long), Boolean.valueOf(paramBoolean) });
          }
        }
        else if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 2))
        {
          if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() > 0) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(204) });
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "destoryRandomChat: double");
          }
        }
      }
    }
  }
  
  public boolean g()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int h()
  {
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetLevel();
  }
  
  public void h() {}
  
  public void h(int paramInt)
  {
    if (this.jdField_i_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkProcessExitStatus act:" + paramInt);
          }
          if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl == null)
          {
            m();
            return;
          }
        } while (!this.jdField_a_of_type_ComTencentAvSessionMgr.b());
        if ((!this.jdField_e_of_type_Boolean) && (!this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) && (!this.jdField_f_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "is in room or is query member or in random match");
      return;
    } while (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isEngineActive());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "CheckEngineActive: engine is not Active");
    }
    g(paramInt);
  }
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAcceptVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(206), paramString });
  }
  
  public void h(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(41), paramString, Integer.valueOf(paramInt) });
  }
  
  public void h(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean h()
  {
    return this.q;
  }
  
  public int i()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      return this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getVideoAbilityLevel();
    }
    return -1;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendRequestBroadcast.");
    }
    if ((a().jdField_f_of_type_Int != 0) && (a().l != 1008)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(706) });
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.AudioVideoRequest");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
    try
    {
      if (a().l == 1008)
      {
        Thread.sleep(2000L);
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
    Thread.sleep(1000L);
  }
  
  public void i(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(39), Integer.valueOf(paramInt) });
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRejectVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(207), paramString });
  }
  
  public void i(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.upgradeInvite");
    localIntent.putExtra("peerUin", paramString);
    localIntent.putExtra("type", paramInt);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG setSelectMemberActivityIsResume selectMemberActivityIsResume = " + paramBoolean);
    }
    if (paramBoolean) {
      this.ap += 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG setSelectMemberActivityIsResume mSelectMemberActivityIsResume = " + this.ap);
      }
      return;
      this.ap -= 1;
      if (this.ap < 0) {
        this.ap = 0;
      }
    }
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentAvSessionMgr.b();
  }
  
  public int j()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  void j()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.av.v2q.MultiVideo");
    localIntent.putExtra("type", 405);
    localIntent.putExtra("phoneList", a().jdField_e_of_type_JavaUtilArrayList);
    localIntent.putExtra("relationType", a().jdField_F_of_type_Int);
    localIntent.putExtra("relationId", a().jdField_e_of_type_Long);
    localIntent.putExtra("sendUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    localIntent.putExtra("MultiAVType", a().jdField_D_of_type_Int);
    localIntent.putExtra("from", "VideoController1");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void j(int paramInt)
  {
    this.jdField_F_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(paramInt) });
  }
  
  public void j(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCancelVideoMode fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(208), paramString });
  }
  
  public void j(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBoolean);
  }
  
  public boolean j()
  {
    boolean bool2 = true;
    jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getSharedPreferences("com.tencent.qav.meeting." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 1).getLong("lastMeetingTime", 0L);
    boolean bool1 = bool2;
    if (jdField_g_of_type_Long != 0L)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() < jdField_g_of_type_Long + 60000L) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void k()
  {
    int i2 = 3;
    label117:
    label149:
    label168:
    label318:
    label355:
    label437:
    label690:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject2 = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
        if (!((SessionInfo)localObject2).jdField_a_of_type_Boolean) {
          break label318;
        }
        if (((SessionInfo)localObject2).d())
        {
          if ((((SessionInfo)localObject2).jdField_f_of_type_Int == 1) || (((SessionInfo)localObject2).jdField_f_of_type_Int == 2))
          {
            if ((!((SessionInfo)localObject2).jdField_K_of_type_Boolean) && (!((SessionInfo)localObject2).jdField_z_of_type_Boolean))
            {
              i1 = 56;
              if ((((SessionInfo)localObject2).l != 1011) && (!n())) {
                break label437;
              }
              i1 = ((SessionInfo)localObject2).jdField_f_of_type_Int;
              if ((i1 == 3) || (i1 == 1)) {
                break label690;
              }
              if (((SessionInfo)localObject2).jdField_F_of_type_Int != 7) {
                break label726;
              }
              i1 = i2;
              if (!o()) {
                break label355;
              }
              localObject3 = ((SessionInfo)localObject2).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.m;
              if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
                break label732;
              }
              i1 = 1;
              if (j() > 0) {
                break label745;
              }
              if (i1 == 0) {
                break label738;
              }
              i1 = 58;
              break;
              localQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, i1, ((SessionInfo)localObject2).l, 3);
              D();
              return;
            }
            i1 = 55;
            continue;
          }
          localObject3 = String.valueOf(((SessionInfo)localObject2).s);
          localObject4 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
          localObject2 = ((SessionInfo)localObject2).jdField_b_of_type_JavaLangString;
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject3, null, true, true);
          localQAVNotification.a((String)localObject2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, (String)localObject4, (String)localObject3), localBitmap, (String)localObject3, 57, 3000, 3);
          if (localBitmap != null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gff(this, (String)localObject3, (String)localObject4, (String)localObject2), 1000L);
          continue;
        }
        if (((SessionInfo)localObject2).jdField_f_of_type_Int != 1) {
          break label699;
        }
      }
      finally {}
      i1 = 47;
      break label696;
      if (((SessionInfo)localObject2).f())
      {
        if (((SessionInfo)localObject2).jdField_f_of_type_Int != 1) {
          break label709;
        }
        i1 = 47;
        break label706;
      }
      if (((SessionInfo)localObject2).jdField_f_of_type_Int != 1) {
        break label719;
      }
      i1 = 46;
      break label716;
      if (((SessionInfo)localObject2).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 4)
      {
        i2 = 52;
        if (this.jdField_f_of_type_Boolean)
        {
          i2 = 60;
          E();
        }
        ((QAVNotification)localObject1).a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, i2, ((SessionInfo)localObject2).l, i1);
      }
      else
      {
        ((QAVNotification)localObject1).a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, "", null, null, 51, ((SessionInfo)localObject2).l, i1);
        E();
        continue;
        if ((((SessionInfo)localObject2).jdField_f_of_type_Int == 3) || (((SessionInfo)localObject2).jdField_f_of_type_Int == 4))
        {
          if (((SessionInfo)localObject2).jdField_z_of_type_Boolean)
          {
            localObject3 = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, null, true, true);
            ((QAVNotification)localObject1).a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, ((SessionInfo)localObject2).s, 48, 0, ((SessionInfo)localObject2).jdField_f_of_type_Int);
          }
          else
          {
            localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().l, a().s, null);
            localObject4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).l, ((SessionInfo)localObject2).s, null, true, true);
            if (localObject4 != null) {
              ((QAVNotification)localObject1).a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, (String)localObject3, (Bitmap)localObject4, ((SessionInfo)localObject2).s, 44, ((SessionInfo)localObject2).l, ((SessionInfo)localObject2).jdField_f_of_type_Int);
            } else {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gel(this), 1000L);
            }
          }
        }
        else
        {
          if (((SessionInfo)localObject2).jdField_d_of_type_JavaLangString == null) {
            ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).l, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString);
          }
          localObject3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(((SessionInfo)localObject2).l, ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString, true, true);
          ((QAVNotification)localObject1).a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString, (Bitmap)localObject3, null, i1, ((SessionInfo)localObject2).l, ((SessionInfo)localObject2).jdField_f_of_type_Int);
        }
      }
    }
    for (;;)
    {
      break label168;
      for (;;)
      {
        label696:
        break;
        label699:
        i1 = 42;
      }
      for (;;)
      {
        label706:
        break;
        label709:
        i1 = 42;
      }
      for (;;)
      {
        label716:
        break;
        label719:
        i1 = 41;
      }
      label726:
      i1 = 1;
      break label117;
      label732:
      i1 = 0;
      break label149;
      label738:
      i1 = 53;
    }
    label745:
    if (i1 != 0) {}
    for (int i1 = 59;; i1 = 54) {
      break;
    }
  }
  
  public void k(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioOutputMode(paramInt);
    }
  }
  
  public void k(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onChannelReady: fromUin = " + paramString);
    }
    if ((this.jdField_a_of_type_Gfo != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
      this.jdField_a_of_type_Gfo = null;
    }
    if (1L == this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean) && (!n())) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      a(true, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
      if ((!this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_i_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l != 1011)
    {
      paramString = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper;
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    }
    w();
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 4;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_Boolean) && (!n()))
    {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
    }
    else
    {
      label335:
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().l == 1011))
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int = 5;
        a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int, 1, null);
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.e() <= 0) {
          break label670;
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(13) });
        if (n()) {
          a(2131165195, 1, null);
        }
      }
      label450:
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_Boolean) {
        break label677;
      }
      a(true, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      if ((!this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.isSharp()) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_i_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new gfa(this), 50L);
      }
      a(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int, true, true, true);
      DataReport.m(this);
      DataReport.e(this, true);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      DataReport.c(this, true);
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a())
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.b("DEVICE_SPEAKERPHONE");
        break label335;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      break label335;
      label670:
      k();
      break label450;
      label677:
      a(false, this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_c_of_type_JavaLangString);
    }
  }
  
  public boolean k()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      boolean bool1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        long l2 = System.currentTimeMillis();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          bool1 = bool2;
          if (localGAudioFriends.jdField_h_of_type_Boolean) {
            if ((localGAudioFriends.jdField_d_of_type_Long >= 2000L) && (localGAudioFriends.jdField_d_of_type_Long < this.jdField_d_of_type_Long))
            {
              l1 = localGAudioFriends.jdField_d_of_type_Long;
              bool1 = bool2;
              if (l2 - localGAudioFriends.jdField_c_of_type_Long > l1)
              {
                localGAudioFriends.jdField_h_of_type_Boolean = false;
                localGAudioFriends.jdField_c_of_type_Long = l2;
                bool2 = true;
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshUserNoiseState : has valid state uin = " + localGAudioFriends.jdField_a_of_type_Long + ",isSuspectNoisy = " + localGAudioFriends.jdField_h_of_type_Boolean);
                  bool1 = bool2;
                }
              }
            }
            else
            {
              if (this.jdField_d_of_type_Long < 2000L) {
                break label225;
              }
              l1 = this.jdField_d_of_type_Long;
              continue;
            }
          }
        }
        else
        {
          return bool2;
        }
      }
      i1 += 1;
      bool2 = bool1;
      continue;
      label225:
      long l1 = 2000L;
    }
  }
  
  public void l()
  {
    a(1);
    a(0);
  }
  
  public void l(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseVideo fromUin = " + paramString + ", remoteHasVideo = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean + ", isOnlyAudio = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean + ", isSupportSharpVideo = " + VcSystemInfo.d() + ", getGLVersion = " + Utils.a(BaseApplication.getContext()));
    }
    if ((!VcSystemInfo.d()) || (Utils.a(BaseApplication.getContext()) == 1)) {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean = false;
    }
    while ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 2) || (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean = false;
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 1;
      f(this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(15) });
    DataReport.r(this);
  }
  
  public boolean l()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    for (;;)
    {
      int i2;
      int i1;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
        i1 = 0;
        if (i1 < i2)
        {
          VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!localGAudioFriends.jdField_h_of_type_Boolean) {
            break label139;
          }
          if (l1 == localGAudioFriends.jdField_a_of_type_Long) {
            a(this.jdField_a_of_type_Long, false);
          } else {
            this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setMicByAdmin(localGAudioFriends.jdField_a_of_type_Long, true);
          }
        }
      }
      if (i1 != i2) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      label139:
      i1 += 1;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "exitProcess");
    }
    l();
    if (TraeHelper.a() != null) {
      TraeHelper.a().d();
    }
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.uninit();
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.uninit();
    }
    QAVNotification localQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    try
    {
      localQAVNotification.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo fromUin = " + paramString + ", remoteHasVideo = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean + ", isOnlyAudio = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean + ", isSupportSharpVideo = " + VcSystemInfo.d() + ", getGLVersion = " + Utils.a(BaseApplication.getContext()));
    }
    if ((!VcSystemInfo.d()) || (Utils.a(BaseApplication.getContext()) == 1))
    {
      if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int != 1) || (c())) {
        break label152;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeVideo !canAVShift()");
      }
    }
    label152:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16) });
      DataReport.q(this);
    } while (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
  }
  
  public boolean m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Go On Stage ");
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_F_of_type_Int == 2)
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startVideoSend() != 0) {
          break label147;
        }
      }
    }
    label147:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return false;
        if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_F_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_D_of_type_Int == 10)) {
          ReportController.b(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
        }
      }
      return true;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "goOnstage-->mGAudioCtrl is null");
    return false;
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateConfigInfo");
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.updateConfigInfo();
    }
  }
  
  public void n(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPauseAudio fromUin = " + paramString + ", remoteMute = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(17) });
    }
  }
  
  public boolean n()
  {
    return (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int < 6);
  }
  
  void o()
  {
    if (this.jdField_c_of_type_JavaLangRunnable == null)
    {
      this.jdField_c_of_type_JavaLangRunnable = new gen(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_c_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 20000L);
      }
    }
  }
  
  public void o(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResumeAudio fromUin = " + paramString + ", remoteMute = " + this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(18) });
    }
  }
  
  public boolean o()
  {
    boolean bool2 = false;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a();
    boolean bool1 = bool2;
    if (localSessionInfo != null)
    {
      bool1 = bool2;
      if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0)
      {
        bool1 = bool2;
        if (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  void p()
  {
    if (this.jdField_d_of_type_JavaLangRunnable == null) {
      this.jdField_d_of_type_JavaLangRunnable = new geo(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_d_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 5000L);
    }
  }
  
  public void p(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onApptypeNotSuit(): fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 5);
  }
  
  public boolean p()
  {
    return this.x;
  }
  
  void q()
  {
    if (this.jdField_e_of_type_JavaLangRunnable == null)
    {
      this.jdField_e_of_type_JavaLangRunnable = new gep(this);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_e_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 15000L);
      }
    }
  }
  
  public void q(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNetworkDisconnect fromUin = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20) });
  }
  
  public boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "WL_DEBUG getSelectMemberActivityIsResume mSelectMemberActivityIsResume = " + this.ap);
    }
    return this.ap > 0;
  }
  
  void r()
  {
    GraphicRenderMgr.getInstance().decoderPtrRef = 0;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setProcessDecoderFrameFunctionptr(0);
    }
  }
  
  public void r(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveAccept fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 7);
  }
  
  void s()
  {
    if (Build.VERSION.SDK_INT <= 7) {
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new geq(this);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      int i1 = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
      if ((i1 != 1) && (QLog.isColorLevel())) {
        QLog.d("AudioManager", 2, "request audio focus fail. " + i1);
      }
    }
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
  }
  
  public void s(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPeerSwitchTermianl fromUin = " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(33), paramString, Boolean.valueOf(true) });
    }
    this.jdField_a_of_type_ComTencentAvSessionMgr.a().ah = true;
  }
  
  void t()
  {
    if (Build.VERSION.SDK_INT <= 7) {}
    while (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
  }
  
  public void t(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAnotherHaveReject fromUin = " + paramString);
    }
    a(paramString, 0);
    c(paramString, 7);
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.ReceiveRequest");
        localIntent.putExtra("revVideoRequest", true);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      }
    }
  }
  
  public void u(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onConfigSysDealDone fromUin = " + paramString);
    }
  }
  
  void v()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 15000L);
    }
  }
  
  public void v(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getSharedPreferences(jdField_h_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 0);
    long l1 = ((SharedPreferences)localObject).getLong("reoldEngineC2CSwitch", 0L);
    String str = ((SharedPreferences)localObject).getString("reoldEngineC2CMsg", null);
    localObject = null;
    if (l1 == 0L) {
      if (TextUtils.isEmpty(str)) {
        break label205;
      }
    }
    label205:
    for (localObject = str;; localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, paramString, null) + a().getString(2131363287) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), null) + a().getString(2131363288))
    {
      a(0, paramString, null, null, (String)localObject, false);
      ReportController.b(null, "CliOper", "", "", "0X800560C", "0X800560C", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 2, "[reoldEngine] recv oldEngineNotSupportSharp req, send out prompt. disable(" + l1 + ") msg(" + str + ") peerUin(" + paramString + ") promptMsg(" + (String)localObject + ")");
      return;
    }
  }
  
  void w()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void w(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onNeedShowPeerVideo fromUin: " + paramString + ", peerUin: " + a().jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_h_of_type_Int == 1) && (!c())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "!canAVShift()");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 1) {
        f(2);
      }
      if (!this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(16) });
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(29) });
        DataReport.q(this);
        if (this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_f_of_type_Int = 2;
          this.jdField_a_of_type_ComTencentAvSessionMgr.a().jdField_K_of_type_Boolean = false;
        }
      }
    } while (a().jdField_c_of_type_JavaLangString.equals(paramString));
    GraphicRenderMgr.getInstance().onUinChanged(a().jdField_c_of_type_JavaLangString, paramString);
  }
  
  public void x()
  {
    if ((!VcSystemInfo.e()) || (!VcSystemInfo.f())) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = QQGAudioCtrl.getGAudioCtrlInstance();
        if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl == null)
        {
          m();
          return;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.SetVideoController(this);
        long l1 = CharacterUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        this.jdField_a_of_type_ComTencentAvVideoCallGAClientLogReport = new GAClientLogReport();
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAppid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.init(this.jdField_a_of_type_AndroidContentContext, l1, 1);
        int i2 = d();
        int i1 = i2;
        if (i2 > 13) {
          i1 = 0;
        }
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setApType(i1);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initGAudioCtrl-->can not init QQGAudioCtrl");
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      m();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
      localUnsatisfiedLinkError.printStackTrace();
      m();
    }
  }
  
  void x(String paramString)
  {
    if (this.jdField_a_of_type_Gfo != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Gfo);
    }
    this.jdField_a_of_type_Gfo = new gfo(this, paramString);
    if (this.jdField_a_of_type_Gfo != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Gfo, 6000L);
    }
  }
  
  public void y()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      long l1 = this.jdField_a_of_type_Long;
      a(this.jdField_E_of_type_Int, this.jdField_a_of_type_Long, 0, new int[] { a().jdField_D_of_type_Int });
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
    }
  }
  
  public void y(String paramString)
  {
    long l1 = b(paramString);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.AudioEngineReady");
      localIntent.putExtra("peerUin", paramString);
      localIntent.putExtra("roomId", l1);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(localIntent);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(36) });
    }
  }
  
  public void z()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(307) });
  }
  
  public void z(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(126), paramString });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\VideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */