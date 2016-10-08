package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MsgUtils
{
  private static float jdField_a_of_type_Float = 0.0F;
  private static final int jdField_a_of_type_Int = 16;
  private static long jdField_a_of_type_Long;
  private static float jdField_b_of_type_Float = 0.0F;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static float c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    int i;
    if (paramMessage == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop, -1L);
      i = j;
    } while (j != -1);
    Object localObject = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).fProgress == 1.0D) {
        return 1;
      }
      return ((FileManagerEntity)localObject).status;
    }
    localObject = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = (TransFileInfo)((EntityManager)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessage.time), String.valueOf(paramMessage.msgseq), paramQQAppInterface.a(), paramMessage.frienduin });
    ((EntityManager)localObject).a();
    if (paramQQAppInterface == null) {
      return 0;
    }
    paramQQAppInterface.status = FileManagerUtil.d(paramQQAppInterface.status);
    if (paramQQAppInterface.status == 2) {
      paramQQAppInterface.status = 0;
    }
    return paramQQAppInterface.status;
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence1, String paramString, CharSequence paramCharSequence2, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    paramDrawable1 = new StringBuffer();
    if (paramCharSequence1 != null) {
      paramDrawable1.append(paramCharSequence1).append(": ");
    }
    for (int j = paramDrawable1.length();; j = 0)
    {
      int i;
      if (paramBoolean1)
      {
        paramDrawable1.append("F ");
        i = paramDrawable1.length();
      }
      for (;;)
      {
        if (paramString != null) {
          paramDrawable1.append(paramString);
        }
        if (paramCharSequence2 != null) {
          paramDrawable1.append(paramCharSequence2);
        }
        paramCharSequence1 = new SpannableStringBuilder(paramDrawable1.toString());
        if (paramBoolean1)
        {
          paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
          paramCharSequence1.setSpan(new ImageSpan(paramDrawable3), j, i, 33);
        }
        while (!paramBoolean2)
        {
          return paramCharSequence1;
          if (!paramBoolean2) {
            break label210;
          }
          paramDrawable1.append("S ");
          i = paramDrawable1.length();
          break;
        }
        paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
        paramCharSequence1.setSpan(new ImageSpan(paramDrawable2), j, i, 33);
        return paramCharSequence1;
        label210:
        i = 0;
      }
    }
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue))) {
      return paramMessage.actMsgContentValue;
    }
    paramContext = paramQQAppInterface.a().a(AppShareIDUtil.a(paramMessage.shareAppID));
    if ((paramContext == null) || (paramContext.messagetail == null) || ("".equals(paramContext.messagetail))) {
      return paramQQAppInterface.a().getString(2131370150);
    }
    return paramQQAppInterface.a().getString(2131370148) + paramContext.messagetail + paramQQAppInterface.a().getString(2131370149);
  }
  
  private static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, QQMessageFacade.Message paramMessage)
  {
    String str1;
    if (SystemMsg.isSystemMessage(paramMessage.msgtype))
    {
      str1 = null;
      switch (paramMessage.msgtype)
      {
      default: 
        paramContext = str1;
        String str2 = TroopSystemMsgUtil.a(paramString);
        str1 = paramString;
        if (str2 != null)
        {
          str1 = paramString;
          if (!"".equals(str2.trim()))
          {
            str1 = paramString;
            if (paramString.indexOf(str2) == 1)
            {
              paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage.senderuin, true);
              if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() <= 0) || (paramQQAppInterface.equals(paramMessage.senderuin))) {
                break label274;
              }
              paramString = new StringBuilder();
              paramString.append(paramQQAppInterface).append(paramContext);
              str1 = paramString.toString();
            }
          }
        }
        break;
      }
    }
    label274:
    label439:
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
                  return str1;
                  paramContext = paramContext.getString(2131368863);
                  break;
                  paramContext = paramContext.getString(2131368864);
                  break;
                  paramContext = paramContext.getString(2131368865);
                  break;
                  paramContext = paramContext.getString(2131368872);
                  break;
                  paramContext = paramContext.getString(2131368873);
                  break;
                  return paramMessage.senderuin + paramContext;
                  str1 = paramString;
                } while (!SystemMsg.isTroopSystemMessage(paramMessage.msgtype));
                if ((paramMessage.msgtype != 64516) && (paramMessage.msgtype != 84) && (paramMessage.msgtype != 35) && (paramMessage.msgtype != 64513) && (paramMessage.msgtype != 87) && (paramMessage.msgtype != 46)) {
                  break label439;
                }
                paramContext = TroopSystemMsgUtil.b(paramString);
                str1 = paramString;
              } while (paramContext == null);
              str1 = paramString;
            } while ("".equals(paramContext.trim()));
            str1 = paramString;
          } while (paramString.indexOf(paramContext) != 1);
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramContext, true);
          str1 = paramString;
        } while (paramQQAppInterface == "");
        str1 = paramString;
      } while (paramQQAppInterface.equals(""));
      return TroopSystemMsgUtil.a(paramString, paramContext, paramQQAppInterface);
      if (paramMessage.msgtype == 64515) {
        break label462;
      }
      str1 = paramString;
    } while (paramMessage.msgtype != 64514);
    label462:
    paramString = TroopSystemMsgUtil.a(paramString, paramQQAppInterface);
    paramMessage = TroopSystemMsgUtil.b(paramString);
    paramContext = paramString;
    if (paramMessage != null)
    {
      paramContext = paramString;
      if (!"".equals(paramMessage.trim()))
      {
        paramContext = paramString;
        if (paramString.indexOf(paramMessage) == 1)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramMessage, true);
          paramContext = paramString;
          if (paramQQAppInterface != "")
          {
            paramContext = paramString;
            if (!paramQQAppInterface.equals("")) {
              paramContext = TroopSystemMsgUtil.a(paramString, paramMessage, paramQQAppInterface);
            }
          }
        }
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramString;
      localObject = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(paramString);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() < 4));
    String str1 = ((Matcher)localObject).group(0);
    String str2 = ((Matcher)localObject).group(1);
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0) {
        i = Integer.parseInt(((Matcher)localObject).group(2));
      }
    }
    j = Integer.parseInt(((Matcher)localObject).group(3));
    int k = Integer.parseInt(((Matcher)localObject).group(4));
    Object localObject = new StringBuffer();
    if (i > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131367330));
    }
    if (j > 0) {
      ((StringBuffer)localObject).append(j).append(paramContext.getString(2131367333));
    }
    ((StringBuffer)localObject).append(k).append(paramContext.getString(2131367334));
    return paramString.replace(str1, ((StringBuffer)localObject).toString());
  }
  
  /* Error */
  public static String a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_1
    //   4: ifnonnull +8 -> 12
    //   7: ldc -91
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: iload 5
    //   14: iconst_1
    //   15: if_icmpeq +11 -> 26
    //   18: iload 5
    //   20: sipush 5000
    //   23: if_icmpne +310 -> 333
    //   26: iconst_1
    //   27: istore 7
    //   29: aload_1
    //   30: arraylength
    //   31: iconst_1
    //   32: if_icmple +284 -> 316
    //   35: aload_1
    //   36: iconst_1
    //   37: aaload
    //   38: invokestatic 298	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore 8
    //   43: iload 8
    //   45: tableswitch	default:+19->64, 13:+114->159
    //   64: aload_2
    //   65: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: ldc_w 316
    //   71: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   74: astore_3
    //   75: iload 5
    //   77: iconst_1
    //   78: if_icmpeq +11 -> 89
    //   81: iload 5
    //   83: sipush 5000
    //   86: if_icmpne +14 -> 100
    //   89: aload_2
    //   90: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   93: ldc_w 320
    //   96: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   99: astore_3
    //   100: iload 9
    //   102: istore 5
    //   104: aload_1
    //   105: arraylength
    //   106: iconst_4
    //   107: if_icmple +11 -> 118
    //   110: aload_1
    //   111: iconst_4
    //   112: aaload
    //   113: invokestatic 298	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore 5
    //   118: aload_3
    //   119: astore_1
    //   120: iload 5
    //   122: iconst_2
    //   123: if_icmpne -113 -> 10
    //   126: aload_3
    //   127: aload_0
    //   128: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: ldc_w 320
    //   134: invokevirtual 203	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   137: aload_0
    //   138: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   141: ldc_w 321
    //   144: invokevirtual 203	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   147: invokevirtual 308	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   150: areturn
    //   151: astore 6
    //   153: iconst_0
    //   154: istore 8
    //   156: goto -113 -> 43
    //   159: aload 4
    //   161: ifnull +113 -> 274
    //   164: aload_0
    //   165: aload 4
    //   167: aload_3
    //   168: iload 7
    //   170: iconst_0
    //   171: invokestatic 324	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   174: astore 4
    //   176: aload_2
    //   177: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   180: ldc_w 316
    //   183: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   186: astore_3
    //   187: iload 5
    //   189: iconst_1
    //   190: if_icmpeq +11 -> 201
    //   193: iload 5
    //   195: sipush 5000
    //   198: if_icmpne +14 -> 212
    //   201: aload_2
    //   202: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   205: ldc_w 320
    //   208: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   211: astore_3
    //   212: aload 4
    //   214: invokevirtual 243	java/lang/String:length	()I
    //   217: bipush 11
    //   219: if_icmple +108 -> 327
    //   222: aload 4
    //   224: iconst_0
    //   225: bipush 10
    //   227: invokevirtual 328	java/lang/String:substring	(II)Ljava/lang/String;
    //   230: astore_2
    //   231: new 205	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   238: aload_2
    //   239: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 330
    //   245: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore_2
    //   252: new 205	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   259: aload_2
    //   260: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_3
    //   264: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_3
    //   271: goto -171 -> 100
    //   274: iload 5
    //   276: iconst_1
    //   277: if_icmpeq +11 -> 288
    //   280: iload 5
    //   282: sipush 5000
    //   285: if_icmpne +17 -> 302
    //   288: aload_2
    //   289: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   292: ldc_w 321
    //   295: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   298: astore_3
    //   299: goto -199 -> 100
    //   302: aload_2
    //   303: invokevirtual 315	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   306: ldc_w 331
    //   309: invokevirtual 319	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   312: astore_3
    //   313: goto -213 -> 100
    //   316: ldc -91
    //   318: areturn
    //   319: astore_1
    //   320: iload 9
    //   322: istore 5
    //   324: goto -206 -> 118
    //   327: aload 4
    //   329: astore_2
    //   330: goto -78 -> 252
    //   333: iconst_2
    //   334: istore 7
    //   336: goto -307 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramQQAppInterface	QQAppInterface
    //   0	339	1	paramArrayOfString	String[]
    //   0	339	2	paramContext	Context
    //   0	339	3	paramString1	String
    //   0	339	4	paramString2	String
    //   0	339	5	paramInt	int
    //   151	1	6	localNumberFormatException	NumberFormatException
    //   27	308	7	i	int
    //   41	114	8	j	int
    //   1	320	9	k	int
    // Exception table:
    //   from	to	target	type
    //   35	43	151	java/lang/NumberFormatException
    //   110	118	319	java/lang/NumberFormatException
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    if (paramString != null) {
      localStringBuilder.append(paramString + ": ");
    }
    localStringBuilder.append("[文件]");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, float paramFloat)
  {
    Object localObject3 = paramString;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label20;
      }
      localObject3 = paramString;
    }
    label20:
    float f1;
    for (;;)
    {
      return (String)localObject3;
      long l1 = 0L;
      if (QLog.isDevelopLevel()) {
        l1 = SystemClock.elapsedRealtime();
      }
      if (jdField_b_of_type_Int == 0) {}
      label796:
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
        localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(((DisplayMetrics)localObject1).density * 14.0F);
        f1 = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
        float f2 = ((DisplayMetrics)localObject1).density;
        f1 -= f2 * 72.0F;
        if (f1 <= 0.0F)
        {
          localObject3 = paramString;
          return paramString;
        }
        c = 0.7F * f1;
        jdField_a_of_type_Float = ((TextPaint)localObject3).measureText("汉");
        jdField_b_of_type_Float = ((TextPaint)localObject3).measureText("AaJjIiMm") / "AaJjIiMm".length();
        if (jdField_a_of_type_Float > 1.0F) {
          jdField_b_of_type_Int = (int)(f1 * 0.8F / jdField_a_of_type_Float);
        }
        if (jdField_b_of_type_Float > 1.0F) {
          jdField_b_of_type_Int = Math.min(jdField_b_of_type_Int, (int)(c / jdField_b_of_type_Float));
        }
        if (jdField_b_of_type_Int <= 0) {
          jdField_b_of_type_Int = 14;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          localException.printStackTrace();
          jdField_b_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder(120);
            localStringBuilder.append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_b_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, localStringBuilder.toString());
          }
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          localError.printStackTrace();
          jdField_b_of_type_Int = 14;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(120);
            ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_b_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
            QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label796;
        }
        localObject2 = new StringBuilder(120);
        ((StringBuilder)localObject2).append("trimName").append(", sMaxWidth = ").append(c).append(", sMinLen = ").append(jdField_b_of_type_Int).append(", sZhW = ").append(jdField_a_of_type_Float).append(", sEnW = ").append(jdField_b_of_type_Float);
        QLog.i("Q.recent", 2, ((StringBuilder)localObject2).toString());
      }
    }
    int k = paramString.length();
    localObject1 = paramString;
    if (k >= jdField_b_of_type_Int)
    {
      localObject1 = paramString;
      if (jdField_b_of_type_Float >= 1.0F)
      {
        if (jdField_a_of_type_Float >= 1.0F) {
          break label798;
        }
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      long l2 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime() - l1 + l2;
      jdField_b_of_type_Long += 1L;
      localObject3 = localObject1;
      if (jdField_b_of_type_Long % 10L != 1L) {
        break;
      }
      QLog.i("Q.recent", 4, "trimName, cost = " + jdField_a_of_type_Long / jdField_b_of_type_Long);
      return (String)localObject1;
      StringBuilder localStringBuilder;
      label798:
      f1 = 0.0F;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        int m = paramString.charAt(i);
        if ((m >= 32) && (m <= 126)) {}
        for (f1 += jdField_b_of_type_Float;; f1 += jdField_a_of_type_Float)
        {
          if (c * paramFloat - f1 <= 1.0F) {
            break label877;
          }
          j += 1;
          i += 1;
          break;
        }
      }
      label877:
      Object localObject2 = paramString;
      if (j < k)
      {
        localObject2 = paramString;
        if (j > 0) {
          localObject2 = paramString.substring(0, j - 1) + "...";
        }
      }
    }
  }
  
  public static String a(String[] paramArrayOfString, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      label11:
      return (String)localObject;
    }
    if (paramArrayOfString.length > 1) {
      for (;;)
      {
        int j;
        try
        {
          i = Integer.parseInt(paramArrayOfString[1]);
          j = k;
          if (paramArrayOfString.length > 3)
          {
            if ("1".equals(paramArrayOfString[3])) {
              j = k;
            }
          }
          else {
            switch (i)
            {
            default: 
              if (j == 0) {
                break label913;
              }
              paramContext = paramContext.getResources().getString(2131363233);
              localObject = paramContext;
              if (TextUtils.isEmpty(paramArrayOfString[0])) {
                break label11;
              }
              return paramContext + " " + paramArrayOfString[0];
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i = 0;
          continue;
          j = 0;
          continue;
          if (paramArrayOfString[0] == null) {
            break label930;
          }
        }
        if (paramContext.getString(2131363324).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131363242);
          }
          return paramContext.getResources().getString(2131363248);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131363233) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131363235) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131363321).equals(paramArrayOfString[0]))
        {
          if (j != 0)
          {
            if (paramBoolean2) {
              return paramContext.getResources().getString(2131363241);
            }
            return paramContext.getResources().getString(2131363239);
          }
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131363247);
          }
          return paramContext.getResources().getString(2131363245);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131363233) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131363235) + " " + paramArrayOfString[0];
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131363241);
          }
          return paramContext.getResources().getString(2131363239);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131363247);
        }
        return paramContext.getResources().getString(2131363245);
        if (j != 0)
        {
          if (paramBoolean2) {
            return paramContext.getResources().getString(2131363241);
          }
          return paramContext.getResources().getString(2131363239);
        }
        if (paramBoolean2) {
          return paramContext.getResources().getString(2131363247);
        }
        return paramContext.getResources().getString(2131363245);
        if (j != 0) {
          return paramContext.getResources().getString(2131363238);
        }
        return paramContext.getResources().getString(2131363244);
        if (j != 0) {
          return paramContext.getResources().getString(2131363233);
        }
        return paramContext.getResources().getString(2131363235);
        if (j != 0) {
          return paramContext.getResources().getString(2131363243);
        }
        return paramContext.getResources().getString(2131363250);
        if (j != 0) {
          return paramContext.getResources().getString(2131363242);
        }
        return paramContext.getResources().getString(2131363248);
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        if (paramContext.getString(2131363324).equals(paramArrayOfString[0]))
        {
          if (j != 0) {
            return paramContext.getResources().getString(2131363242);
          }
          return paramContext.getResources().getString(2131363248);
        }
        if (j != 0) {
          return paramContext.getResources().getString(2131363233) + " " + paramArrayOfString[0];
        }
        return paramContext.getResources().getString(2131363235) + " " + paramArrayOfString[0];
        if (paramArrayOfString[0] == null) {
          break label930;
        }
        return paramContext.getResources().getString(2131363235) + " " + paramArrayOfString[0];
        label913:
        paramContext = paramContext.getResources().getString(2131363235);
      }
    }
    return "";
    label930:
    return "";
  }
  
  /* Error */
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload 5
    //   7: astore 8
    //   9: aload_2
    //   10: invokestatic 470	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   13: ifeq +4080 -> 4093
    //   16: aload 5
    //   18: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +24 -> 45
    //   24: aload 5
    //   26: astore 8
    //   28: aload 5
    //   30: aload_1
    //   31: aload_2
    //   32: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   35: iconst_1
    //   36: invokestatic 472	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   39: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +4051 -> 4093
    //   45: aload_1
    //   46: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   49: aload_2
    //   50: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   53: aload_2
    //   54: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   57: aload_2
    //   58: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   61: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   64: astore 8
    //   66: aload 8
    //   68: instanceof 482
    //   71: ifeq +11 -> 82
    //   74: aload 8
    //   76: checkcast 482	com/tencent/mobileqq/data/ChatMessage
    //   79: invokevirtual 485	com/tencent/mobileqq/data/ChatMessage:parse	()V
    //   82: aload 8
    //   84: ifnull +13 -> 97
    //   87: aload 8
    //   89: invokestatic 488	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo;
    //   92: getfield 492	com/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo:b	Ljava/lang/String;
    //   95: astore 5
    //   97: aload 5
    //   99: astore 8
    //   101: aload 5
    //   103: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +3987 -> 4093
    //   109: aload_2
    //   110: invokestatic 488	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo;
    //   113: getfield 492	com/tencent/biz/anonymous/AnonymousChatHelper$AnonymousExtInfo:b	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: astore 8
    //   122: iload 6
    //   124: ifne +42 -> 166
    //   127: aload_2
    //   128: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   131: ifne +32 -> 163
    //   134: aload 5
    //   136: astore 8
    //   138: aload_2
    //   139: getfield 498	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   142: ifnull +24 -> 166
    //   145: aload 5
    //   147: astore 8
    //   149: aload_2
    //   150: getfield 498	com/tencent/mobileqq/app/message/QQMessageFacade$Message:selfuin	Ljava/lang/String;
    //   153: aload_2
    //   154: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   157: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +6 -> 166
    //   163: aconst_null
    //   164: astore 8
    //   166: aload_2
    //   167: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   170: invokestatic 503	com/tencent/mobileqq/app/message/MsgProxyUtils:j	(I)Z
    //   173: ifeq +6 -> 179
    //   176: aconst_null
    //   177: astore 8
    //   179: aload_2
    //   180: invokestatic 508	com/tencent/mobileqq/troop/utils/TroopBusinessUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnull +10 -> 197
    //   190: aload 5
    //   192: getfield 512	com/tencent/mobileqq/troop/utils/TroopBusinessUtil$TroopBusinessMessage:c	Ljava/lang/String;
    //   195: astore 8
    //   197: aload 8
    //   199: invokestatic 513	com/tencent/mobileqq/utils/MsgUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 8
    //   204: aload_2
    //   205: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   208: sipush 63502
    //   211: if_icmpne +16 -> 227
    //   214: aload 4
    //   216: aload_2
    //   217: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   220: invokestatic 521	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   223: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   226: return
    //   227: aload_2
    //   228: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   231: sipush 63525
    //   234: if_icmpeq +13 -> 247
    //   237: aload_2
    //   238: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   241: sipush 60527
    //   244: if_icmpne +121 -> 365
    //   247: iconst_0
    //   248: istore_3
    //   249: iconst_0
    //   250: istore 10
    //   252: aload_2
    //   253: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   256: iconst_1
    //   257: if_icmpne +73 -> 330
    //   260: aload_1
    //   261: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   264: aload_2
    //   265: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   268: aload_2
    //   269: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   272: aload_2
    //   273: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   276: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   279: astore_0
    //   280: iload 10
    //   282: istore_3
    //   283: aload_0
    //   284: invokestatic 529	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   287: ifeq +21 -> 308
    //   290: aconst_null
    //   291: aconst_null
    //   292: aload_0
    //   293: checkcast 531	com/tencent/mobileqq/data/MessageForStructing
    //   296: invokestatic 534	com/tencent/mobileqq/nearby/NearbyFlowerUtil:a	(Lcom/tencent/mobileqq/data/MessageForStructing;)Ljava/lang/String;
    //   299: iconst_0
    //   300: iconst_0
    //   301: aload 4
    //   303: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   306: iconst_1
    //   307: istore_3
    //   308: aload_0
    //   309: invokestatic 540	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   312: ifeq +18 -> 330
    //   315: aconst_null
    //   316: aconst_null
    //   317: aload_2
    //   318: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   321: iconst_0
    //   322: iconst_0
    //   323: aload 4
    //   325: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   328: iconst_1
    //   329: istore_3
    //   330: iload_3
    //   331: ifne -327 -> 4
    //   334: aload_1
    //   335: aload_2
    //   336: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   339: istore 6
    //   341: aload_1
    //   342: aload_2
    //   343: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   346: istore 7
    //   348: aload 8
    //   350: aconst_null
    //   351: aload_2
    //   352: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   355: iload 6
    //   357: iload 7
    //   359: aload 4
    //   361: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   364: return
    //   365: aload_2
    //   366: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   369: sipush 63536
    //   372: if_icmpne +377 -> 749
    //   375: iconst_0
    //   376: istore 13
    //   378: aload_2
    //   379: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   382: astore 5
    //   384: aload_2
    //   385: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   388: aload_2
    //   389: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   392: invokestatic 548	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   395: ifeq +3695 -> 4090
    //   398: aload_2
    //   399: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   402: astore 5
    //   404: aload_1
    //   405: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   408: aload 5
    //   410: aload_2
    //   411: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   414: aload_2
    //   415: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   418: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   421: checkcast 550	com/tencent/mobileqq/data/MessageForPic
    //   424: astore 9
    //   426: aload_1
    //   427: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   430: aload 5
    //   432: aload_2
    //   433: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   436: invokevirtual 558	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   439: astore_1
    //   440: aload_2
    //   441: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   444: ifeq +183 -> 627
    //   447: aload 9
    //   449: getfield 561	com/tencent/mobileqq/data/MessageForPic:size	J
    //   452: lstore 11
    //   454: lload 11
    //   456: lconst_0
    //   457: lcmp
    //   458: ifgt +152 -> 610
    //   461: aload_1
    //   462: ifnonnull +3622 -> 4084
    //   465: aload 9
    //   467: ifnull +3617 -> 4084
    //   470: iconst_1
    //   471: istore 6
    //   473: iload 6
    //   475: istore 7
    //   477: aload_1
    //   478: instanceof 563
    //   481: ifeq +213 -> 694
    //   484: aload_1
    //   485: checkcast 563	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   488: astore_1
    //   489: aload_1
    //   490: invokevirtual 565	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   493: ldc2_w 566
    //   496: lcmp
    //   497: ifeq +3581 -> 4078
    //   500: iconst_1
    //   501: istore 6
    //   503: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +60 -> 566
    //   509: aload_1
    //   510: getfield 570	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   513: ifnull +173 -> 686
    //   516: aload_1
    //   517: getfield 570	com/tencent/mobileqq/transfile/BaseTransProcessor:a	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   520: getfield 573	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   523: lstore 11
    //   525: ldc_w 575
    //   528: iconst_2
    //   529: new 205	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 577
    //   539: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: lload 11
    //   544: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   547: ldc_w 579
    //   550: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload_1
    //   554: invokevirtual 580	com/tencent/mobileqq/transfile/BaseTransProcessor:a	()Ljava/lang/String;
    //   557: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload_0
    //   567: ldc_w 583
    //   570: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   573: astore_1
    //   574: aload_2
    //   575: invokestatic 586	com/tencent/mobileqq/app/HotChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   578: ifne +10 -> 588
    //   581: aload_2
    //   582: invokestatic 589	com/tencent/mobileqq/app/FlashPicHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   585: ifeq +11 -> 596
    //   588: aload_0
    //   589: ldc_w 590
    //   592: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   595: astore_1
    //   596: aload 8
    //   598: aload_1
    //   599: aconst_null
    //   600: iload 7
    //   602: iload 6
    //   604: aload 4
    //   606: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   609: return
    //   610: aload 9
    //   612: getfield 593	com/tencent/mobileqq/data/MessageForPic:extraflag	I
    //   615: ldc_w 594
    //   618: if_icmpne +3482 -> 4100
    //   621: iconst_1
    //   622: istore 6
    //   624: goto -151 -> 473
    //   627: aload_1
    //   628: ifnull +3456 -> 4084
    //   631: aload_1
    //   632: instanceof 563
    //   635: ifeq +3449 -> 4084
    //   638: aload_1
    //   639: checkcast 563	com/tencent/mobileqq/transfile/BaseTransProcessor
    //   642: invokevirtual 565	com/tencent/mobileqq/transfile/BaseTransProcessor:c	()J
    //   645: lstore 11
    //   647: lload 11
    //   649: l2i
    //   650: istore_3
    //   651: iload_3
    //   652: sipush 1005
    //   655: if_icmpeq +10 -> 665
    //   658: iload_3
    //   659: sipush 1004
    //   662: if_icmpne +3422 -> 4084
    //   665: iconst_1
    //   666: istore 6
    //   668: goto -195 -> 473
    //   671: astore 5
    //   673: aconst_null
    //   674: astore_1
    //   675: aload 5
    //   677: invokevirtual 440	java/lang/Exception:printStackTrace	()V
    //   680: iconst_0
    //   681: istore 7
    //   683: goto -206 -> 477
    //   686: ldc2_w 47
    //   689: lstore 11
    //   691: goto -166 -> 525
    //   694: iload 13
    //   696: istore 6
    //   698: aload_1
    //   699: ifnull -133 -> 566
    //   702: iconst_1
    //   703: istore 13
    //   705: iload 13
    //   707: istore 6
    //   709: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq -146 -> 566
    //   715: ldc_w 575
    //   718: iconst_2
    //   719: new 205	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 596
    //   729: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_1
    //   733: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 582	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: iload 13
    //   744: istore 6
    //   746: goto -180 -> 566
    //   749: aload_2
    //   750: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   753: sipush 63534
    //   756: if_icmpeq +13 -> 769
    //   759: aload_2
    //   760: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   763: sipush 64505
    //   766: if_icmpne +231 -> 997
    //   769: aload_2
    //   770: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   773: astore 5
    //   775: aload_2
    //   776: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   779: aload_2
    //   780: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   783: invokestatic 548	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   786: ifeq +3289 -> 4075
    //   789: aload_2
    //   790: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   793: astore 5
    //   795: aload_0
    //   796: ldc_w 600
    //   799: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   802: astore_0
    //   803: aload_1
    //   804: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   807: aload 5
    //   809: aload_2
    //   810: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   813: aload_2
    //   814: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   817: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   820: astore 9
    //   822: aload 9
    //   824: instanceof 602
    //   827: ifeq +3239 -> 4066
    //   830: aload 9
    //   832: checkcast 602	com/tencent/mobileqq/data/MessageForPtt
    //   835: astore 9
    //   837: aload_2
    //   838: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   841: ifeq +3225 -> 4066
    //   844: aload 9
    //   846: getfield 605	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   849: ldc2_w 47
    //   852: lcmp
    //   853: ifne +49 -> 902
    //   856: iconst_1
    //   857: istore 6
    //   859: iconst_0
    //   860: istore 7
    //   862: ldc_w 607
    //   865: iconst_2
    //   866: anewarray 4	java/lang/Object
    //   869: dup
    //   870: iconst_0
    //   871: iload 6
    //   873: invokestatic 612	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   876: aastore
    //   877: dup
    //   878: iconst_1
    //   879: iload 7
    //   881: invokestatic 612	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   884: aastore
    //   885: invokestatic 617	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   888: aload 8
    //   890: aload_0
    //   891: aconst_null
    //   892: iload 6
    //   894: iload 7
    //   896: aload 4
    //   898: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   901: return
    //   902: aload 9
    //   904: getfield 605	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   907: lconst_0
    //   908: lcmp
    //   909: ifgt +3157 -> 4066
    //   912: aload_1
    //   913: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   916: aload 5
    //   918: aload 9
    //   920: getfield 620	com/tencent/mobileqq/data/MessageForPtt:url	Ljava/lang/String;
    //   923: aload 9
    //   925: getfield 621	com/tencent/mobileqq/data/MessageForPtt:uniseq	J
    //   928: invokevirtual 624	com/tencent/mobileqq/transfile/TransFileController:b	(Ljava/lang/String;Ljava/lang/String;J)I
    //   931: istore_3
    //   932: iload_3
    //   933: sipush 1005
    //   936: if_icmpeq +15 -> 951
    //   939: iload_3
    //   940: sipush 1004
    //   943: if_icmpeq +8 -> 951
    //   946: iload_3
    //   947: iconst_m1
    //   948: if_icmpne +40 -> 988
    //   951: iconst_1
    //   952: istore 6
    //   954: iconst_0
    //   955: istore 7
    //   957: ldc_w 607
    //   960: iconst_2
    //   961: anewarray 4	java/lang/Object
    //   964: dup
    //   965: iconst_0
    //   966: aload 9
    //   968: getfield 605	com/tencent/mobileqq/data/MessageForPtt:fileSize	J
    //   971: invokestatic 629	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   974: aastore
    //   975: dup
    //   976: iconst_1
    //   977: iload_3
    //   978: invokestatic 632	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   981: aastore
    //   982: invokestatic 617	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: goto -123 -> 862
    //   988: iconst_1
    //   989: istore 7
    //   991: iconst_0
    //   992: istore 6
    //   994: goto -37 -> 957
    //   997: aload_2
    //   998: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1001: sipush 62528
    //   1004: if_icmpne +48 -> 1052
    //   1007: aload 4
    //   1009: new 205	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1016: aload_0
    //   1017: ldc_w 633
    //   1020: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   1023: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: ldc_w 635
    //   1029: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_2
    //   1033: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1036: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 635
    //   1042: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1051: return
    //   1052: aload_2
    //   1053: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1056: sipush 63521
    //   1059: if_icmpne +11 -> 1070
    //   1062: aload 4
    //   1064: ldc -91
    //   1066: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1069: return
    //   1070: aload_2
    //   1071: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1074: invokestatic 639	com/tencent/mobileqq/utils/ActionMsgUtil:a	(I)Z
    //   1077: ifeq +28 -> 1105
    //   1080: aload 8
    //   1082: aload_0
    //   1083: aload_1
    //   1084: aload_2
    //   1085: invokestatic 641	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1088: aconst_null
    //   1089: aload_1
    //   1090: aload_2
    //   1091: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1094: aload_1
    //   1095: aload_2
    //   1096: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1099: aload 4
    //   1101: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1104: return
    //   1105: aload_2
    //   1106: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1109: sipush 63519
    //   1112: if_icmpne +94 -> 1206
    //   1115: aload_0
    //   1116: ldc_w 642
    //   1119: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   1122: astore 5
    //   1124: aload_2
    //   1125: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1128: astore_0
    //   1129: aload_2
    //   1130: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1133: aload_2
    //   1134: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1137: invokestatic 548	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   1140: ifeq +8 -> 1148
    //   1143: aload_2
    //   1144: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1147: astore_0
    //   1148: aload_1
    //   1149: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1152: aload_0
    //   1153: aload_2
    //   1154: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1157: aload_2
    //   1158: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1161: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1164: astore 9
    //   1166: aload 5
    //   1168: astore_0
    //   1169: aload 9
    //   1171: instanceof 644
    //   1174: ifeq +12 -> 1186
    //   1177: aload 9
    //   1179: checkcast 644	com/tencent/mobileqq/data/MessageForTroopFile
    //   1182: invokevirtual 647	com/tencent/mobileqq/data/MessageForTroopFile:getSummaryMsg	()Ljava/lang/String;
    //   1185: astore_0
    //   1186: aload 8
    //   1188: aload_0
    //   1189: aconst_null
    //   1190: aload_1
    //   1191: aload_2
    //   1192: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1195: aload_1
    //   1196: aload_2
    //   1197: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1200: aload 4
    //   1202: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1205: return
    //   1206: aload_2
    //   1207: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1210: invokestatic 649	com/tencent/mobileqq/utils/ActionMsgUtil:b	(I)Z
    //   1213: ifeq +35 -> 1248
    //   1216: aload_2
    //   1217: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1220: invokestatic 654	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1223: astore_1
    //   1224: aload_1
    //   1225: ifnull -1221 -> 4
    //   1228: aload 4
    //   1230: aload_1
    //   1231: aload_0
    //   1232: aload_2
    //   1233: getfield 657	com/tencent/mobileqq/app/message/QQMessageFacade$Message:issend	I
    //   1236: invokestatic 658	com/tencent/mobileqq/utils/MsgUtils:b	(I)Z
    //   1239: iload 7
    //   1241: invokestatic 660	com/tencent/mobileqq/utils/MsgUtils:a	([Ljava/lang/String;Landroid/content/Context;ZZ)Ljava/lang/String;
    //   1244: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1247: return
    //   1248: aload_2
    //   1249: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1252: invokestatic 662	com/tencent/mobileqq/utils/ActionMsgUtil:c	(I)Z
    //   1255: ifeq +39 -> 1294
    //   1258: aload_2
    //   1259: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1262: invokestatic 654	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1265: astore 5
    //   1267: aload 5
    //   1269: ifnull -1265 -> 4
    //   1272: aload 4
    //   1274: aload_1
    //   1275: aload 5
    //   1277: aload_0
    //   1278: aload_2
    //   1279: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1282: aload_2
    //   1283: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   1286: iload_3
    //   1287: invokestatic 664	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1290: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   1293: return
    //   1294: aload_2
    //   1295: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1298: invokestatic 666	com/tencent/mobileqq/utils/ActionMsgUtil:d	(I)Z
    //   1301: ifeq +27 -> 1328
    //   1304: aload 8
    //   1306: aload_0
    //   1307: aload_2
    //   1308: invokestatic 671	com/tencent/mobileqq/emosm/EmosmUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   1311: aconst_null
    //   1312: aload_1
    //   1313: aload_2
    //   1314: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1317: aload_1
    //   1318: aload_2
    //   1319: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1322: aload 4
    //   1324: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1327: return
    //   1328: aload_2
    //   1329: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1332: invokestatic 674	com/tencent/mobileqq/utils/ActionMsgUtil:e	(I)Z
    //   1335: ifeq +73 -> 1408
    //   1338: new 676	com/tencent/mobileqq/data/MessageForApollo
    //   1341: dup
    //   1342: invokespecial 677	com/tencent/mobileqq/data/MessageForApollo:<init>	()V
    //   1345: astore_0
    //   1346: aload_0
    //   1347: aload_2
    //   1348: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   1351: putfield 682	com/tencent/mobileqq/data/MessageForApollo:msgData	[B
    //   1354: aload_0
    //   1355: invokevirtual 683	com/tencent/mobileqq/data/MessageForApollo:parse	()V
    //   1358: aload_1
    //   1359: aload_2
    //   1360: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1363: istore 6
    //   1365: aload_1
    //   1366: aload_2
    //   1367: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1370: istore 7
    //   1372: aload 8
    //   1374: new 205	java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   1381: ldc_w 685
    //   1384: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: aload_0
    //   1388: getfield 686	com/tencent/mobileqq/data/MessageForApollo:msg	Ljava/lang/String;
    //   1391: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: aconst_null
    //   1398: iload 6
    //   1400: iload 7
    //   1402: aload 4
    //   1404: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1407: return
    //   1408: aload_2
    //   1409: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1412: sipush 64523
    //   1415: if_icmpeq +13 -> 1428
    //   1418: aload_2
    //   1419: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1422: sipush 64489
    //   1425: if_icmpne +20 -> 1445
    //   1428: aconst_null
    //   1429: aconst_null
    //   1430: aload_2
    //   1431: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1434: invokestatic 521	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   1437: iconst_0
    //   1438: iconst_0
    //   1439: aload 4
    //   1441: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1444: return
    //   1445: aload_2
    //   1446: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1449: sipush 63494
    //   1452: if_icmpeq +13 -> 1465
    //   1455: aload_2
    //   1456: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1459: sipush 63493
    //   1462: if_icmpne +20 -> 1482
    //   1465: aconst_null
    //   1466: aload_2
    //   1467: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1470: invokestatic 521	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   1473: aconst_null
    //   1474: iconst_0
    //   1475: iconst_0
    //   1476: aload 4
    //   1478: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1481: return
    //   1482: aload_2
    //   1483: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1486: sipush 63485
    //   1489: if_icmpne +61 -> 1550
    //   1492: aload_1
    //   1493: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1496: aload_2
    //   1497: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1500: aload_2
    //   1501: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1504: aload_2
    //   1505: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1508: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1511: checkcast 688	com/tencent/mobileqq/data/MessageForQQStory
    //   1514: astore_0
    //   1515: aload_0
    //   1516: invokevirtual 689	com/tencent/mobileqq/data/MessageForQQStory:parse	()V
    //   1519: aload_1
    //   1520: aload_2
    //   1521: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1524: istore 6
    //   1526: aload_1
    //   1527: aload_2
    //   1528: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   1531: istore 7
    //   1533: aload 8
    //   1535: aconst_null
    //   1536: aload_0
    //   1537: invokevirtual 690	com/tencent/mobileqq/data/MessageForQQStory:getSummaryMsg	()Ljava/lang/String;
    //   1540: iload 6
    //   1542: iload 7
    //   1544: aload 4
    //   1546: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1549: return
    //   1550: aload_2
    //   1551: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1554: sipush 63501
    //   1557: if_icmpne +67 -> 1624
    //   1560: aload_2
    //   1561: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1564: invokestatic 521	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   1567: astore_1
    //   1568: aload_1
    //   1569: astore_0
    //   1570: aload_1
    //   1571: ldc_w 692
    //   1574: invokevirtual 695	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1577: ifeq +36 -> 1613
    //   1580: aload_1
    //   1581: ldc_w 697
    //   1584: invokevirtual 234	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1587: istore_3
    //   1588: aload_1
    //   1589: astore_0
    //   1590: iload_3
    //   1591: iconst_m1
    //   1592: if_icmpeq +21 -> 1613
    //   1595: aload_1
    //   1596: astore_0
    //   1597: iload_3
    //   1598: aload_1
    //   1599: invokevirtual 243	java/lang/String:length	()I
    //   1602: if_icmpge +11 -> 1613
    //   1605: aload_1
    //   1606: iload_3
    //   1607: iconst_1
    //   1608: iadd
    //   1609: invokevirtual 699	java/lang/String:substring	(I)Ljava/lang/String;
    //   1612: astore_0
    //   1613: aconst_null
    //   1614: aload_0
    //   1615: aconst_null
    //   1616: iconst_0
    //   1617: iconst_0
    //   1618: aload 4
    //   1620: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1623: return
    //   1624: aload_2
    //   1625: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1628: sipush 63498
    //   1631: if_icmpne +100 -> 1731
    //   1634: aload_1
    //   1635: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1638: aload_2
    //   1639: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1642: aload_2
    //   1643: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1646: aload_2
    //   1647: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1650: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1653: checkcast 701	com/tencent/mobileqq/data/MessageForTroopGift
    //   1656: astore_2
    //   1657: aload_2
    //   1658: invokevirtual 702	com/tencent/mobileqq/data/MessageForTroopGift:parse	()V
    //   1661: aload_2
    //   1662: getfield 703	com/tencent/mobileqq/data/MessageForTroopGift:msg	Ljava/lang/String;
    //   1665: astore_1
    //   1666: aload_1
    //   1667: astore_0
    //   1668: aload_2
    //   1669: invokevirtual 706	com/tencent/mobileqq/data/MessageForTroopGift:isToAll	()Z
    //   1672: ifne +48 -> 1720
    //   1675: aload_1
    //   1676: astore_0
    //   1677: aload_1
    //   1678: ldc_w 692
    //   1681: invokevirtual 695	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1684: ifeq +36 -> 1720
    //   1687: aload_1
    //   1688: ldc_w 697
    //   1691: invokevirtual 234	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1694: istore_3
    //   1695: aload_1
    //   1696: astore_0
    //   1697: iload_3
    //   1698: iconst_m1
    //   1699: if_icmpeq +21 -> 1720
    //   1702: aload_1
    //   1703: astore_0
    //   1704: iload_3
    //   1705: aload_1
    //   1706: invokevirtual 243	java/lang/String:length	()I
    //   1709: if_icmpge +11 -> 1720
    //   1712: aload_1
    //   1713: iload_3
    //   1714: iconst_1
    //   1715: iadd
    //   1716: invokevirtual 699	java/lang/String:substring	(I)Ljava/lang/String;
    //   1719: astore_0
    //   1720: aconst_null
    //   1721: aload_0
    //   1722: aconst_null
    //   1723: iconst_0
    //   1724: iconst_0
    //   1725: aload 4
    //   1727: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1730: return
    //   1731: aload_2
    //   1732: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1735: sipush 63500
    //   1738: if_icmpne +44 -> 1782
    //   1741: aload_1
    //   1742: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1745: aload_2
    //   1746: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1749: aload_2
    //   1750: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1753: aload_2
    //   1754: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1757: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1760: checkcast 708	com/tencent/mobileqq/data/MessageForTroopFee
    //   1763: astore_0
    //   1764: aload_0
    //   1765: invokevirtual 709	com/tencent/mobileqq/data/MessageForTroopFee:parse	()V
    //   1768: aconst_null
    //   1769: aload_0
    //   1770: getfield 710	com/tencent/mobileqq/data/MessageForTroopFee:msg	Ljava/lang/String;
    //   1773: aconst_null
    //   1774: iconst_0
    //   1775: iconst_0
    //   1776: aload 4
    //   1778: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1781: return
    //   1782: aload_2
    //   1783: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1786: sipush 63492
    //   1789: if_icmpne +45 -> 1834
    //   1792: aload_1
    //   1793: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1796: aload_2
    //   1797: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1800: aload_2
    //   1801: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1804: aload_2
    //   1805: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1808: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1811: checkcast 712	com/tencent/mobileqq/data/MessageForTroopTopic
    //   1814: astore_0
    //   1815: aload_0
    //   1816: invokevirtual 713	com/tencent/mobileqq/data/MessageForTroopTopic:parse	()V
    //   1819: aload 8
    //   1821: aload_0
    //   1822: getfield 714	com/tencent/mobileqq/data/MessageForTroopTopic:msg	Ljava/lang/String;
    //   1825: aconst_null
    //   1826: iconst_0
    //   1827: iconst_0
    //   1828: aload 4
    //   1830: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1833: return
    //   1834: aload_2
    //   1835: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1838: sipush 63488
    //   1841: if_icmpne +45 -> 1886
    //   1844: aload_1
    //   1845: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1848: aload_2
    //   1849: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1852: aload_2
    //   1853: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1856: aload_2
    //   1857: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1860: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1863: checkcast 716	com/tencent/mobileqq/data/MessageForTroopReward
    //   1866: astore_0
    //   1867: aload_0
    //   1868: invokevirtual 717	com/tencent/mobileqq/data/MessageForTroopReward:parse	()V
    //   1871: aload 8
    //   1873: aload_0
    //   1874: getfield 718	com/tencent/mobileqq/data/MessageForTroopReward:msg	Ljava/lang/String;
    //   1877: aconst_null
    //   1878: iconst_0
    //   1879: iconst_0
    //   1880: aload 4
    //   1882: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1885: return
    //   1886: aload_2
    //   1887: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1890: iconst_1
    //   1891: if_icmpne +81 -> 1972
    //   1894: aload_2
    //   1895: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1898: sipush 62530
    //   1901: if_icmpne +71 -> 1972
    //   1904: aload_1
    //   1905: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1908: aload_2
    //   1909: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   1912: aload_2
    //   1913: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1916: aload_2
    //   1917: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   1920: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1923: checkcast 720	com/tencent/mobileqq/data/MessageForPubAccount
    //   1926: astore_0
    //   1927: aload_0
    //   1928: invokevirtual 721	com/tencent/mobileqq/data/MessageForPubAccount:parse	()V
    //   1931: aload_1
    //   1932: aload_0
    //   1933: iconst_0
    //   1934: invokestatic 725	com/tencent/mobileqq/data/MessageForPubAccount:getMsgSummary	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)Ljava/lang/String;
    //   1937: astore_2
    //   1938: aload_0
    //   1939: invokevirtual 728	com/tencent/mobileqq/data/MessageForPubAccount:isTextMsg	()Z
    //   1942: ifne +16 -> 1958
    //   1945: aconst_null
    //   1946: astore_0
    //   1947: aload_0
    //   1948: aload_2
    //   1949: aconst_null
    //   1950: iconst_0
    //   1951: iconst_0
    //   1952: aload 4
    //   1954: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   1957: return
    //   1958: aload_1
    //   1959: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1962: ldc_w 729
    //   1965: invokevirtual 203	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   1968: astore_0
    //   1969: goto -22 -> 1947
    //   1972: aload_2
    //   1973: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   1976: sipush 64502
    //   1979: if_icmpne +127 -> 2106
    //   1982: new 731	com/tencent/mobileqq/data/MessageForRichState
    //   1985: dup
    //   1986: invokespecial 732	com/tencent/mobileqq/data/MessageForRichState:<init>	()V
    //   1989: astore_0
    //   1990: aload_0
    //   1991: aload_2
    //   1992: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   1995: putfield 733	com/tencent/mobileqq/data/MessageForRichState:msg	Ljava/lang/String;
    //   1998: aload_0
    //   1999: invokevirtual 734	com/tencent/mobileqq/data/MessageForRichState:parse	()V
    //   2002: new 205	java/lang/StringBuilder
    //   2005: dup
    //   2006: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2009: astore_1
    //   2010: aload_0
    //   2011: getfield 737	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   2014: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2017: ifne +38 -> 2055
    //   2020: aload_1
    //   2021: aload_0
    //   2022: getfield 737	com/tencent/mobileqq/data/MessageForRichState:actionText	Ljava/lang/String;
    //   2025: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: pop
    //   2029: aload_0
    //   2030: getfield 740	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   2033: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2036: ifne +12 -> 2048
    //   2039: aload_1
    //   2040: aload_0
    //   2041: getfield 740	com/tencent/mobileqq/data/MessageForRichState:dataText	Ljava/lang/String;
    //   2044: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2047: pop
    //   2048: aload_1
    //   2049: bipush 32
    //   2051: invokevirtual 743	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2054: pop
    //   2055: aload_0
    //   2056: getfield 747	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   2059: ifnull +26 -> 2085
    //   2062: aload_0
    //   2063: getfield 747	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   2066: invokevirtual 750	org/json/JSONArray:length	()I
    //   2069: ifle +16 -> 2085
    //   2072: aload_1
    //   2073: aload_0
    //   2074: getfield 747	com/tencent/mobileqq/data/MessageForRichState:plainText	Lorg/json/JSONArray;
    //   2077: iconst_0
    //   2078: invokevirtual 753	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2081: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: pop
    //   2085: aload_1
    //   2086: invokevirtual 754	java/lang/StringBuilder:length	()I
    //   2089: ifle -2085 -> 4
    //   2092: aconst_null
    //   2093: aload_1
    //   2094: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2097: aconst_null
    //   2098: iconst_0
    //   2099: iconst_0
    //   2100: aload 4
    //   2102: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2105: return
    //   2106: aload_2
    //   2107: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2110: sipush 64517
    //   2113: if_icmpne +42 -> 2155
    //   2116: aconst_null
    //   2117: aconst_null
    //   2118: new 205	java/lang/StringBuilder
    //   2121: dup
    //   2122: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2125: ldc_w 756
    //   2128: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: aload_2
    //   2132: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2135: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: ldc_w 758
    //   2141: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2147: iconst_0
    //   2148: iconst_0
    //   2149: aload 4
    //   2151: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2154: return
    //   2155: aload_2
    //   2156: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2159: sipush 64518
    //   2162: if_icmpne +42 -> 2204
    //   2165: aconst_null
    //   2166: aconst_null
    //   2167: new 205	java/lang/StringBuilder
    //   2170: dup
    //   2171: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2174: ldc_w 760
    //   2177: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: aload_2
    //   2181: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   2184: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: ldc_w 762
    //   2190: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2196: iconst_0
    //   2197: iconst_0
    //   2198: aload 4
    //   2200: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2203: return
    //   2204: aload_2
    //   2205: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2208: sipush 63517
    //   2211: if_icmpne +16 -> 2227
    //   2214: aload 4
    //   2216: aload_0
    //   2217: ldc_w 763
    //   2220: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2223: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   2226: return
    //   2227: aload_2
    //   2228: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2231: sipush 64510
    //   2234: if_icmpne +16 -> 2250
    //   2237: aload 4
    //   2239: aload_0
    //   2240: ldc_w 764
    //   2243: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2246: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   2249: return
    //   2250: aload_2
    //   2251: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2254: sipush 64509
    //   2257: if_icmpne +16 -> 2273
    //   2260: aload 4
    //   2262: aload_0
    //   2263: ldc_w 765
    //   2266: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2269: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   2272: return
    //   2273: aload_2
    //   2274: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2277: sipush 63531
    //   2280: if_icmpne +56 -> 2336
    //   2283: aload_1
    //   2284: aload_2
    //   2285: invokestatic 768	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   2288: astore 5
    //   2290: aload_1
    //   2291: aload_2
    //   2292: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2295: istore 6
    //   2297: aload_1
    //   2298: aload_2
    //   2299: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   2302: istore 7
    //   2304: aload 8
    //   2306: aload_0
    //   2307: ldc_w 769
    //   2310: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2313: aconst_null
    //   2314: iload 6
    //   2316: iload 7
    //   2318: aload 4
    //   2320: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2323: aload 5
    //   2325: ifnull -2321 -> 4
    //   2328: aload 4
    //   2330: aload 5
    //   2332: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   2335: return
    //   2336: aload_2
    //   2337: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2340: sipush 63514
    //   2343: if_icmpne +537 -> 2880
    //   2346: iconst_0
    //   2347: istore 6
    //   2349: iconst_0
    //   2350: istore 13
    //   2352: aload_1
    //   2353: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2356: aload_2
    //   2357: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2360: aload_2
    //   2361: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2364: aload_2
    //   2365: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2368: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2371: astore 5
    //   2373: aload 5
    //   2375: instanceof 771
    //   2378: ifeq -2374 -> 4
    //   2381: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2384: ifeq +33 -> 2417
    //   2387: ldc_w 412
    //   2390: iconst_2
    //   2391: new 205	java/lang/StringBuilder
    //   2394: dup
    //   2395: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2398: ldc_w 773
    //   2401: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2404: aload_2
    //   2405: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2408: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2411: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2414: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2417: aload 5
    //   2419: checkcast 771	com/tencent/mobileqq/data/MessageForShortVideo
    //   2422: astore 9
    //   2424: aload 9
    //   2426: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2429: sipush 1005
    //   2432: if_icmpeq +13 -> 2445
    //   2435: aload_2
    //   2436: getfield 777	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   2439: ldc_w 594
    //   2442: if_icmpne +22 -> 2464
    //   2445: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2448: ifeq +13 -> 2461
    //   2451: ldc_w 412
    //   2454: iconst_2
    //   2455: ldc_w 779
    //   2458: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2461: iconst_1
    //   2462: istore 6
    //   2464: aload_2
    //   2465: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2468: astore 5
    //   2470: aload_2
    //   2471: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2474: aload_2
    //   2475: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2478: invokestatic 548	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   2481: ifeq +9 -> 2490
    //   2484: aload_2
    //   2485: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   2488: astore 5
    //   2490: aload_1
    //   2491: invokevirtual 553	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   2494: aload 5
    //   2496: aload_2
    //   2497: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2500: invokevirtual 558	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;J)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   2503: astore_1
    //   2504: iload 6
    //   2506: istore 7
    //   2508: aload 9
    //   2510: getfield 782	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   2513: ifnull +103 -> 2616
    //   2516: iload 6
    //   2518: istore 7
    //   2520: ldc -91
    //   2522: aload 9
    //   2524: getfield 782	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   2527: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2530: ifne +86 -> 2616
    //   2533: iload 6
    //   2535: istore 7
    //   2537: aload_2
    //   2538: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2541: ifeq +75 -> 2616
    //   2544: iload 6
    //   2546: istore 7
    //   2548: aload_1
    //   2549: ifnonnull +67 -> 2616
    //   2552: iload 6
    //   2554: istore 7
    //   2556: aload 9
    //   2558: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2561: sipush 1003
    //   2564: if_icmpeq +52 -> 2616
    //   2567: iload 6
    //   2569: istore 7
    //   2571: aload 9
    //   2573: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2576: sipush 1004
    //   2579: if_icmpeq +37 -> 2616
    //   2582: iload 6
    //   2584: istore 7
    //   2586: aload 9
    //   2588: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2591: sipush 2003
    //   2594: if_icmpeq +22 -> 2616
    //   2597: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2600: ifeq +13 -> 2613
    //   2603: ldc_w 412
    //   2606: iconst_2
    //   2607: ldc_w 784
    //   2610: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2613: iconst_1
    //   2614: istore 7
    //   2616: iload 7
    //   2618: istore 6
    //   2620: iload 13
    //   2622: istore 7
    //   2624: aload_2
    //   2625: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   2628: ifeq +81 -> 2709
    //   2631: aload 9
    //   2633: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2636: sipush 1001
    //   2639: if_icmpeq +51 -> 2690
    //   2642: aload 9
    //   2644: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2647: sipush 1002
    //   2650: if_icmpeq +40 -> 2690
    //   2653: aload 9
    //   2655: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2658: sipush 998
    //   2661: if_icmpeq +29 -> 2690
    //   2664: aload 9
    //   2666: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2669: sipush 999
    //   2672: if_icmpeq +18 -> 2690
    //   2675: iload 13
    //   2677: istore 7
    //   2679: aload 9
    //   2681: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2684: sipush 1000
    //   2687: if_icmpne +22 -> 2709
    //   2690: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2693: ifeq +13 -> 2706
    //   2696: ldc_w 412
    //   2699: iconst_2
    //   2700: ldc_w 786
    //   2703: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2706: iconst_1
    //   2707: istore 7
    //   2709: aload 9
    //   2711: getfield 789	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   2714: iconst_2
    //   2715: if_icmpne +141 -> 2856
    //   2718: aload_0
    //   2719: ldc_w 790
    //   2722: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2725: astore_0
    //   2726: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2729: ifeq +101 -> 2830
    //   2732: ldc_w 412
    //   2735: iconst_2
    //   2736: new 205	java/lang/StringBuilder
    //   2739: dup
    //   2740: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2743: ldc_w 792
    //   2746: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: aload 9
    //   2751: getfield 782	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   2754: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2757: ldc_w 794
    //   2760: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2763: aload 9
    //   2765: getfield 776	com/tencent/mobileqq/data/MessageForShortVideo:videoFileStatus	I
    //   2768: invokevirtual 406	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2771: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2774: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2777: aload_1
    //   2778: ifnonnull +89 -> 2867
    //   2781: ldc_w 412
    //   2784: iconst_2
    //   2785: ldc_w 796
    //   2788: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2791: ldc_w 412
    //   2794: iconst_2
    //   2795: new 205	java/lang/StringBuilder
    //   2798: dup
    //   2799: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2802: ldc_w 798
    //   2805: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: iload 6
    //   2810: invokevirtual 801	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2813: ldc_w 803
    //   2816: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: iload 7
    //   2821: invokevirtual 801	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2824: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2827: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2830: aload 8
    //   2832: aload_0
    //   2833: aconst_null
    //   2834: iload 6
    //   2836: iload 7
    //   2838: aload 4
    //   2840: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   2843: return
    //   2844: astore 5
    //   2846: aconst_null
    //   2847: astore_1
    //   2848: aload 5
    //   2850: invokevirtual 440	java/lang/Exception:printStackTrace	()V
    //   2853: goto -233 -> 2620
    //   2856: aload_0
    //   2857: ldc_w 804
    //   2860: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   2863: astore_0
    //   2864: goto -138 -> 2726
    //   2867: ldc_w 412
    //   2870: iconst_2
    //   2871: ldc_w 806
    //   2874: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2877: goto -86 -> 2791
    //   2880: aload_2
    //   2881: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2884: sipush 60534
    //   2887: if_icmpne +40 -> 2927
    //   2890: new 808	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   2893: dup
    //   2894: invokespecial 809	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:<init>	()V
    //   2897: astore_0
    //   2898: aload_0
    //   2899: aload_2
    //   2900: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   2903: putfield 810	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msgData	[B
    //   2906: aload_0
    //   2907: invokevirtual 811	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parse	()V
    //   2910: aload_0
    //   2911: getfield 812	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   2914: ifnull -2910 -> 4
    //   2917: aload 4
    //   2919: aload_0
    //   2920: getfield 812	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:msg	Ljava/lang/String;
    //   2923: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   2926: return
    //   2927: aload_2
    //   2928: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   2931: sipush 63507
    //   2934: if_icmpne +107 -> 3041
    //   2937: aload_1
    //   2938: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   2941: aload_2
    //   2942: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   2945: aload_2
    //   2946: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   2949: aload_2
    //   2950: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   2953: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2956: astore_0
    //   2957: invokestatic 392	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2960: ifeq +30 -> 2990
    //   2963: ldc_w 412
    //   2966: iconst_2
    //   2967: new 205	java/lang/StringBuilder
    //   2970: dup
    //   2971: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   2974: ldc_w 814
    //   2977: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2980: aload_0
    //   2981: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2984: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2987: invokestatic 416	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2990: aload_0
    //   2991: instanceof 816
    //   2994: ifeq -2990 -> 4
    //   2997: aload_0
    //   2998: checkcast 816	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   3001: astore_0
    //   3002: aload_0
    //   3003: aload_2
    //   3004: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   3007: putfield 817	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   3010: aload_0
    //   3011: invokevirtual 818	com/tencent/mobileqq/data/MessageForQQWalletTips:parse	()V
    //   3014: aload_0
    //   3015: aload_1
    //   3016: aload_1
    //   3017: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3020: aconst_null
    //   3021: invokevirtual 822	com/tencent/mobileqq/data/MessageForQQWalletTips:buildQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Landroid/widget/TextView;)V
    //   3024: aload_0
    //   3025: getfield 825	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   3028: ifnull -3024 -> 4
    //   3031: aload 4
    //   3033: aload_0
    //   3034: getfield 825	com/tencent/mobileqq/data/MessageForQQWalletTips:summary	Ljava/lang/String;
    //   3037: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3040: return
    //   3041: aload_2
    //   3042: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3045: sipush 63511
    //   3048: if_icmpne +13 -> 3061
    //   3051: aload 4
    //   3053: aload_2
    //   3054: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3057: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3060: return
    //   3061: aload_2
    //   3062: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3065: sipush 63484
    //   3068: if_icmpne +70 -> 3138
    //   3071: aload_2
    //   3072: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3075: astore_0
    //   3076: aload_2
    //   3077: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3080: aload_2
    //   3081: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3084: invokestatic 548	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(Ljava/lang/String;I)Z
    //   3087: ifeq +8 -> 3095
    //   3090: aload_2
    //   3091: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3094: astore_0
    //   3095: aload_1
    //   3096: invokevirtual 475	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3099: aload_0
    //   3100: aload_2
    //   3101: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3104: aload_2
    //   3105: getfield 39	com/tencent/mobileqq/app/message/QQMessageFacade$Message:uniseq	J
    //   3108: invokevirtual 480	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3111: astore_0
    //   3112: aload_0
    //   3113: instanceof 827
    //   3116: ifeq -3112 -> 4
    //   3119: aload_0
    //   3120: checkcast 827	com/tencent/mobileqq/data/MessageForQQStoryComment
    //   3123: astore_0
    //   3124: aload_0
    //   3125: invokevirtual 828	com/tencent/mobileqq/data/MessageForQQStoryComment:parse	()V
    //   3128: aload 4
    //   3130: aload_0
    //   3131: invokevirtual 829	com/tencent/mobileqq/data/MessageForQQStoryComment:getSummaryMsg	()Ljava/lang/String;
    //   3134: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3137: return
    //   3138: aload_2
    //   3139: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3142: sipush 63489
    //   3145: if_icmpne +51 -> 3196
    //   3148: new 831	com/tencent/mobileqq/data/MessageForVIPDonate
    //   3151: dup
    //   3152: invokespecial 832	com/tencent/mobileqq/data/MessageForVIPDonate:<init>	()V
    //   3155: astore_0
    //   3156: aload_0
    //   3157: aload_2
    //   3158: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   3161: putfield 833	com/tencent/mobileqq/data/MessageForVIPDonate:msgData	[B
    //   3164: aload_0
    //   3165: invokevirtual 834	com/tencent/mobileqq/data/MessageForVIPDonate:parse	()V
    //   3168: aload_0
    //   3169: invokevirtual 835	com/tencent/mobileqq/data/MessageForVIPDonate:getSummaryMsg	()Ljava/lang/String;
    //   3172: astore_0
    //   3173: aload_0
    //   3174: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3177: ifne +10 -> 3187
    //   3180: aload 4
    //   3182: aload_0
    //   3183: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3186: return
    //   3187: aload 4
    //   3189: ldc_w 837
    //   3192: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3195: return
    //   3196: aload_2
    //   3197: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3200: sipush 63496
    //   3203: if_icmpne +29 -> 3232
    //   3206: new 839	com/tencent/mobileqq/data/MessageForApproval
    //   3209: dup
    //   3210: invokespecial 840	com/tencent/mobileqq/data/MessageForApproval:<init>	()V
    //   3213: astore_0
    //   3214: aload_0
    //   3215: aload_2
    //   3216: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   3219: putfield 841	com/tencent/mobileqq/data/MessageForApproval:msgData	[B
    //   3222: aload 4
    //   3224: aload_0
    //   3225: invokevirtual 844	com/tencent/mobileqq/data/MessageForApproval:getFullTitle	()Ljava/lang/String;
    //   3228: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3231: return
    //   3232: aload_2
    //   3233: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3236: sipush 63495
    //   3239: if_icmpne +49 -> 3288
    //   3242: aload_0
    //   3243: ldc_w 845
    //   3246: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3249: astore_1
    //   3250: aload_0
    //   3251: ldc_w 846
    //   3254: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3257: astore_0
    //   3258: aload 4
    //   3260: new 205	java/lang/StringBuilder
    //   3263: dup
    //   3264: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3267: aload_1
    //   3268: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: ldc_w 451
    //   3274: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3277: aload_0
    //   3278: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3284: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3287: return
    //   3288: aload_2
    //   3289: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3292: ifnonnull +11 -> 3303
    //   3295: aload 4
    //   3297: ldc -91
    //   3299: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3302: return
    //   3303: aload_2
    //   3304: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3307: sipush 60533
    //   3310: if_icmpne +13 -> 3323
    //   3313: aload 4
    //   3315: aload_2
    //   3316: invokevirtual 850	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   3319: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3322: return
    //   3323: aload_2
    //   3324: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3327: sipush 63503
    //   3330: if_icmpne +16 -> 3346
    //   3333: aconst_null
    //   3334: ldc_w 852
    //   3337: aconst_null
    //   3338: iconst_0
    //   3339: iconst_0
    //   3340: aload 4
    //   3342: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3345: return
    //   3346: aload_2
    //   3347: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3350: sipush 60526
    //   3353: if_icmpne +33 -> 3386
    //   3356: new 854	com/tencent/mobileqq/data/MessageForDingdongSchedule
    //   3359: dup
    //   3360: invokespecial 855	com/tencent/mobileqq/data/MessageForDingdongSchedule:<init>	()V
    //   3363: astore_0
    //   3364: aload_0
    //   3365: aload_2
    //   3366: getfield 681	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgData	[B
    //   3369: putfield 856	com/tencent/mobileqq/data/MessageForDingdongSchedule:msgData	[B
    //   3372: aload_0
    //   3373: invokevirtual 857	com/tencent/mobileqq/data/MessageForDingdongSchedule:parse	()V
    //   3376: aload 4
    //   3378: aload_0
    //   3379: getfield 858	com/tencent/mobileqq/data/MessageForDingdongSchedule:msg	Ljava/lang/String;
    //   3382: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3385: return
    //   3386: aload_2
    //   3387: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3390: sipush 63487
    //   3393: if_icmpne +16 -> 3409
    //   3396: aload 4
    //   3398: aload_2
    //   3399: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3402: invokestatic 521	com/tencent/mobileqq/data/MessageForGrayTips:getOrginMsg	(Ljava/lang/String;)Ljava/lang/String;
    //   3405: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3408: return
    //   3409: aload_2
    //   3410: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3413: sipush 64501
    //   3416: if_icmpne +107 -> 3523
    //   3419: iconst_0
    //   3420: istore 13
    //   3422: iconst_0
    //   3423: istore 14
    //   3425: iload 13
    //   3427: istore 6
    //   3429: iload 14
    //   3431: istore 7
    //   3433: aload_2
    //   3434: invokevirtual 495	com/tencent/mobileqq/app/message/QQMessageFacade$Message:isSendFromLocal	()Z
    //   3437: ifeq +31 -> 3468
    //   3440: aload_2
    //   3441: getfield 777	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   3444: ldc_w 859
    //   3447: if_icmpne +51 -> 3498
    //   3450: aload_1
    //   3451: invokevirtual 862	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   3454: aload_2
    //   3455: invokevirtual 866	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   3458: ifne +30 -> 3488
    //   3461: iconst_1
    //   3462: istore 6
    //   3464: iload 14
    //   3466: istore 7
    //   3468: aload 8
    //   3470: aload_2
    //   3471: invokevirtual 850	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   3474: invokestatic 869	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3477: aconst_null
    //   3478: iload 6
    //   3480: iload 7
    //   3482: aload 4
    //   3484: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3487: return
    //   3488: iconst_1
    //   3489: istore 7
    //   3491: iload 13
    //   3493: istore 6
    //   3495: goto -27 -> 3468
    //   3498: iconst_0
    //   3499: istore 7
    //   3501: aload_2
    //   3502: getfield 777	com/tencent/mobileqq/app/message/QQMessageFacade$Message:extraflag	I
    //   3505: ldc_w 594
    //   3508: if_icmpne +9 -> 3517
    //   3511: iconst_1
    //   3512: istore 6
    //   3514: goto -46 -> 3468
    //   3517: iconst_0
    //   3518: istore 6
    //   3520: goto -6 -> 3514
    //   3523: aload_1
    //   3524: aload_2
    //   3525: invokestatic 543	com/tencent/mobileqq/utils/MsgUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3528: istore 6
    //   3530: aload_1
    //   3531: aload_2
    //   3532: invokestatic 545	com/tencent/mobileqq/utils/MsgUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Z
    //   3535: istore 7
    //   3537: aload_2
    //   3538: getfield 872	com/tencent/mobileqq/app/message/QQMessageFacade$Message:fileType	I
    //   3541: lookupswitch	default:+51->3592, 1:+179->3720, 2:+250->3791, 8:+250->3791, 65536:+161->3702, 65538:+232->3773
    //   3592: aload_2
    //   3593: invokevirtual 850	com/tencent/mobileqq/app/message/QQMessageFacade$Message:getMessageText	()Ljava/lang/CharSequence;
    //   3596: astore 5
    //   3598: aload_2
    //   3599: getfield 875	com/tencent/mobileqq/app/message/QQMessageFacade$Message:emoRecentMsg	Ljava/lang/CharSequence;
    //   3602: ifnull +319 -> 3921
    //   3605: aload 5
    //   3607: ifnull +314 -> 3921
    //   3610: new 205	java/lang/StringBuilder
    //   3613: dup
    //   3614: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   3617: astore_0
    //   3618: aload 8
    //   3620: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3623: ifne +15 -> 3638
    //   3626: aload_0
    //   3627: aload 8
    //   3629: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: ldc 119
    //   3634: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3637: pop
    //   3638: aload_2
    //   3639: invokestatic 470	com/tencent/biz/anonymous/AnonymousChatHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   3642: ifne +15 -> 3657
    //   3645: iload 6
    //   3647: ifeq +231 -> 3878
    //   3650: aload_0
    //   3651: ldc -128
    //   3653: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3656: pop
    //   3657: aload 5
    //   3659: instanceof 877
    //   3662: ifeq +231 -> 3893
    //   3665: aload 5
    //   3667: checkcast 877	com/tencent/mobileqq/text/QQText
    //   3670: aload_0
    //   3671: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3674: iconst_1
    //   3675: iconst_0
    //   3676: newarray <illegal type>
    //   3678: invokevirtual 880	com/tencent/mobileqq/text/QQText:a	(Ljava/lang/String;Z[I)Lcom/tencent/mobileqq/text/QQText;
    //   3681: astore_0
    //   3682: aload 4
    //   3684: iconst_1
    //   3685: putfield 883	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   3688: aload 8
    //   3690: aload_0
    //   3691: aconst_null
    //   3692: iload 6
    //   3694: iload 7
    //   3696: aload 4
    //   3698: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3701: return
    //   3702: aload 8
    //   3704: ldc -91
    //   3706: aload_2
    //   3707: getfield 516	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msg	Ljava/lang/String;
    //   3710: iload 6
    //   3712: iload 7
    //   3714: aload 4
    //   3716: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3719: return
    //   3720: aload_2
    //   3721: getfield 46	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   3724: sipush 1001
    //   3727: if_icmpne +26 -> 3753
    //   3730: aload_2
    //   3731: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3734: sipush 62535
    //   3737: if_icmpne +16 -> 3753
    //   3740: aload 4
    //   3742: aload_0
    //   3743: ldc_w 884
    //   3746: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3749: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   3752: return
    //   3753: aload 8
    //   3755: aload_0
    //   3756: ldc_w 583
    //   3759: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3762: aconst_null
    //   3763: iload 6
    //   3765: iload 7
    //   3767: aload 4
    //   3769: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3772: return
    //   3773: aload 8
    //   3775: aload_0
    //   3776: ldc_w 583
    //   3779: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3782: aconst_null
    //   3783: iconst_0
    //   3784: iconst_0
    //   3785: aload 4
    //   3787: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3790: return
    //   3791: ldc_w 607
    //   3794: iconst_3
    //   3795: anewarray 4	java/lang/Object
    //   3798: dup
    //   3799: iconst_0
    //   3800: iload_3
    //   3801: invokestatic 632	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3804: aastore
    //   3805: dup
    //   3806: iconst_1
    //   3807: iload 6
    //   3809: invokestatic 612	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3812: aastore
    //   3813: dup
    //   3814: iconst_2
    //   3815: iload 7
    //   3817: invokestatic 612	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3820: aastore
    //   3821: invokestatic 617	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   3824: aload_0
    //   3825: ldc_w 600
    //   3828: invokevirtual 247	android/content/Context:getString	(I)Ljava/lang/String;
    //   3831: astore_0
    //   3832: aload_2
    //   3833: getfield 237	com/tencent/mobileqq/app/message/QQMessageFacade$Message:senderuin	Ljava/lang/String;
    //   3836: aload_1
    //   3837: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3840: invokestatic 889	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3843: ifeq +22 -> 3865
    //   3846: iload_3
    //   3847: ifeq +18 -> 3865
    //   3850: aload 8
    //   3852: aload_0
    //   3853: ldc -91
    //   3855: iload 6
    //   3857: iload 7
    //   3859: aload 4
    //   3861: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3864: return
    //   3865: aload 8
    //   3867: aload_0
    //   3868: ldc -91
    //   3870: iconst_0
    //   3871: iconst_0
    //   3872: aload 4
    //   3874: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3877: return
    //   3878: iload 7
    //   3880: ifeq -223 -> 3657
    //   3883: aload_0
    //   3884: ldc -97
    //   3886: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3889: pop
    //   3890: goto -233 -> 3657
    //   3893: aload_0
    //   3894: aload 5
    //   3896: invokevirtual 892	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3899: pop
    //   3900: new 894	android/text/SpannableString
    //   3903: dup
    //   3904: aload_0
    //   3905: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3908: invokespecial 895	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   3911: astore_0
    //   3912: aload 4
    //   3914: iconst_0
    //   3915: putfield 883	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   3918: goto -230 -> 3688
    //   3921: aload 5
    //   3923: ifnull +114 -> 4037
    //   3926: aload 5
    //   3928: invokeinterface 898 1 0
    //   3933: invokevirtual 230	java/lang/String:trim	()Ljava/lang/String;
    //   3936: astore 5
    //   3938: getstatic 903	com/tencent/mobileqq/app/AppConstants:aq	Ljava/lang/String;
    //   3941: aload_2
    //   3942: getfield 43	com/tencent/mobileqq/app/message/QQMessageFacade$Message:frienduin	Ljava/lang/String;
    //   3945: invokevirtual 906	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3948: ifeq +112 -> 4060
    //   3951: aload 5
    //   3953: ifnull +107 -> 4060
    //   3956: aload 5
    //   3958: invokevirtual 243	java/lang/String:length	()I
    //   3961: ifle +99 -> 4060
    //   3964: aload_0
    //   3965: aload_1
    //   3966: aload 5
    //   3968: aload_2
    //   3969: invokestatic 908	com/tencent/mobileqq/utils/MsgUtils:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;)Ljava/lang/String;
    //   3972: astore_0
    //   3973: aload 8
    //   3975: aconst_null
    //   3976: aload_0
    //   3977: iload 6
    //   3979: aload_1
    //   3980: invokevirtual 862	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   3983: aload_2
    //   3984: invokevirtual 866	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   3987: aload 4
    //   3989: invokestatic 537	com/tencent/mobileqq/utils/MsgUtils:a	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLcom/tencent/mobileqq/activity/recent/MsgSummary;)V
    //   3992: aload_2
    //   3993: getfield 216	com/tencent/mobileqq/app/message/QQMessageFacade$Message:msgtype	I
    //   3996: sipush 64536
    //   3999: if_icmpne +44 -> 4043
    //   4002: aload 4
    //   4004: getfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   4007: ifnull +36 -> 4043
    //   4010: aload 4
    //   4012: new 877	com/tencent/mobileqq/text/QQText
    //   4015: dup
    //   4016: aload 4
    //   4018: getfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   4021: iconst_1
    //   4022: bipush 16
    //   4024: invokespecial 911	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;II)V
    //   4027: putfield 526	com/tencent/mobileqq/activity/recent/MsgSummary:b	Ljava/lang/CharSequence;
    //   4030: aload 4
    //   4032: iconst_1
    //   4033: putfield 883	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   4036: return
    //   4037: aconst_null
    //   4038: astore 5
    //   4040: goto -102 -> 3938
    //   4043: aload 4
    //   4045: iconst_0
    //   4046: putfield 883	com/tencent/mobileqq/activity/recent/MsgSummary:g	I
    //   4049: return
    //   4050: astore 5
    //   4052: goto -1204 -> 2848
    //   4055: astore 5
    //   4057: goto -3382 -> 675
    //   4060: aload 5
    //   4062: astore_0
    //   4063: goto -90 -> 3973
    //   4066: iconst_0
    //   4067: istore 6
    //   4069: iconst_0
    //   4070: istore 7
    //   4072: goto -3210 -> 862
    //   4075: goto -3280 -> 795
    //   4078: iconst_0
    //   4079: istore 6
    //   4081: goto -3578 -> 503
    //   4084: iconst_0
    //   4085: istore 6
    //   4087: goto -3614 -> 473
    //   4090: goto -3686 -> 404
    //   4093: aload 8
    //   4095: astore 5
    //   4097: goto -3979 -> 118
    //   4100: iconst_0
    //   4101: istore 6
    //   4103: goto -3630 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4106	0	paramContext	Context
    //   0	4106	1	paramQQAppInterface	QQAppInterface
    //   0	4106	2	paramMessage	QQMessageFacade.Message
    //   0	4106	3	paramInt	int
    //   0	4106	4	paramMsgSummary	MsgSummary
    //   0	4106	5	paramString	String
    //   0	4106	6	paramBoolean1	boolean
    //   0	4106	7	paramBoolean2	boolean
    //   7	4087	8	localObject1	Object
    //   424	2340	9	localObject2	Object
    //   250	31	10	i	int
    //   452	238	11	l	long
    //   376	3116	13	bool1	boolean
    //   3423	42	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   378	404	671	java/lang/Exception
    //   404	440	671	java/lang/Exception
    //   2464	2470	2844	java/lang/Exception
    //   2470	2490	2844	java/lang/Exception
    //   2490	2504	2844	java/lang/Exception
    //   2508	2516	4050	java/lang/Exception
    //   2520	2533	4050	java/lang/Exception
    //   2537	2544	4050	java/lang/Exception
    //   2556	2567	4050	java/lang/Exception
    //   2571	2582	4050	java/lang/Exception
    //   2586	2613	4050	java/lang/Exception
    //   440	454	4055	java/lang/Exception
    //   610	621	4055	java/lang/Exception
    //   631	647	4055	java/lang/Exception
  }
  
  public static void a(TextView paramTextView, QQAppInterface paramQQAppInterface, String[] paramArrayOfString, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramQQAppInterface, paramArrayOfString, paramContext, paramString1, paramString2, paramInt));
  }
  
  public static void a(TextView paramTextView, String[] paramArrayOfString, Context paramContext, int paramInt)
  {
    if ((paramTextView == null) || (paramArrayOfString == null)) {
      return;
    }
    paramTextView.setText(a(paramArrayOfString, paramContext, b(paramInt), false));
  }
  
  private static void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, boolean paramBoolean1, boolean paramBoolean2, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {
      return;
    }
    paramMsgSummary.a = paramCharSequence1;
    paramMsgSummary.b = paramCharSequence2;
    paramMsgSummary.c = paramCharSequence3;
    if (paramBoolean1)
    {
      paramMsgSummary.f = 2;
      return;
    }
    if (paramBoolean2)
    {
      paramMsgSummary.f = 1;
      return;
    }
    paramMsgSummary.f = 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (1 == paramInt) || (2 == paramInt);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    return a(paramContext, paramQQAppInterface, paramMessage, paramTextView, paramInt, paramDrawable1, paramDrawable2, paramDrawable3, null, null);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, TextView paramTextView, int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, CountDownTimer.CountDownTimerListener paramCountDownTimerListener, CountDownTimer paramCountDownTimer)
  {
    if ((paramTextView == null) || (paramMessage == null)) {
      return true;
    }
    paramTextView.setVisibility(0);
    paramCountDownTimer = paramMessage.nickName;
    if (!paramMessage.isSendFromLocal())
    {
      paramCountDownTimerListener = paramCountDownTimer;
      if (paramMessage.selfuin != null)
      {
        paramCountDownTimerListener = paramCountDownTimer;
        if (!paramMessage.selfuin.equals(paramMessage.senderuin)) {}
      }
    }
    else
    {
      paramCountDownTimerListener = null;
    }
    String str1 = b(paramCountDownTimerListener);
    boolean bool1 = b(paramQQAppInterface, paramMessage);
    boolean bool2 = a(paramQQAppInterface, paramMessage);
    paramContext.getResources();
    paramContext.getString(2131369799);
    paramCountDownTimerListener = paramContext.getString(2131369800);
    if (paramMessage.msgtype == 63525)
    {
      paramContext = StructMsgFactory.a(paramMessage.msgData);
      if (paramContext != null) {
        paramTextView.setText(a(str1, null, paramContext.mMsgBrief, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      }
      return false;
    }
    if (paramMessage.msgtype == 60527)
    {
      paramContext = BitAppMsgFactory.a(paramMessage.msgData);
      if (paramContext != null) {
        paramTextView.setText(a(str1, null, paramContext.mMsgBrief, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      }
      return false;
    }
    String str2;
    if (paramMessage.msgtype == 63536)
    {
      str2 = paramMessage.frienduin;
      bool1 = false;
      bool2 = false;
      paramCountDownTimer = null;
      paramCountDownTimerListener = paramCountDownTimer;
    }
    for (;;)
    {
      long l1;
      try
      {
        MessageForPic localMessageForPic = (MessageForPic)paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        paramCountDownTimerListener = paramCountDownTimer;
        paramQQAppInterface = paramQQAppInterface.a().a(str2, paramMessage.uniseq);
        paramCountDownTimerListener = paramQQAppInterface;
        if ((!paramMessage.isSendFromLocal()) || (paramQQAppInterface != null) || (localMessageForPic == null)) {
          continue;
        }
        paramCountDownTimerListener = paramQQAppInterface;
        l1 = localMessageForPic.size;
        if (l1 > 0L) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = paramCountDownTimerListener;
        continue;
      }
      if (paramQQAppInterface != null) {
        bool2 = true;
      }
      paramTextView.setText(a(str1, paramContext.getString(2131369796), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
      return false;
      if (paramQQAppInterface != null)
      {
        paramCountDownTimerListener = paramQQAppInterface;
        if ((paramQQAppInterface instanceof BaseTransProcessor))
        {
          paramCountDownTimerListener = paramQQAppInterface;
          l1 = ((BaseTransProcessor)paramQQAppInterface).c();
          paramInt = (int)l1;
          if ((paramInt == 1005) || (paramInt == 1004))
          {
            bool1 = true;
            continue;
            if ((paramMessage.msgtype == 63534) || (paramMessage.msgtype == 64505))
            {
              paramCountDownTimerListener = paramMessage.frienduin;
              boolean bool4 = false;
              boolean bool3 = false;
              paramCountDownTimer = paramQQAppInterface.a().a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
              if ((paramCountDownTimer instanceof MessageForPtt))
              {
                paramCountDownTimer = (MessageForPtt)paramCountDownTimer;
                bool1 = bool4;
                bool2 = bool3;
                if (paramMessage.isSendFromLocal())
                {
                  if (paramCountDownTimer.fileSize != -1L) {
                    break label540;
                  }
                  bool1 = true;
                  bool2 = bool3;
                }
              }
              for (;;)
              {
                paramTextView.setText(a(str1, paramContext.getString(2131369798), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                return false;
                label540:
                bool1 = bool4;
                bool2 = bool3;
                if (paramCountDownTimer.fileSize <= 0L)
                {
                  paramInt = paramQQAppInterface.a().b(paramCountDownTimerListener, paramCountDownTimer.url, paramCountDownTimer.uniseq);
                  if ((paramInt == 1005) || (paramInt == 1004) || (paramInt == -1))
                  {
                    bool1 = true;
                    bool2 = bool3;
                  }
                  else
                  {
                    bool2 = true;
                    bool1 = bool4;
                  }
                }
              }
            }
            if (paramMessage.msgtype == 62528)
            {
              paramTextView.setText(BaseApplicationImpl.getContext().getString(2131362874) + "\"" + paramMessage.msg + "\"");
              return false;
            }
            if (paramMessage.msgtype == 63521)
            {
              paramTextView.setText("");
              return false;
            }
            if (ActionMsgUtil.a(paramMessage.msgtype))
            {
              paramTextView.setText(a(str1, a(paramContext, paramQQAppInterface, paramMessage), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == 63519)
            {
              if (paramMessage.isSend()) {}
              for (paramContext = a(null);; paramContext = a(str1))
              {
                paramTextView.setText(paramContext);
                return false;
              }
            }
            if (ActionMsgUtil.b(paramMessage.msgtype))
            {
              paramInt = paramMessage.issend;
              a(paramTextView, TransfileUtile.a(paramMessage.msg), paramContext, paramInt);
              return false;
            }
            if (ActionMsgUtil.c(paramMessage.msgtype))
            {
              a(paramTextView, paramQQAppInterface, TransfileUtile.a(paramMessage.msg), paramContext, paramMessage.frienduin, paramMessage.senderuin, paramInt);
              return false;
            }
            if (ActionMsgUtil.d(paramMessage.msgtype))
            {
              paramTextView.setText(a(str1, paramContext.getString(2131370467), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
              return false;
            }
            if (paramMessage.msgtype == 63519)
            {
              paramTextView.setText("[群文件]");
              return false;
            }
            switch (paramMessage.fileType)
            {
            default: 
              if (paramMessage.msg == null) {
                paramTextView.setText("");
              }
              break;
            case 1: 
            case 0: 
            case 65538: 
            case 2: 
            case 8: 
            case 65536: 
              for (;;)
              {
                return true;
                if (paramMessage.msg == null)
                {
                  paramTextView.setText("");
                }
                else if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == 62535))
                {
                  paramTextView.setText(2131370469);
                }
                else
                {
                  paramTextView.setText(a(str1, paramContext.getString(2131369796), null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                  continue;
                  if (paramMessage.msg == null)
                  {
                    paramTextView.setText("");
                  }
                  else
                  {
                    paramContext = FileManagerUtil.a(paramQQAppInterface, paramMessage);
                    if (paramContext == null)
                    {
                      paramTextView.setText(a(str1, paramCountDownTimerListener, null, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                    }
                    else
                    {
                      paramTextView.setText(paramContext);
                      continue;
                      if (paramMessage.msg == null)
                      {
                        paramTextView.setText("");
                      }
                      else
                      {
                        paramTextView.setText(a(str1, paramContext.getString(2131369796), null, false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                        continue;
                        if (paramMessage.msg == null)
                        {
                          paramTextView.setText("");
                        }
                        else
                        {
                          long l2 = 0L;
                          if (paramMessage.fileSize > 0L)
                          {
                            l1 = paramMessage.fileSize;
                            label1188:
                            if (l1 <= 0L) {
                              break label1323;
                            }
                            new StringBuilder().append(l1).append("\"").toString();
                          }
                          label1323:
                          for (;;)
                          {
                            paramContext = paramContext.getString(2131369798);
                            if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(paramQQAppInterface.a())) || (paramInt == 0)) {
                              break label1326;
                            }
                            paramTextView.setText(a(str1, paramContext, "", bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                            break;
                            l1 = l2;
                            if (paramMessage.pttUrl == null) {
                              break label1188;
                            }
                            l1 = l2;
                            if (paramMessage.pttUrl.toLowerCase().startsWith("http")) {
                              break label1188;
                            }
                            l1 = QQRecorder.a(paramMessage);
                            paramMessage.fileSize = l1;
                            break label1188;
                          }
                          label1326:
                          paramTextView.setText(a(str1, paramContext, "", false, false, paramDrawable1, paramDrawable2, paramDrawable3));
                          continue;
                          paramTextView.setText(a(str1, "", paramMessage.msg, bool1, bool2, paramDrawable1, paramDrawable2, paramDrawable3));
                        }
                      }
                    }
                  }
                }
              }
            }
            paramCountDownTimerListener = paramMessage.getMessageText();
            if ((paramMessage.emoRecentMsg != null) && (paramCountDownTimerListener != null))
            {
              paramContext = new StringBuilder();
              int j = 0;
              paramInt = 0;
              int i = j;
              if (str1 != null)
              {
                i = j;
                if (str1.length() > 0)
                {
                  paramContext.append(str1).append(": ");
                  i = paramContext.length();
                }
              }
              if (bool1)
              {
                paramContext.append("F ");
                paramInt = paramContext.length();
                label1466:
                if (!(paramCountDownTimerListener instanceof QQText)) {
                  break label1574;
                }
                paramContext = ((QQText)paramCountDownTimerListener).a(paramContext.toString(), true, new int[0]);
                label1491:
                if (!bool1) {
                  break label1596;
                }
                paramDrawable3.setBounds(0, 0, paramDrawable3.getIntrinsicWidth() * 2 / 3, paramDrawable3.getIntrinsicHeight() * 2 / 3);
                ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable3), i, paramInt, 33);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                if (!bool2) {
                  break label1466;
                }
                paramContext.append("S ");
                paramInt = paramContext.length();
                break label1466;
                label1574:
                paramContext.append(paramCountDownTimerListener);
                paramContext = new SpannableString(paramContext.toString());
                break label1491;
                label1596:
                if (bool2)
                {
                  paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth() * 2 / 3, paramDrawable2.getIntrinsicHeight() * 2 / 3);
                  ((Spannable)paramContext).setSpan(new ImageSpan(paramDrawable2), i, paramInt, 33);
                }
              }
            }
            if (paramCountDownTimerListener != null)
            {
              paramCountDownTimerListener = paramCountDownTimerListener.toString().trim();
              label1670:
              if ((!String.valueOf(AppConstants.aq).equalsIgnoreCase(paramMessage.frienduin)) || (paramCountDownTimerListener == null) || (paramCountDownTimerListener.length() <= 0)) {
                break label1775;
              }
            }
            label1775:
            for (paramContext = a(paramContext, paramQQAppInterface, paramCountDownTimerListener, paramMessage);; paramContext = paramCountDownTimerListener)
            {
              paramContext = a(str1, null, paramContext, bool1, paramQQAppInterface.a().b(paramMessage), paramDrawable1, paramDrawable2, paramDrawable3);
              if ((paramMessage.msgtype == 64536) && (paramContext != null)) {
                paramContext = new QQText(paramContext, 1, 16);
              }
              for (;;)
              {
                paramTextView.setText(paramContext);
                break;
                paramCountDownTimerListener = null;
                break label1670;
              }
            }
          }
        }
      }
      bool1 = false;
    }
  }
  
  public static boolean a(Context paramContext, MessageForVideo paramMessageForVideo)
  {
    if (paramMessageForVideo == null) {}
    String str;
    do
    {
      return false;
      str = paramMessageForVideo.text;
    } while ((paramMessageForVideo.isSend()) || (!str.contains(paramContext.getString(2131363321))));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    QQMessageFacade.Message localMessage = paramMessage;
    if (MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop))
    {
      localMessage = paramMessage;
      if (paramMessage.senderuin != null)
      {
        if (MsgProxyUtils.c(paramMessage.senderuin)) {
          return false;
        }
        localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
      }
    }
    if (localMessage.msgtype == 63531) {
      return 2 == a(paramQQAppInterface, localMessage);
    }
    if (localMessage.msgtype == 63519)
    {
      paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      if ((paramMessage != null) && (paramMessage.frienduin != null))
      {
        paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.jdField_b_of_type_Int == 1) || (paramQQAppInterface.jdField_b_of_type_Int == 0))) {
          return true;
        }
      }
      return false;
    }
    paramMessage = paramQQAppInterface.a().a(localMessage.frienduin, localMessage.uniseq);
    if (((paramMessage instanceof BuddyTransfileProcessor)) && (localMessage.isSendFromLocal()) && (paramMessage != null) && (((BuddyTransfileProcessor)paramMessage).e() >= 0) && (((BuddyTransfileProcessor)paramMessage).e() != 100)) {
      return true;
    }
    return paramQQAppInterface.a().b(localMessage);
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1.0F);
  }
  
  public static boolean b(int paramInt)
  {
    return 1 == paramInt;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    QQMessageFacade.Message localMessage;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            localMessage = paramMessage;
            if (!MsgProxyUtils.a(paramMessage.frienduin, paramMessage.istroop)) {
              break;
            }
            localMessage = paramMessage;
            if (paramMessage.senderuin == null) {
              break;
            }
          } while (MsgProxyUtils.c(paramMessage.senderuin));
          localMessage = paramQQAppInterface.a().a(paramMessage.senderuin, paramMessage.istroop);
          if (localMessage.msgtype != 63531) {
            break;
          }
        } while (a(paramQQAppInterface, localMessage) != 0);
        return true;
        if (localMessage.fileType == 1)
        {
          int i = paramQQAppInterface.a().b(localMessage.frienduin, null, localMessage.uniseq);
          if ((i != 1005) && (i != 1004)) {
            break;
          }
          return true;
        }
        if (localMessage.msgtype != 63519) {
          break;
        }
        paramMessage = (MessageForTroopFile)paramQQAppInterface.a().a(localMessage.frienduin, localMessage.istroop, localMessage.uniseq);
      } while ((paramMessage == null) || (paramMessage.frienduin == null));
      paramQQAppInterface = TroopFileUtils.a(paramQQAppInterface, paramMessage);
    } while ((paramQQAppInterface == null) || (paramQQAppInterface.jdField_b_of_type_Int != 3));
    return true;
    if ((localMessage.isSendFromLocal()) && (localMessage.extraflag == 32768)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(int paramInt)
  {
    return 2 == paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\MsgUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */