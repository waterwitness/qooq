package com.tencent.mobileqq.nearby.rn;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import java.net.URLEncoder;

public class NearbyAlumnus
  extends BaseBusi
{
  static final int t = 130;
  
  public NearbyAlumnus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(Context paramContext)
  {
    super.a(paramContext);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (!"profileCard".equals(this.w)) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(130.0F * FontSettingManager.a.density));
      paramContext = new View(paramContext);
      paramContext.setId(2131297474);
      paramContext.setBackgroundColor(this.o);
      paramContext.setLayoutParams(localLayoutParams);
      paramContext.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramContext, 1, localLayoutParams);
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public String a(Intent paramIntent, AppInterface paramAppInterface)
  {
    String str1 = paramIntent.getStringExtra("busi_from");
    if ((!"nearby".equals(str1)) && (!"public".equals(str1)) && (!"profileCard".equals(str1))) {
      str1 = "nearby";
    }
    for (;;)
    {
      String str2 = paramIntent.getStringExtra("busi_extra");
      paramIntent = str2;
      if (!"profileCard".equals(str1))
      {
        if (TextUtils.isEmpty(str2)) {
          break label113;
        }
        paramIntent = str2;
      }
      for (;;)
      {
        paramAppInterface = paramIntent;
        if (paramIntent == null) {
          paramAppInterface = "";
        }
        try
        {
          paramIntent = URLEncoder.encode(paramAppInterface);
          this.v = String.format("%s?nativeFrom=%s&editSchoolName=%s", new Object[] { "http://sqimg.qq.com/qq_product_operations/nearbyschool/index.html", str1, paramIntent });
          return this.v;
          label113:
          paramIntent = (String)NearbySPUtil.a(paramAppInterface.a(), "self_school_name", String.valueOf(""));
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
            paramIntent = paramAppInterface;
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297474);
      if (localView != null) {
        localView.setBackgroundColor(this.o);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, Intent paramIntent, NearbyBaseRRV paramNearbyBaseRRV)
  {
    if ((paramAppInterface == null) || (paramIntent == null) || (paramNearbyBaseRRV == null)) {
      return;
    }
    label163:
    for (;;)
    {
      try
      {
        super.a(paramAppInterface, paramIntent, paramNearbyBaseRRV);
        String str = this.w;
        if (("nearby".equals(str)) || ("public".equals(str)) || ("profileCard".equals(str))) {
          break label163;
        }
        str = "nearby";
        paramNearbyBaseRRV.addLaunchOption("from", str);
        paramIntent = paramIntent.getStringExtra("busi_extra");
        if (("profileCard".equals(str)) || (!TextUtils.isEmpty(paramIntent)))
        {
          paramNearbyBaseRRV.addLaunchOption("schoolName", paramIntent);
          paramAppInterface = paramIntent;
          if (!NearbyUtils.a()) {
            break;
          }
          NearbyUtils.a(jdField_a_of_type_JavaLangString, "checkLaunchOption", new Object[] { str, paramAppInterface });
          return;
        }
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return;
      }
      paramAppInterface = (String)NearbySPUtil.a(paramAppInterface.a(), "self_school_name", String.valueOf(""));
      paramNearbyBaseRRV.addLaunchOption("schoolName", paramAppInterface);
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, AppInterface paramAppInterface, com.facebook.react.bridge.ReadableMap paramReadableMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 27
    //   5: aload_0
    //   6: getfield 31	com/tencent/mobileqq/nearby/rn/NearbyAlumnus:w	Ljava/lang/String;
    //   9: invokevirtual 37	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +150 -> 162
    //   15: aload_3
    //   16: ldc -71
    //   18: invokeinterface 191 2 0
    //   23: istore 5
    //   25: iload 5
    //   27: ifeq +226 -> 253
    //   30: aload_3
    //   31: ldc -71
    //   33: invokeinterface 194 2 0
    //   38: astore_2
    //   39: aload_3
    //   40: ldc -60
    //   42: invokeinterface 191 2 0
    //   47: istore 5
    //   49: iload 5
    //   51: ifeq +207 -> 258
    //   54: aload_3
    //   55: ldc -60
    //   57: invokeinterface 199 2 0
    //   62: istore 5
    //   64: aload_2
    //   65: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +6 -> 74
    //   71: iconst_1
    //   72: istore 5
    //   74: invokestatic 204	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   77: ifeq +37 -> 114
    //   80: getstatic 175	com/tencent/mobileqq/nearby/rn/NearbyAlumnus:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: ldc -50
    //   85: iconst_4
    //   86: anewarray 121	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: ldc -71
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_2
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: ldc -60
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: iload 5
    //   107: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   110: aastore
    //   111: invokestatic 180	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: new 94	android/content/Intent
    //   117: dup
    //   118: invokespecial 212	android/content/Intent:<init>	()V
    //   121: astore_3
    //   122: aload_3
    //   123: ldc -42
    //   125: aload_2
    //   126: invokevirtual 218	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   129: pop
    //   130: aload_3
    //   131: ldc -36
    //   133: iload 5
    //   135: invokevirtual 223	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   138: pop
    //   139: aload_1
    //   140: iconst_m1
    //   141: aload_3
    //   142: invokevirtual 229	com/tencent/mobileqq/app/BaseActivity:setResult	(ILandroid/content/Intent;)V
    //   145: return
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual 230	java/lang/Throwable:printStackTrace	()V
    //   151: goto +102 -> 253
    //   154: astore_3
    //   155: aload_3
    //   156: invokevirtual 230	java/lang/Throwable:printStackTrace	()V
    //   159: goto +99 -> 258
    //   162: aload_3
    //   163: ldc -24
    //   165: invokeinterface 191 2 0
    //   170: istore 5
    //   172: aload 4
    //   174: astore_1
    //   175: iload 5
    //   177: ifeq +12 -> 189
    //   180: aload_3
    //   181: ldc -24
    //   183: invokeinterface 194 2 0
    //   188: astore_1
    //   189: invokestatic 204	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   192: ifeq +24 -> 216
    //   195: getstatic 175	com/tencent/mobileqq/nearby/rn/NearbyAlumnus:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: ldc -50
    //   200: iconst_2
    //   201: anewarray 121	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: ldc -24
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: aload_1
    //   212: aastore
    //   213: invokestatic 180	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_1
    //   217: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +32 -> 252
    //   223: aload_2
    //   224: invokevirtual 135	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   227: ldc -119
    //   229: aload_1
    //   230: invokestatic 235	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   233: pop
    //   234: return
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 149	java/lang/Exception:printStackTrace	()V
    //   240: return
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 230	java/lang/Throwable:printStackTrace	()V
    //   246: aload 4
    //   248: astore_1
    //   249: goto -60 -> 189
    //   252: return
    //   253: aconst_null
    //   254: astore_2
    //   255: goto -216 -> 39
    //   258: iconst_0
    //   259: istore 5
    //   261: goto -197 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	NearbyAlumnus
    //   0	264	1	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	264	2	paramAppInterface	AppInterface
    //   0	264	3	paramReadableMap	com.facebook.react.bridge.ReadableMap
    //   1	246	4	localObject	Object
    //   23	237	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	39	146	java/lang/Throwable
    //   54	64	154	java/lang/Throwable
    //   3	25	235	java/lang/Exception
    //   30	39	235	java/lang/Exception
    //   39	49	235	java/lang/Exception
    //   54	64	235	java/lang/Exception
    //   64	71	235	java/lang/Exception
    //   74	114	235	java/lang/Exception
    //   114	145	235	java/lang/Exception
    //   147	151	235	java/lang/Exception
    //   155	159	235	java/lang/Exception
    //   162	172	235	java/lang/Exception
    //   180	189	235	java/lang/Exception
    //   189	216	235	java/lang/Exception
    //   216	234	235	java/lang/Exception
    //   242	246	235	java/lang/Exception
    //   180	189	241	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyAlumnus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */