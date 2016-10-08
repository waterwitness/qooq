package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import slj;

public class ForwardQQStoryMsgOption
  extends ForwardStructingMsgOption
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final String a = "ForwardOption.ForwardQQStoryMsgOption";
  public ScrollView a;
  
  public ForwardQQStoryMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString1, String paramString2, Context paramContext)
  {
    try
    {
      paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramString2);
      i = -1;
      k = -1;
      str = "";
      paramContext = "";
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        int i;
        int j;
        try
        {
          int k;
          String str;
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
          if (j != 0) {
            break label230;
          }
          i = 1;
          j = k;
          if (paramString2 != null)
          {
            str = paramString2.a("unionid");
            paramContext = paramString2.a("storyid");
          }
          try
          {
            j = Integer.valueOf(paramString2.a("contentType")).intValue();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_story", "", "share", paramString1, i, j, str, paramContext, "", "");
            if (QLog.isColorLevel())
            {
              QLog.d("ForwardOption.ForwardQQStoryMsgOption", 2, "reportClickEvent: opName=" + paramString1 + ", fromType=" + i + ", result=" + j + ", extra1=" + str + ", extra2=" + paramContext);
              return;
              paramString2 = paramString2;
              if (!QLog.isColorLevel()) {
                break label225;
              }
              QLog.w("Q.qqstory.share", 2, "report exp:", paramString2);
            }
          }
          catch (Exception paramString2)
          {
            paramString2.printStackTrace();
            j = k;
            continue;
          }
          return;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "reportClickEvent exp:", paramString1);
          }
        }
        label225:
        paramString2 = null;
        continue;
        label230:
        if (j == 1) {
          i = 2;
        } else if (j == 3000) {
          i = 3;
        }
      }
    }
  }
  
  /* Error */
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 135	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   4: bipush 19
    //   6: invokevirtual 141	android/view/Window:setSoftInputMode	(I)V
    //   9: aload_0
    //   10: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   13: ifnull +776 -> 789
    //   16: aload_0
    //   17: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   20: ldc -108
    //   22: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   25: istore 14
    //   27: aload_0
    //   28: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   31: ldc -102
    //   33: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   36: istore 16
    //   38: aload_0
    //   39: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   42: ldc -101
    //   44: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   47: istore 17
    //   49: aload_0
    //   50: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   53: ldc -100
    //   55: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   58: istore 18
    //   60: aload_0
    //   61: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   64: ldc -99
    //   66: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   69: istore 19
    //   71: ldc -97
    //   73: invokestatic 164	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   76: istore 20
    //   78: new 166	android/widget/LinearLayout
    //   81: dup
    //   82: aload_0
    //   83: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   86: invokespecial 169	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   89: astore_2
    //   90: aload_2
    //   91: iconst_1
    //   92: invokevirtual 172	android/widget/LinearLayout:setOrientation	(I)V
    //   95: new 174	android/widget/LinearLayout$LayoutParams
    //   98: dup
    //   99: bipush -2
    //   101: bipush -2
    //   103: invokespecial 177	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   106: astore_3
    //   107: aload_3
    //   108: iconst_1
    //   109: putfield 181	android/widget/LinearLayout$LayoutParams:gravity	I
    //   112: new 183	android/widget/RelativeLayout
    //   115: dup
    //   116: aload_0
    //   117: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   120: invokespecial 184	android/widget/RelativeLayout:<init>	(Landroid/content/Context;)V
    //   123: astore 4
    //   125: new 174	android/widget/LinearLayout$LayoutParams
    //   128: dup
    //   129: iload 16
    //   131: iload 17
    //   133: invokespecial 177	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   136: astore 5
    //   138: new 186	com/tencent/image/URLImageView
    //   141: dup
    //   142: aload_0
    //   143: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   146: invokespecial 187	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   149: astore 8
    //   151: aload 8
    //   153: getstatic 193	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   156: invokevirtual 197	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   159: new 199	android/widget/RelativeLayout$LayoutParams
    //   162: dup
    //   163: iconst_m1
    //   164: iconst_m1
    //   165: invokespecial 200	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   168: astore 6
    //   170: new 186	com/tencent/image/URLImageView
    //   173: dup
    //   174: aload_0
    //   175: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   178: invokespecial 187	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   181: astore 7
    //   183: aload 7
    //   185: getstatic 203	android/widget/ImageView$ScaleType:FIT_START	Landroid/widget/ImageView$ScaleType;
    //   188: invokevirtual 197	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   191: new 199	android/widget/RelativeLayout$LayoutParams
    //   194: dup
    //   195: iload 18
    //   197: iload 19
    //   199: invokespecial 200	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   202: astore 10
    //   204: aload 10
    //   206: bipush 9
    //   208: invokevirtual 206	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   211: aload 10
    //   213: bipush 10
    //   215: invokevirtual 206	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   218: aload 10
    //   220: iload 14
    //   222: putfield 209	android/widget/RelativeLayout$LayoutParams:leftMargin	I
    //   225: aload 10
    //   227: aload_0
    //   228: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   231: ldc -46
    //   233: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   236: putfield 213	android/widget/RelativeLayout$LayoutParams:topMargin	I
    //   239: new 215	android/widget/TextView
    //   242: dup
    //   243: aload_0
    //   244: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   247: invokespecial 216	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   250: astore 9
    //   252: new 199	android/widget/RelativeLayout$LayoutParams
    //   255: dup
    //   256: iconst_m1
    //   257: aload_0
    //   258: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   261: ldc -39
    //   263: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   266: invokespecial 200	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   269: astore 11
    //   271: aload 11
    //   273: bipush 12
    //   275: invokevirtual 206	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   278: aload 9
    //   280: ldc -37
    //   282: invokestatic 164	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   285: invokevirtual 222	android/widget/TextView:setTextColor	(I)V
    //   288: aload 9
    //   290: iconst_2
    //   291: invokevirtual 225	android/widget/TextView:setMaxLines	(I)V
    //   294: aload 9
    //   296: getstatic 231	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   299: invokevirtual 235	android/widget/TextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   302: aload 9
    //   304: iconst_1
    //   305: ldc -46
    //   307: invokevirtual 239	android/widget/TextView:setTextSize	(IF)V
    //   310: aload 9
    //   312: iload 14
    //   314: iconst_0
    //   315: iload 14
    //   317: iconst_0
    //   318: invokevirtual 243	android/widget/TextView:setPadding	(IIII)V
    //   321: aload 9
    //   323: bipush 16
    //   325: invokevirtual 246	android/widget/TextView:setGravity	(I)V
    //   328: aload 9
    //   330: fconst_1
    //   331: fconst_1
    //   332: fconst_1
    //   333: ldc -8
    //   335: invokestatic 164	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   338: invokevirtual 252	android/widget/TextView:setShadowLayer	(FFFI)V
    //   341: new 215	android/widget/TextView
    //   344: dup
    //   345: aload_0
    //   346: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   349: invokespecial 216	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   352: astore 12
    //   354: aload 12
    //   356: ldc -3
    //   358: invokevirtual 222	android/widget/TextView:setTextColor	(I)V
    //   361: aload 12
    //   363: iconst_1
    //   364: ldc -108
    //   366: invokevirtual 239	android/widget/TextView:setTextSize	(IF)V
    //   369: new 174	android/widget/LinearLayout$LayoutParams
    //   372: dup
    //   373: bipush -2
    //   375: bipush -2
    //   377: invokespecial 177	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   380: astore 13
    //   382: aload 13
    //   384: aload_0
    //   385: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   388: ldc -2
    //   390: invokestatic 153	com/tencent/mobileqq/util/DisplayUtil:a	(Landroid/content/Context;F)I
    //   393: putfield 255	android/widget/LinearLayout$LayoutParams:topMargin	I
    //   396: aload 13
    //   398: iconst_3
    //   399: putfield 181	android/widget/LinearLayout$LayoutParams:gravity	I
    //   402: aload 4
    //   404: aload 8
    //   406: aload 6
    //   408: invokevirtual 259	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   411: aload 4
    //   413: aload 7
    //   415: aload 10
    //   417: invokevirtual 259	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   420: aload 4
    //   422: aload 9
    //   424: aload 11
    //   426: invokevirtual 259	android/widget/RelativeLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   429: aload_2
    //   430: aload 4
    //   432: aload 5
    //   434: invokevirtual 260	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   437: aload_2
    //   438: aload 12
    //   440: aload 13
    //   442: invokevirtual 260	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   445: aload_1
    //   446: aload_2
    //   447: aload_3
    //   448: invokevirtual 263	com/tencent/mobileqq/utils/QQCustomDialog:addView	(Landroid/view/View;Landroid/widget/LinearLayout$LayoutParams;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   451: pop
    //   452: aload 9
    //   454: aload_0
    //   455: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   458: getfield 268	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgBrief	Ljava/lang/String;
    //   461: invokevirtual 272	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   464: aload 12
    //   466: aload_0
    //   467: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   470: getfield 275	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   473: invokevirtual 272	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   476: ldc 35
    //   478: astore_3
    //   479: iconst_0
    //   480: istore 15
    //   482: aload_3
    //   483: astore_2
    //   484: new 277	org/json/JSONObject
    //   487: dup
    //   488: aload_0
    //   489: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   492: getfield 280	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   495: invokespecial 283	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   498: astore 5
    //   500: aload_3
    //   501: astore_2
    //   502: aload 5
    //   504: ldc_w 285
    //   507: invokevirtual 288	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: astore_3
    //   511: aload_3
    //   512: astore_2
    //   513: aload 5
    //   515: ldc_w 290
    //   518: invokevirtual 288	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   521: astore 4
    //   523: aload 4
    //   525: astore_2
    //   526: aload 5
    //   528: ldc_w 292
    //   531: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   534: istore 14
    //   536: aload_3
    //   537: astore 5
    //   539: aload_2
    //   540: astore 4
    //   542: aload 9
    //   544: iload 14
    //   546: ldc_w 296
    //   549: iand
    //   550: ldc_w 297
    //   553: ior
    //   554: invokevirtual 300	android/widget/TextView:setBackgroundColor	(I)V
    //   557: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +35 -> 595
    //   563: ldc 117
    //   565: iconst_2
    //   566: new 87	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 302
    //   576: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_0
    //   580: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   583: getfield 280	com/tencent/mobileqq/structmsg/AbsShareMsg:mQQStoryExtra	Ljava/lang/String;
    //   586: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: new 304	android/graphics/drawable/ColorDrawable
    //   598: dup
    //   599: iload 20
    //   601: invokespecial 306	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   604: astore_2
    //   605: aload 8
    //   607: aload_2
    //   608: invokevirtual 310	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   611: invokestatic 316	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   614: astore_3
    //   615: aload_3
    //   616: aload_2
    //   617: putfield 320	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   620: aload_3
    //   621: aload_2
    //   622: putfield 323	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   625: aload_3
    //   626: iload 16
    //   628: putfield 326	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   631: aload_3
    //   632: iload 17
    //   634: putfield 329	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   637: aload 5
    //   639: aload_3
    //   640: invokestatic 335	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   643: astore_2
    //   644: aload_2
    //   645: invokevirtual 338	com/tencent/image/URLDrawable:getStatus	()I
    //   648: iconst_2
    //   649: if_icmpne +7 -> 656
    //   652: aload_2
    //   653: invokevirtual 341	com/tencent/image/URLDrawable:restartDownload	()V
    //   656: aload 8
    //   658: aload_2
    //   659: invokevirtual 310	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   662: new 304	android/graphics/drawable/ColorDrawable
    //   665: dup
    //   666: ldc_w 343
    //   669: invokestatic 164	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   672: invokespecial 306	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   675: astore_2
    //   676: aload 7
    //   678: aload_2
    //   679: invokevirtual 310	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   682: invokestatic 316	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   685: astore_3
    //   686: aload_3
    //   687: aload_2
    //   688: putfield 320	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   691: aload_3
    //   692: aload_2
    //   693: putfield 323	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   696: aload_3
    //   697: iload 18
    //   699: putfield 326	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   702: aload_3
    //   703: iload 19
    //   705: putfield 329	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   708: aload 4
    //   710: aload_3
    //   711: invokestatic 335	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   714: astore_2
    //   715: aload_2
    //   716: invokevirtual 338	com/tencent/image/URLDrawable:getStatus	()I
    //   719: iconst_2
    //   720: if_icmpne +7 -> 727
    //   723: aload_2
    //   724: invokevirtual 341	com/tencent/image/URLDrawable:restartDownload	()V
    //   727: aload 7
    //   729: aload_2
    //   730: invokevirtual 310	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   733: aload_0
    //   734: aload_1
    //   735: invokevirtual 135	com/tencent/mobileqq/utils/QQCustomDialog:getWindow	()Landroid/view/Window;
    //   738: invokevirtual 347	android/view/Window:getDecorView	()Landroid/view/View;
    //   741: ldc_w 348
    //   744: invokevirtual 354	android/view/View:findViewById	(I)Landroid/view/View;
    //   747: checkcast 356	android/widget/ScrollView
    //   750: putfield 358	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   753: aload_0
    //   754: getfield 358	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   757: ifnull +14 -> 771
    //   760: aload_0
    //   761: getfield 358	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidWidgetScrollView	Landroid/widget/ScrollView;
    //   764: invokevirtual 362	android/widget/ScrollView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   767: aload_0
    //   768: invokevirtual 368	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   771: aload_0
    //   772: ldc_w 370
    //   775: aload_0
    //   776: getfield 144	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg	Lcom/tencent/mobileqq/structmsg/AbsShareMsg;
    //   779: getfield 373	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   782: aload_0
    //   783: getfield 147	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   786: invokevirtual 375	com/tencent/mobileqq/forward/ForwardQQStoryMsgOption:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   789: iconst_1
    //   790: ireturn
    //   791: astore 6
    //   793: ldc 35
    //   795: astore 4
    //   797: aload_2
    //   798: astore_3
    //   799: aload 4
    //   801: astore_2
    //   802: iload 15
    //   804: istore 14
    //   806: aload_2
    //   807: astore 4
    //   809: aload_3
    //   810: astore 5
    //   812: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq -273 -> 542
    //   818: ldc 117
    //   820: iconst_2
    //   821: ldc_w 302
    //   824: aload 6
    //   826: invokestatic 123	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: iload 15
    //   831: istore 14
    //   833: aload_2
    //   834: astore 4
    //   836: aload_3
    //   837: astore 5
    //   839: goto -297 -> 542
    //   842: astore_2
    //   843: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq -184 -> 662
    //   849: ldc 117
    //   851: iconst_2
    //   852: ldc_w 302
    //   855: aload_2
    //   856: invokestatic 123	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   859: goto -197 -> 662
    //   862: astore_2
    //   863: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   866: ifeq -133 -> 733
    //   869: ldc 117
    //   871: iconst_2
    //   872: ldc_w 302
    //   875: aload_2
    //   876: invokestatic 123	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   879: goto -146 -> 733
    //   882: astore_1
    //   883: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   886: ifeq -115 -> 771
    //   889: ldc 117
    //   891: iconst_2
    //   892: new 87	java/lang/StringBuilder
    //   895: dup
    //   896: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   899: ldc_w 302
    //   902: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: aload_1
    //   906: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   909: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   918: goto -147 -> 771
    //   921: astore 6
    //   923: goto -121 -> 802
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	926	0	this	ForwardQQStoryMsgOption
    //   0	926	1	paramQQCustomDialog	QQCustomDialog
    //   89	745	2	localObject1	Object
    //   842	14	2	localException1	Exception
    //   862	14	2	localException2	Exception
    //   106	731	3	localObject2	Object
    //   123	712	4	localObject3	Object
    //   136	702	5	localObject4	Object
    //   168	239	6	localLayoutParams1	android.widget.RelativeLayout.LayoutParams
    //   791	34	6	localException3	Exception
    //   921	1	6	localException4	Exception
    //   181	547	7	localURLImageView1	com.tencent.image.URLImageView
    //   149	508	8	localURLImageView2	com.tencent.image.URLImageView
    //   250	293	9	localTextView1	android.widget.TextView
    //   202	214	10	localLayoutParams2	android.widget.RelativeLayout.LayoutParams
    //   269	156	11	localLayoutParams3	android.widget.RelativeLayout.LayoutParams
    //   352	113	12	localTextView2	android.widget.TextView
    //   380	61	13	localLayoutParams	android.widget.LinearLayout.LayoutParams
    //   25	807	14	i	int
    //   480	350	15	j	int
    //   36	591	16	k	int
    //   47	586	17	m	int
    //   58	640	18	n	int
    //   69	635	19	i1	int
    //   76	524	20	i2	int
    // Exception table:
    //   from	to	target	type
    //   484	500	791	java/lang/Exception
    //   502	511	791	java/lang/Exception
    //   513	523	791	java/lang/Exception
    //   595	656	842	java/lang/Exception
    //   656	662	842	java/lang/Exception
    //   662	727	862	java/lang/Exception
    //   727	733	862	java/lang/Exception
    //   733	771	882	java/lang/Exception
    //   526	536	921	java/lang/Exception
  }
  
  protected void k()
  {
    int i = c();
    String str = "";
    if (i != 0) {
      str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getInputValue();
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", str);
    u();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("clk_send", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    super.k();
  }
  
  protected void l()
  {
    super.l();
    u();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      a("cancel", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgAction, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "forwardOnCancel");
    }
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
      this.jdField_a_of_type_AndroidWidgetScrollView.post(new slj(this));
    }
  }
  
  protected void u()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "removeLayoutListener:", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardQQStoryMsgOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */