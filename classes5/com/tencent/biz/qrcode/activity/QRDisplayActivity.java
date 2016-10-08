package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.CodeMaskManager;
import com.tencent.biz.qrcode.CodeMaskManager.Callback;
import com.tencent.biz.qrcode.CustomAccessibilityDelegate.CallBack;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PcmPlayer;
import com.tencent.chirp.PcmPlayer.QQPlayerListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler.Callback;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jbc;
import jbd;
import jbg;
import jbh;
import jbi;
import jbj;
import jbk;
import jbl;
import jbm;
import jbn;
import jbp;
import jbq;
import jbr;
import jbt;
import jbu;
import jbv;
import jbw;
import jbx;
import jby;
import jca;
import mqq.os.MqqHandler;

public class QRDisplayActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, CodeMaskManager.Callback, CustomAccessibilityDelegate.CallBack, PcmPlayer.QQPlayerListener, ChirpSoHandler.Callback
{
  protected static final int a = 60000;
  protected static final String a = "QRDisplayActivity";
  protected static final int b = 1;
  public static final String b = "qrcode";
  protected static final int c = 2;
  public static final String c = "user";
  protected static final int d = 3;
  public static final String d = "group";
  public static final String e = "discussion";
  protected static final String l = "memberUin";
  private static final int m = 7;
  private static final int n = 8;
  public static final String n = "声波播放失败，请重新打开二维码页面重试";
  private static final int o = 1000;
  private static final int p = 1001;
  private static final int q = 1002;
  private static final int r = 1003;
  private static final int s = 1004;
  private static final int t = 1;
  private static final int u = 2;
  private static final int v = 3;
  private static final int w = 4;
  private static final int x = 5;
  protected long a;
  public Bitmap a;
  public Bundle a;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  protected Handler a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  protected View a;
  public ImageView a;
  protected TextView a;
  public BitMatrix a;
  protected CodeMaskManager a;
  QRDisplayActivity.GetNicknameObserver jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver;
  private PcmPlayer jdField_a_of_type_ComTencentChirpPcmPlayer;
  public DiscussionHandler a;
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  protected ActionSheetAdapter a;
  public Runnable a;
  List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public long b;
  public Bitmap b;
  private Handler b;
  public View b;
  public ImageView b;
  protected TextView b;
  public ActionSheet b;
  public Runnable b;
  public List b;
  public boolean b;
  protected long c;
  public View c;
  public ImageView c;
  protected TextView c;
  public ActionSheet c;
  protected Runnable c;
  protected boolean c;
  public View d;
  public ImageView d;
  public boolean d;
  public int e;
  View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  protected int f;
  protected View f;
  public String f;
  private volatile boolean f;
  public int g;
  protected View g;
  public String g;
  private boolean g;
  public int h;
  protected View h;
  public String h;
  public int i;
  public String i;
  int j;
  public String j;
  public int k;
  protected String k;
  public int l;
  public String m;
  
  public QRDisplayActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver = new jbc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new jbq(this);
    this.jdField_a_of_type_JavaLangRunnable = new jbr(this);
    this.jdField_b_of_type_JavaLangRunnable = new jbt(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new jbu(this);
    this.jdField_c_of_type_JavaLangRunnable = new jbv(this);
    this.l = -1;
    this.jdField_a_of_type_AndroidOsCountDownTimer = new jbp(this, 1000L, 200L);
  }
  
  private static void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      paramArrayOfByte[(i1 * 2)] = ((byte)(paramArrayOfShort[i1] & 0xFF));
      paramArrayOfByte[(i1 * 2 + 1)] = ((byte)(paramArrayOfShort[i1] >> 8 & 0xFF));
      i1 += 1;
    }
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    int i2 = arrayOfInt[1];
    int i3 = paramView.getHeight();
    int i4 = arrayOfInt[0];
    int i5 = arrayOfInt[0];
    int i6 = paramView.getWidth();
    return (paramFloat2 >= i1) && (paramFloat2 < i2 + i3) && (paramFloat1 > i4) && (paramFloat1 < i5 + i6);
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 197	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 200	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 204	java/io/File:exists	()Z
    //   13: ifne +173 -> 186
    //   16: new 206	com/tencent/chirp/ChirpWrapper
    //   19: dup
    //   20: invokespecial 207	com/tencent/chirp/ChirpWrapper:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 209	com/tencent/chirp/ChirpWrapper:a	()I
    //   28: ifne +267 -> 295
    //   31: aload_0
    //   32: getfield 213	com/tencent/biz/qrcode/activity/QRDisplayActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   35: invokevirtual 218	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   38: astore_3
    //   39: new 220	java/lang/String
    //   42: dup
    //   43: ldc -34
    //   45: invokespecial 223	java/lang/String:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: new 225	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   57: ldc -28
    //   59: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: iconst_0
    //   65: bipush 14
    //   67: aload_3
    //   68: invokevirtual 235	java/lang/String:length	()I
    //   71: isub
    //   72: invokevirtual 239	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_3
    //   79: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_3
    //   86: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +28 -> 117
    //   92: ldc 24
    //   94: iconst_2
    //   95: new 225	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   102: ldc -7
    //   104: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_2
    //   118: aload_3
    //   119: invokevirtual 255	com/tencent/chirp/ChirpWrapper:a	(Ljava/lang/String;)Landroid/util/Pair;
    //   122: astore_2
    //   123: aload_2
    //   124: getfield 261	android/util/Pair:first	Ljava/lang/Object;
    //   127: checkcast 263	java/lang/Integer
    //   130: invokevirtual 266	java/lang/Integer:intValue	()I
    //   133: istore 5
    //   135: aload_2
    //   136: getfield 269	android/util/Pair:second	Ljava/lang/Object;
    //   139: checkcast 271	[S
    //   142: astore_3
    //   143: iload 5
    //   145: ifne +115 -> 260
    //   148: aload_3
    //   149: ifnull +111 -> 260
    //   152: new 273	java/io/FileOutputStream
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   160: astore_2
    //   161: aload_3
    //   162: arraylength
    //   163: iconst_2
    //   164: imul
    //   165: newarray <illegal type>
    //   167: astore_1
    //   168: aload_3
    //   169: aload_1
    //   170: invokestatic 278	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	([S[B)V
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual 282	java/io/FileOutputStream:write	([B)V
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_1
    //   189: aload_1
    //   190: athrow
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +13 -> 210
    //   200: ldc 24
    //   202: iconst_2
    //   203: ldc_w 287
    //   206: aload_2
    //   207: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: astore_2
    //   212: aload_1
    //   213: ifnull +9 -> 222
    //   216: aload_1
    //   217: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_2
    //   235: goto -13 -> 222
    //   238: astore_1
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 285	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: aload_1
    //   259: athrow
    //   260: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +30 -> 293
    //   266: ldc 24
    //   268: iconst_4
    //   269: new 225	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 292
    //   279: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload 5
    //   284: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 252	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_0
    //   294: ireturn
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_1
    //   298: goto -112 -> 186
    //   301: astore_1
    //   302: goto -72 -> 230
    //   305: astore_2
    //   306: goto -54 -> 252
    //   309: astore_1
    //   310: goto -66 -> 244
    //   313: astore_3
    //   314: aload_1
    //   315: astore_2
    //   316: aload_3
    //   317: astore_1
    //   318: goto -74 -> 244
    //   321: astore_3
    //   322: aload_2
    //   323: astore_1
    //   324: aload_3
    //   325: astore_2
    //   326: goto -132 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	QRDisplayActivity
    //   0	329	1	paramString	String
    //   23	160	2	localObject1	Object
    //   191	16	2	localException1	Exception
    //   211	38	2	str1	String
    //   305	1	2	localIOException	java.io.IOException
    //   315	11	2	localObject2	Object
    //   38	131	3	localObject3	Object
    //   313	4	3	localObject4	Object
    //   321	4	3	localException2	Exception
    //   48	15	4	str2	String
    //   133	150	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   182	186	188	finally
    //   152	161	191	java/lang/Exception
    //   216	220	232	java/io/IOException
    //   216	220	238	finally
    //   152	161	241	finally
    //   239	241	241	finally
    //   226	230	254	finally
    //   248	252	257	finally
    //   182	186	297	java/io/IOException
    //   226	230	301	java/io/IOException
    //   248	252	305	java/io/IOException
    //   161	178	309	finally
    //   194	210	313	finally
    //   161	178	321	java/lang/Exception
  }
  
  private void l()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, getString(2131367256), 0).b(getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "tryToGetShareLink: net is not supported");
      }
      this.l = -1;
    }
    label419:
    label535:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (this.l)
            {
            default: 
              return;
            case 0: 
            case 2: 
            case 3: 
              for (;;)
              {
                try
                {
                  Object localObject2 = QRUtils.a(this, "temp_qrcode_share_" + this.jdField_h_of_type_JavaLangString + ".png", this.jdField_b_of_type_AndroidGraphicsBitmap);
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putInt("forward_type", 1);
                  ((Bundle)localObject1).putString("forward_filepath", (String)localObject2);
                  ((Bundle)localObject1).putString("forward_thumb", (String)localObject2);
                  ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject2);
                  ((Bundle)localObject1).putString("forward_extra", (String)localObject2);
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtras((Bundle)localObject1);
                  ForwardBaseOption.a(this, (Intent)localObject2, 21);
                  if (this.jdField_g_of_type_Int != 2) {
                    break label535;
                  }
                  ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qq", 0, 0, this.jdField_h_of_type_JavaLangString, "", "", String.valueOf(this.jdField_e_of_type_Int));
                  return;
                }
                catch (OutOfMemoryError localOutOfMemoryError2)
                {
                  Object localObject1;
                  QRUtils.a(1, 2131364461);
                  return;
                }
                try
                {
                  localObject1 = QRUtils.a(this, "temp_qrcode_share_" + this.jdField_h_of_type_JavaLangString + ".png", this.jdField_b_of_type_AndroidGraphicsBitmap);
                  if (TextUtils.isEmpty((CharSequence)localObject1))
                  {
                    QRUtils.a(1, 2131364462);
                    return;
                  }
                }
                catch (OutOfMemoryError localOutOfMemoryError1)
                {
                  QRUtils.a(1, 2131364461);
                  return;
                }
              }
              if (this.l != 2) {
                break label419;
              }
              WXShareHelper.a().a(localOutOfMemoryError1, this.jdField_b_of_type_AndroidGraphicsBitmap, 0);
              if (this.jdField_g_of_type_Int == 2)
              {
                ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_wechat", 0, 0, this.jdField_h_of_type_JavaLangString, "", "", String.valueOf(this.jdField_e_of_type_Int));
                return;
              }
              break;
            }
          } while (this.jdField_g_of_type_Int != 5);
          ReportController.b(this.app, "CliOper", "", "", "0X8006676", "0X8006676", 0, 0, "", "", "", "");
          return;
          WXShareHelper.a().a(localOutOfMemoryError1, this.jdField_b_of_type_AndroidGraphicsBitmap, 1);
          if (this.jdField_g_of_type_Int == 2)
          {
            ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_circle", 0, 0, this.jdField_h_of_type_JavaLangString, "", "", String.valueOf(this.jdField_e_of_type_Int));
            return;
          }
        } while (this.jdField_g_of_type_Int != 5);
        ReportController.b(this.app, "CliOper", "", "", "0X8006677", "0X8006677", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_g_of_type_Int != 5);
      ReportController.b(this.app, "CliOper", "", "", "0X8006674", "0X8006674", 0, 0, "", "", "", "");
      return;
      e();
      if ((this.jdField_k_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
      }
      if (this.jdField_g_of_type_Int == 2)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "qr_qzone", 0, 0, this.jdField_h_of_type_JavaLangString, "", "", String.valueOf(this.jdField_e_of_type_Int));
        return;
      }
    } while (this.jdField_g_of_type_Int != 5);
    ReportController.b(this.app, "CliOper", "", "", "0X8006675", "0X8006675", 0, 0, "", "", "", "");
  }
  
  private void m()
  {
    if ((this.app.d()) || (!AppSetting.j)) {
      return;
    }
    Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1000, 5, 0);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void n()
  {
    if ((this.app.d()) || (!AppSetting.j)) {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1001, 5, 0).sendToTarget();
  }
  
  public BitMatrix a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramString = "user" + paramString;
    }
    for (;;)
    {
      paramString = getSharedPreferences("qrcode", 0).getString(paramString, null);
      if (paramString != null) {
        break label104;
      }
      return null;
      if (paramInt1 == 2)
      {
        paramString = "group" + paramString;
      }
      else
      {
        if (paramInt1 != 5) {
          break;
        }
        paramString = "discussion" + paramString;
      }
    }
    return null;
    label104:
    return QRUtils.a(paramString, paramInt2);
  }
  
  public String a()
  {
    String str;
    if (this.jdField_g_of_type_Int == 1) {
      str = "user" + this.jdField_h_of_type_JavaLangString;
    }
    for (;;)
    {
      return getSharedPreferences("qrcode", 0).getString(str, null);
      if (this.jdField_g_of_type_Int == 2)
      {
        str = "group" + this.jdField_h_of_type_JavaLangString;
      }
      else
      {
        if (this.jdField_g_of_type_Int != 5) {
          break;
        }
        str = "discussion" + this.jdField_h_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    paramString = "discussionnick_name" + paramString;
    return getSharedPreferences("qrcode", 0).getString(paramString, null);
  }
  
  public String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i1));
      if (i1 != paramList.size() - 1) {
        localStringBuffer.append("、");
      }
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus, " + this.app.d());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    String str;
    switch (paramInt)
    {
    default: 
      str = "获取多人聊天链接失败";
    }
    for (;;)
    {
      a(2130838442, str);
      finish();
      return;
      str = "多人聊天不存在";
      continue;
      str = "你已不在此多人聊天";
    }
  }
  
  void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "template ready, draw qrcode");
    }
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    Bitmap localBitmap1 = (Bitmap)paramBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)paramBundle.getParcelable("qrbkg");
    int i4 = paramBundle.getInt("B");
    int i5 = paramBundle.getInt("W");
    Rect localRect = (Rect)paramBundle.getParcelable("qrloc");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("clip");
    if (paramBundle.containsKey("qrsz"))
    {
      i1 = paramBundle.getInt("qrsz");
      localObject = a();
      if (localObject != null) {
        this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = QRUtils.a((String)localObject, i1);
      }
    }
    int i6 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a();
    Object localObject = new int[i6 * i6];
    int i1 = 0;
    while (i1 < i6)
    {
      i2 = 0;
      if (i2 < i6)
      {
        if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i2, i1)) {}
        for (int i3 = i4;; i3 = i5)
        {
          localObject[(i1 * i6 + i2)] = i3;
          i2 += 1;
          break;
        }
      }
      i1 += 1;
    }
    Bitmap localBitmap3 = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
    localBitmap3.setPixels((int[])localObject, 0, i6, 0, 0, i6, i6);
    int i2 = 0;
    i1 = i2;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L)
    {
      if (this.jdField_f_of_type_Int == 2) {
        i1 = 2130838906;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = QRUtils.a(this, localBitmap1, this.jdField_a_of_type_AndroidGraphicsBitmap, paramBundle.getInt("nameClr"), this.jdField_f_of_type_JavaLangString, localBitmap2, localBitmap3, paramBundle.getInt("head"), paramBundle.getInt("tipsClr"), this.jdField_g_of_type_JavaLangString, localRect, localArrayList, i1);
      localBitmap3.recycle();
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break label430;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      i1 = i2;
      if (this.jdField_f_of_type_Int != 1) {
        break;
      }
      i1 = 2130839365;
      break;
      label430:
      if (super.isResume())
      {
        paramBundle = DialogUtil.a(this, 230);
        paramBundle.setMessage(2131364391);
        paramBundle.setPositiveButton(2131367263, new jbg(this));
        paramBundle.show();
      }
      else
      {
        super.finish();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 1) {}
    for (paramString1 = "user" + paramString1;; paramString1 = "group" + paramString1)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
      do
      {
        return;
      } while (paramInt != 2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = "discussionnick_name" + paramString1;
    SharedPreferences.Editor localEditor = getSharedPreferences("qrcode", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "enter focus_clear");
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 1001, 3, 0).sendToTarget();
  }
  
  public void b(int paramInt)
  {
    Intent localIntent = new Intent(this, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=1"));
    startActivityForResult(localIntent, -1);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131364464, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131364466, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(2131364467, 1);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new jbw(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new jbx(this));
    }
    if (!this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void c(int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt != 0)) {
      QLog.d("QRDisplayActivity", 2, "onPlayStop, " + paramInt);
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 500L);
      return;
    } while (this.jdField_b_of_type_AndroidOsHandler.hasMessages(1001));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 1000L);
  }
  
  public void d()
  {
    ThreadManager.c(new jby(this));
    String str = null;
    if (this.jdField_g_of_type_Int == 1) {
      str = "saveConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_g_of_type_Int == 2) {
        str = "saveGroupQRcard";
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 1) {
        break label90;
      }
      a(0, getString(2131364465));
      if (QLog.isColorLevel()) {
        QLog.i("QRDisplayActivity", 2, "shareQRCode success");
      }
      if ((this.jdField_k_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416F", "0X800416F", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label90:
      Intent localIntent;
      if (paramInt1 == 2)
      {
        localIntent = new Intent(this, SplashActivity.class);
        localIntent.putExtras(paramIntent);
        SessionInfo localSessionInfo = ForwardUtils.a(localIntent);
        ForwardUtils.a(this.app, this, localSessionInfo, localIntent);
      }
      else if (paramInt1 == 21)
      {
        localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
        finish();
      }
      else if (paramInt1 != 3) {}
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    super.setContentView(2130903777);
    paramBundle = super.getIntent();
    this.jdField_k_of_type_JavaLangString = paramBundle.getStringExtra("from");
    this.jdField_k_of_type_Int = paramBundle.getIntExtra("reportFlag", 0);
    super.setTitle(paramBundle.getStringExtra("title"));
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("nick");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramBundle.getParcelableExtra("face"));
    this.jdField_g_of_type_Int = paramBundle.getIntExtra("type", 1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("adminLevel", 2);
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("GroupFlagExt", 0L);
    this.jdField_f_of_type_Int = ((int)paramBundle.getLongExtra("AuthGroupType", 0L));
    int i1;
    Object localObject1;
    if (this.jdField_g_of_type_Int == 1)
    {
      this.jdField_g_of_type_JavaLangString = getString(2131364449);
      paramBundle = findViewById(2131300028);
      paramBundle.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131300029);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300030));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300031));
      this.jdField_g_of_type_AndroidViewView = findViewById(2131300032);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300033));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300034));
      this.jdField_h_of_type_AndroidViewView = findViewById(2131300035);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300036));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300037));
      i1 = (getWindowManager().getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(2131493127) * 3) / 8;
      localObject1 = (ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams();
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = i1;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = i1;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131300022);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300024));
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131300021);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131300025);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131300027);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131300038);
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131364397));
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "display qrcode, type: " + this.jdField_g_of_type_Int);
      }
      if (this.jdField_g_of_type_Int != 5) {
        break label1386;
      }
      getIntent().getStringExtra("discussion_shorturl");
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      if (this.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
        this.app.registObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
      }
      this.leftView.setContentDescription(getString(2131364645));
      this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131364646));
      setResult(-1, getIntent());
      paramBundle = (FriendsManager)this.app.getManager(50);
      localObject2 = (DiscussionManager)this.app.getManager(52);
      localObject1 = ((DiscussionManager)localObject2).a(this.jdField_h_of_type_JavaLangString);
      if (localObject1 != null) {
        break;
      }
      g();
      i1 = 1;
      this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager = new CodeMaskManager(this, this.jdField_g_of_type_Int);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 60000L);
      if (i1 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_f_of_type_JavaLangString + "," + this.jdField_g_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_k_of_type_Int & 0x1) != 0) {
        ReportController.b(this.app, "P_CliOper", "flag1", "", "0X800416D", "0X800416D", 0, 0, "", "", "", "");
      }
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 1, 0).sendToTarget();
      return true;
      if (this.jdField_g_of_type_Int == 2)
      {
        findViewById(2131300026).setVisibility(0);
        findViewById(2131300042).setVisibility(0);
        findViewById(2131300043).setOnClickListener(this);
        findViewById(2131300044).setOnClickListener(this);
        this.jdField_g_of_type_JavaLangString = getString(2131364450);
        paramBundle = getString(2131365107);
        this.leftView.setText(paramBundle);
        this.leftView.setContentDescription(paramBundle);
      }
      else if (this.jdField_g_of_type_Int == 5)
      {
        findViewById(2131300026).setVisibility(0);
        findViewById(2131300042).setVisibility(0);
        findViewById(2131300043).setOnClickListener(this);
        findViewById(2131300044).setOnClickListener(this);
        this.jdField_g_of_type_JavaLangString = getString(2131364454);
      }
    }
    Object localObject2 = ((DiscussionManager)localObject2).a(this.jdField_h_of_type_JavaLangString);
    if (localObject2 != null)
    {
      this.jdField_j_of_type_Int = ((List)localObject2).size();
      if (!((DiscussionInfo)localObject1).hasRenamed())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QRDisplayActivity", 4, "title not defined, join by nicks");
        }
        if (localObject2 != null) {
          localObject1 = ((List)localObject2).iterator();
        }
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label1210;
        }
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (this.app.getAccount().equals(((DiscussionMemberInfo)localObject2).memberUin))
        {
          this.jdField_b_of_type_JavaUtilList.add(ContactUtils.i(this.app, ((DiscussionMemberInfo)localObject2).memberUin));
          continue;
          this.jdField_j_of_type_Int = 0;
          break;
        }
        Friends localFriends = paramBundle.c(((DiscussionMemberInfo)localObject2).memberUin);
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          this.jdField_b_of_type_JavaUtilList.add(localFriends.name);
        } else if (a(((DiscussionMemberInfo)localObject2).memberUin) != null) {
          this.jdField_b_of_type_JavaUtilList.add(a(((DiscussionMemberInfo)localObject2).memberUin));
        } else {
          this.jdField_a_of_type_JavaUtilList.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
      label1210:
      if ((this.jdField_b_of_type_JavaUtilList.size() >= 5) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label1432;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "fetch nicks from server");
      }
      paramBundle = new String[this.jdField_a_of_type_JavaUtilList.size()];
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        paramBundle[i1] = ((String)((Iterator)localObject1).next());
        i1 += 1;
      }
      ((DiscussionHandler)this.app.a(6)).a(new String[] { "20002" }, paramBundle);
    }
    label1386:
    label1432:
    for (int i2 = 0;; i2 = 1)
    {
      i1 = i2;
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, new jca(this));
      this.jdField_f_of_type_JavaLangString = a(this.jdField_b_of_type_JavaUtilList);
      i1 = i2;
      break;
      if (this.jdField_g_of_type_Int == 2) {
        this.jdField_d_of_type_AndroidViewView.setContentDescription(getString(2131364452, new Object[] { this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString }));
      }
      i1 = 1;
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager.a();
    if (this.jdField_g_of_type_Int == 5)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRDisplayActivity$GetNicknameObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.b(this);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 2, 0).sendToTarget();
  }
  
  public void e()
  {
    ThreadManager.c(new jbd(this));
    String str = null;
    if (this.jdField_g_of_type_Int == 1) {
      str = "shareConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", str, 1);
      return;
      if (this.jdField_g_of_type_Int == 2) {
        str = "shareGroupQRcard";
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_Boolean) || (super.isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "get code template");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager;
    boolean bool2 = this.jdField_c_of_type_Boolean;
    if ((this.jdField_a_of_type_Long & 0x800) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((CodeMaskManager)localObject).a(this, bool2, bool1, this.jdField_f_of_type_Int);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    if (this.jdField_g_of_type_Int == 1) {}
    for (localObject = "changeConsumerQRcard";; localObject = "changeGroupQRcard")
    {
      StatisticCollector.a(BaseApplication.getContext()).b(this.app, "", (String)localObject, 1);
      return;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (super.isResume())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage(2131364390);
      localQQCustomDialog.setPositiveButton(2131367263, new jbh(this));
      localQQCustomDialog.show();
      return;
    }
    finish();
  }
  
  protected void h()
  {
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 <= 3)
    {
      ((List)localObject).add(ActionSheetAdapter.a(i1));
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a((List)localObject);
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet == null)
    {
      localObject = new jbj(this);
      jbk localjbk = new jbk(this);
      jbl localjbl = new jbl(this);
      this.jdField_c_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, (AdapterView.OnItemClickListener)localObject, localjbk, localjbl, false);
    }
    if ((this.jdField_c_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1004: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.app.E();
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "talkback value " + AppSetting.j);
        }
        if ((AppSetting.j) && (this.jdField_g_of_type_Int == 1))
        {
          bool1 = ChirpWrapper.a();
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "isSoLoaded " + bool1);
          }
          if (!bool1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler == null) {
              this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler = ((ChirpSoHandler)((EarlyDownloadManager)this.app.getManager(76)).a("qq.android.system.chirp"));
            }
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(this);
            this.jdField_a_of_type_ComTencentMobileqqEarlydownloadHandlerChirpSoHandler.a(true);
            bool1 = false;
          }
        }
      }
      break;
    }
    for (;;)
    {
      BaseApplicationImpl.a.post(new jbn(this, bool1));
      break;
      boolean bool2 = true;
      bool1 = bool2;
      if (!this.jdField_g_of_type_Boolean)
      {
        BaseApplicationImpl.a.post(new jbm(this));
        this.jdField_g_of_type_Boolean = true;
        bool1 = bool2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_f_of_type_Boolean);
        }
        if (this.jdField_f_of_type_Boolean) {
          break;
        }
        String str = getFilesDir() + this.app.a() + "_vqr.dat";
        File localFile = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("QRDisplayActivity", 2, "voiceFile.exists = " + localFile.exists());
        }
        if (!localFile.exists()) {
          if (a(str)) {
            break label530;
          }
        }
        label530:
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_f_of_type_Boolean = bool1;
          if (QLog.isColorLevel()) {
            QLog.d("QRDisplayActivity", 2, "playQRCodeFailed = " + this.jdField_f_of_type_Boolean);
          }
          if (this.jdField_f_of_type_Boolean) {
            break label536;
          }
          if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null)
          {
            this.jdField_a_of_type_ComTencentChirpPcmPlayer = new PcmPlayer(this, this, 44100, str);
            this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
            AudioUtil.a(this, true);
          }
          if (paramMessage.arg1 != 5) {
            break;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 0, 0, "", "", "", "");
          break;
        }
        label536:
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.b();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer = null;
        if (paramMessage.arg1 == 5) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        if (paramMessage.arg1 == 3) {
          ReportController.b(this.app, "CliOper", "", "", "0X8007099", "0X8007099", 1, 0, "", "", "", "");
        }
        AudioUtil.a(this, false);
        break;
        if (this.jdField_a_of_type_ComTencentChirpPcmPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentChirpPcmPlayer.a();
        break;
        QQAppInterface.f("声波播放失败，请重新打开二维码页面重试");
        break;
        bool1 = false;
      }
    }
  }
  
  public void i()
  {
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "scan_QR_code", "code_click", 0, 0, "", "", "", "");
    if ("ScannerActivity".equals(this.jdField_k_of_type_JavaLangString))
    {
      setResult(-1);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("from", "QRDisplayActivity");
    startActivityForResult(localIntent, 3);
  }
  
  public void j() {}
  
  public void k()
  {
    if (isResume()) {
      this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004, 4, 0).sendToTarget();
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.jdField_c_of_type_Long) <= 1000L) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_Long = l1;
      if (paramView.getId() == 2131300027)
      {
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.jdField_g_of_type_Int == 2)
        {
          f();
          if ((this.jdField_k_of_type_Int & 0x1) == 0) {
            continue;
          }
          ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_g_of_type_Int == 5)
        {
          f();
          ReportController.b(this.app, "CliOper", "", "", "0X8006671", "0X8006671", 0, 0, "", "", "", "");
          return;
        }
        c();
        return;
      }
      if (paramView.getId() == 2131300041) {
        if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet = new LinkShareActionSheetBuilder(this).a(this);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        ReportController.b(this.app, "CliOper", "", "", "0X80040F6", "0X80040F6", 0, 0, "", "", "", "");
        return;
        if (paramView.getId() == 2131300043)
        {
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          d();
          if ((this.jdField_k_of_type_Int & 0x1) != 0) {
            ReportController.b(this.app, "P_CliOper", "flag1", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
          }
          if (this.jdField_g_of_type_Int != 5) {
            continue;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006672", "0X8006672", 0, 0, "", "", "", "");
          return;
        }
        if (paramView.getId() == 2131300044)
        {
          h();
          if (this.jdField_g_of_type_Int != 5) {
            continue;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8006673", "0X8006673", 0, 0, "", "", "", "");
          return;
        }
        if ((paramView.getId() == 2131300030) || (paramView.getId() == 2131300031))
        {
          b(7);
          return;
        }
        if ((paramView.getId() == 2131300033) || (paramView.getId() == 2131300034))
        {
          b(8);
          return;
        }
        if ((paramView.getId() == 2131300036) || (paramView.getId() == 2131300037))
        {
          i();
          return;
        }
        if (paramView.getId() == 2131300029)
        {
          b(7);
          return;
        }
        if (paramView.getId() == 2131300032)
        {
          b(8);
          return;
        }
        if (paramView.getId() != 2131300035) {
          continue;
        }
        i();
        return;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      int i1 = -1;
      if (!WXShareHelper.a().a()) {
        i1 = 2131369529;
      }
      for (;;)
      {
        if (i1 == -1) {
          break label93;
        }
        QRUtils.a(1, i1);
        break;
        if (!WXShareHelper.a().b()) {
          i1 = 2131369530;
        }
      }
      label93:
      if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new jbi(this);
        WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
      }
      paramView = this.app;
      label136:
      String str1;
      Bitmap localBitmap;
      String str2;
      if (paramInt == 2)
      {
        paramAdapterView = "1";
        ReportController.b(paramView, "CliOper", "", "", "discuss", "share_discuss_to", 0, 0, paramAdapterView, "", "", "");
        this.m = String.valueOf(System.currentTimeMillis());
        paramAdapterView = WXShareHelper.a();
        paramView = this.m;
        str1 = String.format(getString(2131370147), new Object[] { this.jdField_f_of_type_JavaLangString });
        localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        str2 = this.i;
        if (paramInt != 2) {
          break label252;
        }
      }
      label252:
      for (paramInt = 0;; paramInt = 1)
      {
        paramAdapterView.a(paramView, str1, localBitmap, "", str2, paramInt);
        break;
        paramAdapterView = "0";
        break label136;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      DiscussionInfoCardActivity.a(this.app, this, 2, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      continue;
      DiscussionInfoCardActivity.a(this.app, this, this.i, this.jdField_h_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      continue;
      DiscussionInfoCardActivity.a(this.app, this.jdField_b_of_type_Long, this.i, this.jdField_f_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\qrcode\activity\QRDisplayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */