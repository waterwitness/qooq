package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.activities.PrinterOptionActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevAudioMsgProcessor;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.voicechange.VoiceTuneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import nwz;
import nxe;
import nxf;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMsgChatPie
  extends BaseChatPie
{
  public static boolean N = false;
  public static ConcurrentHashMap a;
  static final String am = "devicemsg_showsupporttips_first";
  public static final String an = "devicemsg_openchat_firsttrue";
  public static final String ao = "devicemsg_showvideotips_first";
  public static final String aq = "device_groupchat";
  private static final String ar = "lock_red_dot_show";
  private static final String as = "ota_showupdatereddot";
  public static final int dQ = 1;
  public static final int dR = 2;
  public static final int dS = 3;
  public static final int dT = 4;
  public static final int dU = 5;
  public static final int dV = 6;
  public static final int dW = 7;
  public static final int dX = 8;
  public static final int dY = 9;
  public static final int dZ = 10;
  public static final int ea = 11;
  static final int ed = 1;
  static final int ee = 2;
  static final int ef = 3;
  static int eg = 100100;
  static int eh = 10;
  static int ei = 11;
  boolean J = false;
  public volatile boolean K;
  boolean L = false;
  boolean M = false;
  boolean O = false;
  boolean P = false;
  private boolean Q;
  BroadcastReceiver a;
  public Boolean a;
  final String al = DeviceMsgChatPie.class.getSimpleName();
  public String ap = "";
  public int dP;
  int eb = 0;
  int ec = 0;
  private ImageView j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  }
  
  public DeviceMsgChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new nxe(this);
  }
  
  public static void a(int paramInt, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramMessageRecord);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq == paramMessageRecord.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  boolean A()
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject1 = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportFuncMsgType(1))) {}
    }
    for (int i = 1;; i = 0)
    {
      long l = 0L;
      if (localObject1 != null) {
        l = ((DeviceInfo)localObject1).din;
      }
      for (int k = ((DeviceInfo)localObject1).productId;; k = 0)
      {
        if ((i == 0) && (this.eb != 4) && (this.eb != 3))
        {
          localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, k);
          return false;
        }
        return true;
      }
    }
  }
  
  protected void D()
  {
    super.D();
    if ((this.eb == 3) || (this.eb == 4))
    {
      if (!this.O) {
        this.O = true;
      }
    }
    else {
      return;
    }
    super.x();
  }
  
  protected void E()
  {
    PerformanceReportUtils.a();
    AIOUtils.a(false);
    this.h = false;
    this.jdField_j_of_type_Boolean = true;
    this.k = false;
    this.m = false;
    this.n = false;
    this.p = false;
    this.r = false;
    this.q = false;
    this.E = true;
    this.F = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.e = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
    }
  }
  
  public QQRecorder.RecorderParam a()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    localObject = new LightAppUtil().a((DeviceInfo)localObject);
    if ((localObject != null) && (((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007)) != null)) {}
    try
    {
      String str = (String)((LightAppSettingInfo)localObject).a.get(Integer.valueOf(11007));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      if (new JSONObject(((String)localObject).replace("&quot;", "\"")).optString("Audio", "").toLowerCase().equals("slk"))
      {
        localObject = new QQRecorder.RecorderParam(RecordParams.i, 16000, 1);
        return (QQRecorder.RecorderParam)localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.al, 2, "getString from json JSONException error:" + localJSONException.getMessage());
      }
      return new QQRecorder.RecorderParam(RecordParams.f, 0, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.al, 2, "getString from json Exception error:" + localException.getMessage());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(20);
  }
  
  /* Error */
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: iload_1
    //   8: iload_2
    //   9: aload_3
    //   10: invokespecial 442	com/tencent/mobileqq/activity/BaseChatPie:a	(IILandroid/content/Intent;)V
    //   13: bipush 84
    //   15: iload_1
    //   16: if_icmpne +124 -> 140
    //   19: aload_3
    //   20: ifnull +120 -> 140
    //   23: aload_3
    //   24: ldc_w 444
    //   27: invokevirtual 450	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   30: astore 4
    //   32: new 446	android/content/Intent
    //   35: dup
    //   36: aload_0
    //   37: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   40: ldc_w 455
    //   43: invokespecial 458	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   46: astore 5
    //   48: aload 5
    //   50: ldc_w 444
    //   53: aload 4
    //   55: invokevirtual 462	android/content/Intent:putParcelableArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   58: pop
    //   59: aload 5
    //   61: getstatic 466	com/tencent/mobileqq/utils/AlbumConstants:i	Ljava/lang/String;
    //   64: iload_1
    //   65: invokevirtual 470	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   68: pop
    //   69: aload 5
    //   71: ldc_w 472
    //   74: iconst_1
    //   75: invokevirtual 475	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   78: pop
    //   79: aload_0
    //   80: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   83: aload 5
    //   85: bipush 102
    //   87: invokevirtual 481	android/support/v4/app/FragmentActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   90: iload_1
    //   91: tableswitch	default:+25->116, 81:+802->893, 82:+25->116, 83:+870->961
    //   116: aload_0
    //   117: getfield 123	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:eb	I
    //   120: iconst_4
    //   121: if_icmpne +18 -> 139
    //   124: iload_2
    //   125: iconst_m1
    //   126: if_icmpne +13 -> 139
    //   129: iload_1
    //   130: iconst_1
    //   131: if_icmpne +8 -> 139
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 131	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:O	Z
    //   139: return
    //   140: iload_1
    //   141: bipush 102
    //   143: if_icmpne +232 -> 375
    //   146: iload_2
    //   147: iconst_m1
    //   148: if_icmpne -58 -> 90
    //   151: aload_3
    //   152: ifnull -62 -> 90
    //   155: aload_0
    //   156: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: bipush 51
    //   161: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   164: checkcast 200	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   167: aload_0
    //   168: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   171: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: invokestatic 213	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: invokevirtual 485	com/tencent/device/devicemgr/SmartDeviceProxyMgr:g	(J)Z
    //   180: ifne +21 -> 201
    //   183: aload_0
    //   184: getfield 488	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   187: ldc_w 490
    //   190: sipush 2000
    //   193: invokestatic 495	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   196: invokevirtual 498	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   199: pop
    //   200: return
    //   201: aload_3
    //   202: ldc_w 444
    //   205: invokevirtual 450	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   208: astore 5
    //   210: aload 5
    //   212: ifnull -122 -> 90
    //   215: aload 5
    //   217: invokevirtual 504	java/util/ArrayList:size	()I
    //   220: ifle -130 -> 90
    //   223: new 500	java/util/ArrayList
    //   226: dup
    //   227: invokespecial 505	java/util/ArrayList:<init>	()V
    //   230: astore 4
    //   232: aload 5
    //   234: invokevirtual 506	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   237: astore 5
    //   239: aload 5
    //   241: invokeinterface 175 1 0
    //   246: ifeq +25 -> 271
    //   249: aload 4
    //   251: aload 5
    //   253: invokeinterface 179 1 0
    //   258: checkcast 508	com/tencent/mobileqq/filemanager/data/FileInfo
    //   261: invokevirtual 510	com/tencent/mobileqq/filemanager/data/FileInfo:d	()Ljava/lang/String;
    //   264: invokevirtual 513	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   267: pop
    //   268: goto -29 -> 239
    //   271: aload_3
    //   272: ldc_w 515
    //   275: invokevirtual 519	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 5
    //   280: aload_0
    //   281: getfield 488	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   284: invokestatic 524	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)Z
    //   287: ifne +77 -> 364
    //   290: aload_0
    //   291: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   294: sipush 230
    //   297: aload_0
    //   298: getfield 488	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   301: ldc_w 525
    //   304: invokevirtual 531	android/content/Context:getString	(I)Ljava/lang/String;
    //   307: aload_0
    //   308: getfield 488	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   311: ldc_w 532
    //   314: invokevirtual 531	android/content/Context:getString	(I)Ljava/lang/String;
    //   317: ldc_w 534
    //   320: ldc_w 536
    //   323: new 538	nxa
    //   326: dup
    //   327: aload_0
    //   328: aload 4
    //   330: aload 5
    //   332: invokespecial 541	nxa:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;Ljava/util/ArrayList;Ljava/lang/String;)V
    //   335: new 543	nxb
    //   338: dup
    //   339: aload_0
    //   340: invokespecial 544	nxb:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;)V
    //   343: invokestatic 549	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   346: astore 4
    //   348: aload 4
    //   350: invokevirtual 554	com/tencent/mobileqq/utils/QQCustomDialog:isShowing	()Z
    //   353: ifne -263 -> 90
    //   356: aload 4
    //   358: invokevirtual 557	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   361: goto -271 -> 90
    //   364: aload_0
    //   365: aload 4
    //   367: aload 5
    //   369: invokevirtual 560	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   372: goto -282 -> 90
    //   375: bipush 81
    //   377: iload_1
    //   378: if_icmpeq +9 -> 387
    //   381: bipush 83
    //   383: iload_1
    //   384: if_icmpne +429 -> 813
    //   387: aload_0
    //   388: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   391: bipush 51
    //   393: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   396: checkcast 200	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   399: astore 6
    //   401: aload 6
    //   403: aload_0
    //   404: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   407: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   410: invokestatic 213	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   413: invokevirtual 216	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   416: astore 4
    //   418: aload 4
    //   420: ifnull +820 -> 1240
    //   423: aload 6
    //   425: aload 4
    //   427: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   430: invokevirtual 224	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(I)Lcom/tencent/device/datadef/ProductInfo;
    //   433: astore 6
    //   435: aload 6
    //   437: ifnull +803 -> 1240
    //   440: aload 6
    //   442: iconst_2
    //   443: invokevirtual 230	com/tencent/device/datadef/ProductInfo:isSupportFuncMsgType	(I)Z
    //   446: ifeq +794 -> 1240
    //   449: iconst_1
    //   450: istore 9
    //   452: lconst_0
    //   453: lstore 11
    //   455: aload 4
    //   457: ifnull +777 -> 1234
    //   460: aload 4
    //   462: getfield 233	com/tencent/device/datadef/DeviceInfo:din	J
    //   465: lstore 11
    //   467: aload 4
    //   469: getfield 221	com/tencent/device/datadef/DeviceInfo:productId	I
    //   472: istore 10
    //   474: iload 9
    //   476: ifne +33 -> 509
    //   479: aload_0
    //   480: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   483: bipush 49
    //   485: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   488: checkcast 235	com/tencent/device/msg/data/DeviceMsgHandle
    //   491: astore_3
    //   492: aload_0
    //   493: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: lload 11
    //   498: ldc -19
    //   500: bipush 7
    //   502: iconst_0
    //   503: iload 10
    //   505: invokestatic 242	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;JLjava/lang/String;III)V
    //   508: return
    //   509: aload_0
    //   510: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   513: aload_0
    //   514: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   517: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   520: aconst_null
    //   521: ldc 19
    //   523: iconst_1
    //   524: invokestatic 566	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   527: istore 13
    //   529: getstatic 568	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:N	Z
    //   532: ifeq +57 -> 589
    //   535: iload 13
    //   537: ifeq +52 -> 589
    //   540: aload_0
    //   541: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: bipush 49
    //   546: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   549: checkcast 235	com/tencent/device/msg/data/DeviceMsgHandle
    //   552: aload_0
    //   553: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   556: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   559: ldc_w 570
    //   562: invokestatic 575	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   565: iconst_1
    //   566: iconst_0
    //   567: iconst_1
    //   568: invokevirtual 578	com/tencent/device/msg/data/DeviceMsgHandle:a	(Ljava/lang/String;Ljava/lang/String;JZZZ)V
    //   571: aload_0
    //   572: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   575: aload_0
    //   576: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   579: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   582: aconst_null
    //   583: ldc 19
    //   585: iconst_0
    //   586: invokestatic 582	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   589: getstatic 587	android/os/Build$VERSION:SDK_INT	I
    //   592: bipush 10
    //   594: if_icmpgt -504 -> 90
    //   597: aload_0
    //   598: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   601: invokevirtual 591	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   604: aload_3
    //   605: invokevirtual 595	android/content/Intent:getData	()Landroid/net/Uri;
    //   608: ldc_w 596
    //   611: invokevirtual 602	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   614: astore 4
    //   616: aload 4
    //   618: ifnull +135 -> 753
    //   621: aload 4
    //   623: invokevirtual 608	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   626: astore 4
    //   628: new 610	java/io/FileOutputStream
    //   631: dup
    //   632: new 612	java/io/File
    //   635: dup
    //   636: aload_0
    //   637: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   640: invokevirtual 616	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   643: invokestatic 622	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   646: ldc_w 624
    //   649: ldc 111
    //   651: invokeinterface 628 3 0
    //   656: invokespecial 629	java/io/File:<init>	(Ljava/lang/String;)V
    //   659: invokespecial 632	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   662: astore 6
    //   664: sipush 1024
    //   667: newarray <illegal type>
    //   669: astore 8
    //   671: aload 4
    //   673: aload 8
    //   675: invokevirtual 638	java/io/FileInputStream:read	([B)I
    //   678: istore 9
    //   680: aload 6
    //   682: astore 7
    //   684: aload 4
    //   686: astore 5
    //   688: iload 9
    //   690: ifle +69 -> 759
    //   693: aload 6
    //   695: aload 8
    //   697: iconst_0
    //   698: iload 9
    //   700: invokevirtual 642	java/io/FileOutputStream:write	([BII)V
    //   703: goto -32 -> 671
    //   706: astore 7
    //   708: aload 4
    //   710: astore 5
    //   712: aload 6
    //   714: astore 4
    //   716: aload 7
    //   718: astore 6
    //   720: aload 6
    //   722: invokevirtual 645	java/lang/Exception:printStackTrace	()V
    //   725: aload 5
    //   727: ifnull +8 -> 735
    //   730: aload 5
    //   732: invokevirtual 648	java/io/FileInputStream:close	()V
    //   735: aload 4
    //   737: ifnull -647 -> 90
    //   740: aload 4
    //   742: invokevirtual 649	java/io/FileOutputStream:close	()V
    //   745: goto -655 -> 90
    //   748: astore 4
    //   750: goto -660 -> 90
    //   753: aconst_null
    //   754: astore 7
    //   756: aconst_null
    //   757: astore 5
    //   759: aload 5
    //   761: ifnull +8 -> 769
    //   764: aload 5
    //   766: invokevirtual 648	java/io/FileInputStream:close	()V
    //   769: aload 7
    //   771: ifnull -681 -> 90
    //   774: aload 7
    //   776: invokevirtual 649	java/io/FileOutputStream:close	()V
    //   779: goto -689 -> 90
    //   782: astore 4
    //   784: goto -694 -> 90
    //   787: astore_3
    //   788: aconst_null
    //   789: astore 4
    //   791: aload 4
    //   793: ifnull +8 -> 801
    //   796: aload 4
    //   798: invokevirtual 648	java/io/FileInputStream:close	()V
    //   801: aload 5
    //   803: ifnull +8 -> 811
    //   806: aload 5
    //   808: invokevirtual 649	java/io/FileOutputStream:close	()V
    //   811: aload_3
    //   812: athrow
    //   813: iload_1
    //   814: getstatic 91	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:eg	I
    //   817: if_icmpne -727 -> 90
    //   820: iload_2
    //   821: getstatic 93	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:eh	I
    //   824: if_icmpne +54 -> 878
    //   827: aload_0
    //   828: invokevirtual 650	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:x	()V
    //   831: aload_0
    //   832: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   835: bipush 51
    //   837: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   840: checkcast 200	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   843: aload_0
    //   844: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   847: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   850: invokestatic 213	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   853: invokevirtual 216	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   856: invokestatic 655	com/tencent/device/utils/SmartDeviceUtil:a	(Lcom/tencent/device/datadef/DeviceInfo;)Ljava/lang/String;
    //   859: astore 4
    //   861: aload 4
    //   863: ifnull -773 -> 90
    //   866: aload_0
    //   867: getfield 657	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   870: aload 4
    //   872: invokevirtual 663	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   875: goto -785 -> 90
    //   878: iload_2
    //   879: getstatic 95	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ei	I
    //   882: if_icmpne -51 -> 831
    //   885: aload_0
    //   886: iconst_1
    //   887: putfield 157	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:Q	Z
    //   890: goto -59 -> 831
    //   893: iload_2
    //   894: iconst_m1
    //   895: if_icmpne -779 -> 116
    //   898: aload_3
    //   899: ifnull -783 -> 116
    //   902: aload_3
    //   903: ldc_w 665
    //   906: invokevirtual 450	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   909: astore_3
    //   910: aload_3
    //   911: ifnull -795 -> 116
    //   914: aload_3
    //   915: invokevirtual 504	java/util/ArrayList:size	()I
    //   918: ifle -802 -> 116
    //   921: aload_0
    //   922: aload_3
    //   923: iconst_0
    //   924: invokevirtual 668	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   927: checkcast 670	com/dataline/util/file/SendInfo
    //   930: invokevirtual 672	com/dataline/util/file/SendInfo:a	()Ljava/lang/String;
    //   933: putfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   936: aload_0
    //   937: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   940: aload_0
    //   941: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   944: aload_0
    //   945: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   948: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   951: aload_0
    //   952: getfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   955: invokestatic 677	com/tencent/device/file/DevVideoMsgProcessor:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   958: goto -842 -> 116
    //   961: aload_0
    //   962: aload_0
    //   963: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   966: invokevirtual 616	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   969: invokestatic 622	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   972: ldc_w 624
    //   975: ldc 111
    //   977: invokeinterface 628 3 0
    //   982: putfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   985: aload_0
    //   986: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   989: invokevirtual 616	android/support/v4/app/FragmentActivity:getApplicationContext	()Landroid/content/Context;
    //   992: invokestatic 622	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   995: invokeinterface 681 1 0
    //   1000: ldc_w 624
    //   1003: invokeinterface 687 2 0
    //   1008: invokeinterface 690 1 0
    //   1013: pop
    //   1014: iload_2
    //   1015: iconst_m1
    //   1016: if_icmpne +130 -> 1146
    //   1019: aload_0
    //   1020: getfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   1023: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1026: ifne -910 -> 116
    //   1029: aload_0
    //   1030: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   1033: sipush 230
    //   1036: invokestatic 693	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1039: astore_3
    //   1040: aload_3
    //   1041: ldc_w 694
    //   1044: new 696	nxc
    //   1047: dup
    //   1048: aload_0
    //   1049: invokespecial 697	nxc:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;)V
    //   1052: invokevirtual 701	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1055: pop
    //   1056: aload_3
    //   1057: ldc_w 702
    //   1060: new 704	nxd
    //   1063: dup
    //   1064: aload_0
    //   1065: invokespecial 705	nxd:<init>	(Lcom/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie;)V
    //   1068: invokevirtual 708	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1071: pop
    //   1072: aload_3
    //   1073: ldc_w 710
    //   1076: invokevirtual 714	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1079: pop
    //   1080: new 612	java/io/File
    //   1083: dup
    //   1084: aload_0
    //   1085: getfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   1088: invokespecial 629	java/io/File:<init>	(Ljava/lang/String;)V
    //   1091: astore 4
    //   1093: aload_0
    //   1094: getfield 453	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   1097: aload 4
    //   1099: invokevirtual 717	java/io/File:length	()J
    //   1102: invokestatic 722	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;J)Ljava/lang/String;
    //   1105: astore 4
    //   1107: aload_3
    //   1108: new 406	java/lang/StringBuilder
    //   1111: dup
    //   1112: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   1115: ldc_w 724
    //   1118: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload 4
    //   1123: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: ldc_w 726
    //   1129: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 419	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokevirtual 730	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1138: pop
    //   1139: aload_3
    //   1140: invokevirtual 557	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1143: goto -1027 -> 116
    //   1146: aload_0
    //   1147: getfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   1150: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1153: ifne +11 -> 1164
    //   1156: aload_0
    //   1157: getfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   1160: invokestatic 735	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1163: pop
    //   1164: aload_0
    //   1165: ldc 111
    //   1167: putfield 113	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:ap	Ljava/lang/String;
    //   1170: goto -1054 -> 116
    //   1173: astore 4
    //   1175: goto -364 -> 811
    //   1178: astore_3
    //   1179: goto -388 -> 791
    //   1182: astore_3
    //   1183: aload 6
    //   1185: astore 5
    //   1187: goto -396 -> 791
    //   1190: astore_3
    //   1191: aload 4
    //   1193: astore 6
    //   1195: aload 5
    //   1197: astore 4
    //   1199: aload 6
    //   1201: astore 5
    //   1203: goto -412 -> 791
    //   1206: astore 6
    //   1208: aconst_null
    //   1209: astore 4
    //   1211: aload 7
    //   1213: astore 5
    //   1215: goto -495 -> 720
    //   1218: astore 6
    //   1220: aconst_null
    //   1221: astore 7
    //   1223: aload 4
    //   1225: astore 5
    //   1227: aload 7
    //   1229: astore 4
    //   1231: goto -511 -> 720
    //   1234: iconst_0
    //   1235: istore 10
    //   1237: goto -763 -> 474
    //   1240: iconst_0
    //   1241: istore 9
    //   1243: goto -791 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1246	0	this	DeviceMsgChatPie
    //   0	1246	1	paramInt1	int
    //   0	1246	2	paramInt2	int
    //   0	1246	3	paramIntent	Intent
    //   30	711	4	localObject1	Object
    //   748	1	4	localException1	Exception
    //   782	1	4	localException2	Exception
    //   789	333	4	localObject2	Object
    //   1173	19	4	localException3	Exception
    //   1197	33	4	localObject3	Object
    //   1	1225	5	localObject4	Object
    //   399	801	6	localObject5	Object
    //   1206	1	6	localException4	Exception
    //   1218	1	6	localException5	Exception
    //   4	679	7	localObject6	Object
    //   706	11	7	localException6	Exception
    //   754	474	7	localObject7	Object
    //   669	27	8	arrayOfByte	byte[]
    //   450	792	9	i	int
    //   472	764	10	k	int
    //   453	44	11	l	long
    //   527	9	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   664	671	706	java/lang/Exception
    //   671	680	706	java/lang/Exception
    //   693	703	706	java/lang/Exception
    //   730	735	748	java/lang/Exception
    //   740	745	748	java/lang/Exception
    //   764	769	782	java/lang/Exception
    //   774	779	782	java/lang/Exception
    //   597	616	787	finally
    //   621	628	787	finally
    //   796	801	1173	java/lang/Exception
    //   806	811	1173	java/lang/Exception
    //   628	664	1178	finally
    //   664	671	1182	finally
    //   671	680	1182	finally
    //   693	703	1182	finally
    //   720	725	1190	finally
    //   597	616	1206	java/lang/Exception
    //   621	628	1206	java/lang/Exception
    //   628	664	1218	java/lang/Exception
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    if (i == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        super.a(paramObject);
        return;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        continue;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        if (p())
        {
          p(2);
          continue;
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          Object localObject = new FileManagerReporter.fileAssistantReportData();
          ((FileManagerReporter.fileAssistantReportData)localObject).b = "send_file";
          ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
          FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
          localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
          long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).d(l)) && (((SmartDeviceProxyMgr)localObject).a(l, 17))) {
            PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          } else {
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
    } while (!this.P);
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, null);
  }
  
  public void a(String paramString)
  {
    if (this.J) {
      super.a(paramString);
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if (!this.J) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label290;
      }
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label33:
      if (new File(paramString).exists()) {
        break label510;
      }
      paramInt1 = 0;
      paramRecorderParam = paramString;
      label53:
      if (paramInt1 < VoiceTuneUtil.jdField_a_of_type_Int)
      {
        paramRecorderParam = VoiceTuneUtil.a(paramString, paramInt1);
        if (!new File(paramRecorderParam).exists()) {
          break label298;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramRecorderParam);
      }
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = null;
      paramString = localSmartDeviceProxyMgr;
      if (!TextUtils.isEmpty(paramRecorderParam))
      {
        paramString = localSmartDeviceProxyMgr;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
          if (paramLong == 0L) {
            break label307;
          }
        }
      }
      label290:
      label298:
      label307:
      for (paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);; paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L))
      {
        if (paramString == null) {
          break label342;
        }
        super.a(0, paramRecorderParam, paramString.uniseq);
        if ((!N) || (!this.M)) {
          break label457;
        }
        if ((NetworkUtil.e(BaseApplication.getContext())) || (!(paramString instanceof MessageForDevPtt))) {
          break label344;
        }
        paramString = (MessageForDevPtt)paramString;
        paramString.fileSize = -1L;
        paramString.extraflag = 32768;
        paramString.extStr = "device_groupchat";
        paramString.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
        return;
        paramInt1 = 0;
        break;
        PttBuffer.b(paramString);
        break label33;
        paramInt1 += 1;
        break label53;
      }
      label342:
      break;
      label344:
      localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramInt1 = localSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramRecorderParam, QQRecorder.a(paramInt2));
      if ((paramString instanceof MessageForDevPtt)) {
        ((MessageForDevPtt)paramString).voiceLength = QQRecorder.a(paramInt2);
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), paramString);
      paramString = localSmartDeviceProxyMgr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (paramString == null) {
        break;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
      return;
      label457:
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(DeviceMsgHandle.f, paramRecorderParam, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramString.uniseq, paramString.istroop, QQRecorder.a(paramInt2));
      paramLong = paramString.uniseq;
      return;
      label510:
      paramRecorderParam = paramString;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Object localObject1 = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localObject1 != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportMainMsgType(2))) {}
    }
    for (boolean bool = true;; bool = false)
    {
      long l = 0L;
      int i = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        i = ((DeviceInfo)localObject1).productId;
      }
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 1, 0, i);
      this.J = bool;
      if (!bool)
      {
        paramString = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.al, 2, "onRecorderPerpare path = " + paramString);
      }
      localObject1 = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
      {
        i = 1;
        label203:
        if (i != 0) {
          break label274;
        }
        StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
        StreamDataManager.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
        label241:
        if (paramString == null) {
          break label290;
        }
        if (paramBoolean) {
          break label292;
        }
        this.jdField_c_of_type_Long = 0L;
        g(2131165202);
      }
      for (;;)
      {
        a(true, false);
        return;
        i = 0;
        break label203;
        label274:
        PttBuffer.a(paramString);
        PttBuffer.a(paramString, (byte[])localObject1, localObject1.length);
        break label241;
        label290:
        break;
        label292:
        paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_c_of_type_Long = paramString.uniseq;
        }
        g(2131165193);
      }
    }
  }
  
  /* Error */
  public void a(ArrayList paramArrayList, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: new 363	org/json/JSONObject
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 374	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 961
    //   16: iconst_1
    //   17: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   20: istore_3
    //   21: aload_2
    //   22: ldc_w 967
    //   25: iconst_1
    //   26: invokevirtual 965	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   29: istore 5
    //   31: aload_0
    //   32: getfield 193	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: bipush 49
    //   37: invokevirtual 198	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   40: checkcast 235	com/tencent/device/msg/data/DeviceMsgHandle
    //   43: invokevirtual 970	com/tencent/device/msg/data/DeviceMsgHandle:a	()Lcom/tencent/device/msg/data/DeviceComnFileMsgProcessor;
    //   46: getstatic 972	com/tencent/device/msg/data/DeviceMsgHandle:c	Ljava/lang/String;
    //   49: aload_0
    //   50: getfield 203	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   53: getfield 207	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_1
    //   57: iload_3
    //   58: iload 5
    //   60: invokevirtual 977	com/tencent/device/msg/data/DeviceComnFileMsgProcessor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)V
    //   63: return
    //   64: astore_2
    //   65: iconst_1
    //   66: istore 4
    //   68: iload 4
    //   70: istore_3
    //   71: iload 6
    //   73: istore 5
    //   75: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq -47 -> 31
    //   81: aload_0
    //   82: getfield 107	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:al	Ljava/lang/String;
    //   85: iconst_2
    //   86: new 406	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 409
    //   96: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: invokevirtual 416	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 419	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: iload 4
    //   114: istore_3
    //   115: iload 6
    //   117: istore 5
    //   119: goto -88 -> 31
    //   122: astore_2
    //   123: iconst_1
    //   124: istore 4
    //   126: iload 4
    //   128: istore_3
    //   129: iload 6
    //   131: istore 5
    //   133: invokestatic 404	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq -105 -> 31
    //   139: aload_0
    //   140: getfield 107	com/tencent/mobileqq/activity/aio/rebuild/DeviceMsgChatPie:al	Ljava/lang/String;
    //   143: iconst_2
    //   144: new 406	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 428
    //   154: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_2
    //   158: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 419	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 423	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 4
    //   172: istore_3
    //   173: iload 6
    //   175: istore 5
    //   177: goto -146 -> 31
    //   180: astore_2
    //   181: iload_3
    //   182: istore 4
    //   184: goto -58 -> 126
    //   187: astore_2
    //   188: iload_3
    //   189: istore 4
    //   191: goto -123 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	DeviceMsgChatPie
    //   0	194	1	paramArrayList	ArrayList
    //   0	194	2	paramString	String
    //   20	169	3	i	int
    //   66	124	4	k	int
    //   29	147	5	m	int
    //   1	173	6	n	int
    // Exception table:
    //   from	to	target	type
    //   3	21	64	org/json/JSONException
    //   3	21	122	java/lang/Exception
    //   21	31	180	java/lang/Exception
    //   21	31	187	org/json/JSONException
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.C = false;
    this.F = false;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      super.x();
    }
    do
    {
      return true;
      super.a(paramBoolean);
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    Object localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    ((DeviceMsgHandle)localObject1).a().a();
    ((DeviceMsgHandle)localObject1).a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
    if (VersionUtils.e()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
    }
    aC();
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("SmartDevice_DeviceUnBindRst");
    ((IntentFilter)localObject1).addAction("SmartDevice_ProductFetchRst");
    ((IntentFilter)localObject1).addAction("SmartDevice_receiveVasFlagResult");
    ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgProgress");
    ((IntentFilter)localObject1).addAction("SmartDevice_OnDataPointFileMsgSendRet");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
    this.K = true;
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(((Bundle)localObject1).getBoolean("bFromLightApp", false));
      this.eb = ((Bundle)localObject1).getInt("operType", 0);
      this.ec = ((Bundle)localObject1).getInt("jumpTab", 0);
    }
    localObject1 = (ImageView)this.d.findViewById(2131297392);
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageResource(2130838433);
    }
    for (localObject1 = (RelativeLayout)((ImageView)localObject1).getParent();; localObject1 = null)
    {
      Object localObject2 = (ImageView)this.d.findViewById(2131297404);
      if (localObject2 != null)
      {
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130838432);
        ((ImageView)localObject2).setOnClickListener(new nwz(this));
      }
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((((SmartDeviceProxyMgr)localObject2).d(l)) && (((SmartDeviceProxyMgr)localObject2).a(l, 17)))
      {
        paramBoolean = true;
        this.P = paramBoolean;
        if (this.P) {
          ((SmartDeviceProxyMgr)localObject2).a(l, "", "", "", 0, 1, 1);
        }
        paramBoolean = BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).getBoolean("ota_showupdatereddot", true);
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0);
        if ((EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.a()) == 0) || (localSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false))) {
          break label572;
        }
      }
      label572:
      for (int i = 1;; i = 0)
      {
        if (((!paramBoolean) || (!((SmartDeviceProxyMgr)localObject2).f(l))) && (i == 0)) {
          break label576;
        }
        this.jdField_j_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131297392);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131297392);
        if (localObject1 != null)
        {
          ((RelativeLayout)localObject1).addView(this.jdField_j_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
          this.jdField_j_of_type_AndroidWidgetImageView.setImageResource(2130843322);
        }
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(0);
        return true;
        paramBoolean = false;
        break;
      }
      label576:
      break;
    }
  }
  
  public void aC()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    Object localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    ProductInfo localProductInfo;
    if (localDeviceInfo != null)
    {
      localProductInfo = ((SmartDeviceProxyMgr)localObject1).a(localDeviceInfo.productId);
      if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(4)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.dP = localDeviceInfo.productId;
    }
    for (;;)
    {
      N = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
      boolean bool1 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", true);
      boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
      if (localProductInfo != null)
      {
        if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
          this.L = true;
        }
        if ((!bool2) && ((localDeviceInfo.SSOBid_Platform == 1027) || ((!StringUtil.b(localDeviceInfo.SSOBid_Version)) && (Double.valueOf(localDeviceInfo.SSOBid_Version).doubleValue() >= 1.1D))))
        {
          this.M = true;
          SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
        }
      }
      else
      {
        if ((this.L) && (this.M) && (localDeviceInfo != null)) {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localDeviceInfo.din, "Usr_AIO_SupportGroupChat", 0, 0, localDeviceInfo.productId);
        }
        if ((localProductInfo != null) && (bool1))
        {
          if ((localProductInfo.supportMainMsgType & 0xF) != 0) {
            break label543;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371961);
          label366:
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            if ((this.L) && (localDeviceInfo.isAdmin == 1) && (this.M) && (!N))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371987);
              ((DeviceMsgHandle)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject2, MessageCache.a(), true, false, true);
            }
            SettingCloneUtil.writeValue(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_showsupporttips_first", false);
          }
        }
        if (QLog.isColorLevel())
        {
          if (localProductInfo == null) {
            break label851;
          }
          QLog.d(this.al, 2, "support msg type maintype" + localProductInfo.supportMainMsgType + ", FuncMsgType:" + localProductInfo.supportFuncMsgType);
        }
      }
      for (;;)
      {
        aD();
        return;
        if ((!bool2) && (!N)) {
          break;
        }
        this.M = true;
        break;
        label543:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371962);
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(1)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371955) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportMainMsgType(2)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371956) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportMainMsgType(8)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371959) + "、";
        }
        localObject2 = localObject1;
        if (localProductInfo.isSupportFuncMsgType(1)) {
          localObject2 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371957) + "、";
        }
        localObject1 = localObject2;
        if (localProductInfo.isSupportFuncMsgType(2)) {
          localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371958) + "、";
        }
        localObject2 = localObject1;
        if (((String)localObject1).endsWith("、")) {
          localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localObject1 = (String)localObject2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131371963);
        break label366;
        label851:
        QLog.d(this.al, 2, "product is null");
      }
      localProductInfo = null;
    }
  }
  
  void aD()
  {
    int i = (int)(6.0F * this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics().density);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null) {}
    for (localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);; localObject = null)
    {
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) != 0) {
          break label122;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
      }
      for (;;)
      {
        if (!((ProductInfo)localObject).isSupportMainMsgType(1)) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        return;
        label122:
        if (((ProductInfo)localObject).isSupportMainMsgType(15))
        {
          if ((((ProductInfo)localObject).isSupportFuncMsgType(3)) || (((ProductInfo)localObject).isSupportFuncMsgType(1)) || (!((ProductInfo)localObject).isSupportFuncMsgType(2))) {}
        }
        else if (((ProductInfo)localObject).isSupportMainMsgType(8))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
          if (VersionUtils.e()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
          }
          localLayoutParams.leftMargin = i;
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
        }
        else if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
          if (VersionUtils.e()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
          }
          localLayoutParams.leftMargin = i;
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
        }
        else if (((ProductInfo)localObject).isSupportMainMsgType(1))
        {
          if (((ProductInfo)localObject).isSupportFuncMsgType(3))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
            if (VersionUtils.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            localLayoutParams.leftMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
          }
        }
        else if (((ProductInfo)localObject).isSupportMainMsgType(2))
        {
          if (((ProductInfo)localObject).isSupportFuncMsgType(3))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          else
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
            if (VersionUtils.e()) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
            }
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
          if (VersionUtils.e()) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
          }
          if (((ProductInfo)localObject).isSupportFuncMsgType(3))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(1))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          else if (((ProductInfo)localObject).isSupportFuncMsgType(2))
          {
            localLayoutParams.rightMargin = i;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131371209));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131427351));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setGravity(17);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(false);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    DeviceMsgHandle localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    if ((N) && (this.M))
    {
      localDeviceMsgHandle.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
      paramList = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList.din, "Usr_AIO_SendGroupMsg", 3, 0, paramList.productId);
      return;
    }
    localDeviceMsgHandle.a().a(DeviceMsgHandle.d, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
  }
  
  public boolean b(int paramInt)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localSmartDeviceProxyMgr != null)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (localSmartDeviceProxyMgr.a(l1, paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    boolean bool = true;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      PicPreDownloadUtils.a((String)localObject1);
      if ((localObject1 != null) && (((String)localObject1).length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131367627, 1);
        return;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      Object localObject3 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      Object localObject2 = ((SmartDeviceProxyMgr)localObject3).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject2 != null)
      {
        localObject3 = ((SmartDeviceProxyMgr)localObject3).a(((DeviceInfo)localObject2).productId);
        if ((localObject3 == null) || (!((ProductInfo)localObject3).isSupportMainMsgType(1))) {}
      }
      for (int i = 1;; i = 0)
      {
        long l = 0L;
        if (localObject2 != null) {
          l = ((DeviceInfo)localObject2).din;
        }
        for (int k = ((DeviceInfo)localObject2).productId;; k = 0)
        {
          if (i == 0)
          {
            localObject1 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, k);
            return;
          }
          localObject2 = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
          SessionInfo localSessionInfo;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if ((!N) || (!this.M)) {
              break label249;
            }
          }
          for (;;)
          {
            ((DeviceMsgHandle)localObject2).a((QQAppInterface)localObject3, localSessionInfo, (String)localObject1, bool);
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 6, 0, k);
            return;
            label249:
            bool = false;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public void c(List paramList)
  {
    Intent localIntent = new Intent();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", str);
        localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        PicReq localPicReq1 = PicBusiManager.a(2, 1007);
        PicBusiManager.a(1007, localIntent);
        PicReq localPicReq2 = PicBusiManager.a(1, 1007);
        localPicReq2.a(localPicReq1.jdField_a_of_type_JavaLangString);
        if (localPicReq2.a(PicBusiManager.a(1007, localIntent)))
        {
          localPicReq2.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack = new nxf(this);
          PicBusiManager.a(localPicReq2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        else
        {
          d(str);
        }
      }
    }
  }
  
  protected boolean c()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 6)) {
        return true;
      }
    }
    return false;
  }
  
  public void d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    b(localArrayList);
  }
  
  protected boolean d()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if (localObject != null)
      {
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 1) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 1)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 2)) {
          return true;
        }
        if (((((ProductInfo)localObject).supportMainMsgType & 0xF) == 5) && (((ProductInfo)localObject).supportFuncMsgType == 3)) {
          return true;
        }
        if ((((ProductInfo)localObject).supportMainMsgType & 0xF) == 9) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    c(localArrayList);
  }
  
  protected void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {}
    String str;
    DeviceMsgHandle localDeviceMsgHandle;
    do
    {
      return;
      paramIntent.removeExtra("forward_type");
      if (i != -1) {
        break;
      }
      str = paramIntent.getStringExtra("forward_text");
      localDeviceMsgHandle = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((N) && (this.M)) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceMsgHandle.a(paramIntent, localSessionInfo, str, bool);
      return;
    }
    super.f(paramIntent);
  }
  
  protected void g(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() == null) {
      super.x();
    }
    do
    {
      return;
      super.g(paramIntent);
    } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing());
    k(paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20, 10000L);
      continue;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20);
    }
  }
  
  void k(Intent paramIntent)
  {
    int m = paramIntent.getIntExtra(AlbumConstants.i, -1);
    ArrayList localArrayList;
    int n;
    Object localObject1;
    Object localObject2;
    if ((80 == m) || (82 == m))
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      localArrayList = paramIntent.getExtras().getStringArrayList("PhotoConst.PHOTO_PATHS");
      n = paramIntent.getExtras().getInt("PhotoConst.SEND_SIZE_SPEC", 0);
      paramIntent = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      localObject1 = paramIntent.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if (localObject1 == null) {
        break label571;
      }
      localObject2 = paramIntent.a(((DeviceInfo)localObject1).productId);
      if ((localObject2 == null) || (!((ProductInfo)localObject2).isSupportFuncMsgType(1))) {
        break label571;
      }
    }
    label571:
    for (int i = 1;; i = 0)
    {
      long l = 0L;
      int k = 0;
      if (localObject1 != null)
      {
        l = ((DeviceInfo)localObject1).din;
        k = ((DeviceInfo)localObject1).productId;
      }
      if ((i == 0) && (this.eb != 4) && (this.eb != 3))
      {
        paramIntent = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, k);
      }
      do
      {
        do
        {
          return;
          localObject1 = new ArrayList();
          localObject2 = localArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            try
            {
              ((ArrayList)localObject1).add(new FileInfo(str));
            }
            catch (FileNotFoundException localFileNotFoundException) {}
          }
          if ((this.eb == 4) || (this.eb == 3))
          {
            localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext()) {
              paramIntent.a((String)((Iterator)localObject1).next(), 2154);
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.al, 2, "prcessExtraData: send:" + localArrayList.size());
            }
            x();
            return;
          }
          if (this.eb != 9) {
            break;
          }
        } while (((ArrayList)localObject1).size() <= 0);
        paramIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PrinterOptionActivity.class);
        paramIntent.putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
        paramIntent.putExtra(AlbumConstants.i, m);
        paramIntent.putExtra("sIsCloudPrinter", true);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramIntent, 102);
        return;
        paramIntent = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
        if ((N) && (this.M))
        {
          paramIntent.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList);
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendGroupMsg", 3, 0, k);
          return;
        }
        if (!this.P) {
          break;
        }
      } while (((ArrayList)localObject1).size() <= 0);
      paramIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PrinterOptionActivity.class);
      paramIntent.putParcelableArrayListExtra("sFilesSelected", (ArrayList)localObject1);
      paramIntent.putExtra(AlbumConstants.i, m);
      paramIntent.putExtra("sIsCloudPrinter", true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(paramIntent, 102);
      return;
      if (n == 2)
      {
        b(localArrayList);
        return;
      }
      c(localArrayList);
      return;
    }
  }
  
  protected void m()
  {
    super.m();
    if ((this.eb == 1) || (this.eb == 3) || (this.eb == 9)) {
      if ((PanelIconLinearLayout)this.d.findViewById(2131297408) != null) {
        a(Integer.valueOf(4));
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          break label53;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d(this.al, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.eb + "], find view panelicons failed!!");
          return;
          if ((this.eb != 2) && (this.eb != 4)) {
            break;
          }
          if ((PanelIconLinearLayout)this.d.findViewById(2131297408) != null)
          {
            a(Integer.valueOf(5));
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.al, 2, "DeviceMsgChatPie, OPER_TYPE_SEND_PICTURE[" + this.eb + "], find view panelicons failed!!");
        return;
      } while (this.eb == 5);
      if (this.eb == 6)
      {
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData;
      if (this.eb == 7)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file";
        localfileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.ec);
        return;
      }
      if (this.eb == 8)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        return;
      }
      if (this.eb == 10)
      {
        localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
        localfileAssistantReportData.b = "send_file";
        localfileAssistantReportData.jdField_a_of_type_Int = 1;
        FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
        PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        return;
      }
    } while (this.eb != 11);
    a(Integer.valueOf(13));
  }
  
  protected void n()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void o()
  {
    Object localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    long l = 0L;
    int i;
    if (localObject != null)
    {
      i = ((DeviceInfo)localObject).productId;
      l = ((DeviceInfo)localObject).din;
    }
    for (;;)
    {
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_Menu", 1, 0, i);
      if (localObject == null) {
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("device_info", (Parcelable)localObject);
      localIntent.putExtra("isPublicDevice", true);
      localObject = new LightAppUtil(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a((DeviceInfo)localObject);
      if (localObject != null) {
        localIntent.putExtra("lightapp_setting", (Parcelable)localObject);
      }
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSettingActivity", eg, null, SmartDevicePluginProxyActivity.class);
      if (this.jdField_j_of_type_AndroidWidgetImageView != null) {
        this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      BaseApplication.getContext().getSharedPreferences("lock_red_dot_show", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "_" + "lock_red_dot_show" + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
      BaseApplication.getContext().getSharedPreferences("qsmart_preference", 0).edit().putBoolean("ota_showupdatereddot", false).commit();
      return;
      i = 0;
    }
  }
  
  protected void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838433);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getText(2131364570));
    }
  }
  
  public boolean v()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(2))) {
        return true;
      }
    }
    return false;
  }
  
  protected void w()
  {
    if (this.F) {
      if (QLog.isColorLevel()) {
        QLog.d(this.al, 2, "hasDestory = true return");
      }
    }
    do
    {
      return;
      super.w();
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    } while (!QLog.isColorLevel());
    QLog.w(this.al, 2, " already unregisterReceiver" + localIllegalArgumentException);
  }
  
  public boolean w()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(8))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean x()
  {
    if (w()) {
      return true;
    }
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      if ((localSmartDeviceProxyMgr != null) && (localSmartDeviceProxyMgr.d(l)) && (localSmartDeviceProxyMgr.a(l, 17))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        long l = 0L;
      }
    }
    return false;
  }
  
  public boolean y()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportFuncMsgType(1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean z()
  {
    Object localObject = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject = ((SmartDeviceProxyMgr)localObject).a(localDeviceInfo.productId);
      if ((localObject != null) && (((ProductInfo)localObject).isSupportMainMsgType(2))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\DeviceMsgChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */