package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopMemberCharmUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.troop.TroopMemberCardProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mse;
import msh;
import msi;
import msj;
import msk;
import msl;
import msm;
import msp;
import msq;
import msr;
import mss;
import mst;
import msu;
import msv;
import msx;
import msz;
import mta;
import mtb;
import mtc;
import mtd;
import mtf;
import mth;
import mti;
import mtj;
import mtk;
import mtl;
import mtm;
import mto;
import mtp;
import mtr;
import mts;
import mtt;
import mtu;
import mtv;
import mtw;
import mtx;
import mtz;
import org.json.JSONObject;

public class TroopMemberCardActivity
  extends IphoneTitleBarActivity
  implements View.OnLongClickListener
{
  public static final int A = 4;
  public static final int B = 4;
  public static final int C = 3;
  protected static final int D = 1;
  protected static final String D = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  protected static final int E = 3;
  protected static final int F = 4;
  protected static final int G = 5;
  protected static final int H = 6;
  protected static final int O = 1;
  protected static final int P = 0;
  public static final int R = 0;
  public static final int S = 1;
  public static final int T = 2;
  public static final int U = 3;
  public static final int V = 4;
  public static final int W = 5;
  public static final int X = 6;
  public static final int Y = 7;
  public static final int Z = 8;
  public static final byte a = 1;
  protected static final int a = 0;
  public static final int[] a;
  protected static final int aa = 0;
  protected static final int ab = 1;
  protected static final int ac = 2;
  protected static final int ad = 3;
  public static final int ae = 3;
  public static final int af = 4;
  public static final int ag = 5;
  public static final int ah = 6;
  public static final int ai = 7;
  public static final int ak = 1;
  public static final int al = 2;
  public static final int am = 3;
  public static final int an = 4;
  public static final int ao = 5;
  public static final int ap = 6;
  public static final int aq = 0;
  public static final int ar = 1;
  public static final int as = 60;
  public static final byte b = 2;
  protected static final int b = 1;
  public static final String b = "1";
  public static final byte c = 3;
  protected static final int c = 2;
  public static final String c = "2";
  public static final byte d = 4;
  protected static final int d = 3;
  public static final String d = "100";
  public static final byte e = 6;
  protected static final int e = 4;
  public static final String e = "101";
  public static final byte f = 8;
  protected static final int f = 5;
  public static final String f = "102";
  public static final byte g = 9;
  protected static final int g = 6;
  protected static final String g = "message/rfc822";
  public static final byte h = 10;
  protected static final int h = 7;
  public static final String h = "data_dep_ids";
  protected static final int i = 8;
  public static final String i = "data_dep_add";
  protected static final int j = 9;
  public static final String j = "data_dep_remove";
  protected static final int k = 10;
  public static final String k = "troopUin";
  protected static final int l = 11;
  public static final String l = "memberUin";
  protected static final int m = 0;
  public static final String m = "fromFlag";
  protected static final int n = 1;
  public static final String n = "[icon]";
  public static final String o = "[torch]";
  public static final int p = 10000;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  public static final int u = 4;
  public static final int v = 0;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 1;
  public static final int z = 2;
  protected String A = "";
  protected String B = "";
  public String C;
  public int I;
  public int J = -1;
  public int K = -1;
  public int L = -1;
  public int M = 1;
  public int N = -1;
  public int Q;
  protected float a;
  protected long a;
  protected Intent a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Handler a;
  protected DisplayMetrics a;
  protected View.OnClickListener a;
  protected View a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public AlphaAnimation a;
  public Animation.AnimationListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public TroopMemberCardActivity a;
  protected FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mto(this);
  public TroopHandler a;
  public TroopManager a;
  protected TroopObserver a;
  protected Card a;
  public TroopMemberCard a;
  protected BounceScrollView a;
  protected QQProgressDialog a;
  protected QQProgressNotifier a;
  protected QQToastNotifier a;
  protected ActionSheet.OnButtonClickListener a;
  public ActionSheet a;
  public ImmersiveTitleBar2 a;
  public Object a;
  protected final String a;
  public ArrayList a;
  public List a;
  private mtz jdField_a_of_type_Mtz = new mtz(this);
  public volatile boolean a;
  public View[] a;
  public int aj = -1;
  protected long b;
  protected View.OnClickListener b;
  protected View b;
  public ViewTreeObserver.OnGlobalLayoutListener b;
  public AlphaAnimation b;
  public ImageView b;
  protected LinearLayout b;
  public TextView b;
  protected TroopObserver b;
  public boolean b;
  protected long c;
  protected View.OnClickListener c;
  protected View c;
  protected LinearLayout c;
  protected TextView c;
  protected TroopObserver c;
  public boolean c;
  protected View.OnClickListener d;
  public View d;
  public TextView d;
  protected boolean d;
  protected View.OnClickListener e;
  public View e;
  protected TextView e;
  public boolean e;
  public View f;
  protected TextView f;
  protected TextView g;
  public TextView h;
  protected TextView i;
  public int o = -1;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  protected String y = "";
  public String z = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 64536, 63536, 45536, 63534, 63514, 64501, 63535, 63529, 60527, 64487 };
  }
  
  public TroopMemberCardActivity()
  {
    this.jdField_a_of_type_JavaLangString = "Q.profilecard.TroopMemberCardActivity";
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[11];
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = new TroopMemberCard();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new mtv(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new msh(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new msi(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new msk(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new msl(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = new msm(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new msu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new msv(this);
    this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new msx(this);
    this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver = new msz(this);
    this.jdField_a_of_type_AndroidContentIntent = new Intent();
    this.jdField_a_of_type_AndroidOsHandler = new mta(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new mtj(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new mtk(this);
  }
  
  public static Intent a(Intent paramIntent, TroopInfo paramTroopInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramIntent.putExtra("url", String.format("http://web.qun.qq.com/cgi-bin/misc/dynamic_url?gc=%1$s&uin=%2$s&from=%3$s&type=%4$s&nick=%5$s", new Object[] { paramString3, paramString4, new TroopMemberCardActivity.9().get(paramString1), paramString1, paramString5 }));
    paramIntent.putExtra("uin", paramString2);
    paramIntent.putExtra("portraitOnly", true);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("hide_operation_bar", true);
    return paramIntent;
  }
  
  private Bitmap a(View paramView)
  {
    try
    {
      int i1 = paramView.getWidth();
      int i2 = paramView.getHeight();
      Bitmap localBitmap;
      if ((i1 != 0) && (i2 != 0)) {
        localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      }
      Object localObject2;
      Object localObject1;
      return null;
    }
    catch (Exception paramView)
    {
      try
      {
        paramView.draw(new Canvas(localBitmap));
        localObject2 = localBitmap;
        return (Bitmap)localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        for (;;)
        {
          paramView = localOutOfMemoryError1;
          localObject1 = localOutOfMemoryError2;
        }
      }
      paramView = paramView;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, QLog.getStackTraceString(paramView));
      }
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      do
      {
        paramView = null;
        localObject2 = paramView;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.TroopMemberCardActivity", 2, QLog.getStackTraceString(localOutOfMemoryError1));
      return paramView;
    }
  }
  
  public static String a(TroopInfo paramTroopInfo)
  {
    int i1 = 0;
    JSONObject localJSONObject;
    try
    {
      if (paramTroopInfo.troopLevelMap != null)
      {
        localJSONObject = new JSONObject();
        paramTroopInfo = paramTroopInfo.troopLevelMap.split("\001");
        if ((paramTroopInfo != null) && (paramTroopInfo.length > 0)) {
          for (;;)
          {
            if (i1 >= paramTroopInfo.length) {
              break label156;
            }
            String[] arrayOfString = paramTroopInfo[i1].split("\000");
            int i2 = arrayOfString.length;
            if (i2 == 2) {}
            try
            {
              localJSONObject.put(arrayOfString[0], arrayOfString[1]);
              i1 += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString[0] + " value: " + arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramTroopInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberCardActivity", 2, "getTroopLevelMap, catch exception, makeTroopLevelMapString");
      }
    }
    label156:
    paramTroopInfo = localJSONObject.toString();
    return paramTroopInfo;
  }
  
  public static void a(Activity paramActivity, TroopMemberCard paramTroopMemberCard, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("title", paramActivity.getString(2131365071));
    localIntent.putExtra("default_text", paramTroopMemberCard.card);
    localIntent.putExtra("isTroopNick", true);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("max_num", 60);
    localIntent.putExtra("from", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void x()
  {
    Object localObject = ((FriendsManager)this.app.getManager(50)).c(this.v);
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localAllInOne = new ProfileActivity.AllInOne(this.v, 1);
      localAllInOne.h = ((Friends)localObject).name;
      localAllInOne.i = ((Friends)localObject).remark;
    }
    for (;;)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, FriendProfileCardActivity.class);
      ((Intent)localObject).putExtra("AllInOne", localAllInOne);
      ((Intent)localObject).addFlags(536870912);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity((Intent)localObject);
      return;
      localAllInOne = new ProfileActivity.AllInOne(this.v, 21);
    }
  }
  
  private void y()
  {
    int i1 = 1;
    Object localObject = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305187);
    if (!TextUtils.isEmpty(this.y))
    {
      ((TextView)localObject).setText(this.y);
      ((TextView)localObject).setVisibility(0);
      localObject = super.getString(2131369953) + super.getString(2131368675) + this.w + this.y;
      this.jdField_e_of_type_AndroidViewView.setContentDescription((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
      a((View)localObject, this.v, false);
      ((View)localObject).setContentDescription(super.getString(2131367933) + this.v);
      ((View)localObject).setBackgroundResource(2130838357);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
      ((View)localObject).setBackgroundResource(2130838355);
      String str = this.r;
      if (TextUtils.isEmpty(str)) {
        break label439;
      }
      ((View)localObject).setContentDescription(getString(2131367935) + this.r);
      label204:
      a((View)localObject, str, false);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
      ((View)localObject).setBackgroundResource(2130838355);
      str = this.p;
      a((View)localObject, str, false);
      if (TextUtils.isEmpty(str)) {
        break label476;
      }
      a((View)localObject, false, true, 0, getResources().getColor(2131427568));
      ((View)localObject).setContentDescription(getString(2131367936) + str);
      label290:
      ((View)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setClickable(true);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
      ((View)localObject).setBackgroundResource(2130838355);
      str = this.q;
      a((View)localObject, str, false);
      if (TextUtils.isEmpty(str)) {
        break label540;
      }
      a((View)localObject, false, true, 0, getResources().getColor(2131427568));
      ((View)localObject).setContentDescription(getString(2131367937) + str);
    }
    for (;;)
    {
      ((View)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setClickable(true);
      if (this.o == 1)
      {
        this.jdField_d_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
          i1 = 3;
        }
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
      }
      return;
      ((TextView)localObject).setVisibility(8);
      break;
      label439:
      ((View)localObject).setContentDescription(getString(2131367935) + getString(2131365073));
      break label204;
      label476:
      a((View)localObject, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
      ((View)localObject).setContentDescription(getString(2131367936) + getString(2131365073));
      break label290;
      label540:
      a((View)localObject, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
      ((View)localObject).setContentDescription(getString(2131367937) + getString(2131365073));
    }
  }
  
  protected int a(TroopInfo paramTroopInfo, String paramString)
  {
    int i2 = 1;
    int i1 = i2;
    if (paramTroopInfo != null)
    {
      if ((paramTroopInfo.troopowneruin == null) || (!paramTroopInfo.troopowneruin.equalsIgnoreCase(paramString))) {
        break label32;
      }
      i1 = 3;
    }
    label32:
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (paramTroopInfo.Administrator == null);
      i1 = i2;
    } while (!paramTroopInfo.Administrator.contains(paramString));
    return 2;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i2 = 0;
    if (paramBitmap == null)
    {
      paramBitmap = null;
      return paramBitmap;
    }
    int i5 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    int i3 = getResources().getDimensionPixelSize(2131493177);
    int i1 = i3;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i1 = i3 + ImmersiveUtils.a(getApplicationContext());
    }
    i3 = paramBitmap.getHeight();
    int i4 = paramBitmap.getWidth();
    if (i4 * i1 > i3 * i5)
    {
      i5 = i5 * i3 / i1;
      i2 = (i4 - i5) / 2;
      i1 = 0;
      i4 = i5;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i2, i1, i4, i3);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 4, "is bitmap mutable: " + localBitmap.isMutable());
      }
      paramBitmap = localBitmap;
      if (localBitmap.isMutable()) {
        break;
      }
      paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, true);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return paramBitmap;
      i5 = i1 * i4 / i5;
      i1 = (i3 - i5) / 2;
      i3 = i5;
    }
  }
  
  protected View a(int paramInt)
  {
    View localView;
    if ((this.K == 5) && (paramInt != 2)) {
      localView = LayoutInflater.from(this).inflate(2130905070, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    }
    for (;;)
    {
      localView.setTag(new TroopMemberCardActivity.ViewHolder(localView, paramInt));
      return localView;
      if ((this.K == 5) && (paramInt == 2)) {
        localView = LayoutInflater.from(this).inflate(2130905071, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      } else {
        localView = LayoutInflater.from(this).inflate(2130905073, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      }
    }
  }
  
  public MessageRecord a()
  {
    if ((jdField_a_of_type_ArrayOfInt != null) && (jdField_a_of_type_ArrayOfInt.length > 0))
    {
      localObject = new StringBuilder();
      int i1 = 0;
      while (i1 < jdField_a_of_type_ArrayOfInt.length)
      {
        ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfInt[i1]);
        if (i1 < jdField_a_of_type_ArrayOfInt.length - 1) {
          ((StringBuilder)localObject).append(" , ");
        }
        i1 += 1;
      }
    }
    for (Object localObject = ((StringBuilder)localObject).toString();; localObject = null)
    {
      EntityManager localEntityManager = this.app.a().createEntityManager();
      localObject = localEntityManager.a(MessageRecord.class, MessageRecord.getTableName(this.t, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", new Object[] { Long.valueOf(Long.MAX_VALUE), localObject }), new String[] { this.v }, null, null, "shmsgseq DESC", String.valueOf(1));
      localEntityManager.a();
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        return null;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
  }
  
  protected String a()
  {
    boolean bool = TroopMemberLbsHelper.a(this.t, this.app).booleanValue();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance != -1L)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance >= 0L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance >= 10L) {
            break label73;
          }
          localObject1 = "0.01km";
        }
      }
    }
    return (String)localObject1;
    label73:
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance < 10000L)
    {
      localObject1 = new DecimalFormat("0.00");
      return ((DecimalFormat)localObject1).format(Math.round(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance / 10.0D) * 0.01D) + "km";
    }
    return String.valueOf(Math.round(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.distance / 1000.0D)) + "km";
  }
  
  public String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt1 == 0)
    {
      localStringBuilder.append(getString(2131368209));
      localStringBuilder.append("  ");
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(getString(2131368211));
        localStringBuilder.append("  ");
      }
      localObject = null;
      if (TextUtils.isEmpty(paramString2)) {
        break label166;
      }
    }
    for (;;)
    {
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() > 5) {
          paramString1 = paramString2.substring(0, 4) + "…";
        }
        localStringBuilder.append(paramString1);
      }
      return localStringBuilder.toString();
      if (paramInt1 != 1) {
        break;
      }
      localStringBuilder.append(getString(2131368210));
      localStringBuilder.append("  ");
      break;
      label166:
      paramString2 = (String)localObject;
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2 = paramString1;
      }
    }
  }
  
  public String a(long paramLong)
  {
    if (paramLong == 1L) {
      return "";
    }
    if (paramLong > 0L) {
      try
      {
        String str = DateFormat.format(getString(2131369057), 1000L * paramLong).toString();
        return str;
      }
      catch (Exception localException)
      {
        return "";
      }
    }
    return getString(2131369058);
  }
  
  protected String a(String paramString1, String paramString2)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        if (this.o == 0)
        {
          paramString1 = this.app.b();
          localObject1 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            localObject1 = paramString2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, nick=" + (String)localObject1);
          break;
        }
        Object localObject2 = (FriendsManager)this.app.getManager(50);
        localObject1 = (TroopManager)this.app.getManager(51);
        localObject2 = ((FriendsManager)localObject2).a(paramString2);
        TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject1).a(paramString1, paramString2);
        if (localObject2 == null) {
          break label341;
        }
        if (((Friends)localObject2).isFriend())
        {
          localObject1 = ((Friends)localObject2).remark;
          paramString1 = (String)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramString1 = ((Friends)localObject2).name;
          }
          localObject1 = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, Friends!=null, remark=" + ((Friends)localObject2).remark + " name=" + ((Friends)localObject2).name);
            localObject1 = paramString1;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (localTroopMemberInfo != null)
            {
              paramString1 = localTroopMemberInfo.friendnick;
              localObject2 = paramString1;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, TroopMemberInfo!=null, friendnick=" + localTroopMemberInfo.friendnick);
                localObject2 = paramString1;
              }
            }
          }
          paramString1 = (String)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          paramString1 = (String)localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
            continue;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
          paramString1 = (String)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "getNickName, mFriendCard!=null, strNick=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
          paramString1 = (String)localObject1;
          continue;
        }
        localObject1 = "";
      }
      catch (Exception paramString1)
      {
        return paramString2;
      }
      continue;
      label341:
      localObject1 = "";
    }
    return (String)localObject1;
  }
  
  protected void a()
  {
    if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity)) {}
    do
    {
      return;
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.v);
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.t, this.u, localArrayList);
        if (this.K != 5) {
          break;
        }
        this.Q = 2;
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.t), Long.parseLong(this.v));
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
    return;
    this.Q = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.v, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.t), Long.parseLong(this.v));
    startTitleProgress();
  }
  
  public void a(int paramInt)
  {
    if ((this.K == 1) || (this.L == 1) || (this.K == 7))
    {
      int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperationFlag", i1 | paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.v);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected void a(int paramInt, LinearLayout paramLinearLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {}
    for (TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t);; localTroopInfo = null)
    {
      String str;
      switch (paramInt)
      {
      default: 
        return;
      case 2: 
        a((Button)paramLinearLayout.getChildAt(0), 3, 2131369990, 2131362022);
        if (this.jdField_d_of_type_Boolean)
        {
          str = "";
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
          }
          if (!TextUtils.isEmpty(str)) {
            break label457;
          }
          str = this.w;
        }
        break;
      }
      label454:
      label457:
      for (;;)
      {
        if ((localTroopInfo != null) && (TroopInfo.hasPayPrivilege(localTroopInfo.troopPrivilegeFlag, 32))) {
          a((Button)paramLinearLayout.getChildAt(1), 7, 2131365079, 2131365079);
        }
        for (;;)
        {
          a((Button)paramLinearLayout.getChildAt(2), 4, 2131367902, 2131362023);
          paramLinearLayout.setVisibility(0);
          return;
          a((Button)paramLinearLayout.getChildAt(1), 6, 2131365077, getString(2131365078, new Object[] { str }));
          continue;
          a((Button)paramLinearLayout.getChildAt(1), 5, 2131370025, 2131362027);
        }
        paramLinearLayout.getChildAt(1).setVisibility(8);
        if (this.jdField_d_of_type_Boolean)
        {
          str = "";
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
          }
          if (!TextUtils.isEmpty(str)) {
            break label454;
          }
          str = this.w;
        }
        for (;;)
        {
          if ((localTroopInfo != null) && (TroopInfo.hasPayPrivilege(localTroopInfo.troopPrivilegeFlag, 32))) {
            a((Button)paramLinearLayout.getChildAt(0), 7, 2131365079, 2131365079);
          }
          for (;;)
          {
            a((Button)paramLinearLayout.getChildAt(2), 4, 2131367902, 2131362023);
            paramLinearLayout.setVisibility(0);
            return;
            a((Button)paramLinearLayout.getChildAt(0), 6, 2131365077, getString(2131365078, new Object[] { str }));
            continue;
            a((Button)paramLinearLayout.getChildAt(0), 5, 2131370025, 2131362027);
          }
          paramLinearLayout.getChildAt(0).setVisibility(8);
          paramLinearLayout.getChildAt(1).setVisibility(8);
          a((Button)paramLinearLayout.getChildAt(2), 3, 2131369990, 2131362022);
          paramLinearLayout.setVisibility(0);
          return;
          paramLinearLayout.setVisibility(8);
          return;
        }
      }
    }
  }
  
  public void a(int paramInt, TroopMemberCard paramTroopMemberCard)
  {
    if (paramTroopMemberCard == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: cardInfo==null, ");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: uint32_result:" + paramTroopMemberCard.result + " memberRole:" + paramTroopMemberCard.memberRole);
      }
    } while ((paramTroopMemberCard.result != 0) && (paramTroopMemberCard.memberRole != 0));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mQzoneFeed)) {
      paramTroopMemberCard.mQzoneFeed = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mQzoneFeed;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied)) {
      paramTroopMemberCard.mRecentSaied = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRichSignStatus != null) {
      paramTroopMemberCard.mRichSignStatus = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRichSignStatus;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = paramTroopMemberCard;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t, this.v, paramTroopMemberCard);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, TroopManager.saveTroopMemberCard");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "updateParams, server level name:" + paramTroopMemberCard.levelName);
    }
    this.w = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
    if (TextUtils.isEmpty(this.w)) {
      this.w = this.v;
    }
    this.M = paramInt;
    this.A = a(paramTroopMemberCard.joinTime);
    this.B = a(paramTroopMemberCard.sex, paramTroopMemberCard.age, paramTroopMemberCard.location, "");
    f();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    View localView = a(paramInt);
    localView.setContentDescription(paramString1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt] = localView;
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((localView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      if (!paramBoolean) {
        break label99;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      return;
      label99:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setClickable(false);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong2));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramInt, paramLong1, localArrayList);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    if (this.K == 5)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837958);
      return;
    }
    ChatSettingForTroop.b(this, this.jdField_b_of_type_AndroidViewView, paramBitmap);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    if (this.K == 5)
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837958);
      return;
    }
    paramDrawable = ImageUtil.a(paramDrawable);
    ChatSettingForTroop.b(this, this.jdField_b_of_type_AndroidViewView, paramDrawable);
  }
  
  public void a(View paramView, RichStatus paramRichStatus)
  {
    SpannableString localSpannableString = paramRichStatus.toSpannableString(null);
    if (TextUtils.isEmpty(localSpannableString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "onUpdateStrangerRichStatus s = empty--------");
      }
      return;
    }
    TroopMemberCardActivity.ViewHolder localViewHolder = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
    TextView localTextView = localViewHolder.jdField_c_of_type_AndroidWidgetTextView;
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
      localSpannableStringBuilder.insert(0, "[S] ");
      StatusManager localStatusManager = (StatusManager)this.app.getManager(14);
      if (localStatusManager != null)
      {
        paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int i1 = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, i1, i1);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        localSpannableStringBuilder.setSpan(paramRichStatus, 0, "[S]".length(), 17);
        localTextView.setText(localSpannableStringBuilder);
        label188:
        paramView.setVisibility(0);
        paramView.setContentDescription(getString(2131367713) + localSpannableString);
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) && (this.o != 0)) {
          break label350;
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "onUpdateStrangerRichStatus s = " + localSpannableString);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) && (this.jdField_a_of_type_ArrayOfAndroidViewView[9] != null)) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[9].setVisibility(8);
      }
      g("exp_signature");
      return;
      paramRichStatus = BitmapManager.a(getResources(), 2130842868);
      break;
      localTextView.setText(localSpannableString);
      break label188;
      label350:
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.setOnClickListener(null);
    }
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    TroopMemberCardActivity.ViewHolder localViewHolder;
    if ((paramView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      localViewHolder = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
      if (TextUtils.isEmpty(paramString)) {
        break label54;
      }
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
    while (paramBoolean)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setClickable(true);
      return;
      label54:
      localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131365073));
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramView.setClickable(false);
  }
  
  protected void a(View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if ((paramView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      paramView = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
      if (paramBoolean1) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt1);
      }
      if (paramBoolean2) {
        paramView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt2);
      }
    }
  }
  
  protected void a(View paramView, boolean paramBoolean1, boolean paramBoolean2, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    if ((paramView.getTag() instanceof TroopMemberCardActivity.ViewHolder))
    {
      paramView = (TroopMemberCardActivity.ViewHolder)paramView.getTag();
      if (paramBoolean1) {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList1);
      }
      if (paramBoolean2) {
        paramView.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList2);
      }
    }
  }
  
  protected void a(Button paramButton, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramButton, paramInt1, paramInt2, getString(paramInt3));
  }
  
  protected void a(Button paramButton, int paramInt1, int paramInt2, String paramString)
  {
    if (paramButton != null)
    {
      paramButton.setVisibility(0);
      paramButton.setTag(Integer.valueOf(paramInt1));
      paramButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      paramButton.setContentDescription(paramString);
      paramButton.setText(paramInt2);
    }
  }
  
  protected void a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    TroopRankColorConfig localTroopRankColorConfig = TroopRankColorConfig.a();
    int i1 = -1;
    if (paramInt1 == 2) {
      paramInt2 = localTroopRankColorConfig.jdField_b_of_type_Int;
    }
    for (;;)
    {
      paramTextView.setBackgroundDrawable(TroopUtils.a(getResources(), paramInt2));
      paramTextView.setPadding(10, 2, 10, 2);
      return;
      if (paramInt1 == 3)
      {
        paramInt2 = localTroopRankColorConfig.jdField_a_of_type_Int;
      }
      else if (paramInt1 == 4)
      {
        paramInt2 = localTroopRankColorConfig.c;
      }
      else if (paramInt1 == 1)
      {
        paramInt2 = localTroopRankColorConfig.a(paramInt2);
      }
      else
      {
        paramInt2 = i1;
        if (paramInt1 == 0) {
          paramInt2 = 0;
        }
      }
    }
  }
  
  protected void a(TextView paramTextView, ImageView paramImageView, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramInt + ", " + paramBoolean3);
        }
        if ((paramBoolean1) || (paramBoolean2) || (this.o == 0)) {
          break label604;
        }
        return;
      }
      catch (Exception paramTextView)
      {
        String str2;
        LinearLayout.LayoutParams localLayoutParams;
        if (!QLog.isColorLevel()) {
          break label603;
        }
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq:" + paramTextView.toString());
        return;
        String str1 = "http://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_svip_" + i1 + ".png";
        continue;
        float f1 = this.jdField_a_of_type_Float * 57.0F;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        if (!paramBoolean3) {
          continue;
        }
        str1 = "http://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_vip_annual_" + i1 + ".png";
        Object localObject = new ColorDrawable(0);
        localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
        paramInt = (int)(this.jdField_a_of_type_Float * 24.0F);
        if (!paramBoolean3) {
          continue;
        }
        f1 = this.jdField_a_of_type_Float * 60.0F;
        i1 = (int)f1;
        ((Drawable)localObject).setBounds(0, 0, i1, paramInt);
        localLayoutParams.width = i1;
        localLayoutParams.height = paramInt;
        continue;
        str1 = "http://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_vip_" + i1 + ".png";
        continue;
        f1 = this.jdField_a_of_type_Float * 50.0F;
        continue;
        str1 = str2;
        if (this.o != 0) {
          continue;
        }
        localObject = getResources().getDrawable(2130841083);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        localLayoutParams.width = ((Drawable)localObject).getIntrinsicWidth();
        localLayoutParams.height = ((Drawable)localObject).getIntrinsicHeight();
        str1 = str2;
        continue;
        paramImageView.setVisibility(8);
        continue;
      }
      localObject = null;
      str2 = "";
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (paramBoolean1) {
        if (paramBoolean3)
        {
          str1 = "http://i.gtimg.cn/club/mobile/profile/iconnew/qvip_profile_svip_annual_" + i1 + ".png";
          localObject = new ColorDrawable(0);
          localObject = URLDrawable.getDrawable(str1, (Drawable)localObject, (Drawable)localObject);
          paramInt = (int)(this.jdField_a_of_type_Float * 26.0F);
          if (!paramBoolean3) {
            continue;
          }
          f1 = this.jdField_a_of_type_Float * 66.0F;
          i1 = (int)f1;
          localLayoutParams.width = i1;
          localLayoutParams.height = paramInt;
          ((Drawable)localObject).setBounds(0, 0, i1, paramInt);
          if (localObject == null) {
            continue;
          }
          paramImageView.setImageDrawable((Drawable)localObject);
          paramImageView.setLayoutParams(localLayoutParams);
          paramImageView.setVisibility(0);
          paramTextView.setText(paramString);
          if (!QLog.isColorLevel()) {
            break label603;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "showVipAndSqq: url" + str1);
        }
      }
      label603:
      return;
      label604:
      int i1 = paramInt;
      if (paramInt < 1) {
        i1 = 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.a(new mtr(this, paramQQAppInterface, paramString), 8, null, true);
  }
  
  public void a(String paramString)
  {
    if (isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString, TextView paramTextView)
  {
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.C = new String(paramString);
    int i2 = paramString.length();
    Object localObject = (OlympicManager)this.app.getManager(166);
    boolean bool1;
    boolean bool2;
    int i3;
    if ((((OlympicManager)localObject).a(this.v)) && (((OlympicManager)localObject).b("MCard")))
    {
      bool1 = true;
      bool2 = bool1;
      if (this.o == 0) {
        bool2 = bool1 & ((OlympicManager)localObject).a("olympic_flag_setting", true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troopQ.profilecard.TroopMemberCardActivity", 2, "hasTorch:" + bool2 + " nickName:" + paramString + " length:" + i2);
      }
      if (!bool2) {
        break label652;
      }
      paramString = paramString + "  ";
      localObject = paramString + "[torch]";
      i3 = ((String)localObject).length();
      i1 = i3;
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d(".troopQ.profilecard.TroopMemberCardActivity", 2, "after append Torch Flag olympicNickLength:" + i3 + " nickName:" + (String)localObject + " length:" + i2);
        paramString = (String)localObject;
      }
    }
    label328:
    label652:
    for (int i1 = i3;; i1 = i2)
    {
      bool1 = bool3;
      if (!TextUtils.isEmpty(this.h.getText().toString())) {
        bool1 = true;
      }
      if (bool1)
      {
        paramString = new SpannableString(paramString + "\n" + "[icon]");
        if (QLog.isColorLevel()) {
          QLog.d(".troopQ.profilecard.TroopMemberCardActivity", 2, "SpannableString:" + paramString + " needTag:" + bool1 + " length:" + paramString.length());
        }
        if (bool2)
        {
          paramString.setSpan(new mtx(this, 2130840986), i2 + 2, i1, 33);
          paramString.setSpan(new mtw(this), i2 + 2, i1, 33);
          OlympicUtil.a(this.app, "0X800688F", 3, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberUin));
        }
        if (bool1) {
          switch (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
          {
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troopQ.profilecard.TroopMemberCardActivity", 2, "SpannableString:" + paramString + " length:" + paramString.length());
        }
        paramTextView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        paramTextView.setText(paramString);
        paramTextView.setContentDescription("群名称：" + this.C);
        paramTextView.setMovementMethod(TroopMemberCardActivity.ClickableMovementMethod.a());
        return;
        bool1 = false;
        break;
        paramString = new SpannableString(paramString);
        break label328;
        localObject = a(this.jdField_e_of_type_AndroidViewView.findViewById(2131305196));
        if (localObject != null) {
          paramString.setSpan(new ImageSpan(this, (Bitmap)localObject), i1 + 1, paramString.length(), 33);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield) {
        i1 = 2;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369588, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369584, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131369591, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.e(i1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.aj = 1;
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
      paramString1 = "";
    }
    ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramString3, paramString1, paramString2, 1101);
  }
  
  protected void a(List paramList)
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: customItemList==null or size==0, return");
      }
      return;
    }
    int i2 = paramList.size();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initCustomItems: size=" + i2);
    }
    Object localObject = (TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130905075, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    ((TextView)localObject).setText(2131369403);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (TroopMemberCard.CustomEntry)paramList.get(i1);
      View localView = a(i1);
      TroopMemberCardActivity.ViewHolder localViewHolder = (TroopMemberCardActivity.ViewHolder)localView.getTag();
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).label)) {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopMemberCard.CustomEntry)localObject).label);
      }
      if (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).info)) {
        localViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((TroopMemberCard.CustomEntry)localObject).info);
      }
      if ((((TroopMemberCard.CustomEntry)localObject).isClickable) && (!TextUtils.isEmpty(((TroopMemberCard.CustomEntry)localObject).linkUrl)))
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localView.setClickable(true);
        label244:
        if (i2 != 1) {
          break label292;
        }
        localView.setBackgroundResource(2130838349);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
        i1 += 1;
        break;
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localView.setClickable(false);
        break label244;
        label292:
        if (i1 == 0) {
          localView.setBackgroundResource(2130838357);
        } else if (i1 == i2 - 1) {
          localView.setBackgroundResource(2130838352);
        } else {
          localView.setBackgroundResource(2130838355);
        }
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a()
  {
    if (ClubContentJsonTask.a == null) {
      ThreadManager.a(new mst(this), 5, null, true);
    }
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301082);
    if (this.K == 5)
    {
      q();
      l();
      f();
      if (this.L != 6) {
        a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = ((TroopPluginManager)this.app.getManager(118)).a("troop_member_card_plugin.apk", new mti(this));
      g("exp");
      return true;
      i();
      l();
      f();
      a();
    }
  }
  
  public boolean a(View paramView, List paramList, String paramString)
  {
    paramView.setVisibility(8);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ((TextView)paramView.findViewById(2131305168)).setText(paramString);
    paramString = (LinearLayout)paramView.findViewById(2131305206);
    paramString.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initTroopBar: troopBarList==null or size==0, return");
      }
      if (this.o == 0)
      {
        paramView.setVisibility(0);
        paramList = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        if (paramList != null) {
          paramList.height = getResources().getDimensionPixelSize(2131493178);
        }
        for (;;)
        {
          return true;
          paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131493178)));
        }
      }
      return false;
    }
    Object localObject1 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    int i4;
    int i5;
    int i6;
    int i7;
    int i1;
    if (localObject1 != null)
    {
      ((LinearLayout.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131493176);
      i4 = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 70.0F);
      i5 = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 50.0F);
      i6 = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 5.0F);
      i7 = paramString.getMeasuredWidth();
      i1 = paramList.size();
      if (i1 <= 4) {
        break label738;
      }
      i1 = 4;
    }
    label486:
    label738:
    for (;;)
    {
      int i2 = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 10.0F);
      localObject1 = new StringBuffer("initTroopBar");
      int i3 = 0;
      if ((i3 >= i1) || (i2 + i4 > i7))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, ((StringBuffer)localObject1).toString());
        }
        paramView.setVisibility(0);
        return true;
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131493176)));
        break;
      }
      TroopMemberCardActivity.Info localInfo = (TroopMemberCardActivity.Info)paramList.get(i3);
      String str = localInfo.jdField_a_of_type_JavaLangString;
      Object localObject2 = LayoutInflater.from(this).inflate(2130903920, null);
      if (i3 != 0) {
        new LinearLayout.LayoutParams((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 70.0F), -2).leftMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 15.0F));
      }
      ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131296303);
      Object localObject3 = (TextView)((View)localObject2).findViewById(2131296829);
      if (localInfo.jdField_b_of_type_JavaLangString != null)
      {
        if (localInfo.jdField_b_of_type_JavaLangString.length() > 5) {
          localInfo.jdField_b_of_type_JavaLangString = (localInfo.jdField_b_of_type_JavaLangString.substring(0, 4) + "…");
        }
        ((TextView)localObject3).setText(localInfo.jdField_b_of_type_JavaLangString);
        paramString.addView((View)localObject2);
      }
      for (;;)
      {
        try
        {
          this.jdField_c_of_type_Boolean = false;
          if ((str != null) && (localInfo.jdField_b_of_type_Int == 2))
          {
            localObject2 = URLDrawable.getDrawable(str, i5, i5, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false);
            if (((URLDrawable)localObject2).getStatus() != 1) {
              continue;
            }
            localObject2 = ImageUtil.a((Drawable)localObject2);
            if (localObject2 != null)
            {
              localObject3 = ImageUtil.b((Bitmap)localObject2, (int)DisplayUtils.a(getApplicationContext(), 5.0F), i5, i5);
              if (localObject3 != null)
              {
                localImageView.setImageBitmap((Bitmap)localObject3);
                this.jdField_c_of_type_Boolean = true;
              }
              ((Bitmap)localObject2).recycle();
            }
          }
          if ((!this.jdField_c_of_type_Boolean) && (localInfo.jdField_b_of_type_Int == 2)) {
            localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, localException.toString());
          continue;
        }
        if (QLog.isColorLevel()) {
          ((StringBuffer)localObject1).append(", addBar:" + str);
        }
        i3 += 1;
        i2 += i4 + i6;
        break;
        ((TextView)localObject3).setVisibility(8);
        break label486;
        ((URLDrawable)localObject2).setURLDrawableListener(new msj(this, i5, localImageView));
        localImageView.setImageDrawable((Drawable)localObject2);
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.app, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.isTroopFollowed;
    }
    return false;
  }
  
  public String b()
  {
    String str = "";
    if (this.M == 3) {
      str = "0";
    }
    do
    {
      return str;
      if (this.M == 2) {
        return "1";
      }
    } while (this.M != 1);
    return "2";
  }
  
  public String b(String paramString1, String paramString2)
  {
    return ContactUtils.g(this.app, paramString1, paramString2);
  }
  
  protected void b()
  {
    boolean bool = false;
    if ((this.K == 5) && (this.L == 6))
    {
      localObject1 = getIntent().getBundleExtra("params");
      this.u = ((Bundle)localObject1).getString("troopcode");
      this.p = ((Bundle)localObject1).getString("tel");
      this.q = ((Bundle)localObject1).getString("email");
      this.r = ((Bundle)localObject1).getString("job");
      this.w = ((Bundle)localObject1).getString("nick");
      this.x = ((Bundle)localObject1).getString("troopnick");
      localObject1 = ((Bundle)localObject1).getString("sex");
      if (((String)localObject1).equals("0")) {
        this.y = getString(2131368209);
      }
      for (;;)
      {
        if (TextUtils.getTrimmedLength(this.p) <= 0) {
          this.p = "";
        }
        if (TextUtils.getTrimmedLength(this.q) <= 0) {
          this.q = "";
        }
        if (TextUtils.getTrimmedLength(this.r) <= 0) {
          this.r = "";
        }
        localObject1 = (FriendsManager)this.app.getManager(50);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendsManager)localObject1).b(this.v);
        return;
        if (((String)localObject1).equals("1")) {
          this.y = getString(2131368210);
        }
      }
    }
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t);
    TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.app, this.t, this.v);
    if (localTroopMemberInfo != null) {
      this.J = localTroopMemberInfo.mGlamourLevel;
    }
    if (localObject2 != null)
    {
      this.s = ((TroopInfo)localObject2).troopname;
      this.u = ((TroopInfo)localObject2).troopcode;
      QLog.i("Q.profilecard.TroopMemberCardActivity", 1, "initParams: troopInfo != null, troopCode:" + this.u + ", mTroopName:" + this.s);
    }
    TroopMemberCard localTroopMemberCard = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t, this.v);
    if (localTroopMemberCard != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: cacheCard != null");
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard = localTroopMemberCard;
      this.w = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      this.M = a((TroopInfo)localObject2, this.app.a());
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendsManager)localObject1).b(this.v);
      this.A = a(localTroopMemberCard.joinTime);
      this.B = a(localTroopMemberCard.sex, localTroopMemberCard.age, localTroopMemberCard.location, "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = ((FriendsManager)localObject1).a(this.v);
    }
    this.w = a(this.t, this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberUin = Long.parseLong(this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend = ((FriendsManager)localObject1).b(this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = a(this.t, this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield = b(this.t, this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = b(this.t, this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isAllowModCard = true;
    this.M = a((TroopInfo)localObject2, this.app.a());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = a((TroopInfo)localObject2, this.v);
    int i2;
    int i1;
    if (localTroopMemberInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: troopMemberInfo != null");
      }
      if (localTroopMemberInfo.join_time != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.joinTime = localTroopMemberInfo.join_time;
        this.A = a(localTroopMemberInfo.join_time);
      }
    }
    else
    {
      localObject2 = "";
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label959;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "initParams: mFriendCard != null");
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender;
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.age;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex = i2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.age = i1;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location = ((String)localObject1);
        label780:
        this.B = a(i2, i1, (String)localObject2, (String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip = this.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip = this.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperQQ = this.jdField_a_of_type_ComTencentMobileqqDataCard.isVipOpen(EVIPSPEC.E_SP_SUPERQQ);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip) {
          break label929;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = this.jdField_a_of_type_ComTencentMobileqqDataCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipType == 1) {
          bool = true;
        }
        ((TroopMemberCard)localObject1).isYearVip = bool;
        return;
        this.A = "";
        break;
        if (localObject2 == null) {
          break label780;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location = ((String)localObject2);
        break label780;
        label929:
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel = this.jdField_a_of_type_ComTencentMobileqqDataCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        }
      }
      label959:
      i2 = -1;
      i1 = 0;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView instanceof DynamicAvatarView))
    {
      DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)this.jdField_b_of_type_AndroidWidgetImageView;
      localDynamicAvatarView.setFaceDrawable(this.app, 1, paramString, 200, true, true, 5);
      paramString = localDynamicAvatarView.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramString != null)
      {
        if (this.K == 5) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837958);
        }
      }
      else {
        return;
      }
      paramString = ImageUtil.a(paramString);
      ChatSettingForTroop.b(this, this.jdField_b_of_type_AndroidViewView, paramString);
      return;
    }
    a(ImageUtil.a());
    ThreadManager.a(new mtd(this, paramString), 5, null, true);
  }
  
  public void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", paramString1);
    localIntent.putExtra("member_uin", paramString2);
    localIntent.putExtra("member_is_shield", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield);
    TroopMemberCardProxyActivity.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, localIntent, "com.tencent.mobileqq.memcard.plugin.RecentSaidActivity", 0);
  }
  
  protected void b(String paramString1, String paramString2, String paramString3)
  {
    String str3 = b();
    String str1 = "";
    if (this.o == 0) {
      str1 = "0";
    }
    for (;;)
    {
      String str2 = "";
      if (paramString2 != null) {
        str2 = paramString2;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport, actionName:" + paramString1 + " reportId:" + paramString2);
        }
        ReportController.b(this.app, paramString3, "Grp_mber", "", "mber_card", paramString1, 0, 0, this.t, str3, str1, str2);
        return;
      }
      catch (Exception paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doReport:" + paramString1.toString());
      }
      if (this.o == 1) {
        str1 = "1";
      }
    }
  }
  
  public boolean b()
  {
    Object localObject = getIntent();
    this.t = ((Intent)localObject).getStringExtra("troopUin");
    this.v = ((Intent)localObject).getStringExtra("memberUin");
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberUin = Long.parseLong(this.v);
        this.K = ((Intent)localObject).getIntExtra("fromFlag", 0);
        if (this.K == 8) {
          this.z = ((Intent)localObject).getStringExtra("callback");
        }
        if (this.K == 4) {
          ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent", "Clk_name", 0, 0, this.t, "", "", "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "checkIntentParams:" + this.t + "," + this.v + "," + this.K);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(51));
        localObject = null;
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null)
        {
          TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t);
          localObject = localTroopInfo;
          if (localTroopInfo != null)
          {
            this.jdField_b_of_type_Long = localTroopInfo.dwOfficeMode;
            this.jdField_c_of_type_Long = localTroopInfo.dwGroupClassExt;
            localObject = localTroopInfo;
          }
        }
        if ((localObject != null) && (((TroopInfo)localObject).hasOrgs()))
        {
          i1 = 1;
          if (((TroopUtils.a(Long.toString(this.jdField_c_of_type_Long))) && (this.jdField_b_of_type_Long == 1L) && (i1 == 0)) || (this.K == 6))
          {
            this.L = this.K;
            this.K = 5;
            ReportController.b(this.app, "CliOper", "", "", "0X80054B1", "0X80054B1", 0, 0, "", "", "", "");
          }
          if ((!TextUtils.isEmpty(this.t)) && (!TextUtils.isEmpty(this.v)) && (!TextUtils.isEmpty(this.app.a()))) {
            break;
          }
          return false;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.TroopMemberCardActivity", 2, "NumberFormatException, mMemberUin:" + this.v);
        }
        return false;
      }
      int i1 = 0;
    }
    if (this.v.equals(this.app.a()))
    {
      this.o = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
      b();
      if (this.K != 5) {
        break label527;
      }
      if (this.L != 6)
      {
        this.app.registObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver);
        addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      }
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(ImageUtil.a());
      return true;
      this.o = 1;
      break;
      label527:
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    paramString1 = DBUtils.a().a(this.app, paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.mIsShielded;
    }
    return false;
  }
  
  public String c()
  {
    String str = this.w;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card)) {
        str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
      }
    }
    else {
      return str;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
    if (!TextUtils.isEmpty(this.r))
    {
      localView.setContentDescription(getString(2131367935) + this.r);
      a(localView, this.r, false);
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
      a(localView, this.p, false);
      if (TextUtils.isEmpty(this.p)) {
        break label248;
      }
      a(localView, false, true, 0, getResources().getColor(2131427568));
      localView.setContentDescription(getString(2131367936) + this.p);
    }
    for (;;)
    {
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
      a(localView, this.q, false);
      if (TextUtils.isEmpty(this.q)) {
        break label312;
      }
      a(localView, false, true, 0, getResources().getColor(2131427568));
      localView.setContentDescription(getString(2131367937) + this.q);
      return;
      localView.setContentDescription(getString(2131367935) + getString(2131365073));
      break;
      label248:
      a(localView, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
      localView.setContentDescription(getString(2131367936) + getString(2131365073));
    }
    label312:
    a(localView, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
    localView.setContentDescription(getString(2131367937) + getString(2131365073));
  }
  
  public void c(String paramString)
  {
    ThreadManager.a(new mtf(this, paramString), 8, null, true);
  }
  
  protected void c(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("member_uin", paramString2);
    localIntent.putExtra("from_troop_card", true);
    startActivityForResult(localIntent, 6);
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) {
      bool = false;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return bool;
  }
  
  public String d()
  {
    String str2 = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    int i1 = str2.lastIndexOf("[icon]");
    String str1 = str2;
    if (i1 != -1)
    {
      str1 = str2;
      if ("[icon]".length() + i1 == str2.length()) {
        str1 = str2.substring(0, i1);
      }
    }
    return str1.trim();
  }
  
  public void d()
  {
    if ((this.J > -1) && (this.jdField_a_of_type_ArrayOfAndroidViewView[10] != null))
    {
      int i1 = AIOUtils.a(20.0F, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getResources());
      Drawable localDrawable = TroopMemberCharmUtils.a(this.J, 2);
      localDrawable.setBounds(0, 0, i1, i1);
      ((TroopMemberCardActivity.ViewHolder)this.jdField_a_of_type_ArrayOfAndroidViewView[10].getTag()).jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[10].setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[10].setVisibility(8);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage:" + paramString);
    }
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "openCustomItemPage, checkClickTime: false");
      }
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    startActivity(localIntent);
  }
  
  public void d(String paramString1, String paramString2)
  {
    b(paramString1, null, paramString2);
  }
  
  public boolean d()
  {
    if (!NetworkUtil.e(getApplication().getApplicationContext()))
    {
      a(getString(2131369008));
      return false;
    }
    return true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    boolean bool1 = false;
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 8: 
    case 9: 
    case 10: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    e();
                    a(2);
                  } while (!QLog.isColorLevel());
                  QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SET_TROOP_NICK");
                  return;
                  if (paramIntent != null) {
                    bool1 = paramIntent.getBooleanExtra("changed", false);
                  }
                  if (bool1) {
                    a(2);
                  }
                } while (!QLog.isColorLevel());
                QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_SHOW_PERSONAL_CARD, isChanged:" + bool1);
                return;
              } while (!QLog.isColorLevel());
              QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "doOnActivityResult, REQUEST_CODE_ADDFRIEND");
              return;
            } while (paramIntent == null);
            bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
            boolean bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
            boolean bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
            boolean bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
            boolean bool5 = paramIntent.getBooleanExtra("extra_is_level_modify", false);
            paramIntent = (TroopMemberCard)paramIntent.getSerializableExtra("troopMemberCard");
            if ((bool2) || (bool5)) {
              a(2);
            }
            if (bool3) {
              a(4);
            }
            if (bool1) {
              a(1);
            }
            if (bool4)
            {
              paramIntent = new Intent();
              if (!bool1)
              {
                paramIntent.putExtra("isNeedFinish", bool4);
                setResult(-1, paramIntent);
              }
              for (;;)
              {
                finish();
                return;
                if (this.K == 8)
                {
                  paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
                  paramIntent.putExtra("callback", this.z);
                  setResult(-1, paramIntent);
                }
              }
            }
            if (!bool3)
            {
              paramInt1 = i1;
              if (!bool5) {}
            }
            else
            {
              paramInt1 = 1;
            }
            if (bool3) {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole = paramIntent.memberRole;
            }
            if (bool5)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName = paramIntent.levelName;
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle = paramIntent.mUniqueTitle;
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitleExpire = paramIntent.mUniqueTitleExpire;
            }
            if (bool2)
            {
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned = paramIntent.isConcerned;
              this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield = paramIntent.mIsShield;
            }
          } while (paramInt1 == 0);
          f();
          return;
        } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("isDataChanged", false)));
        startTitleProgress();
        this.Q = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.v, 0, 0);
        return;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("troopmembercardchanged", false)));
      r();
      return;
    }
    paramIntent.putExtra("selfSet_leftViewText", getString(2131367566));
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    this.mNeedStatusTrans = false;
    setContentView(2130905068);
    ThreadManager.a(new mse(this), 8, null, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(null);
    }
    if ((this.h != null) && (this.h.getTag() != null))
    {
      localObject = (Bitmap)this.h.getTag();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    if ((this.i != null) && (this.i.getTag() != null))
    {
      localObject = (Bitmap)this.i.getTag();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t, this.v);
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mQzoneFeed)) {
        ((TroopMemberCard)localObject).mQzoneFeed = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mQzoneFeed;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied)) {
        ((TroopMemberCard)localObject).mRecentSaied = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRichSignStatus != null) {
        ((TroopMemberCard)localObject).mRichSignStatus = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRichSignStatus;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t, this.v, (TroopMemberCard)localObject);
    }
    super.doOnDestroy();
    if (this.K == 5) {
      if (this.L != 6)
      {
        this.app.unRegistObserver(this.jdField_c_of_type_ComTencentMobileqqAppTroopObserver);
        removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      }
    }
    for (;;)
    {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      return;
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
  }
  
  public void e()
  {
    String str2 = b(this.t, this.v);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card = new String(str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = c();
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
    a(str1, this.jdField_d_of_type_AndroidWidgetTextView);
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131367929) + str1);
  }
  
  public void e(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(localIntent);
      }
      startActivity(localIntent);
      this.app.a().b(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X80054B3", "0X80054B3", 0, 0, "", "", "", "");
    }
  }
  
  protected void f()
  {
    int i3 = 3;
    if (this.K == 5)
    {
      r();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        finish();
        return;
      }
      Object localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305182);
      int i1;
      label220:
      label242:
      label524:
      label626:
      label671:
      label693:
      Object localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
      {
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(2131367971);
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getResources().getColor(2131427496));
        ((TextView)localObject2).setCompoundDrawables(null, null, null, null);
        if (this.rightHighLView != null) {
          this.rightHighLView.setVisibility(8);
        }
        if (this.rightViewText != null) {
          this.rightViewText.setVisibility(8);
        }
        g("exp_nonexist");
        i1 = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 0) {
          enableRightHighlight(true);
        }
        if ((((TroopInfo)localObject1).cGroupRankSysFlag != 1) || (((TroopInfo)localObject1).cGroupRankUserFlag != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle))) {
          break label1423;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
          break label1386;
        }
        a(this.h, 2, 0);
        if (localObject1 != null) {
          break label1596;
        }
        a(this.h, 0, 0);
        this.h.setText(null);
        this.h.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305190));
        this.jdField_d_of_type_AndroidWidgetTextView.setMaxLines(4);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(c());
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131367929) + c());
        localObject1 = new TroopMemberCardActivity.ViewHolder(this.jdField_d_of_type_AndroidWidgetTextView, 6);
        this.jdField_d_of_type_AndroidWidgetTextView.setTag(localObject1);
        this.jdField_a_of_type_ArrayOfAndroidViewView[6] = this.jdField_d_of_type_AndroidWidgetTextView;
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305185));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("昵称：%s", new Object[] { this.w }));
        localObject1 = new TroopMemberCardActivity.ViewHolder(this.jdField_e_of_type_AndroidWidgetTextView, 7);
        this.jdField_e_of_type_AndroidWidgetTextView.setTag(localObject1);
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = this.jdField_e_of_type_AndroidWidgetTextView;
        localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305192);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.age <= 0)) {
          break label1667;
        }
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(String.format("%d岁", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.age) }));
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex != 0) {
          break label1632;
        }
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130838637, 0, 0, 0);
        this.g = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305193));
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location)) {
          break label1690;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location.length() > 7) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.location.substring(0, 7) + "...";
        }
        this.g.setText((CharSequence)localObject1);
        this.g.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305194));
        localObject1 = a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1702;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = this.jdField_e_of_type_AndroidViewView.findViewById(2131305191);
        if (i1 == 0) {
          break label1714;
        }
        ((View)localObject1).setVisibility(8);
        localObject1 = super.getString(2131369953) + super.getString(2131368675) + this.w + this.B + this.A;
        this.jdField_e_of_type_AndroidViewView.setContentDescription((CharSequence)localObject1);
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
        a((View)localObject3, this.v, true);
        localObject1 = (TroopMemberCardActivity.ViewHolder)((View)localObject3).getTag();
        ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131305199);
        a(((TroopMemberCardActivity.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView, localImageView, this.v, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isSuperVip) {
          break label1733;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {
          break label1722;
        }
        localObject1 = super.getString(2131365022);
        label860:
        localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131367965);
        label895:
        ((View)localObject3).setContentDescription(super.getString(2131369953) + this.v + (String)localObject1);
        d();
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
          break label1901;
        }
        if (this.o != 1) {
          break label2091;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
          break label1821;
        }
        i1 = 3;
      }
      for (;;)
      {
        label965:
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.customEntryList);
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mRecentSaied;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], (String)localObject1, true);
            this.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(getString(2131364648) + (String)localObject1);
            label1053:
            this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
          }
        }
        for (;;)
        {
          w();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mQzoneFeed;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a(this.jdField_a_of_type_ArrayOfAndroidViewView[8], (String)localObject1, true);
            this.jdField_a_of_type_ArrayOfAndroidViewView[8].setContentDescription(getString(2131369123) + (String)localObject1);
          }
          a(this.app, this.v);
          localObject1 = this.v;
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(new String[] { localObject1 }, false);
          label1162:
          if ((FontSettingManager.a() <= 17.0F) || (((TextView)localObject2).getVisibility() != 0) || (this.g.getVisibility() != 0) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
            break label2077;
          }
          localObject1 = this.jdField_e_of_type_AndroidViewView.findViewById(2131305191);
          localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          return;
          if ((this.o != 0) && ((this.M == 2) || (this.M == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.credit == 1))
          {
            ((TextView)localObject2).setVisibility(0);
            ((TextView)localObject2).setText(2131367972);
            ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getResources().getColor(2131427886));
            localObject3 = (ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams();
            ((ViewGroup.MarginLayoutParams)localObject3).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 20.0F));
            ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getResources().getDrawable(2130840077);
            ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getIntrinsicWidth(), ((Drawable)localObject3).getIntrinsicHeight());
            ((TextView)localObject2).setCompoundDrawables((Drawable)localObject3, null, null, null);
            g("exp_danger");
            i1 = 1;
            break;
          }
          ((TextView)localObject2).setVisibility(8);
          i1 = 0;
          break;
          label1386:
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 3)
          {
            a(this.h, 3, 0);
            break label220;
          }
          a(this.h, 4, 0);
          break label220;
          label1423:
          switch (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
          {
          }
          for (;;)
          {
            localObject1 = null;
            break;
            localObject1 = getResources().getString(2131365067);
            a(this.h, 2, 0);
            break;
            localObject1 = getResources().getString(2131365068);
            a(this.h, 3, 0);
            break;
            if ((((TroopInfo)localObject1).cGroupRankSysFlag == 1) && (((TroopInfo)localObject1).cGroupRankUserFlag == 1))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.t, this.v);
              if (localObject1 == null) {}
              for (int i2 = 0;; i2 = ((TroopMemberInfo)localObject1).level)
              {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName;
                a(this.h, 1, i2);
                break;
              }
              a(this.h, 0, 0);
            }
          }
          label1596:
          this.h.setText(" " + (String)localObject1 + " ");
          break label242;
          label1632:
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex == 1)
          {
            ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130838635, 0, 0, 0);
            break label524;
          }
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label524;
          label1667:
          ((TextView)localObject2).setText("");
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          ((TextView)localObject2).setVisibility(8);
          break label524;
          label1690:
          this.g.setVisibility(8);
          break label626;
          label1702:
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
          break label671;
          label1714:
          ((View)localObject1).setVisibility(0);
          break label693;
          label1722:
          localObject1 = super.getString(2131365023);
          break label860;
          label1733:
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isVip)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isYearVip) {}
            for (localObject1 = super.getString(2131365024);; localObject1 = super.getString(2131365025))
            {
              localObject1 = (String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.vipLevel + super.getString(2131367965);
              break;
            }
          }
          localObject1 = super.getString(2131365026);
          break label895;
          label1821:
          i1 = 2;
          break label965;
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], getString(2131365081), true);
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(getString(2131364648) + getString(2131365081));
          break label1053;
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
        }
        label1901:
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130838352);
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[9] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[9].setVisibility(8);
        }
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[3] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(8);
        }
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[4] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[4].setVisibility(8);
        }
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[8] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[8].setVisibility(8);
        }
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
        }
        if (this.o == 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            i1 = i3;
          }
        }
        for (;;)
        {
          a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
          break label1162;
          label2077:
          break;
          i1 = 1;
          continue;
          i1 = 0;
        }
        label2091:
        i1 = 0;
      }
    }
  }
  
  public void f(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    if ((paramString != null) && (paramString.length() > 0))
    {
      localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString });
      localIntent.setType("message/rfc822");
      Intent.createChooser(localIntent, getResources().getString(2131361796));
    }
    try
    {
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "0X80054B4", "0X80054B4", 0, 0, "", "", "", "");
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      for (;;)
      {
        Toast.makeText(getActivity().getApplicationContext(), 2131361797, 0).show();
      }
    }
  }
  
  public void g()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield)
    {
      a(localView, super.getString(2131369591), true);
      localView.setContentDescription(super.getString(2131369407) + super.getString(2131369591));
    }
    for (;;)
    {
      localView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 4, "updateMemberSpeak");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned)
      {
        a(localView, super.getString(2131369584), true);
        localView.setContentDescription(super.getString(2131369407) + super.getString(2131369584));
      }
      else
      {
        a(localView, super.getString(2131369588), true);
        localView.setContentDescription(super.getString(2131369407) + super.getString(2131369588));
      }
    }
  }
  
  public void g(String paramString)
  {
    b(paramString, null, "dc00899");
  }
  
  public void h()
  {
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131305206);
    if (localLinearLayout.getMeasuredWidth() != 0)
    {
      boolean bool = a(this.jdField_f_of_type_AndroidViewView, this.jdField_a_of_type_JavaUtilList, getResources().getString(2131365069));
      if (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130838357);
        if (bool) {
          d("exp_joingrp", "P_CliOper");
        }
      }
    }
    for (;;)
    {
      if (this.o != 0) {
        break label164;
      }
      this.jdField_f_of_type_AndroidViewView.setContentDescription(getResources().getString(2131365065, new Object[] { getResources().getString(2131365069) }));
      return;
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130838352);
      break;
      localLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new mts(this, localLinearLayout));
    }
    label164:
    this.jdField_f_of_type_AndroidViewView.setContentDescription(getResources().getString(2131365064, new Object[] { getResources().getString(2131365069) }));
  }
  
  protected void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300057));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299502));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_c_of_type_AndroidViewView = ((RelativeLayout)findViewById(2131305175));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_c_of_type_AndroidViewView.findViewById(2131297137));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297392));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131297613));
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i1 = ((Resources)localObject).getDimensionPixelSize(2131492908);
    this.I = (((Resources)localObject).getDimensionPixelSize(2131493177) - i1 - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new mtt(this));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i1 = ImmersiveUtils.a(getApplicationContext());
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130905072, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305188));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131362035));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new mtu(this));
    b(this.v);
    this.h = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305197));
    a(0, getString(2131369953), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].setOnLongClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130838357);
    a(9, getString(2131367713), "", false);
    this.jdField_a_of_type_ArrayOfAndroidViewView[9].setBackgroundResource(2130838355);
    this.jdField_a_of_type_ArrayOfAndroidViewView[9].setVisibility(8);
    a(8, getString(2131369123), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[8].setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ArrayOfAndroidViewView[8].setBackgroundResource(2130838352);
    if (BmqqSegmentUtil.a(null, this.v)) {
      this.jdField_a_of_type_ArrayOfAndroidViewView[8].setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131492937);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    localObject = View.inflate(this, 2130904388, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a(10, getString(2131369967), "", true);
    this.jdField_a_of_type_ArrayOfAndroidViewView[10].setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ArrayOfAndroidViewView[10].setBackgroundResource(2130838357);
    a(1, getString(2131364648), "", true);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130905076, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_f_of_type_AndroidViewView.setVisibility(4);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838352);
      return;
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
    }
  }
  
  public void j()
  {
    Dialog localDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 2131558973);
    localDialog.setContentView(2130903341);
    ((TextView)localDialog.findViewById(2131297840)).setText(getString(2131367359));
    TextView localTextView = (TextView)localDialog.findViewById(2131296852);
    CheckBox localCheckBox = (CheckBox)localDialog.findViewById(2131298193);
    if ((localTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localCheckBox.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)localCheckBox.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localTextView.setText(getString(2131367368));
    localCheckBox.setText(getString(2131367369));
    localTextView = (TextView)localDialog.findViewById(2131297843);
    Object localObject = (TextView)localDialog.findViewById(2131297844);
    localTextView.setText(17039360);
    ((TextView)localObject).setText(17039370);
    localTextView.setOnClickListener(new msp(this, localDialog));
    ((TextView)localObject).setOnClickListener(new msq(this, localCheckBox, localDialog));
    localDialog.show();
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_movegrp", 0, 0, this.t, "", "", "");
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 2)
    {
      localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 230).setTitle(getString(2131367358)).setMessage(getString(2131369413));
      localQQCustomDialog.setPositiveButton(getString(2131367263), new msr(this, localQQCustomDialog));
      localQQCustomDialog.setNegativeButton(getString(2131367262), new mss(this, localQQCustomDialog));
      localQQCustomDialog.show();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 1)
    {
      QQCustomDialog localQQCustomDialog;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((byte)1, this.t, this.v);
    b(2131367372);
    ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "mber_card", "Clk_setadmin", 0, 0, this.t, "", "", "");
  }
  
  public void l()
  {
    hideTitleBar();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    if (this.L == 6)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131365070);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131365070));
      if (this.L != 1) {
        break label211;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131367349));
      label76:
      String str = getIntent().getStringExtra("custom_leftbackbutton_name");
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131371308));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131367975));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new mtb(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mtc(this));
      if (this.jdField_a_of_type_Boolean) {
        break label223;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label211:
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      break label76;
      label223:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    if (this.o == 0)
    {
      this.aj = 2;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131368716));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131368715), 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    this.jdField_e_of_type_Boolean = ((TroopGagMgr)this.app.getManager(47)).a(this.t, this.v);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
      this.aj = 4;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      int i1;
      if ((this.M == 3) || ((this.M == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2)))
      {
        i1 = 1;
        label221:
        if (i1 == 0) {
          break label370;
        }
        if (!this.jdField_e_of_type_Boolean) {
          break label333;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131364685);
        label242:
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
        if (this.M == 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 2) {
            break label346;
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131367358);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131368716));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131368717));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131367360, 3);
        this.aj = 3;
        break;
        i1 = 0;
        break label221;
        label333:
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131364684);
        break label242;
        label346:
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 1) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131367357);
        }
      }
      label370:
      if ((this.M == 3) || (this.M == 2)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131368716));
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369311);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131368717));
      this.aj = 5;
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    this.aj = 6;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("拨打QQ电话", 5);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("拨打电话", 5);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("发送短信", 5);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(getString(2131367262));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    ReportController.b(this.app, "P_CliOper", "Grp_work", "", "function", "exp_phone", 0, 0, this.t, "", "", "");
  }
  
  public void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof TroopMemberCardActivity.ViewHolder))) {
      return false;
    }
    this.N = ((TroopMemberCardActivity.ViewHolder)localObject).jdField_a_of_type_Int;
    paramView.setSelected(true);
    localObject = new QQCustomMenu();
    ((QQCustomMenu)localObject).a(2131305407, getString(2131369291));
    BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_e_of_type_AndroidViewView$OnClickListener, new mth(this, paramView));
    return true;
  }
  
  public void p()
  {
    String str2 = this.w;
    int i1 = 10004;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 0) {
      i1 = 3004;
    }
    for (String str1 = this.u;; str1 = null)
    {
      startActivityForResult(AddFriendLogicActivity.a(this, 1, this.v, str1, i1, 1, str2, null, null, null, null), 3);
      return;
    }
  }
  
  protected void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity = this;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300057));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299502));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131297613));
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
    int i1 = ((Resources)localObject1).getDimensionPixelSize(2131492908);
    this.I = (((Resources)localObject1).getDimensionPixelSize(2131493177) - i1 - (int)(((DisplayMetrics)localObject2).density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.h = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new mtl(this));
    this.jdField_c_of_type_AndroidViewView = ((RelativeLayout)findViewById(2131305175));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_c_of_type_AndroidViewView.findViewById(2131297137));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i1 = ImmersiveUtils.a(getApplicationContext());
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = i1;
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297139));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131297392));
    this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130905069, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    localObject1 = this.jdField_e_of_type_AndroidViewView.findViewById(2131305179);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i1 = ImmersiveUtils.a(getApplicationContext());
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = (i1 + ((RelativeLayout.LayoutParams)localObject2).height);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305188));
    b(this.v);
    ImageView localImageView = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305180);
    localObject2 = this.app.a(this.t, (byte)1, false, false);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ImageUtil.a();
    }
    localObject1 = a((Bitmap)localObject1);
    if (localObject1 != null) {}
    try
    {
      StackBlur.a((Bitmap)localObject1, 6);
      localObject1 = new BitmapDrawable((Bitmap)localObject1);
      if (localImageView != null) {
        localImageView.setBackgroundDrawable((Drawable)localObject1);
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131305181);
      localObject1 = (RelativeLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131305184);
      a(0, getString(2131367933), "", false);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setOnLongClickListener(this);
      a(3, getString(2131367935), "", false);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setOnLongClickListener(this);
      a(4, getString(2131367936), "", false);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4].setOnLongClickListener(this);
      a(5, getString(2131367937), "", false);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5].setOnLongClickListener(this);
      if (this.L == 6) {
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.TroopMemberCardActivity", 2, "fast blur OOM");
        }
      }
      a(1, getString(2131364648), "", true);
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[1].getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = getResources().getDimensionPixelSize(2131492937);
        this.jdField_a_of_type_ArrayOfAndroidViewView[1].setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label937;
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
    for (;;)
    {
      a(2, getString(2131369407), "", true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setBackgroundResource(2130838352);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity).inflate(2130905075, this.jdField_a_of_type_AndroidWidgetLinearLayout, false));
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = ((int)(2.0F * this.jdField_a_of_type_Float));
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131493166);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, getResources().getInteger(2131623939));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369408);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131369408));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
      return;
      label937:
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
    }
  }
  
  protected void r()
  {
    ThreadManager.a(new mtm(this), 8, null, true);
  }
  
  @Deprecated
  public void s()
  {
    int i1 = 3;
    int i2 = 0;
    if (this.L == 6)
    {
      y();
      return;
    }
    Object localObject1 = (TroopManager)this.app.getManager(51);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).a(this.t);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        finish();
        return;
      }
      localObject1 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305186);
      Object localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 2)
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131367351);
        a((TextView)localObject1, 2, 0);
        localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305187);
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305185));
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.w);
        localObject1 = "";
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex != 0) {
          break label672;
        }
        localObject1 = getString(2131368209);
        label161:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label694;
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setVisibility(0);
        label178:
        localObject1 = super.getString(2131369953) + super.getString(2131368675) + this.w + (String)localObject1;
        this.jdField_e_of_type_AndroidViewView.setContentDescription((CharSequence)localObject1);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
        a((View)localObject1, this.v, false);
        ((View)localObject1).setContentDescription(super.getString(2131367933) + this.v);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 0) {
          break label891;
        }
        ((View)localObject1).setBackgroundResource(2130838357);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
        ((View)localObject1).setBackgroundResource(2130838355);
        localObject2 = this.r;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label703;
        }
        ((View)localObject1).setContentDescription(getString(2131367935) + this.r);
        label350:
        a((View)localObject1, (String)localObject2, false);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
        ((View)localObject1).setBackgroundResource(2130838355);
        localObject2 = this.p;
        a((View)localObject1, (String)localObject2, false);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label740;
        }
        a((View)localObject1, false, true, 0, getResources().getColor(2131427568));
        ((View)localObject1).setContentDescription(getString(2131367936) + (String)localObject2);
        label436:
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((View)localObject1).setClickable(true);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
        ((View)localObject1).setBackgroundResource(2130838355);
        localObject2 = this.q;
        a((View)localObject1, (String)localObject2, false);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label804;
        }
        a((View)localObject1, false, true, 0, getResources().getColor(2131427568));
        ((View)localObject1).setContentDescription(getString(2131367937) + (String)localObject2);
        label528:
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((View)localObject1).setClickable(true);
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(0);
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(getString(2131364648));
          this.jdField_a_of_type_ArrayOfAndroidViewView[1].setBackgroundResource(2130838352);
        }
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[2];
        if (this.o == 0) {
          break label868;
        }
        g();
        label606:
        i1 = i2;
        if (this.o == 1) {
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
            break label886;
          }
        }
      }
      label672:
      label694:
      label703:
      label740:
      label804:
      label868:
      label886:
      for (i1 = 3;; i1 = 2)
      {
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole != 3) {
          break;
        }
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131367352);
        a((TextView)localObject1, 3, 0);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex != 1) {
          break label161;
        }
        localObject1 = getString(2131368210);
        break label161;
        ((TextView)localObject2).setVisibility(8);
        break label178;
        ((View)localObject1).setContentDescription(getString(2131367935) + getString(2131365073));
        break label350;
        a((View)localObject1, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
        ((View)localObject1).setContentDescription(getString(2131367936) + getString(2131365073));
        break label436;
        a((View)localObject1, false, true, getResources().getColorStateList(2131428262), getResources().getColorStateList(2131428262));
        ((View)localObject1).setContentDescription(getString(2131367937) + getString(2131365073));
        break label528;
        ((View)localObject1).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label606;
      }
      label891:
      localObject1 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131305182);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131367971);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundResource(2130838352);
      this.jdField_a_of_type_ArrayOfAndroidViewView[3].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5].setVisibility(8);
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[1] != null) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[2].setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.o == 1) {
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {}
      }
      for (;;)
      {
        a(i1, this.jdField_b_of_type_AndroidWidgetLinearLayout);
        return;
        i1 = 1;
        continue;
        i1 = 0;
      }
    }
  }
  
  protected String setLastActivityName()
  {
    return BaseApplicationImpl.getContext().getString(2131365070);
  }
  
  public void t()
  {
    Intent localIntent = new Intent(this, ModifyTroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.t);
    localIntent.putExtra("memberUin", this.v);
    localIntent.putExtra("troopCode", this.u);
    localIntent.putExtra("troopMemberNick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card);
    startActivityForResult(localIntent, 10);
    if (((this.M == 3) || (this.M == 2)) && (!this.v.equals(this.app.a())))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X80058F2", "0X80058F2", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80058EF", "0X80058EF", 0, 0, "", "", "", "");
  }
  
  public void u()
  {
    Object localObject3 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    Object localObject1 = "";
    try
    {
      localObject2 = "&troopcode=" + this.t + "&nick=" + URLEncoder.encode(this.w, "utf-8").replace("+", "%20") + "&sex=" + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.sex + "&troopnick=" + URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card, "utf-8").replace("+", "%20") + "&job=" + URLEncoder.encode(this.r, "utf-8").replace("+", "%20") + "&tel=" + URLEncoder.encode(this.p, "utf-8").replace("+", "%20") + "&email=" + URLEncoder.encode(this.q, "utf-8").replace("+", "%20");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject4;
        StructMsgItemLayout2 localStructMsgItemLayout2;
        StringBuilder localStringBuilder;
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject2 = "mqqapi://card/show_pslcard?card_type=troopmember&src_type=internal&source=sharecard&version=1&troopuin=" + this.u + (String)localObject1 + "&uin=" + this.v;
    localObject4 = "AppCmd://OpenTroopMemberInfo/?troopuin=" + this.u + (String)localObject1 + "&uin=" + this.v;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
    if (TextUtils.getTrimmedLength((CharSequence)localObject1) <= 0)
    {
      localObject1 = this.w;
      localObject3 = ((AbsShareMsg.Builder)localObject3).c(63).a(3).a("推荐了群名片:" + (String)localObject1).a("plugin", "", (String)localObject4, (String)localObject2, (String)localObject2).d(getResources().getString(2131367954)).a();
      localObject4 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject4).d(1);
      ((AbsStructMsgItem)localObject4).b("群名片分享");
      localStructMsgItemLayout2 = new StructMsgItemLayout2();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("帐号: " + this.v);
      localStringBuilder.append("\n来自群: " + this.s);
      localStructMsgItemLayout2.a(new StructMsgItemCover((String)localObject2));
      localStructMsgItemLayout2.a(new StructMsgItemTitle((String)localObject1));
      localStructMsgItemLayout2.a(new StructMsgItemSummary(localStringBuilder.toString()));
      ((AbsShareMsg)localObject3).addItem((AbsStructMsgElement)localObject4);
      ((AbsShareMsg)localObject3).addItem(localStructMsgItemLayout2);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 24);
      ((Bundle)localObject1).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject3).getBytes());
      ((Bundle)localObject1).putBoolean("k_dataline", false);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ForwardBaseOption.a(this, (Intent)localObject2, 21);
      ReportController.b(this.app, "CliOper", "", "", "0X8005B33", "0X8005B33", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void v()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131367929) + this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card);
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card, this.jdField_d_of_type_AndroidWidgetTextView);
        localObject1 = null;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark)) {}
      }
    }
    label491:
    do
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131365074, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark });
      for (;;)
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131365075, new Object[] { this.w });
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if (this.o != 0) {
          break;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131365075, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick });
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.w;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131367929) + (String)localObject1);
        a((String)localObject1, this.jdField_d_of_type_AndroidWidgetTextView);
        break;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
        }
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      Friends localFriends = ((FriendsManager)this.app.getManager(50)).a(this.v);
      Object localObject2 = this.w;
      localObject1 = localObject2;
      if (localFriends != null)
      {
        localObject1 = localObject2;
        if (localFriends.isFriend())
        {
          if (TextUtils.isEmpty(localFriends.remark)) {
            break label491;
          }
          localObject1 = localFriends.remark;
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(super.getString(2131367929) + (String)localObject1);
        a((String)localObject1, this.jdField_d_of_type_AndroidWidgetTextView);
        break;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(localFriends.name)) {
          localObject1 = localFriends.name;
        }
      }
    } while (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void w()
  {
    ThreadManager.a(new mtp(this), 8, null, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopMemberCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */